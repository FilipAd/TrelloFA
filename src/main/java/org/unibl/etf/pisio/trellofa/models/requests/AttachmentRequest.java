package org.unibl.etf.pisio.trellofa.models.requests;

import lombok.Data;

import java.sql.Date;

@Data
public class AttachmentRequest
{
    private Integer bytes;

    private Date date;

    private Byte isUpload;

    private String mimeType;

    private String name;

    private String url;

    private Integer idMember;
}
