package com.jk.board.service.user;

import com.jk.board.entity.user.User;
import com.jk.board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;

@Service
class UserService implements IUserService {

    PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(String name, String loginId, String password) {
        String encodedPassword = passwordEncoder.encode(password);

        User user = new User(name, loginId, encodedPassword, new Date());
        userRepository.save(user);
    }

    @Override
    public boolean login(String loginId, String password) {
        User user = userRepository.findByLoginId(loginId);
        Assert.notNull(user, "사용자가 없습니다.");

        return passwordEncoder.matches(passwordEncoder.encode(password), user.getPassword());
    }

    @Override
    public User getByLoginId(String loginId) {
        return userRepository.findByLoginId(loginId);
    }

}
