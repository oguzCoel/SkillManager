package ch.quickline.business.dao;

public interface StudentDao {
	public void insertStudent(String staffID, String first_name, String last_name);
	public void deleteStudent();
	public void findStudent();
	

}
