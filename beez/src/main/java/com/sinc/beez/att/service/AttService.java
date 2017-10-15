package com.sinc.beez.att.service;

import java.util.Map;

public interface AttService {
	public Map<Object, Object> attList(Object user);	// obj: Date
	public Map<Object, Object> attAjaxList(Object user, Object date);	// obj: Date

}
