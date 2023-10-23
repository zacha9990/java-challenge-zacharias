package ist.challenge.zacharias.service;

import ist.challenge.zacharias.model.User;
import ist.challenge.zacharias.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<String> loginUser(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            return new ResponseEntity<>("Username dan / atau password kosong", HttpStatus.BAD_REQUEST);
        }

        User user = userRepository.findByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            return new ResponseEntity<>("Username dan / atau password tidak cocok", HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>("Sukses Login", HttpStatus.OK);
    }
}