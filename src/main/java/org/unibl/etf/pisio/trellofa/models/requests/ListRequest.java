package org.unibl.etf.pisio.trellofa.models.requests;

import lombok.Data;

@Data
public class ListRequest
{
    private String name;

    private Byte closed;

    private Integer pos;

    private Byte subscribed;

    private Integer idBoard;

}
