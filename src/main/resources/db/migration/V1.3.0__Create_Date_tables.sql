CREATE TABLE IF NOT EXISTS date (
                                     id              SERIAL PRIMARY KEY,
                                     filter_id      INT NOT NULL,
                                     compare_condition			DATE NOT NULL,
    FOREIGN KEY (filter_id)
    REFERENCES filter (id) ON DELETE CASCADE
    );

INSERT INTO date(filter_id, compare_condition) VALUES
((SELECT id from filter WHERE filter_name='first_filter'), current_timestamp);

INSERT INTO date(filter_id, compare_condition) VALUES
((SELECT id from filter WHERE filter_name='second_filter'), current_timestamp);
