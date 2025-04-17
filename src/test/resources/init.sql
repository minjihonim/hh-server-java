CREATE TABLE `user` (
                        `id` bigint PRIMARY KEY,
                        `name` varchar(50),
                        `register_date` datetime NOT NULL,
                        `update_date` datetime
);

CREATE TABLE `balance` (
                           `user_id` bigint PRIMARY KEY,
                           `amount` bigint,
                           `register_date` datetime NOT NULL,
                           `update_date` datetime
);

CREATE TABLE `balance_history` (
                                   `id` bigint AUTO_INCREMENT PRIMARY KEY,
                                   `user_id` bigint,
                                   `amount` bigint,
                                   `type` varchar(10),
                                   `register_date` datetime NOT NULL,
                                   `update_date` datetime
);

CREATE TABLE `coupon` (
                          `id` bigint PRIMARY KEY,
                          `name` varchar(50),
                          `discount` int,
                          `start_time` datetime,
                          `end_time` datetime,
                          `max_quantity` int,
                          `issued_quantity` int,
                          `expiration_day` date,
                          `register_date` datetime NOT NULL ,
                          `update_date` datetime
);

CREATE TABLE `issued_coupon` (
                                 `id` bigint AUTO_INCREMENT PRIMARY KEY,
                                 `user_id` bigint,
                                 `coupon_id` bigint,
                                 `used_date` date,
                                 `register_date` datetime NOT NULL,
                                 `update_date` datetime
);

CREATE TABLE `order` (
                         `id` bigint AUTO_INCREMENT PRIMARY KEY,
                         `user_id` bigint,
                         `amount` bigint,
                         `coupon_id` bigint,
                         `final_amount` bigint,
                         `payment_id` bigint,
                         `register_date` datetime,
                         `update_date` datetime
);

CREATE TABLE `order_item` (
                              `id` bigint AUTO_INCREMENT PRIMARY KEY,
                              `order_id` bigint,
                              `product_option_id` bigint,
                              `product_price` int,
                              `quantity` int,
                              `amount` bigint,
                              `register_date` datetime,
                              `update_date` datetime
);

CREATE TABLE `product` (
                           `id` bigint PRIMARY KEY,
                           `name` varchar(100),
                           `price` bigint,
                           `description` text,
                           `register_date` datetime,
                           `update_date` datetime
);

CREATE TABLE `product_option` (
                                  `id` bigint AUTO_INCREMENT PRIMARY KEY,
                                  `product_id` bigint,
                                  `name` varchar(100),
                                  `quantity` int,
                                  `register_date` datetime,
                                  `update_date` datetime
);

CREATE TABLE `payment` (
                           `id` bigint AUTO_INCREMENT PRIMARY KEY,
                           `user_id` bigint,
                           `order_id` bigint,
                           `amount` bigint,
                           `status` varchar(10),
                           `failed_reason` varchar(255),
                           `register_date` datetime,
                           `update_date` datetime
);

-- insert

INSERT INTO `user` (id, name, register_date) VALUES (1, '홍길동', NOW());
INSERT INTO `balance` (user_id, amount, register_date) VALUES (1, 10, NOW());

-- coupon
 -- 쿠폰 발급 성공용 데이터
INSERT INTO `coupon` (id, name, discount, start_time, end_time, max_quantity, issued_quantity, expiration_day, register_date)
VALUES (1, "10% 할인쿠폰", 10, '20250401', '20250430', 50, 0, '20250430', NOW())
