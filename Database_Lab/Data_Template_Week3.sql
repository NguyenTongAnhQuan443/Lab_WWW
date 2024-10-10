-- Use the correct database
USE `www_week3`;

-- Insert data into the 'product' table
INSERT INTO product (product_id, name, description, img_path, status) VALUES
(1, 'Product A', 'Description for Product A', 'img_a.jpg', 1),
(2, 'Product B', 'Description for Product B', 'img_b.jpg', 1),
(3, 'Product C', 'Description for Product C', 'img_c.jpg', 1),
(4, 'Product D', 'Description for Product D', 'img_d.jpg', 0),
(5, 'Product E', 'Description for Product E', 'img_e.jpg', 1);

-- Insert data into the 'product_price' table with multiple prices for each product
INSERT INTO product_price (price_id, product_id, apply_date, value, note) VALUES
(1, 1, '2024-01-01 10:00:00', 100.0, 'Initial price'),
(2, 1, '2024-06-01 10:00:00', 120.0, 'Updated price'),
(3, 2, '2024-02-01 11:00:00', 150.0, 'Initial price'),
(4, 2, '2024-07-01 11:00:00', 160.0, 'Mid-year update'),
(5, 3, '2024-03-01 12:00:00', 200.0, 'Initial price'),
(6, 3, '2024-08-01 12:00:00', 220.0, 'Mid-year update'),
(7, 4, '2024-04-01 13:00:00', 250.0, 'Initial price'),
(8, 4, '2024-09-01 13:00:00', 270.0, 'End of season update'),
(9, 5, '2024-05-01 14:00:00', 300.0, 'Initial price'),
(10, 5, '2024-10-01 14:00:00', 320.0, 'End of year update');
