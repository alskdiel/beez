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
function toggleSidebar() {
	$body = $("body");
	if($body.hasClass("sidebar-open")) {
		$body.removeClass("sidebar-open");
	} else {
		$body.addClass("sidebar-open");
	}
}


$(document).on("ready", function() {
	
	var prev = {};
	var current = {};
	var flag = false;
	$(".content-wrapper").bind('touchstart', function(e) {


		console.log("touch started");
		
		console.log("page");
		if(event.touches[0].pageX < 30) {
			flag = true;
			prev.x = event.touches[0].pageX;
			
			console.log(prev.x);
			e.preventDefault();	//	이벤트취소

		} else {
			console.log("x more than 30");
		}

	});

	
	$(".content-wrapper").bind('touchmove', function(e) {
		if(flag) {
			var event = e.originalEvent;
	/*
			console.log("screen");
			console.log(event.touches[0].screenX);
			console.log(event.touches[0].screenY);
	
			console.log("page");
			console.log(event.touches[0].pageX);
			console.log(event.touches[0].pageY);
			
			console.log("client");
			console.log(event.touches[0].clientX);
			console.log(event.touches[0].clientY);
	*/	
			current.x = event.touches[0].pageX;
			
			event.preventDefault();
		} else {
			console.log("x more than 20");
		}
	});

	$(".content-wrapper").bind('touchend', function(e) {
		if(flag) {
			console.log("터치이벤트가 종료되었어요"); 
			
			console.log(current.x);
			chkSlideScale();
		} else {
			console.log("x more than 20");
		}
	});


	function chkSlideScale() {
		if((current.x - prev.x) > 100) {
			console.log("enough");
			$body = $("body");
			toggleSidebar();
/*
			if(!$body.hasClass("sidebar-open")) {
				$body.addClass("sidebar-open");
			}
*/
		} else {
			console.log("not enough");
		}
		flag = false;
	}
});