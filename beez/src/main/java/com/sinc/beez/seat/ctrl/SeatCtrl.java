package com.sinc.beez.seat.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
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
	    
		
		JSONArray list = new JSONArray(seatlist);
		model.addAttribute("tmp", list);
		
		return "/seat/status";
	}
	
	@RequestMapping("/listAjax.do")
	@ResponseBody
	public List<Object> statusAjax(Model model) {
		
		List<Object> seatlist = service.seatList();
	    
		return seatlist;
	}
	
	@RequestMapping("/seatstat.do")
	public String statistics() {
		
		return "seat/statistics";
	}
	
	@RequestMapping("/statistics.do")
	@ResponseBody
	public List<Object> statisticsAjax(HttpServletRequest request, HttpSession session) {
		
		String type = request.getParameter("type");
		String sub_type = request.getParameter("sub_type");
		
		UserVO currentUser = (UserVO) session.getAttribute("currentUser");
		
		System.out.println(type);
		System.out.println(sub_type);
		
		Map<Object, Object> obj = new HashMap<Object, Object>();
		obj.put("currentUser", currentUser);
		obj.put("sub_type", sub_type);
		
		List<Object> chartlist;
		
		if(type.equals("fav")) {
			chartlist = service.getUserFavorite(obj);
		} else {
			chartlist = service.getUserFavorite(obj);
		}
		
		System.out.println(chartlist);
		
		return chartlist;
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
		pagingDTO.setTotalCount(service.getCount(current_user, "all", null));
		
		List<Object> list = service.seatHistoryList(current_user, pagingDTO, "all", null);
		model.addAttribute("userSeatVO", list);
		
		
		return "seat/myseat";
	}
	
	@RequestMapping("/myseatajax.do")
	@ResponseBody
	public HashMap<String, Object> myHistoryAjax(PagingDTO pagingDTO, String pageNo, HttpServletRequest request) {
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
		String filterType = request.getParameter("filterType");
		String params = request.getParameter("params");
		
		pagingDTO.setTotalCount(service.getCount(current_user, filterType, params));
				
		ArrayList<UserSeatVO> list = (ArrayList) service.seatHistoryList(current_user, pagingDTO, filterType, params);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("endPageNo", pagingDTO.getEndPageNo());
		map.put("list", list);
		
		
		return map;
	}
}
