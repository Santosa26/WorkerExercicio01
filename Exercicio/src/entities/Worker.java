package Exercicio.src.entities;

import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Exercicio.src.enums.WorkerLevel;

public class Worker {
private String name;
private WorkerLevel level;
private Double baseSalary;
private Department department;
private List<HourContract> contracts = new ArrayList<>();

public Worker(String name, WorkerLevel level, Double baseSalary, Department department){
    this.name = name;
    this.level = level;
    this.baseSalary = baseSalary;
    this.department = department;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public WorkerLevel getLevel() {
    return level;
}

public void setLevel(WorkerLevel level) {
    this.level = level;
}

public Double getBaseSalary() {
    return baseSalary;
}

public void setBaseSalary(Double baseSalary) {
    this.baseSalary = baseSalary;
}

public Department getDepartment() {
    return department;
}

public void setDepartment(Department department) {
    this.department = department;
}

public void addContract(HourContract contract){
    addContract(contract);
}

public void removeContract(HourContract contract){
    removeContract(contract);
}

public Double income(Integer month , Integer year){
    double sum = baseSalary;
    Calendar cal = Calendar.getInstance();
    for(HourContract h: contracts){
        int year_Y = cal.get(Calendar.YEAR);
        int month_M = cal.get(Calendar.MONTH);
        if(month == month_M && year == year_Y){
            sum += h.totalValue();
        }
    } return sum;
}


}
