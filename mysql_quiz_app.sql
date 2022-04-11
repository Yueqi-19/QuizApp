
-- ---------- ---------- ---------- ---------- ---------- 

/* Naming Convention for this Project */

-- Database, Table					lowercase					
-- Column							lower camelcase
-- Constraint						uppercase with underscore

-- ---------- ---------- ---------- ---------- ---------- 

/* Database */

DROP DATABASE IF EXISTS `quiz_app`;
CREATE SCHEMA `quiz_app` DEFAULT COLLATE utf8mb4_bin ;

USE `quiz_app`;

-- ---------- ---------- ---------- ---------- ---------- 

-- SHOW CREATE TABLE `user`;
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `username` varchar(45) NOT NULL,
   `password` varchar(45) NOT NULL,
   `first_name` varchar(45) NOT NULL,
   `last_name` varchar(45) NOT NULL,
   `email` varchar(45) NOT NULL,
   `is_admin` tinyint(1) NOT NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY `username_UNIQUE` (`username`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

INSERT INTO `user` (`username`, `password`, `first_name`, `last_name`, `email`, `is_admin`) VALUES
('userwasin', '123456', 'Wasin', 'Sanguansuk', 'wasin.sanguansuk@gmail.com', true),
('userbob', '111111', 'Bob', 'Smith', 'bob.smith@gmail.com', false),
('userlaura', '777777', 'Laura', 'Suk', 'laura.suk@gmail.com', false);

-- ---------- ---------- ---------- ---------- ---------- 

-- SHOW CREATE TABLE `category`;
DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `name` varchar(45) NOT NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY `name_UNIQUE` (`name`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

INSERT INTO `category` (`name`) VALUES
('Java'),
('Python'),
('SQL');

-- ---------- ---------- ---------- ---------- ---------- 

-- SHOW CREATE TABLE `question`;
DROP TABLE IF EXISTS `question`;

CREATE TABLE `question` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `content` varchar(300) NOT NULL,
   `category_id` int(11) NOT NULL,
   PRIMARY KEY (`id`),
   CONSTRAINT `FK_category_id_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

INSERT INTO `question` (`content`, `category_id`) VALUES
('Which of the following option leads to the portability and security of Java?', 1), 				-- 1
('Which of the following is not a Java features?', 1),
('The \u0021 article referred to as a', 1),
('_____ is used to find and fix bugs in the Java programs', 1),
('What is the return type of the hashCode() method in the Object class?', 1),
('Which of the following is a valid long literal?', 1),												-- 6
('What does the expression float a = 35 / 0 return?', 1),	
('Which of the following tool is used to generate API documentation in HTML format from doc comments in source code?', 1),	
('Which of the following creates a List of 3 visible items and multiple selections abled?', 1),	
('Which of the following for loop declaration is not valid?', 1),	
('In which process, a local variable has the same name as one of the instance variables?', 1),		-- 11
('Which method of the Class.class is used to determine the name of a class represented by the class object as a String?', 1),	
('Which of the following is true about the anonymous inner class?', 1),	
('Which package contains the Random class?', 1),	
('What do you mean by nameless objects?', 1),	

('What is the maximum possible length of an identifier?', 2),										-- 16
('Who developed the Python language?', 2),
('In which year was the Python language developed?', 2),
('In which language is Python written?', 2),
('Which one of the following is the correct extension of the Python file?', 2),
('In which year was the Python 3.0 version developed?', 2),											-- 21
('What do we use to define a block of code in Python language?', 2),	
('Which character is used in Python to make a single line comment?', 2),
('Which of the following statements is correct regarding the object-oriented programming concept in Python?', 2),
('What is the method inside the class in python language?', 2),
('Which of the following declarations is incorrect?', 2),											-- 26
('Why does the name of local variables start with an underscore discouraged?', 2),
('Which of the following is not a keyword in Python language?', 2),
('Which of the following statements is correct for variable names in Python language?', 2),
('Which of the following words cannot be a variable in python language?', 2),

('What is the full form of SQL?', 3),																-- 31
('Which of the following is not a valid SQL type?', 3),	
('Which of the following is not a DDL command?', 3),	
('Which of the following are TCL commands?', 3),	
('Which statement is used to delete all rows in a table without having the action logged?', 3),	
('SQL Views are also known as', 3),																	-- 36
('How many Primary keys can have in a table?', 3),	
('Which datatype can store unstructured data in a column?', 3),	
('Which of the following is not Constraint in SQL?', 3),	
('Which of the following is not a valid aggregate function?', 3),	
('Which data manipulation command is used to combines the records from one or more tables?', 3),	-- 41	
('Which operator is used to compare a value to a specified list of values?', 3),	
('What operator tests column for absence of data', 3),	
('In which of the following cases a DML statement is not executed?', 3),	
('If we have not specified ASC or DESC after a SQL ORDER BY clause, the following is used by default', 3);

-- ---------- ---------- ---------- ---------- ---------- 

-- SHOW CREATE TABLE `option`;
DROP TABLE IF EXISTS `option`;

CREATE TABLE `option` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `content` varchar(300) NOT NULL,
   `question_id` int(11) NOT NULL,
   `is_correct` tinyint(1) NOT NULL,
   PRIMARY KEY (`id`),
   CONSTRAINT `FK_question_id_1` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

INSERT INTO `option` (`content`, `question_id`, `is_correct`) VALUES
('Bytecode is executed by JVM', 1, true),
('The applet makes the Java code secure and portable', 1, false),
('Use of exception handling', 1, false),
('Dynamic binding between objects', 1, false),

('Dynamic', 2, false),
('Architecture Neutral', 2, false),
('Use of pointers', 2, true),
('Object-oriented', 2, false),

('Unicode escape sequence', 3, true),
('Octal escape', 3, false),
('Hexadecimal', 3, false),
('Line feed', 3, false),

('JVM', 4, false),
('JRE', 4, false),
('JDK', 4, false),
('JDB', 4, true),

('Object', 5, true),
('int', 5, false),
('long', 5, false),
('void', 5, false),

('ABH8097', 6, false),
('L990023', 6, false),
('904423', 6, false),
('0xnf029L', 6, true),

('0', 7, false),
('Not a Number', 7, false),
('Infinity', 7, true),
('Run time exception', 7, false),

('javap tool', 8, false),
('javaw command', 8, false),
('Javadoc tool', 8, true),
('javah command', 8, false),

('new List(false, 3)', 9, false),
('new List(3, true)', 9, true),
('new List(true, 3)', 9, false),
('new List(3, false)', 9, false),

('for ( int i = 99; i >= 0; i / 9 )', 10, true),
('for ( int i = 7; i <= 77; i += 7 )', 10, false),
('for ( int i = 20; i >= 2; - -i )', 10, false),
('for ( int i = 2; i <= 20; i = 2* i )', 10, false),

('Serialization', 11, false),
('Variable Shadowing', 11, true),
('Abstraction', 11, false),
('Multi-threading', 11, false),

('getClass()', 12, false),
('intern()', 12, false),
('getName()', 12, true),
('toString()', 12, false),

('It has only methods', 13, false),
('Objects cannot be created', 13, false),
('It has a fixed class name', 13, false),
('It has no class name', 13, true),

('java.util package', 14, true),
('java.lang package', 14, false),
('java.awt package', 14, false),
('java.io package', 14, false),

('An object created by using the new keyword.', 15, false),
('An object of a superclass created in the subclass.', 15, false),
('An object without having any name but having a reference.', 15, false),
('An object that has no reference.', 15, true),

('16', 16, false),
('32', 16, false),
('64', 16, false),
('None of these above', 16, true),

('Zim Den', 17, false),
('Guido van Rossum', 17, true),
('Niene Stom', 17, false),
('Wick van Rossum', 17, false),

('1995', 18, false),
('1972', 18, false),
('1981', 18, false),
('1989', 18, true),

('English', 19, false),
('PHP', 19, false),
('C', 19, true),
('All of the above', 19, false),

('.py', 20, true),
('.python', 20, false),
('.p', 20, false),
('None of these', 20, false),

('2008', 21, true),
('2000', 21, false),
('2010', 21, false),
('2005', 21, false),

('Key', 22, false),
('Brackets', 22, false),
('Indentation', 22, true),
('None of these', 22, false),

('/', 23, false),
('//', 23, false),
('#', 23, true),
('!', 23, false),

('Classes are real-world entities while objects are not real', 24, false),
('Objects are real-world entities while classes are not real', 24, true),
('Both objects and classes are real-world entities', 24, false),
('All of the above', 24, false),

('Object', 25, false),
('Function', 25, true),
('Attribute', 25, false),
('Argument', 25, false),

('_x = 2', 26, false),
('__x = 3', 26, false),
('__xyz__ = 5', 26, false),
('None of these', 26, true),

('To identify the variable', 27, false),
('It confuses the interpreter', 27, false),
('It indicates a private variable of a class', 27, true),
('None of these', 27, false),

('val', 28, true),
('raise', 28, false),
('try', 28, false),
('with', 28, false),

('All variable names must begin with an underscore.', 29, false),
('Unlimited length', 29, true),
('The variable name length is a maximum of 2.', 29, false),
('All of the above', 29, false),

('_val', 30, true),
('val', 30, false),
('try', 30, false),
('_try_', 30, false),

('Structured Query List', 31, false),
('Structure Query Language', 31, true),
('Sample Query Language', 31, false),
('None of these.', 31, false),

('FLOAT', 32, false),
('NUMERIC', 32, false),
('DECIMAL', 32, true),
('CHARACTER', 32, false),

('TRUNCATE', 33, false),
('ALTER', 33, false),
('CREATE', 33, false),
('UPDATE', 33, true),

('COMMIT and ROLLBACK', 34, true),
('UPDATE and TRUNCATE', 34, false),
('SELECT and INSERT', 34, false),
('GRANT and REVOKE', 34, false),

('DELETE', 35, false),
('REMOVE', 35, false),
('DROP', 35, false),
('TRUNCATE', 35, true),

('Simple tables', 36, false),
('Virtual tables', 36, true),
('Complex tables', 36, false),
('Actual Tables', 36, false),

('Only 1', 37, true),
('Only 2', 37, false),
('Depends on no of Columns', 37, false),
('Depends on DBA', 37, false),

('CHAR', 38, false),
('RAW', 38, true),
('NUMERIC', 38, false),
('VARCHAR', 38, false),

('Primary Key', 39, false),
('Not Null', 39, false),
('Check', 39, false),
('Union', 39, true),

('COUNT', 40, false),
('COMPUTE', 40, true),
('SUM', 40, false),
('MAX', 40, false),

('SELECT', 41, false),
('PROJECT', 41, false),
('JOIN', 41, true),
('PRODUCT', 41, false),

('ANY', 42, false),
('BETWEEN', 42, false),
('ALL', 42, false),
('IN', 42, true),

('NOT Operator', 43, false),
('Exists Operator', 43, false),
('IS NULL Operator', 43, true),
('None of the above', 43, false),

('When existing rows are modified.', 44, false),
('When a table is deleted.', 44, true),
('When some rows are deleted.', 44, false),
('All of the above', 44, false),

('DESC', 45, false),
('ASC', 45, true),
('There is no default value', 45, false),
('None of the mentioned', 45, false);

-- ---------- ---------- ---------- ---------- ---------- 

-- SHOW CREATE TABLE `quiz`;
DROP TABLE IF EXISTS `quiz`;

CREATE TABLE `quiz` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `name` varchar(100) NOT NULL,
   `category_id` int(11) NOT NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY `name_UNIQUE` (`name`),
   CONSTRAINT `FK_category_id_2` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

INSERT INTO `quiz` (`name`, `category_id`) VALUES
('userwasin-SQL-2022-03-14 06:05:39.8', 3);

-- ---------- ---------- ---------- ---------- ---------- 

-- SHOW CREATE TABLE `quiz_question`;
DROP TABLE IF EXISTS `quiz_question`;

CREATE TABLE `quiz_question` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `quiz_id` int(11) NOT NULL,
   `question_id` int(11) NOT NULL,
   `selected_option_id` int(11),
   PRIMARY KEY (`id`),
   UNIQUE KEY `quiz_id_question_id_UNIQUE` (`quiz_id`, `question_id`),
   CONSTRAINT `FK_quiz_id_1` FOREIGN KEY (`quiz_id`) REFERENCES `quiz` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
   CONSTRAINT `FK_question_id_2` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
   CONSTRAINT `FK_selected_option_id` FOREIGN KEY (`selected_option_id`) REFERENCES `option` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

INSERT INTO `quiz_question` (`quiz_id`, `question_id`, `selected_option_id`) VALUES
(1, 32, 128),
(1, 42, 168),
(1, 45, 179),
(1, 36, 143),
(1, 41, 162),
(1, 39, 154),
(1, 44, 174),
(1, 40, 158),
(1, 43, 170),
(1, 34, 135);

-- ---------- ---------- ---------- ---------- ---------- 

-- SHOW CREATE TABLE `submission`;
DROP TABLE IF EXISTS `submission`;

CREATE TABLE `submission` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `start_time` datetime NOT NULL,
   `end_time` datetime NOT NULL DEFAULT current_timestamp(),
   `score` int(2) NOT NULL CHECK (`score` >= 0 AND `score` <= 10),
   `user_id` int(11) NOT NULL,
   `quiz_id` int(11) NOT NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY `quiz_id_UNIQUE` (`quiz_id`),
   CONSTRAINT `FK_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
   CONSTRAINT `FK_quiz_id_2` FOREIGN KEY (`quiz_id`) REFERENCES `quiz` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

INSERT INTO `submission` (`start_time`, `end_time`, `score`, `user_id`, `quiz_id`) VALUES
('2022-03-14 06:05:40', '2022-03-14 06:06:23', 3, 1, 1);

-- ---------- ---------- ---------- ---------- ---------- 

-- SHOW CREATE TABLE `feedback`;
DROP TABLE IF EXISTS `feedback`;

CREATE TABLE `feedback` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `content` varchar(300) NOT NULL,
   `rating` int(1) NOT NULL CHECK (`rating` >= 1 AND `rating` <= 5), 		-- rating is 1-5
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

INSERT INTO `feedback` (`content`, `rating`) VALUES
('The quiz is very difficult. I like it, and will try again.', 4);

-- ---------- ---------- ---------- ---------- ---------- 

USE `quiz_app`;





























