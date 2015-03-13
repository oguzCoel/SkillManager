package ch.quickline.business.domain;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.openrdf.model.Value;
import org.openrdf.query.BindingSet;
import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.query.QueryLanguage;
import org.openrdf.query.TupleQuery;
import org.openrdf.query.TupleQueryResult;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.http.HTTPRepository;

@ManagedBean
@SessionScoped
public class LecturerBean {
	static RepositoryConnection con = null;
	
	private final String sesameServer = "http://localhost:8080/openrdf-sesame";
	private final String repositoryId = "uni";
	
	public RepositoryConnection getConnection() throws RepositoryException{
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
	
	public ArrayList<Lecturer> getLecturerList() throws RepositoryException, MalformedQueryException, QueryEvaluationException{
		ArrayList<Lecturer> lecturers = new ArrayList<Lecturer>();
		Lecturer lecturer = new Lecturer();
		con = getConnection();
		String queryString = "PREFIX ab: <http://people.brunel.ac.uk/~csstnns/university.owl#> SELECT ?first_name ?last_name ?modul WHERE { ab:Lecturer1 ab:first_name ?first_name .  ab:Lecturer1 ab:last_name ?last_name . ab:Lecturer1  ab:teaches ?modul}";
																																																																																																																																																																									
		TupleQuery tupleQuery = con.prepareTupleQuery(QueryLanguage.SPARQL, queryString);
		TupleQueryResult result = tupleQuery.evaluate();
		
		while (result.hasNext()){
			BindingSet bindingSet = result.next();
			Value valueOfFirstName = bindingSet.getValue("first_name");
			Value valueOfLastName = bindingSet.getValue("last_name");
			Value valueOfModul = bindingSet.getValue("modul");
			
			String fname = valueOfFirstName.stringValue();
			lecturer.setFirst_name(fname);
			
			String lname = valueOfLastName.stringValue();
			lecturer.setLast_name(lname);
			
			
			if (valueOfModul.stringValue().contains("#")){
				String [] rec2 = valueOfModul.stringValue().split("#");
				String mod = rec2[1];
				lecturer.setModul(mod);
			}
			
			lecturers.add(lecturer);
			
			
		}
		
		return lecturers;
		
	}
	
}