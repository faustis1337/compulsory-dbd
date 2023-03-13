package dal.database;

import be.Department;
import dal.ICompanyRepository;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
    public Department GetDepartmentByDNumber(int dNumber){
        CallableStatement cstmt;
        Department temp = null;
        try{
            String sql = "EXEC usp_GetDepartmentByDNumber ?";
            cstmt = databaseConnector.getConnection().prepareCall (sql);
            cstmt.setInt(1,dNumber);
            cstmt.execute();
            ResultSet resultSet = cstmt.executeQuery();

            while (resultSet.next()) {
                String dName = resultSet.getString("DName");
                int dnumber = resultSet.getInt("DNumber");
                int mGrSSN = resultSet.getInt("MgrSSN");
                Date mGrStartdate = resultSet.getDate("MgrStartdate");
                int empCount = resultSet.getInt("EmpCount");
                temp = new Department(dName, dnumber, mGrSSN, mGrStartdate, empCount );

            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return temp;
    }

    @Override
    public void UpdateDepartmentName(String dName, int dNumber) {
        CallableStatement cstmt;
        try{
            String sql = "EXEC usp_UpdateDepartmentName ?,?";
            cstmt = databaseConnector.getConnection().prepareCall (sql);
            cstmt.setString(1,dName);
            cstmt.setInt(2,dNumber);
            cstmt.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void CreateDepartment(String dName, int mGrSSN) {
        CallableStatement cstmt;
        Date date = Date.valueOf(LocalDate.now());
        try{
            String sql = "EXEC usp_CreateDepartment ?,?,?";
            cstmt = databaseConnector.getConnection().prepareCall (sql);
            cstmt.setString(1,dName);
            cstmt.setInt(2,mGrSSN);
            cstmt.setDate( 3, date);
            cstmt.execute();
        } catch (SQLException e) {
            System.out.println(e);
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
