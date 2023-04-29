import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class SelectingChangings {
    public static void selectChangings(Employee employee) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер изменяемого параметра: 1 - Имя сотрудника, 2 - Фамилия сотрудника, 3 - пол сотрудника, 4 - возраст сотрудника, 5 - номер города сотрудника");
        int i = scanner.nextInt();
        scanner.nextLine();
        switch (i) {
            case 1:
                System.out.println("Введите имя");
                String name = scanner.nextLine();
                employee.setFirstName(name);
                break;
            case 2:
                System.out.println("Введите фамилию");
                String surname = scanner.nextLine();
                employee.setLastName(surname);
                break;
            case 3:
                System.out.println("Введите пол female/male");
                String gender = scanner.nextLine();
                employee.setGender(gender);
                break;
            case 4:
                System.out.println("Введите возраст");
                int age = scanner.nextInt();
                employee.setAge(age);
                break;
            case 5:
                System.out.println("Введите номер города");
                int cityNumber = scanner.nextInt();
                EntityManager entityManager = CreatingEntityManager.create();
                entityManager.getTransaction().begin();
                City city = entityManager.find(City.class, cityNumber);
                entityManager.getTransaction().commit();
                employee.setCity(city);
                break;
        }
    }

        public static void changeCity(City city) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите изменяемый параметр: 1. Название города 2. Добавить сотрудника, проживающего в городе 3. Изменить сотрудника, проживающего в городе");
            int i = scanner.nextInt();
            scanner.nextLine();
            switch (i) {
                case 1:
                    System.out.println("Введите новое название города");
                    String newNameCity = scanner.nextLine();
                    city.setNameCity(newNameCity);
                    break;
                case 2:
                    System.out.println("Введите id сотрудника");
                    int id = scanner.nextInt();
                    List<Employee> employeeList = city.getEmployee();
                    EmployeeDAO employeeDAO = new EmployeeDAOImpl();
                    employeeList.add(employeeDAO.getEmployeeById(id));
                    city.setEmployee(employeeList);
                    break;
                case 3:
                    System.out.println("Введите id сотрудника");
                    int id1 = scanner.nextInt();
                    List<Employee> employeeList1 = city.getEmployee();
                    EmployeeDAO employeeDAO1 = new EmployeeDAOImpl();
                    employeeList1.remove(employeeDAO1.getEmployeeById(id1));
                    employeeDAO1.updateEmployee(employeeDAO1.getEmployeeById(id1));
                    employeeList1.add(employeeDAO1.getEmployeeById(id1));
                    city.setEmployee(employeeList1);
                    break;
            }
        };
}
