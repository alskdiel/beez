var data_cal;
function setCalData(data_cal, date) {
	this.data_cal = data_cal;

	
	drawCalendar(date);
}

function pad(d) {
    return (d < 10) ? '0' + d.toString() : d.toString();
}

function getCalendar(date_to_get) {
	var to_send = date_to_get.split("-");
	var date = {};
	date.from = pad(to_send[1]) + "/01/" + to_send[0];
	date.to = pad((parseInt(to_send[1]) + 1)) + "/01/" + to_send[0];
	
	
	$.ajax({
		url  : "myattendAjax.do" , 
		type : "get" , 
		data : { from: date.from,
				 to: date.to } ,
		dataType : "json" , 
		success : function(data) {
			data_cal = data.data_cal;
			
			data_cal_yr = data.data_cal_yr;
			data_cal_mon = data.data_cal_mon;
			
			setCalData(data_cal, data_cal_yr+"-"+data_cal_mon+"-01");
		}
	});
}


function drawCalendar(date) {
	var id = "canvas-calendar";
	
	var kCalendar = document.getElementById(id);

	if( typeof( date ) !== 'undefined' ) {
	date = date.split('-');
	date[1] = date[1] - 1;
	date = new Date(date[0], date[1], date[2]);
	} else {
	var date = new Date();
	}
	var currentYear = date.getFullYear();
	//년도를 구함

	var currentMonth = date.getMonth() + 1;
	//연을 구함. 월은 0부터 시작하므로 +1, 12월은 11을 출력

	var currentDate = date.getDate();
	//오늘 일자.

	date.setDate(1);
	var currentDay = date.getDay();
	//이번달 1일의 요일은 출력. 0은 일요일 6은 토요일

	var dateString = new Array('sun', 'mon', 'tue', 'wed', 'thu', 'fri', 'sat');
	var lastDate = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
	if( (currentYear % 4 === 0 && currentYear % 100 !== 0) || currentYear % 400 === 0 )
	lastDate[1] = 29;
	//각 달의 마지막 일을 계산, 윤년의 경우 년도가 4의 배수이고 100의 배수가 아닐 때 혹은 400의 배수일 때 2월달이 29일 임.

	var currentLastDate = lastDate[currentMonth-1];
	var week = Math.ceil( ( currentDay + currentLastDate ) / 7 );
	//총 몇 주인지 구함.

	if(currentMonth != 1)
	var prevDate = currentYear + '-' + ( currentMonth - 1 ) + '-' + currentDate;
	else
	var prevDate = ( currentYear - 1 ) + '-' + 12 + '-' + currentDate;
	//만약 이번달이 1월이라면 1년 전 12월로 출력.

	if(currentMonth != 12) 
	var nextDate = currentYear + '-' + ( currentMonth + 1 ) + '-' + currentDate;
	else
	var nextDate = ( currentYear + 1 ) + '-' + 1 + '-' + currentDate;
	//만약 이번달이 12월이라면 1년 후 1월로 출력.


	if( currentMonth < 10 )
	var currentMonth = '0' + currentMonth;
	//10월 이하라면 앞에 0을 붙여준다.

	var calendar = '';

	calendar += '<div id="header" class="calendar-header">';
	calendar += '			<span><a href="#" onclick="getCalendar(\'' + prevDate + '\')"><i class="fa fa-chevron-left" aria-hidden="true"></i></a></span>';
	calendar += '			<span id="date">' + currentYear + '년 ' + currentMonth + '월</span>';
	calendar += '			<span><a href="#" onclick="getCalendar(\'' + nextDate + '\')"><i class="fa fa-chevron-right" aria-hidden="true"></i></a></span>';
	calendar += '		</div>';
	calendar += '		<table border="0" cellspacing="0" cellpadding="0">';
	calendar += '			<thead>';
	calendar += '				<tr>';
	calendar += '					<th class="sun" scope="row sun">일</th>';
	calendar += '					<th class="mon" scope="row">월</th>';
	calendar += '					<th class="tue" scope="row">화</th>';
	calendar += '					<th class="wed" scope="row">수</th>';
	calendar += '					<th class="thu" scope="row">목</th>';
	calendar += '					<th class="fri" scope="row">금</th>';
	calendar += '					<th class="sat" scope="row sat">토</th>';
	calendar += '				</tr>';
	calendar += '			</thead>';
	calendar += '			<tbody>';

	var dateNum = 1 - currentDay;

	for(var i = 0; i < week; i++) {
		calendar += '			<tr>';
		for(var j = 0; j < 7; j++, dateNum++) {
			if( dateNum < 1 || dateNum > currentLastDate ) {
				calendar += '				<td class="' + dateString[j] + '"> </td>';
				continue;
			}
			var inner_box = "<div class='info-day'>"
						  + 	"<div class='info-day-header'>" + dateNum + "</div>"
						  + 	"<div class='info-day-content'>";
			if(data_cal[dateNum] != null) {
				inner_box +=		"<div class='arrive'>"
						  +				data_cal[dateNum].arrive
						  + 		"</div>"
						  + 		"<div class='leave'>"
						  +				(data_cal[dateNum].leave? data_cal[dateNum].leave: "")
						  + 		"</div>"
			}
						  + 	"</div>"
						  + "</div>"
			calendar += '				<td class="' + dateString[j] + '">' + inner_box + '</td>';
		}
		calendar += '			</tr>';
	}

	calendar += '			</tbody>';
	calendar += '		</table>';

	kCalendar.innerHTML = calendar;
}