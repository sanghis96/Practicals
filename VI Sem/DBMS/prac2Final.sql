--QUERY(1) Write and execute the DDL statements to create SalesCo database. Ensure that you enforce the specified constraints (entity-integrity, referential integrity, domain, unique, and not null along with defaults if any).

CREATE TABLE CUSTOMER(
	C_CODE NUMBER(5),
	LNAME VARCHAR2(10) NOT NULL,
	FNAME VARCHAR2(10) NOT NULL,
	C_AREA NUMBER(3) NOT NULL,
	C_PHONE NUMBER(7) NOT NULL,
	BALANCE NUMBER(7,2) DEFAULT 0 NOT NULL,
	CONSTRAINT customer_pk_c_code PRIMARY KEY (C_CODE),
	CONSTRAINT customer_chk_c_code CHECK (C_CODE > 10009),
	CONSTRAINT customer_chk_c_area CHECK (C_AREA > 500 AND C_AREA < 1000)
);
CREATE TABLE VENDOR (
	V_CODE NUMBER(5),
	V_NAME VARCHAR2(30) NOT NULL,
	V_CONTACT VARCHAR2(20) NOT NULL,
	V_AREA NUMBER(3) NOT NULL,
	V_PHONE NUMBER(7) NOT NULL,
	V_STATE CHAR(2) NOT NULL,
	V_ORDER CHAR(1) DEFAULT 'N' NOT NULL,
	CONSTRAINT vendor_pk_v_code PRIMARY KEY (V_CODE),
	CONSTRAINT vendor_chk_v_code CHECK (V_CODE > 21000),
	CONSTRAINT vendor_chk_v_area CHECK (V_AREA > 500 AND V_AREA < 1000), 
	CONSTRAINT vendor_chk_v_state CHECK (V_STATE IN ('TN','FL','KY','GA'))
);
CREATE TABLE INVOICE (
	INV_NUM NUMBER(4),
	C_CODE NUMBER(5),
	INV_DATE DATE NOT NULL,
	CONSTRAINT invoice_pk_INV_NUM PRIMARY KEY (INV_NUM),
	CONSTRAINT invoice_chk_INV_NUM CHECK (INV_NUM > 1000),
	CONSTRAINT invoice_fk_C_CODE FOREIGN KEY (C_CODE) REFERENCES CUSTOMER(C_CODE)
);
CREATE TABLE PRODUCT (
	P_CODE CHAR(5),
	DESCRIPT VARCHAR2(30) NOT NULL,
	P_DATE DATE NOT NULL,
	QTY NUMBER(4) NOT NULL,
	P_MIN NUMBER(3) NOT NULL, 
	P_PRICE NUMBER(6,2) NOT NULL,
	P_DISC NUMBER(2,2) DEFAULT 0 NOT NULL ,
	V_CODE NUMBER(5),
	CONSTRAINT product_pk_P_CODE PRIMARY KEY (P_CODE),
	CONSTRAINT product_chk_P_MIN CHECK (P_MIN < QTY),
	CONSTRAINT product_fk_V_CODE FOREIGN KEY (V_CODE) REFERENCES VENDOR(V_CODE)
);
CREATE TABLE LINE (
	INV_NUM NUMBER(4),
	L_NUM NUMBER(1),
	P_CODE CHAR(5),
	L_UNITS NUMBER(3) NOT NULL,
	L_PRICE NUMBER(5,2) NOT NULL,
	CONSTRAINT line_pk_INV_NUM PRIMARY KEY (INV_NUM,L_NUM),
	CONSTRAINT line_fk_INV_NUM FOREIGN KEY (INV_NUM) REFERENCES INVOICE (INV_NUM),
	CONSTRAINT line_chk_L_NUM CHECK (L_NUM > 0),
	CONSTRAINT line_fk_P_CODE FOREIGN KEY (P_CODE) REFERENCES PRODUCT (P_CODE),
	CONSTRAINT invoice_chk_L_UNITS CHECK (L_UNITS > 0),
	CONSTRAINT invoice_chk_L_PRICE CHECK (L_PRICE > 0)
);

--QUERY(2) Populate the database with above mentioned sample contents. You must ensure that tables without referential integrity constraints are populated first. You may use .SQL file to store database population INSERT scripts and execute it at one go).

INSERT ALL
INTO CUSTOMER(C_CODE, LNAME, FNAME, C_AREA, C_PHONE, BALANCE) VALUES(10010, 'Anderson', 'James', 615, 2933893, 0.00)
INTO CUSTOMER(C_CODE, LNAME, FNAME, C_AREA, C_PHONE, BALANCE) VALUES(10011, 'Kurtis', 'Elena', 713, 2753455, 0.00)
INTO CUSTOMER(C_CODE, LNAME, FNAME, C_AREA, C_PHONE, BALANCE) VALUES(10012, 'Smith', 'Kathy', 615, 2873453, 345.86)
INTO CUSTOMER(C_CODE, LNAME, FNAME, C_AREA, C_PHONE, BALANCE) VALUES(10013, 'Paul', 'Chris', 615, 2879998, 536.75)
INTO CUSTOMER(C_CODE, LNAME, FNAME, C_AREA, C_PHONE, BALANCE) VALUES(10014, 'Johnson', 'Bill', 615, 2455533, 0.00)
INTO CUSTOMER(C_CODE, LNAME, FNAME, C_AREA, C_PHONE, BALANCE) VALUES(10015, 'Samuels', 'Julia', 713, 2345432, 0.00)
INTO CUSTOMER(C_CODE, LNAME, FNAME, C_AREA, C_PHONE, BALANCE) VALUES(10016, 'Harris', 'Anne', 615, 2233445, 221.19)
INTO CUSTOMER(C_CODE, LNAME, FNAME, C_AREA, C_PHONE, BALANCE) VALUES(10017, 'Ford', 'Gustav', 615, 2223444, 768.93)
INTO CUSTOMER(C_CODE, LNAME, FNAME, C_AREA, C_PHONE, BALANCE) VALUES(10018, 'Lee', 'Ming', 713, 2323234, 216.55)
INTO CUSTOMER(C_CODE, LNAME, FNAME, C_AREA, C_PHONE, BALANCE) VALUES(10019, 'Green', 'Walter', 615, 2786403, 0.00)
SELECT * FROM dual;

INSERT ALL
INTO VENDOR(V_CODE, V_NAME, V_CONTACT, V_AREA, V_PHONE, V_STATE, V_ORDER) VALUES(21225, 'Bryson, Inc.', 'Bella', 615, 2453628, 'TN', 'Y')
INTO VENDOR(V_CODE, V_NAME, V_CONTACT, V_AREA, V_PHONE, V_STATE, V_ORDER) VALUES(21226, 'SuperLoo, Inc.', 'Ching-Hun', 904, 3876330, 'FL', 'N')
INTO VENDOR(V_CODE, V_NAME, V_CONTACT, V_AREA, V_PHONE, V_STATE, V_ORDER) VALUES(21231, 'GnB Supply', 'Samson', 615, 2889922, 'TN', 'Y')
INTO VENDOR(V_CODE, V_NAME, V_CONTACT, V_AREA, V_PHONE, V_STATE, V_ORDER) VALUES(21344, 'Gomez Sons', 'Mark', 615, 2986363, 'KY', 'N')
INTO VENDOR(V_CODE, V_NAME, V_CONTACT, V_AREA, V_PHONE, V_STATE, V_ORDER) VALUES(22587, 'Downing, Inc.', 'Simon Singh', 901, 3985333, 'GA', 'N')
INTO VENDOR(V_CODE, V_NAME, V_CONTACT, V_AREA, V_PHONE, V_STATE, V_ORDER) VALUES(23119, 'Blackman Sisters', 'Svetlana', 901, 3562429, 'GA', 'Y')
INTO VENDOR(V_CODE, V_NAME, V_CONTACT, V_AREA, V_PHONE, V_STATE, V_ORDER) VALUES(24004, 'Almeda House', 'Almeda', 615, 2787878, 'TN', 'N')
INTO VENDOR(V_CODE, V_NAME, V_CONTACT, V_AREA, V_PHONE, V_STATE, V_ORDER) VALUES(24288, 'Justin Stores', 'Gracy Yu', 615, 2543333, 'TN', 'Y')
INTO VENDOR(V_CODE, V_NAME, V_CONTACT, V_AREA, V_PHONE, V_STATE, V_ORDER) VALUES(25443, 'Super Systems', 'Ted Hwang', 904, 3561111, 'FL', 'N')
INTO VENDOR(V_CODE, V_NAME, V_CONTACT, V_AREA, V_PHONE, V_STATE, V_ORDER) VALUES(25501, 'SilverminesLtd.', 'Anne White', 615, 2983455, 'TN', 'N')
INTO VENDOR(V_CODE, V_NAME, V_CONTACT, V_AREA, V_PHONE, V_STATE, V_ORDER) VALUES(25595, 'HighEnd Supplies', 'Smith', 904, 3098773, 'FL', 'Y')
SELECT * FROM dual;

INSERT ALL
INTO INVOICE (INV_NUM, C_CODE, INV_DATE) VALUES(1001, 10014, '16-JAN-12')
INTO INVOICE (INV_NUM, C_CODE, INV_DATE) VALUES(1002, 10011, '16-JAN-12')
INTO INVOICE (INV_NUM, C_CODE, INV_DATE) VALUES(1003, 10012, '16-JAN-12')
INTO INVOICE (INV_NUM, C_CODE, INV_DATE) VALUES(1004, 10018, '17-JAN-12')
INTO INVOICE (INV_NUM, C_CODE, INV_DATE) VALUES(1005, 10011, '17-JAN-12')
INTO INVOICE (INV_NUM, C_CODE, INV_DATE) VALUES(1006, 10014, '17-JAN-12')
INTO INVOICE (INV_NUM, C_CODE, INV_DATE) VALUES(1007, 10015, '17-JAN-12')
INTO INVOICE (INV_NUM, C_CODE, INV_DATE) VALUES(1008, 10011, '17-JAN-12')
SELECT * FROM dual;

INSERT ALL
INTO PRODUCT (P_CODE , DESCRIPT, P_DATE, QTY, P_MIN, P_PRICE, P_DISC, V_CODE) VALUES('AB112', 'Power Painter', '03-NOV-11', 8, 5, 109.99, 0.00, 25595)
INTO PRODUCT (P_CODE , DESCRIPT, P_DATE, QTY, P_MIN, P_PRICE, P_DISC, V_CODE) VALUES('SB725', '7.25in Saw Blade', '13-DEC-11', 32, 15, 14.99, 0.05, 21344)
INTO PRODUCT (P_CODE , DESCRIPT, P_DATE, QTY, P_MIN, P_PRICE, P_DISC, V_CODE) VALUES('SB900', '9.00 in Saw Blade', '13-NOV-11', 18, 12, 17.49, 0.00, 21344)
INTO PRODUCT (P_CODE , DESCRIPT, P_DATE, QTY, P_MIN, P_PRICE, P_DISC, V_CODE) VALUES('CL025', 'Hrd. Cloth 1/4in', '15-JAN-12', 15, 8, 39.95, 0.00, 23119)
INTO PRODUCT (P_CODE , DESCRIPT, P_DATE, QTY, P_MIN, P_PRICE, P_DISC, V_CODE) VALUES('CL050', 'Hrd. Cloth 1/2in', '15-JAN-12', 23, 5, 43.99, 0.00, 23119)
INTO PRODUCT (P_CODE , DESCRIPT, P_DATE, QTY, P_MIN, P_PRICE, P_DISC, V_CODE) VALUES('JB012', 'Jigsaw 12in Blade', '30-DEC-11', 8, 5, 109.92, 0.05, 24288)
INTO PRODUCT (P_CODE , DESCRIPT, P_DATE, QTY, P_MIN, P_PRICE, P_DISC, V_CODE) VALUES('JB008', 'Jigsaw 8in Blade', '24-DEC-11', 6, 5, 99.87, 0.05, 24288)
INTO PRODUCT (P_CODE , DESCRIPT, P_DATE, QTY, P_MIN, P_PRICE, P_DISC, V_CODE) VALUES('CD00X', 'Cordless Drill', '20-JAN-12', 12, 5, 38.95, 0.05, 25595)
INTO PRODUCT (P_CODE , DESCRIPT, P_DATE, QTY, P_MIN, P_PRICE, P_DISC, V_CODE) VALUES('CH10X', 'Claw Hammer', '20-JAN-12', 23, 10, 9.95, 0.10, 21225)
INTO PRODUCT (P_CODE , DESCRIPT, P_DATE, QTY, P_MIN, P_PRICE, P_DISC, V_CODE) VALUES('SH100', 'Sledge Hammer', '02-JAN-12', 8, 5, 14.40, 0.05, NULL)
INTO PRODUCT (P_CODE , DESCRIPT, P_DATE, QTY, P_MIN, P_PRICE, P_DISC, V_CODE) VALUES('RF100', 'Rat Tail File', '15-DEC-11', 43, 20, 4.99, 0.00, 21344)
INTO PRODUCT (P_CODE , DESCRIPT, P_DATE, QTY, P_MIN, P_PRICE, P_DISC, V_CODE) VALUES('HC100', 'Hicut Chain Saw', '07-FEB-12', 11, 5, 256.99, 0.05, 24288)
INTO PRODUCT (P_CODE , DESCRIPT, P_DATE, QTY, P_MIN, P_PRICE, P_DISC, V_CODE) VALUES('PP101', 'PVC Pipe', '20-FEB-12', 188, 75, 5.87, 0.00, NULL)
INTO PRODUCT (P_CODE , DESCRIPT, P_DATE, QTY, P_MIN, P_PRICE, P_DISC, V_CODE) VALUES('MC001', 'Metal Screw', '01-MAR-12', 172, 75, 6.99, 0.00, 21225)
INTO PRODUCT (P_CODE , DESCRIPT, P_DATE, QTY, P_MIN, P_PRICE, P_DISC, V_CODE) VALUES('WC025', '2.5in wide Screw', '24-FEB-12', 237, 100, 8.45, 0.00, 21231)
INTO PRODUCT (P_CODE , DESCRIPT, P_DATE, QTY, P_MIN, P_PRICE, P_DISC, V_CODE) VALUES('SM48X', 'Steel Malting Mesh', '17-JAN-12', 18, 5, 119.95, 0.10, 25595)
SELECT * FROM dual;

INSERT ALL
INTO LINE (INV_NUM, L_NUM, P_CODE, L_UNITS, L_PRICE) VALUES(1001, 1, 'SB725', 1, 14.99)
INTO LINE (INV_NUM, L_NUM, P_CODE, L_UNITS, L_PRICE) VALUES(1001, 2, 'CH10X', 1, 9.95)
INTO LINE (INV_NUM, L_NUM, P_CODE, L_UNITS, L_PRICE) VALUES(1002, 1, 'RF100', 2, 4.99)
INTO LINE (INV_NUM, L_NUM, P_CODE, L_UNITS, L_PRICE) VALUES(1003, 1, 'CD00X', 1, 38.95)
INTO LINE (INV_NUM, L_NUM, P_CODE, L_UNITS, L_PRICE) VALUES(1003, 2, 'CL025', 1, 39.95)
INTO LINE (INV_NUM, L_NUM, P_CODE, L_UNITS, L_PRICE) VALUES(1003, 3, 'SB725', 5, 14.99)
INTO LINE (INV_NUM, L_NUM, P_CODE, L_UNITS, L_PRICE) VALUES(1004, 2, 'RF100', 3, 4.99)
INTO LINE (INV_NUM, L_NUM, P_CODE, L_UNITS, L_PRICE) VALUES(1004, 3, 'CH10X', 2, 9.95)
INTO LINE (INV_NUM, L_NUM, P_CODE, L_UNITS, L_PRICE) VALUES(1005, 1, 'PP101', 12, 5.87)
INTO LINE (INV_NUM, L_NUM, P_CODE, L_UNITS, L_PRICE) VALUES(1006, 1, 'MC001', 3, 6.99)
INTO LINE (INV_NUM, L_NUM, P_CODE, L_UNITS, L_PRICE) VALUES(1006, 2, 'JB012', 1, 109.92)
INTO LINE (INV_NUM, L_NUM, P_CODE, L_UNITS, L_PRICE) VALUES(1006, 3, 'CH10X', 1, 9.95)
INTO LINE (INV_NUM, L_NUM, P_CODE, L_UNITS, L_PRICE) VALUES(1006, 4, 'HC100', 1, 256.99)
INTO LINE (INV_NUM, L_NUM, P_CODE, L_UNITS, L_PRICE) VALUES(1007, 1, 'SB725', 2, 14.99)
INTO LINE (INV_NUM, L_NUM, P_CODE, L_UNITS, L_PRICE) VALUES(1007, 2, 'RF100', 1, 4.99)
INTO LINE (INV_NUM, L_NUM, P_CODE, L_UNITS, L_PRICE) VALUES(1008, 1, 'PP101', 5, 5.87)
INTO LINE (INV_NUM, L_NUM, P_CODE, L_UNITS, L_PRICE) VALUES(1008, 2, 'SM48X', 3, 119.95)
INTO LINE (INV_NUM, L_NUM, P_CODE, L_UNITS, L_PRICE) VALUES(1008, 3, 'CH10X', 1, 9.95)
SELECT * FROM dual;

--QUERY(3) For each table of SalesCo database, list all the enforced constraints. (Use USER_CONSTRAINTS table in Oracle‘s Data Catalog)

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE FROM USER_CONSTRAINTS WHERE TABLE_NAME LIKE 'CUSTOMER';
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE FROM USER_CONSTRAINTS WHERE TABLE_NAME LIKE 'VENDOR';
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE FROM USER_CONSTRAINTS WHERE TABLE_NAME LIKE 'INVOICE';
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE FROM USER_CONSTRAINTS WHERE TABLE_NAME LIKE 'PRODUCT';
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE FROM USER_CONSTRAINTS WHERE TABLE_NAME LIKE 'LINE';

--QUERY(4) List the contents of all the tables in the database. You must but set the display screen width appropriately using SET LINESIZE NN command.

SELECT * FROM CUSTOMER;
SELECT * FROM VENDOR;
SELECT * FROM INVOICE;
SELECT * FROM PRODUCT;
SELECT * FROM LINE;

--QUERY(5) Write SQL code to insert a LINE record – 1009, 1, HH15X, 20, 5.50. What are the problems encountered? What are the additional requirements? Assume that the 200 units of the product ―Hanging Hook 15in‖ were supplied by ―Martha Associates‖ located in ―KY‘ at unit price of 5.75 on January 10, 2013. Minimum stock quantity was anticipated to be 25. The line was billed to Grace Dawson located in area 904 with phone 3562098 and a balance of 452.99 on June 22, 2013. The supplier with ID 24992 has a contact named ―Jasmine Ray‖ with phone 2863322.

INSERT INTO CUSTOMER(C_CODE, LNAME, FNAME, C_AREA, C_PHONE, BALANCE) VALUES(10020, 'Dawson', 'Grace', 904, 3562098, 452.99);
INSERT INTO VENDOR(V_CODE, V_NAME, V_CONTACT, V_AREA, V_PHONE, V_STATE, V_ORDER) VALUES(24992, 'Martha Associates', 'Jasmine Ray', 615, 2863322, 'KY', 'N');
INSERT INTO INVOICE (INV_NUM, C_CODE, INV_DATE) VALUES(1009, 10020, '22-JUN-13');
INSERT INTO PRODUCT (P_CODE , DESCRIPT, P_DATE, QTY, P_MIN, P_PRICE, P_DISC, V_CODE) VALUES('HH15X', 'Hanging Hook 15in', '10-JAN-13', 200, 25, 5.75, 0.00, 24992);
INSERT INTO LINE (INV_NUM, L_NUM, P_CODE, L_UNITS, L_PRICE) VALUES (1009, 1, 'HH15X', 20, 5.50);

--QUERY(6) Write the SQL code that will list P_CODE, DESCRIPT, V_CODE for all products that are some kind of blades.


--QUERY(7) Write the SQL code that will list for all zero-balance customers their names, phone numbers and customer IDs. You must but ensure that in the output the name is a single field that combines first name followed by last name of the customer.

SELECT C_CODE, FNAME, LNAME, C_PHONE FROM CUSTOMER WHERE BALANCE = 0.00;

--QUERY(8) Write the SQL code that will list all products which were added to inventory during 2012.

SELECT * FROM PRODUCT WHERE P_DATE > '31-DEC-2011' AND P_DATE < '01-JAN-2013';