CREATE TABLE stocks (
    id BIGSERIAL PRIMARY KEY,
    product_id INT,                    
    quantity TEXT,             
    created_at TIMESTAMP DEFAULT now()
);