package com.mfu.repository;

import com.mfu.domain.funds.Fund;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the User entity.
 */
@Repository
public interface FundRepository extends MongoRepository<Fund, String> {

}
