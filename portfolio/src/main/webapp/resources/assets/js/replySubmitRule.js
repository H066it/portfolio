	function replyNullCheck() {
		if($('input[id=rWriter]').val().length < 2) {
			alert('작성자를 2자 이상 입력해주세요.');
			$('input[id=rWriter]').focus();
			return false;
		}
		if($('input[id=rPassword]').val().length < 4) {
			alert('비밀번호를 4자 이상 입력해주세요.');
			$('input[id=rPassword]').focus();
			return false;
		}
		if($('textarea[id=rContent]').val().length < 2) {
			alert('내용을 2자 이상 입력해주세요.');
			$('textarea[id=rContent]').focus();
			return false;
		}
		if($('input[id=rWriter]').val().length > 15) {
			alert('작성자 명을 15자 이하로 입력해주십시오.');
			$('input[id=rWriter]').focus();
			return false;
		}
		if($('input[id=rPassword]').val().length > 20) {
			alert('비밀번호를 20자 이하로 입력해주십시오.');
			$('input[id=rPassword]').focus();
			return false;
		}
		if($('textarea[id=rContent]').val().length > 300) {
			alert('내용을 300자 이하로 입력해주십시오.');
			$('textarea[id=rContent]').focus();
			return false;
		}
	}
	
	function replyOnReplyNullCheck() {
		if($('input[id=rWriterOnReply]').val().length < 2) {
			alert('작성자를 2자 이상 입력해주세요.');
			$('input[id=rWriterOnReply]').focus();
			return false;
		}
		if($('input[id=rPasswordOnReply]').val().length < 4) {
			alert('비밀번호를 4자 이상 입력해주세요.');
			$('input[id=rPasswordOnReply]').focus();
			return false;
		}
		if($('textarea[id=rContentOnReply]').val().length < 2) {
			alert('내용을 2자 이상 입력해주세요.');
			$('textarea[id=rContentOnReply]').focus();
			return false;
		}
		if($('input[id=rWriterOnReply]').val().length > 15) {
			alert('작성자 명을 15자 이하로 입력해주십시오.');
			$('input[id=rWriterOnReply]').focus();
			return false;
		}
		if($('input[id=rPasswordOnReply]').val().length > 20) {
			alert('비밀번호를 20자 이하로 입력해주십시오.');
			$('input[id=rPasswordOnReply]').focus();
			return false;
		}
		if($('textarea[id=rContentOnReply]').val().length > 300) {
			alert('내용을 300자 이하로 입력해주십시오.');
			$('textarea[id=rContentOnReply]').focus();
			return false;
		}
	}
	
	function transferRId(value) {
		alert(value);
		$("#replyWriteOnReply").on('submit', function() {		
			var path = $(pageContext.request.contextPath);	// 없으면 에러남.
			$.ajax( {
				url : path + "/test123",
				type : "POST",
				datatype : "json",
				data : {
					"bId" : $("#bIdOnReply").val(), "rId" : value,
					"rWriter" : $("#rWriterOnReply").val(),
					"rPassword" : $("#rPasswordOnReply").val(), "rContent" : $("#rContentOnReply").val()
				},
				success: function(response){ 
	              alert('success!');
		        },
		        error:function(request,status,e){
		             alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+e);
		             alert($("#bIdOnReply").val());
		             alert($("#rIdOnReply").val());
		             alert($("#rWriterOnReply").val());
		             alert($("#rPasswordOnReply").val());
		             alert($("#rContentOnReply").val());
		        }
			})	
		});
	}