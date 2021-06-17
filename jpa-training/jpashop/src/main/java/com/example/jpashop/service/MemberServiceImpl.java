package com.example.jpashop.service;

import com.example.jpashop.domain.Member;
import com.example.jpashop.domain.Order;
import com.example.jpashop.dto.MemberDto;
import com.example.jpashop.repository.MemberRepository;
import com.example.jpashop.repository.OrderRepository;
import com.example.jpashop.util.MemberMapper;
import com.example.jpashop.util.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.*;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;
    private final MemberMapper memberMapper;
    private final OrderMapper orderMapper;

    @Override
    public List<MemberDto> getMembers() {
        return memberRepository.findAll()
                .stream()
                .map(memberMapper::map)
                .collect(toList());
    }

    @Override
    public MemberDto getMember(Long id) {

        List<Order> orderList = orderRepository.findByMemberIdFetch(id);
        return orderList.isEmpty()
                ? memberMapper.map(memberRepository.findById(id).orElseThrow())
                : orderMapper.map(orderList);
    }

    @Override
    public MemberDto join(MemberDto request) throws Exception {

        validDuplicateMemberName(request.getName());
        Member member = memberMapper.memberDtoToMember(request);
        memberRepository.save(member);
        return memberMapper.map(member);
    }

    @Override
    public void validDuplicateMemberName(String name) throws Exception {
        memberRepository.findByName(name).ifPresent(m -> {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        });
    }
}
