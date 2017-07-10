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
	public ArrayList<Dto> count(String gId) {

		IDao dao = sqlSession.getMapper(IDao.class);
				
		return dao.count(gId);
	}

	@Override
	public ArrayList<Dto> list(String gId, int firNum, int lstNum) {

		IDao dao = sqlSession.getMapper(IDao.class);
		
		return dao.list(gId, firNum, lstNum);
	}

	@Override
	public void write(int gId, String bWriter, String bPassword, String bTitle, String bContent, int fileCheck) {

		IDao dao = sqlSession.getMapper(IDao.class);

		dao.write(gId, bWriter, bPassword, bTitle, bContent, fileCheck);
		
	}

	@Override
	public void delete(String gId, String bId) {

		IDao dao = sqlSession.getMapper(IDao.class);
		
		dao.delete(gId, bId);
		
	}

	@Override
	public Dto view(String gId, String bId) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		return dao.view(gId, bId);
	}

	@Override
	public void update(String gId, String bId, String bWriter, String bTitle, String bContent, int fileCheck) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		dao.update(gId, bId, bWriter, bTitle, bContent, fileCheck);
		
	}

	@Override
	public void countUpdate(String gId, String bId) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		dao.countUpdate(gId, bId);
		
	}
	
	/*-------------- Search 관련 --------------*/

	@Override
	public ArrayList<Dto> searchCount(String gId, String searchType, String keyword) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		return dao.searchCount(gId, searchType, keyword);
	}

	@Override
	public ArrayList<Dto> searchList(String gId, int firNum, int lstNum, String searchType, String keyword) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		return dao.searchList(gId, firNum, lstNum, searchType, keyword);
	}
	
	@Override
	public ArrayList<Dto> searchReplyBIdCount(String gId, String searchType, String keyword) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		return dao.searchReplyBIdCount(gId, searchType, keyword);
	}

	@Override
	public Dto searchReplyBIdList(int gId, int bIds) {

		IDao dao = sqlSession.getMapper(IDao.class);
		
		return dao.searchReplyBIdList(gId, bIds);
	}
	
	/*-------------- File 관련 --------------*/
	
	@Override
	public void fileWrite(int gId, String fName, String rName, double fSize) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
	
		dao.fileWrite(gId, fName, rName, fSize);
		
	}
	
	@Override
	public void fileDelete(String gId, String fId) {
	
		IDao dao = sqlSession.getMapper(IDao.class);
		
		dao.fileDelete(gId, fId);
		
	}

	@Override
	public ArrayList<FileDto> fileView(String gId, String bId) {
	
		IDao dao = sqlSession.getMapper(IDao.class);
		
		return dao.fileView(gId, bId);
	}

	@Override
	public void fileUpdate(int gId, int bId, String fName, String rName, double fSize) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		dao.fileUpdate(gId, bId, fName, rName, fSize);
		
	}	
	
	@Override
	public void fileDownload(HttpServletRequest request, HttpServletResponse response) {

		String path = "C:\\Users\\tosh\\git\\portfolio\\portfolio\\src\\main\\webapp\\resources\\fileRepository";
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
				write(dto.getgId(), dto.getbWriter(), dto.getbPassword(), dto.getbTitle(),
						dto.getbContent(), dto.getFileCheck());
				
				if(!fileList.isEmpty()) {
					for(FileDto file : fileList) {	// DB에 file들 정보 저장.
						
						System.out.println("file.getfName() : " + file.getfName());
						System.out.println("file.getrName() : " + file.getrName());
						System.out.println("file.getfSize() : " + file.getfSize());
						
						fileWrite(dto.getgId(), file.getfName(), file.getrName(), file.getfSize());
					}
				}
			}
		});
		
	}
	
	@Override
	public void deleteWithFile(final String gId, final String bId, final List<FileDto> fileList) {
		
		TransactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				
				System.out.println("delete");
				delete(gId, bId);

				if(!fileList.isEmpty()) {
					for(FileDto file : fileList) {	// DB에 file들 정보 저장.
					
						System.out.println("file.getfId() : " + file.getfId());
					
						String fId = Integer.toString(file.getfId());
						fileDelete(gId, fId);
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
				
				String gId = Integer.toString(dto.getgId());
				String bId = Integer.toString(dto.getbId());
				update(gId, bId, dto.getbWriter(), dto.getbTitle(),	dto.getbContent(), dto.getFileCheck());

				if(!fileList.isEmpty()) {
					for(FileDto file : fileList) {	// DB에 file들 정보 저장.
						
						System.out.println("file.getfName() : " + file.getfName());
						System.out.println("file.getrName() : " + file.getrName());
						System.out.println("file.getfSize() : " + file.getfSize());
						
						fileUpdate(dto.getgId(), dto.getbId(), file.getfName(), file.getrName(), file.getfSize());
					}
				}
				
				if(fIds != null) {
					for(String fId : fIds) {
						
						System.out.println("fileDelete fId : " + fId);
						fileDelete(gId, fId);
						
					}
				}
			}
		});
		
	}

	/*-------------- Reply 관련 --------------*/
	
	@Override
	public void replyWrite(ReplyDto rDto) {
				
		System.out.println("rDto.getrId() : " + rDto.getrId());
		
		if(rDto.getrId() == 0) {
			
			System.out.println("replyWriteOnBoard");						
			replyWriteOnBoard(rDto.getgId(), rDto.getbId(), rDto.getrWriter(), rDto.getrPassword(), rDto.getrContent());
			
		} else {
						
			System.out.println("replyWriteOnReply");						
			int depth = getDepth(rDto.getgId(), rDto.getbId(), rDto.getrId());
			int indent = getIndent(rDto.getgId(), rDto.getbId(), rDto.getrId());
						
			depth = replyDepthChk(rDto.getgId(), rDto.getbId(),
					rDto.getrGroup(), depth, indent);	// depth와 indent로 넣을 depth 위치 찾음.
			
			System.out.println("depth : " + depth);
			
			if(depth == -1) {	// -1이면 맨 밑으로 가고, 아니면 중간에 끼어 듬.
				depth = depthDown(rDto.getgId(), rDto.getbId(), rDto.getrGroup());
			} else {
				depthSort(rDto.getgId(), rDto.getbId(), rDto.getrId(), rDto.getrGroup(), depth);
			}
			
			indent = getIndent(rDto.getgId(), rDto.getbId(), rDto.getrId()) + 1;			
			
			replyWriteOnReply(rDto.getgId(), rDto.getbId(), rDto.getrWriter(), rDto.getrPassword(),
					rDto.getrContent(),	rDto.getrGroup(), depth, indent);
			
		}
	}

	@Override
	public void replyWriteOnBoard(int gId, int bId, String rWriter, String rPassword, String rContent) {
	
		ReplyIDao rDao = sqlSession.getMapper(ReplyIDao.class);
		
		rDao.replyWriteOnBoard(gId, bId, rWriter, rPassword, rContent);
		
	}	

	@Override
	public int replyDepthChk(int gId, int bId, int rGroup, int rDepth, int rIndent) {
		
		ReplyIDao rDao = sqlSession.getMapper(ReplyIDao.class);
				
		return rDao.replyDepthChk(gId, bId, rGroup, rDepth, rIndent);
	}

	@Override
	public ArrayList<ReplyDto> replyView(String gId, String bId) {

		ReplyIDao rDao = sqlSession.getMapper(ReplyIDao.class);
		
		return rDao.replyView(gId, bId);
	}

	
	@Override
	public int getDepth(int gId, int bId, int rId) {
		
		ReplyIDao rDao = sqlSession.getMapper(ReplyIDao.class);
		
		return rDao.getDepth(gId, bId, rId);
	}
	
	@Override
	public int getIndent(int gId, int bId, int rId) {

		ReplyIDao rDao = sqlSession.getMapper(ReplyIDao.class);
		
		return rDao.getIndent(gId, bId, rId);
	}


	@Override
	public int depthDown(int gId, int bId, int rGroup) {
		
		ReplyIDao rDao = sqlSession.getMapper(ReplyIDao.class);
		
		return rDao.depthDown(gId, bId, rGroup);
	}	

	@Override
	public void depthSort(int gId, int bId, int rId, int rGroup, int depth) {
		
		ReplyIDao rDao = sqlSession.getMapper(ReplyIDao.class);
		
		rDao.depthSort(gId, bId, rId, rGroup, depth);
		
	}

	@Override
	public void replyWriteOnReply(int gId, int bId, String rWriter, String rPassword, String rContent,
			int rGroup,	int rDepth, int rIndent) {

		ReplyIDao rDao = sqlSession.getMapper(ReplyIDao.class);
		
		rDao.replyWriteOnReply(gId, bId, rWriter, rPassword, rContent, rGroup, rDepth, rIndent);
		
	}

	@Override
	public boolean replyUpdate(int gId, int bId, int rId, String rWriter, String rPassword, String rContent) {
		
		ReplyIDao rDao = sqlSession.getMapper(ReplyIDao.class);
				
		return (boolean)rDao.replyUpdate(gId, bId, rId, rWriter, rPassword, rContent);
		
	}

	@Override
	public boolean replyDelete(int gId, int bId, int rId, String rPassword) {
		
		ReplyIDao rDao = sqlSession.getMapper(ReplyIDao.class);
				
		return (boolean)rDao.replyDelete(gId, bId, rId, rPassword);
	}
	
	@Override
	public String pwdChk(int gId, int bId) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		return dao.pwdChk(gId , bId);
	}
	
}
