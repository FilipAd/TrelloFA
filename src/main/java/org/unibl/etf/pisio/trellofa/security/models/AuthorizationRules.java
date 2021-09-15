package org.unibl.etf.pisio.trellofa.security.models;

import lombok.Data;

import java.util.List;

@Data
public class AuthorizationRules
{
    List<Rule> rules;
}
