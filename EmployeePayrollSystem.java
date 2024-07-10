
import java.util.ArrayList;
import java.util.List;
import javax.naming.PartialResultException;

abstract class Employee {
    private String name;
    private int id;

    public Employee (String name, int id)
    {
        this.name = name;
        this.id = id;  
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }

    //Abstract method 
    public abstract double calculateSalary();

    @Override
    public String toString(){
        return "Employee [name=" + name + ",id=" + id + ",salary=" + calculateSalary()+ "]";

    }
}
class FullTimeEmployee extends Employee{
    private double monthlySalary;
    
    public FullTimeEmployee(String name, int id, double monthlySalary)
    {
        super(name, id);
        this.monthlySalary = monthlySalary;

    }

    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name,int id, int hoursWorked,double hourlyRate )
{
    super(name, id);
    this.hoursWorked = hoursWorked;
    this.hourlyRate = hourlyRate;
}
@Override
    public double calculateSalary(){
    return hoursWorked* hoursWorked;
}
}




public class EmployeePayrollSystem{
    private ArrayList<Employee> employeeList;
    
    public EmployeePayrollSystem()
    {
        employeeList = new ArrayList<>();
    }
    
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for (Employee employee : employeeList){
            if(employee.getId() == id){
                employeeToRemove = employee;
                break;
            }

}        }
        if (employeeToRemove!=null){
            employeeList.remove(employeeToRemove);

        }
    

    public void displayEmployees(){
        for (Employee employee : employeeList){
            System.out.print(employee);

        }
    }
}

public class EmployeePayrollSysMain {
    public static void main(String[]args)
    {
        EmployeePayrollSystem employeePayrollSystem = new EmployeePayrollSystem();

        FullTimeEmployee emp1 = new FullTimeEmployee("John Doe", 101, 5000.0);
        PartTimeEmployee emp2 = new PartTimeEmployee("Jane Smith", 109, 30, 15.0);

        employeePayrollSystem.addEmployee(emp1);
        employeePayrollSystem.addEmployee(emp2);

        System.out.println("Initital Employee Details:");
        employeePayrollSystem.displayEmployees();

        System.out.println("\nRemoving Employee...");
        employeePayrollSystem.removeEmployee(101);

        System.out.println("\nRemaining Employee Details:");
        employeePayrollSystem.displayEmployees();


    }
}



    
    

