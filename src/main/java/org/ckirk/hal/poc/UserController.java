package org.ckirk.hal.poc;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * @author Chris Kirk
 * @since 1.0
 */
@RestController
public class UserController {

    @RequestMapping("/user")
    public ResponseEntity<User> getUser(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        User user = new User();
        user.setName(name);
        user.add(linkTo(methodOn(UserController.class).getUser(name)).withSelfRel());

        return ResponseEntity.ok(user);
    }

    @RequestMapping("/users")
    public ResponseEntity<List<User>> getUsers(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        List<User> users = new ArrayList<>();

        User user1 = new User();
        user1.setName(name + "1");
        user1.add(linkTo(methodOn(UserController.class).getUsers(name)).withSelfRel());
        users.add(user1);

        User user2 = new User();
        user2.setName(name + "2");
        user2.add(linkTo(methodOn(UserController.class).getUsers(name)).withSelfRel());
        users.add(user2);

        return ResponseEntity.ok(users);
    }

}
