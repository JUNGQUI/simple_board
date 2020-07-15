package com.jk.board.service.board;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IBoardService {
    void searchTitle(String title);
}
