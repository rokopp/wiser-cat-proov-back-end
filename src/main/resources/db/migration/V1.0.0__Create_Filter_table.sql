CREATE TABLE IF NOT EXISTS filter (
                                       id			    SERIAL      PRIMARY KEY,
                                       filter_name 		    VARCHAR(30) NOT NULL
    );

INSERT INTO filter (filter_name) VALUES('first_filter');
INSERT INTO filter (filter_name) VALUES('second_filter');
