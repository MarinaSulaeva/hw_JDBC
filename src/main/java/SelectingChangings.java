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
                int cityID = scanner.nextInt();
                employee.setCityId(cityID);
                break;
        }
    }
}
