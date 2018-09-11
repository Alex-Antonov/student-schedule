/*
DROP DATABASE IF EXISTS db_schedule;
DROP SCHEMA IF EXISTS db_schedule;
DROP USER IF EXISTS db_schedule;
DROP ROLE IF EXISTS db_scedule;

CREATE ROLE db_schedule WITH LOGIN PASSWORD 'db_schedule';
ALTER ROLE db_schedule SUPERUSER;
CREATE SCHEMA db_schedule AUTHORIZATION db_schedule;
CREATE DATABASE db_schedule OWNER db_schedule;
GRANT ALL PRIVILEGES ON DATABASE db_schedule TO db_schedule;
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO db_schedule;
*/

CREATE TABLE users (
  id BIGINT NOT NULL PRIMARY KEY,
  login VARCHAR(32) NOT NULL UNIQUE,
  password VARCHAR (256) NOT NULL
);

CREATE INDEX users_users_id_idx ON users(id);
CREATE INDEX users_login_idx ON users(login);

CREATE INDEX person_type_id_idx ON person_type(id);

CREATE TABLE person (
  id BIGINT NOT NULL PRIMARY KEY,
  user_id BIGINT,
  first_name VARCHAR(64) NOT NULL,
  second_name VARCHAR(64) NOT NULL,
  last_name VARCHAR(64),
  person_type VARCHAR(16),
  phone VARCHAR(24),
  email VARCHAR(128) NOT NULL,
  FOREIGN KEY (person_type) REFERENCES person_type(id),
  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE INDEX person_id_idx ON person(id);
CREATE INDEX person_first_name_idx ON person(first_name);
CREATE INDEX person_second_name_idx ON person(second_name);

CREATE TABLE tutor (
  id BIGINT NOT NULL PRIMARY KEY,
  degree VARCHAR(50) NOT NULL
);

CREATE INDEX tutor_id_idx ON tutor(id);

CREATE TABLE flow(
  id BIGINT NULL PRIMARY KEY,
  spec_name VARCHAR(128)
);

CREATE INDEX flow_id_idx ON flow(id);
CREATE INDEX flow_spec_name_idx ON flow(spec_name);

CREATE TABLE groups(
  id BIGINT NOT NULL PRIMARY KEY,
  start_year INTEGER NOT NULL,
  end_year INTEGER NOT NULL,
  flow_id INTEGER NOT NULL,
  name VARCHAR(16) NOT NULL,
  FOREIGN KEY (flow_id) REFERENCES flow(id)
);

CREATE INDEX groups_id_idx ON groups(id);
CREATE INDEX groups_name_idx ON groups(name);

CREATE TABLE student(
  id BIGINT NOT NULL PRIMARY KEY,
  group_id BIGINT NOT NULL,
  is_hostel_inh BOOLEAN NOT NULL,
  is_grantes BOOLEAN NOT NULL,
  FOREIGN KEY (group_id) REFERENCES groups(id)
);

CREATE INDEX student_id_idx ON student(id);

CREATE TABLE subject(
  id BIGINT NOT NULL PRIMARY KEY,
  name VARCHAR(64) NOT NULL
);

CREATE INDEX subject_id_idx ON subject(id);
CREATE INDEX subject_name_idx ON subject(name);

CREATE TABLE tutor_subject(
  tutor_id BIGINT NOT NULL,
  subject_id BIGINT NOT NULL,
  FOREIGN KEY (tutor_id) REFERENCES tutor(id),
  FOREIGN KEY (subject_id) REFERENCES subject(id)
);

CREATE INDEX tutor_subject_tutor_id_idx ON tutor_subject(tutor_id);
CREATE INDEX tutor_subject_subject_id_idx ON tutor_subject(subject_id);

CREATE TABLE class_time(
  id BIGINT NOT NULL PRIMARY KEY,
  start_time TIMESTAMP NOT NULL UNIQUE,
  end_time TIMESTAMP NOT NULL UNIQUE
);

CREATE INDEX class_time_id_idx ON class_time(id);

CREATE TABLE schedule (
  id BIGINT NOT NULL PRIMARY KEY,
  subject_id BIGINT,
  audience_number SMALLINT,
  tutor_id BIGINT,
  day SMALLINT NOT NULL,
  group_id BIGINT,
  flow_id BIGINT,
  class_time_id BIGINT NOT NULL,
  FOREIGN KEY (group_id) REFERENCES groups(id),
  FOREIGN KEY (flow_id) REFERENCES flow(id),
  FOREIGN KEY (tutor_id) REFERENCES tutor(id),
  FOREIGN KEY (subject_id) REFERENCES subject(id),
  FOREIGN KEY (class_time_id) REFERENCES class_time(id),
  CHECK (group_id IS NOT NULL OR flow_id IS NOT NULL)
);
