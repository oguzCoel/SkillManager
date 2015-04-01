package ch.business.quickline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ch.business.quickline.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
