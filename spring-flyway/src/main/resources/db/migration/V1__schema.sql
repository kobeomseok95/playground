create table member (
    member_id bigint auto_increment,
    name varchar(200) not null,
    intro varchar(100) not null,
    primary key (member_id)
);

create table article(
    article_id bigint auto_increment,
    member_id bigint not null,
    title varchar(50) not null,
    description varchar(500) not null,
    primary key (article_id),

    constraint fk_article_member
    foreign key (member_id)
    references member(member_id)
);
