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

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<UserResponse> listUsers() {
        Iterable<User> users = userRepository.findAll();
        return new ResponseEntity<>(new UserResponse("success", "List of users retrieved successfully", users), HttpStatus.OK);
    }

    public ResponseEntity<UserResponse> editUser(Long userId, User updatedUser) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return new ResponseEntity<>(new UserResponse("error", "User tidak ditemukan"), HttpStatus.NOT_FOUND);
        }

        if (!user.getUsername().equals(updatedUser.getUsername()) && userRepository.existsByUsername(updatedUser.getUsername())) {
            return new ResponseEntity<>(new UserResponse("error", "Username sudah terpakai"), HttpStatus.CONFLICT);
        }

        if (user.getPassword().equals(updatedUser.getPassword())) {
            return new ResponseEntity<>(new UserResponse("error", "Password tidak boleh sama dengan password sebelumnya"), HttpStatus.BAD_REQUEST);
        }

        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        userRepository.save(user);               

        return new ResponseEntity<>(new UserResponse("success", "Edit sukses", user), HttpStatus.CREATED);
    }
}
