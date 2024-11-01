-- Insert Users
INSERT INTO Users (username, email, password) VALUES
                                                  ('johndoe', 'john@example.com', 'password123'),
                                                  ('janedoe', 'jane@example.com', 'password456');

-- Insert Books
INSERT INTO Books (title, author, isbn, published_date, genre) VALUES
                                                                   ('The Great Gatsby', 'F. Scott Fitzgerald', '9780743273565', '1925-04-10', 'Classic'),
                                                                   ('To Kill a Mockingbird', 'Harper Lee', '9780061120084', '1960-07-11', 'Classic'),
                                                                   ('1984', 'George Orwell', '9780451524935', '1949-06-08', 'Dystopian');

-- Insert Book Instances
INSERT INTO book_instances (book_id, status, due_date) VALUES
                                                          (1, 'available', NULL),
                                                          (1, 'checked_out', '2024-07-15'),
                                                          (2, 'available', NULL),
                                                          (3, 'reserved', '2024-07-20'),
                                                          (3, 'available', NULL);

-- Insert Checkouts
INSERT INTO Checkouts (user_id, instance_id, checkout_date, return_date) VALUES
                                                                             (1, 2, '2024-07-01 10:00:00', NULL), -- John Doe checks out a copy of "The Great Gatsby"
                                                                             (2, 4, '2024-07-02 11:00:00', NULL); -- Jane Doe reserves a copy of "1984"
