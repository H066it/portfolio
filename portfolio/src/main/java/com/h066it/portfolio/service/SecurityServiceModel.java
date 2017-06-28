package com.h066it.portfolio.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.h066it.portfolio.dao.SecurityIDao;
import com.h066it.portfolio.dto.MemberDto;

@Service
public class SecurityServiceModel implements SecurityIDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private TransactionTemplate TransactionTemplate; 
	
	/*-------------- 회원가입 관련 --------------*/
	
	@Override
	public void signUpOnMember(String id, String pwd) {

		SecurityIDao sDao = sqlSession.getMapper(SecurityIDao.class);
		
		sDao.signUpOnMember(id, pwd);
		
	}
	
	@Override
	public void signUpOnAuthorities(String id) {
		
		SecurityIDao sDao = sqlSession.getMapper(SecurityIDao.class);
		
		sDao.signUpOnAuthorities(id);
		
	}

	@Override
	public boolean signUp(final MemberDto mDto) {

		SecurityIDao sDao = sqlSession.getMapper(SecurityIDao.class);
		
		String idChk = sDao.memberIdChk(mDto.getId());
		
		if(idChk == null) {
			
			TransactionTemplate.execute(new TransactionCallbackWithoutResult() {
				
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					
					signUpOnMember(mDto.getId(), mDto.getPwd());					
					signUpOnAuthorities(mDto.getId());					
					System.out.println("sign Up success!");
				}
			});	
			
			return true;
		} else {			
			System.out.println("sign Up fail!");
			return false;
		}
	}

	@Override
	public String memberIdChk(String id) {

		SecurityIDao sDao = sqlSession.getMapper(SecurityIDao.class);
		
		return sDao.memberIdChk(id);
	}

}
