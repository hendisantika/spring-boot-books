CREATE TABLE Checkouts (
                           checkout_id bigserial PRIMARY KEY,
                           user_id BIGINT REFERENCES Users(user_id),
                           instance_id BIGINT REFERENCES book_instances(instance_id),
                           checkout_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           return_date TIMESTAMP
);
