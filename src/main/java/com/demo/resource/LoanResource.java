package com.demo.resource;

import com.demo.entity.Loan;
import com.demo.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/9/5.
 */
@Controller
@RequestMapping("/loan")
public class LoanResource {
    @Autowired
    private LoanService loanService;

    @RequestMapping("/list")
    public void findAllLoans(){
        Page<Loan> loanPage =loanService.findAll(new PageRequest(0,10));
        System.out.println("+++++++++++==");
    }
}
