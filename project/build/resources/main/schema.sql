DROP TABLE IF EXISTS polls;
DROP TABLE IF EXISTS user_answers;


CREATE TABLE polls (
   question_id INT PRIMARY KEY AUTO_INCREMENT,
   question_title VARCHAR(100) NOT NULL DEFAULT '',
   question_first_answer VARCHAR(100) NOT NULL DEFAULT '',
   question_second_answer VARCHAR(100) NOT NULL DEFAULT '',
   question_third_answer VARCHAR(100) NOT NULL DEFAULT '',
   question_fourth_answer VARCHAR(100) NOT NULL DEFAULT ''
);

CREATE TABLE user_answers (
    id INT AUTO_INCREMENT,
    user_id INT NOT NULL,
    question_id INT NOT NULL,
    answer_option VARCHAR(100) NOT NULL,
    PRIMARY KEY(user_id,question_id),
    FOREIGN KEY(question_id)REFERENCES polls(question_id)
);
