DROP TABLE IF EXISTS book;

CREATE TABLE book (
                      id INT AUTO_INCREMENT  PRIMARY KEY,
                      title VARCHAR(250) NOT NULL,
                      author VARCHAR(250) NOT NULL,
                      isbn VARCHAR(14) NOT NULL,
                      price DECIMAL(19,4) NOT NULL,
                      quantity INT NOT NULL DEFAULT 0
);