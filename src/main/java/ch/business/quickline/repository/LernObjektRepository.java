package ch.business.quickline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.business.quickline.domain.LernObjekt;

public interface LernObjektRepository extends JpaRepository<LernObjekt, Integer> {

}
