package skillmanager;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import org.openrdf.model.Value;
import org.openrdf.query.QueryLanguage;
import org.openrdf.query.TupleQuery;
import org.openrdf.repository.RepositoryConnection;

@ManagedBean
public class Model {
	private ArrayList<Value> list;
	
	public Model(){
		
		list = new ArrayList<Value>();
	
		//Verbindung mit Repository erstellen
		//RepositoryConnection con = repo.getConnection();
		
		
			//Query definieren
			String queryString = "SELECT * {?x ?y ?z}";
		//	TupleQuery tupleQuery = con.prepareTupleQuery(QueryLanguage.SPARQL, queryString);
			
	}
	

}
