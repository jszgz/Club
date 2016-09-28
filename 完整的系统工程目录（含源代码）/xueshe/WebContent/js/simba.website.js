/*
 * 网站常用效果插件
 * EDIT.ERIC.20150806
 * Version: 1.3.0
 * Author: SIMBA
 */

(function($){

	//截取字符串 //EDIT.ERIC.20150114
	$.fn.limit = function(num){
		var objString = $(this).text();
		var objSize = objString.length;

		if(objSize > num){
			$(this).attr("title",objString);
			objString = $(this).text(objString.substring(0,num) + "...");
		};
	};
	//-------html
	$.each($("*[e-fun = limit]"),function(i){
		$("*[e-fun = limit]").eq(i).limit($("*[e-fun = limit]").eq(i).attr("e-num"));
	});

	//Tab菜单切换  EDIT.ERIC.20150806
	$.fn.tab = function(options) {

		//num:默认显示第几个nav,ent:事件：click/mouseover/touchend,choo:导航选中时的class

		options = $.extend({  
	        num  : 0,       //默认显示  
	        ent  : "click", //默认响应事件  
	        choo : "choo"  //选中的类名   
	    },options || {});  
		
		var ths = this;//解决this指向问题

		//初始化
		ths.find("*[e-tab-nav]").hide();
		ths.find("*[e-tab-nav]").eq(options.num).show();
		ths.find("*[e-tab-for]").eq(options.num).addClass(options.choo);

		//事件绑定
		ths.on(options.ent,"*[e-tab-for]",function(){
			var thisFor = $(this).attr("e-tab-for");
			ths.find("*[e-tab-for]").removeClass(options.choo);
			$(this).addClass(options.choo);
			ths.find("*[e-tab-nav]").hide();
			$("*[e-tab-nav =" + thisFor + "]").show();
		});
	};

	//-------html
	$.each($("*[e-fun = tab]"),function(i){
		var num = $("*[e-fun = tab]").eq(i).attr("e-index"),
			ent = $("*[e-fun = tab]").eq(i).attr("e-event"),
			choo = $("*[e-fun = tab]").eq(i).attr("e-class");
		$("*[e-fun = tab]").eq(i).tab({num:num,ent:ent,choo:choo});
	});

	//下拉选择   EDIT.SIMBA.20150806
	$.fn.dropBox = function(opts){

		opts = $.extend({  
			tapType: "click", //默认的点击方式---click,touchend
	            n  : 0,       //默认value初始值  
	        ntype  : "name",  //提交的input值得value值    
	        speed  : 100,     //下拉框下拉或收起的速度
	        li_lineH : 30, 	  //下拉项行高
	        ul_bg : "#fff"	  //下拉项背景
	    },opts || {});  

		var ths = this;//解决this指向问题

		var init = function(){
			var thsW = ths.width(),
				thsH = ths.height();
			ths.css({
				"position" : "relative",
				"border" : "1px solid #d3d3d3"
			});
			ths.find("input").css({
				"float" : "left",
				"padding" : "5px",
				"width" : thsW - thsH - 10 + "px",
				"height" : thsH - 10 + "px",
				"line-height" : thsH - 10 + "px",
				"font-family": "Microsoft YaHei",
				"border-radius" : "5px"
			});
			ths.find("i").css({
				"float" : "left",
				"width" : thsH - 1 + "px",
				"height" : thsH + "px",
				"line-height" : thsH + "px",
				"border-left" : "1px solid #d3d3d3",
				"cursor" : "pointer"
			});
			ths.find("ul").css({
				"position" : "absolute",
				"top" : thsH + "px",
				"left" : -1,
				"display" : "none",
				"width" : thsW + "px",
				"background-color" : opts.ul_bg,
				"border" : "1px solid #d3d3d3",
				"z-index" : "100"
			});
			ths.find("ul li").css({
				"line-height" : opts.li_lineH + "px",
				"padding-left" : "5px",
				"cursor" : "pointer"
			});
		}
		init();
		//每个选项赋值value
		for(var i = 0, len = ths.find("ul li").length; i < len; i ++){
			ths.find("ul li").eq(i).prop("value",opts.n);
			opts.n ++;
		};
		//绑定事件---下拉收起事件
		ths.on(opts.tapType,function(){
			$('*[e-fun = dropBox]').find("ul").stop().slideUp(50);
			ths.find("ul").stop().slideToggle(opts.speed);
		})//下拉项选择
		.on("click","li",function(){
			var _this = $(this),
				thsText = _this.text(),
				thsVal = _this.prop("value");
			ths.find("input").val(thsText).prop("name",thsVal).attr("value",thsText);
		});

		//点击页面其他地方下拉框收起
		$(document).on(opts.tapType,function(event){
	        var eo = $(event.target);
	        if(ths.find("ul").is(":visible") && eo.parents("[e-fun]").attr("e-fun")!="dropBox"){
	        	ths.find("ul").stop().slideUp(opts.speed);  
	        };
	                                            
	    });

	};
	//----------Html
	$.each($('*[e-fun = dropBox]'),function(i){
		var n = $('*[e-fun = dropBox]').eq(i).attr("e-val");
		var type = $('*[e-fun = dropBox]').eq(i).attr("e-type");
		var speed = $('*[e-fun = dropBox]').eq(i).attr("e-speed");
		var tapType = $('*[e-fun = dropBox]').eq(i).attr("e-tap-type");
		$('*[e-fun = dropBox]').eq(i).dropBox({n:n,ntype:type,speed:speed,tapType:tapType});
	});

	//弹出框  EDIT.SIMBA.2015.8.07
	$.fn.pop = function(opts){
		opts = $.extend({
			tapType    : "click",     		 //默认的点击方式---click,touchend
			popFor     : "e-pop"	   		 //弹出框的e-pop-box值
		},opts || {});

		var ths = this;//解决this指向问题

		//弹出
		ths.on("click",function(){
			$("*[e-pop-box="+ opts.popFor + "],*[e-pop-bg]").show();
		});

		//关闭
		$('*[e-pop-close]').on("click",function(){
			var thisFor = $(this).attr("e-pop-close");
			$("*[e-pop-box=" + thisFor + "],*[e-pop-bg]").hide();
		});

	};
	//----------Html
	$.each($('*[e-pop-for]'),function(i){
		var popFor = $('*[e-pop-for]').eq(i).attr("e-pop-for");
		var tapType = $('*[e-pop-for]').eq(i).attr("e-tap-type");
		$('*[e-pop-for]').eq(i).pop({popFor:popFor,tapType:tapType});
	});


	//多选  EDIT.SIMBA.2015.08.10
	$.fn.check = function(opts){
		opts = $.extend({
			tapType    :  "click",     				  //默认的点击方式---click,touchend
			checkSrc   :  "./images/e-check.png",     //显示的默认图片
			checkedSrc :  "./images/e-checked.png"	  //选中后显示的图片
		},opts || {});

		var ths = this;//解决this指向问题


		var $checkAll = ths.find("*[e-check-all]");
		var $checkOne = ths.find("*[e-check-one]");

		//全选
		$checkAll.on(opts.tapType,function(){
			//自身check改变
			var thischeck = $(this).attr("e-check") == 0 ? 1 : 0;
			$(this).attr("e-check",thischeck);
			//所有单选check改变
			$checkOne.attr("e-check",thischeck);

			//图片链接替换
			checkSrcChange(thischeck,ths.find("*[e-check]"));
		});

		//单选
		$checkOne.on(opts.tapType,function(){
			//自身check改变
			var thischeck = $(this).attr("e-check") == 0 ? 1 : 0;
			$(this).attr("e-check",thischeck);

			//图片链接替换
			checkSrcChange(thischeck,$(this));
			
			//遍历所有单选 判断是否全选
			var checkOneSize = $checkOne.size();
			var checkedOneSize = ths.find("*[e-check-one][e-check=1]").size();

			if(checkOneSize == checkedOneSize){
				$checkAll.attr("e-check",1);
				checkSrcChange(1,$checkAll);
			}else{
				$checkAll.attr("e-check",0);
				checkSrcChange(0,$checkAll);
			}

		});

		//替换图片
		var checkSrcChange = function(check,obj){
			if(check == 1){
				obj.find("img").attr("src",opts.checkedSrc);
			}else{
				obj.find("img").attr("src",opts.checkSrc);
			}
		};

	};
	//----------Html
	$.each($('*[e-fun = check]'),function(i){
		var checkSrc = $('*[e-fun = check]').eq(i).attr("e-check-src");
		var checkedSrc = $('*[e-fun = check]').eq(i).attr("e-checked-src");
		var tapType = $('*[e-fun = check]').eq(i).attr("e-tap-type");
		$('*[e-fun = check]').eq(i).check({checkSrc:checkSrc,checkedSrc:checkedSrc,tapType:tapType});
	});


	//单选  EDIT.SIMBA.2015.08.10
	$.fn.radio = function(opts){
		opts = $.extend({
			tapType     :  "click",     			  //默认的点击方式---click,touchend
			radiusSrc   :  "./images/e-radio.png",	  //显示的默认图片
			radiusedSrc :  "./images/e-radioed.png"  //选中后显示的图片
		},opts || {});
		
		var ths = this;//解决this指向问题

		var $radio = ths.find("*[e-radio]");

		$radio.on(opts.tapType,function(){
			ths.find("*[e-check]").attr("e-check",0);
			//自身check改变
			var thischeck = $(this).attr("e-check") == 0 ? 1 : 0;
			$(this).attr("e-check",thischeck);
			//替换所有的图片
			radiusSrcChange(0,ths.find("*[e-check]"));
			//替换当前点击图片
			radiusSrcChange(thischeck,$(this));
		});

		//替换图片
		var radiusSrcChange = function(check,obj){
			if(check == 1){
				obj.find("img").attr("src",opts.radiusedSrc);
			}else{
				obj.find("img").attr("src",opts.radiusSrc);
			}
		};
	}
	//----------Html
	$.each($('*[e-fun = radio]'),function(i){
		var radiusSrc = $('*[e-fun = radio]').eq(i).attr("e-radio-src");
		var radiusedSrc = $('*[e-fun = radio]').eq(i).attr("e-radio-src");
		var tapType = $('*[e-fun = radio]').eq(i).attr("e-tap-type");
		$('*[e-fun = radio]').eq(i).radio({radiusSrc:radiusSrc,radiusedSrc:radiusedSrc,tapType:tapType});
	});

	//类锚点  回到顶部  EDIT.SIMBA.2015.08.14
	$.fn.anchor = function(opts){
		opts = $.extend({
			tapType   	     :  "click",     	//默认的点击方式---click,touchend
			speed     	     :  500, 			//回到顶部的速度
			minHeight 	     :  0,			    //回到顶部按钮出现的最小高度
			forID            :  null
		},opts || {});
		var ths = this;//解决this指向问题
		ths.on(opts.tapType,function(){
			var h = 0;
			if(opts.forID == null || opts.forID == ""){
				h = 0;
			}else{
				h = $("#" + opts.forID).getTop();
			}

			$(this).siblings().removeClass("choo");
			$(this).addClass("choo");
			
			$('html,body').animate({scrollTop:h},opts.speed);
		});

	    //为窗口的scroll事件绑定处理函数
	    $(window).scroll(function(){
	        //获取窗口的滚动条的垂直位置
	        var s = $(window).scrollTop();
	        //当窗口的滚动条的垂直位置大于页面的最小高度时，让返回顶部元素渐现，否则渐隐
	        if( s >= opts.minHeight){
	            ths.fadeIn(100);
	        }else{
	            ths.fadeOut(200);
	        };
	    });
	}
	//参数转换
	$.fn.styleConversion = function(){
		var ths = $(this);
		var date = ths.attr("e-style");
		var dateJosn =  eval('(' + date + ')');
		return dateJosn;
	}
	//----------Html
	$.each($('*[e-fun = anchor]'),function(i){
		var date = $('*[e-fun = anchor]').eq(i).attr("e-for");
		$('*[e-fun = anchor]').eq(i).anchor({forID : date});
	});

	//获取元素的纵坐标（相对于窗口）
	$.fn.getTop = function(e){
		var ths = $(this)[0];
		var offset = ths.offsetTop;
		var init = function(e){
			if(e.offsetParent != null){
				offset += e.offsetParent.offsetTop;
				init(e.offsetParent);
			};
		}
		init(ths);
		return offset;
	}
	//----------Html


	//轮播   EDIT.SIMBA.2015.12.15
	$.fn.slider = function(opts){

		opts = $.extend({
			imgW : 0,  //轮播图片的宽度
			imgH : 0,  //轮播图片的高度
			timeout : "3000",	//轮播间隔时间
			moveTime : 500, //动画时间
			autoSlider : true, //是否自动轮播
			moveStyle : "slide", //动画效果  slide ：滑动， fade ：渐隐渐现
			addTag : true,	//是否创建圆点标记
			tagSize : 12,
			tagDefaultBg : "#fff", //圆点标记的默认背景
			tagActiveBg : "#5638d8", // 圆点标记选中背景
			btnShow : true, //是否显示左右按钮
			btnW : 30,	//按钮的宽度
			btnH : 60,	//按钮的高度
			btnBg : "rgba(255,255,255,.6)" //左右按钮的背景
		}, opts || {});
		//
		opts.timeout = opts.timeout < 1500 ? 1500 : opts.timeout;
		//
		var ths = this,
			$imgs = ths.find("img"),
			$thsLink = ths.find("a"),
			imgSize = $imgs.size(),
			$btn,$tag,
			count = 0;
		var init = function(){
			stopSlider();
			initCss();
			ths.find(".s_btn").remove();
			ths.find(".s_tag").remove();

			paramChange("autoSlider");
			paramChange("addTag");
			paramChange("btnShow");
			if(opts.addTag){
				createTag(ths);
				$tag.find("span").eq(0).css({"background-color" : opts.tagActiveBg});
			}
			if(opts.btnShow){
				createBtn();
				$btn.on("click",function(){
					stopSlider();
					var thsIndex = $btn.index($(this));
					if(thsIndex == 1){
						imgsMove();
					}else if(thsIndex == 0){
						imgsMove("left");
					}
				});
			}
			$thsLink.eq(0).css({"left" : 0});
			$thsLink.eq(imgSize - 1).css({"left" : "-100%"});
			
			startSlider();
		},
		//变量转换
		paramChange = function(p){
			if(eval("opts." + p) == "true"){
				opts[p] = true;
			}else if(eval("opts." + p) == "false"){
				opts[p] = false;
			}
		},
		//初始化样式
		initCss = function(){
			ths.css({
				"position" : "relative",
				"height" : opts.imgH + "px",
				"overflow" : "hidden",
				"background-color" : "#fff",
				"z-index" : "9"
			});
			$thsLink.css({
				"display" : "block",
				"position" : "absolute",
				"top" : "0",
				"left" : "100%",
				"width" : "100%",
				"height" : "100%",
				"z-index" : "9"
			});
			$imgs.css({
				"width" : "100%",
				"height" : "100%"
			});
		},
		//创建左右按钮
		createBtn = function(){
			var btnTem = '<span class="s_btn"></span><span class="s_btn"></span>';
			ths.append(btnTem);
			$btn = ths.find(".s_btn");
			$btn.css({
				"position" : "absolute",
				"top" : "50%",
				"margin-top" : (-1)*opts.btnH/2 + "px",
				"width" : opts.btnW + "px",
				"height" : opts.btnH+ "px",
				"cursor" : "pointer",
				"background-color" : opts.btnBg,
				"z-index" : "10"
			});
			$btn.eq(0).css({"left" : "10px"});
			$btn.eq(1).css({"right" : "10px"});
		}
		//创建圆点标记
		createTag = function(warp){
			var tem = '<div class="s_tag"></div>';
			warp.append(tem);
			$tag = warp.find(".s_tag");
			$tag.css({
				"position" : "absolute",
				"left" : "0",
				"bottom" : "0",
				"width" : "100%",
				"height" : "40px",
				"line-height" : "40px",
				"font-size" : "0",
				"text-align" : "center",
				"z-index" : "10"
			});
			for(var i = 0; i < imgSize; i ++){
				$tag.append("<span></span>");
			}
			$tag.find("span").css({
				"display" : "inline-block",
				"margin-top" : (40 - opts.tagSize)/2 + "px", 
				"margin-left" : "5px",
				"margin-right" : "5px",
				"width" : opts.tagSize + "px",
				"height" : opts.tagSize + "px",
				"background-color" : opts.tagDefaultBg,
				"border-radius" : "9999px",
				"cursor" : "pointer"
			});
		},
		//轮播动画
		imgsMove = function(direction){
			if(opts.moveStyle == "slide"){
				if(direction == "left"){
					count --;
					count = count < 0 ? imgSize - 1 : count;
					$thsLink.eq(count).stop(true,false).animate({
						"left": 0},
						opts.moveTime, function() {
						var countR = count - 1;
						$thsLink.eq(countR).css({"left":"-100%"});
					});
					var countL = count + 1 == imgSize ? 0 : count + 1 ;
					$thsLink.eq(countL).stop(true,true).animate({"left": "100%"},opts.moveTime);
				}else{
					count ++;
					count = count == imgSize ? 0 : count;
					$thsLink.eq(count).stop(true,false).animate({
						"left": 0},
						opts.moveTime, function() {
						var countR = (count == imgSize - 1 ? -1 : count) + 1;
						$thsLink.eq(countR).css({"left":"100%"});
					});
					$thsLink.eq(count-1).stop(true,true).animate({"left": "-100%"},opts.moveTime);
				}
			}else if(opts.moveStyle == "fade"){
				if(direction == "left"){
					count --;
					count = count < 0 ? imgSize - 1 : count;
				}else{
					count ++;
					count = count == imgSize ? 0 : count;
				}
				$thsLink.css({"left": 0}).stop().hide().eq(count).fadeIn(opts.moveTime);	
			}
			tagsMove();
			startSlider();
		},
		//圆点标记移动
		tagsMove = function(){
			if(opts.addTag){
				var $tagsObj = $tag.find("span");
				$tagsObj.css({
					"background-color" : opts.tagDefaultBg
				}).eq(count).css({
					"background-color" : opts.tagActiveBg
				});
			}
		},
		//开始轮播
		startSlider = function(){
			if(opts.autoSlider == true){
				ths.data('autoSli', window.setTimeout(imgsMove, opts.timeout));
			}
		},
		//暂停轮播
		stopSlider = function(){
			window.clearTimeout(ths.data('autoSli'));
		};

		//首张图片加载完毕后执行初始化
	    var bannerImg = new Image;
	    bannerImg.onload = function(){
	    	var loadImgW = ths.width(),
	    		loadImgH = bannerImg.height;
	    	opts.imgH = loadImgW*9/21;
	    	init();
	    }
	    bannerImg.src = $imgs.eq(0).attr("src");
	}
	//----------Html
	$.each($('*[e-fun = slider]'),function(i){
		$('*[e-fun = slider]').eq(i).slider();
	});

})(jQuery);	

//弹框   EDIT.SIMBA.2015.12.15
var popUpWindow = function(opts){

	opts = $.extend({
		title : "确定要删除么？", //弹出框的提示语  ps:可以是html字符串
		popType : 1,  // 弹出框的形式  1：确认框  2：提示框  3：带确认的提示框
		btnLeftTxt : "取消", //确认框取消
		btnRightTxt : "确定", //确认框 确定
		closeTime : 3000, //提示框自动关闭时间
		callback : function(){} //回调函数
	}, opts || {});

	var tem = '<div id="popUpWindowBox">'
				+'<div class="e-popUpWindowCon">'
					+'<p class="e-popUpWindowTxt"></p>'
					+'<div class="e-popUpWindowBtnBox">'
						+'<a class="e-popUpWindowBtn"></a>'
						+'<a class="e-popUpWindowBtn"></a>'
					+'</div>'
				+'</div>'
			   +'</div>';
	var	$popWarp,$popCon,$popTxt,$popBtn,$popBtnLeft,$popBtnRight,clTimeout;

	var init = function(){
		$("#popUpWindowBox").remove();
		$("body").append(tem);

		$popWarp = $("#popUpWindowBox");
		$popCon = $popWarp.find(".e-popUpWindowCon");
		$popTxt = $popWarp.find(".e-popUpWindowTxt");
		$popBtnBox = $popWarp.find(".e-popUpWindowBtnBox");
		$popBtn = $popWarp.find(".e-popUpWindowBtn");
		$popBtnLeft = $popBtn.eq(0);
		$popBtnRight = $popBtn.eq(1);
		
		popStyle();
		operation();
		styleAdjust();
	},
	//样式
	popStyle = function(){
		$popWarp.css({
			"position" : "fixed",
			"top" : 0,
			"left" : 0,
			"width" : "100%",
			"height" : "100%",
			"text-align" : "center",
			"background-color" : "rgba(1,1,1,.6)",
			"z-index" : "9999"
		});
		$popCon.css({
			"position" : "absolute",
			"top" :"50%",
			"left" : "50%",
			"background-color" : "#fff",
			"border" : "1px solid #ccc",
			"border-radius" : "5px",
			"z-index" : "10000"
		});
		$popTxt.css({
			"padding" : "20px",
			"line-height" : "30px"
		});
		$popBtnBox.css({
			"width" : "100%",
			"border-top" : "1px solid #ccc"
		});
		$popBtn.css({
			"display" : "inline-block",
			"width" : "50%",
			"height" : "40px",
			"line-height" : "40px",
			"cursor" : "pointer"
		});
		$popBtnRight.css({
			"border-left" : "1px solid #ccc",
			"margin-left" : "-1px"
		});
		switch(opts.popType){
			case 1:
			  $popBtnBox.show();
			  $popBtnLeft.on("click",closePop);
			  $popBtnRight.on("click",function(){
			  	opts.callback();
			  	closePop();
			  });
			  break;
			case 2:
			  $popBtnBox.hide();
			  clTimeout = setTimeout(closePop,opts.closeTime);
			  break;
			case 3:
			  $popBtnLeft.hide();
			  $popBtnRight.width("100%").on("click",closePop);
			  break;
		}

	},
	//初始化操作
	operation = function(){
		$popTxt.html(opts.title);
		$popBtnLeft.text(opts.btnLeftTxt);
		$popBtnRight.text(opts.btnRightTxt);
	},
	//操作完成后位置调整
	styleAdjust = function(){
		var conW = $popCon.width(),
			conH = $popCon.height();
		$popCon.css({
			"margin-left": (-1)*conW/2 + "px",
			"margin-top": (-1)*conH/2 + "px"
		});
	}
	//关闭弹框
	closePop = function(){
		$popWarp.remove();
	}
	init();
}