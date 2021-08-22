package TestFolder;

import java.util.Random;
import java.util.stream.Collectors;

import static TestFolder.Users.getUsers;

public class User {
    Integer id;
    String name;
    Integer age;
    String location;
    String sex;

    public User(String name, Integer age, String location, String sex) {
        if (getUsers().stream().noneMatch(user -> user.name.equals(name))) {
            this.id = setId();
            this.name = name;
            this.age = age;
            this.location = location;
            this.sex = sex;
            getUsers().add(this);
        } else {
            User readyUser = getUsers().stream().filter(user -> user.name.equals(name)).collect(Collectors.toList()).get(0);
            this.id = readyUser.id;
            this.name = readyUser.name;
            this.age = readyUser.age;
            this.location = readyUser.location;
            this.sex = readyUser.sex;
        }
    }

    public Integer setId() {
        Random random = new Random();
        return random.nextInt(900) + 100;
    }
}
