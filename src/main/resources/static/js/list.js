$(function (){
    //페이징 헤더
    $("[name='pageRows']").change(function (){
        // alert($(this).val());  //확인 용


        $("[name='frmPageRows']").attr({
            "method": "POST",
            "action": "/board/pageRows",
        }).submit();
    })
});