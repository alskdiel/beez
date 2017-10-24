var prev = {};
var current = {};
var flag = false;
var isFirstPage = true;

$(".carousel").bind('touchstart', function(e) {
	if(event.touches[0].pageX > 40) {
		flag = true;
		prev.x = event.touches[0].pageX;
	}
	
});

$(".carousel").bind('touchmove', function(e) {
	if(flag) {
		var event = e.originalEvent;
		current.x = event.touches[0].pageX;			
	}
});

$(".carousel").bind('touchend', function(e) {
	var $element = $(this).parent().children(".nav-tabs");
	
	if(flag) {
		if(current.x - prev.x < -40 && isFirstPage) {
			$(this).carousel('next');
			isFirstPage = false;
			toggleNavTabs($element, 'hot');
		} else if(current.x - prev.x > 40 && !isFirstPage) {
			$(this).carousel('prev');
			isFirstPage = true;
			toggleNavTabs($element, 'fav');
		}
	}
	flag = false;
});




$(".nav.nav-tabs li").on("click", function() {
	var $tab = $(this);
	
	if($tab.text() == 'FAVORITE') {
		isFirstPage = true;
	} else {
		isFirstPage = false;
	}
});


function toggleNavTabs($element, type) {	
	if(type == 'fav') {
		$element.children("li:nth-child(1)").addClass("active");
		$element.children("li:nth-child(2)").removeClass("active");
	} else {
		$element.children("li:nth-child(2)").addClass("active");
		$element.children("li:nth-child(1)").removeClass("active");
	}
}

$(".filter-container .year").on("click", function() {
	var $this = $(this);
	var type;
	if($this.hasClass("fav")) {
		type = "fav";
	} else {
		type = "hot";
	}
	$this.parent().find(".month").removeClass("active");
	$this.addClass("active");
	
	getChartData(type, "year");
});

$(".filter-container .month").on("click", function() {
	var $this = $(this);
	var type;
	if($this.hasClass("fav")) {
		type = "fav";
	} else {
		type = "hot";
	}
	$this.parent().find(".year").removeClass("active");
	$this.addClass("active");
	
	getChartData(type, "month");
});


function getChartData(type, sub_type) {
	console.log(type);
	console.log(sub_type);
	
	$.ajax({
		url  : "statistics.do" , 
		type : "get" , 
		data : { type: type,
				 sub_type: sub_type },
		dataType : "json" , 
		success : function(data) {
			
		}
	});
	
}



/*
$('#datepicker-f-f').datepicker();
$('#datepicker-f-t').datepicker();
$('#datepicker-h-f').datepicker();
$('#datepicker-h-t').datepicker();
*/
/*
$(".icon-search").on("click", function() {
	var type;
	var from;
	var to;
	
	if($(this).hasClass("fav")) {
		type = "fav";
		from = $(this).parent().find("#datepicker-f-f").val();
		to = $(this).parent().find("#datepicker-f-t").val();
	} else {
		type = "hot";
		from = $(this).parent().find("#datepicker-h-f").val();
		to = $(this).parent().find("#datepicker-h-t").val();	
	}
	
	if(!from || !to) {
		alert("날짜를 선택해주세요.");
	} else {
		console.log(type);
		console.log(from);
		console.log(to);
	}
});
*/


$(document).on("ready", function() {
	setChart();
	
	function setChart() {
		setFavChart();
		setHotChart();
	}
	
	function setFavChart() {
		var ctx_f = document.getElementById("favChart").getContext('2d');
		
		var favChart = new Chart(ctx_f,{
		    type: 'pie',
		    data: {
		    	datasets: [{
			        data: [10, 20, 30]
			    }],

			    // These labels appear in the legend and in the tooltips when hovering different arcs
			    labels: [
			        'Red',
			        'Yellow',
			        'Blue'
			    ]
		    }
		    //options: options
		});
	}
	
	function setHotChart() {
		var ctx_h = document.getElementById("hotChart").getContext('2d');

		var hotChart = new Chart(ctx_h, {
		    type: 'bar',
		    data: {
		        labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
		        datasets: [{
		            label: '# of Votes',
		            data: [12, 19, 3, 5, 2, 3],
		            backgroundColor: [
		                'rgba(255, 99, 132, 0.2)',
		                'rgba(54, 162, 235, 0.2)',
		                'rgba(255, 206, 86, 0.2)',
		                'rgba(75, 192, 192, 0.2)',
		                'rgba(153, 102, 255, 0.2)',
		                'rgba(255, 159, 64, 0.2)'
		            ],
		            borderColor: [
		                'rgba(255,99,132,1)',
		                'rgba(54, 162, 235, 1)',
		                'rgba(255, 206, 86, 1)',
		                'rgba(75, 192, 192, 1)',
		                'rgba(153, 102, 255, 1)',
		                'rgba(255, 159, 64, 1)'
		            ],
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
	

});