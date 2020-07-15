package com.jk.board.service.board;

import com.jk.board.entity.board.Board;
import com.jk.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
class BoardService implements IBoardService {

    private final BoardRepository boardRepository;

    @Autowired
    BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public void searchTitle(String title) {
        Page<Board> boards = boardRepository.searchByTitleWithPage(title, PageRequest.of(0, 10, Sort.by("commonContent.title")));
        System.out.println("J Tag");
    }

}
