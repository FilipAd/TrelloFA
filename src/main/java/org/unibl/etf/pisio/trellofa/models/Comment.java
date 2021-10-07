package org.unibl.etf.pisio.trellofa.models;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Date;
import java.time.LocalDateTime;

@Data
public class Comment
{
    private Integer id;

    private String text;

    private Date date;

    private Integer idCard;

    private Integer idMember;

    private String memberUsername;

}
