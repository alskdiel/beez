$("#team-toggle").prop('checked', false).change();


function setStatus(data) {
	for(var i=0; i<data.length; i++) {
		var floor = data[i].floor;
		var floor_info = data[i].data;
		
		for(var j=0; j<floor_info.length; j++) {
			var section = floor_info[j].section;
			var section_status = floor_info[j].data;
			
			var $cur_section = $("#floor-" + floor);
			
			var disabled = section_status.disabled;
			var inuse = section_status.inuse;
			
			for(var k=0; k<disabled.length; k++) {
				$cur_section.find("#"+disabled[k]).addClass("disabled");
			}
			
			for(var k=0; k<inuse.length; k++) {
				$cur_section.find("#"+inuse[k]).addClass("inuse");
			}
		}
	}
}

function resetStatus() {
	var seats = $(".floor-container .outer .inner td");
	for(var i=0; i<seats.length; i++) {
		if(($(seats[i]).hasClass("disabled")) || ($(seats[i]).hasClass("inuse"))) {
			$(seats[i]).removeClass();
		}
	}
}

//$(document).on("ready", function() {
	 

$offset_9f = $("#floor-9").offset().top - 25;
$offset_10f = $("#floor-10").offset().top - 25;
$offset_13f = $("#floor-13").offset().top - 25;
$offset_14f = $("#floor-14").offset().top - 25;


$("#to-9f").on("click", function() {
    $('html, body').animate({ scrollTop: $offset_9f}, 1000);
});

$("#to-10f").on("click", function() {
    $('html, body').animate({ scrollTop: $offset_10f}, 1000);
});

$("#to-13f").on("click", function() {
    $('html, body').animate({ scrollTop: $offset_13f}, 1000);
});

$("#to-14f").on("click", function() {
    $('html, body').animate({ scrollTop: $offset_14f}, 1000);
});

$(".my-modal .dismiss").on("click", function() {
	
	$(".my-modal").css("display", "none");
});

$(".display-team-list").on("click", function() {
	getTeamMates()
	
});

$("#team-toggle").on("change", function() {
	if($(this).prop("checked") == true) {
		getTeamMatesSeat();	
	}	
});



var prev = {};
var current = {};
var flag = false;

$(".carousel").bind('touchstart', function(e) {
	if(event.touches[0].pageX > 40) {
		flag = true;
		prev.x = event.touches[0].pageX;
		//e.preventDefault();	//	이벤트취소
	}
	
});

$(".carousel").bind('touchmove', function(e) {
	if(flag) {
		var event = e.originalEvent;
		current.x = event.touches[0].pageX;			
		//event.preventDefault();
	}
});


var isFirstPage = {
		"floor-9": true,
		"floor-10": true,
		"floor-13": true,
		"floor-14": true
}

$(".carousel").bind('touchend', function(e) {
	var floor = $(this).parent().parent().attr("id");
	var $element = $(this).parent().children(".nav-tabs");
	
	if(flag) {
		if(current.x - prev.x < -40 && isFirstPage[floor]) {
			$(this).carousel('next');
			isFirstPage[floor] = false;
			
			toggleNavTabs($element, 'B');
		} else if(current.x - prev.x > 40 && !isFirstPage[floor]) {
			$(this).carousel('prev');
			isFirstPage[floor] = true;
			
			toggleNavTabs($element, 'A');
		}
	}
	flag = false;
});

$(".nav.nav-tabs li").on("click", function() {
	var $tab = $(this);
	var floor = $(this).parent().parent().parent().attr("id");
	
	if($tab.text() == 'A') {
		isFirstPage[floor] = true;
	} else {
		isFirstPage[floor] = false;
	}
});

$(".search .icon-container").on("click", function() {
	var user_name = $(".search .input-container input").val();
	searchUserByName(user_name);
});

$(".refresh .icon-container").on("click", function() {

	resetStatus();
	
	getCurrentStatus();
	$("#team-toggle").prop('checked', false).change();

});

function refresh(seat_status) {

	setStatus(seat_status);
}

function toggleNavTabs($element, type) {
	if(type == 'A') {
		$element.children("li:nth-child(1)").addClass("active");
		$element.children("li:nth-child(2)").removeClass("active");
	} else {
		$element.children("li:nth-child(2)").addClass("active");
		$element.children("li:nth-child(1)").removeClass("active");
	}
}

function getCurrentStatus() {
	$.ajax({
		url  : "/seat/listAjax.do" , 
		type : "get" , 
		dataType : "json" , 
		success : function(data) {
			console.log(data);
			refresh(data);
		}
	});
}

function searchUserSeatById(user_id) {
	$.ajax({
		url  : "/user/search.do" , 
		type : "get" , 
		data : { user_id : user_id } ,
		dataType : "json" , 
		success : function(data) {
			resetStatus();
			takeElavatorWithOfficeSeq(data.floor);
			showSearchResult(data)
		}
	});
}

function officeSeqToFlr(office_seq) {
	if(office_seq == 1) {
		return 9;
	} else if(office_seq == 2) {
		return 10;
	} else if(office_seq == 3) {
		return 13;
	} else if(office_seq == 4) {
		return 14;
	}
	
	return 9;
}

function takeElavatorWithOfficeSeq(office_seq) {
	var floor = officeSeqToFlr(office_seq);
	
	if(floor == 9) {
	    $('html, body').animate({ scrollTop: $offset_9f}, 1000);
	} else if(floor == 10) {
	    $('html, body').animate({ scrollTop: $offset_10f}, 1000);
	}  else if(floor == 13) {
	    $('html, body').animate({ scrollTop: $offset_13f}, 1000);
	}  else if(floor == 14) {
	    $('html, body').animate({ scrollTop: $offset_14f}, 1000);
	} 
}

function showSearchResult(data) {
	var office_seq = data.floor;
	var seat_id = data.seat_id;
	var floor = officeSeqToFlr(office_seq);
	
	$("#floor-"+floor+"").find("#"+seat_id).addClass("inuse");
}

function getTeamMates() {
	$.ajax({
		url  : "/user/myteam.do" , 
		type : "get" , 
		dataType : "json" , 
		success : function(data) {
			console.log(data);
			$(".my-modal").css("display", "block");
			writeTeamList(data);
		}
	});
}

function getTeamMatesSeat() {
	$.ajax({
		url  : "/user/myteam_seat.do" , 
		type : "get" , 
		dataType : "json" , 
		success : function(data) {
			console.log(data);
			resetStatus();
			
			for(var i=0; i<data.length; i++) {
				showSearchResult(data[i]);
			}
			
		}
	});
}

function searchUserByName(user_name) {
	$.ajax({
		url  : "/user/finduser.do" , 
		type : "get" , 
		data : { user_name: user_name },
		dataType : "json" , 
		success : function(data) {
			console.log(data);
			
			
			resetStatus();
			showSearchResult(data);

			takeElavatorWithOfficeSeq(data.floor);

			var $element = $(this).parent().children(".nav-tabs");
			var type = 'A';
			if(data.id > 35 && data.id < 70) {
				type = 'B';
			}
			
			if(type == 'A') {
				isFirstPage[data.floor] = true;
			} else {
				isFirstPage[data.floor] = false;
			}
			
			toggleNavTabs($element, type);
		}
	});
}

function writeTeamList(teammates) {
	var html = "";
	for(var i=0; i<teammates.length; i++) {
		var user_id = teammates[i].user_id;
		var user_name = teammates[i].user_name;
		var user_seat = teammates[i].seat;
		
		var td_seat_status = "<div class='user-leave-yn'></div>";
		if(user_seat) {
			td_seat_status = "<div class='user-leave-yn y'></div>";
		}
		
		//onclick="getCalendar(\'' + prevDate + '\')"
		
		html += "<tr onclick='searchUserSeatById(\"" + user_id + "\")'>"
			  + "<td>" + user_id + "</td>"
			  + "<td>" + user_name + "</td>"
			  + "<td>" + td_seat_status + "</td>"
			  + "</tr>";
	}
	
	$(".my-modal .modal-content table tbody").html(html);
}
//searchUserSeatById('p908vd');
//getTeamMates();
//searchUserByName('조현재');
	
	
	
//});

