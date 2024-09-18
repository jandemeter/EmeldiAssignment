CREATE TABLE IF NOT EXISTS team (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
    );

CREATE TABLE IF NOT EXISTS employee (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    nick VARCHAR(255) NOT NULL,
    team_id INT,
    FOREIGN KEY (team_id) REFERENCES team(id)
    );

CREATE TABLE IF NOT EXISTS vacation (
    id SERIAL PRIMARY KEY,
    date_duration BIGINT NOT NULL,
    create_date DATE NOT NULL,
    approved BOOLEAN NOT NULL,
    from_date DATE NOT NULL,
    from_daypart SMALLINT,
    to_date DATE NOT NULL,
    to_daypart SMALLINT,
    created_by INT,
    approved_by INT,
    FOREIGN KEY (created_by) REFERENCES employee(id),
    FOREIGN KEY (approved_by) REFERENCES employee(id)
    );

INSERT INTO team (id, name)
VALUES
    (1, 'Testing Team');

INSERT INTO employee (id, name, nick, team_id)
VALUES
    (1, 'Michal Makas', 'mmakas', 1),
    (2, 'Michal Hruby', 'mh', 1);

INSERT INTO vacation (id, date_duration, create_date, approved, from_date, from_daypart, to_date, to_daypart, created_by, approved_by)
VALUES
    (1, 4, '2016-08-14', TRUE, '2016-09-05', 0, '2016-09-08', 0, 1, 2),
    (2, 1, '2016-12-05', TRUE, '2016-12-07', 0, '2016-12-07', 0, 1, 2),
    (3, 2, '2016-10-31', TRUE, '2016-12-22', 0, '2016-12-23', 0, 1, 2),
    (4, 4, '2016-10-31', TRUE, '2016-12-27', 0, '2016-12-30', 0, 1, 2),
    (5, 2, '2016-10-31', TRUE, '2017-01-02', 0, '2017-01-03', 0, 1, 2),
    (6, 0.5, '2017-02-07', TRUE, '2017-02-24', 2, '2017-02-25', 1, 1, 2);
