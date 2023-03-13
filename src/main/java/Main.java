import be.Department;
import dal.ICompanyRepository;
import dal.database.CompanyRepository;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static ICompanyRepository companyRepository = new CompanyRepository();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while(true){
            System.out.println("1: Create Department");
            System.out.println("2: Update Department Name");
            System.out.println("3: Update Department Manager");
            System.out.println("4: Delete Department");
            System.out.println("5: Get Department");
            System.out.println("6: Get All Departments");
            System.out.print("Enter number selection: ");

            int selection = scanner.nextInt();
            switch(selection){
                case 1:
                    break;
                case 2:
                    break;
                case 3 :
                    showUpdateDepartmentManager();
                    break;
                case 4:
                    showDeleteDepartment();
                    break;
                case 5:
                    break;
                case 6:
                    showGetAllDepartments();
                    break;
            }
        }
    }

    public static void showUpdateDepartmentManager(){
        System.out.print("Enter department number: ");
        int departmentNumber = scanner.nextInt();
        System.out.print("Enter MgrSSN: ");
        int mgrSSN = scanner.nextInt();
        if(companyRepository.updateDepartmentManager(departmentNumber,mgrSSN)==1){
            System.out.println("Manager has been updated!");
        }else{
            System.out.println("Failed to update manager...");
        }
    }

    public static void showDeleteDepartment(){
        System.out.print("Enter department number: ");
        int departmentNumber = scanner.nextInt();
        if(companyRepository.deleteDepartment(departmentNumber)>0){
            System.out.println("Successfully deleted department with number: "+departmentNumber);
        }else{
            System.out.println("Failed to delete department...");
        }
    }

    public static void showGetAllDepartments(){
        List<Department> allDepartments = companyRepository.getAllDepartments();
        for(int i = 0; i<allDepartments.size();i++){
            Department department = allDepartments.get(i);
            System.out.println(i+1+"| Name: "+department.dName + " No: "+ department.dNumber + " MgrSSN: " + department.mgrSSN + " MgrStartDate: " +department.mgrStartDate + " EmpCount: "+ department.empCount);
        }
    }

}