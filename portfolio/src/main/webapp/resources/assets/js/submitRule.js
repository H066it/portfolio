	function nullCheck() {		
		if($('input[name=bWriter]').val().length < 2) {
			alert('작성자를 2자 이상 입력해주세요.');
			$('input[name=bWriter]').focus();
			return false;
		}
		if($('input[name=bTitle]').val().length < 2) {
			alert('제목을 2자 이상 입력해주세요.');
			$('input[name=bTitle]').focus();
			return false;
		}
		if($('textarea[name=bContent]').val().length < 2) {
			alert('내용을 2자 이상 입력해주세요.');
			$('textarea[name=bContent]').focus();
			return false;
		}

		if($('input[name=bWriter]').val().length > 15) {
			alert('작성자 명을 15자 이하로 입력해주십시오.');
			$('input[name=bWriter]').focus();
			return false;
		}
		if($('input[name=bTitle]').val().length > 40) {
			alert('제목을 40자 이하로 입력해주십시오.');
			$('input[name=bTitle]').focus();
			return false;
		}
		if($('textarea[name=bContent]').val().length > 500) {
			alert('내용을 500자 이하로 입력해주십시오.');
			$('textarea[name=bContent]').focus();
			return false;
		}		
	}