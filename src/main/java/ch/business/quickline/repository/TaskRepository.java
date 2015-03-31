package ch.business.quickline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.business.quickline.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
