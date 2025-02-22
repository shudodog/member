package com.ssg.member.config;

import com.ssg.member.domain.Member;
import com.ssg.member.domain.code.MbrStatCode;
import com.ssg.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
@Profile(value = "default | dev")
public class InitData {

    private final MemberRepository memberRepository;

    @PostConstruct
    public void init() {
        Member testMember1 = Member.builder()
                .mbrLoginId("test1")
                .mbrStatCd(MbrStatCode.ACTIVE)
                .build();

        Member testMember2 = Member.builder()
                .mbrLoginId("test2")
                .mbrStatCd(MbrStatCode.DORMANT)
                .build();

        memberRepository.save(testMember1);
        memberRepository.save(testMember2);
    }

}
