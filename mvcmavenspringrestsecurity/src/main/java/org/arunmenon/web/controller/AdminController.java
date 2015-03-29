package org.arunmenon.web.controller;


import java.util.List;

import org.arunmenon.persistence.model.Foo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	  	@RequestMapping(method = RequestMethod.GET)
	    @ResponseBody
	    public List<Foo> findAll() {
	        return Lists.newArrayList(new Foo("Arun Menon"));
	    }
}
