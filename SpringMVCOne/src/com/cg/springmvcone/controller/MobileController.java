package com.cg.springmvcone.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cg.springmvcone.dto.Mobile;
import com.cg.springmvcone.service.iMobileService;

@Controller
public class MobileController {
	@Autowired
	iMobileService mobileservice;
	@RequestMapping(value="/home")
	public String getAllMobile(@ModelAttribute("my") Mobile mob, Map<String,Object> model) {
		//System.out.println("Welcome to Spring MVC....");
		
		List<String> myList=new ArrayList<>();
		myList.add("Android");
		myList.add("iphone");
		myList.add("Windows");
		
		model.put("cato",myList);
		return "AddMobile";
	}
	@RequestMapping(value="AddData", method=RequestMethod.POST)
   public String addMobileData(@Valid@ModelAttribute("my") Mobile mobile,BindingResult result,Map<String,Object> model){
		
		//System.out.println(mobile.getMobId()+" "+mobile.getMobName()+" "+mobile.getMobPrice()+" "+mobile.getMobCategory()+" "+mobile.getMobOnline());
       if(result.hasErrors()){
    	   List<String> myList=new ArrayList<>();
   		myList.add("Android");
   		myList.add("iphone");
   		myList.add("Windows");
   		
   		model.put("cato",myList);
	return "AddMobile";
       }else
       {
    	   mobileservice.addMobile(mobile);
		return "Success";
	}
	}
	@RequestMapping(value="showall", method=RequestMethod.GET)
	public ModelAndView showAllMobileData(){
		List<Mobile> allMobile=mobileservice.showAllMobile();
		System.out.println(allMobile);
		return new ModelAndView("mobileshow","data",allMobile);
	}
	@RequestMapping(value="searchmobile",method=RequestMethod.GET)
	public String searchData(@ModelAttribute("yy") Mobile mob){
		return "searchmobile";
	}
	@RequestMapping(value="mobilesearch", method=RequestMethod.POST)
	public ModelAndView dataSearch(@ModelAttribute("yy") Mobile mob){
		Mobile mobSearch=mobileservice.searchMobile(mob.getMobId());
		//System.out.println(mobSearch);
		return new ModelAndView("showsearch","temp",mobSearch);
	}
	@RequestMapping(value="deletemobile", method=RequestMethod.GET)
	public String deleteData(@ModelAttribute("zz") Mobile del){
		return "deletemobile";
	}
	@RequestMapping(value="mobiledelete", method=RequestMethod.POST)
	public String dataDelete(@ModelAttribute("zz") Mobile del){
		mobileservice.deleteMobile(del.getMobId());
		return "delete";
	}
	@RequestMapping(value="updatemobile", method=RequestMethod.GET)
	public String updateData(@ModelAttribute("xx") Mobile upd){
		return "updatemobile";
		
		}
	@RequestMapping(value="mobileUpdate", method=RequestMethod.POST)
	public ModelAndView dataUpdate(@ModelAttribute("xx") Mobile upd){
		mobileservice.updateMobile(upd.getMobId(),upd.getMobPrice());
		return new ModelAndView ("mobileUpdate");
		
	}
}
