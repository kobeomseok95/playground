package com.miniproject.yeolgongdabang.user.repository;

import com.miniproject.yeolgongdabang.user.User;
import com.miniproject.yeolgongdabang.user.UserSeat;
import com.querydsl.jpa.impl.JPAQuery;

public interface UserRepositoryCustom {

    UserSeat findByPhoneFetchSeatedAndEnableSeat(String phone);
}
