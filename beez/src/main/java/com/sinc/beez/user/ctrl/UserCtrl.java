package com.sinc.beez.user.ctrl;

import java.util.List;

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
	public String status() {
		UserVO tmp = new UserVO();	// tmp: current_user
		tmp.setUser_id("p908vd");
		System.out.println(service.getState(tmp));
		
		return null;
	}
/*	
	@RequestMapping("/search.do")
	@ResponseBody
	public UserVO search(UserVO userToSearch) {
		System.out.println("/user/search.do");
		UserVO ret = (UserVO)service.getUserById(userToSearch);
		
		return ret;
	}
*/
	@RequestMapping("/finduser.do")
	@ResponseBody
	public List<Object> findUserByName(UserVO userToSearch) {
		System.out.println("/user/finduser.do");
		List<Object> list = service.getUserByName(userToSearch);
		
		return list;
	}
}
