package dal;

import be.Department;

import java.util.List;

public interface ICompanyRepository {
    int deleteDepartment(int departmentId);
    int updateDepartmentManager(int departmentNumber,int managerSSN);
    List<Department> getAllDepartments();
}
