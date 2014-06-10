
(function($){
	/*动画的参数有linear，swing，jswing，easeInQuad，easeOutQuad，
	easeInOutQuad，easeInCubic， easeOutCubic，easeInOutCubic，
	easeInQuart，easeOutQuart，easeInOutQuart， easeInQuint，
	easeOutQuint，easeInOutQuint，easeInSine，easeOutSine，
	 easeInOutSine，easeInExpo，easeOutExpo，easeInOutExpo，
	 easeInCirc， easeOutCirc，easeInOutCirc，easeInElastic，
	 easeOutElastic，easeInOutElastic， easeInBack，easeOutBack，
	 easeInOutBack，easeInBounce，easeOutBounce，easeInOutBounce*/
	$.fn.BannerImages=function(options) {
	var settings = {length:3,speed:3000,easing:'jswing',duration:500}; 
	$.extend(settings, options);
	//e代表调用这个函数的元素 f表示第一个子元素
	var e = this, f = 1;
	//得到它的宽度转成int
	var width=parseInt($(this.children()[0]).css('width'));
	var main = function() {
		//width*f-width 其实就是
		var j = (width * f - width);
		//是第一个吗是的话返回0否则返回负值
		j=(j == 0 ? 0 : -j);
		//执行动画 改变距左边的距离 就可以实现动画效果
		e.animate({
			left : j + "px"
		}, {queue:false,
duration:settings.duration, easing: settings.easing});
	};
	//开始
	function start()  {
		//不停调用main 在一段时间后
		setInterval(function() {
			f++;
			if (f > settings.length) {
				f = 1;
			}
			main();
		}, settings.speed)
	};
	//刚开始调用的其实是start函数
	start();
}
})(jQuery);