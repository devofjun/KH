package com.kh.sample01;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.sample01.dao.MemberDao;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDaoTest {
	//@Autowired // spring에서 지원함
	@Inject // 자바에서 지원함 둘 다 똑같음
	private MemberDao memberDao;
	
	
	// 반드시 아래 형태가 되어야 한다.
	// public, 매개변수 없음, throws 해야함
	@Test
	public void testGetTime() throws Exception{
		memberDao.getTime();
	}
}
