package com.example.solid.modules.unit.voucher.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QVoucher is a Querydsl query type for Voucher
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QVoucher extends EntityPathBase<Voucher> {

    private static final long serialVersionUID = -1633971745L;

    public static final QVoucher voucher = new QVoucher("voucher");

    public final com.example.solid.modules.QBaseEntity _super = new com.example.solid.modules.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final StringPath passName = createString("passName");

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final NumberPath<Integer> time = createNumber("time", Integer.class);

    public QVoucher(String variable) {
        super(Voucher.class, forVariable(variable));
    }

    public QVoucher(Path<? extends Voucher> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVoucher(PathMetadata metadata) {
        super(Voucher.class, metadata);
    }

}

