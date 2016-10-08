package com.bm.resource;

import com.bm.entity.CheckEntry;
import com.bm.entity.CheckEntryItem;
import com.bm.entity.EntryItemPathogen;
import com.bm.entity.Pathogen;
import com.bm.service.CheckEntryService;
import com.bm.service.PathogenService;
import com.bm.service.impl.CheckEntryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by Administrator on 2016/9/8.
 */
@Controller
@RequestMapping("/admin/dictionary")
public class CheckEntryResource {

    @Autowired
    private CheckEntryService checkEntryService;
    @Autowired
    private CheckEntryItemService checkEntryItemService;
    @Autowired
    private PathogenService pathogenService;

    @RequestMapping("/checkEntry/list")
    public ModelAndView checkEntryList(){
        ModelAndView modelAndView = new ModelAndView("checkEntryList");
        List<CheckEntry> checkEntries=checkEntryService.findEntriesByParentId(0l);
        for (CheckEntry checkEntry:checkEntries){
            checkEntry.setChildrenEntries(checkEntryService.findEntriesByParentId(checkEntry.getId()));
        }
        List<Pathogen> pathogenList = pathogenService.findAllPathogen();
        modelAndView.addObject("pathogenList",pathogenList);
        modelAndView.addObject("checkEntryList",checkEntries);
        return modelAndView;


    }
    @RequestMapping("/checkEntry/toEdit")
    public ModelAndView toAddcheckEntry(@RequestParam(required = false) Long entryId){
        ModelAndView modelAndView = new ModelAndView("checkEntry/edit");
        List parentEntries = checkEntryService.findEntriesByParentId(0l);
        List<Pathogen> pathogenList = pathogenService.findAllPathogen();
        modelAndView.addObject("parentEntries",parentEntries);
        modelAndView.addObject("pathogenList",pathogenList);
        if (entryId==null||entryId==0){
            return modelAndView;
        }else {
            return modelAndView;
        }

    }
    @RequestMapping("/checkEntry/add")
    public String AddcheckEntry(CheckEntry checkEntry,
                                @RequestParam(required = false) String[] itemLabel,
                                @RequestParam(required = false) Float[] smallValue,
                                @RequestParam(required = false) Float[] bigValue,
                                @RequestParam(required = false) String[] analysis,
                                @RequestParam(required = false) String[] medicalAdvice,
                                @RequestParam(required = false) String[] lifeGuidance,
                                @RequestParam(required = false) String[] clinicDepartment
                                ){

        checkEntryService.saveCheckEntry(checkEntry);
        int length = itemLabel.length;
        for (int i=0;i<length;i++){
            CheckEntryItem checkEntryItem = new CheckEntryItem();
            checkEntryItem.setEntryId(checkEntry.getId());
            checkEntryItem.setItemLabel(itemLabel[i]);
            checkEntryItem.setSmallValue(smallValue[i]);
            checkEntryItem.setBigValue(bigValue[i]);
            checkEntryItem.setAnalysis(analysis[i]);
            checkEntryItem.setMedicalAdvice(medicalAdvice[i]);
            checkEntryItem.setLifeGuidance(lifeGuidance[i]);
            checkEntryItem.setClinicDepartment(clinicDepartment[i]);
            checkEntryItemService.saveCheckEntryItem(checkEntryItem);
       /*     EntryItemPathogen entryItemPathogen = new EntryItemPathogen();
            entryItemPathogen.setItemId(checkEntryItem.getId());
            entryItemPathogen.setPathogenId(pathogenIds[i]);*/
        }
        return "redirect:/admin/ftl/checkEntry/list";
    }

    @RequestMapping("/checkEntry/ajax/list")
    @ResponseBody
    public Map checkEntryAjaxList(@RequestParam int page,
                                  @RequestParam int rows){
        Map result = new HashMap();
        Page<CheckEntry> checkEntryPage = checkEntryService.pageAllCheckEntry(page,rows);
        result.put("total",checkEntryPage.getTotalElements());
        result.put("rows",checkEntryPage.getContent());
        return result;
    }

    @RequestMapping("/checkEntry/del")
    public String checkEntryBatchDel(@RequestParam String ids){
        String[] idStrs = ids.split(",");
        List<Long> idList = new ArrayList<>(idStrs.length);
        for (String idStr : idStrs){
            idList.add(Long.valueOf(idStr.trim()));
        }
        this.checkEntryService.batchDelCheckEntry(idList);
        return "redirect:/admin/ftl/checkEntry/list";
    }

    @RequestMapping("/checkEntry/ajax/all")
    @ResponseBody
    public List<CheckEntry> checkEntryAjaxAll(){
        return checkEntryService.findAllCheckEntry();
    }
}
