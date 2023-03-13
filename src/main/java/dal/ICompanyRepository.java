package dal;

import be.Department;

import java.util.List;

public interface ICompanyRepository {
    int deleteDepartment(int departmentId);
    int updateDepartmentManager(int departmentNumber,int managerSSN);
    List<Department> getAllDepartments();
    Department GetDepartmentByDNumber(int dNumber);
    int UpdateDepartmentName(String dName, int dNumber);
    int CreateDepartment(String dName, int dgrSSN );
}
