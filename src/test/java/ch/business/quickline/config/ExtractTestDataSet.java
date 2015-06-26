package ch.business.quickline.config;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;





import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.DatabaseSequenceFilter;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.FilteredDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;



public class ExtractTestDataSet {

    public static void main(String[] args) throws Exception {

        // database connection

    	Class driverClass = Class.forName("com.mysql.jdbc.Driver");

        Connection jdbcConnection = DriverManager.getConnection(

                "jdbc:mysql://localhost:3306/Skillmanager", "root", "");

        IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);



        // partial database export

        QueryDataSet partialDataSet = new QueryDataSet(connection);

        partialDataSet.addTable("abteilung", "SELECT * FROM Abteilung");

        partialDataSet.addTable("Abteilung");

        FlatXmlDataSet.write(partialDataSet,

                new FileOutputStream("abteilung-export.xml"));


        

        // full database export

       
        IDataSet fullDataSet = new FilteredDataSet(new DatabaseSequenceFilter(connection), connection.createDataSet());

        FlatXmlDataSet.write(fullDataSet, new FileOutputStream("db-export.xml"));
        

    }
    }

