package com.example.solid.modules.voucher;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.example.solid.modules.voucher.domain.MemberVoucher;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberVoucher is a Querydsl query type for MemberVoucher
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberVoucher extends EntityPathBase<MemberVoucher> {

    private static final long serialVersionUID = 488326329L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberVoucher memberVoucher = new QMemberVoucher("memberVoucher");

    public final com.example.solid.modules.QBaseEntity _super = new com.example.solid.modules.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final DateTimePath<java.time.LocalDateTime> expiredDateTime = createDateTime("expiredDateTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final StringPath phone = createString("phone");

    public final BooleanPath use = createBoolean("use");

    public final QVoucher voucher;

    public QMemberVoucher(String variable) {
        this(MemberVoucher.class, forVariable(variable), INITS);
    }

    public QMemberVoucher(Path<? extends MemberVoucher> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberVoucher(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberVoucher(PathMetadata metadata, PathInits inits) {
        this(MemberVoucher.class, metadata, inits);
    }

    public QMemberVoucher(Class<? extends MemberVoucher> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.voucher = inits.isInitialized("voucher") ? new QVoucher(forProperty("voucher")) : null;
    }

}

