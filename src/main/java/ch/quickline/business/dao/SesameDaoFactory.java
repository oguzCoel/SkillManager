package ch.quickline.business.dao;

import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.http.HTTPRepository;

public class SesameDaoFactory extends DAOFactory {
	static RepositoryConnection con = null;
	public static final String sesameServer = "http://localhost:8080/openrdf-sesame";
	public static final String repositoryId = "uni";
	
		public static RepositoryConnection createConnection() throws RepositoryException{
			Repository repo = new HTTPRepository(sesameServer, repositoryId);
			try {
				repo.initialize();
			} catch (RepositoryException e) {
				System.out.println("repository could not initialized");
				e.printStackTrace();
			}
			
			
				con = repo.getConnection();
				return con;
	}
		
		public StudentDao getStudentDao(){
			return new SesameStudentDao();
		}
		
		public LecturerDao getLecturerDao(){
			return new LecturerDao;
		}

}
