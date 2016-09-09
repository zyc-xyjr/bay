package com.demo.service;

import com.demo.entity.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Administrator on 2016/9/5.
 */
public interface LoanService {

    Page<Loan> findAll(Pageable pageable);
}
