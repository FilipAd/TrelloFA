package org.unibl.etf.pisio.trellofa.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.pisio.trellofa.models.LoginResponse;
import org.unibl.etf.pisio.trellofa.models.requests.LoginRequest;
import org.unibl.etf.pisio.trellofa.models.requests.MemberRequest;
import org.unibl.etf.pisio.trellofa.services.AuthService;
import org.unibl.etf.pisio.trellofa.services.MemberService;

import javax.validation.Valid;

@RestController
public class AuthController
{
 private final AuthService authService;
 private final MemberService memberService;

    public AuthController(AuthService authService, MemberService memberService)
    {
        this.authService = authService;
        this.memberService = memberService;
    }

   @PostMapping("login")
    public LoginResponse login(@RequestBody @Valid LoginRequest request)
    {
        return authService.login(request);
    }
    @PostMapping("sign-up")
    public void signUp(@RequestBody @Valid MemberRequest memberRequest)
    {
        memberService.singUp(memberRequest);
    }
}
