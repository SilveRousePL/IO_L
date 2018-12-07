CREATE TABLE IF NOT EXISTS reservation (
                                         id serial PRIMARY KEY,
                                         start_date TIMESTAMP,
                                         end_date TIMESTAMP,
                                         client_id integer,
                                         room_id integer
);
CREATE TABLE IF NOT EXISTS room (
                                  id serial PRIMARY KEY,
                                  room_number integer,
                                  amount_of_persons integer,
                                  cost varchar(30),
                                  status integer,
                                  lock boolean
);
CREATE TABLE IF NOT EXISTS client (
                                    id serial PRIMARY KEY,
                                    first_name varchar(30),
                                    last_name varchar(30),
                                    pesel varchar(30),
                                    phone_number varchar(30)
);