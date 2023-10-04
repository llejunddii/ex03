package org.zerock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;

import lombok.extern.log4j.Log4j;

@RestController // data로 응답하겠다.
@RequestMapping("/sample")
@Log4j
public class SampleController {
	
	@GetMapping(value="/getText",produces="text/plain;charset=UTF-8")
	public String getText() {
		log.info("MIME Type : "+ MediaType.TEXT_PLAIN_VALUE);
		
		return "안녕하세요";
	}
	
	@GetMapping(value="/getSample",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		SampleVO vo = new SampleVO(1,"오늘은","수요일");
		
		return vo;
		
		// json 변환 라이브러리만 있으면 json르로
		// xml 변환 라이브러리만 있으면 xml
		// 둘다있으면 xml으로 변환 된다 (xml이 우선순위가 높음)
		// URL뒤에 .json 으로 하면 json르로 .xml로 하면 xml로 처리된다.
	}
	
	@GetMapping("/getList")
	public List<SampleVO> getList() {
//		List<SampleVO> list = new ArrayList<>(); 
//		for(int i=0; i < 10; i++) {
//			SampleVO vo = new SampleVO(i,"성"+i,"이름"+i);
//			list.add(vo);
//		}
		
		List<SampleVO> list = IntStream.range(0, 10).mapToObj(i -> new SampleVO(i,"성"+i,"이름"+i)).collect(Collectors.toList());
		
		return list;
		
	}
	
	@GetMapping("/getMap")
	public Map<String,SampleVO> getMap(){
		Map<String,SampleVO> map = new HashMap<>();
		map.put("나는키값",new SampleVO(1,"오늘은","수요일"));
		
		return map;
		
	}
	
	// /sample/check?height=140&weight=50
	@GetMapping(value="/check",params= {"height","weight"}) // params : 특정키값이 존재하게 제한 (파라미터 없으면 400에러 처리)
	public ResponseEntity<SampleVO> check(int height,int weight) {
	  SampleVO vo =	new SampleVO(1,height+"",weight+"");
	  
	  ResponseEntity<SampleVO> result=null;
	  
	  if(height<150)
		  result= ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
	  else
		  result= ResponseEntity.status(HttpStatus.OK).body(vo);
		
	  return result;
	}
	
	// p.366 URL에 있는 값 읽는법
	
	// /sample/product/원하는글자/원하는숫자
	// /sample/product/bags/123
	
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat,@PathVariable("pid") Integer pid) {
		
		return new String[] {"cat값 : "+cat,"pid값 : "+pid};
		
	}
	
	// 보낸 데이터를 읽는법
	
	@PostMapping("/ticket")
	public SampleVO convert(@RequestBody SampleVO vo) {
		
		log.info("수집이 잘되는지 확인" + vo);
		
		return vo;
		
	}
	
	

}





















