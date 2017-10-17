package com.sinc.beez.user.ctrl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.beez.user.model.vo.UserVO;
import com.sinc.beez.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserCtrl {
    
	@Resource(name="userService")
	private UserService service;
	
	@RequestMapping("/status.do")
	@ResponseBody
	public String status() {
		System.out.println("/user/status.do");
		
		/**********************************/
		// current_user = session.getUserVO
		UserVO current_user = new UserVO();
		current_user.setUser_id("p908vd");
		/**********************************/
		
		System.out.println(service.getState(current_user));
		
		return null;
	}
	
	@RequestMapping("/search.do")
	@ResponseBody
	public UserVO search(UserVO userToSearch) {			// user_id should be in params
		System.out.println("/user/search.do");
		
		UserVO ret = (UserVO)service.getUserSeat(userToSearch); 
		
		return ret;
	}

	@RequestMapping("/finduser.do")
	@ResponseBody
	public ArrayList<UserVO> findUserByName(UserVO userToSearch) {
		System.out.println("/user/finduser.do");

		ArrayList<UserVO> list = (ArrayList) service.getUserByName(userToSearch);
		
		return list;
	}
	
	@RequestMapping("/myteam.do")
	@ResponseBody
	public ArrayList<UserVO> getUserTeam() {
		System.out.println("/user/myteam.do");
		
		/**********************************/
		// current_user = session.getUserVO
		UserVO current_user = new UserVO();
		current_user.setUser_id("p908v4");
		/**********************************/
		
		ArrayList<UserVO> list = (ArrayList) service.getUserTeamList(current_user);
		
		return list;
	}
}
