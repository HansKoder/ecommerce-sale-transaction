CREATE TABLE products (
    id BIGSERIAL PRIMARY KEY,
    product_name TEXT,                    
    product_description TEXT,             
    created_at TIMESTAMP DEFAULT now()    
);