/**
 * 
 */

function tj() {
	var options = $("#sex_sel option:selected");
	$("#sex").val(options.val());

	if (trim($("#user_name").val()) == "") {
		$$.alert("请填写姓名");
		$('#user_name').focus();
		return
	}
	;
	// if(trim($("#phone").val()) == "") {$$.alert("请填写电话号码"); return};
	// 判断手机号码
	if ($.trim($('#phone').val()).length == 0) {
		$$.alert("请填写手机号码");
		$('#phone').focus();
		return;
	} else {
		if (isPhoneNo($.trim($('#phone').val())) == false) {
			$$.alert("请填写有效的手机号码");
			$('#phone').focus();
			return;
		}
	}
	// if(trim($("#zjhm").val()) == "") {$$.alert("请填写证件号码"); return};
	if (trim($("#dz").val()) == "") {
		$$.alert("请填写住址");
		$('#dz').focus();
		return
	}
	;
	if (trim($("#sex").val()) == "") {
		$$.alert("请选择性别");
		return
	}
	;

	$.ajax({
		url : '/hyzc/addUser',
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

function go_zc() {
	document.forms[0].submit();
}

function trim(x) {
	return $.trim(x)
}

// 验证手机号
function isPhoneNo(phone) {
	var pattern = /^1[34578]\d{9}$/;
	return pattern.test(phone);
}