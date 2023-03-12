package dal.database;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import dal.ICompanyRepository;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompanyRepository implements ICompanyRepository {
    DBConnector dbConnector = new DBConnector();

    public void GetDepartmentByDNumber() throws SQLServerException {
        try(Statement statement = dbConnector.getConnection().createStatement()) {

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } ;
        return null;
    }

    public void UpdateDepartmentName(String DName, int DNumber) {

    }

    public void CreateDepartment(String DName, int MgrSSN) {

    }
}
