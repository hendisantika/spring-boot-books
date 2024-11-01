CREATE TABLE Books (
                       book_id SERIAL PRIMARY KEY,
                       title VARCHAR(100) NOT NULL,
                       author VARCHAR(100) NOT NULL,
                       isbn VARCHAR(20) UNIQUE NOT NULL,
                       published_date DATE,
                       genre VARCHAR(50),
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
