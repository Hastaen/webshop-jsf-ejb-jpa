webshop-jsf-ejb-jpa
===================

Project for Networkprogramming in Java course


DB

CREATE TABLE Items
(
ItemID INT not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1), 
ItemName varchar(255) not null,
ItemStock int not null,
ItemDescription varchar(255) not null
);
CREATE TABLE Users ( UserID INT not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), UserName varchar(255) not null, Password varchar(255) not null, LastName varchar(255) not null, FirstName varchar(255) not null, Mail varchar(255), IsAdmin boolean , isBanned boolean );
