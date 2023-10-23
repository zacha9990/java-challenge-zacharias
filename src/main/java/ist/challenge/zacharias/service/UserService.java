package ist.challenge.zacharias.service;

import ist.challenge.zacharias.model.User;
import ist.challenge.zacharias.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> listUsers() {
        return userRepository.findAll();
    }

    public ResponseEntity<String> editUser(Long userId, User updatedUser) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return new ResponseEntity<>("User tidak ditemukan", HttpStatus.NOT_FOUND);
        }

        if (!user.getUsername().equals(updatedUser.getUsername()) && userRepository.existsByUsername(updatedUser.getUsername())) {
            return new ResponseEntity<>("Username sudah terpakai", HttpStatus.CONFLICT);
        }

        if (user.getPassword().equals(updatedUser.getPassword())) {
            return new ResponseEntity<>("Password tidak boleh sama dengan password sebelumnya", HttpStatus.BAD_REQUEST);
        }

        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        userRepository.save(user);

        return new ResponseEntity<>("Edit sukses", HttpStatus.CREATED);
    }
}
