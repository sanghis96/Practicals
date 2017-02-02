SET ECHO ON
SET FEEDBACK ON
SPOOL "E:\Practicals\VI Sem\DBMS\prac4.txt" APPEND

--QUERY(1) Write SQL code to establish the schema (including enforcement of integrity constraints). Populate DEPT with indicated tuples. [Note: While creating DEPT do not enforce the referential integrity constraint]. You should use default value for HOD while inserting tuples in DEPT. Also populate first 6 tuples in STAFF.
DROP TABLE DEPT CASCADE CONSTRAINTS;
CREATE TABLE DEPT (
	DNAME VARCHAR2(25) NOT NULL,
	BRANCH CHAR(2),
	INTAKE NUMBER(2) NOT NULL,
	YR_EST NUMBER(4) NOT NULL,
	HOD NUMBER(3) DEFAULT 101,
	CONSTRAINT dept_pk_branch PRIMARY KEY (BRANCH),
	CONSTRAINT dept_chk_branch CHECK (BRANCH IN ('CS', 'IT', 'EN')),
	CONSTRAINT dept_chk_intake CHECK (INTAKE IN (20, 30, 40)),
	CONSTRAINT dept_chk_yr_est CHECK (YR_EST > 2005)
);

DELETE FROM DEPT;
INSERT ALL
INTO DEPT(DNAME, BRANCH, INTAKE, YR_EST, HOD) VALUES('Computer Science', 'CS', 40, 2012, NULL)
INTO DEPT(DNAME, BRANCH, INTAKE, YR_EST, HOD) VALUES('Information Technology', 'IT', 20, 2013, NULL)
INTO DEPT(DNAME, BRANCH, INTAKE, YR_EST, HOD) VALUES('Electronics Engineering', 'EN', 30, 2014, NULL)
SELECT * FROM dual;

COMMIT;
SPOOL OFF
SET FEEDBACK OFF
SET ECHO OFF