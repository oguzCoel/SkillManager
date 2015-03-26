package ch.quickline.business.domain;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ch.quickline.business.dao.DAOFactory;
import ch.quickline.business.dao.PersistenceType;
import ch.quickline.business.dao.StudentDao;

@ManagedBean (name = "student")
@SessionScoped
public class StudentBean {
	private String staffID;
	private String first_name;
	private String last_name;
	
	
	public String getStaffID() {
		return staffID;
	}
	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public void insertStudent(){

		DAOFactory sesFac = DAOFactory.getDAOFactory(PersistenceType.SESAME);
		
		StudentDao studentDao = sesFac.getStudentDao();
		
		studentDao.insertStudent(staffID, first_name, last_name);
		
		
	}
	

}
