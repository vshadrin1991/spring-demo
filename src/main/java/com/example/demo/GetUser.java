package com.example.demo;

import TestFolder.User;
import TestFolder.Users;
import com.google.gson.Gson;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class GetUser extends DemoApplication {

    @RequestMapping(value = "/setUserParam", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String setUserByParam(@RequestParam String name, @RequestParam Integer age, @RequestParam String location, @RequestParam String sex) {
        return new Gson().toJson(new User(name, age, location, sex));
    }

    @RequestMapping(value = "/setUserBody", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String setUserByBody(@RequestBody User user) {
        return new Gson().toJson(user);
    }


    @RequestMapping(value = "getUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUsersData() {
        return new Gson().toJson(Users.getUsers());
    }
}

