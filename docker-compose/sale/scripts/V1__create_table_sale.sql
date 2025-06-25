CREATE TABLE sales (
    id BIGSERIAL PRIMARY KEY,
    customer TEXT,                    
    total NUMERIC,             
    created_at TIMESTAMP DEFAULT now()
);