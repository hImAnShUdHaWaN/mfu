package com.mfu.web.rest.vm;

import com.codahale.metrics.annotation.Timed;
import com.mfu.domain.funds.Fund;
import com.mfu.service.FundService;
import com.mfu.web.rest.util.PaginationUtil;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by himanshu dhawan on 18-05-2018.
 */
@RestController
@RequestMapping("/api")
public class FundResource {

    @Autowired
    private FundService fundService;

    /**
     * GET  /users : get all users.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and with body all users
     */
    @GetMapping("/funds")
    @Timed
    public ResponseEntity<List<Fund>> getAllFunds(@ApiParam Pageable pageable) {
        final Page<Fund> page = fundService.getAllManagedFunds(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/funds");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
}
