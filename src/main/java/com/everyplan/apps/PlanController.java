package com.everyplan.apps;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlanController {
	
	private static final Logger logger = LoggerFactory.getLogger(PlanController.class);
	
	@Autowired
	PlanService planService;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
//		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", date );
		
		return "home";
	}
	
	@RequestMapping(value="/createPlan", method = RequestMethod.GET)
	public ModelAndView create() {
	    return new ModelAndView("plan/createPlan");
	}
	
	@RequestMapping(value="/createPlan", method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
	    
		ModelAndView mav = new ModelAndView();
		
		
		String planId = this.planService.create(map);
		if(planId == null) {
			mav.setViewName("redirect:plan/createPlan");
		}else {
			mav.setViewName("redirect:/detail?planId=" + planId);
		}
		return mav;
	}
	
	@RequestMapping(value="/detail", method = RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
		Map<String, Object> detailMap = this.planService.selectDetail(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detailMap);
		String planId = map.get("planId").toString();
		mav.addObject("planId", planId);
		mav.setViewName("/plan/detail");
		return mav;
	}
	
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public ModelAndView update(@RequestParam Map<String, Object> map){
		Map<String, Object> detailMap = this.planService.selectDetail(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detailMap);
		mav.setViewName("plan/updatePlan");
		return mav;
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	public ModelAndView updatePost(@RequestParam Map<String, Object> map){
		ModelAndView mav = new ModelAndView();
		
		boolean isUpdateSuccess = this.planService.edit(map);
		if(isUpdateSuccess) {
			String planId = map.get("planId").toString();
			mav.setViewName("redirect:/detail?planId="+planId);
		}else {
			mav = this.update(map);
		}
		return mav;
	}
	
	@RequestMapping(value="delete", method = RequestMethod.POST)
	public ModelAndView deletePost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		// 삭제 성공여부 확인
		boolean isUpdateSuccess = this.planService.remove(map);
		if(isUpdateSuccess) {
			// 삭제 성공 시 상세 페이지가 없으므로 리스트 페이지로 돌아감
			mav.setViewName("redirect:/list");
		}else {
			// 삭제가 실패했으므로 다시 상세페이지로 간다.
			String planId = map.get("planId").toString();
			mav.setViewName("redirect:/detail?planId="+planId);
		}
		return mav;
	}
	
	@RequestMapping(value="list")
	public ModelAndView list(@RequestParam Map<String, Object> map) {
		List<Map<String, Object>> list = this.planService.list(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", list);
		
		if(map.containsKey("keyword")) {
			mav.addObject("keyword", map.get("keyword"));
		}
		
		mav.setViewName("/plan/list");
		
		return mav;
	}
		
}