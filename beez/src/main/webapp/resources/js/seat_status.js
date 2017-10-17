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
	
	var prev = {};
	var current = {};
	var flag = false;
	
	$(".carousel").bind('touchstart', function(e) {
		console.log("xxxxx");
		if(event.touches[0].pageX > 40) {
			flag = true;
			prev.x = event.touches[0].pageX;
			//e.preventDefault();	//	이벤트취소
		}
		
	});

	$(".carousel").bind('touchmove', function(e) {
		console.log("yyyy");
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
	
	function toggleNavTabs($element, type) {
		if(type == 'A') {
			$element.children("li:nth-child(1)").addClass("active");
			$element.children("li:nth-child(2)").removeClass("active");
		} else {
			$element.children("li:nth-child(2)").addClass("active");
			$element.children("li:nth-child(1)").removeClass("active");
		}
	}

	
	
	
	/*
	$('.mleft').on("click", function() {
		console.log("xx");
		//$('#carousel-example-generic').carousel('prev');
		$('#carousel-example-generic').prev();
	});

	$('.mright').on("click", function() {
		console.log("yy");
		$('#carousel-example-generic').next();
	});
*/
});

