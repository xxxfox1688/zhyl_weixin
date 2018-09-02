/**
 * 
 */


function tj(){
	var options=$("#sex_sel option:selected");
	$("#sex").val(options.val());

	if(trim($("#user_name").val()) == "") {$$.alert("请填写姓名"); return};
	if(trim($("#phone").val()) == "") {$$.alert("请填写电话号码"); return};
	if(trim($("#zjhm").val()) == "") {$$.alert("请填写证件号码"); return};
	if(trim($("#dz").val()) == "") {$$.alert("请填写住址"); return};
	if(trim($("#sex").val()) == "") {$$.alert("请选择性别"); return};

	$.ajax({
		url : 'hyzc/addUser',
		type : 'post',
		data : $('#addUserForm').serialize(),
		dataType : "json",
		success : function(result) {
			if (result.success = '000000') {
				$$.alert("会员注册成功");
			} else {
				$$.alert("会员注册失败");
			}
		}
	});
}

function go_zc(){
	document.forms[0].submit();
}

function trim(x) {
    return x.replace(/^\s+|\s+$/gm,'');
}