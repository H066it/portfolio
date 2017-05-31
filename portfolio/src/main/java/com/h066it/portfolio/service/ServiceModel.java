package com.h066it.portfolio.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h066it.portfolio.dao.IDao;
import com.h066it.portfolio.dto.Dto;
import com.h066it.portfolio.dto.FileDto;

@Service
public class ServiceModel implements IDao {

	@Autowired
	private SqlSession sqlSession;
	
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

}
