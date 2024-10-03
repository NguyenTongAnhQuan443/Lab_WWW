-- Sử dụng cơ sở dữ liệu www_week2
USE `www_week2`;

-- Dữ liệu cho bảng customer
INSERT INTO `customer` (address, cust_name, email, phone)
VALUES
('123 Example St.', 'John Doe', 'johndoe@example.com', '123456789'),
('456 Market St.', 'Jane Smith', 'janesmith@example.com', '987654321'),
('789 Industrial Rd.', 'Mike Johnson', 'mike.j@example.com', '111222333'),
('101 Broadway Ave.', 'Susan Lee', 'susan.l@example.com', '222333444'),
('202 Ocean Blvd.', 'Chris Brown', 'chris.b@example.com', '333444555');

-- Dữ liệu cho bảng employee
INSERT INTO `employee` (status, dob, address, email, full_name, phone)
VALUES
(1, '1990-05-12', '789 Industrial Rd.', 'john.doe@company.com', 'John Doe', '123456789'),
(2, '1985-09-23', '456 Maple Ave.', 'jane.smith@company.com', 'Jane Smith', '987654321'),
(1, '1992-07-18', '321 Sunset Blvd.', 'mike.johnson@company.com', 'Mike Johnson', '444555666'),
(0, '1995-01-30', '432 Pine St.', 'susan.lee@company.com', 'Susan Lee', '555666777'),
(1, '1993-11-11', '543 River Dr.', 'chris.brown@company.com', 'Chris Brown', '666777888');

-- Dữ liệu cho bảng product
INSERT INTO `product` (status, description, manufacturer_name, name, unit)
VALUES
(1, 'High-quality smartphone', 'TechCorp', 'Smartphone Pro', 'piece'),
(0, 'Wireless earbuds', 'AudioTech', 'Earbuds X', 'pair'),
(1, '4K Smart TV', 'VisionWorks', 'Vision TV', 'unit'),
(2, 'Gaming Laptop', 'GamerTech', 'Laptop GT-X', 'unit'),
(1, 'Bluetooth Speaker', 'SoundMaster', 'Speaker Boom', 'unit');

-- Dữ liệu cho bảng product_image
INSERT INTO `product_image` (product_id, alternative, path)
VALUES
(1, 'Front view of Smartphone Pro', '/images/smartphone_pro_front.jpg'),
(2, 'Earbuds X packaging', '/images/earbuds_x_package.jpg'),
(3, 'Vision TV promotional image', '/images/vision_tv.jpg'),
(4, 'Laptop GT-X display image', '/images/laptop_gtx.jpg'),
(5, 'Speaker Boom top view', '/images/speaker_boom.jpg');

-- Dữ liệu cho bảng product_price
INSERT INTO `product_price` (price, price_date_time, product_id, note)
VALUES
(999.99, '2024-09-28 12:00:00', 1, 'Launch price'),
(199.99, '2024-09-28 12:00:00', 2, 'Launch price'),
(1499.99, '2024-09-28 12:00:00', 3, 'Discounted price'),
(2499.99, '2024-09-28 12:00:00', 4, 'Special price for pre-order'),
(149.99, '2024-09-28 12:00:00', 5, 'New arrival');

-- Dữ liệu cho bảng orders
INSERT INTO `orders` (order_date, cust_id, employee_id)
VALUES
('2024-09-20', 1, 1),
('2024-09-21', 2, 2),
('2024-09-22', 3, 3),
('2024-09-23', 4, 4),
('2024-09-24', 5, 5);

-- Dữ liệu cho bảng order_details
INSERT INTO `order_detail` (order_id, product_id, quantity, price, note)
VALUES
(1, 1, 2, 999.99,'note'),  -- 2 chiếc Smartphone Pro cho order 1
(2, 2, 1, 199.99,'note'),  -- 1 chiếc Earbuds X cho order 2
(3, 3, 1, 1499.99,'note'),  -- 1 chiếc Vision TV cho order 3
(4, 4, 1, 2499.99,'note'),  -- 1 chiếc Laptop GT-X cho order 4
(5, 5, 3, 149.99,'note');   -- 3 chiếc Speaker Boom cho order 5
