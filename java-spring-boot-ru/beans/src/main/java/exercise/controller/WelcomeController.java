package exercise.controller;

import exercise.daytime.Daytime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

// BEGIN
@RestController
public class WelcomeController {


    @Autowired
    private Daytime daytime;

    @GetMapping(path = "/welcome")
    public String welcome() {
        String name = daytime.getName();
        return String.format("It is %s now! Welcome to Spring!%n", name);
    }

}
// END
