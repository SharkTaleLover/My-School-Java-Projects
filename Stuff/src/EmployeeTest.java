public class EmployeeTest {

    public static void main(String[] args)
    {
        Employee employee1 = new Employee("Kyle", 300, 1);
        displayEmployee(employee1);
    }

    public static void displayEmployee(Employee employee)
    {
        System.out.println("Employee " + employee.getName() + "'s salary is $" + employee.getSalary() + " and their employee number is " + employee.getEmployeeNumber() + ".");
    }
}
