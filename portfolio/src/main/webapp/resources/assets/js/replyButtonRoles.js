	function transferRId(rId, rGroup, auth) {		
		$("#rIdOnReply").val(rId);
		$("#rGroupOnReply").val(rGroup);
		$("#rWriterOnReply").val(auth);
	}
	
	function transferRIdUpd(rId, rGroup, auth) {		
		$("#rIdOnUpdate").val(rId);
		$("#rGroupOnUpdate").val(rGroup);
		$("#rWriterOnUpdate").val(auth);
	}
	
	function transferRIdDel(rId, rGroup) {		
		$("#rIdOnDelete").val(rId);
		$("#rGroupOnDelete").val(rGroup);
	}