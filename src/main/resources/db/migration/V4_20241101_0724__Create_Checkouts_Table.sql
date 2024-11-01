CREATE TABLE Checkouts (
                           checkout_id SERIAL PRIMARY KEY,
                           user_id INT REFERENCES Users(user_id),
                           instance_id INT REFERENCES BookInstances(instance_id),
                           checkout_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           return_date TIMESTAMP
);
