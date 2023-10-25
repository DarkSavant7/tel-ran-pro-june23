create table if not exists products
(
    id
    int
    auto_increment,
    title
    varchar
(
    255
), description varchar
(
    5000
),
    price numeric
(
    8,
    2
),
    primary key
(
    id
)
    );

create table if not exists users
(
    id
    integer
    auto_increment,
    phone
    VARCHAR
(
    30
) not null UNIQUE,
    password VARCHAR
(
    80
) not null,
    email VARCHAR
(
    50
) UNIQUE,
    first_name VARCHAR
(
    50
),
    last_name VARCHAR
(
    50
),
    enabled boolean default true,
    PRIMARY KEY
(
    id
)
    );

insert into users (phone, password, first_name, last_name, email, enabled)
values ('+79995554433', '$2y$12$LCRtWCx5RSDAv9CTABHTqOUUUHgtDnxGevP7THrfY3Ege7SD3y2Su', 'Vasya',
        'Pupkin', 'vp@example.org', true),
       ('+79998887766', '$2y$12$J5NpHQtsAc/B7dWgQeShdO0hSXWorm.jiel/KJ.OxVvQ8LtiG4YFC', 'Charles',
        'Bronson', 'bronson@example.org', true),
       ('1', '$2y$12$DOsDOtZc96P7EtCKiH0bb.8ZNLW5SHAltUEBUCXvoN3JTaRwD24Xa', 'test', 'test',
        'test@test.org', true),
       ('+79994443322', '$2y$12$L.kXVPmlt3KB8tsaReFNfeAQhkVByxQB/Sv6Q8mJzgrLmMzyh4M6m', 'Masha',
        'Ivanova', 'ivanova@example.org', true),
       ('2', '$2y$12$LCRtWCx5RSDAv9CTABHTqOUUUHgtDnxGevP7THrfY3Ege7SD3y2Su', '1', '1',
        '1@example.org', false);


create table if not exists roles
(
    id
    integer
    auto_increment,
    name
    VARCHAR
(
    50
) not null,
    primary key
(
    id
)
    );

insert into roles (name)
values ('ROLE_CUSTOMER'),
       ('ROLE_MANAGER'),
       ('ROLE_ADMIN'),
       ('ROLE_SUPERADMIN');

create table users_roles
(
    user_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
    primary key (user_id, role_id),
    FOREIGN KEY (user_id)
        REFERENCES users (id),
    FOREIGN KEY (role_id)
        REFERENCES roles (id)
);

insert into users_roles (user_id, role_id)
values (1, 1),
       (2, 2),
       (2, 3),
       (3, 4);

create table if not exists orders
(
    id
    integer
    auto_increment,
    user_id
    integer,
    price
    numeric
(
    8,
    2
) not null, address varchar
(
    255
) not null, phone_number varchar
(
    30
) not null, primary key
(
    id
), constraint fk_user_id foreign key
(
    user_id
) references users
(
    id
));

create table if not exists order_items
(
    id
    integer
    auto_increment,
    order_id
    integer,
    product_id
    integer
    not
    null,
    quantity
    int,
    price
    numeric
(
    8,
    2
), primary key
(
    id
), constraint fk_prod_id foreign key
(
    product_id
) references products
(
    id
), constraint fk_order_id foreign key
(
    order_id
) references orders
(
    id
));
