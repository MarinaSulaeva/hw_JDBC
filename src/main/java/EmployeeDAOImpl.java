import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeDAOImpl implements EmployeeDAO {
    final String user = "postgres";
    final String password = "73aberiv";
    final String url = "jdbc:postgresql://localhost:5432/postgres";

    @Override
    public void createEmployee(Employee employee) {
        String sql = "INSERT INTO employees1 (first_name, last_name, gender, age, city_id) VALUES ('" + employee.getFirstName() + "', '" + employee.getLastName() + "', '" + employee.getGender() + "', " + employee.getAge() + ", " + employee.getCityId() + ")";
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            System.out.println("Сотрудник добавлен");
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД");
            e.printStackTrace();
        }
    }

    @Override
    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM employees1 WHERE id=" + id;
        Employee employee = new Employee(0, null, null, null, 0, 0);
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idEmployee = resultSet.getInt("id");
                String firstNameEmployee = resultSet.getString("first_name");
                String lastNameEmployee = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                int numberOfCity = resultSet.getInt("city_id");
                employee.setId(idEmployee);
                employee.setFirstName(firstNameEmployee);
                employee.setLastName(lastNameEmployee);
                employee.setGender(gender);
                employee.setAge(age);
                employee.setCityId(numberOfCity);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД");
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employees1")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idEmployee = resultSet.getInt("id");
                String firstNameEmployee = resultSet.getString("first_name");
                String lastNameEmployee = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                int nameOfCity = resultSet.getInt("city_id");
                employeeList.add(new Employee(idEmployee, firstNameEmployee, lastNameEmployee, gender, age, nameOfCity));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД");
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void updateEmployee(int id) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер изменяемого параметра: 1 - Имя сотрудника, 2 - Фамилия сотрудника, 3 - пол сотрудника, 4 - возраст сотрудника, 5 - номер города сотрудника");
        String nameColumn = null;
        String containOfColumn = null;
        int i = scanner.nextInt();
        scanner.nextLine();
        switch (i) {
            case 1:
                containOfColumn = scanner.nextLine();
                nameColumn = "first_name";
                break;
            case 2:
                containOfColumn = scanner.nextLine();
                nameColumn = "last_name";
                break;
            case 3:
                containOfColumn = scanner.nextLine();
                nameColumn = "gender";
                break;
            case 4:
                containOfColumn = scanner.nextLine();
                nameColumn = "age";
                break;
            case 5:
                containOfColumn = scanner.nextLine();
                nameColumn = "city_id";
                break;
        }
        String sql;
        if (i <= 3) {
            sql = "UPDATE employees1 SET " + nameColumn + "='" + containOfColumn + "' WHERE id=" + id;
        } else {
            sql = "UPDATE employees1 SET " + nameColumn + "=" + containOfColumn + " WHERE id=" + id;
        }
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            System.out.println("Сотрудник изменен");
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees1 WHERE id=" + id;
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            System.out.println("Сотрудник удален");
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД");
            e.printStackTrace();
        }
    }
}
