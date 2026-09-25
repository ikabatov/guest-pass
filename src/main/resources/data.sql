-- Начальные данные для ручной проверки API
INSERT INTO customers (first_name, last_name)
VALUES ('Petr', 'Ivanov'),
       ('Vladimir', 'Lenov'),
       ('Marya', 'Medvedeva'),
       ('Inna', 'Milovanova'),
       ('Garik', 'Tyhachev');

-- UUID заданы явно, чтобы по ним можно было проверить вход
INSERT INTO qr_codes (code, customer_id)
VALUES ('65f7fa23-cf06-4ee4-9012-49a15580f9b8', 1),
       ('ade2b7c3-a874-408e-8b56-21808707e8c5', 3),
       ('659b5b84-fa10-45b6-be7f-0b8c98d39d78', 5);
