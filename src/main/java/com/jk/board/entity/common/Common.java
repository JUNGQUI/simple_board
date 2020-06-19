package com.jk.board.entity.common;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
@Data
@EqualsAndHashCode
public class Common {
    private String title;
    @Lob
    private String content;
    private long goodThumbs;
    private long badThumbs;
}
