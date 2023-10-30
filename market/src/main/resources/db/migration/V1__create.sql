create table if not exists products
(id int  auto_increment,
 title varchar(255), description varchar(5000),
    price numeric(8, 2),
    primary key(id)
    );

create table if not exists users (
                       id                    integer auto_increment,
                       phone                 VARCHAR(30) not null UNIQUE,
                       password              VARCHAR(80) not null,
                       email                 VARCHAR(50) UNIQUE,
                       first_name            VARCHAR(50),
                       last_name             VARCHAR(50),
                       enabled                boolean default true,
                       PRIMARY KEY (id)
);

create table if not exists roles (
                       id                    integer auto_increment,
                       name                  VARCHAR(50) not null,
                       primary key (id)
);

create table  users_roles (
                             user_id               INTEGER NOT NULL,
                             role_id               INTEGER NOT NULL,
                             primary key (user_id, role_id),
                             FOREIGN KEY (user_id)
                                 REFERENCES users (id),
                             FOREIGN KEY (role_id)
                                 REFERENCES roles (id)
);

create table if not exists orders (id integer auto_increment, user_id integer, price numeric(8, 2) not null, address varchar (255) not null, phone_number varchar(30) not null, primary key(id), constraint fk_user_id foreign key (user_id) references users (id));

create table if not exists order_items (id integer auto_increment, order_id integer, product_id integer not null, quantity int, price numeric(8, 2), primary key(id), constraint fk_prod_id foreign key (product_id) references products (id), constraint fk_order_id foreign key (order_id) references orders (id));
