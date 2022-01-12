package com.poscoict.emaillist01.dao.test;

import com.poscoict.emaillist01.dao.EmaillistDao;
import com.poscoict.emaillist01.vo.EmaillistVo;
import java.util.List;

public class EmaillistDaoTest {

	public static void main(String[] args) {
		testFindAll();
	}
	
	public static void testFindAll() {
		List <EmaillistVo> list = new EmaillistDao().findAll();
		for(EmaillistVo vo:list) {
			System.out.println(vo);
			}
		
	}

}
