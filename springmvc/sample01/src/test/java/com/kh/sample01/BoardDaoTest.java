package com.kh.sample01;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.sample01.dao.BoardDao;
import com.kh.sample01.vo.BoardVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDaoTest {

	
	@Inject
	@Qualifier("dao1") // 한정하다. => 여러개의 BoardDao를 구현한 클래스가 있어서 환개를 지정해줘야한다.
	private BoardDao boardDao;
	
	@Test
	public void testBoardDao() throws Exception {
		System.out.println("Test:"+boardDao);
	}
	
	@Test
	public void testInsertArticle() throws Exception {
		System.out.println("+++testInsertArticle+++");
		BoardVo boardVo = new BoardVo();
		boardVo.setB_title("제목2");
		boardVo.setB_content("내용2");
		boardVo.setUser_id("hong");
		boardDao.insertArticle(boardVo);
	}
	
	@Test
	public void testSelectByBno() throws Exception {
		int b_no = 2;
		boardDao.selectByBno(b_no);
	}
	
	@Test
	public void testUpdateArticle() throws Exception {
		BoardVo boardVo = new BoardVo();
		boardVo.setB_title("제목3");
		boardVo.setB_content("내용3");
		boardVo.setB_no(3);
		boardDao.updateArticle(boardVo);
	}
	
	@Test
	public void testDeleteArticle() throws Exception {
		int b_no = 3;
		boardDao.deleteArticle(b_no);
	}
	
	@Test
	public void testListAll() throws Exception {
		List<BoardVo> list = boardDao.listAll();
		System.out.println(list);
	}
}
