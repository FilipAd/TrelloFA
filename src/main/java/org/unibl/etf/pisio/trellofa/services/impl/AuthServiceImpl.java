package org.unibl.etf.pisio.trellofa.services.impl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.trellofa.exceptions.UnauthorizedException;
import org.unibl.etf.pisio.trellofa.models.JwtMember;
import org.unibl.etf.pisio.trellofa.models.LoginResponse;
import org.unibl.etf.pisio.trellofa.models.Member;
import org.unibl.etf.pisio.trellofa.models.requests.LoginRequest;
import org.unibl.etf.pisio.trellofa.services.AuthService;
import org.unibl.etf.pisio.trellofa.services.MemberService;
import org.unibl.etf.pisio.trellofa.util.LoggingUtil;

import java.util.Date;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final MemberService memberService;
    @Value("${authorization.token.expiration-time}")
    private String tokenExpirationTime;
    @Value("${authorization.token.secret}")
    private String tokenSecret;


    public AuthServiceImpl(AuthenticationManager authenticationManager,MemberService memberService)
    {
        this.authenticationManager = authenticationManager;
        this.memberService = memberService;

    }

    @Override
    public LoginResponse login(LoginRequest request) {
        LoginResponse response = new LoginResponse();
        try {
            Authentication authenticater = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    request.getUsername(), request.getPassword()
                            )
                    );
            JwtMember user = (JwtMember) authenticater.getPrincipal();
            Member memberpom=memberService.findByIdMember(user.getId());
            response.setId(memberpom.getId());
            response.setUsername(memberpom.getUsername());
            response.setEmail(memberpom.getEmail());
            response.setFullname(memberpom.getFullname());
            response.setToken(generateJwt(user));
        } catch (Exception ex)
        {
            LoggingUtil.logException(ex, getClass());
            throw new UnauthorizedException();
        }
        return response;
    }

    private String generateJwt(JwtMember user) {
        return Jwts.builder()
                .setId(user.getId().toString())
                .setSubject(user.getUsername())
                .claim("role", user.getRole().name())
                .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(tokenExpirationTime)))
                .signWith(SignatureAlgorithm.HS512, tokenSecret)
                .compact();
    }
}
