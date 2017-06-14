package com.h066it.portfolio.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.h066it.portfolio.dao.IDao;
import com.h066it.portfolio.dao.ReplyIDao;
import com.h066it.portfolio.dto.Dto;
import com.h066it.portfolio.dto.FileDto;
import com.h066it.portfolio.dto.ReplyDto;

@Service
public class ServiceModel implements IDao, ReplyIDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private TransactionTemplate TransactionTemplate; 
	
	/*-------------- CRUD 관련 --------------*/
	
	@Override
	public ArrayList<Dto> count() {

		IDao dao = sqlSession.getMapper(IDao.class);
				
		return dao.count();
	}

	@Override
	public ArrayList<Dto> list(int firNum, int lstNum) {

		IDao dao = sqlSession.getMapper(IDao.class);
		
		return dao.list(firNum, lstNum);
	}

	@Override
	public void write(String bWriter, String bTitle, String bContent, int fileCheck) {

		IDao dao = sqlSession.getMapper(IDao.class);

		dao.write(bWriter, bTitle, bContent, fileCheck);
		
	}

	@Override
	public void delete(String bId) {

		IDao dao = sqlSession.getMapper(IDao.class);
		
		dao.delete(bId);
		
	}

	@Override
	public Dto view(String bId) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		return dao.view(bId);
	}

	@Override
	public void update(String bId, String bWriter, String bTitle, String bContent, int fileCheck) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		dao.update(bId, bWriter, bTitle, bContent, fileCheck);
		
	}

	@Override
	public void countUpdate(String bId) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		dao.countUpdate(bId);
		
	}
	
	/*-------------- Search 관련 --------------*/

	@Override
	public ArrayList<Dto> searchCount(String searchType, String keyword) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		return dao.searchCount(searchType, keyword);
	}

	@Override
	public ArrayList<Dto> searchList(int firNum, int lstNum, String searchType, String keyword) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		return dao.searchList(firNum, lstNum, searchType, keyword);
	}
	
	/*-------------- File 관련 --------------*/
	
	@Override
	public void fileWrite(String fName, String rName, double fSize) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
	
		dao.fileWrite(fName, rName, fSize);
		
	}
	
	@Override
	public void fileDelete(String fId) {
	
		IDao dao = sqlSession.getMapper(IDao.class);
		
		dao.fileDelete(fId);
		
	}

	@Override
	public ArrayList<FileDto> fileView(String bId) {
	
		IDao dao = sqlSession.getMapper(IDao.class);
		
		return dao.fileView(bId);
	}

	@Override
	public void fileUpdate(int bId, String fName, String rName, double fSize) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		dao.fileUpdate(bId, fName, rName, fSize);
		
	}	
	
	@Override
	public void fileDownload(HttpServletRequest request, HttpServletResponse response) {

		String path = "C:\\Users\\tosh\\git\\portfolio\\portfolio\\fileRepository";
		String fName = request.getParameter("fName");
		String filePath = path + "\\" + fName.substring(1, fName.length() - 1);

		String rName = null;
		
		String header = request.getHeader("User-Agent");
		
		System.out.println("header : " + header);
		
		if (header.indexOf("MSIE") != -1 || header.indexOf("Trident") != -1) {	// IE 다운로드 수정해야함.
			try {
				rName = URLEncoder.encode(request.getParameter("rName"), "utf-8").replaceAll("\\+", "%20");
				System.out.println("rName : " + rName);
				response.setHeader("content-disposition", "attachment; filename=\"" + rName.substring(3, rName.length() - 3) + "\"");
				response.setHeader("content-type", "application/octet-stream; charset=utf-8");
			} catch (UnsupportedEncodingException e) {
				System.out.println(e.getMessage());
			}
		} else {
			try {
				rName = new String(request.getParameter("rName").getBytes("UTF-8"), "ISO-8859-1");	// 파일 이름 한글 인코딩.
				System.out.println("rName : " + rName);
				response.setHeader("content-disposition", "attachment; filename=\"" + rName.substring(1, rName.length() - 1) + "\"");
				response.setHeader("content-type", "application/octet-stream; charset=utf-8");
			} catch (UnsupportedEncodingException e) {
			}
		}
		
		System.out.println("request.getParameter(\"rName\") : " + rName.substring(1, rName.length() - 1));
		System.out.println("filePath : " + filePath);
/*		response.setHeader("content-disposition", "attachment; filename=\"" + rName.substring(1, rName.length() - 1) + "\"");*/
		// 다운시 파일 이름.
		/*response.setHeader("content-type", "application/octet-stream; charset=utf-8");	// 다운시 알림창.
*/
		try {
			FileInputStream input = new FileInputStream(filePath);
			OutputStream output = response.getOutputStream();
			
			int read = 0;
            byte[] byteStream = new byte[10485760];	// bufferSize 10MB 제한.

            while ((read = input.read(byteStream)) != -1 ) {
                output.write(byteStream, 0, read);
            }			
            output.close();
            input.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		
	}

	@Override
	public void writeWithFile(final Dto dto, final List<FileDto> fileList) {
		
		TransactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				
				System.out.println("write");
				write(dto.getbWriter(), dto.getbTitle(), dto.getbContent(), dto.getFileCheck());
				
				if(!fileList.isEmpty()) {
					for(FileDto file : fileList) {	// DB에 file들 정보 저장.
						
						System.out.println("file.getfName() : " + file.getfName());
						System.out.println("file.getrName() : " + file.getrName());
						System.out.println("file.getfSize() : " + file.getfSize());
						
						fileWrite(file.getfName(), file.getrName(), file.getfSize());
					}
				}
			}
		});
		
	}
	
	@Override
	public void deleteWithFile(final String bId, final List<FileDto> fileList) {
		
		TransactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				
				System.out.println("delete");
				delete(bId);

				if(!fileList.isEmpty()) {
					for(FileDto file : fileList) {	// DB에 file들 정보 저장.
					
						System.out.println("file.getfId() : " + file.getfId());
					
						String fId = Integer.toString(file.getfId());
						fileDelete(fId);
					}
				}
			}
		});
		
	}

	@Override
	public void updateeWithFile(final Dto dto, final List<FileDto> fileList, final String[] fIds) {
		
		TransactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				
				System.out.println("update");
				
				String bId = Integer.toString(dto.getbId());
				update(bId, dto.getbWriter(), dto.getbTitle(),	dto.getbContent(), dto.getFileCheck());

				if(!fileList.isEmpty()) {
					for(FileDto file : fileList) {	// DB에 file들 정보 저장.
						
						System.out.println("file.getfName() : " + file.getfName());
						System.out.println("file.getrName() : " + file.getrName());
						System.out.println("file.getfSize() : " + file.getfSize());
						
						fileUpdate(dto.getbId(), file.getfName(), file.getrName(), file.getfSize());
					}
				}
				
				if(fIds != null) {
					for(String fId : fIds) {
						
						System.out.println("fileDelete fId : " + fId);
						fileDelete(fId);
						
					}
				}
			}
		});
		
	}

	/*-------------- Reply 관련 --------------*/
	
	@Override
	public void replyWrite(ReplyDto rDto) {
				
		System.out.println("★rDto.getrId() : " + rDto.getrId());
		if(rDto.getrId() == 0) {
			System.out.println("replyWriteOnBoard");
			rDto.setrIndent(0);
			
			int order = lastReplyOrder(rDto.getbId());
			
			System.out.println("★order : " + order);
			
			replyWriteOnBoard(rDto.getbId(), rDto.getrWriter(), rDto.getrPassword(), rDto.getrContent(), order);
		} else {
			System.out.println("rDto.getrId() : " + rDto.getrId());
			
			int indent = getIndent(rDto.getbId(), rDto.getrId()) + 1;
			int order = getOrder(rDto.getbId(), rDto.getrId()) + 1;
			
			System.out.println("indent + 1 : " + indent);
			System.out.println("order + 1 : " + order);
			
			orderSort(rDto.getbId(), order);	// 중간 삽입시 나머지 rOrder들에게 + 1 씩 해주는 것
			
			replyWriteOnReply(rDto.getbId(), rDto.getrWriter(), rDto.getrPassword(), rDto.getrContent(),
					indent, order);
			
		}
	
	}

	@Override
	public void replyWriteOnBoard(int bId, String rWriter, String rPassword, String rContent, int lstReplyOrder) {
	
		ReplyIDao rDao = sqlSession.getMapper(ReplyIDao.class);
		
		rDao.replyWriteOnBoard(bId, rWriter, rPassword, rContent, lstReplyOrder);
		
	}	

	@Override
	public int lastReplyOrder(int bId) {
		
		ReplyIDao rDao = sqlSession.getMapper(ReplyIDao.class);
				
		return rDao.lastReplyOrder(bId);
	}

	@Override
	public ArrayList<ReplyDto> replyView(String bId) {

		ReplyIDao rDao = sqlSession.getMapper(ReplyIDao.class);
		
		return rDao.replyView(bId);
	}

	
	@Override
	public int getIndent(int bId, int rId) {

		ReplyIDao rDao = sqlSession.getMapper(ReplyIDao.class);
		
		return rDao.getIndent(bId, rId);
	}

	@Override
	public int getOrder(int bId, int rId) {

		ReplyIDao rDao = sqlSession.getMapper(ReplyIDao.class);
		
		return rDao.getOrder(bId, rId);
	}

	@Override
	public void orderSort(int bId, int order) {
		
		ReplyIDao rDao = sqlSession.getMapper(ReplyIDao.class);
		
		rDao.orderSort(bId, order);
		
	}	
	
	@Override
	public void replyWriteOnReply(int bId, String rWriter, String rPassword, String rContent, int rIndent,
			int rOrder) {

		ReplyIDao rDao = sqlSession.getMapper(ReplyIDao.class);
		
		rDao.replyWriteOnReply(bId, rWriter, rPassword, rContent, rIndent, rOrder);
		
	}
	
}
