package com.h066it.portfolio.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.h066it.portfolio.dao.IDao;
import com.h066it.portfolio.dto.Dto;
import com.h066it.portfolio.dto.FileDto;

@Service
public class ServiceModel implements IDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private TransactionTemplate TransactionTemplate; 
	
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
	public void write(String bWriter, String bTitle, String bContent) {

		IDao dao = sqlSession.getMapper(IDao.class);

		dao.write(bWriter, bTitle, bContent);
		
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
	public void update(String bId, String bWriter, String bTitle, String bContent) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		dao.update(bId, bWriter, bTitle, bContent);
		
	}

	@Override
	public void countUpdate(String bId) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		dao.countUpdate(bId);
		
	}

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

	@Override
	public void fileWrite(String fName, String rName, double fSize) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
	
		dao.fileWrite(fName, rName, fSize);
		
	}

	@Override
	public ArrayList<FileDto> fileView(String bId) {
	
		IDao dao = sqlSession.getMapper(IDao.class);
		
		return dao.fileView(bId);
	}

	@Override
	public void writeWithFile(final Dto dto, final List<FileDto> fileList) {
		// TODO Auto-generated method stub
		
		TransactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				
				System.out.println("write");
				write(dto.getbWriter(), dto.getbTitle(), dto.getbContent());

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

}
