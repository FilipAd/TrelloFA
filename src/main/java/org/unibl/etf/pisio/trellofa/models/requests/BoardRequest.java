package org.unibl.etf.pisio.trellofa.models.requests;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BoardRequest
{
    private String name;

    private String description;

    private Byte closed;

    private Byte pinned;

    private String url;

    private Byte invited;

    private String shortUrl;

    private Byte subscribed;

    private Timestamp dateLastActivity;

    private Timestamp dateLastView;

    private String shortLink;

    private Integer idOrganization;
}
