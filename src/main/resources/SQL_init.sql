INSERT INTO roles (id, name) VALUES (1, 'ROLE_USER'), (2, 'ROLE_ADMIN');

INSERT INTO users (username, password, age)
VALUES
    ('user', 'user', 22),
    ('admin', 'admin', 88);

INSERT INTO users_roles (user_id, role_id)
VALUES
    (1, 1),
    (2, 1),
    (2, 2);