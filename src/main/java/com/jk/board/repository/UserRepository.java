package com.jk.board.repository;

import com.jk.board.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLoginId(String loginId);
}
