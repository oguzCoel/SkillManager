package ch.business.quickline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.business.quickline.domain.Task;
import ch.business.quickline.repository.TaskRepository;

@Service("taskService")
@Transactional
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	TaskRepository taskRepository;

	public Task save(Task task) {
		
		return taskRepository.save(task);
	}

}
