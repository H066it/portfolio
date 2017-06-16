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
	
	function replyOnUpdateNullCheck() {
		if($('input[id=rWriterOnUpdate]').val().length < 2) {
			alert('작성자를 2자 이상 입력해주세요.');
			$('input[id=rWriterOnUpdate]').focus();
			return false;
		}
		if($('input[id=rPasswordOnUpdate]').val().length < 4) {
			alert('비밀번호를 4자 이상 입력해주세요.');
			$('input[id=rPasswordOnUpdate]').focus();
			return false;
		}
		if($('textarea[id=rContentOnUpdate]').val().length < 2) {
			alert('내용을 2자 이상 입력해주세요.');
			$('textarea[id=rContentOnUpdate]').focus();
			return false;
		}
		if($('input[id=rWriterOnUpdate]').val().length > 15) {
			alert('작성자 명을 15자 이하로 입력해주십시오.');
			$('input[id=rWriterOnUpdate]').focus();
			return false;
		}
		if($('input[id=rPasswordOnUpdate]').val().length > 20) {
			alert('비밀번호를 20자 이하로 입력해주십시오.');
			$('input[id=rPasswordOnUpdate]').focus();
			return false;
		}
		if($('textarea[id=rContentOnUpdate]').val().length > 300) {
			alert('내용을 300자 이하로 입력해주십시오.');
			$('textarea[id=rContentOnUpdate]').focus();
			return false;
		}
	}
	
	function replyOnDeleteNullCheck() {		
		if($('input[id=rPasswordOnDelete]').val().length < 4) {
			alert('비밀번호를 4자 이상 입력해주세요.');
			$('input[id=rPasswordOnDelete]').focus();
			return false;
		}
		if($('input[id=rPasswordOnDelete]').val().length > 20) {
			alert('비밀번호를 20자 이하로 입력해주십시오.');
			$('input[id=rPasswordOnDelete]').focus();
			return false;
		}		
	}