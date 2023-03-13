package dal;

import be.Department;

public interface ICompanyRepository {
    int deleteDepartment(int departmentId);
    Department GetDepartmentByDNumber(int dNumber);
    void UpdateDepartmentName(String dName, int dNumber);
    void CreateDepartment(String dName, int dgrSSN );
}
