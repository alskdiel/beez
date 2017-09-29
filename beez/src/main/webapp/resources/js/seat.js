var pageNo = 2;

$("#myseat").on("click", function() {
	
	if(pageNo <= $("#endPageNo").val()) {
		$.ajax({
			url  : "myseatajax.do" , 
			type : "get" , 
			data : { pageNo : pageNo } ,
			dataType : "json" , 
			success : function(data) {
				console.log(data);
				pageNo++;
			}
		});
	} else {
		console.log('data end');
	}
	
});