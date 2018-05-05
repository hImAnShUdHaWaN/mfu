package com.mfu.domain.funds;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by himanshu dhawan on 01-05-2018.
 */
@Document(collection = "price_point")
@Data
public class FundPricePoint {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String schemeCode;

    private Date date;

    private Double nav;

    private Double repPrice;

    private Double salePrice;

}
