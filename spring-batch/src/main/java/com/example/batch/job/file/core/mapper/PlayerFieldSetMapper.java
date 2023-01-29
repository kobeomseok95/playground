package com.example.batch.job.file.core.mapper;

import com.example.batch.job.file.core.domain.Player;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class PlayerFieldSetMapper implements FieldSetMapper<Player> {

    @Override
    public Player mapFieldSet(FieldSet fieldSet) throws BindException {
        return new Player(
                fieldSet.readString(0),
                fieldSet.readString(1),
                fieldSet.readString(2),
                fieldSet.readString(3),
                fieldSet.readInt(4),
                fieldSet.readInt(5)
        );
    }
}
