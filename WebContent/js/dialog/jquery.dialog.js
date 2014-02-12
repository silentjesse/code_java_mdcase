//document.documentElement.scrollHeight;
jQuery.extend({
    // ∂®“ÂsetApDiv
    dialog:function (divid) {  
    	//document.body.appendChild(ds.script);
    	
    	//1°¢create  gray div for bottom 
    	var div_graybg = document.createElement("div");
    	div_graybg.style = "position: absolute;text-align: center;z-index: 9998;display: none;width: 100%;height: 100%;";
    	div_graybg.style +=  "opacity: 0.2; background: none repeat scroll 0% 0% rgb(0, 0, 0);";
    	
    	var height = document.documentElement.scrollHeight;
    	var width = document.documentElement.scrollWidth;
    	
    	div_graybg.style.height = height;
    	div_graybg.style.width = width;
    	
    	//2°¢create a div on the above of gray div 
    	//position: absolute;text-align: center;z-index: 9999;display: none;width: 100%;height: 100%;background-image: url('images/transbg.gif');
    	var div_tran = document.createElement("div");
    	div_tran.style = "position: absolute;text-align: center;z-index: 9999;display: none;width: 100%;height: 100%;background-image: url('transbg.gif');";
    	div_tran.style.height = height;
    	div_tran.style.width = width;
    	
    	var showdiv = document.getElementById(divid);
    	showdiv.style.zIndex = 10000;
    	 
    	div_tran.appendChild(showdiv);
    	div_graybg.appendChild(div_tran);
    	document.body.appendChild(div_graybg);
    }
 }); 
