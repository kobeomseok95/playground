package com.example.solid.modules.locker;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUsingLocker is a Querydsl query type for UsingLocker
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUsingLocker extends EntityPathBase<UsingLocker> {

    private static final long serialVersionUID = -540033151L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUsingLocker usingLocker = new QUsingLocker("usingLocker");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QLocker locker;

    public final StringPath phone = createString("phone");

    public QUsingLocker(String variable) {
        this(UsingLocker.class, forVariable(variable), INITS);
    }

    public QUsingLocker(Path<? extends UsingLocker> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUsingLocker(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUsingLocker(PathMetadata metadata, PathInits inits) {
        this(UsingLocker.class, metadata, inits);
    }

    public QUsingLocker(Class<? extends UsingLocker> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.locker = inits.isInitialized("locker") ? new QLocker(forProperty("locker")) : null;
    }

}

