--QUERY(1) Write SQL code that will list all invoices billed to customers Elena Kurtis and Julia Samuels. Your query must account for combining the FNAME and LNAME attributes while creating and testing the predicate.



--QUERY(2) Write a SQL code that will list all customers who have purchased products on credit sequenced on dates (chronologically backward). The output should include customer number, customer‘s phone, customer name, and billing date.



--QUERY(3) Write SQL code that will remove the vendor 21344. Explain the problem(s) encountered (if any). Now, if the policy decision has been to allow such removals from vendor list without affecting the depending relation tuples, but maintaining them will NULLs; modify the constraints in PRODUCT table. On modifying the constraints, remove the said vendor and check the changes in database. Revert to the database state as before executing this query.



--QUERY(4) Write SQL code to list all referential constraints along with the information about the action to be taken if a tuple in parent table is removed. [Use DELETE_RULE attribute of USER_CONSTRAINTS relation]. Also observe for all constraints on each table of SalesCo database, their enforcement state. [Use DEFERRED and DEFERRABLE attributes of USER_CONSTRAINTS relation].



--QUERY(5) Write a SQL code that lists all products that were supplied by vendors belonging to the state ‗TN‘ arranged in increasing sequence of vendor code. The output should include product code, vendor code, vendor‘s name, product description, vendor‘s state, and inventory purchase date.



--QUERY(6) Write a SQL code that for each customer lists invoices in decreasing order. You must but keep ascending sequence for customers in the output. The output should show customer code, invoice number, invoice date, product description, line units and line price.



--QUERY(7) Write a SQL code that will modify Query-06, to include the subtotals for each of the line invoice numbers, but excluding the invoice date. [You are required compute a derived column SUBTOTAL to compute line subtotals. Use expression L_UNITS * L_PRICE to be referred by SUBTOTAL].



--QUERY(8) Write a SQL code that will list all LINE entries for which to replenish the inventory, the additional quantity of the billed products was added after the invoice date.



--QUERY(9) Write a SQL code that will list the names of all customers and vendors who belong to same area. Your output should also include customer code and vendor code along with the area to which they belong.



--QUERY(10) Write a SQL code that will modify Query-09, to show all products bought by customers which were supplied by vendors in their area.

