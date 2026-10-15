-- Gym Member Management System database
CREATE DATABASE IF NOT EXISTS gymproject CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE gymproject;

CREATE TABLE IF NOT EXISTS auth (
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(80) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS members (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(120) NOT NULL,
  age INT NOT NULL,
  height DOUBLE NOT NULL,
  weight DOUBLE NOT NULL,
  doj DATE NOT NULL,
  doe DATE NOT NULL
);

-- Demo account for local evaluation only. Change this password before any real use.
INSERT INTO auth (username, password)
SELECT 'admin', 'admin123'
WHERE NOT EXISTS (SELECT 1 FROM auth WHERE username = 'admin');
