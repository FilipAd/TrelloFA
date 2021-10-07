package org.unibl.etf.pisio.trellofa.models.requests;

import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
public class CommentRequest
{
    private String text;

    private Date date;

    private Integer idCard;

    private Integer idMember;
}
