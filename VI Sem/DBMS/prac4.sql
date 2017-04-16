CREATE TABLE STAFF (
	SID NUMBER(3),
	NAME VARCHAR2(25) NOT NULL,
	BRANCH CHAR(2),
	DESG VARCHAR2(9) NOT NULL,
	JOIN_DT DATE NOT NULL,
	CONSTRAINT staff_pk_sid PRIMARY KEY (SID),
	CONSTRAINT staff_chk_sid CHECK (SID > 100),
	CONSTRAINT staff_fk_branch FOREIGN KEY (BRANCH) REFERENCES DEPT(BRAM, 
	CONSTRAINT staff_chk_desg CHECK (DESG IN ('Professor', 'Associate', 'Assistant'))
);

CREATE TABLE STUDENT (
	ROLL NUMBER(5),
	LNAME VARCHAR2(15) NOT NULL,
	FNAME VARCHAR2(15) NOT NULL,
	EMAIL VARCHAR2(25),
	ENROLL CHAR(9),
	ADVISOR NUMBER(3),
	CONSTRAINT student_pk_roll PRIMARY KEY (ROLL),
	CONSTRAINT student_chk_roll CHECK (ROLL > 3000),
	CONSTRAINT student_chk_email UNIQUE (EMAIL),
	CONSTRAINT student_chk_enroll UNIQUE (ENROLL),
	CONSTRAINT student_fk_advisor FOREIGN KEY (ADVISOR) REFERENCES STAFF(SID)
);

CREATE TABLE DEPT (
	DNAME VARCHAR2(25) NOT NULL,
	BRANCH CHAR(2),
	INTAKE NUMBER(2) NOT NULL,
	YR_EST NUMBER(4) NOT NULL,
	HOD NUMBER(3) DEFAULT 101 NOT NULL,
	CONSTRAINT dept_pk_branch PRIMARY KEY (BRANCH),
	CONSTRAINT dept_chk_branch CHECK (BRANCH IN ('CS', 'IT', 'EN')),
	CONSTRAINT dept_chk_intake CHECK (INTAKE IN (20, 30, 40)),
	CONSTRAINT dept_chk_yr_est CHECK (YR_EST > 2005),
	CONSTRAINT dept_fk_hod FOREIGN KEY (HOD) REFERENCES STAFF(SID)
);

INSERT ALL
INTO STAFF(SID, NAME, BRANCH, DESG, JOIN_DT) VALUES(101, 'Kamalkant Marathe', 'CS', 'Professor', '12-Jun-2005')
INTO STAFF(SID, NAME, BRANCH, DESG, JOIN_DT) VALUES(102, 'Adishesh Vidyarthi', 'CS', 'Associate', '22-Jul-2006')
INTO STAFF(SID, NAME, BRANCH, DESG, JOIN_DT) VALUES(103, 'Aasawari Deodhar', 'CS', 'Assistant', '13-Oct-2007')
INTO STAFF(SID, NAME, BRANCH, DESG, JOIN_DT) VALUES(104, 'Deo Narayan Mishra', 'IT', 'Assistant', '13-Oct-2007')
INTO STAFF(SID, NAME, BRANCH, DESG, JOIN_DT) VALUES(105, 'Jasmine Paul', 'IT', 'Associate', '12-May-2008')
INTO STAFF(SID, NAME, BRANCH, DESG, JOIN_DT) VALUES(106, 'Manishi Singh', 'IT', 'Professor', '11-Nov-2009')
INTO STAFF(SID, NAME, BRANCH, DESG, JOIN_DT) VALUES(107, 'Ramanathan Arun', 'EN', 'Professor', '12-Aug-2005')
INTO STAFF(SID, NAME, BRANCH, DESG, JOIN_DT) VALUES(108, 'Saifuddin Sheikh', 'EN', 'Associate', '19-Sep-2010')
INTO STAFF(SID, NAME, BRANCH, DESG, JOIN_DT) VALUES(109, 'Babush Baltiwala', 'EN', 'Assistant', '12-Apr-2012')
INTO STAFF(SID, NAME, BRANCH, DESG, JOIN_DT) VALUES(110, 'Christopher Kundu', 'CS', 'Assistant', '13-Mar-2013')
SELECT * FROM dual;

INSERT ALL
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(3001, 'Agrawal', 'Aditi', 'agrawalaa8@rknec.edu', 'MT14CS001', 101)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(3002, 'Jadhao', 'Ankita', 'jadhaoar@rknec.edu', 'MT14CS002', 102)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(3003, 'Rathi', 'Charulata', 'rathics@rknec.edu', 'MT14CS006', 101)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(3004, 'Rathi', 'Divya', 'rathidv@rknec.edu', 'MT14CS004', 101)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(3005, 'Gadiya', 'Minal', 'gadiyams@rknec.edu', 'MT14CS005', 103)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(3006, 'Naxane', 'Prajakta', 'naxanepp@rknec.edu', 'MT14CS003', 101)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(3007, 'Borele', 'Pranali', 'borelepl@rknec.edu', 'MT14CS007', 102)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(3008, 'Kushwaha', 'Preeti', 'kushwahapk1@rknec.edu', 'MT14CS008', 103)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(3009, 'Mundada', 'Priya', 'mundadapp@rknec.edu', 'MT14CS009', 102)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(3010, 'Agrawal', 'Ruchi', 'agrawalrr3@rknec.edu', 'MT14CS011', 110)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(3011, 'Khatwani', 'Sneha', 'khatwanisa@rknec.edu', 'MT14CS012', 110)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(3012, 'Pannase', 'Sonal', 'pannasesn@rknec.edu', '14CSE119', 110)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(3013, 'Nikhar', 'Sonam', 'nikharsm@rknec.edu', 'MT14CS010', 103)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(3014, 'Hardeniya', 'Tanvi', 'hardeniyatg@rknec.edu', 'MT14CS014', 110)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(3015, 'Ninawe', 'Ujwala', 'ninaweui@rknec.edu', 'MT14CS015', 103)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(3016, 'Bhogadhi', 'Vani', 'bhogadhiv@rknec.edu', 'MT14CS016', 101)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(3017, 'Mal', 'Vishakha', 'malv@rknec.edu', 'MT14CS017', 110)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(3018, 'Gowardhan', 'Yamini', 'gowardhany@rknec.edu', 'MT14CS018', 110)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(3019, 'Rathi', 'Ankit', 'rathiaa@rknec.edu', 'MT14CS019', 103)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(3020, 'Palaskar', 'Hanok', 'palaskarhd@rknec.edu', 'MT14CS022', 101)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(3021, 'Shahu', 'Ishankumar', 'shahuir@rknec.edu', 'MT14CS024', 103)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(3022, 'Dongre', 'Rushikesh', 'dongrerd@rknec.edu', 'MT14CS020', 102)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(3023, 'Jain', 'Saurabh', 'jainsm4@rknec.edu', 'MT14CS023', 102)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(3024, 'Sathawane', 'Vishal', 'sathawanevh@rknec.edu', 'MT14CS021', 103)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(4001, 'Jain', 'Aarju', 'jainas2@rknec.edu', '14MTIT001', 104)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(4002, 'Dixit', 'Ankita', 'dixitaa2@rknec.edu', '14MTIT003', 105)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(4003, 'Tiwari', 'Ankita', 'tiwarias2@rknec.edu', '14MTIT002', 106)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(4004, 'Shah', 'Arti', 'shahag@rknec.edu', '14MTIT005', 105)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(4005, 'Hinge', 'Ashwini', 'hingeaa@rknec.edu', '14MTIT006', 106)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(4006, 'Singh', 'Asmita', 'singhar5@rknec.edu', '14MTIT004', 104)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(4007, 'Chaudhari', 'Bhagyashree', 'chaudharibv@rknec.edu', '14MTIT009', 106)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(4008, 'Madan', 'Devyani', 'madands@rknec.edu', '14MTIT008', 104)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(4009, 'Bhojwani', 'Kanchan', 'bhojwanikv@rknec.edu', '14MTIT007', 105)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(4010, 'Gandhi', 'Kripali', 'gandhiko@rknec.edu', '14MTIT010', 106)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(5001, 'Nisal', 'Namita', 'nisalns@rknec.edu', '14MTEN001', 107)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(5002, 'Pathan', 'Needa', 'pathanna@rknec.edu', '14MTEN002', 109)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(5003, 'Agrawal', 'Nikita', 'agrawalno@rknec.edu', '14MTEN004', 108)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(5004, 'Kalra', 'Nikita', 'kalranm@rknec.edu', '14MTEN003', 108)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(5005, 'Sharma', 'Roopa', 'sharmarm@rknec.edu', '14MTEN010', 109)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(5006, 'Adgurwar', 'Sayli', 'adgurwarsp@rknec.edu', '14MTEN011', 108)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(5007, 'Harode', 'Shivani', 'harodess@rknec.edu', '14MTEN012', 107)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(5008, 'Thokal', 'Shweta', 'thokalss@rknec.edu', '14MTEN005', 108)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(5009, 'Gupta', 'Suruchi', 'guptasd1@rknec.edu', '14MTEN009', 107)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(5010, 'Sharma', 'Aashish', 'sharmaaa4@rknec.edu', '14MTEN006', 109)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(5011, 'Ganediwal', 'Abhay', 'ganediwalan@rknec.edu', '14MTEN007', 109)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(5012, 'Dixit', 'Abhishek', 'dixitaa1@rknec.edu', '14MTEN008', 107)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(4012, 'Tiwari', 'Abhishek', 'tiwariad1@rknec.edu', '14MTIT011', 105)
INTO STUDENT(ROLL, LNAME, FNAME, EMAIL, ENROLL, ADVISOR) VALUES(4011, 'Parmar', 'Abhishek', 'parmarar@rknec.edu', '14MTIT012', 104)
SELECT * FROM dual;

INSERT ALL
INTO DEPT(DNAME, BRANCH, INTAKE, YR_EST, HOD) VALUES('Computer Science', 'CS', 40, 2006, 101)
INTO DEPT(DNAME, BRANCH, INTAKE, YR_EST, HOD) VALUES('Information Technology', 'IT', 20, 2007, 106)
INTO DEPT(DNAME, BRANCH, INTAKE, YR_EST, HOD) VALUES('Electronics Engineering', 'EN', 30, 2007, 107)
SELECT * FROM dual;