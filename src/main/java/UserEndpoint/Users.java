package UserEndpoint;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    static List<User> users = new ArrayList<>();

    public static List<User> getUsers() {
        return users;
    }

    public static List<User> getFilterUser(String name, Integer age, String location, String sex) {
        return users.stream()
                .filter(user -> user.name.equals(name))
                .filter(user -> user.age.equals(age))
                .filter(user -> user.location.equals(location))
                .filter(user -> user.sex.equals(sex))
                .collect(Collectors.toList());
    }

    public static List<User> editUsers(String name, Integer age, String location, String sex) {
        return null;
    }
}
