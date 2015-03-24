package ch.quickline.business.dao;

import java.text.MessageFormat;

import org.openrdf.model.Model;
import org.openrdf.model.URI;
import org.openrdf.model.ValueFactory;
import org.openrdf.model.impl.LinkedHashModel;
import org.openrdf.model.impl.ValueFactoryImpl;
import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.query.QueryLanguage;
import org.openrdf.query.TupleQuery;
import org.openrdf.query.TupleQueryResult;
import org.openrdf.query.Update;
import org.openrdf.query.UpdateExecutionException;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.model.Statement;

public class SesameStudentDao implements StudentDao {
	
	public SesameStudentDao(){
		
	}
	
	public void insertStudent(String staffID, String first_name, String last_name) {
		try {
			RepositoryConnection con = SesameDaoFactory.createConnection();
		
		

		
			 

			StringBuilder stringBuilder=new StringBuilder();
			stringBuilder.append("PREFIX ab: <http://people.brunel.ac.uk/~csstnns/university.owl#> \n ");
			stringBuilder.append("PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n ");
			stringBuilder.append("PREFIX owl: <http://www.w3.org/2002/07/owl#> \n ");
			stringBuilder.append("INSERT DATA { ab:Lectuter10 rdf:type owl:NamedIndividual .\n ");
			stringBuilder.append("ab:Lecturer12 rdf:type ab:Lecturer . \n " );
			stringBuilder.append("ab:Lecturer12 ab:staffID ");
			stringBuilder.append("'" + staffID + "'. \n");
			stringBuilder.append("ab:Lecturer12 ab:first_name ");
			stringBuilder.append("'" + first_name + "'. \n");
			stringBuilder.append("ab:Lecturer12 ab:last_name ");
			stringBuilder.append("'" + last_name + "'. \n");
			stringBuilder.append("}  \n");
		
			
		
	

		String updateString = stringBuilder.toString();

		
		
		Update update = con.prepareUpdate(QueryLanguage.SPARQL, updateString);

		update.execute();
		
		System.out.println("Succesfully added a new Student");
		
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
