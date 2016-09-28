/*
 * website
 * EDIT.ERIC.20151217
 * Version: 1.3.0
 * Author: SIMBA
 */



(function($){
		
	//轮播重置
	function sliderInit(){
		var ths = $(this),
			$thsUl = ths.prev(".demo-list"),
			$thsLi = $thsUl.find("li.clear"),
			$thsSpan = $thsLi.find("span"),
			$thsIpt = $thsLi.find("input"),
			param = {};
		for(var i = 0, len = $thsLi.size(); i < len; i ++){
			var paramName = $thsSpan.eq(i).text().split("(")[0],
				paramVal = $thsIpt.eq(i).val();
			param[paramName] = paramVal;
		}
		$("#slider").slider(param);
	}
	$("#slider_a").on("click",sliderInit);

	//弹出框（确认框，提示框）

	$("#pop1").on("click",function(){
		popUpWindow({
			title : "<p>111111</p>",
			popType : 1,
			callback : function(){
				console.log(111);
			}
		});
	});
	$("#pop2").on("click",function(){
		popUpWindow({
			title : "操作成功！",
			closeTime : 1000,
			popType : 2
		});
	});
	$("#pop3").on("click",function(){
		popUpWindow({
			title : "操作成功！",
			popType : 3
		});
	});
})(jQuery);  