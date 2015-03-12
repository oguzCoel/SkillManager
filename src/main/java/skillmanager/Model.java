package skillmanager;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

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

public class Model {

	public static void main(String[] args) throws RepositoryException, MalformedQueryException, QueryEvaluationException {
		
	
	ArrayList<String> list = new ArrayList<String>();
	String sesameServer = "http://localhost:8080/openrdf-sesame";
	String repositoryId = "uni";
	

		
		
	
		//Verbindung mit Repository erstellen
		Repository repo = new HTTPRepository(sesameServer, repositoryId);
		repo.initialize();
		
		RepositoryConnection con = repo.getConnection();
		String queryString = "PREFIX AB: <http://people.brunel.ac.uk/~csstnns/university.owl#> SELECT ?z WHERE {AB:Lecturer1 AB:teaches ?z}";
		TupleQuery tupleQuery = con.prepareTupleQuery(QueryLanguage.SPARQL, queryString);
		
		TupleQueryResult result = tupleQuery.evaluate();
		
		while (result.hasNext()){
			BindingSet bindingSet = result.next();
			//Value valueOfX = bindingSet.getValue("x");
			//Value valueOfY = bindingSet.getValue("y");
			Value valueOfZ = bindingSet.getValue("z");
			
			if (valueOfZ.toString().contains("#")){
			
			String [] rec = valueOfZ.stringValue().split("#");
			String a = rec[0];
			String b = rec[1];
			list.add(b);
			
			
			}
		}
		
		for (String s: list){
			System.out.println(s);
		}
		
	}
			
}
	
	
		
	


