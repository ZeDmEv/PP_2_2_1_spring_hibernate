package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

        Car car1 = new Car("car1", 123456);
        User user1 = new User("User1", "Lastname1", "user1@mail.ru", car1);
        userService.add(user1);

       Car car2 = new Car("car2", 123654);
       User user2 = new User("User2", "Lastname2", "user2@mail.ru", car2);
       userService.add(user2);

       User user3 = new User("User3", "Lastname3", "user3@mail.ru");
       userService.add(user3);

       Car car4 = new Car("car4", 123789);
       User user4 = new User("User4", "Lastname4", "user4@mail.ru", car4);
       userService.add(user4);

        System.out.println("Машина принадлежит: " + userService.getUserByCar(0,"car4"));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }

        context.close();
    }
}
