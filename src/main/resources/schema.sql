CREATE TABLE IF NOT EXISTS `transaction`(
       id SERIAL PRIMARY KEY,
       `type` int,
       `date` date,
       amount decimal,
       cpf bigint,
       card varchar(255),
       `hour` time,
       shop_owner varchar(255),
       shop_name varchar(255)
);