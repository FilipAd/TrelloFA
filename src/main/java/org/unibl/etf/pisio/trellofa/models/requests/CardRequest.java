package org.unibl.etf.pisio.trellofa.models.requests;

import lombok.Data;

import java.sql.Date;

@Data
public class CardRequest
{
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

    private Integer idList;

    private Integer dndIndex;
}
