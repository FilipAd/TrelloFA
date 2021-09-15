package org.unibl.etf.pisio.trellofa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.unibl.etf.pisio.trellofa.models.entities.MemberEntity;
import org.unibl.etf.pisio.trellofa.services.MemberService;

import java.util.Optional;

@Configuration
public class AuditConfig
{
    private final MemberService memberService;

    public AuditConfig(MemberService memberService)
    {
        this.memberService=memberService;
    }

    @Bean
    AuditorAware<MemberEntity> auditorProvider()
    {
        return new AuditorAwareImpl(memberService);
    }
    }

