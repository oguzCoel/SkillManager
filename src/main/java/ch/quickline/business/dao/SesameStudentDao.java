package ch.quickline.business.dao;

import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.query.QueryLanguage;
import org.openrdf.query.TupleQuery;
import org.openrdf.query.TupleQueryResult;
import org.openrdf.query.Update;
import org.openrdf.query.UpdateExecutionException;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;

public class SesameStudentDao implements StudentDao {
	
	public SesameStudentDao(){
		
	}
	
	public void insertStudent() {
		try {
			RepositoryConnection con = SesameDaoFactory.createConnection();
		
		
		String updateString = "PREFIX ab: <http://people.brunel.ac.uk/~csstnns/university.owl#> PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> INSERT DATA { ab:Student7 rdf:type owl:NamedIndividual }";
		Update update = con.prepareUpdate(QueryLanguage.SPARQL, updateString);
		
		update.execute();
		
		} 
		catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (UpdateExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteStudent(){
		
	
	}
	
	public void findStudent(){
		
	}

}
