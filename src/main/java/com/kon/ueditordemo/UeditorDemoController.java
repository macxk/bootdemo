package com.kon.ueditordemo;

import com.baidu.ueditor.ActionEnter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UeditorDemoController {
    @Autowired
    private ActionEnter actionEnter;

    @RequestMapping("ue")
    public String ueditor(){
        return "uedemo.html";
    }


}
