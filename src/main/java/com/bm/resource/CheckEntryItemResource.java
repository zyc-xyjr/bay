package com.bm.resource;

import com.bm.entity.CheckEntryItem;
import com.bm.service.impl.CheckEntryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/9/18.
 */
@Controller
@RequestMapping("/admin/item")
public class CheckEntryItemResource {

    @Autowired
    private CheckEntryItemService checkEntryItemService;

    @RequestMapping("/ajax/list")
    @ResponseBody
    public List<CheckEntryItem> entryItemsByEntryId(@RequestParam Long entryId){
        return checkEntryItemService.entryItemsByEntryId(entryId);
    }
}
