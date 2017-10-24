package com.sinc.beez.user.ctrl;

import java.util.ArrayList;
import java.util.Map;

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
		
		/**********************************/
		// current_user = session.getUserVO
		UserVO current_user = new UserVO();
		current_user.setUser_id("p908vd");
		/**********************************/
				
		return null;
	}
	
	@RequestMapping("/search.do")
	@ResponseBody
	public Map<Object, Object> search(UserVO userToSearch) {			// user_id should be in params
		Map<Object, Object> ret = null;
		
		try {
			ret = (Map<Object, Object>) service.getUserSeat(userToSearch); 
		} catch(Exception e) {}
		
		return ret;
	}

	/*
	@RequestMapping("/finduser.do")
	@ResponseBody
	public ArrayList<UserVO> findUserByName(UserVO userToSearch) {
		System.out.println("/user/finduser.do");

		ArrayList<UserVO> list = (ArrayList) service.getUserByName(userToSearch);

		return list;
	}
	*/
	
	@RequestMapping("/finduser.do")
	@ResponseBody
	public Map<Object, Object> findUserByName(UserVO userToSearch) {

		Map<Object, Object> ret = null;
		
		try {
			ret = (Map<Object, Object>) service.getUserSeatByName(userToSearch); 
		} catch(Exception e) {}
		
		return ret;
	}

	
	@RequestMapping("/myteam.do")
	@ResponseBody
	public ArrayList<UserVO> getUserTeam() {
		
		/**********************************/
		// current_user = session.getUserVO
		UserVO current_user = new UserVO();
		current_user.setUser_id("p908vd");
		/**********************************/
		
		ArrayList<UserVO> list = (ArrayList) service.getUserTeamList(current_user);
		
		return list;
	}
	
	@RequestMapping("/myteam_seat.do")
	@ResponseBody
	public ArrayList<UserVO> getUserTeamSeat() {
		
		/**********************************/
		// current_user = session.getUserVO
		UserVO current_user = new UserVO();
		current_user.setUser_id("p908vd");
		/**********************************/
		
		ArrayList<UserVO> list = (ArrayList) service.getUserTeamSeatList(current_user);
		
		return list;
	}
}
