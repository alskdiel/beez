var $side_bar_close_btn = $(".main-sidebar .user-panel .beez-logo-right");

$side_bar_close_btn.on("click", function() {
	$body = $("body");
	if($body.hasClass("sidebar-open")) {
		$body.removeClass("sidebar-open");
	}
});