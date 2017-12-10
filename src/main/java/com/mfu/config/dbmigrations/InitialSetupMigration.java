package com.mfu.config.dbmigrations;

import com.mfu.domain.Authority;
import com.mfu.domain.OAuth2AuthenticationClientDetails;
import com.mfu.domain.User;
import com.mfu.security.AuthoritiesConstants;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;

/**
 * Creates the initial database setup
 */
@ChangeLog(order = "001")
public class InitialSetupMigration {

    @ChangeSet(order = "01", author = "initiator", id = "01-addAuthorities")
    public void addAuthorities(MongoTemplate mongoTemplate) {
        Authority adminAuthority = new Authority();
        adminAuthority.setName(AuthoritiesConstants.ADMIN);
        Authority userAuthority = new Authority();
        userAuthority.setName(AuthoritiesConstants.USER);
        mongoTemplate.save(adminAuthority);
        mongoTemplate.save(userAuthority);
    }

    @ChangeSet(order = "02", author = "initiator", id = "02-addUsers")
    public void addUsers(MongoTemplate mongoTemplate) {
        Authority adminAuthority = new Authority();
        adminAuthority.setName(AuthoritiesConstants.ADMIN);
        Authority userAuthority = new Authority();
        userAuthority.setName(AuthoritiesConstants.USER);

        User systemUser = new User();
        systemUser.setId("user-0");
        systemUser.setLogin("system");
        systemUser.setPassword("$2a$10$mE.qmcV0mFU5NcKh73TZx.z4ueI/.bDWbj0T1BYyqP481kGGarKLG");
        systemUser.setFirstName("");
        systemUser.setLastName("System");
        systemUser.setEmail("system@localhost");
        systemUser.setActivated(true);
        systemUser.setLangKey("en");
        systemUser.setCreatedBy(systemUser.getLogin());
        systemUser.setCreatedDate(Instant.now());
        systemUser.getAuthorities().add(adminAuthority);
        systemUser.getAuthorities().add(userAuthority);
        mongoTemplate.save(systemUser);

        User anonymousUser = new User();
        anonymousUser.setId("user-1");
        anonymousUser.setLogin("anonymoususer");
        anonymousUser.setPassword("$2a$10$j8S5d7Sr7.8VTOYNviDPOeWX8KcYILUVJBsYV83Y5NtECayypx9lO");
        anonymousUser.setFirstName("Anonymous");
        anonymousUser.setLastName("User");
        anonymousUser.setEmail("anonymous@localhost");
        anonymousUser.setActivated(true);
        anonymousUser.setLangKey("en");
        anonymousUser.setCreatedBy(systemUser.getLogin());
        anonymousUser.setCreatedDate(Instant.now());
        mongoTemplate.save(anonymousUser);

        User adminUser = new User();
        adminUser.setId("user-2");
        adminUser.setLogin("admin");
        adminUser.setPassword("$2a$10$gSAhZrxMllrbgj/kkK9UceBPpChGWJA7SYIb1Mqo.n5aNLq1/oRrC");
        adminUser.setFirstName("admin");
        adminUser.setLastName("Administrator");
        adminUser.setEmail("admin@localhost");
        adminUser.setActivated(true);
        adminUser.setLangKey("en");
        adminUser.setCreatedBy(systemUser.getLogin());
        adminUser.setCreatedDate(Instant.now());
        adminUser.getAuthorities().add(adminAuthority);
        adminUser.getAuthorities().add(userAuthority);
        mongoTemplate.save(adminUser);

        User userUser = new User();
        userUser.setId("user-3");
        userUser.setLogin("user");
        userUser.setPassword("$2a$10$VEjxo0jq2YG9Rbk2HmX9S.k1uZBGYUHdUcid3g/vfiEl7lwWgOH/K");
        userUser.setFirstName("");
        userUser.setLastName("User");
        userUser.setEmail("user@localhost");
        userUser.setActivated(true);
        userUser.setLangKey("en");
        userUser.setCreatedBy(systemUser.getLogin());
        userUser.setCreatedDate(Instant.now());
        userUser.getAuthorities().add(userAuthority);
        mongoTemplate.save(userUser);
    }

    @ChangeSet(order = "03", author = "initiator", id = "03-addOAuthClientDetails")
    public void addOAuthClientDetails(MongoTemplate mongoTemplate) {
        SimpleGrantedAuthority adminAuthority = new SimpleGrantedAuthority(AuthoritiesConstants.ADMIN);
        SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority(AuthoritiesConstants.USER);

        OAuth2AuthenticationClientDetails appDetails = new OAuth2AuthenticationClientDetails();
        appDetails.setClientId("mfuapp");
        appDetails.setClientSecret("my-secret-token-to-change-in-production");
        appDetails.setResourceIds(Collections.singletonList("res_mfu"));
        appDetails.setScope(Arrays.asList("read", "write"));
        appDetails.setAuthorizedGrantTypes(Arrays.asList("password", "refresh_token", "authorization_code", "implicit"));
        appDetails.setAuthorities(Arrays.asList(adminAuthority, userAuthority));
        appDetails.setAccessTokenValiditySeconds(1800);
        appDetails.setRefreshTokenValiditySeconds(2000);
        mongoTemplate.save(appDetails);

        OAuth2AuthenticationClientDetails swaggerUIDetails = new OAuth2AuthenticationClientDetails();
        swaggerUIDetails.setClientId("your-client-id");
        swaggerUIDetails.setClientSecret("your-client-secret-if-required");
        swaggerUIDetails.setResourceIds(Collections.singletonList("res_mfu"));
        swaggerUIDetails.setScope(Collections.singletonList("access"));
        swaggerUIDetails.setAuthorizedGrantTypes(Arrays.asList("refresh_token", "authorization_code", "implicit"));
        swaggerUIDetails.setAuthorities(Arrays.asList(adminAuthority, userAuthority));
        swaggerUIDetails.setAccessTokenValiditySeconds(1800);
        swaggerUIDetails.setRefreshTokenValiditySeconds(2000);
        mongoTemplate.save(swaggerUIDetails);
    }
}
