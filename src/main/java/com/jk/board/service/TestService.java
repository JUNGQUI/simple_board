package com.jk.board.service;

import com.jk.board.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private final IUserService userService;

    @Autowired
    public TestService(IUserService userService) {
        this.userService = userService;
    }

    public void test() {
        userService.getByLoginId("jklee");
    }
}
