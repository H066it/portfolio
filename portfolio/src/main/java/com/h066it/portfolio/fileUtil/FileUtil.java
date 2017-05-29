package com.h066it.portfolio.fileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.h066it.portfolio.dto.FileDto;

public class FileUtil {

	public List<FileDto> saveFiles(List<MultipartFile> upFiles) {	// file upload
		
		String path = "C:\\Users\\tosh\\git\\portfolio\\portfolio\\fileRepository";
		List<FileDto> fileList = new ArrayList<FileDto>();
		
		for(MultipartFile upFile : upFiles) {
			
			saveFileRepository(upFile, path);	// 암호화해야함.
			
			FileDto fDto = new FileDto();
			fDto.setfName(upFile.getName());	// 암호화해야함.
			System.out.println("upFile.getName() : " + upFile.getName());
			fDto.setrName(upFile.getOriginalFilename());
			System.out.println("upFile.getOriginalFilename() : " + upFile.getOriginalFilename());
			fDto.setfSize(upFile.getSize());
			System.out.println("upFile.getSize() : " + upFile.getSize());
			
			fileList.add(fDto);
		}
		
		return fileList;
	}

	private void saveFileRepository(MultipartFile upFile, String path) {
		// TODO Auto-generated method stub
		File fileRepository = new File(path);
		if(!fileRepository.exists()) {	// 폴더 없을시 생성
			fileRepository.mkdirs();
		}
		
		File file = new File(path + "/" + upFile.getOriginalFilename());	// 이름 암호화 해야함.

		try {
			upFile.transferTo(file);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
}
