package ch.business.quickline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.business.quickline.domain.LernObjekt;
import ch.business.quickline.repository.LernObjektRepository;

@Service("lernobjektService")
@Transactional
public class LernObjektServiceImpl implements LernObjektService {
	
	@Autowired
	LernObjektRepository lernObjektRepository;

	public LernObjekt save(LernObjekt lernObjekt) {
		
		return lernObjektRepository.save(lernObjekt);
	}

}
