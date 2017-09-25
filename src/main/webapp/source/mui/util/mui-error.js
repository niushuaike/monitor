/**
 * ERROR	错误类
 * @author zhangjl
 * @namespace mui.util
 * @singleton Error
 */
mui.util.Error = {
	_throw:function(ret){
		alert(ret);
		return false;
	}
}

mui.util.ErrorCode = {
	10001:"返回值为空",
	10002:"请求发生异常",
	100012:"服务器发生异常"
}