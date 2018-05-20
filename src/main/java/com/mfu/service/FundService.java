package com.mfu.service;

import com.mfu.domain.funds.Fund;
import com.mfu.repository.FundRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by himanshu dhawan on 18-05-2018.
 */
@Service
public class FundService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private FundRepository fundRepository;

    public Page<Fund> getAllManagedFunds(Pageable pageable) {
        return fundRepository.findAll(pageable);
    }
}
