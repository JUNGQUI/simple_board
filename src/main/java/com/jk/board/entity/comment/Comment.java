package com.jk.board.entity.comment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jk.board.entity.board.Board;
import com.jk.board.entity.common.Common;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode
@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Common commonContent;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Comment parentComment;

    @JsonBackReference
    @OneToMany(mappedBy = "parentComment", fetch = FetchType.LAZY)
    private List<Comment> childrenComment;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Board commentedBoard;
}
