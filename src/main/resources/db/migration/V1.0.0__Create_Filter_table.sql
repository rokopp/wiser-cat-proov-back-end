CREATE TABLE IF NOT EXISTS filter (
                                    id			        SERIAL      PRIMARY KEY,
                                    filter_name 		VARCHAR(30) NOT NULL,
                                    selected_filter     INT
    );

INSERT INTO filter (filter_name, selected_filter) VALUES('first_filter', 1);
INSERT INTO filter (filter_name, selected_filter) VALUES('second_filter', 2);
