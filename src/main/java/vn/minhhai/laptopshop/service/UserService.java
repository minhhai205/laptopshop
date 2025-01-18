package vn.minhhai.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.minhhai.laptopshop.domain.User;
import vn.minhhai.laptopshop.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handleSaveUser(User user) {
        return this.userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public List<User> getAllUsersByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public User getUserById(long id) {
        Optional<User> result = this.userRepository.findById(id);
        return result.orElse(null);
    }

    public void deleteUserById(long id) {
        this.userRepository.deleteById(id);
    }

}
