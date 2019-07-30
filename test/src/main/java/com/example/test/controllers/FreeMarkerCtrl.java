package com.example.test.controllers;


import com.example.test.utils.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/ftl")
public class FreeMarkerCtrl {

	@Autowired
	private Resource resource;

	@RequestMapping(value = "index")
	public String index(ModelMap map){
//		resource.setName("name");
//		resource.setLanguage("language");
//		resource.setWebsite("website");
		map.addAttribute("resource",resource);
		return "freemarker/index";
	}
}
