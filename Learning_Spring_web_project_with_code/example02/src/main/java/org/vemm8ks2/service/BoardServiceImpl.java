package org.vemm8ks2.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.vemm8ks2.domain.BoardVO;
import org.vemm8ks2.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	// spring 4.3 �̻󿡼� �ڵ� ó��
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {

		log.info("register: " + board);
		
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {

		log.info("get ...");
		
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {

		log.info("modify ... " + board);
		
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {

		log.info("remove ... " + bno);
		
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList() {

		log.info("getList ...");
		
		return mapper.getList();
	}
	
}
