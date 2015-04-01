package ch.business.quickline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ch.business.quickline.domain.Berechtigung;

public interface BerechtigungRepository extends JpaRepository<Berechtigung, Integer> {

}
