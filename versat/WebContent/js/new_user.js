$(document).ready(function() {
	$(".close_window").click(function() { 
		$("#save").fadeOut("slow");
		$("#collect").fadeOut("slow");
		$("#list_choose").fadeOut("slow");
		$("#department_2").fadeOut("slow");
	});
});


jQuery.fn.extend({
    "focusInput":function(){
        return this.each(function(){
            $(this).focus(function(){
                if( $(this).val() == $(this).get(0).defaultValue ){
                    $(this).val("");
                }
            });
            $(this).blur(function(){
                if( $(this).val() == "" ){
                    $(this).val( $(this).get(0).defaultValue );
                }
            })
        })
    }
});

$(document).ready(function() {
	$(".new_user input[@type=text]").css("color","#000");
	$(".new_user input[@type=password]").css("color","#000");
	//$(".new_user input[@type=text]").not("#choose_department").focusInput();
	$(".new_user input[@type=text]").not("#choose_department").focus(function(){
		$(this).css({border:"1px #50b8ff solid",background:"#edf8ff",color:"#000"});
	});
	$(".new_user input[@type=password]").not("#choose_department").focus(function(){
		$(this).css({border:"1px #50b8ff solid",background:"#edf8ff",color:"#000"});
	});
	//$(".new_user input[@type=text]").not("#choose_department").blur(function(){
	//	$(this).css({border:"1px #7f9db9 solid",background:"#fff"});
	//	if($(this).val() == $(this).get(0).defaultValue){
	//		$(this).css({color:"#c1c1c1"});
	//	};
	//});
	$(".new_user input[@type=password]").not("#choose_department").blur(function(){
		$(this).css({border:"1px #7f9db9 solid",background:"#fff"});
		if($(this).val() == $(this).get(0).defaultValue){
			$(this).css({color:"#c1c1c1"});
		};
	});
});


$(document).ready(function() {
	$("#choose_department").focus(function(){
		$("#department_2").fadeIn("slow");
		$("#save").fadeOut("slow");
		$("#collect").fadeOut("slow");
		$("#list_choose").fadeOut("slow");
	});
	$("#choose_department").blur(function(){
		
	});
	$(".btn_define").click(function(){
		$("#department_2").fadeOut("slow");
	});
});
