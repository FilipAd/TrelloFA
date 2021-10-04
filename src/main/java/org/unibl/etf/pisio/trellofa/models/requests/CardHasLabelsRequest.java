package org.unibl.etf.pisio.trellofa.models.requests;

import lombok.Data;

@Data
public class CardHasLabelsRequest
{
    private Integer idCard;

    private Integer idLabel;
}

