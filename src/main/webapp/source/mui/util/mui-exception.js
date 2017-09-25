/**
 * Exception 异常捕获类
 * @author zhangjl
 * @namespace mui.util
 * @singleton Exception
 */
mui.util.Exception = {

	_try:function(ret,obv) {
		if(!obv) return;
		
		if(ret == undefined || typeof ret == 'undefined'){
			mui.util.Error._throw(mui.util.ErrorCode[10001]);
			return false;
		}
		
		var jsonStr;
		
		if(typeof ret == 'string'){
			if(ret.indexOf("<!DOCTYPE html>")>0){//拦截器拦截
				obv.call(window,"");
				return false;
			}
			
			if(JSON){
				jsonStr=JSON.parse(ret);
			}else{
				jsonStr = eval('(' + ret + ')'); 
			}
		}else {
			jsonStr = ret;
		}
		
		if(jsonStr && jsonStr.ret != undefined){
			if(parseFloat(jsonStr.ret) > 0){
				if(mui.util.ErrorCode[jsonStr.ret]!=undefined){
					mui.util.Error._throw(mui.util.ErrorCode[jsonStr.ret]);
					if(layer){
						layer.closeAll("loading");
					}
					return false;
				}
				obv.call(window,jsonStr);
				return false;
			}
			jsonStr = jsonStr.data;
		}
		
		obv.call(window,jsonStr);
	}
}