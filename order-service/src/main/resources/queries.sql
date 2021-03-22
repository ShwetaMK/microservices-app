CREATE TABLE `orders` (
   `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
   `order_name` varchar(255) DEFAULT NULL,
   `inventory_id` int(11) DEFAULT NULL,
   `quantity` int(11) DEFAULT NULL,
   `price` float DEFAULT 0.0,
   `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   `update_time` datetime DEFAULT NULL,  -- ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY (`order_id`)
 );
 

CREATE TRIGGER on_order_update BEFORE UPDATE ON orders
FOR EACH ROW SET NEW.update_time = CURRENT_TIMESTAMP; 