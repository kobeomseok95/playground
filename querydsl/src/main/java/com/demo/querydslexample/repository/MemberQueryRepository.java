package com.demo.querydslexample.repository;

import com.demo.querydslexample.controller.dto.MemberInfo;

import java.util.List;

public interface MemberQueryRepository {

    List<MemberInfo> getMembersInfo();
}
