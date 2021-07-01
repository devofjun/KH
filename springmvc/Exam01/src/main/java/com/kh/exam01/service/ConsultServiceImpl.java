package com.kh.exam01.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.exam01.domain.ConsultVo;
import com.kh.exam01.persitence.ConsultDao;
import com.kh.exam01.persitence.StudentDao;


@Service
public class ConsultServiceImpl implements ConsultService {
	
	@Inject
	ConsultDao consultDao;
	
	@Inject
	StudentDao studentDao;
	
	@Override
	//@Transactional
	public List<ConsultVo> showStdConsult(int sno) {
		List<ConsultVo> list = consultDao.selectConsult(sno);
		return list;
	}

}
