package ist.challenge.zacharias.controller;

import ist.challenge.zacharias.model.User;
import ist.challenge.zacharias.service.RegistrationService;
import ist.challenge.zacharias.service.LoginService;
import ist.challenge.zacharias.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        return registrationService.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        return loginService.loginUser(user.getUsername(), user.getPassword());
    }

    @GetMapping
    public Iterable<User> listUsers() {
        return userService.listUsers();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> editUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        return userService.editUser(userId, updatedUser);
    }
}
