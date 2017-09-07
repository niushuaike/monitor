//索引 根据索引进行编辑
			var index;
			$('.chk-body tr').click(function(){
				 index=$(this).index();
						
			})
			//编辑
			$(".jichu-edit").click(function(){
				var ipt=$('.chk-body tr').eq(index).find('input[type=text]');
				ipt.css('border','solid #ccc 1px');
				ipt.attr('readonly',false);
				$('.chk-body .ipt-p').eq(index).show();
			})
			//取消
			$('.chk-body .not-save').click(function(){
				var ipt=$('.chk-body tr').eq(index).find('input[type=text]');
				ipt.css('border','none');
				ipt.attr('readonly','readonly');
				$('.ipt-p').hide();
			})
			//保存
			$('.chk-body .save').click(function(){
				var ipt=$('.chk-body tr').eq(index).find('input[type=text]');
				ipt.css('border','none');
				ipt.attr('readonly','readonly');
				$('.ipt-p').hide();
			})
			