import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    final EntityManager entityManager = CreatingEntityManager.create();

    @Override
    public void createEmployee(Employee employee) {
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
    }

    @Override
    public Employee getEmployeeById(int idEmployee) {
        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class, idEmployee);
        entityManager.getTransaction().commit();
        return employee;
    }
    @Override
    public void deleteEmployee(Employee employee) {
        entityManager.getTransaction().begin();
        Employee employee1 = entityManager.find(Employee.class, employee.getId());
        entityManager.remove(employee1);
        entityManager.getTransaction().commit();
        System.out.println("сотрудник №" + employee.getId() + " удален");
    }
    @Override
    public List<Employee> getAllEmployee() {
        entityManager.getTransaction().begin();
        String jpqlQuery = "SELECT s FROM Employee s";
        TypedQuery<Employee> query = entityManager.createQuery(jpqlQuery, Employee.class);
        List<Employee> employeeList = query.getResultList();
        entityManager.getTransaction().commit();
        return employeeList;
    }
    @Override
    public void updateEmployee(Employee employee) {
        entityManager.getTransaction().begin();
        Employee employee1 = entityManager.find(Employee.class, employee.getId());
                Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер изменяемого параметра: 1 - Имя сотрудника, 2 - Фамилия сотрудника, 3 - пол сотрудника, 4 - возраст сотрудника, 5 - номер города сотрудника");
        int i = scanner.nextInt();
        scanner.nextLine();
        switch (i) {
            case 1:
                System.out.println("Введите имя");
                String name = scanner.nextLine();
                employee1.setFirstName(name);
                break;
            case 2:
                System.out.println("Введите фамилию");
                String surname = scanner.nextLine();
                employee1.setLastName(surname);
                break;
            case 3:
                System.out.println("Введите пол female/male");
                String gender = scanner.nextLine();
                employee1.setGender(gender);
                break;
            case 4:
                System.out.println("Введите возраст");
                int age = scanner.nextInt();
                employee1.setAge(age);
                break;
            case 5:
                System.out.println("Введите номер города");
                int cityID = scanner.nextInt();
                employee1.setCityId(cityID);
                break;
        }
        entityManager.merge(employee1);
        entityManager.getTransaction().commit();
        System.out.println("сотрудник №" + employee.getId() + " изменен");
    }
}
