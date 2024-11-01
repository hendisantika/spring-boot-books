CREATE TABLE BookInstances (
                               instance_id SERIAL PRIMARY KEY,
                               book_id INT REFERENCES Books(book_id),
                               status VARCHAR(20) CHECK (status IN ('available', 'checked_out', 'reserved')) NOT NULL,
                               due_date DATE,
                               created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
