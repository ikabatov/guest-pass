-- Участники клуба
CREATE TABLE customers (
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name  VARCHAR(100) NOT NULL
);

-- Одноразовые QR-коды участников (у одного участника может быть много кодов)
CREATE TABLE qr_codes (
    code        UUID PRIMARY KEY,
    customer_id INTEGER NOT NULL REFERENCES customers (id)
);
