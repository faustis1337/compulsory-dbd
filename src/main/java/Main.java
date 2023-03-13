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
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
        }
    }
}