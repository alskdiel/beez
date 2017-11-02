package com.sinc.beez.settings.ctrl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sinc.beez.user.model.vo.UserVO;
import com.sinc.beez.user.service.UserService;

@Controller
@RequestMapping("/settings")
public class SettingsCtrl {
	
	@Resource(name="userService")
	private UserService service;
	
	@RequestMapping("/AlramSettings.do")
	public String AlramSettings(HttpSession session, Model model){
		
		UserVO current_user = (UserVO) session.getAttribute("currentUser");
		
		String userStatus = "출근 전";
		try {
			Map<Object, Object> stParam = new HashMap<Object, Object>();
			stParam.put("user_id", current_user.getUser_id());
			userStatus = (String)((Map) service.getStatus(stParam)).get("USER_STATE");
			System.out.println(userStatus);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		boolean isAtted = true;
		if(((UserVO) service.getState(current_user)).getAtt() == null) {
			isAtted = false;
		}
		model.addAttribute("isAtted", isAtted);		
		model.addAttribute("userState", userStatus);

		
		return "settings/settingsa";
	}

	
}
