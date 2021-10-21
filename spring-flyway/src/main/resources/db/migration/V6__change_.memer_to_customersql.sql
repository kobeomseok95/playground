alter table article
add constraint fk_article_customer
foreign key (customer_id )
references customer(customer_id);