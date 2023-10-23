package ist.challenge.zacharias.service;

import ist.challenge.zacharias.model.User;
import ist.challenge.zacharias.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<String> registerUser(User newUser) {
        if (userRepository.existsByUsername(newUser.getUsername())) {
            return new ResponseEntity<>("Username sudah terpakai", HttpStatus.CONFLICT);
        }
        userRepository.save(newUser);
        return new ResponseEntity<>("Registrasi berhasil", HttpStatus.CREATED);
    }
}
