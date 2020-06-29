package com.jk.board.entity.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jk.board.entity.board.Board;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Entity
@EqualsAndHashCode
@Table(name = "board_user")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String loginId;
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "owner")
    private List<Board> boards;

    public User() {}

    public User(String name, String loginId, String password, Date createdDate) {
        this.name = name;
        this.loginId = loginId;
        this.password = password;
        this.createdDate = createdDate;
    }

    public void changePassword(String password) {
        this.password = password;
        this.modifiedDate = new Date();
    }
}
