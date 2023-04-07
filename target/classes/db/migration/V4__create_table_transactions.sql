create table transactions (

    id bigint not null auto_increment primary key,
    user_id bigint not null,
    date_time DATETIME not null,
    transaction_type enum('REGISTER_PRODUCT','UPDATE_PRODUCT','UPDATE_QUANTITY_PRODUCT','DELETE_PRODUCT'),
    foreign key (user_id) references users(id)
);