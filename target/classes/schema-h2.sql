DROP TABLE IF EXISTS books;

CREATE TABLE books (
  id      INT PRIMARY KEY AUTO_INCREMENT,
  book_name    VARCHAR(200),
  author   VARCHAR(20),
  translator    VARCHAR(20),
  ISBN    VARCHAR(13),
  publisher    VARCHAR(50),
  publication_date    DATE,
  price    INT,
  created_date    TIMESTAMP,
  modified_date    TIMESTAMP
);