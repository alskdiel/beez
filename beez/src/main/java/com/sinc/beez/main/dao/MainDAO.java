package com.sinc.beez.main.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.jdbc.Sql;

import com.sinc.beez.main.model.MainVO;

@Repository("MainDAO")
public class MainDAO {

	
	private final static String PREFIX="com.sinc.beez.mapper.main.";
	@Inject
	SqlSession session;

	public MainVO getMainInfo(MainVO vo) {
		MainVO ret;
		try {
			ret = (MainVO)session.selectOne(PREFIX + "selectMain",vo);
		} catch (Exception e) {
			ret = new MainVO();
		}

		return ret;
	}

}
