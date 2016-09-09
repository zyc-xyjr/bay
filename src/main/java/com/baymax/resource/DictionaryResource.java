package com.baymax.resource;

import com.baymax.entity.CheckEntry;
import com.baymax.service.CheckEntryService;
import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/8.
 */
@Controller
@RequestMapping("/admin/dictionary")
public class DictionaryResource {

    @Autowired
    private CheckEntryService checkEntryService;

    @RequestMapping("/checkEntry/list")
    public ModelAndView checkEntryList(){
        ModelAndView modelAndView = new ModelAndView("checkEntryList");
        List<CheckEntry> checkEntries=new ArrayList<>();
        CheckEntry checkEntry = new CheckEntry();
        checkEntry.setEntryName("啊啊啊");
        checkEntries.add(checkEntry);
        modelAndView.addObject("checkEntryList",checkEntries);
        return modelAndView;


    }
    @RequestMapping("/checkEntry/toEdit")
    public ModelAndView toAddcheckEntry(@RequestParam(required = false) Long entryId){
        ModelAndView modelAndView = new ModelAndView("checkEntryEdit");
        if (entryId==null||entryId==0){
            return modelAndView;
        }else {
            return modelAndView;
        }

    }
    @RequestMapping("/checkEntry/add")
    public ModelAndView AddcheckEntry(CheckEntry checkEntry){
        ModelAndView modelAndView = new ModelAndView("checkEntryList");
        checkEntryService.saveCheckEntry(checkEntry);
        return modelAndView;
    }
}
