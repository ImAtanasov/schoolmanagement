CREATE TABLE _group (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE course (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    type VARCHAR(255)
);

CREATE TABLE student (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    age INT,
    group_id BIGINT,
    FOREIGN KEY (group_id) REFERENCES _group(id)
);

CREATE TABLE teacher (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    age INT,
    group_id BIGINT,
    FOREIGN KEY (group_id) REFERENCES _group(id)
);

CREATE TABLE student_course (
    student_id BIGINT,
    course_id BIGINT,
    PRIMARY KEY (student_id, course_id),
    FOREIGN KEY (student_id) REFERENCES student(id),
    FOREIGN KEY (course_id) REFERENCES course(id)
);

CREATE TABLE teacher_course (
    teacher_id BIGINT,
    course_id BIGINT,
    PRIMARY KEY (teacher_id, course_id),
    FOREIGN KEY (teacher_id) REFERENCES teacher(id),
    FOREIGN KEY (course_id) REFERENCES course(id)
);
