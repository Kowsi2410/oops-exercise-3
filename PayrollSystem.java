/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package payrollsystem;

/**
 *
 * @author kowsi
 */
import java.util.Scanner;

class Employee {
    String emp_name, emp_id, address, mail_id, mobile_no;
    double basicPay;

    public Employee(String emp_name, String emp_id, String address, String mail_id, String mobile_no, double basicPay) {
        this.emp_name = emp_name;
        this.emp_id = emp_id;
        this.address = address;
        this.mail_id = mail_id;
        this.mobile_no = mobile_no;
        this.basicPay = basicPay;
    }

    public double calculateDA() {
        return 0;  // To be overridden by subclasses
    }

    public double calculateHRA() {
        return 0;  // To be overridden by subclasses
    }

    public double calculatePF() {
        return 0;  // To be overridden by subclasses
    }

    public double calculateStaffClubFund() {
        return 0;  // To be overridden by subclasses
    }

    public double calculateGrossSalary() {
        return basicPay + calculateDA() + calculateHRA() + calculateStaffClubFund();
    }

    public double calculateNetSalary() {
        return calculateGrossSalary() - calculatePF();
    }

    public void printPaySlip() {
        System.out.println("Employee Name: " + emp_name);
        System.out.println("Employee ID: " + emp_id);
        System.out.println("Address: " + address);
        System.out.println("Email: " + mail_id);
        System.out.println("Mobile Number: " + mobile_no);
        System.out.println("Basic Pay: $" + basicPay);
        System.out.println("Dearness Allowance: $" + calculateDA());
        System.out.println("House Rent Allowance: $" + calculateHRA());
        System.out.println("Staff Club Fund: $" + calculateStaffClubFund());
        System.out.println("Gross Salary: $" + calculateGrossSalary());
        System.out.println("Provident Fund (PF): $" + calculatePF());
        System.out.println("Net Salary: $" + calculateNetSalary());
    }
}

class Programmer extends Employee {
    public Programmer(String emp_name, String emp_id, String address, String mail_id, String mobile_no, double basicPay) {
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
    public AssistantProfessor(String emp_name, String emp_id, String address, String mail_id, String mobile_no, double basicPay) {
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

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Programmer Details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Employee ID: ");
        String empId = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Email ID: ");
        String email = scanner.nextLine();
        System.out.print("Mobile Number: ");
        String mobileNo = scanner.nextLine();
        System.out.print("Basic Pay: ");
        double basicPayProgrammer = scanner.nextDouble();

        Programmer programmer = new Programmer(name, empId, address, email, mobileNo, basicPayProgrammer);

        System.out.println("\nEnter Assistant Professor Details:");
        System.out.print("Name: ");
        name = scanner.nextLine();  // Consume newline character
        name = scanner.nextLine();
        System.out.print("Employee ID: ");
        empId = scanner.nextLine();
        System.out.print("Address: ");
        address = scanner.nextLine();
        System.out.print("Email ID: ");
        email = scanner.nextLine();
        System.out.print("Mobile Number: ");
        mobileNo = scanner.nextLine();
        System.out.print("Basic Pay: ");
        double basicPayAssistantProfessor = scanner.nextDouble();

        AssistantProfessor assistantProfessor = new AssistantProfessor(name, empId, address, email, mobileNo, basicPayAssistantProfessor);

        System.out.println("\nPay Slips:");
        System.out.println("Programmer Pay Slip:");
        programmer.printPaySlip();

        System.out.println("\nAssistant Professor Pay Slip:");
        assistantProfessor.printPaySlip();

        scanner.close();
    }
}

