USE master
GO
CREATE DATABASE QLNV
GO

USE QLNV
GO

CREATE TABLE EMPLOYEES
(
    EMPLOYEE_ID INT PRIMARY KEY IDENTITY,
    FULL_NAME NVARCHAR(50),
    ETHNICITY NVARCHAR(50),
    DATE_OF_BIRTH DATE,
    GENDER NVARCHAR(5),
    ADDRESS NVARCHAR(100),
    SALARY_LEVEL INT,
    SUPERVISOR_ID INT,
    DEPARTMENT_ID INT,
    EDUCATION_ID INT,
    POSITION_ID INT
);
GO

CREATE TABLE ACCOUNTS
(
	ACCOUNT_ID INT PRIMARY KEY IDENTITY,
	USERNAME VARCHAR(50),
	PASSWORD VARCHAR(50),
	FOREIGN KEY (ACCOUNT_ID) REFERENCES EMPLOYEES(EMPLOYEE_ID)
);
GO

CREATE TABLE DEPARTMENTS
(
    DEPARTMENT_ID INT PRIMARY KEY IDENTITY,
    DEPARTMENT_NAME NVARCHAR(100),
    HEAD_OF_DEPARTMENT VARCHAR(8), --head of department
    ROOM VARCHAR(8), --room
);
GO

CREATE TABLE SALARIES
(
    SALARY_ID INT PRIMARY KEY IDENTITY,
    BASE_SALARY FLOAT, --base salary
    SALARY_FACTOR INT, --salary factor
    ALLOWANCE_FACTOR INT --allowance factor
);
GO

CREATE TABLE POSITIONS
(
    POSITION_ID INT PRIMARY KEY IDENTITY,
    POSITION_NAME VARCHAR(20),
);
GO

CREATE TABLE EDUCATIONS
(
    EDUCATION_ID INT PRIMARY KEY IDENTITY,
    DEGREE_NAME VARCHAR(20), --degree name
    MAJOR VARCHAR(20) NULL --major
);
GO

CREATE TABLE SHIFTS
(
	SHIFT_ID INT PRIMARY KEY IDENTITY,
	SHIFT_NAME VARCHAR(10),
	SHIFT_START TIME,
	SHIFT_END TIME
);
GO

CREATE TABLE PATIENTROOMS
(
	ROOM_ID INT PRIMARY KEY IDENTITY,
	NAME VARCHAR(8),
	DEPARTMENT_ID INT
);
GO

CREATE TABLE WORK_SCHEDULES
(
    SCHEDULE_ID INT PRIMARY KEY IDENTITY,
    EMPLOYEE_ID INT,
    SHIFT_ID INT,
	ROOM_ID INT,
    WORK_DATE DATE
);
GO

CREATE TABLE ATTENDANCES
(
    ATTENDANCE_ID INT PRIMARY KEY IDENTITY,
    EMPLOYEE_ID INT,
    WORK_DATE DATE,
    PRESENT VARCHAR(7), --PRESENT: TRUE OR FALSE
    ARRIVAL_TIME TIME NULL, --arrival time
    DEPARTURE_TIME TIME NULL, --departure time
    LEAVE_TYPE VARCHAR(7) NULL --IF ABSENT THEN LEAVE OR NO LEAVE
);
GO


--LIÊN KẾT RÀNG BUỘC CHO NHÂN VIÊN
ALTER TABLE EMPLOYEES  
ADD CONSTRAINT FK_EMPLOYEE_EMPLOYEE 
FOREIGN KEY  (SUPERVISOR_ID)
REFERENCES EMPLOYEES(EMPLOYEE_ID)
GO

ALTER TABLE EMPLOYEES  
ADD CONSTRAINT FK_EMPLOYEE_SALARY
FOREIGN KEY  (SALARY_LEVEL)
REFERENCES SALARIES(SALARY_ID)
GO

ALTER TABLE EMPLOYEES  
ADD CONSTRAINT FK_EMPLOYEE_DEPARTMENT
FOREIGN KEY  (DEPARTMENT_ID)
REFERENCES DEPARTMENTS(DEPARTMENT_ID)
GO

ALTER TABLE EMPLOYEES  
ADD CONSTRAINT FK_EMPLOYEE_POSITION
FOREIGN KEY  (POSITION_ID)
REFERENCES POSITIONS(POSITION_ID)
GO

ALTER TABLE EMPLOYEES  
ADD CONSTRAINT FK_EMPLOYEE_EDUCATION
FOREIGN KEY  (EDUCATION_ID)
REFERENCES EDUCATIONS(EDUCATION_ID)
GO

--LIÊN KẾT RÀNG BUỘC CHO LỊCH LÀM VIỆC
ALTER TABLE WORK_SCHEDULES  
ADD CONSTRAINT FK_WORK_SCHEDULE_SHIFT
FOREIGN KEY  (SHIFT_ID)
REFERENCES SHIFTS(SHIFT_ID)
GO

ALTER TABLE WORK_SCHEDULES  
ADD CONSTRAINT FK_WORK_SCHEDULE_EMPLOYEES
FOREIGN KEY  (EMPLOYEE_ID)
REFERENCES EMPLOYEES(EMPLOYEE_ID)
GO

ALTER TABLE WORK_SCHEDULES  
ADD CONSTRAINT FK_WORK_SCHEDULE_PATIENTROOM
FOREIGN KEY  (ROOM_ID)
REFERENCES PATIENTROOMS(ROOM_ID)
GO

--LIÊN KẾT RÀNG BUỘC CHO PHÒNG BỆNH
ALTER TABLE PATIENTROOMS  
ADD CONSTRAINT FK_PATIENTROOM_DEPARTMENT
FOREIGN KEY  (DEPARTMENT_ID)
REFERENCES DEPARTMENTS(DEPARTMENT_ID)
GO

--LIEN KẾT RÀNG BUỘC CHO BẢNG CHUYÊN CẦN

ALTER TABLE ATTENDANCES  
ADD CONSTRAINT FK_ATTENDANCE_EMPLOYEE
FOREIGN KEY  (EMPLOYEE_ID)
REFERENCES EMPLOYEES(EMPLOYEE_ID)
GO

ALTER TABLE EMPLOYEES
ADD IMAGE VARCHAR(255) NULL
GO

ALTER TABLE EMPLOYEES
ALTER COLUMN  SUPERVISOR_ID INT NULL
GO

ALTER TABLE DEPARTMENTS
ALTER COLUMN  HEAD_OF_DEPARTMENT VARCHAR(50)
GO

ALTER TABLE EDUCATIONS
ALTER COLUMN  DEGREE_NAME VARCHAR(50)
GO

ALTER TABLE EDUCATIONS
ALTER COLUMN  MAJOR VARCHAR(50)
GO

ALTER TABLE PATIENTROOMS
ALTER COLUMN  NAME VARCHAR(50)
GO

ALTER TABLE SHIFTS
ALTER COLUMN  SHIFT_NAME VARCHAR(50)
GO

--NHẬP DỮ LIỆU

INSERT INTO DEPARTMENTS (DEPARTMENT_NAME, HEAD_OF_DEPARTMENT, ROOM)
VALUES 
    ('Cardiology', 'Dr. Johnson', 'Room 301'), --TIM MẠCH
    ('Orthopedics', 'Dr. Smith', 'Room 302'), --CHỈNH HÌNH
    ('Pediatrics', 'Dr. Davis', 'Room 303'), --NHI KHOA
    ('Neurology', 'Dr. White', 'Room 304'), --THÀN KINH HỌC
    ('Emergency Medicine', 'Dr. Turner', 'Room 305'),
    ('Obstetrics and Gynecology', 'Dr. Harris', 'Room 306'), --SẢN PHỤ
    ('Dermatology', 'Dr. Lee', 'Room 307'), --DA LIỄU
    ('Ophthalmology', 'Dr. Anderson', 'Room 308'), --NHÃN KHOA
    ('Radiology', 'Dr. Taylor', 'Room 309'), --PHÓNG XẠ
    ('Urology', 'Dr. Brown', 'Room 310'), --TIẾT NIỆU
    ('Psychiatry', 'Dr. Wilson', 'Room 311'), --TÂM THẦN HỌC
    ('Surgery', 'Dr. Miller', 'Room 312'); --PHẨU THUẬT
GO

INSERT INTO POSITIONS (POSITION_NAME)
VALUES 
   ('Doctor'),
    ('Nurse'),
    ('Surgeon'),
    ('Radiologist'), --BS X QUANG
    ('Pharmacist'), --DƯỢC SĨ
    ('Physiotherapist'), --BS VẬT LÝ TRỊ LIỆU
    ('Medical Technologist'), --KỸ THUẬT VIỂN Y TẾ
    ('Receptionist'), --LỄ TÂN
    ('Administrative Staff'), --QUẢN LÝ NHÂN VIÊN
    ('IT Specialist'), --CHUYÊN GUA CNTT
    ('Security Guard'), --BẢO VỆ
	('Laborer'); --LAO CÔNG
GO

INSERT INTO SALARIES (BASE_SALARY, SALARY_FACTOR, ALLOWANCE_FACTOR)
VALUES 
    (50000.00, 2, 1),
    (60000.00, 2, 1),
    (70000.00, 2, 1),
    (55000.00, 1.8, 0.8),
    (65000.00, 1.8, 0.8),
    (75000.00, 1.8, 0.8),
    (60000.00, 2.5, 1.2),
    (70000.00, 2.5, 1.2),
    (80000.00, 2.5, 1.2);
GO

INSERT INTO EDUCAEDUCATIONSTIONS (DEGREE_NAME, MAJOR)
VALUES 
    ('Bachelor of Science in Nursing', 'Nursing'),
    ('Master of Science in Medicine', 'Internal Medicine'),
    ('Doctor of Medicine', 'Surgery'),
    ('Bachelor of Science in Health Administration', 'Health Administration'),
    ('Master of Business Administration', 'Healthcare Management'),
    ('Doctor of Medicine', 'Cardiology'),
    ('Bachelor of Science in Computer Science', 'Health Informatics'),
    ('Master of Science in Computer Science', 'Medical Software Development'),
    ('Doctor of Medicine', 'Oncology'),
    ('Bachelor of Science in Information Technology', 'Health IT'),
    ('Master of Science in Database Administration', 'Medical Database Management'),
    ('Doctor of Medicine', 'Pediatrics'),
	('PRIMARY SCHOOL GRADUATION', NULL),
	('SECONDARY  SCHOOL GRADUATION', NULL),
	('HIGH SCHOOL GRADUATION', NULL);
GO

INSERT INTO PATIENTROOMS (NAME, DEPARTMENT_ID)
VALUES 
    ('Room A.101', 3),
    ('Room A.102', 3),
    ('Room A.103', 3),
    ('Room A.104', 3),
    ('Room A.201', 4),
    ('Room A.202', 4),
	('Room A.203', 4),
	('Room A.204', 4),
    ('Room A.301', 5),
    ('Room A.302', 5),
    ('Room A.401', 6),
    ('Room A.402', 6),
    ('Room B.101', 7),
    ('Room B.102', 7),
    ('Room B.201', 8),
    ('Room B.202', 8),
    ('Room B.301', 9),
    ('Room B.302', 9),
    ('Room C.101', 10),
    ('Room C.102', 10),
    ('Room C.201', 11),
    ('Room C.202', 11),
    ('Room D.101', 12),
    ('Room D.102', 12),
	('Room D.201', 13),
    ('Room D.202', 13),
    ('Room D.301', 14),
    ('Room D.302', 14);
GO


INSERT INTO SHIFTS (SHIFT_NAME, SHIFT_START, SHIFT_END)
VALUES 
    ('Morning Shift', '04:00', '12:00'),
    ('Afternoon Shift', '15:00', '23:00'),
    ('Night Shift', '23:00', '07:00'),
    ('Day Shift', '08:00', '16:00'),
    ('Evening Shift', '16:00', '00:00'),
    ('Late Night Shift', '23:00', '07:00'),
    ('Early Morning Shift', '05:00', '13:00'),
    ('Day Shift', '10:00', '18:00'),
    ('Night Shift', '20:00', '04:00'),
    ('Morning Shift', '07:30', '15:30'),
    ('Afternoon Shift', '15:30', '23:30'),
    ('Night Shift', '23:30', '07:30'),
    ('Day Shift', '08:30', '16:30'),
    ('Evening Shift', '16:30', '00:30'),
    ('Night Shift', '22:30', '06:30'),
    ('Morning Shift', '06:30', '14:30'),
    ('Day Shift', '09:30', '17:30'),
    ('Night Shift', '21:30', '05:30'),
    ('Morning Shift', '08:00', '16:00'),
    ('Afternoon Shift', '16:00', '00:00');
GO

CREATE PROC getAllAccount
AS
BEGIN
	SELECT * FROM ACCOUNTS
END


CREATE PROC getAccount
@pageNumber INT , @rowOfPage INT
AS
BEGIN
	SELECT *FROM ACCOUNTS
	ORDER BY ACCOUNT_ID
	OFFSET (@pageNumber -1)*@rowOfPage rows
	FETCH NEXT @rowOfPage ROWS ONLY
END
GO






CREATE PROC getAllSchedule
AS
BEGIN
	Select * from WORK_SCHEDULES
END
GO

