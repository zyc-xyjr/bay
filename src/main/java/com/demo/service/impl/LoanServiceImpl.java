package com.demo.service.impl;

import com.demo.dao.LoanDao;
import com.demo.entity.Loan;
import com.demo.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/9/5.
 */
@Service("loanService")
@Transactional
public class LoanServiceImpl implements LoanService{

    @Autowired
    private LoanDao loanDao;

    @Override
    public Page<Loan> findAll(Pageable pageable) {

        return loanDao.findAll(pageable);
    }
}
