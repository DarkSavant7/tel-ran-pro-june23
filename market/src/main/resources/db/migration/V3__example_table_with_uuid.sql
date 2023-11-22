create table if not exists uuid_examples
(
    id          binary(16) primary key,
    title       varchar(255),
    description varchar(5000)
);

insert into uuid_examples(id, title, description)
values (UUID_TO_BIN('d4d8fd73-2b35-460b-802f-ed04d8531496'), 'test', 'description');