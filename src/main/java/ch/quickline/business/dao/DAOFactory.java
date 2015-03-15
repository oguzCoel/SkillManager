package ch.quickline.business.dao;

public abstract class DAOFactory {
	public static final String SESAME = "sesame";
	public static final String MYSQL = "mysql";
	
	public abstract LecturerDao getLecturerDao();
	public abstract StudentDao getStudentDao();
	
	public static DAOFactory(String whichfactory){
		switch (whichfactory){
		case "sesame":
			return new SesameDaoFactory();
		case "mysql":
			return new MysqlDbDaoFactory();
			
			default
			return null;
		}
	}

}
