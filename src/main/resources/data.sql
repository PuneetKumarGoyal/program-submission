DROP TABLE IF EXISTS TASKS;
DROP TABLE IF EXISTS SUBMISSIONS;

CREATE TABLE TASKS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  task_name VARCHAR(250) NOT NULL,
  description CLOB NOT NULL,
  input_parameters CLOB,
  output_parameters CLOB
);

CREATE TABLE SUBMISSIONS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR2(250) NOT NULL,
    task_name VARCHAR2(250) NOT NULL,
    solution CLOB
);

INSERT INTO tasks (task_name, description, input_parameters, output_parameters) VALUES
  ('Fibonnaci', 'Dangote', 'j,h', 'b,c'),
  ('tower of hanoi', 'Gates', 'a,f', 'e,f'),
  ('roulette', 'Alakija', '1,2', '3,4');

--INSERT INTO SUBMISSIONS (user_name, task_name, solution) VALUES
--    ('Puneet Goyal', 'Fibonacci', 'public static void main(String args[]){...}'),
--     ('Lars', 'Tower of hanoi', 'class Solution{...}'),
--      ('Steve Jobs', 'Card Solutions', 'class HouseOfCards(){...}')