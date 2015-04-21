package ch.business.quickline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.business.quickline.domain.Projekt;

public interface ProjektRepository extends JpaRepository<Projekt, Integer> {

}
