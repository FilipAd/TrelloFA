package org.unibl.etf.pisio.trellofa.models.requests;

import lombok.Data;

@Data
public class BoardHasMembersRequest
{
    private Integer idBoard;

    private Integer idMember;
}

