package com.example.bulkquery.repository;

import com.example.bulkquery.entity.Article;
import com.example.bulkquery.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public void saveAll(Article article, List<Comment> comments) {
        Long articleId = article.getId();
        jdbcTemplate.batchUpdate("insert into comment(article_id, comment) " +
                        "values(?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setLong(1, articleId);
                        ps.setString(2, comments.get(i).getComment());
                    }

                    @Override
                    public int getBatchSize() {
                        return comments.size();
                    }
                });
    }
}
