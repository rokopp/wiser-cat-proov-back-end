CREATE TABLE IF NOT EXISTS amount (
    id                  SERIAL PRIMARY KEY,
    filter_id           INT NOT NULL,
    compare_condition   VARCHAR(20) NOT NULL,
    FOREIGN KEY (filter_id)
    REFERENCES filter (id) ON DELETE CASCADE
    );

INSERT INTO amount(filter_id, compare_condition) VALUES
((SELECT id from filter WHERE filter_name='first_filter'), 'More');

INSERT INTO amount(filter_id, compare_condition) VALUES
((SELECT id from filter WHERE filter_name='second_filter'), 'Less');
