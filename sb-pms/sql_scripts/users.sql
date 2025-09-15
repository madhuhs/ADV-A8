create table users(
                      id int primary key auto_increment,
                      name varchar(120) not null,
                      email varchar(160) not null unique,
                      role varchar(20) not null,
                      created_at timestamp not null default current_timestamp
);