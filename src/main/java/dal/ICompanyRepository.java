package dal;

import be.Department;

import java.util.List;

public interface ICompanyRepository {
    int deleteDepartment(int departmentId);
    int updateDepartmentManager(int departmentNumber,int managerSSN);
    List<Department> getAllDepartments();
    Department GetDepartmentByDNumber(int dNumber);
    void UpdateDepartmentName(String dName, int dNumber);
    void CreateDepartment(String dName, int dgrSSN );
}
