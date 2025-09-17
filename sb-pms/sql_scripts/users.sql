create table users(
                      id int primary key auto_increment,
                      name varchar(120) not null,
                      email varchar(160) not null unique,
                      role varchar(20) not null,
                      created_at timestamp not null default current_timestamp
);

-- projects
create table projects(
                         id int primary key auto_increment,
                         name varchar(140) not null,
                         code varchar(40) not null unique,
                         description text,
                         owner_id bigint not null,
                         start_date date,
                         end_date date,
                         created_at timestamp not null default current_timestamp,
                         constraint fk_project_owner foreign key(owner_id) references users(id)
);