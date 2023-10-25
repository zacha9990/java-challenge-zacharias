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

    public ResponseEntity<RegistrationResponse> registerUser(User newUser) {
        if (userRepository.existsByUsername(newUser.getUsername())) {
            // Username already exists
            return new ResponseEntity<>(new RegistrationResponse("error", "Username sudah terpakai"), HttpStatus.CONFLICT);
        }
        
        // Registration successful
        userRepository.save(newUser);
        return new ResponseEntity<>(new RegistrationResponse("success", "Registrasi berhasil"), HttpStatus.CREATED);
    }
}
