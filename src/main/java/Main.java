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
                    showUpdateDepartmentManager();
                    break;
                case 4:
                    showDeleteDepartment();
                    break;
                case 5:
                    showGetDepartment();
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