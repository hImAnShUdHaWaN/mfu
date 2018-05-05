package com.mfu.domain.funds;

import com.mfu.domain.AbstractAuditingEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by himanshu dhawan on 01-05-2018.
 */
@Data
@Document(collection = "fund")
public class Fund implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String schemeCode;

    private AMC AMC;

    private String schemeName;

    private String detailedName;

    private String isin;

    private String divReinvestIsin;

    private SchemeCategory category;

    private SchemeType type;

    private Date launchDate;

    private Date closureDate;

    private String minAmount;
}
