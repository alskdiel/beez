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

$(document).on("ready", function() {
	$offset_9f = $("#floor-9").offset().top - 35;
	$offset_10f = $("#floor-10").offset().top - 35;
	$offset_13f = $("#floor-13").offset().top - 35;
	$offset_14f = $("#floor-14").offset().top - 35;

	
	
	
	
	//setStatus(dummies);
	/*
	setTimeout(function() { 
    	setStatus(seat_status);
	}, 1000);
	*/
	
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
});

var dummies =
	[{"floor": 9,
	  "data": [
	           {"section": "A",
		  		"data": {
		  			"disabled": [1, 2, 3, 4],
		  			"inuse": [5, 6, 7, 8]}},
		  	   {"section": "B",
		  		"data": {
		  			"disabled": [5, 6, 7, 8],
		  			"inuse": [1, 2, 3, 4]}}
		  	  ]
	 },
	 
	 
	 {"floor": 10,
	  "data": [
	           {"section": "A",
			  	"data": {
			  		"disabled": [1, 2, 3, 4],
			  		"inuse": [5, 6, 7, 8]}},
			   {"section": "B",
		  		"data": {
		  			"disabled": [5, 6, 7, 8],
		  			"inuse": [1, 2, 3, 4]}}
			  ]
	},
	 
	 
	 {"floor": 13,
	  "data": [
	           {"section": "A",
			  	"data": {
			  		"disabled": [1, 2, 3, 4],
			  		"inuse": [5, 6, 7, 8]}},
			   {"section": "B",
		  		"data": {
		  			"disabled": [5, 6, 7, 8],
		  			"inuse": [1, 2, 3, 4]}}
			  ]
	},
	 
	 
	 {"floor": 14,
	  "data": [
	           {"section": "A",
			  	"data": {
			  		"disabled": [1, 2, 3, 4],
			  		"inuse": [5, 6, 7, 8]}},
			   {"section": "B",
		  		"data": {
		  			"disabled": [5, 6, 7, 8],
		  			"inuse": [1, 2, 3, 4]}}
			  ]
	}];