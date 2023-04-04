create table stocks (

    id bigint not null auto_increment,
    name varchar(100) not null,
    description varchar(255) not null,
    provider varchar(100) not null,
    quantity int not null,
    type enum('ELECTRONICS','CLOTHING','FURNISHINGS','AUTOMOTIVE_PRODUCTS','GAMES'),

    primary key (id)
)