DROP VIEW IF EXISTS car_brand_creation_datetime;

CREATE VIEW car_brand_creation_datetime AS
SELECT CURRENT_TIMESTAMP - INTERVAL FLOOR(RAND() * 20000 * 24 * 60 * 60) SECOND;

INSERT INTO brands (name, created)
VALUES ('Acura', (SELECT * FROM car_brand_creation_datetime)),
       ('Alfa-Romeo', (SELECT * FROM car_brand_creation_datetime)),
       ('Aston Martin', (SELECT * FROM car_brand_creation_datetime)),
       ('Audi', (SELECT * FROM car_brand_creation_datetime)),
       ('BMW', (SELECT * FROM car_brand_creation_datetime)),
       ('Bentley', (SELECT * FROM car_brand_creation_datetime)),
       ('Buick', (SELECT * FROM car_brand_creation_datetime)),
       ('Cadillac', (SELECT * FROM car_brand_creation_datetime)),
       ('Chevrolet', (SELECT * FROM car_brand_creation_datetime)),
       ('Chrysler', (SELECT * FROM car_brand_creation_datetime)),
       ('Daewoo', (SELECT * FROM car_brand_creation_datetime)),
       ('Daihatsu', (SELECT * FROM car_brand_creation_datetime)),
       ('Dodge', (SELECT * FROM car_brand_creation_datetime)),
       ('Eagle', (SELECT * FROM car_brand_creation_datetime)),
       ('Ferrari', (SELECT * FROM car_brand_creation_datetime)),
       ('Fiat', (SELECT * FROM car_brand_creation_datetime)),
       ('Fisker', (SELECT * FROM car_brand_creation_datetime)),
       ('Ford', (SELECT * FROM car_brand_creation_datetime)),
       ('Freightliner', (SELECT * FROM car_brand_creation_datetime)),
       ('GMC', (SELECT * FROM car_brand_creation_datetime)),
       ('Genesis', (SELECT * FROM car_brand_creation_datetime)),
       ('Geo', (SELECT * FROM car_brand_creation_datetime)),
       ('Honda', (SELECT * FROM car_brand_creation_datetime)),
       ('Hummer', (SELECT * FROM car_brand_creation_datetime)),
       ('Hyundai', (SELECT * FROM car_brand_creation_datetime)),
       ('Infinity', (SELECT * FROM car_brand_creation_datetime)),
       ('Isuzu', (SELECT * FROM car_brand_creation_datetime)),
       ('Jaguar', (SELECT * FROM car_brand_creation_datetime)),
       ('Jeep', (SELECT * FROM car_brand_creation_datetime)),
       ('Kia', (SELECT * FROM car_brand_creation_datetime)),
       ('Lamborghini', (SELECT * FROM car_brand_creation_datetime)),
       ('Land Rover', (SELECT * FROM car_brand_creation_datetime)),
       ('Lexus', (SELECT * FROM car_brand_creation_datetime)),
       ('Lincoln', (SELECT * FROM car_brand_creation_datetime)),
       ('Lotus', (SELECT * FROM car_brand_creation_datetime)),
       ('Mazda', (SELECT * FROM car_brand_creation_datetime)),
       ('Maserati', (SELECT * FROM car_brand_creation_datetime)),
       ('Maybach', (SELECT * FROM car_brand_creation_datetime)),
       ('McLaren', (SELECT * FROM car_brand_creation_datetime)),
       ('Mercedes-Benz', (SELECT * FROM car_brand_creation_datetime)),
       ('Mercury', (SELECT * FROM car_brand_creation_datetime)),
       ('Mini', (SELECT * FROM car_brand_creation_datetime)),
       ('Mitsubishi', (SELECT * FROM car_brand_creation_datetime)),
       ('Nissan', (SELECT * FROM car_brand_creation_datetime)),
       ('Oldsmobile', (SELECT * FROM car_brand_creation_datetime)),
       ('Panoz', (SELECT * FROM car_brand_creation_datetime)),
       ('Plymouth', (SELECT * FROM car_brand_creation_datetime)),
       ('Polestar', (SELECT * FROM car_brand_creation_datetime)),
       ('Pontiac', (SELECT * FROM car_brand_creation_datetime)),
       ('Porsche', (SELECT * FROM car_brand_creation_datetime)),
       ('Ram', (SELECT * FROM car_brand_creation_datetime)),
       ('Rivian', (SELECT * FROM car_brand_creation_datetime)),
       ('Rolls_Royce', (SELECT * FROM car_brand_creation_datetime)),
       ('Saab', (SELECT * FROM car_brand_creation_datetime)),
       ('Saturn', (SELECT * FROM car_brand_creation_datetime)),
       ('Smart', (SELECT * FROM car_brand_creation_datetime)),
       ('Subaru', (SELECT * FROM car_brand_creation_datetime)),
       ('Suzuki', (SELECT * FROM car_brand_creation_datetime)),
       ('Tesla', (SELECT * FROM car_brand_creation_datetime)),
       ('Toyota', (SELECT * FROM car_brand_creation_datetime)),
       ('Volkswagen', (SELECT * FROM car_brand_creation_datetime)),
       ('Volvo', (SELECT * FROM car_brand_creation_datetime));
