package com.sinc.beez.settings.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/settings")
public class SettingsCtrl {
	
	@RequestMapping("/AlramSettings.do")
	public String AlramSettings(){
		
		return "settings/settingsa";
	}

	
}
