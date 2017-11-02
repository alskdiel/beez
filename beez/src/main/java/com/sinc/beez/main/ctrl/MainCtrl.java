package com.sinc.beez.main.ctrl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.beez.main.model.MainVO;
import com.sinc.beez.main.model.SyncDTO;
import com.sinc.beez.main.service.MainService;
import com.sinc.beez.user.model.vo.UserVO;
import com.sinc.beez.user.service.UserService;

@Controller
public class MainCtrl {
	@Resource(name="MainService")
	MainService service;

	    
	@Resource(name="userService")
	private UserService service2;
	
	@RequestMapping("/main.do")
	public String main(MainVO vo ,Model model, HttpSession session) {
		System.out.println("MainCtrl main");
		/*
		System.out.println("BEFORE : "+vo.toString());
		vo = service.getMainInto(vo);
		System.out.println("AFTER : "+vo.toString());
		*/
		UserVO current_user = (UserVO)session.getAttribute("currentUser");
		
		if(current_user == null) {
			
			UserVO user = new UserVO();
			
			try {
			user.setUser_id((String)session.getAttribute("currentUserId"));
			user = (UserVO)service2.getUserVoById(user);
			} catch(Exception e){}
			session.setAttribute("currentUser", user);
			
			current_user = user; 
		}
		
		String userStatus = "출근 전";
		try {
			Map<Object, Object> stParam = new HashMap<Object, Object>();
			stParam.put("user_id", current_user.getUser_id());
			userStatus = (String)((Map) service2.getStatus(stParam)).get("USER_STATE");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		boolean isAtted = true;
		if(((UserVO) service2.getState(current_user)).getAtt() == null) {
			isAtted = false;
		}
		model.addAttribute("isAtted", isAtted);		
		model.addAttribute("userState", userStatus);

		return "home";
	}
	@RequestMapping("syncAttNFc.do")
	@ResponseBody
	public SyncDTO syncAttNFc(String userid){

		SyncDTO vo = new SyncDTO();
		vo.setUserid(userid);
		System.out.println(vo.toString());
		vo = service.init(vo);
		System.out.println(vo.toString());
		return vo;
	}
}
