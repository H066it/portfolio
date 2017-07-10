package com.h066it.portfolio.fileUtil;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.web.multipart.MultipartFile;

import com.h066it.portfolio.dto.FileDto;

public class FileUtil {

	public List<FileDto> saveFiles(List<MultipartFile> upFiles) {	// file upload
		
		String path = "C:\\Users\\tosh\\git\\portfolio\\portfolio\\src\\main\\webapp\\resources\\fileRepository";
		List<FileDto> fileList = new ArrayList<FileDto>();
		
		for(MultipartFile upFile : upFiles) {
			if(!upFile.getOriginalFilename().isEmpty() && upFile.getSize() != 0) {
				String encName = encryptName(upFile.getOriginalFilename());
			
				saveFileRepository(upFile, path, encName);
				
				FileDto fDto = new FileDto();
				fDto.setfName(encName);
				System.out.println("encName : " + encName);
				fDto.setrName(upFile.getOriginalFilename());
				System.out.println("upFile.getOriginalFilename() : " + upFile.getOriginalFilename());
				fDto.setfSize(upFile.getSize());
				System.out.println("upFile.getSize() : " + upFile.getSize());
					
				fileList.add(fDto);
			}
		}
		
		return fileList;
	}

	private String encryptName(String originalFilename) {
		
		DateFormat dateFormatformat = new SimpleDateFormat("yyyyMMddHHssSSS", Locale.KOREA);
		System.out.println("dateFormatformat : " + dateFormatformat.format(new Date()));
		String encName = originalFilename + dateFormatformat.format(new Date()) + (int)(Math.random()*10000000);
		
		return encName;
	}

	private void saveFileRepository(MultipartFile upFile, String path, String encName) {
		// TODO Auto-generated method stub
		File fileRepository = new File(path);
		if(!fileRepository.exists()) {	// 폴더 없을시 생성
			fileRepository.mkdirs();
		}
		
		File file = new File(path + "/" + encName);

		try {
			upFile.transferTo(file);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
}
