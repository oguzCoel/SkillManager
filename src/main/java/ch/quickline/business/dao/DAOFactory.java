package ch.quickline.business.dao;

public abstract class DAOFactory {
	public static final String SESAME = "sesame";
	public static final String MYSQL = "mysql";
	
	public abstract StudentDao getStudentDao();
	
	public static DAOFactory getDAOFactory(PersistenceType type){
		switch (type){
		case SESAME:
			return new SesameDaoFactory();
		/*
		case "mysql":
			return new MysqlDbDaoFactory();
			*/
			default:
			return null;
		}
	}

}
