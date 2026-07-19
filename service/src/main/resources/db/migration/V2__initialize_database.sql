CREATE SCHEMA IF NOT EXISTS reactive_rating_service;

CREATE TABLE IF NOT EXISTS reactive_rating_service.rating
(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    product_code VARCHAR(255) NOT NULL,
    value DECIMAL(3, 2) CHECK(value BETWEEN 1 AND 5)
);

COMMENT ON TABLE reactive_rating_service.rating IS 'Рейтинги';
COMMENT ON COLUMN reactive_rating_service.rating.id IS 'Идентификатор рейтинга';
COMMENT ON COLUMN reactive_rating_service.rating.product_code IS 'Код товара';
COMMENT ON COLUMN reactive_rating_service.rating.value IS 'Значение рейтинга';