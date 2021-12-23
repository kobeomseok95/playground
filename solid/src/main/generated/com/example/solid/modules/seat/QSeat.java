package com.example.solid.modules.seat;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSeat is a Querydsl query type for Seat
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSeat extends EntityPathBase<Seat> {

    private static final long serialVersionUID = 1476202835L;

    public static final QSeat seat = new QSeat("seat");

    public final com.example.solid.modules.QBaseEntity _super = new com.example.solid.modules.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final NumberPath<Integer> seatNumber = createNumber("seatNumber", Integer.class);

    public QSeat(String variable) {
        super(Seat.class, forVariable(variable));
    }

    public QSeat(Path<? extends Seat> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSeat(PathMetadata metadata) {
        super(Seat.class, metadata);
    }

}

