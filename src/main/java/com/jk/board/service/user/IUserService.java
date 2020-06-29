package com.jk.board.service.user;

import com.jk.board.entity.user.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IUserService {
    void saveUser(String name, String loginId, String password);

    boolean login(String loginId, String password);

    User getByLoginId(String loginId);
}
