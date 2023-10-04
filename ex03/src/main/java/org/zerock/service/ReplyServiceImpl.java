package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@AllArgsConstructor
@Log4j
@Service //스프링에 Sevice 객체로 인식시키기위해서(현재로는 @Componet 와 동일)
public class ReplyServiceImpl implements ReplyService {
	
	private ReplyMapper mapper;

	@Override
	public int register(ReplyVO vo) {
		log.info("댓글 작성 요청");
		
		return mapper.insert(vo);
	}

	@Override
	public List<ReplyVO> getList(Long bno) {
		
		return mapper.getList(bno);
	}

	@Override
	public int remove(Long rno) {
		
		return mapper.delete(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		return mapper.update(vo);
	}

}
