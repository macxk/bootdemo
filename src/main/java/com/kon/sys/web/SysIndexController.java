package com.kon.sys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*@Controller*/
@RequestMapping("sysIndex")
public class SysIndexController {

    @RequestMapping("index")
    public String doIndex(){
        return "index.html";
    }


}
