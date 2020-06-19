package com.jk.board.entity.board;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jk.board.entity.common.Common;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode
@Entity(name = "board")
public class Board {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Common commonContent;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Board parentBoard;

    @JsonBackReference
    @OneToMany(mappedBy = "parentBoard")
    private List<Board> childrenBoard;

}
