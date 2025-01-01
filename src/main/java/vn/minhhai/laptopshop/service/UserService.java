package vn.minhhai.laptopshop.service;

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

    public String handleHello() {
        return "Hello from service";
    }
}
