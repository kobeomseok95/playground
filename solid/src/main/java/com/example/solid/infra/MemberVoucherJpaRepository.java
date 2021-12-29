package com.example.solid.infra;

import com.example.solid.modules.unit.voucher.domain.MemberVoucher;
import com.example.solid.modules.unit.voucher.domain.MemberVoucherRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberVoucherJpaRepository extends JpaRepository<MemberVoucher, Long>, MemberVoucherRepository {
}
