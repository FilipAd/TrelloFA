package org.unibl.etf.pisio.trellofa.models.requests;

import lombok.Data;

    @Data
    public class InvitationRequest
    {
        private Integer idBoard;

        private Integer idMember;

        private String sender;
    }


