package com.kh.sample01;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.sample01.dao.MemberDao;
import com.kh.sample01.vo.MemberVo;



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
	
	@Test
	public void TESTINSERTMEMBER() throws Exception {
		MemberVo memberVo = new MemberVo("kim", "1234", "김길동", "kim@gmail.com", null, null);
		memberDao.insertMember(memberVo);
	}
	
	@Test
	public void testSelectMember() throws Exception{
		MemberVo memberVo = memberDao.selectMember("hong");
		System.out.println("test_memberVo: "+memberVo);
	}
	
	@Test
	public void testLogin() throws Exception{
		MemberVo memberVo = memberDao.login("hong", "12345");
		System.out.println("##Login:"+memberVo);
	}
	
	@Test
	public void testUpdate() throws Exception {
		MemberVo memberVo = new MemberVo("hong", "1234", "김길동", "hh@gmail.com", null, null);
		memberDao.updateMember(memberVo);
	}
	
	@Test
	public void testDelete() throws Exception {
		memberDao.deleteMember("hong");
	}
	
	@Test
	public void testMemberList() throws Exception {
		List<MemberVo> list = memberDao.memberList();
		System.out.println(list);
	}
}
