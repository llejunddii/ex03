package org.zerock.service;

import java.util.List;

import org.zerock.domain.ReplyVO;

public interface ReplyService {
	
	// 댓글등록
		int register(ReplyVO vo);
	
	// 해당글에 대한 댓글보기
		List<ReplyVO> getList(Long bno);
	
	// 댓글 삭제
		int remove(Long rno);
	
	// 댓글 수정
		int modify(ReplyVO vo);

}
