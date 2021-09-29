package com.example.elasticsearch.service;

import com.example.elasticsearch.dto.SearchQuery;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;

public class DynamicSearchQueryBuilder {

    public static BoolQueryBuilder makeQuery(SearchQuery search) {
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        keywordBuilder(boolQuery, search);
        priceBuilder(boolQuery, search);
        zoneAndCategoryBuilder(boolQuery, search);
        return boolQuery;
    }

    private static void keywordBuilder(BoolQueryBuilder boolQuery, SearchQuery search) {
        if (search.getKeyword() != null) {
            boolQuery.should(QueryBuilders.multiMatchQuery(search.getKeyword(), "title", "description", "finishedProductText"));
        }
    }

    private static void priceBuilder(BoolQueryBuilder boolQuery, SearchQuery search) {
        boolQuery.must(QueryBuilders.rangeQuery("regularPrice").gte(search.getMinPrice()).lte(search.getMaxPrice()));
    }

    private static void zoneAndCategoryBuilder(BoolQueryBuilder boolQuery, SearchQuery search) {
        if (search.getCategoryIdList() != null) {
            boolQuery.must(QueryBuilders.termsQuery("categoryId", search.getCategoryIdList()));
        }

        if (search.getZoneId() != null) {
            boolQuery.must(QueryBuilders.matchQuery("zoneId", search.getZoneId()));
        }
    }
}
