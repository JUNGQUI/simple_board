package com.jk.board.entity.user;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "board_user")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
}
