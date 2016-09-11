package com.bm.resource;

import com.bm.entity.CheckEntry;
import com.bm.entity.CheckEntryItem;
import com.bm.service.CheckEntryService;
import com.bm.service.impl.CheckEntryItemService;
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
    @Autowired
    private CheckEntryItemService checkEntryItemService;

    @RequestMapping("/checkEntry/list")
    public ModelAndView checkEntryList(){
        ModelAndView modelAndView = new ModelAndView("checkEntryList");
        List<CheckEntry> checkEntries=checkEntryService.findEntriesByParentId(0l);
        for (CheckEntry checkEntry:checkEntries){
            checkEntry.setChildrenEntries(checkEntryService.findEntriesByParentId(checkEntry.getId()));
        }
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
    public ModelAndView AddcheckEntry(CheckEntry checkEntry,
                                      @RequestParam("itemLabel") String[] itemLabels,
                                      @RequestParam("itemSection") String[] itemSections){
        ModelAndView modelAndView = new ModelAndView("checkEntryList");
        checkEntryService.saveCheckEntry(checkEntry);
        int length = itemLabels.length;
        for (int i=0;i<length;i++){
            CheckEntryItem checkEntryItem = new CheckEntryItem();
            checkEntryItem.setEntryId(checkEntry.getId());
            checkEntryItem.setItemLabel(itemLabels[i]);
            checkEntryItem.setItemSection(itemSections[i]);
            checkEntryItemService.saveCheckEntryItem(checkEntryItem);
        }
        return modelAndView;
    }
}
