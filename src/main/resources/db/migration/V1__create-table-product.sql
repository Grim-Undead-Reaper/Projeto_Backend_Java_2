CREATE TABLE Product (
    product_ID TEXT PRIMARY KEY NOT NULL UNIQUE,
    product_name TEXT NOT NULL,
    price_in_cents int NOT NULL,
    quantity int NOT NULL,
    category TEXT NOT NULL
);