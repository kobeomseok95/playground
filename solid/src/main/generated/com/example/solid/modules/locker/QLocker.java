package com.example.solid.modules.locker;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLocker is a Querydsl query type for Locker
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLocker extends EntityPathBase<Locker> {

    private static final long serialVersionUID = 1304548659L;

    public static final QLocker locker = new QLocker("locker");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> lockerNumber = createNumber("lockerNumber", Integer.class);

    public QLocker(String variable) {
        super(Locker.class, forVariable(variable));
    }

    public QLocker(Path<? extends Locker> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLocker(PathMetadata metadata) {
        super(Locker.class, metadata);
    }

}

