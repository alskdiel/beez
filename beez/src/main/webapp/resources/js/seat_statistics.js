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
	var cData = [[1, 2, 3, 4, 5, 6],
	             [11, 12, 13, 14, 15, 16],
	             [21, 22, 23, 24, 25, 26],
	             [31, 32, 33, 34, 35, 36],
	             [41, 42, 43, 44, 45, 46],
	             [51, 52, 53, 54, 55, 56],
	             [61, 62, 63, 64, 65, 66],
	             [71, 72, 73, 74, 75, 76],
	             [81, 82, 83, 84, 85, 86],
	             [91, 92, 93, 94, 95, 96]];
	var cLabels = [["a1", "b1", "c1", "d1", "e1", "f1"],
	               ["a2", "b2", "c2", "d2", "e2", "f2"],
	               ["a3", "b3", "c3", "d3", "e3", "f3"],
	               ["a4", "b4", "c4", "d4", "e4", "f4"],
	               ["a5", "b5", "c5", "d5", "e5", "f5"],
	               ["a6", "b6", "c6", "d6", "e6", "f6"],
	               ["a7", "b7", "c7", "d7", "e7", "f7"],
	               ["a8", "b8", "c8", "d8", "e8", "f8"],
	               ["a9", "b9", "c9", "d9", "e9", "f9"],
	               ["a0", "b0", "c0", "d0", "e0", "f0"]];
	
	
	function setChart() {
		getChartData("fav", "year");
		for(var i=0; i<10; i++) {
			setHotChart(i, cData[i], cLabels[i], BGCOLOR[i]);
		}
	}
	
	var ctx_f = document.getElementById("favChart").getContext('2d');
	function setFavChart(data, labels, bgColor) {
		console.log(bgColor);
		var favChart = new Chart(ctx_f,{
		    type: 'pie',
		    data: {
		    	datasets: [{
			        data: data,
			        backgroundColor: bgColor
			    }],

			    // These labels appear in the legend and in the tooltips when hovering different arcs
			    labels: labels,
			    
		    }
		    //options: options
		});
	}
	var ctx_h = [
	             document.getElementById("hotChart-1").getContext('2d'),
	             document.getElementById("hotChart-2").getContext('2d'),
	             document.getElementById("hotChart-3").getContext('2d'),
	             document.getElementById("hotChart-4").getContext('2d'),
	             document.getElementById("hotChart-5").getContext('2d'),
	             document.getElementById("hotChart-6").getContext('2d'),
	             document.getElementById("hotChart-7").getContext('2d'),
	             document.getElementById("hotChart-8").getContext('2d'),
	             document.getElementById("hotChart-9").getContext('2d'),
	             document.getElementById("hotChart-10").getContext('2d')
	            ];

	function setHotChart(chartnum, data, labels, bgcolor) {
		
		var hotChart = new Chart(ctx_h[chartnum], {
		    type: 'line',
		    data: {
		        labels: labels,
		        datasets: [{
		            label: '# of Votes',
		            data: data,
		            backgroundColor: bgcolor,
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
				console.log(data);
				var dataArr = [];
				var labels = [];
				var bgcolor = [];
				for(var i=0; i<data.length; i++) {
					dataArr.push(data[i].CNT);
					labels.push(data[i].SEAT_NAME);
					bgcolor.push(BGCOLOR[i]);
				}
				setFavChart(dataArr, labels, bgcolor)
			}
		});
		
	}

	setChart();
	
	
});

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
]