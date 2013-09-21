CREATE TABLE data
(
  id     INT PRIMARY KEY                     NOT NULL AUTO_INCREMENT,
  txt    VARCHAR(45)                         NOT NULL,
  ts     TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  active BIT DEFAULT 1                       NOT NULL
);
