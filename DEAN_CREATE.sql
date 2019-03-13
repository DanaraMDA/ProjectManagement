create table STUDY_GROUP(id	int, name	nchar(10), primary key (id) );
create table STUDENT(id     int, surname       nvarchar(50), name   nvarchar(50), second_name   nvarchar(50), study_group_id       int, primary key (id), foreign key (study_group_id) references STUDY_GROUP(id) );
create table SUBJECT(id     int, name   nvarchar(50), short_name    nvarchar(50), primary key (id) );
create table EXAM_TYPE(id     int, type   nvarchar(50), primary key (id) );
create table STUDY_PLAN(id     int, subject_id    int, exam_type_id  int, primary key (id), foreign key (subject_id) references SUBJECT(id), foreign key (exam_type_id) references EXAM_TYPE(id) );
create table MARK(id     int, name nvarchar(50), value  nvarchar(50), primary key (id) );
create table JOURNAL( id     int, student_id    int, study_plan_id int, in_time       bit, count  int,
mark_id       int, primary key (id), foreign key (student_id) references STUDENT(id), foreign key (study_plan_id) references STUDY_PLAN(id), foreign key (mark_id) references MARK(id) );