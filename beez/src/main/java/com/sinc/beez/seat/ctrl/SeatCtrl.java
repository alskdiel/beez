package com.sinc.beez.seat.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.beez.seat.service.SeatService;
import com.sinc.beez.user.model.vo.UserVO;
import com.sinc.beez.userseat.model.vo.UserSeatVO;
import com.sinc.beez.util.PagingDTO;

@Controller
@RequestMapping("/seat")
public class SeatCtrl {

	@Resource(name="seatService")
	private SeatService service;
	
	
	//전체 좌석 현황
	@RequestMapping("/list.do")
	public String status(Model model) {
		
		List<Object> seatlist = service.seatList();
	     
		model.addAttribute("seatlist",seatlist);
		return "/seat/status";
	}
	
	@RequestMapping("/seatstat.do")
	public String statistics() {
		
		return "seat/statistics";
	}
	
	@RequestMapping("/myseat.do")
	public String myHistory(Model model, PagingDTO pagingDTO) {
		/**********************************/
		// current_user = session.getUserVO
		UserVO current_user = new UserVO();
		current_user.setUser_id("p908vd");
		/**********************************/
		
		pagingDTO.setPageSize(10);
		pagingDTO.setPageNo(1);
		
		pagingDTO.setBlockSize(10);
		pagingDTO.setTotalCount(service.getCount(current_user));
		
		
		List<Object> list = service.seatHistoryList(current_user, pagingDTO);
		model.addAttribute("endPageNo", pagingDTO.getEndPageNo());
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		return "seat/myseat";
	}
	
	@RequestMapping("/myseatajax.do")
	@ResponseBody
	public ArrayList<UserSeatVO> myHistoryAjax(PagingDTO pagingDTO, String pageNo) {
		/**********************************/
		// current_user = session.getUserVO
		UserVO current_user = new UserVO();
		current_user.setUser_id("p908vd");
		/**********************************/
		
		pagingDTO.setPageSize(10);
		pagingDTO.setPageNo(1);
		if(pageNo != null){
			pagingDTO.setPageNo(Integer.parseInt(pageNo));
		}
				
		pagingDTO.setBlockSize(10);
		pagingDTO.setTotalCount(service.getCount(current_user));
		
		
		ArrayList<UserSeatVO> list = (ArrayList) service.seatHistoryList(current_user, pagingDTO);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		return list;
	}
}
