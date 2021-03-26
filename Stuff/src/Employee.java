public class Employee {
    String name;
    double salary;
    int employeeNumber;

    public Employee(String name, double sal, int num)
    {
        this.name = name;
        salary = sal;
        employeeNumber = num;
    }
    public Employee()
    {
        this("Employee",0, 0);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSalary(double sal)
    {
        salary = sal;
    }

    public void setEmployeeNumber(int num)
    {
        employeeNumber = num;
    }

    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public int getEmployeeNumber()
    {
        return employeeNumber;
    }
}
