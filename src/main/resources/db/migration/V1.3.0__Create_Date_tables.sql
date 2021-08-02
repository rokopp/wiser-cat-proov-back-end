CREATE TABLE IF NOT EXISTS date (
    id                  SERIAL PRIMARY KEY,
    type                VARCHAR(20) NOT NULL,
    filter_id           INT NOT NULL,
    compare_condition   VARCHAR(20) NOT NULL,
    date			    DATE NOT NULL DEFAULT CURRENT_DATE,
    FOREIGN KEY (filter_id)
    REFERENCES filter (id) ON DELETE CASCADE
    );

INSERT INTO date(filter_id, type, date, compare_condition) VALUES
((SELECT id from filter WHERE filter_name='first_filter'), 'Date', current_timestamp, 'From');

INSERT INTO date(filter_id, type, date, compare_condition) VALUES
((SELECT id from filter WHERE filter_name='second_filter'), 'Date', current_timestamp, 'Before');
