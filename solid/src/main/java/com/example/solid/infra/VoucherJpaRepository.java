package com.example.solid.infra;

import com.example.solid.modules.voucher.Voucher;
import com.example.solid.modules.voucher.VoucherRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherJpaRepository extends JpaRepository<Voucher, Long>, VoucherRepository {
}
