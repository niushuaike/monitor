/*添加*/
		var n=0;
		$('.person-add').click(function(){
			var str="<tr><td><input type='checkbox'/></td><td>1</td><td><input type='text' value='' style='border:solid #ccc 1px'/></td><td><input type='text' value='' style='border:solid #ccc 1px'/></td><td><input type='text' value='' style='border:solid #ccc 1px'/></td><td><input type='text' value='' style='border:solid #ccc 1px'/></td><td><input type='text' value='' style='border:solid #ccc 1px'/></td><td><select><option>管理员1</option><option>管理员2</option></select></td><td><p class='person-p'><span class='time-notSave'>取消</span><span class='time-save'>保存</span></p></td></tr>"
			$('.yonghu-table tbody').append(str);
			
			/*取消*/
			$('.yonghu-table p .time-notSave').click(function(){
				$(this).hide();
				$(this).siblings().hide()
				var parent=$(this).parent().parent().parent();
				parent.find('input[type=text]').css('border','none');
				var val=parent.find('option:selected').text();
				parent.find('select').replaceWith("<input type='text' value='' />");
				parent.find('input[type=text]').eq(5).val(val);
				parent.find('input[type=text]').attr('readonly','readonly')
				
				
			})
			/*保存*/
			$('.yonghu-table p .time-save').click(function(){
				$(this).hide();
				$(this).siblings().hide()
				var parent=$(this).parent().parent().parent();
				parent.find('input[type=text]').css('border','none');
				var val=parent.find('option:selected').text();
				parent.find('select').replaceWith("<input type='text' value='' />");
				parent.find('input[type=text]').eq(5).val(val);
				parent.find('input[type=text]').attr('readonly','readonly')
				
				
			})
			
			
			/*编辑*/
			//索引 根据索引进行编辑
			var index;
			$('.chk-body tr').click(function(){
				 index=$(this).index();
						
			})
			//编辑
			$(".person-edit").click(function(){
				var ipt=$('.chk-body tr').eq(index).find('input[type=text]');
				ipt.css('border','solid #ccc 1px');
				ipt.attr('readonly',false);
				var ipt_sel=$('.chk-body tr').eq(index).find('input[type=text]').eq(5);
				ipt_sel.replaceWith("<select><option>管理员1</option><option>管理员2</option></select>");
				$('.chk-body tr').eq(index).find('span').show();

			})
		
		})