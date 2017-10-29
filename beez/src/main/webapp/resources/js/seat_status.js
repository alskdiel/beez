
//searchUserSeatById('p908vd');
//getTeamMates();
//searchUserByName('조현재');
	
	
	
//});






$('html').click(function(e) {	
	$('table.inner tr td .btn').popover('hide');
	
	$modal = $("#chartModal");
	if($modal.hasClass("active")) {
		$modal.removeClass("active");
		$modal.addClass("fade");
		
	}
});

$('table.inner tr td .btn').popover({
    html: true,
    trigger: 'manual'
}).click(function(e) {
	$('table.inner tr td .btn').popover('hide');

	var seat_id = $(this).parent().attr("id");
	var floor_num = $(this).parent()
							.parent()
							.parent()
							.parent()
							.parent()
							.parent()
							.parent()
							.parent()
							.parent()
							.parent()
							.parent()
							.parent()
							.parent()
							.parent()
							.attr("id")
							.split("-")[1];
							
	var isRevable = isReservable(floor_num, seat_id);
	
	seat_info = transformToNFCID(floor_num, seat_id);
	
	setTimeout(function() {
		if(isRevable) {
			mkRevBtn(seat_info);
		}
		if(isHotPlace(floor_num, seat_id)) {
			mkShowHotDetailBtn(floor_num, seat_id);
		}
	}, 100);
	
	
    $(this).popover('toggle');
    e.stopPropagation();
});

function mkShowHotDetailBtn(floor_num, seat_id) {
	
	var btn = "<div class='btn-show-hot' onclick=getHotChart("+ floor_num +"," + seat_id +")>상세보기</div>";
	$(".popover .popover-content").append(btn);
}

function transformToNFCID(floor_num, seat_id) {
	section = 'A';
	
	if(seat_id > 35) {
		section = 'B';
	}
	
	if(seat_id < 10) {
		seat_id = "0" + seat_id;
	}
	
	return floor_num + "F-" + section + "-" + seat_id;
}

function getHotPlace() {
	var ret = [];
	for(var i=0; i<hot_places.length; i++) {
		ret.push(splitNFCID(hot_places[i].TITLE));
	}
	
	return ret;
}


function getHotChart(floor_num, seat_id) {
	console.log(floor_num);
	console.log(seat_id);
	
	console.log("after ajax success");


	setTimeout(function() {
		var $modal = $("#chartModal");
		$modal.removeClass("fade");
		$modal.addClass("active");
		
		setHotChart(cData, cLabels, BGCOLOR);
			
	});
	
	
}



function isHotPlace(floor_num, seat_id) {
	var hotPlaces = getHotPlace();
	console.log(hotPlaces);
	
	for(var i=0; i<hotPlaces.length; i++) {
		if(floor_num == hotPlaces[i].floor && seat_id == hotPlaces[i].seat_id) {
			return true;
		}
	}
	return false;
}

function splitNFCID(nfcID) {
	var temp = nfcID.split("-");
	var floor_num = temp[0].substr(0, temp[0].length-1);
	var seat_id = temp[2];
	
	return {floor: floor_num,
			seat_id: seat_id};
}

function mkRevBtn(seat_info) {
	var btn = "<div class='btn-rev' onclick=reserveSeat('" + seat_info + "')>예약</div>";
	$(".popover .popover-content").html(btn);
}

function reserveSeat(seat_info) {
	sendAndroidMsgTwoValue("GoSeatBook", seat_info);
}

function isReservable(floor_num, seat_id) {
	for(var i=0; i<seat_status.length; i++) {
		if(seat_status[i].floor == floor_num) {
			for(var j=0; j<seat_status[i].data.length; j++) {
				for(var k=0; k<seat_status[i].data[j].data.disabled.length; k++) {
					if(seat_status[i].data[j].data.disabled[k] == seat_id) {
						return false;
					}
				}
				
				for(var k=0; k<seat_status[i].data[j].data.inuse.length; k++) {
					if(seat_status[i].data[j].data.inuse[k] == seat_id) {
						return false;
					}
				}
			}
		}
	}
	
	return true;
}


$("#team-toggle").prop('checked', false).change();


function setStatus(data) {
	console.log(data);
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
	
	var hotPlaces = getHotPlace();
	
	for(var i=0; i<hotPlaces.length; i++) {
		var floor = hotPlaces[i].floor;
		var seat_id = hotPlaces[i].seat_id;
		
		
		var $floor = $("#floor-" + floor);
		var hotPlaceTxt = "<div class='icon-wrapper'>"
						+ 	"<div class='icon-hotplace'>"
						+ 	"</div>"
						+ "</div>";
		
		$floor.find("#"+seat_id).prepend(hotPlaceTxt);

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
	 

$offset_9f = $("#floor-9").offset().top - 100;
$offset_10f = $("#floor-10").offset().top - 100;
$offset_13f = $("#floor-13").offset().top - 100;
$offset_14f = $("#floor-14").offset().top - 100;

function switchFlrBtn(flr) {
    var $btns = $(".floor-btn div");
	console.log($btns);
	var idx = 0;
	if(flr == 10) {
		idx = 1;
	} else if(flr == 13) {
		idx = 2
	} else if(flr == 14) {
		idx = 3;
	} else {
		idx = 0;
	}
	
    for(var i=0; i<$btns.length; i++) {
    	
    	var $cur_flr = $($btns[i]);
    	if($cur_flr.hasClass("current_floor")) {
    		$cur_flr.removeClass("current_floor");
    	}
    	
    	if(idx == i) {
    		$cur_flr.addClass("current_floor");
    	}
    }
}

$("#to-9f").on("click", function() {
	switchFlrBtn(9);
    $('html, body').animate({ scrollTop: $offset_9f}, 700);
});

$("#to-10f").on("click", function() {
	switchFlrBtn(10);
    $('html, body').animate({ scrollTop: $offset_10f}, 700);
});

$("#to-13f").on("click", function() {
	switchFlrBtn(13);
    $('html, body').animate({ scrollTop: $offset_13f}, 700);
});

$("#to-14f").on("click", function() {
	switchFlrBtn(14);
    $('html, body').animate({ scrollTop: $offset_14f}, 700);
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
	
	$modal = $("#chartModal");
	if($modal.hasClass("active")) {
		$modal.removeClass("active");
		$modal.addClass("fade");
		
	}	
	
	if(event.touches[0].pageX > 20) {
		flag = true;
		prev.x = event.touches[0].pageX;
		//e.preventDefault();	//	이벤트취소
	}
	
});

$(".carousel").bind('touchmove', function(e) {
	if(flag) {
		var event = e.originalEvent;
		current.x = event.touches[0].pageX;
		$('table.inner tr td .btn').popover('hide');

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
			seat_status = data;
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
	
	switchFlrBtn(floor);

	
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

var cData = [];
var cLabels = [];
var BGCOLOR = [
         	           	'rgba(255, 99, 132, 0.2)',
        	           	'rgba(54, 162, 235, 0.2)',
        	           	'rgba(255, 206, 86, 0.2)',
        	           	'rgba(75, 192, 192, 0.2)',
        	           	'rgba(153, 102, 255, 0.2)',
        	           	'rgba(255, 159, 64, 0.2)',
        	           	'rgba(79, 159, 64, 0.2)',
        	           	'rgba(239, 19, 234, 0.2)',
        	           	'rgba(189, 59, 24, 0.2)',
        	           	'rgba(79, 211, 184, 0.2)'
        	           ];
;

var ctx;

function setHotChart(data, labels, bgcolor) {
	
	var hotChart = new Chart(ctx, {
	    type: 'line',
	    data: {
	        labels: labels,
	        datasets: [{
	            label: '# of Votes',
	            data: data,
	            backgroundColor: BGCOLOR,
	            borderColor: BGCOLOR,
	            borderWidth: 1
	        }]
	    },
	    options: {
	        scales: {
	            yAxes: [{
	                ticks: {
	                    beginAtZero:true
	                }
	            }]
	        }
	    }
	});
}



$(document).on("ready", function() {

	
	cData = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
	cLabels = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
	
	ctx = document.getElementById("hotChart").getContext('2d');
	
	setStatus(seat_status);

	setHotChart(cData, cLabels, BGCOLOR);

});
