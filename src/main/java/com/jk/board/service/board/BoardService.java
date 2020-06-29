package com.jk.board.service.board;

import com.jk.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class BoardService implements IBoardService {

    private final BoardRepository boardRepository;

    @Autowired
    BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

}
