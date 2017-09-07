	$('.modal-01 input[type=radio]').change(function(){
			if($("#sex-1").is(':checked')){
				$('.mail').show();
			}
			else{
				$('.mail').hide();
			}
		})
		$('#editModal input[type=radio]').change(function(){
			if($("#sex-3").is(':checked')){
				$('.mail').show();
			}
			else{
				$('.mail').hide();
			}
		})
		
		/*冻结弹窗出现*/
		$('.tit-btn .btn-warning').click(function(){
			$('.tit-btn .block').fadeToggle(500)
		})
		/*冻结弹窗关闭*/
		$('.fadin').click(function(){
			$('.block').fadeOut(500)
		})
		
/*添加*/	
	$('.key-btn').click(function(){
		$('.modal-01').show()
	})
	
	$('.modal-sel').click(function(){
		$('.modal-01').hide();
		$('.modal-02').show();
	})
/*编辑*/
	$('.key-edit').click(function(){
		$('.modal-01').show()
	})
$('button.close').click(function(){
	$(this).parent().parent().parent().parent().hide();
})
