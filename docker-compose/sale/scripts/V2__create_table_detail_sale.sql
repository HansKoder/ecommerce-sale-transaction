CREATE TABLE details_sale (
    id BIGSERIAL PRIMARY KEY,
    sale_id INT,                    
    product_id INT,                    
    quantity TEXT,             
    subtotal NUMERIC,
    created_at TIMESTAMP DEFAULT now(),
    CONSTRAINT fk_sale_id FOREIGN KEY (sale_id) REFERENCES sales (id)
);