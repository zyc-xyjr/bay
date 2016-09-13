package com.bm.resource;

import com.bm.entity.CheckEntry;
import com.bm.entity.CheckEntryItem;
import com.bm.entity.Pathogen;
import com.bm.service.PathogenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/12.
 */
@Controller
@RequestMapping("/admin/dictionary")
public class PathogenResource {

    @Autowired
    private PathogenService pathogenService;

    @RequestMapping("/pathogen/list")
    public ModelAndView checkEntryList(){
        ModelAndView modelAndView = new ModelAndView("pathogenList");
        List<Pathogen> pathogenList = this.pathogenService.findAllPathogen();
        modelAndView.addObject("pathogenList",pathogenList);
        return modelAndView;

    }
    @RequestMapping("/pathogen/toEdit")
    public ModelAndView toAddcheckEntry(@RequestParam(required = false) Long pathogenId){
        ModelAndView modelAndView = new ModelAndView("edit");
        if (pathogenId==null||pathogenId==0){
            return modelAndView;
        }else {
            return modelAndView;
        }

    }
    @RequestMapping("/pathogen/add")
    public String AddcheckEntry(Pathogen pathogen){
        this.pathogenService.savePathogen(pathogen);
        return "redirect:/admin/ftl/pathogen/list";
    }

    @RequestMapping("/pathogen/ajax/list")
    @ResponseBody
    public Map pathogenAjaxList(@RequestParam int page,
                                @RequestParam int rows){
        Map result = new HashMap();
        Page<Pathogen> pathogenPage = pathogenService.pageAllPathogen(page,rows);
        result.put("total",pathogenPage.getTotalElements());
        result.put("rows",pathogenPage.getContent());
        return result;
    }


    @RequestMapping("/pathogen/del")
    public String checkEntryBatchDel(@RequestParam String ids){
        String[] idStrs = ids.split(",");
        List<Long> idList = new ArrayList<>(idStrs.length);
        for (String idStr : idStrs){
            idList.add(Long.valueOf(idStr.trim()));
        }
        this.pathogenService.batchDelPathogen(idList);
        return "redirect:/admin/ftl/pathogen/list";
    }
}
