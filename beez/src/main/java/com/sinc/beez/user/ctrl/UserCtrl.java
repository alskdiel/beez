package com.sinc.beez.user.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
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
			System.out.println(ret);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
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
	@RequestMapping("/setSession.do")
	@ResponseBody
	public UserVO setSession(UserVO user, HttpSession session){
		System.out.println(">>>>>>>>SETSESSION USERVO : nextLine ");
		user = (UserVO)service.getUserVoById(user);
		System.out.println(user.toString());
		
		
		JSONObject res = new JSONObject();
		res.put("userid",  user.getUser_id());
		res.put("username",user.getUser_name());
		res.put("deptname", user.getDept_name());
		return  user;
	}
	
	@RequestMapping("/logout.do")
	@ResponseBody
	public Map<Object, Object> logout(HttpSession session){
		System.out.println("LOGOUT CTRL");
		
		Map<Object, Object> ret = new HashMap<Object, Object>();
		try {
			session.invalidate();
			ret.put("ret", true);
		} catch(Exception e) {
			ret.put("ret", false);
		}
		return  ret;
	}
	
	@RequestMapping("/setStatus.do")
	@ResponseBody
	public Map<Object, Object> setStatus(HttpSession session, HttpServletRequest request) {

		String userState = request.getParameter("state");
		String userId = ((UserVO) session.getAttribute("currentUser")).getUser_id();
		Map<Object, Object> param = new HashMap<Object, Object>();
		param.put("user_id", userId);
		param.put("user_state", userState);
		
		Map<Object, Object> ret = new HashMap<Object, Object>();

		try {
			service.setStatus(param);
			ret.put("ret", true);
		} catch(Exception e) {
			e.printStackTrace();
			ret.put("ret", false);
		}
		
		return ret;
	}
	
	@RequestMapping("/getStatus.do")
	@ResponseBody
	public Map<Object, Object> getStatus(HttpServletRequest request) {
		String userName = request.getParameter("user_name");
		ArrayList<UserVO> list = (ArrayList) service.getUserByName(userName);
		
		Map<Object, Object> ret = new HashMap<Object, Object>();
		String result = "검색할 수 없습니다";
		
		try {
			UserVO user = list.get(0);
			Map<Object, Object> param = new HashMap<Object, Object>();
			param.put("user_id", user.getUser_id());
			
			result = (String)((Map) service.getStatus(param)).get("USER_STATE");
		} catch(Exception e){}
		
		
		ret.put("result", result);
		return ret;
	}
}
