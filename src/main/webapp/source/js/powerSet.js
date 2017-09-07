/*动力参数设置页*/
$(function(){
    var ipt=$('.power-table input')
    $('.worker-edit').click(function(){
        ipt.css('border','solid #ccc 1px');
        ipt.attr('readonly',false)
    })//编辑
    $('.worker-notSave').click(function(){
        ipt.css('border','none');
        ipt.attr('readonly','readonly')
    })//取消
})