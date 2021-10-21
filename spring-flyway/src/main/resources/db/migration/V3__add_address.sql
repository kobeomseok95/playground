ALTER TABLE member
    ADD address VARCHAR(255) NULL;

ALTER TABLE member
    MODIFY intro VARCHAR (100) NULL;

ALTER TABLE article
    MODIFY member_id BIGINT NULL;

ALTER TABLE member
    MODIFY name VARCHAR (255);

ALTER TABLE article
DROP
COLUMN view_count;

ALTER TABLE article
    ADD view_count INT NOT NULL;