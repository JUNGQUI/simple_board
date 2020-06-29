package com.jk.board.entity.comment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jk.board.entity.board.Board;
import com.jk.board.entity.common.Common;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@EqualsAndHashCode
@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Common commonContent;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "parent_id")
    private Comment parentComment;

    @JsonBackReference
    @OneToMany(mappedBy = "parentComment", fetch = FetchType.LAZY)
    private List<Comment> childrenComment;

    @ManyToOne
    private Board commentedBoard;

    public Comment() {}

    public Comment(Common common, Comment parentComment, List<Comment> childrenComment, Board commentedBoard) {
        this.commonContent = common;
        this.parentComment = parentComment;
        this.childrenComment = childrenComment;
        this.commentedBoard = commentedBoard;
    }
}
