import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String password = "73aberiv";
        final String url = "jdbc:postgresql://localhost:5432/postgres";
// задание 1
        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employees1 WHERE id=2")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idEmployee = resultSet.getInt("id");
                System.out.println("id сотрудника: " + idEmployee);
                String firstNameEmployee = resultSet.getString("first_name");
                System.out.println("Имя сотрудника: " + firstNameEmployee);
                String lastNameEmployee = resultSet.getString("last_name");
                System.out.println("Фамилия сотрудника: " + lastNameEmployee);
                String gender = resultSet.getString("gender");
                System.out.println("Пол: " + gender);
                int nameOfCity = resultSet.getInt("city_id");
                System.out.println("Город проживания сотрудника: " + nameOfCity);
            }

            System.out.println("Соединение установлено");
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных");
            e.printStackTrace();
        }
//задание №2
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        employeeDAO.deleteEmployee(10);
        Employee employee = new Employee(11, "Zhanna", "Koroleva", "female", 45, 3);
        employeeDAO.createEmployee(employee);
        employeeDAO.updateEmployee(2);
        employeeDAO.getEmployeeById(1);
        List<Employee> employeeList = employeeDAO.getAllEmployee();
        for (Employee employees : employeeList) {
            System.out.println(employees);
        }
    }
}
