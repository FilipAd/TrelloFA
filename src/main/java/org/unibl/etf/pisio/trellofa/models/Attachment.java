package org.unibl.etf.pisio.trellofa.models;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Date;

@Data
public class Attachment
{

    private Integer id;

    private Integer bytes;

    private Date date;

    private Byte isUpload;

    private String mimeType;

    private String name;

    private String url;

    private Integer idMember;
}
