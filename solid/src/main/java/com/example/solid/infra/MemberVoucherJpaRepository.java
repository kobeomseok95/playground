package com.example.solid.infra;

import com.example.solid.modules.voucher.MemberVoucher;
import com.example.solid.modules.voucher.MemberVoucherRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberVoucherJpaRepository extends JpaRepository<MemberVoucher, Long>, MemberVoucherRepository {
}
