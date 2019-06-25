SET MODE PostgreSQL;
CREATE TABLE IF NOT EXISTS heroSquadDetails(
    id int PRIMARY KEY auto_increment,
    strength varchar,
    weakness varchar,
    hero_name varchar,
    age int,
    squad_name varchar,
    cause_value int
);