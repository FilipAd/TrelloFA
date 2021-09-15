package org.unibl.etf.pisio.trellofa.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.unibl.etf.pisio.trellofa.models.JwtMember;
import org.unibl.etf.pisio.trellofa.models.enums.Status;
import org.unibl.etf.pisio.trellofa.repositories.MemberEntityRepository;
import org.unibl.etf.pisio.trellofa.services.JwtUserDetailsService;

@Service
public class JwtUserDetailsServiceImpl implements JwtUserDetailsService {

    private final MemberEntityRepository memberEntityRepository;
    private final ModelMapper modelMapper;

    public JwtUserDetailsServiceImpl(MemberEntityRepository userEntityRepository, ModelMapper modelMapper)
    {
        this.memberEntityRepository = userEntityRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public JwtMember loadUserByUsername(String username) throws UsernameNotFoundException
    {
        return modelMapper.map(memberEntityRepository.findByUsernameAndStatus(username,Status.ACTIVE).orElseThrow(()->new UsernameNotFoundException(username)),JwtMember.class);

    }
}
