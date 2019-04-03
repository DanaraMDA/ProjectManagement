DROP TABLE IF EXISTS study_group;
CREATE TABLE study_group(id INT PRIMARY KEY NOT NULL, name TEXT NOT NULL);

DROP TABLE IF EXISTS student;
CREATE TABLE student(id INT PRIMARY KEY NOT NULL, surname TEXT NOT NULL, name TEXT NOT NULL, second_name TEXT NOT NULL, study_group_id INT NOT NULL, foreign key (study_group_id) references study_group(id));

DROP TABLE IF EXISTS student_local;
CREATE TABLE student_local(id INT PRIMARY KEY NOT NULL, surname TEXT NOT NULL, name TEXT NOT NULL, second_name TEXT NOT NULL, study_group_id INT NOT NULL, foreign key (study_group_id) references study_group(id));

DROP TABLE IF EXISTS subject;
CREATE TABLE subject(id INT PRIMARY KEY, name TEXT NOT NULL, short_name TEXT NOT NULL);

DROP TABLE IF EXISTS exam_type;
CREATE TABLE exam_type(id INT PRIMARY KEY, type TEXT NOT NULL);

DROP TABLE IF EXISTS study_plan;
CREATE TABLE study_plan(id INT PRIMARY KEY, subject_id INT NOT NULL, exam_type_id INT NOT NULL, foreign key (subject_id) references subject(id), foreign key (exam_type_id) references exam_type(id));

DROP TABLE IF EXISTS mark;
CREATE TABLE mark(id INT PRIMARY KEY, name TEXT NOT NULL, value TEXT NOT NULL);

DROP TABLE IF EXISTS journal;
CREATE TABLE journal(id INT PRIMARY KEY, student_id INT NOT NULL, study_plan_id INT NOT NULL, in_time BOOLEAN NOT NULL, count INT NOT NULL, mark_id INT NOT NULL, foreign key (student_id) references student(id), foreign key (study_plan_id) references study_plan(id), foreign key (mark_id) references mark(id));

INSERT INTO study_group VALUES (2, 'ИВБО-02-15-2');

INSERT INTO student_local VALUES (132, 'Борзых', 'Никита', 'Юрьевич', 2),
                           (148, 'Манджиева', 'Данара', 'Альбертовна', 2);

INSERT INTO subject VALUES (1, 'Проектирование информационных систем', 'ПрИС'),
                           (2, 'Системы искусственного интеллекта', 'СИИ'),
                           (3, 'Программная инженерия', 'ПИ'),
                           (4, 'Национальная система информационной безопасности', 'НСИБ'),
                           (5, 'Системный анализ', 'СисАнал'),
                           (6, 'Распределенные базы данных', 'РБД'),
                           (7, 'Системное программное обеспечение', 'СПО');

INSERT INTO exam_type VALUES (1, 'Экзамен'),
                             (2, 'Зачет'),
                             (3, 'Зачет с оценкой'),
                             (4, 'Курсовая');

INSERT INTO study_plan VALUES (1, 1, 1),
                              (2, 1, 4),
                              (3, 2, 1),
                              (4, 3, 1),
                              (5, 4, 2),
                              (6, 5, 1),
                              (7, 6, 2),
                              (8, 7, 1);

INSERT INTO mark VALUES (1, 'Отлично', 5),
                        (2, 'Хорошо', 4),
                        (3, 'Удовлетворительно', 3),
                        (4, 'Неудовлетворительно', 2);
