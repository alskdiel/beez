package com.sinc.beez.tablet.model.sql;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sinc.beez.seat.model.vo.SeatVO;
import com.sinc.beez.userseat.model.vo.UserSeatVO;

@Repository("tabletDao")
public class TabletDaoImpl implements TabletDao {

	@Resource(name = "sqlSession")
	private SqlSession session;

	private static final String TABLETPREFIX = "com.sinc.beez.mapper.tablet.";

	@Override
	public List<Object> seatInfo(SeatVO seat) {

		System.out.println("TabletDaoImpl seatInfo");

		if (seat.getSeat_id() != null) {
			return session.selectList(TABLETPREFIX + "seat", seat);
		}
		return null;
	}

	@Override
	public List<Object> userseatInfo(UserSeatVO userseat) {

		System.out.println("TabletDaoImpl userseatInfo");
		if (userseat.getSeat_id() != null) {
			return session.selectList(TABLETPREFIX + "userseat", userseat);
		}
		return null;
	}
}
