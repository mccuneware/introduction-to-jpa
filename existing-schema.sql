PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;
	
CREATE TABLE products (
    product_id NUMBER(10) NOT NULL,
    product_name VARCHAR, 
    PRIMARY KEY (product_id));
	
COMMIT;

