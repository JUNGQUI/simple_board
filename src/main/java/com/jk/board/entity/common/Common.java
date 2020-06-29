package com.jk.board.entity.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Getter
@Embeddable
@EqualsAndHashCode
public class Common {
    private String title;
    @Lob
    private String content;
    private long goodThumbs;
    private long badThumbs;

    public Common() {}
    public Common(String title, String content) {
        this.title = title;
        this.content = content;
        this.goodThumbs = 0;
        this.badThumbs = 0;
    }

    public void updateGoodT(long thumbs){
        this.goodThumbs += thumbs;
    }

    public void updateBadT(long thumbs){
        this.badThumbs += thumbs;
    }
}
