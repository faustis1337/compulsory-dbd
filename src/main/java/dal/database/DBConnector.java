package dal.database;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;

public class DBConnector {

    private SQLServerDataSource ds;


    public DBConnector()
    { ds = new SQLServerDataSource();
        ds.setServerName("10.176.111.31");
        ds.setUser("CSe20B_6");
        ds.setPassword("CSe20B_6");
        ds.setDatabaseName("Company99");

    }

    public Connection getConnection()throws SQLServerException
    {
        return ds.getConnection();
    }
}
