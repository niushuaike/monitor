/*全选反选*/
	$('.allChk').click(function(){
		if(this.checked){   
			
    		$(".chk-body :checkbox").prop("checked", true);  
			
		}
		else{
			$(".chk-body :checkbox").prop("checked", false);
			   
		}
	})
	$('.allChk2').click(function(){
		if(this.checked){   
			
    		$(".chk-body2 :checkbox").prop("checked", true);  
			
		}
		else{
			$(".chk-body2 :checkbox").prop("checked", false);
			   
		}
	})
	
/*当前时间*/
$(function(){
    window.setInterval(getNowTime, 1000*1);
})

function getNowTime() {
    var mydate = new Date();
    var year=mydate.getFullYear(); //获取完整的年份(4位,1970-????)
    var mon=mydate.getMonth()+1; //获取当前月份(0-11,0代表1月)
    var data=mydate.getDate(); //获取当前日(1-31)
    var hours = mydate.getHours();
    var minutes = mydate.getMinutes();
    var seconds = mydate.getSeconds();
    var nowTime=year+'-'+mon+'-'+data+' '+hours+':'+minutes+':'+seconds;
    $('#now-time').text(nowTime);
}









	
