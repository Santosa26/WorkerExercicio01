package Exercicio.src.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.Date;

import Exercicio.src.entities.Department;
import Exercicio.src.entities.HourContract;
import Exercicio.src.entities.Worker;
import Exercicio.src.enums.WorkerLevel;

public class Program {
    public static void main(String[] args) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 

    Scanner sc = new Scanner(System.in);
    Locale.setDefault(Locale.US);

    System.out.print("Enter department's name: ");   
    Department departmentName = new Department( sc.next().toUpperCase());

    System.out.println("Enter Worker data: ");
    System.out.print("Name: ");
    sc.nextLine();
    String name = sc.nextLine();
    System.out.print("Level: ");
    WorkerLevel level = WorkerLevel.valueOf(sc.next().toUpperCase());
    System.out.print("Base Salary: ");
    double baseSalary = sc.nextDouble();

    Worker worker = new Worker(name, level, baseSalary, departmentName);

    System.out.print("How many contracts to this worker?: ");
    int n = sc.nextInt();

    for(int i = 0; i < n; i++ ){
        System.out.println("Enter contract #" + (i + 1 ) + " data:");
        System.out.print("Date(DD/MM/YYYY): ");
        Date date = sdf.parse(sc.next());
        System.out.print("Value per hour: ");
        double valuePerHour = sc.nextDouble();
        System.out.print("Duration: ");
        int duration = sc.nextInt();

        worker.addContract(new HourContract(date, valuePerHour, duration));
    }

    System.out.println("Enter month and year to calculate income(MM/YYYY): ");
    String monthYear = sc.next();

    int month = Integer.parseInt(monthYear.substring(0,2));
    int year = Integer.parseInt(monthYear.substring(3));
    

    System.out.println("Name " + worker.getName());
    System.out.println("Department: " + worker.getDepartment().getName());
    System.out.println("Income for " + monthYear + ": " + worker.income(month, year));

    }
}
