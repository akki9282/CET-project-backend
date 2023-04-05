/*create database*/
create schema college_predict;

use college_predict;
/*college table*/
create table college(
college_ID int,
college_name varchar(255) not null,
college_type varchar(255) not null,
city varchar(255) not null,

primary key(college_ID)
);

/*branch table*/
create table branch(
branch_ID int,
college_ID int not null,
branch_name varchar(255) not null,

primary key(branch_ID),
foreign key(college_ID) references college(college_ID)
);

/*category table
create table category(
category_ID int,
category_name varchar(10) not null,

primary key(category_ID)
);
*/

/*percentage table*/
create table percentage(
branch_ID int not null,
college_ID int not null,
cap_round int not null,	
category_name varchar(255) not null,
stage varchar(255) not null,
ranking int not null,
percentage decimal(4,2) not null,

foreign key(branch_ID) references branch(branch_ID),
foreign key(college_ID) references college(college_ID)

);

/*centeral table
create table college_predict(
branch_ID int not null,
category_ID int not null,
college_ID int not null,
foreign key(branch_ID) references branch(branch_ID),
foreign key(category_ID) references category(category_ID),
foreign key(college_ID) references college(college_ID)
);
*/
ALTER TABLE percentage
ADD CONSTRAINT all_unique UNIQUE (branch_ID, college_ID, cap_round,ranking,percentage,category_name,stage);

 
