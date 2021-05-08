# EmployeManagementApp
This is an Basic Employee Mangement Application made using Swing framework.
To connect it with Oracle database follow the below steps :
Step #1: Change the DB Url, username and password in DButil Class.
Step #2: Type the follwing command in oracle: 
          cmd#1:- create table employee(empid number(5), empname varchar2(20), empsal number(10,2));
          cmd#2:- ALTER TABLE employee ADD CONSTRAINT PK_empid PRIMARY KEY (empid);
