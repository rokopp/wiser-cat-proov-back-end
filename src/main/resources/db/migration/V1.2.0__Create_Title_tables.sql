CREATE TABLE IF NOT EXISTS title (
    id                  SERIAL PRIMARY KEY,
    type                VARCHAR(20) NOT NULL,
    filter_id           INT NOT NULL,
    compare_condition	VARCHAR(20) NOT NULL,
    text                VARCHAR(254) NOT NULL,
    FOREIGN KEY (filter_id)
    REFERENCES filter (id) ON DELETE CASCADE
    );

INSERT INTO title(filter_id, type, compare_condition, text) VALUES
((SELECT id from filter WHERE filter_name='first_filter'), 'Title', 'Starts with', 'Meow');

INSERT INTO title(filter_id, type, compare_condition, text) VALUES
((SELECT id from filter WHERE filter_name='second_filter'), 'Title', 'Ends with', 'Woof');
