import be.Department;
import dal.ICompanyRepository;
import dal.database.CompanyRepository;

import java.util.List;

public class Main {
    private static ICompanyRepository companyRepository = new CompanyRepository();
    public static void main(String[] args) {
        System.out.println(companyRepository.updateDepartmentManager(7,888665555));
    }
}