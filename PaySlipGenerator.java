/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package payslipgenerator;

/**
 *
 * @author kowsi
 */
/*public class PaySlipGenerator {

    /**
     * @param args the command line arguments
     */
   // public static void main(String[] args) {
        // TODO code application logic here
   // }
    
//}
import java.util.Scanner;

class Employee {
    protected String emp_name;
    protected int emp_id;
    protected String address;
    protected String mail_id;
    protected String mobile_no;
    protected double basicPay;

    public Employee(String emp_name, int emp_id, String address, String mail_id, String mobile_no, double basicPay) {
        this.emp_name = emp_name;
        this.emp_id = emp_id;
        this.address = address;
        this.mail_id = mail_id;
        this.mobile_no = mobile_no;
        this.basicPay = basicPay;
    }

    public double calculateDA() {
        return 0.0;
    }

    public double calculateHRA() {
        return 0.0;
    }

    public double calculatePF() {
        return 0.0;
    }

    public double calculateStaffClubFund() {
        return 0.0;
    }

    public double calculateGrossSalary() {
        return basicPay + calculateDA() + calculateHRA();
    }

    public double calculateNetSalary() {
        return calculateGrossSalary() - calculatePF() - calculateStaffClubFund();
    }
}

class Programmer extends Employee {
    public Programmer(String emp_name, int emp_id, String address, String mail_id, String mobile_no, double basicPay) {
        super(emp_name, emp_id, address, mail_id, mobile_no, basicPay);
    }

    @Override
    public double calculateDA() {
        return 0.97 * basicPay;
    }

    @Override
    public double calculateHRA() {
        return 0.10 * basicPay;
    }

    @Override
    public double calculatePF() {
        return 0.12 * basicPay;
    }

    @Override
    public double calculateStaffClubFund() {
        return 0.001 * basicPay;
    }
}

class AssistantProfessor extends Employee {
    public AssistantProfessor(String emp_name, int emp_id, String address, String mail_id, String mobile_no, double basicPay) {
        super(emp_name, emp_id, address, mail_id, mobile_no, basicPay);
    }

    @Override
    public double calculateDA() {
        return 0.98 * basicPay;
    }

    @Override
    public double calculateHRA() {
        return 0.12 * basicPay;
    }

    @Override
    public double calculatePF() {
        return 0.15 * basicPay;
    }

    @Override
    public double calculateStaffClubFund() {
        return 0.002 * basicPay;
    }
}

public class PaySlipGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter employee details for Programmer:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Employee ID: ");
        int empId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Email ID: ");
        String email = scanner.nextLine();
        System.out.print("Mobile Number: ");
        String mobile = scanner.nextLine();
        System.out.print("Basic Pay: ");
        double basicPayProgrammer = scanner.nextDouble();

        Programmer programmer = new Programmer(name, empId, address, email, mobile, basicPayProgrammer);

        System.out.println("\nEnter employee details for Assistant Professor:");
        System.out.print("Name: ");
        name = scanner.nextLine();
        System.out.print("Employee ID: ");
        empId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Address: ");
        address = scanner.nextLine();
        System.out.print("Email ID: ");
        email = scanner.nextLine();
        System.out.print("Mobile Number: ");
        mobile = scanner.nextLine();
        System.out.print("Basic Pay: ");
        double basicPayAssistantProfessor = scanner.nextDouble();

        AssistantProfessor assistantProfessor = new AssistantProfessor(name, empId, address, email, mobile, basicPayAssistantProfessor);

        System.out.println("\nPay Slip for Programmer:");
        displayPaySlip(programmer);

        System.out.println("\nPay Slip for Assistant Professor:");
        displayPaySlip(assistantProfessor);

        scanner.close();
    }

    public static void displayPaySlip(Employee employee) {
        System.out.println("Employee Name: " + employee.emp_name);
        System.out.println("Employee ID: " + employee.emp_id);
        System.out.println("Basic Pay: $" + employee.basicPay);
        System.out.println("Dearness Allowance (DA): $" + employee.calculateDA());
        System.out.println("House Rent Allowance (HRA): $" + employee.calculateHRA());
        System.out.println("Provident Fund (PF): $" + employee.calculatePF());
        System.out.println("Staff Club Fund: $" + employee.calculateStaffClubFund());
        System.out.println("Gross Salary: $" + employee.calculateGrossSalary());
        System.out.println("Net Salary: $" + employee.calculateNetSalary());
    }
}
