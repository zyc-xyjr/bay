package com.demo.dao;

import com.demo.entity.Invest;
import com.demo.entity.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2016/9/5.
 * String is ID`s Type
 */
public interface InvestDao extends CrudRepository<Invest,String> {

    Page<Invest> findAll(Pageable pageable);
}
