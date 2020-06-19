package com.jk.board.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<Object, String> {

    List<Object> findAll();
}
