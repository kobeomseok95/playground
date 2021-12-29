package com.example.solid.modules.unit.voucher.domain;

import java.util.Optional;

public interface VoucherRepository {

    Voucher save(Voucher voucher);

    Optional<Voucher> findById(Long id);
}
