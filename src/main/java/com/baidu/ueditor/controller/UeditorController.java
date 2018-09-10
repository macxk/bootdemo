package com.baidu.ueditor.controller;

import com.baidu.ueditor.ActionEnter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/ueditor")
public class UeditorController {

	@Autowired
	private ActionEnter actionEnter;
	
	@ResponseBody
	@RequestMapping("/upload")
	public String exe(HttpServletRequest request){
		return actionEnter.exec(request);
	}
	
}
