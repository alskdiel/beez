var sysdate = new Date().yyyymmdd_datepicker();
$('input[name="daterange"]').val(sysdate + "-" + sysdate);

var index = {
		"all": 26,
		"loc": 1,
		"date": 1
};


var pageNo = {
		"all": 2,
		"loc": 1,
		"date": 1
};


var endPageNo = {
		"all": 4,
		"loc": 1,
		"date": 1
};

var filterType = "all";
var stored_filterType = "all";

function getMoreData() {
	if(pageNo[stored_filterType] <= endPageNo[stored_filterType]) {
		var params;
		if(stored_filterType == "all") {

			params = null;
		} else if(stored_filterType == "date") {
			params = $('input[name="daterange"]').val();	
		} else {
			params = $("#entered-loc").val();
		}

		$.ajax({
			url  : "myseatajax.do" , 
			type : "get" , 
			data : { pageNo : pageNo[stored_filterType],
					 filterType: stored_filterType,
					 params: params} ,
			dataType : "json" , 
			success : function(data) {
				pageNo[stored_filterType]++;
				endPageNo[stored_filterType] = data.endPageNo;
				renderData(data.list);
			}
		});
	}	
}

$("#seat-history-filter").on("click", function() {
	$filterBody = $("#filter-body");
	if($filterBody.hasClass("validated")) {
		$("#filter-body").removeClass("validated");
		setTimeout(function() {
			$("#filter-body .filter-container").css("display", "none");	
		}, 200);
		
	} else {
		$("#filter-body").addClass("validated");
		setTimeout(function() {
			$("#filter-body .filter-container").css("display", "block");	
		}, 200);
		
		
	}
});

var prev_filterType;

function setFilterType(selected) {
	prev_filterType = filterType;
	filterType = selected;
	
	$filter_type = $(".filter-container .dropdown #filter-type");
	$filter_content = $(".filter-container .filter-content");
	
	var type = ""
	if(selected == "loc") {
		type = "위치";
	} else if(selected == "date") {
		type = "날짜";
	} else {
		stored_filterType = filterType;
		type = "전체보기";
	}
	type += "<span class='caret'></span>";
	changeFilterContent($filter_content, selected);
	
	if(selected == "all" && stored_data) {
		$("#table-seat-history tbody").html(stored_data);
		resetPageNo();
	}

	$(".filter-container .dropdown #filter-type").html(type);
}

function changeFilterContent(contents, changeTo) {
	for(var i=0; i<contents.length; i++) {
		$(contents[i]).css("display", "none");
		
		if($(contents[i]).hasClass(changeTo)) {
			$(contents[i]).css("display", "inline-block");
		}
	}
}

var flag = true;
$(document).on("scroll", function() {
	if($(window).scrollTop() + window.innerHeight == $(document).height()) {
		flag = false;
		getMoreData();
	}
});


function renderData(data) {
	var building_name;
	var floor_num;
	var seat_real_location;
	var seat_id;
	var seated_Date;
	
	var toRender = "";
	for(var i=0; i<data.length; i++) {
		building_name = data[i].building_name;
		floor_num = data[i].floor_num;
		seat_real_location = data[i].seat_real_location;
		seat_id = data[i].seat_id;
		seated_Date = new Date(data[i].seated_Date).yyyymmdd();
		
		toRender += "<tr>" +
				"<td>" + index[stored_filterType]++ + "</td>" +
				"<td>" + building_name + " </br> " + floor_num + "F / " + seat_real_location + "</td>" +
				"<td>" + seat_id + "</td>" +
				"<td>" + seated_Date + "</td>" +
				"</tr>";
	}

	$("#table-seat-history tbody").append(toRender);
	
	flag = true;
}


$(function() {
	$('input[name="daterange"]').daterangepicker();
});

$("#icon-search").on("click", function() {
	stored_filterType = filterType;
	
	if(prev_filterType == "all" && !stored_data) {
		stored_data = $("#table-seat-history tbody").html();
	}
	
	$("#table-seat-history tbody").empty();
	resetPageNo();
	getMoreData();
});

function resetPageNo() {
	pageNo["loc"] = pageNo["date"] = 1;
	index["loc"] = index["date"] = 1;
}
var stored_data;
