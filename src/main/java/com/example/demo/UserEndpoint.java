package com.example.demo;

import UserEndpoint.User;
import UserEndpoint.Users;
import com.google.gson.Gson;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class UserEndpoint extends DemoApplication {

    @RequestMapping(value = "/getUser", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUser(@RequestParam String name, @RequestParam Integer age, @RequestParam String location, @RequestParam String sex) {
        return new Gson().toJson(Users.getFilterUser(name, age, location, sex));
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String editUser(@RequestParam String name, @RequestParam Integer age, @RequestParam String location, @RequestParam String sex) {
        return new Gson().toJson(null);
    }

    @RequestMapping(value = "/setUser", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String setUser(@RequestBody User user) {
        return new Gson().toJson(user);
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUsers() {
        return new Gson().toJson(Users.getUsers());
    }
}

