DROP TABLE IF EXISTS transaction;
DROP TABLE IF EXISTS account;

CREATE TABLE account(
  `id`           INT NOT NULL AUTO_INCREMENT,
  `number`       VARCHAR(50) NOT NULL,
  `type`         INT NOT NULL,
  `balance`      DECIMAL(20) NULL,
  `currency`     VARCHAR(10) NOT NULL,
  `balance_date` DATETIME NULL,
PRIMARY KEY(`id`));

CREATE TABLE transaction(
  `id`                      INT NOT NULL AUTO_INCREMENT,
  `account_id`              INT NOT NULL,
  `date`                    DATETIME NOT NULL,
  `amount`                  DECIMAL(20) NOT NULL,
  `currency`                VARCHAR(10) NOT NULL,
  `type`                    INT NOT NULL,
  `narrative`               VARCHAR(250) NULL,
PRIMARY KEY(`id`));

INSERT INTO account(id, number, `type`, balance, currency, balance_date)
VALUES (1, '123-123456-1', 0, 44680, 'USD', '2020-08-07 00:00:00'),
(2, '342-646355-2', 0, 4000, 'USD', '2020-08-07 00:00:00'),
(3, '765-123424-3', 1, 3800, 'AUD', '2020-08-07 00:00:00'),
(4, '264-123664-4', 0, 12120, 'AUD', '2020-08-07 00:00:00'),
(5, '632-122446-5', 1, 34324, 'AUD', '2020-08-07 00:00:00');

INSERT INTO transaction(account_id, `date`, amount, currency, `type`, narrative)
values (1, '2020-08-07 00:12:33', 12, 'USD', 0, 'Direct transfer'),
(1, '2020-08-07 02:12:33', 20, 'USD', 0, 'Direct transfer'),
(3, '2020-08-07 03:11:00', 32, 'AUD', 0, 'Direct transfer'),
(3, '2020-08-07 12:11:00', 500, 'AUD', 0, 'Direct transfer');
