import java.util.List;

public class Application {
    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        Employee employee1 = new Employee();
        employee1.setFirstName("Petr");
        employee1.setLastName("Petrov");
        employee1.setGender("male");
        employee1.setAge(51);
        employee1.setCityId(1);
        employeeDAO.createEmployee(employee1);
        employeeDAO.deleteEmployee(employeeDAO.getEmployeeById(13));
        employeeDAO.updateEmployee(employeeDAO.getEmployeeById(2));
        List <Employee> employeeList = employeeDAO.getAllEmployee();
        for (Employee employees : employeeList) {
            System.out.println(employees);
        }
        CreatingEntityManager.close();
    }
}
