var $side_bar_close_btn = $(".main-sidebar .user-panel .beez-logo-right");
$side_bar_close_btn.on("click", function() {
	/*
	$body = $("body");
	if($body.hasClass("sidebar-open")) {
		$body.removeClass("sidebar-open");
	}
	*/
	toggleSidebar();
});
/*
$(".sidebar-toggle").on("click", function() {
	toggleSidebar();
});
*/

function logout() {
	$.ajax({
		url  : "/user/logout.do" , 
		type : "get", 
		dataType : "json" , 
		success : function(data) {
			if(data.ret) {
				sendAndroidMsg('LOGOUTPROCESS');
			}
		}
	});
}
function toggleSidebar() {
	$body = $("body");
	if($body.hasClass("sidebar-open")) {
		$body.removeClass("sidebar-open");
	} else {
		$body.addClass("sidebar-open");
	}
}

function setState(type) {
	var text; 
	if(type == 'edu') {
		text = "교육 중";
	} else if (type == 'out') {
		text = "외근 중";
	} else if (type == 'vac') {
		text = "휴가 중";
	} else {
		text = "출근 전";
	}
	
	$.ajax({
		url  : "/user/setStatus.do" , 
		type : "get", 
		dataType : "json",
		data : {state: text},
		success : function(data) {
			console.log(data);
		}
	});
	
	
	$(".sidebar-menu-row .dropdown button").html(text + "<span class='caret'></span>");
}

$(document).on("ready", function() {
	var $windowWidth = $(window).width();
	
	var prev = {};
	var current = {};
	var flag_open = false;
	var flag_close = false;
	
	$(".main-sidebar").bind('touchstart', function(e) {
		if(($windowWidth - event.touches[0].pageX) < 200 && ($("body").hasClass("sidebar-open"))) {
			flag_close = true;
			prev.x = event.touches[0].pageX;
			//e.preventDefault();	//	이벤트취소
		}
	});

	$(".main-sidebar").bind('touchmove', function(e) {
		if(flag_close) {
			var event = e.originalEvent;
			current.x = event.touches[0].pageX;			
			//event.preventDefault();
		}
	});

	$(".main-sidebar").bind('touchend', function(e) {
		if(flag_close) {
			chkSlideScale("close");
		}
	});
	
	
	
	$(".content-wrapper").bind('touchstart', function(e) {
		if(event.touches[0].pageX < 40) {
			flag_open = true;
			prev.x = event.touches[0].pageX;
			e.preventDefault();	//	이벤트취소
		}
	});

	$(".content-wrapper").bind('touchmove', function(e) {
		if(flag_open) {
			var event = e.originalEvent;
			current.x = event.touches[0].pageX;			
			event.preventDefault();
		}
	});

	$(".content-wrapper").bind('touchend', function(e) {
		if(flag_open) {
			chkSlideScale("open");
		}
	});


	function chkSlideScale(type) {
		if(Math.abs(current.x - prev.x) > 100) {
			$body = $("body");
			toggleSidebar();
		}
		if(type == "open") {
			flag_open = false;
		} else {
			flag_close = false;
		}
	}
});
