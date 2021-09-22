package org.unibl.etf.pisio.trellofa.models;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Date;

@Data
public class Card
{

    private Integer id;

    private String name;

    private String description;

    private String url;

    private Date due;

    private Byte dueComplete;

    private Byte closed;

    private Date dateLastActivity;

    private String idShort;

    private Long pos;

    private String shortLink;

    private String shortUrl;

    private Byte subscribed;

    private Integer dndIndex;

    private Integer idList;
}
