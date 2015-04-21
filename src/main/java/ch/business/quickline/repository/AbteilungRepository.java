package ch.business.quickline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ch.business.quickline.domain.Abteilung;

public interface AbteilungRepository extends JpaRepository<Abteilung, Integer> {
	

}
