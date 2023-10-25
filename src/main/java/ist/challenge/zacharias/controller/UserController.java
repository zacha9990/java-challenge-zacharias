package ist.challenge.zacharias.controller;

import ist.challenge.zacharias.model.User;
import ist.challenge.zacharias.service.RegistrationService;
import ist.challenge.zacharias.service.LoginResponse;
import ist.challenge.zacharias.service.UserResponse;
import ist.challenge.zacharias.service.LoginService;
import ist.challenge.zacharias.service.RegistrationResponse;
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
    
    public UserController(LoginService loginService) {
        this.loginService = loginService;
    }


    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> registerUser(@RequestBody User user) {
        return registrationService.registerUser(user);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestParam String username, @RequestParam String password) {
        return loginService.loginUser(username, password);
    }

    @GetMapping("/")
    public ResponseEntity<UserResponse> listUsers() {
        return userService.listUsers();
    }

    @PutMapping("/edit")
    public ResponseEntity<UserResponse> editUser(@RequestParam Long id, @RequestBody User updatedUser) {
        return userService.editUser(id, updatedUser);
    }
}
