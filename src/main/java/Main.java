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
                    showCreateDepartment();
                    break;
                case 2:
                    showUpdateDepartmentName();
                    break;
                case 3 :
                    break;
                case 4:
                    break;
                case 5:
                    showGetDepartment();
                    break;
                case 6:
                    break;
            }
        }
    }

    public static void showCreateDepartment(){
        System.out.println("Pls enter the new Department Name: ");
        String newDepartmentName = scanner.nextLine();
        System.out.println("Pls enter the new Department  MgrSSN: ");
        int departmentNumber = scanner.nextInt();
        if (companyRepository.createDepartment(newDepartmentName,departmentNumber) == 1){
            System.out.println("Department created: "+ departmentNumber);
        }else {
            System.out.println("Failed to create the department Name!");
        }
    }
    public static void showUpdateDepartmentName(){
        System.out.println("Pls enter the new Department Name: ");
        String newDepartmentName = scanner.nextLine();
        System.out.println("Pls enter the department Number: ");
        int departmentNumber = scanner.nextInt();
        if (companyRepository.updateDepartmentName(newDepartmentName,departmentNumber)>1){
            System.out.println("Department updated"+ departmentNumber);
        }else {
            System.out.println("Failed to update the department Name!");
        }
    }

    public static void showGetDepartment(){
        System.out.println("Pls enter the new Department Number: ");
        int departmentNumber = scanner.nextInt();
        Department department = companyRepository.getDepartmentByDNumber(departmentNumber);

        if (department == null){
            System.out.println("Failed to get the department");
        }else {
            System.out.println("Name: "+department.dName + " No: "+ department.dNumber + " MgrSSN: " + department.mgrSSN + " MgrStartDate: " +department.mgrStartDate + " EmpCount: "+ department.empCount);
        }
    }



}