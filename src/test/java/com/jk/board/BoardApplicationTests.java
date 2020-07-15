package com.jk.board;

import com.jk.board.service.board.IBoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardApplicationTests {

    @Autowired
    private IBoardService boardService;

    @Test
    void contextLoads() {
        boardService.searchTitle("title");

        System.out.println("J Tag");
    }

}
