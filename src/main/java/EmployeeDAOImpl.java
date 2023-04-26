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
        SelectingChangings.selectChangings(employee1);
        entityManager.merge(employee1);
        entityManager.getTransaction().commit();
        System.out.println("сотрудник №" + employee.getId() + " изменен");
    }
}
