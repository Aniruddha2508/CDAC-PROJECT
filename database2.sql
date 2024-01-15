use project;
show tables;
drop table roles;

create table Roles(
Id int auto_increment,
RoleName varchar(50) not null,
constraint Role_PK primary key(Id));

select * from roles;

create table Admin(
AdminId int auto_increment,
Password varchar(100),
RoleId int not null unique,
constraint AdminID_PK primary key(AdminId),
foreign key (RoleId) references Roles(ID));

describe admin;

create table Users(
Id int auto_increment,
Email varchar(50),
Password varchar(100),
RoleId int not null unique,
constraint UserId_PK primary key(Id),
foreign key (RoleId) references Roles(ID));

drop table vendors;

create table Vendors(
Id int auto_increment,
Password varchar(100),
RoleId int not null unique,
constraint VendorId_PK primary key(Id),
foreign key (RoleId) references Roles(ID));


create table Customer(
Id int auto_increment primary key,
First_name varchar(20),
Middle_name varchar(20),
Last_name varchar(20),
Mobile varchar(20),
Email varchar(50),
Set_Password varchar(20),
Location varchar(30),
Area varchar(30),
House_no varchar(20),
Apart_Name varchar(30),
Pincode varchar(20)
);

create table Product(
ID int auto_increment primary key,
Name varchar(40),
price decimal(5,2),
Quantity varchar(10),
Discount decimal(3,2),
size varchar(10),
Product_Image varbinary(10000),
VendorId int  not null unique,
foreign key (VendorId) references Vendors(Id)
);

drop table product;

create table Orders(
Id int auto_increment ,
Price decimal(5,2),
Quantity int,
SubTotal decimal(5,2),
Saving decimal(3,2),
Shipping_Charge varchar(20),
Total decimal(5,2),
CustomerId int  not null unique,
productId int  not null unique,
constraint Order_Id_PK primary key(Id),
foreign key (CustomerId) references Customer(Id),
foreign key (productId) references product(Id));

drop table orders;
create table cart(
id int auto_increment primary key,
Product_Description varchar(100),
Unit_price decimal(5,2),
SubTotal decimal(5,2),
Saving decimal(5,2),
Total decimal(5,2),
productId int  not null unique,
CustomerId int  not null unique,
foreign key (CustomerId) references Customer(Id),
foreign key (productId) references product(Id));


create table Transaction(
Transaction_Id int auto_increment primary key,
Transaction_Mode varchar(20),
Transaction_DateAndTime datetime,
Total_Amount decimal(5,2),
Status_Of_Payment varchar(20),
CustomerId int not null unique,
Order_Id int not null unique,
foreign key (CustomerId) references Customer(Id),
foreign key (Order_Id) references orders(Id));


show tables;