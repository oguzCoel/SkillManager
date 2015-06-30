package ch.business.quickline.story;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
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
}
