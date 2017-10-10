Date.prototype.yyyymmdd = function() {
	var mm = this.getMonth() + 1; // getMonth() is zero-based
	var dd = this.getDate();
	var hr = this.getHours();
	var min =this.getMinutes();
	  
	return [this.getFullYear() + "/",
	        (mm>9 ? '' : '0') + mm + "/",
	        (dd>9 ? '' : '0') + dd + " ",
	        hr + ":", min+""
	].join('');
};
	
	
Date.prototype.yyyymmdd_datepicker = function() {
	  var mm = this.getMonth() + 1; // getMonth() is zero-based
	  var dd = this.getDate();

	  return [(mm>9 ? '' : '0') + mm + "/",
	          (dd>9 ? '' : '0') + dd + "/",
	          this.getFullYear()
	         ].join('');
	};
