package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplySeviceTest {
	
	@Autowired
	private ReplyService service;
	
	@Test
	public void register() {
		ReplyVO vo = new ReplyVO();
		vo.setBno(47L);
		vo.setReply("안녕하세요~~");
		vo.setReplyer("접니다");
		log.info("!!댓글 등록 테스트!!");
		service.register(vo);
	}
	@Test
	public void getList() {
		service.getList(47L);
		log.info("이것은 목록 가져오기 테스트!!!!!!!");
		
	
	}
	@Test
	public void remove() {
		service.remove(17L);
		log.info("이것은 삭제 테스트으으으");
	}
	@Test
	public void modify() {
		ReplyVO vo = new ReplyVO();
		vo.setRno(20L);
		vo.setReply("짜라라라라란");
		service.modify(vo);
	}
	
	
	

}
