package com.jk.board.entity.board;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jk.board.entity.common.Common;
import com.jk.board.entity.user.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@EqualsAndHashCode
@Entity(name = "board")
public class Board {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Common commonContent;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Board parentBoard;

    @JsonBackReference
    @OneToMany(mappedBy = "parentBoard")
    private List<Board> childrenBoard;


    public Board() {}

    public Board(User owner, Common common, Board parentBoard, List<Board> childrenBoard) {
        this.owner = owner;
        this.commonContent = common;
        this.parentBoard = parentBoard;
        this.childrenBoard = childrenBoard;
    }
}
