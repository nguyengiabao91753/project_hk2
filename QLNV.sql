USE master
GO

DROP DATABASE IF EXISTS QLNV
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
    GENDER NVARCHAR(10),
    ADDRESS NVARCHAR(100),
    SALARY_LEVEL INT,
    SUPERVISOR_ID INT,
    DEPARTMENT_ID INT,
    EDUCATION_ID INT,
    POSITION_ID INT,
	IMAGE VARCHAR(255) NULL,
	LEVEL VARCHAR(50) NOT NULL
);
GO

CREATE TABLE ACCOUNTS
(
	ACCOUNT_ID INT PRIMARY KEY IDENTITY,
	USERNAME VARCHAR(50),
	PASSWORD VARCHAR(50),
	STATUS INT NOT NULL,
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
    ALLOWANCE_FACTOR FLOAT --allowance factor
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
    WORKSCHEDULE_ID INT,
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
ADD CONSTRAINT FK_ATTENDANCE_SCHEDULE
FOREIGN KEY  (WORKSCHEDULE_ID)
REFERENCES WORK_SCHEDULES(SCHEDULE_ID)
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

ALTER TABLE DEPARTMENTS
ALTER COLUMN ROOM VARCHAR(20); 
go

--THAY DỔI CỘT ROOM
ALTER TABLE DEPARTMENTS
ALTER COLUMN ROOM VARCHAR(50);
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

INSERT INTO EDUCATIONS(DEGREE_NAME, MAJOR)
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
    ('Room D.102', 12);
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
    ('Night Shift', '20:00', '04:00')
GO



--DBCC CHECKIDENT ('EMPLOYEES', RESEED, 1);


 INSERT INTO EMPLOYEES (FULL_NAME, ETHNICITY, DATE_OF_BIRTH, GENDER, ADDRESS, SALARY_LEVEL, SUPERVISOR_ID, DEPARTMENT_ID, EDUCATION_ID, POSITION_ID, IMAGE, LEVEL)
VALUES ('Boss', 'Asian', '1990-05-15', 'Male', '123 Main Street', 1, NuLL, 1, 1, 1, null, 'Admin');
GO

INSERT INTO ACCOUNTS (USERNAME, PASSWORD, STATUS)
VALUES ('Admin', 'Admin12345', 1);
GO


--DBCC CHECKIDENT ('ACCOUNTS', RESEED, 9);

--DBCC CHECKIDENT ('ACCOUNTS', RESEED, 10);
--INSERT INTO EMPLOYEES (FULL_NAME, ETHNICITY, DATE_OF_BIRTH, GENDER, ADDRESS, SALARY_LEVEL, SUPERVISOR_ID, DEPARTMENT_ID, EDUCATION_ID, POSITION_ID, IMAGE, LEVEL)
--VALUES ('John Doe', 'Asian', '1990-05-15', 'Male', '123 Main Street', 3, 4, 2, 2, 2, 'john_doe.jpg', 'Admin');


--INSERT INTO EMPLOYEES (FULL_NAME, ETHNICITY, DATE_OF_BIRTH, GENDER, ADDRESS, SALARY_LEVEL, SUPERVISOR_ID, DEPARTMENT_ID, EDUCATION_ID, POSITION_ID, IMAGE, LEVEL)
--VALUES ('Jane Smith', 'Caucasian', '1985-08-22', 'Female', '456 Oak Avenue', 2, 4, 3, 3, 1, 'jane_smith.jpg', 'Admin');

--INSERT INTO ACCOUNTS (USERNAME, PASSWORD, STATUS)
--VALUES ('john_doe_username', 'password123', 1);

--INSERT INTO ACCOUNTS (USERNAME, PASSWORD, STATUS)
--VALUES ('jane_smith_username', 'securepass', 1);


--INSERT INTO WORK_SCHEDULES(EMPLOYEE_ID, SHIFT_ID, ROOM_ID, WORK_DATE)
--VALUES
--	(7,1,1,'2024-01-07'),
--	(7,2,2,'2024-01-06');
--GO 

--INSERT INTO ATTENDANCES(WORKSCHEDULE_ID,PRESENT,ARRIVAL_TIME , DEPARTURE_TIME ,LEAVE_TYPE)
--VALUES
--(1,'True', '04:00', '12:00',NULL)
--GO





--EMPLOYEE
CREATE PROC getAllEmployee
AS
BEGIN
	SELECT * FROM EMPLOYEES
END
GO

CREATE PROC getEmployee
@pageNumber INT , @rowOfPage INT
AS
BEGIN
	SELECT *FROM EMPLOYEES
	ORDER BY EMPLOYEE_ID
	OFFSET (@pageNumber -1)*@rowOfPage rows
	FETCH NEXT @rowOfPage ROWS ONLY
END
GO

CREATE PROC countEmployee
AS
BEGIN
	SELECT COUNT(EMPLOYEE_ID) TOTAL FROM EMPLOYEES
END
GO

CREATE PROC updateEmployee
	@fullname NVARCHAR(50), 
	@ethnicity NVARCHAR(50) ,
	@dateofbirth DATE ,
	@gender NVARCHAR(10) , 
	@address NVARCHAR(100),
	@salarylevel INT , 
	@supervisorid INT ,
	@departmentid INT , 
	@educationid INT , 
	@positionid INT ,
	@image VARCHAR(255) ,
	@level VARCHAR(50) ,
	@id INT
AS
BEGIN
	UPDATE EMPLOYEES
	SET FULL_NAME = @fullname, ETHNICITY = @ethnicity , DATE_OF_BIRTH = @dateofbirth , GENDER = @gender , ADDRESS = @address , SALARY_LEVEL = @salarylevel , SUPERVISOR_ID = @supervisorid , DEPARTMENT_ID = @departmentid , EDUCATION_ID = @educationid , POSITION_ID =@positionid , IMAGE = @image , LEVEL = @level
	WHERE EMPLOYEE_ID = @id
END
GO

CREATE PROC insertEmployee
@fullname NVARCHAR(50), @ethnicity NVARCHAR(50), @date_of_birth DATE, @gender NVARCHAR(10),@address NVARCHAR(100),@salary_level INT,@supervisor_id INT,@department_id INT,@education_id INT,@position_id INT,@picture VARCHAR(255),@level VARCHAR(50)
AS
BEGIN
	INSERT INTO EMPLOYEES(FULL_NAME,ETHNICITY,DATE_OF_BIRTH,GENDER,ADDRESS,SALARY_LEVEL,SUPERVISOR_ID,DEPARTMENT_ID,EDUCATION_ID,POSITION_ID,IMAGE,LEVEL)
	VALUES(@fullname, @ethnicity, @date_of_birth, @gender,@address,@salary_level,@supervisor_id,@department_id,@education_id,@position_id,@picture,@level)
END
GO

CREATE PROC deleteEmployee
@id int
AS
BEGIN
	DELETE FROM EMPLOYEES
	WHERE EMPLOYEE_ID = @id
END
GO




--SCHEDULE

CREATE PROC getAllSchedule
AS
BEGIN
	Select * from WORK_SCHEDULES
END
GO

CREATE PROC getAllEducation
AS
BEGIN
	Select * from EDUCATIONS
END
GO

CREATE PROC getAllRoom
AS
BEGIN
	SELECT * FROM PATIENTROOMS
END
GO

CREATE PROC getAllShift
AS
BEGIN
	SELECT * FROM SHIFTS
END
GO


CREATE PROC updateSchedule
    @SCHEDULE_ID INT,
    @EMPLOYEE_ID INT,
    @SHIFT_ID INT,
	@ROOM_ID INT,
    @WORK_DATE DATE
AS
BEGIN
	UPDATE WORK_SCHEDULES
	SET EMPLOYEE_ID = @EMPLOYEE_ID, SHIFT_ID = @SHIFT_ID, ROOM_ID = @ROOM_ID, WORK_DATE = @WORK_DATE
	WHERE SCHEDULE_ID = @SCHEDULE_ID
END
GO 

--Job_Positions


CREATE PROC getAllSalary
AS
BEGIN
	SELECT * FROM SALARIES
END
GO



CREATE PROC getAllPosition
AS
BEGIN
	SELECT * FROM POSITIONS
END
GO






CREATE PROC insertSchedule
	@EMPLOYEE_ID INT,
    @SHIFT_ID INT,
	@ROOM_ID INT,
    @WORK_DATE DATE
AS
BEGIN
	INSERT INTO WORK_SCHEDULES (EMPLOYEE_ID, SHIFT_ID, ROOM_ID, WORK_DATE)
	VALUES
		(@EMPLOYEE_ID, @SHIFT_ID,@ROOM_ID,@WORK_DATE)
END
GO


CREATE PROC deleteSchedule
@id int
AS
BEGIN
	DELETE FROM WORK_SCHEDULES
	WHERE SCHEDULE_ID = @id
END
GO

CREATE PROC getSchedule
@pagenumber INT, @rowOfPage INT
AS
BEGIN
	SELECT *
	FROM WORK_SCHEDULES
	ORDER BY SCHEDULE_ID
	OFFSET (@pagenumber -1)* @rowOfPage rows
	FETCH NEXT @rowOfPage ROWS ONLY
END
GO

CREATE PROC COUNTWORK
AS
BEGIN
	SELECT COUNT(SCHEDULE_ID) total
	FROM WORK_SCHEDULES
End
GO

--position
--LẤY từ dòng nào đến , và lấy bao nhiêu dòng .

CREATE PROC getPosition
@pageNumber int , @rowsOfPage int 
AS
BEGIN
	SELECT * FROM POSITIONS
	ORDER BY POSITION_ID
	OFFSET (@pageNumber - 1)*@rowsOfPage ROWS
	FETCH NEXT @rowsOfPage ROWS ONLY
END
GO

CREATE PROC getDepartments
@pageNumber int , @rowsOfPage int 
AS
BEGIN
	SELECT * FROM DEPARTMENTS
	ORDER BY DEPARTMENT_ID
	OFFSET (@pageNumber - 1)*@rowsOfPage ROWS
	FETCH NEXT @rowsOfPage ROWS ONLY
END
GO

CREATE PROC insertDep
@department_id int , @department_name VARCHAR(100) , @head_of_department VARCHAR(20),@room VARCHAR(20)
AS
BEGIN
	INSERT INTO DEPARTMENTS(DEPARTMENT_ID,DEPARTMENT_NAME,HEAD_OF_DEPARTMENT,ROOM)
	VALUES(@department_id,@department_name,@head_of_department,@room)
END
GO
ALTER PROCEDURE insertDep
    @department_name VARCHAR(100),
    @head_of_department VARCHAR(20),
    @room VARCHAR(20)
AS
BEGIN
    -- Thay đổi câu lệnh INSERT
    INSERT INTO DEPARTMENTS(DEPARTMENT_NAME, HEAD_OF_DEPARTMENT, ROOM)
    VALUES(@department_name, @head_of_department, @room)
END

--THAY DỔI CỘT ROOM
ALTER TABLE DEPARTMENTS
ALTER COLUMN ROOM VARCHAR(50);
GO


CREATE PROC getAllAtt
AS
BEGIN
	Select * from ATTENDANCES
END
GO

CREATE PROC getAtt
@pagenumber INT, @rowOfPage INT
AS
BEGIN
	SELECT *
	FROM ATTENDANCES
	ORDER BY ATTENDANCE_ID DESC
	OFFSET (@pagenumber -1)* @rowOfPage rows
	FETCH NEXT @rowOfPage ROWS ONLY
END
GO

CREATE PROC countAtt 
AS
BEGIN
	SELECT COUNT(ATTENDANCE_ID) TOTAL FROM ATTENDANCES
END
GO





--ACCOUNT
CREATE PROC getAllAccount
AS
BEGIN
	SELECT * FROM ACCOUNTS
END
GO

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

CREATE PROC countAccount
AS
BEGIN
	SELECT COUNT(ACCOUNT_ID) TOTAL FROM ACCOUNTS
END
GO

CREATE PROC updateAccount
@username VARCHAR(50),@password VARCHAR(50),@id INT
AS
BEGIN
	UPDATE ACCOUNTS
	SET USERNAME = @username , PASSWORD = @password
	WHERE ACCOUNT_ID = @id
END
GO

CREATE PROC insertAccount
@username VARCHAR(50) , @password VARCHAR(50),@status int
AS
BEGIN
	INSERT INTO ACCOUNTS(USERNAME,PASSWORD, STATUS)
	VALUES(@username,@password,@status)
END
GO

CREATE PROCEDURE blockAccount
@id INT
AS
BEGIN
    UPDATE ACCOUNTS
    SET Status = 0
    WHERE ACCOUNT_ID = @id;
END
go

CREATE PROC deleteEmployeeAndAccount
@employeeId INT,
@accountId INT
AS
BEGIN
	 BEGIN TRANSACTION;
    DELETE FROM EMPLOYEES
    WHERE EMPLOYEE_ID = @employeeId;
    DELETE FROM ACCOUNTS
    WHERE ACCOUNT_ID = @accountId;
	 COMMIT;
END
GO

CREATE PROCEDURE deleteAccountAndEmployee
    @accountId INT,
    @employeeId INT
AS
BEGIN
    BEGIN TRANSACTION;
    DELETE FROM ACCOUNTS WHERE ACCOUNT_ID = @accountId;
    DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID = @employeeId;
    COMMIT;
END;
GO


CREATE PROC CheckUsernameExists
    @username VARCHAR(255)
AS
BEGIN
    SET NOCOUNT ON;

    IF EXISTS (SELECT 1 FROM ACCOUNTS WHERE USERNAME = @username)
        SELECT 1 AS UsernameExists;
    ELSE
        SELECT 0 AS UsernameExists;
END
GO


--Login Admin
CREATE PROC LoginAdmin
    @username VARCHAR(50),
    @password VARCHAR(50)
AS
BEGIN
    SET NOCOUNT ON;

    DECLARE @status INT, @level VARCHAR(50);
    
    SELECT @status = STATUS
    FROM ACCOUNTS
    WHERE USERNAME = @username AND PASSWORD = @password;

    IF @status = 1
    BEGIN
        SELECT @level = LEVEL
        FROM EMPLOYEES E
        JOIN ACCOUNTS A ON E.EMPLOYEE_ID = A.ACCOUNT_ID
        WHERE A.USERNAME = @username;

        IF @level = 'Admin'
            SELECT 'Login successful.' AS message;
        ELSE
            SELECT 'Your account is not authorized as an Admin. Please choose another account.' AS message;
    END
    ELSE IF @status = 0
		SELECT 'Your account has been locked, please choose another account.' AS message;
    ELSE
        SELECT 'Invalid username or password.' AS message;
END
GO



--Login User
CREATE PROCEDURE loginUser
	@username VARCHAR(50),
	@password VARCHAR(50)
AS
BEGIN
	SET NOCOUNT ON;
	
	DECLARE @status INT , @level VARCHAR(50);
	SELECT @status = STATUS
	FROM ACCOUNTS
	WHERE @username = USERNAME AND @password = PASSWORD;

	IF @status = 1
	BEGIN
		SELECT @level = LEVEL
		FROM EMPLOYEES E
		JOIN ACCOUNTS A ON E.EMPLOYEE_ID = A.ACCOUNT_ID
		WHERE A.USERNAME = @username
	
		IF @level = 'Admin' OR @level = 'User'
			SELECT 'Login successful.' AS message
	END
	ELSE IF @status = 0
		SELECT 'Your account has been locked, please choose another account.' AS message;
    ELSE
        SELECT 'Invalid username or password.' AS message
END
GO

--Get ID User
CREATE PROCEDURE GetId
    @username VARCHAR(50)
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @employeeId INT;

    -- Lấy employee_id từ bảng ACCOUNTS dựa trên username
    SELECT @employeeId = E.EMPLOYEE_ID
    FROM EMPLOYEES E
    JOIN ACCOUNTS A ON E.EMPLOYEE_ID = A.ACCOUNT_ID
    WHERE A.USERNAME = @username;

    -- Trả về employee_id
    SELECT @employeeId AS EMPLOYEE_ID;
END
GO

--Get User by ID
CREATE PROCEDURE GetUserById
    @userId INT
AS
BEGIN
    SET NOCOUNT ON;
    
    DECLARE @employeeId INT , @fullname NVARCHAR(50), @ethnicity NVARCHAR(50), @date_of_birth DATE, @gender NVARCHAR(10),@address NVARCHAR(100),@salary_level INT,@supervisor_id INT,@department_id INT,@education_id INT,@position_id INT,@picture VARCHAR(255),@level VARCHAR(50);

    SELECT @employeeId = E.EMPLOYEE_ID,
           @fullname = E.FULL_NAME,
           @ethnicity = E.ETHNICITY,
           @date_of_birth = E.DATE_OF_BIRTH,
           @gender = E.GENDER,
           @address = E.ADDRESS,
           @salary_level = E.SALARY_LEVEL,
           @supervisor_id = E.SUPERVISOR_ID,
           @department_id = E.DEPARTMENT_ID,
           @education_id = E.EDUCATION_ID,
           @position_id = E.POSITION_ID,
           @picture = E.IMAGE,
           @level = E.LEVEL
    FROM EMPLOYEES E
    JOIN ACCOUNTS A ON E.EMPLOYEE_ID = A.ACCOUNT_ID
    WHERE E.EMPLOYEE_ID = @userId;

    SELECT @employeeId AS EMPLOYEE_ID,
           @fullname AS FULL_NAME,
           @ethnicity AS ETHNICITY,
           @date_of_birth AS DATE_OF_BIRTH,
           @gender AS GENDER,
           @address AS ADDRESS,
           @salary_level AS SALARY_LEVEL,
           @supervisor_id AS SUPERVISOR_ID,
           @department_id AS DEPARTMENT_ID,
           @education_id AS EDUCATION_ID,
           @position_id AS POSITION_ID,
           @picture AS PICTURE,
           @level AS LEVEL;
END
GO












--SCHEDULE

CREATE PROC getpersonschedule
@EMPLOYEE_ID INT
AS
BEGIN
	SELECT * FROM WORK_SCHEDULES
	WHERE EMPLOYEE_ID = @EMPLOYEE_ID
	ORDER BY WORK_DATE DESC
END
GO

--ATTEN-PERSONAL
CREATE PROC getAttpersonal
@a INT
AS
BEGIN
	SELECT * FROM ATTENDANCES
	WHERE WORKSCHEDULE_ID IN (
			SELECT SCHEDULE_ID
			FROM WORK_SCHEDULES
			WHERE EMPLOYEE_ID = @a
		)
	ORDER BY ATTENDANCE_ID DESC
END
GO


--TRIGGER
-- Tạo stored procedure
CREATE PROCEDURE DailyInsertAtt
AS
BEGIN
    DECLARE @target_date DATE;
    DECLARE @work_id_to_insert INT;

    -- Lấy ngày hiện tại
    SET @target_date = CAST(GETDATE() AS DATE);

    -- Tìm id của dòng dữ liệu trong bảng work trùng với ngày hiện tại
    SELECT TOP 1 @work_id_to_insert = SCHEDULE_ID
    FROM WORK_SCHEDULES
    WHERE CONVERT(DATE, WORK_DATE) = @target_date
    ORDER BY WORK_DATE;

    -- Kiểm tra nếu có dữ liệu
    IF @work_id_to_insert IS NOT NULL
    BEGIN
        -- Thực hiện lệnh insert vào bảng emp với work_id tương ứng
        INSERT INTO ATTENDANCES ( WORKSCHEDULE_ID,PRESENT, ARRIVAL_TIME, DEPARTURE_TIME, LEAVE_TYPE)
        VALUES (@work_id_to_insert, 'False', NULL, NULL, 'WP');
    END
END
GO

--EXEC DailyInsertAtt;

--SELECT* FROM ATTENDANCES



--checkin
CREATE PROC checkin
@a INT,
@Time Time
AS
BEGIN
	UPDATE ATTENDANCES
	SET ARRIVAL_TIME = @Time,
	PRESENT = 'True', LEAVE_TYPE=NULL
	WHERE ATTENDANCE_ID = @a
END
GO

CREATE PROC checkout
@a INT,
@Time Time
AS
BEGIN
	UPDATE ATTENDANCES
	SET DEPARTURE_TIME = @Time
	WHERE ATTENDANCE_ID = @a
END
GO

CREATE PROC dayOff
@a INT
AS
BEGIN
	UPDATE ATTENDANCES
	SET LEAVE_TYPE = 'P'
	WHERE ATTENDANCE_ID = @a
END
GO



Create PROC insertAtt
@work_id INT
AS
BEGIN
	 INSERT INTO ATTENDANCES ( WORKSCHEDULE_ID,PRESENT, ARRIVAL_TIME, DEPARTURE_TIME, LEAVE_TYPE)
     VALUES (@work_id, 'False', NULL, NULL, 'WP');
END
GO

--TRIGGER
CREATE TRIGGER AutoinsertAtt
ON WORK_SCHEDULES
AFTER INSERT
AS
BEGIN
    -- Insert new records into ATTENDANCES based on newly inserted records in WORK_SCHEDULES
    INSERT INTO ATTENDANCES (WORKSCHEDULE_ID, PRESENT, ARRIVAL_TIME, DEPARTURE_TIME, LEAVE_TYPE)
    SELECT SCHEDULE_ID, 'False', NULL, NULL, 'WP'
    FROM INSERTED;
END
GO

--Select * from ACCOUNTS
--Select * from ATTENDANCES
--Select * from SHIFTS
--Select * from SALARIES
--Select * from EMPLOYEES
--Select * from POSITIONS







--POSITION

CREATE PROC getAllPos
AS
BEGIN
	Select * from POSITIONS
END
GO

--position
--LẤY từ dòng nào đến , và lấy bao nhiêu dòng .

CREATE PROC getPosition
@pageNumber int , @rowsOfPage int 
AS
BEGIN
	SELECT * FROM POSITIONS
	ORDER BY POSITION_ID
	OFFSET (@pageNumber - 1)*@rowsOfPage ROWS
	FETCH NEXT @rowsOfPage ROWS ONLY
END
GO

CREATE Proc countPosition
AS
BEGIN
	SELECT COUNT(POSITION_ID) total FROM POSITIONS
END
GO

CREATE PROC insertPos
	 @POSITION_NAME VARCHAR(20)
AS
BEGIN
    -- Thay đổi câu lệnh INSERT
    INSERT INTO POSITIONS(POSITION_NAME)
    VALUES(@POSITION_NAME)
END
GO

CREATE PROC deletePos
@id int
AS
BEGIN
	DELETE FROM POSITIONS
	WHERE POSITION_ID = @id 
END
GO

CREATE PROC updatePos
    @POSITION_ID INT ,
	@POSITION_NAME VARCHAR(20)
AS 

BEGIN
	UPDATE POSITIONS
	SET POSITION_NAME = @POSITION_NAME 
	WHERE POSITION_ID = @POSITION_ID
END
GO 















--Department
CREATE PROC getAllDepartment
AS
BEGIN
	SELECT * FROM DEPARTMENTS
END
GO

CREATE PROC getDepartments
@pageNumber int , @rowsOfPage int 
AS
BEGIN
	SELECT * FROM DEPARTMENTS
	ORDER BY DEPARTMENT_ID
	OFFSET (@pageNumber - 1)*@rowsOfPage ROWS
	FETCH NEXT @rowsOfPage ROWS ONLY
END
GO

CREATE Proc countDepartments
AS
BEGIN
	SELECT COUNT(DEPARTMENT_ID) total FROM DEPARTMENTS
END
GO

CREATE PROC insertDep
@department_id int , @department_name VARCHAR(100) , @head_of_department VARCHAR(20),@room VARCHAR(20)
AS
BEGIN
	INSERT INTO DEPARTMENTS(DEPARTMENT_ID,DEPARTMENT_NAME,HEAD_OF_DEPARTMENT,ROOM)
	VALUES(@department_id,@department_name,@head_of_department,@room)
END
GO
ALTER PROCEDURE insertDep
    @department_name VARCHAR(100),
    @head_of_department VARCHAR(20),
    @room VARCHAR(20)
AS
BEGIN
    -- Thay đổi câu lệnh INSERT
    INSERT INTO DEPARTMENTS(DEPARTMENT_NAME, HEAD_OF_DEPARTMENT, ROOM)
    VALUES(@department_name, @head_of_department, @room)
END
GO

CREATE PROC deleteDepartments
@id int
AS
BEGIN
	DELETE FROM DEPARTMENTS
	WHERE DEPARTMENT_ID = @id
END
GO

CREATE PROC updateDepartments
    @DEPARTMENT_ID INT ,
    @DEPARTMENT_NAME NVARCHAR(100),
    @HEAD_OF_DEPARTMENT VARCHAR(20),
    @ROOM VARCHAR(20)
AS 

BEGIN
	UPDATE DEPARTMENTS
	SET DEPARTMENT_NAME = @DEPARTMENT_NAME , HEAD_OF_DEPARTMENT = @HEAD_OF_DEPARTMENT , ROOM = @ROOM 

	WHERE DEPARTMENT_ID = @DEPARTMENT_ID
END
GO 
