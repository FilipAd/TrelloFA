package org.unibl.etf.pisio.trellofa.models;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
public class Board
{
    private Integer id;

    private String name;

    private String desc;

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
