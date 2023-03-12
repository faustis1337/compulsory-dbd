package dal.database;

import dal.ICompanyRepository;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class CompanyRepository implements ICompanyRepository {
    private static final DBConnector databaseConnector = new DBConnector();
    @Override
    public int deleteDepartment(int departmentId) {
        CallableStatement cstmt;
        try{
            String sql = "EXEC dbo.usp_DeleteDepartment ?";
            cstmt = databaseConnector.getConnection().prepareCall (sql);
            cstmt.setInt(1,departmentId);
            cstmt.execute();
            return departmentId;
        } catch (SQLException e) {
            System.out.println(e);
            return -1;
        }
    }
}
