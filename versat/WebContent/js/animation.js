/*--处理页面表现JS--*/
$(document).ready(function() {
	$("#search_button").click(function() { 
		$(".search_detail").slideToggle("fast");
		$(this).toggleClass("current");
		if($("#search_button img").attr("src") == "../images/button/unfold.gif"){
			$("#search_button img").attr("src","../images/button/fold.gif");
		}else{
			$("#search_button img").attr("src","../images/button/unfold.gif");
		}
	});

	$("#add_favorites").click(function() { 
		$("#save").fadeIn("slow");
		$("#collect").fadeOut("slow");
		$("#list_choose").fadeOut("slow");
		$("#department").fadeOut("slow");
	});
	$("#favorites").click(function() { 
		$("#collect").fadeIn("slow");
		$("#save").fadeOut("slow");
		$("#list_choose").fadeOut("slow");
		$("#department").fadeOut("slow");
	});
	$("#search_button").click(function() { 
		$("#list_choose").fadeOut("slow");
	});
	$(".add_button").click(function() { 
		$("#list_choose").fadeOut("slow");
	});
	$("#list_choose_btn").click(function() { 
		$("#list_choose").fadeIn("slow");
		$("#collect").fadeOut("slow");
		$("#save").fadeOut("slow");
		$("#department").fadeOut("slow");
	});
	$(".close_window").click(function() { 
		$("#save").fadeOut("slow");
		$("#collect").fadeOut("slow");
		$("#list_choose").fadeOut("slow");
		$("#department").fadeOut("slow");
	});
	$(".btn_define").click(function() { 
		$("#list_choose").fadeOut("slow");
	});
	$("#checkall1").click( function() {
		checkHandle("checkall1");
	});
	$("#checkall2").click( function() {
		checkHandle("checkall2");
	});
});

function checkHandle(id) {
	if ($("#" + id).attr("checked")) {
		$(":checkbox").each( function() {
			$(this).parent().parent().addClass("line_selected");
			return $(this).attr("checked", true);
		});
	} else {
		$(":checkbox").each( function() {
			$(this).parent().parent().removeClass("line_selected")
			return $(this).attr("checked", false);
		});
	}
}

jQuery.fn.extend({
    "focusInput":function(){
        return this.each(function(){
            $(this).focus(function(){
                if( $(this).val() == $(this).get(0).defaultValue ){
                    //$(this).val("");
                }
            });
            $(this).blur(function(){
                if( $(this).val() == "" ){
                    $(this).val("");
                }
            })
        })
    }
});
/*----
$(document).ready(function() {
	$(".search_detail input[@type=text]").css("color","#c1c1c1");
	$(".search_detail input[@type=text]").not("#choose_department").focusInput();
	$(".search_detail input[@type=text]").not("#choose_department").focus(function(){
		$(this).css({border:"1px #50b8ff solid",background:"#edf8ff",color:"#000"});
	});
	$(".search_detail input[@type=text]").not("#choose_department").blur(function(){
		$(this).css({border:"1px #7f9db9 solid",background:"#fff"});
		if($(this).val() == $(this).get(0).defaultValue){
			$(this).css({color:"#c1c1c1"});
		};
	});
});
*/
$(document).ready(function() {
	$("input[@type=text],textarea").css("color","#c1c1c1");
	$("input[@type=text],textarea").not("#choose_department").focusInput();
	$("input[@type=text],textarea").not("#choose_department").focus(function(){
		$(this).css({border:"1px #50b8ff solid",background:"#edf8ff",color:"#000"});
	});
	$("input[@type=text],textarea").not("#choose_department").blur(function(){
		$(this).css({border:"1px #7f9db9 solid",background:"#fff"});
		if($(this).val() == $(this).get(0).defaultValue){
			$(this).css({color:"#c1c1c1"});
		};
	});
});


/*---����ѡ��b----*/
$(document).ready(function() {
	$("#choose_department").focus(function(){
		$("#department").fadeIn("slow");
		$("#save").fadeOut("slow");
		$("#collect").fadeOut("slow");
		$("#list_choose").fadeOut("slow");
	});
	$("#choose_department").blur(function(){
		
	});
	$(".btn_define").click(function(){
		$("#department").fadeOut("slow");
	});
});
/*---����ѡ��e----*/

/*--������e--*/
/*--�б�b--*/
$(document).ready(function(){
//���е�����ɫ:
	 $(".list_table tbody tr:odd").addClass("even");
     // ���ѡ��Ĭ���������ѡ��ģ���ɫ.
	$('.list_table input[type="checkbox"]:checked').parents('tr').addClass('line_selected');
	// ��ѡ��
	$('.list_table_choose tbody tr').click(
		function() {
			if ($(this).hasClass('line_selected')) {
				$(this).removeClass('line_selected');
				$(this).find('input[type="checkbox"]').removeAttr('checked');
			} else {
				$(this).addClass('line_selected');
				$(this).find('input[type="checkbox"]').attr('checked','checked');
			}
		}
     );
//ȫѡ���и�ѡ��:	

});
/*--�б�e--*/

/*--�����µĴ���b--*/
$(document).ready(function(){
	$(".add_one").click(
		function() {
			if ('.add_one input[type="radio"]:checked') {
				$(".add_one_content").show();
				$(".add_all_content").hide();
			} 
				}
     );
     $(".add_all").click(
		function() {
			if ('.add_all input[type="radio"]:checked') {
				$(".add_all_content").show();
				$(".add_one_content").hide();
			} 
				}
     );
});
/*--�����µĴ���e--*/
/*--�޸��½�ɫb--*/
$(document).ready(function(){
	$(".modify_icon").click(function(){
		var role = $(this);
		var openRole1 = role.parents("td").siblings().children(".view_detail");
		var openRole2 = role.parents("td").siblings().children(".modify_detail");
		var openRole3 = role.parents("td").children(".view_detail");
		var openRole4 = role.parents("td").children(".modify_detail");
		var openRole9 = role.parents("tr");
		openRole1.addClass("hide");
		openRole2.addClass("show");
		openRole3.addClass("hide");
		openRole4.addClass("show");
		openRole9.addClass("line_selected");
	});
	$(".save_icon").click(function(){
		var role = $(this);
		var openRole5 = role.parents("td").siblings().children(".view_detail");
		var openRole6 = role.parents("td").siblings().children(".modify_detail");
		var openRole7 = role.parents("td").children(".view_detail");
		var openRole8 = role.parents("td").children(".modify_detail");
		var openRole10 = role.parents("tr");
		openRole5.removeClass("hide");
		openRole6.removeClass("show");
		openRole7.removeClass("hide");
		openRole8.removeClass("show");
		openRole10.removeClass("line_selected");
	});
});

/*
 * 截取字符串区别中英文
 */
function left_str(str, len, mode) {
	//测字符串实际长度
	String.prototype.Tlength = function(){
		var arr=this.match(/[^\x00-\xff]/ig);
		return this.length+(arr == null ? 0 : arr.length);
	}
	//字符串左取
	String.prototype.left = function(num,mode){
		if(!/\d+/.test(num))
			return(this);
		var str = this.substr(0,num);
		if(mode) { 
			var n = str.Tlength() - str.length;
			num = num - parseInt(n/2);
			return this.substr(0,num)+"...";
		} else {
			return str;
		}
	}
	
	if(str.Tlength() > len) {
		return str.left(len, mode);
	} else {
		return str;
	}
}




