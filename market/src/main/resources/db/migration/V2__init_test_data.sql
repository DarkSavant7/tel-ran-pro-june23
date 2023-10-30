insert into users (phone, password, first_name, last_name, email, enabled) values
                                                                               ('+79995554433', '$2y$12$LCRtWCx5RSDAv9CTABHTqOUUUHgtDnxGevP7THrfY3Ege7SD3y2Su', 'Vasya', 'Pupkin', 'vp@example.org', true),
                                                                               ('+79998887766', '$2y$12$J5NpHQtsAc/B7dWgQeShdO0hSXWorm.jiel/KJ.OxVvQ8LtiG4YFC', 'Charles', 'Bronson', 'bronson@example.org', true),
                                                                               ('1', '$2y$12$DOsDOtZc96P7EtCKiH0bb.8ZNLW5SHAltUEBUCXvoN3JTaRwD24Xa', 'test', 'test', 'test@test.org', true),
                                                                               ('+79994443322', '$2y$12$L.kXVPmlt3KB8tsaReFNfeAQhkVByxQB/Sv6Q8mJzgrLmMzyh4M6m', 'Masha', 'Ivanova', 'ivanova@example.org', true),
                                                                               ('2', '$2y$12$LCRtWCx5RSDAv9CTABHTqOUUUHgtDnxGevP7THrfY3Ege7SD3y2Su', '1', '1', '1@example.org', false);


insert into roles (name)
values
    ('ROLE_CUSTOMER'), ('ROLE_MANAGER'), ('ROLE_ADMIN'), ('ROLE_SUPERADMIN');

insert into  users_roles (user_id, role_id)
values
    (1, 1),
    (2, 2),
    (2, 3),
    (3, 4);