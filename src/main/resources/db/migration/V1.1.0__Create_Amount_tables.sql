CREATE TABLE IF NOT EXISTS amount (
    id                  SERIAL PRIMARY KEY,
    type                VARCHAR(20) NOT NULL,
    filter_id           INT NOT NULL,
    compare_condition   VARCHAR(20) NOT NULL,
    number              INT NOT NULL,
    FOREIGN KEY (filter_id)
    REFERENCES filter (id) ON DELETE CASCADE
    );

INSERT INTO amount(filter_id, type, compare_condition, number) VALUES
((SELECT id from filter WHERE filter_name='first_filter'),'Amount', 'More', 6);

INSERT INTO amount(filter_id, type, compare_condition, number) VALUES
((SELECT id from filter WHERE filter_name='second_filter'),'Amount', 'Less', 2);
