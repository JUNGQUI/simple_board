package com.jk.board.repository;

import com.jk.board.entity.board.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("select b from Board b where b.commonContent.title like %:title%")
    Page<Board> searchByTitleWithPage(@Param(value="title") String title, Pageable pageable);
}
