/**
 * Ajax异步提交工具类 注意：提交的服务器必须与当前使用页面同域名（跨域问题）。
 * 
 * @namespace mui.util
 * @singleton Ajax
 */
mui.util.Ajax = {
		/**
		 * 异步GET请求
		 * @param {String} url 服务器地址
		 * @param {String} params 参数
		 * @param {Function} successFun 成功后回调函数
		 */
		asyncGET:function(url, params, successFun, failureFun, beforeSend, complete) {
			$.ajax({
				url:url,
				type:'get',
				contentType:"application/x-www-form-urlencoded; charset=utf-8",
				cache:false,
				beforeSend:beforeSend,
				data:params,
				success:function(ret){
					mui.util.Exception._try(ret,successFun);
				},
				error:function(XMLHttpRequest, textStatus, errorThrown){
					layer.closeAll("loading");
					var json = eval("("+XMLHttpRequest.responseText+")");
					if(json.ret)
						layer.msg(json.message,{icon:0});
					if(failureFun){
						failureFun.call(window);
					}
				},
				complete:complete
			})
		},
		
		/**
		 * 异步POST请求
		 * @param {String} url 服务器地址
		 * @param {String} params 参数
		 * @param {Function} successFun 成功后回调函数
		 */
		asyncPOST:function(url, params, successFun, failureFun, beforeSend, complete) {
			$.ajax({
				url:url,
				type:'post',
				cache:false,
				data:params,
				contentType:"application/x-www-form-urlencoded; charset=utf-8",
				beforeSend:beforeSend,
				success:function(ret){
					mui.util.Exception._try(ret,successFun);
				},
				error:function(XMLHttpRequest, textStatus, errorThrown){
					layer.closeAll("loading");
					var json = eval("("+XMLHttpRequest.responseText+")");
					if(json.ret)
						layer.msg(json.message,{icon:0});
					if(failureFun){
						failureFun.call(window);
					}
				},
				complete:complete
			})
		},
		
		/**
		 * 同步GET请求
		 * @param {String} url 服务器地址
		 * @param {String} params 参数
		 * @param {Function} successFun 成功后回调函数
		 */
		syncGET:function(url, params) {
			var ret;
			$.ajax({
				url:url,
				async:false,
				type:'get',
				cache:false,
				data:params,
				contentType:"application/x-www-form-urlencoded; charset=utf-8",
				success:function(data){
					mui.util.Exception._try(data,function(data){
						ret=data;
					});
				},
				error:function(){
					console.log(mui.util.ErrorCode[10002])
				}
			});
			return ret;
		},
		
		/**
		 * 同步POST请求
		 * @param {String} url 服务器地址
		 * @param {String} params 参数
		 * @param {Function} successFun 成功后回调函数
		 */
		syncPOST:function(url, params) {
			var ret;
			$.ajax({
				url:url,
				async:false,
				cache:false,
				type:'post',
				contentType:"application/x-www-form-urlencoded; charset=utf-8",
				data:params,
				success:function(data){
					mui.util.Exception._try(data,function(data){
						ret=data;
					});
				},
				error:function(){
					console.log(mui.util.ErrorCode[10002])
				}
			});
			return ret;
		}
}

/**
 * 直接返回HTML
 */
mui.util.AjaxReturnHtml = {
		/**
		 * 异步GET请求
		 * @param {String} url 服务器地址
		 * @param {String} params 参数
		 * @param {Function} successFun 成功后回调函数
		 */
		asyncGET:function(url, params, successFun, failureFun, beforeSend, complete) {
			$.ajax({
				url:url,
				type:'get',
				contentType:"application/x-www-form-urlencoded; charset=utf-8",
				cache:false,
				beforeSend:beforeSend,
				data:params,
				dataType :"html", 
				success:function(data){
					if(data == undefined || typeof data == 'undefined'){
						mui.util.Error._throw(mui.util.ErrorCode[10001]);
						return false;
					}
					if(typeof data == 'object' && data.ret != 0){
						mui.util.Error._throw(data.message);
						return false;
					}
					successFun.call(window,data);
				},
				error:function(){
					if(failureFun){
						failureFun.call(window);
					}else{
						console.log(mui.util.ErrorCode[10002])
					}
				},
				complete:complete
			})
		},
		
		/**
		 * 异步POST请求
		 * @param {String} url 服务器地址
		 * @param {String} params 参数
		 * @param {Function} successFun 成功后回调函数
		 */
		asyncPOST:function(url, params, successFun, failureFun, beforeSend, complete) {
			$.ajax({
				url:url,
				type:'post',
				cache:false,
				data:params,
				dataType :"html",
				contentType:"application/x-www-form-urlencoded; charset=utf-8",
				beforeSend:beforeSend,
				success:function(data){
					if(data == undefined || typeof data == 'undefined'){
						mui.util.Error._throw(mui.util.ErrorCode[10001]);
						return false;
					}
					if(typeof data == 'object' && data.ret != 0){
						mui.util.Error._throw(data.message);
						return false;
					}
					successFun.call(window,data);
				},
				error:function(XMLHttpRequest, textStatus, errorThrown){
					if(failureFun){
						failureFun.call(window);
					}else{
						console.log(mui.util.ErrorCode[10002])
					}
				},
				complete:complete
			})
		},
		
		/**
		 * 同步GET请求
		 * @param {String} url 服务器地址
		 * @param {String} params 参数
		 * @param {Function} successFun 成功后回调函数
		 */
		syncGET:function(url, params) {
			var ret;
			$.ajax({
				url:url,
				async:false,
				type:'get',
				cache:false,
				data:params,
				dataType :"html",
				contentType:"application/x-www-form-urlencoded; charset=utf-8",
				success:function(data){
					if(data == undefined || typeof data == 'undefined'){
						mui.util.Error._throw(mui.util.ErrorCode[10001]);
						return false;
					}
					if(typeof data == 'object' && data.ret != 0){
						mui.util.Error._throw(data.message);
						return false;
					}
					ret=data;
				},
				error:function(){
					console.log(mui.util.ErrorCode[10002])
				}
			});
			return ret;
		},
		
		/**
		 * 同步POST请求
		 * @param {String} url 服务器地址
		 * @param {String} params 参数
		 * @param {Function} successFun 成功后回调函数
		 */
		syncPOST:function(url, params) {
			var ret;
			$.ajax({
				url:url,
				async:false,
				cache:false,
				type:'post',
				dataType :"html",
				contentType:"application/x-www-form-urlencoded; charset=utf-8",
				data:params,
				success:function(data){
					if(data == undefined || typeof data == 'undefined'){
						mui.util.Error._throw(mui.util.ErrorCode[10001]);
						return false;
					}
					if(typeof data == 'object' && data.ret != 0){
						mui.util.Error._throw(data.message);
						return false;
					}
					ret=data;
				},
				error:function(){
					console.log(mui.util.ErrorCode[10002])
				}
			});
			return ret;
		}
}