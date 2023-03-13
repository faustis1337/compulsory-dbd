package dal.database;

import be.Department;
import dal.ICompanyRepository;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            return -1;
        }
    }

    @Override
    public int updateDepartmentManager(int departmentNumber, int managerSSN) {
        CallableStatement cstmt;
        try{
            String sql = "EXEC dbo.usp_UpdateDepartmentManager ?, ?";
            cstmt = databaseConnector.getConnection().prepareCall (sql);
            cstmt.setInt(1,departmentNumber);
            cstmt.setInt(2,managerSSN);
            int rowsAffected = cstmt.executeUpdate();
            if(rowsAffected>0){
                return 1;
            }
        } catch (SQLException ignored) {}
        return -1;
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> departmentList = new ArrayList<>();

        CallableStatement cstmt;
        try{
            String sql = "EXEC dbo.usp_GetAllDepartments";
            cstmt = databaseConnector.getConnection().prepareCall (sql);
            cstmt.execute();
            ResultSet rs = cstmt.getResultSet();
            while(rs.next()){
                departmentList.add(new Department(rs.getString("Dname"),rs.getInt("Dnumber"),rs.getInt("MgrSSN"),rs.getDate("MgrStartDate"),rs.getInt("EmpCount")));
            }
        } catch (SQLException ignored) {}
        return departmentList;
    }
}
