	/*编辑*/
		var time_index;
		$('.time-table tbody tr').click(function(){
			time_index=$(this).index()
		})
		$('.time-edit').click(function(){
			$('.time-table span').show();
			$('.time-ipt').css('border','solid #ccc 1px');
			$('.time-ipt').attr('readonly',false)
			var sel=$('.time-table tbody tr').eq(time_index).find('select');
			sel.css('border','solid #ccc 1px')
			sel.attr('disabled',false)
		})
		
		$(function(){
			/*取消*/
			$('.time-notSave').click(function(){
				$(this).hide();
				$(this).siblings().hide();
				var sel=$(this).parent().parent().find('select');
					sel.css('border','none');
					sel.attr('disabled',true);
				$('.time-ipt').css('border','none');
				$('.time-ipt').attr('readonly',true)
			})
			/*保存*/
			$('.time-save').click(function(){
				$(this).hide();
				$(this).siblings().hide();
				var sel=$(this).parent().parent().find('select');
					sel.css('border','none');
					sel.attr('disabled',true);
				$('.time-ipt').css('border','none');
				$('.time-ipt').attr('readonly',true)
			})
		})