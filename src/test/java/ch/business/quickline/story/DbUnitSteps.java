package ch.business.quickline.story;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.DatabaseSequenceFilter;
import org.dbunit.dataset.FilteredDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DbUnitSteps {
	

  @Autowired
  private DataSource dataSource;

  @BeforeStory
	  public void deleteAllData() throws SQLException, DatabaseUnitException {
		   
  }
  /*
  @AfterStory
  	public void insertAllData()throws SQLException, DatabaseUnitException, FileNotFoundException, IOException{
	  DatabaseDataSourceConnection connection = new DatabaseDataSourceConnection(dataSource);
	  @SuppressWarnings("deprecation")
	IDataSet fullDataSet = new FlatXmlDataSet(new File("/dbunit/db-export.xml"));
      DatabaseOperation.INSERT.execute(connection, fullDataSet);
	 
  }
  */
}
