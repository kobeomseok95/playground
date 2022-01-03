package com.example.solid.infra;

import com.example.solid.modules.voucher.domain.Voucher;
import com.example.solid.modules.voucher.domain.VoucherRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherJpaRepository extends JpaRepository<Voucher, Long>, VoucherRepository {
}
