package com.example.solid.modules.seat;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTakenSeat is a Querydsl query type for TakenSeat
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTakenSeat extends EntityPathBase<TakenSeat> {

    private static final long serialVersionUID = -1602060066L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTakenSeat takenSeat = new QTakenSeat("takenSeat");

    public final com.example.solid.modules.QBaseEntity _super = new com.example.solid.modules.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final com.example.solid.modules.voucher.QMemberVoucher memberVoucher;

    public final DateTimePath<java.time.LocalDateTime> remainDateTime = createDateTime("remainDateTime", java.time.LocalDateTime.class);

    public final QSeat seat;

    public final BooleanPath use = createBoolean("use");

    public QTakenSeat(String variable) {
        this(TakenSeat.class, forVariable(variable), INITS);
    }

    public QTakenSeat(Path<? extends TakenSeat> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTakenSeat(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTakenSeat(PathMetadata metadata, PathInits inits) {
        this(TakenSeat.class, metadata, inits);
    }

    public QTakenSeat(Class<? extends TakenSeat> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.memberVoucher = inits.isInitialized("memberVoucher") ? new com.example.solid.modules.voucher.QMemberVoucher(forProperty("memberVoucher"), inits.get("memberVoucher")) : null;
        this.seat = inits.isInitialized("seat") ? new QSeat(forProperty("seat")) : null;
    }

}

