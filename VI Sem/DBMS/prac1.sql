--QUERY(1) Write the SQL code that will create the table structure.

CREATE TABLE EMPLOYEE (
	EID NUMBER(4) NOT NULL,
	FNAME VARCHAR2(10) NOT NULL,
	LNAME VARCHAR2(10) NOT NULL,
	BIRTHDATE DATE NOT NULL,
	GENDER CHAR(1) NOT NULL,
	HIREDATE DATE NOT NULL,
	SALARY NUMBER(7,2) NOT NULL,
	DEPARTMENT CHAR(20),
	DESIGNATION VARCHAR2(15) NOT NULL,
	SSN CHAR(10) NOT NULL,
	CONSTRAINT employee_pk_eid PRIMARY KEY (EID),
	CONSTRAINT employee_chk_eid CHECK (EID > 7100),
	CONSTRAINT employee_chk_gender CHECK (GENDER IN ('M','m','F','f')),
	CONSTRAINT employee_chk_salary CHECK (SALARY > 9999),
	CONSTRAINT employee_chk_ssn UNIQUE (SSN), 
	CONSTRAINT employee_chk_designation CHECK (DESIGNATION IN ('Professor','Asst. Professor','Lecturer','Sr. Lecturer'))
);

--QUERY(2) Write the SQL code that will enter the first two data rows into the EMPLOYEE table. (Enter other rows using insert with environment variables, at a stretch – anonymous PL/SQL).

INSERT INTO EMPLOYEE (EID, FNAME, LNAME, BIRTHDATE, GENDER, HIREDATE, SALARY, DEPARTMENT, DESIGNATION, SSN) VALUES
	(7101, 'Samantha', 'Jones', '31-MAR-1970', 'F', '08-NOV-1994', 16500.00, 'Computer Science', 'Professor', '12LS924445'),
	(7102, 'Albert', 'Greenfield', '16-APR-1975', 'M', '12-JUL-1998', 14200.00, 'Biotechnology', 'Sr. Lecturer', '12LS893456'),
	(7103, 'Julia', 'Martin', '09-FEB-1977', 'F', '01-DEC-1999', 13320.00, 'Computer Science', 'Lecturer', '13CA911760'),
	(7104, 'Martina', 'Jacobson', '30-JUN-1974', 'F', '15-NOV-1996', 15550.00, 'Nanotechnology', 'Asst. Professor', '56TX811122'),
	(7105, 'Alexander', 'Lloyd', '30-JAN-1970', 'M', '01-FEB-1994', 17500.00, 'Machine Vision', 'Professor', '56TX921165'),
	(7106, 'William', 'Smithfield', '02-NOV-1972', 'M', '23-JUN-1996', 15660.00, 'Computer Science', 'Asst. Professor', '11WA112121'),
	(7107, 'Eugene', 'Sabatini', '09-NOV-1973', 'F', '10-OCT-1994', 16500.00, 'Biotechnology', 'Professor', '11WA132311'),
	(7108, 'James', 'Washington', '15-SEP-1971', 'M', '22-AUG-1998', 14000.00, 'Nanotechnology', 'Sr. Lecturer', '13CA123121'),
	(7109, 'Larry', 'Gomes', '28-AUG-1976', 'M', '18-MAY-1999', 13650.00, 'Machine Vision', 'Lecturer', '56TX288761');


--QUERY(3) Assuming that the remaining data have been entered, write the SQL code that will list all attributes for the designation ―Professor‖.

SELECT * FROM EMPLOYEE WHERE DESIGNATION = 'Professor';

--QUERY(4) Write the SQL code that will save the EMPLOYEE table.

COMMIT;

--QUERY(5) Write the SQL code to list the first names and last names of the employees who were born before 01-JAN-1976 and were hired after 01-JUL-1997.

SELECT FNAME, LNAME FROM EMPLOYEE WHERE BIRTHDATE < '01-JAN-1976' AND HIREDATE > '01-JUL-1997';

--QUERY(6) Write the SQL code to change the designation to ―Asst. Professor‖ for the employee whose employee identification is 7102. (After completing the task, examine the results, and then reset the designation to its original value).

UPDATE EMPLOYEE SET DESIGNATION = 'Asst. Professor' WHERE EID = 7102;
ROLLBACK;

--QUERY(7) Write the SQL code to display the contents of the EMPLOYEE table as summarized above. (Write two independent projection statements with employee identification as one of the base referring attribute).

SELECT EID, FNAME, LNAME, BIRTHDATE, GENDER, HIREDATE FROM EMPLOYEE;
SELECT EID, SALARY, DEPARTMENT, DESIGNATION, SSN FROM EMPLOYEE;

--QUERY(8) Write the SQL code to insert the following employee – 7010, Svetlana, Sanders, 15-OCT-1984, M, 44MA123456, 15-JAN-2006, 8000, Machine Vision, Lecturer What are the problems encountered? Fix and reinsert the record. Save the EMPLOYEE table and check if the updates are saved.

INSERT INTO EMPLOYEE (EID, FNAME, LNAME, BIRTHDATE, GENDER, HIREDATE, SALARY, DEPARTMENT, DESIGNATION, SSN) VALUES
	(7010, 'Svetlana', 'Sanders', '15-OCT-1984', 'M', '15-JAN-2006', 8000, 'Machine Vision', 'Lecturer', '44MA123456');