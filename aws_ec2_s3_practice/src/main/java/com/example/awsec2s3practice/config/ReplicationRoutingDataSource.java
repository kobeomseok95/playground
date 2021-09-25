package com.example.awsec2s3practice.config;

import com.example.awsec2s3practice.util.CircularList;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class ReplicationRoutingDataSource extends AbstractRoutingDataSource {

    private CircularList<String> dataSourceNameList;

    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        super.setTargetDataSources(targetDataSources);

        dataSourceNameList = new CircularList<>(
                targetDataSources.keySet()
                        .stream()
                        .filter(key -> key.toString().contains("slave"))
                        .map(Object::toString)
                        .collect(toList()));
    }

    @Override
    protected Object determineCurrentLookupKey() {
        boolean isReadOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
        if (isReadOnly) {
            return dataSourceNameList.getOne();
        } else {
            return "master";
        }
    }
}
