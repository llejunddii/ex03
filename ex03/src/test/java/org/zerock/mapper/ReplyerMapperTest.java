package org.zerock.mapper;

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
public class ReplyerMapperTest {
	
	@Autowired
	private ReplyMapper mapper;
	
	@Test
	public void testInsert() {
		
		ReplyVO vo = new ReplyVO();
		vo.setBno(47L);
		vo.setReply("댓글 테스트");
		vo.setReplyer("나다");
		
		log.info("등록 테스트@@@@@@"+vo);
		mapper.insert(vo);
	}
	@Test
	public void testGetList() {
//		ReplyVO vo = new ReplyVO();
//		vo.setBno(47L);
		
		log.info("목록 화면 테스트 !!!!!!!!!!!!");
		mapper.getList(47L);
	}
	@Test
	public void testUpdate() {
		ReplyVO vo = new ReplyVO();
		vo.setRno(2L);
		vo.setReply("댓글수정이지롱");
		
		log.info("수정 테스트다아아아아아아아ㅏㅇ아아아ㅏ아아아아아아"+vo);
		mapper.update(vo);
	}
	@Test
	public void testDelete() {
//		ReplyVO vo = new ReplyVO();
//		vo.setRno(3L);
		
		log.info("지우는 테스트 할꺼임!!!!@@@%%%%%%%%");
		mapper.delete(6L);
		
	}

}
