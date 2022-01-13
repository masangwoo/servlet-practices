package com.poscoict.guestbook01.dao.test;

import java.util.List;

import com.poscoict.guestbook01.dao.GuestbookDao;
import com.poscoict.guestbook01.vo.GuestbookVo;

public class GuestbookDaoTest {

	public static void main(String[] args) {
		testInsert();
		//testFindAll();
		//testDelete();
	}
	
	
	
	private static void testDelete() {
		GuestbookVo vo = new GuestbookVo();
		
		vo.setNo(1);
		vo.setPassword("");
		
		boolean result = new GuestbookDao().insert(vo);
		System.out.println(result ? "success" : "fail");
		
	}



	private static void testInsert() {
		GuestbookVo vo = new GuestbookVo();
		
		vo.setName("마상우");
		vo.setPassword("1234");		
		vo.setMessage("안녕");
		
		boolean result = new GuestbookDao().insert(vo);
		System.out.println(result ? "success" : "fail");
	}



	public static void testFindAll() {
		List <GuestbookVo> list = new GuestbookDao().findAll();
		for(GuestbookVo vo:list) {
			System.out.println(vo);
			}
		//assertEqual(2,list.size());
	}

}
