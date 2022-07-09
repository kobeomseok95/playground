package com.example.ddd.article.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@SecondaryTable(
        name = "article_content",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "article_id")
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long id;

    @AttributeOverrides({
            @AttributeOverride(
                name = "title",
                column = @Column(table = "article_content", name = "title")),
            @AttributeOverride(
                    name = "contents",
                    column = @Column(table = "article_content", name = "contents")
            ),
            @AttributeOverride(
                    name = "createdDate",
                    column = @Column(table = "article_content", name = "created_date")
            )
    })
    @Embedded
    private ArticleContents contents;
}
