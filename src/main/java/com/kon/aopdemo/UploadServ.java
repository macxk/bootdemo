package com.kon.aopdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UploadServ {

    @RequestMapping(value = "recMap",method = RequestMethod.POST,produces = "application/json")
    public String recMap(@RequestBody Map data){
        return data.toString();
    }
}
