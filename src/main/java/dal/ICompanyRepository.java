package dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.util.List;

public interface ICompanyRepository {

void GetDepartmentByDNumber() throws SQLServerException;
void UpdateDepartmentName(String DName, int DNumber);
void CreateDepartment(String DName, int MgrSSN );
}
