package org.unibl.etf.pisio.trellofa.config;

import lombok.SneakyThrows;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.unibl.etf.pisio.trellofa.exceptions.NotFoundException;
import org.unibl.etf.pisio.trellofa.models.JwtMember;
import org.unibl.etf.pisio.trellofa.models.Member;
import org.unibl.etf.pisio.trellofa.models.entities.MemberEntity;
import org.unibl.etf.pisio.trellofa.services.MemberService;
import org.springframework.security.core.Authentication;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<MemberEntity>
{
    private final MemberService memberService;

    public AuditorAwareImpl(MemberService memberService)
    {
        this.memberService = memberService;
    }


    @Override
    public Optional<MemberEntity> getCurrentAuditor()
    {

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication instanceof JwtMember) {
                JwtMember jwtMember = (JwtMember) authentication.getPrincipal();
            //   return Optional.of(memberService.findByIdMember(jwtMember.getId()));
            }


        return Optional.empty();
    }
}
