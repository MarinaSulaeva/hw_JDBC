import java.util.List;

public class Application {
    public static void main(String[] args) {

//создаем экземпляры городов и сотрудников
        CityDAO cityDAO = new CityDAOImpl();
        City city = new City();
        city.setNameCity("Москва");
        cityDAO.createCity(city);

        City city1 = new City();
        city.setNameCity("Томск");
        cityDAO.createCity(city1);

        City city2 = new City();
        city.setNameCity("Санкт-Петербург");
        cityDAO.createCity(city2);

        City city3 = new City();
        city.setNameCity("Новосибирск");
        cityDAO.createCity(city3);

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        Employee employee1 = new Employee();
        employee1.setFirstName("Ivan");
        employee1.setLastName("Ivanov");
        employee1.setGender("male");
        employee1.setAge(43);
        employee1.setCity(cityDAO.getCityById(1));
        employeeDAO.createEmployee(employee1);

        Employee employee = new Employee();
        employee.setFirstName("Elena");
        employee.setLastName("Nikitina");
        employee.setGender("female");
        employee.setAge(37);
        employee.setCity(cityDAO.getCityById(2));
        employeeDAO.createEmployee(employee);

        Employee employee2 = new Employee();
        employee2.setFirstName("Alla");
        employee2.setLastName("Sidorova");
        employee2.setGender("female");
        employee2.setAge(33);
        employee2.setCity(cityDAO.getCityById(3));
        employeeDAO.createEmployee(employee2);

        Employee employee3 = new Employee();
        employee3.setFirstName("Victor");
        employee3.setLastName("Victorov");
        employee3.setGender("male");
        employee3.setAge(37);
        employee3.setCity(cityDAO.getCityById(4));
        employeeDAO.createEmployee(employee3);

//      добавляем сотрудников в города

        cityDAO.updateCity(cityDAO.getCityById(1));
        cityDAO.updateCity(cityDAO.getCityById(1));
        cityDAO.updateCity(cityDAO.getCityById(2));
        cityDAO.updateCity(cityDAO.getCityById(2));
        cityDAO.updateCity(cityDAO.getCityById(3));
        cityDAO.updateCity(cityDAO.getCityById(4));

//        распечатаем список сотрудников по городам

        System.out.println("сотрудники города №1");
        List <Employee> employeeList1 = cityDAO.getCityById(1).getEmployee();
        for (Employee employees : employeeList1) {
            System.out.println(employees);
        }
        System.out.println("сотрудники города №2");
        List <Employee> employeeList2 = cityDAO.getCityById(2).getEmployee();
        for (Employee employees : employeeList2) {
            System.out.println(employees);
        }
        System.out.println("сотрудники города №3");
        List <Employee> employeeList3 = cityDAO.getCityById(3).getEmployee();
        for (Employee employees : employeeList3) {
            System.out.println(employees);
        }
        System.out.println("сотрудники города №4");
        List <Employee> employeeList4 = cityDAO.getCityById(4).getEmployee();
        for (Employee employees : employeeList4) {
            System.out.println(employees);
        }

        //удаляем сотрудников и распечатаем списки городов и сотрудников

        cityDAO.deleteCity(cityDAO.getCityById(4));

        List <City> cityList = cityDAO.getAllCities();
        for (City cities : cityList) {
            System.out.println(cities);
        }

        List <Employee> employeeList = employeeDAO.getAllEmployee();
        for (Employee employees : employeeList) {
            System.out.println(employees);
        }
//        изменяем сотрудника в городе и распечатаем списки городов и сотрудников
        cityDAO.updateCity(cityDAO.getCityById(3));

        List <City> cityList1 = cityDAO.getAllCities();
        for (City cities : cityList1) {
            System.out.println(cities);
        }

        List <Employee> employeeList5 = employeeDAO.getAllEmployee();
        for (Employee employees : employeeList1) {
            System.out.println(employees);
        }

        CreatingEntityManager.close();
    }
}
