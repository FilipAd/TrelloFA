package org.unibl.etf.pisio.trellofa.services;

import org.unibl.etf.pisio.trellofa.models.LoginResponse;
import org.unibl.etf.pisio.trellofa.models.requests.LoginRequest;

public interface AuthService
{
    LoginResponse login(LoginRequest request);
}
