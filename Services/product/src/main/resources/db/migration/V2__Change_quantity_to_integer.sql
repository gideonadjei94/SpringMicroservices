ALTER TABLE product
ALTER COLUMN quantity TYPE INTEGER USING quantity::integer;