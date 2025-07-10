CREATE DATABASE j6lab2b3;
GO

USE j6lab2b3;
GO

CREATE TABLE Users (
    Username VARCHAR(100) PRIMARY KEY,
    Password VARCHAR(100) NOT NULL,
    Enabled BIT NOT NULL
);

CREATE TABLE Roles (
    Id VARCHAR(50) PRIMARY KEY,
    Name NVARCHAR(100) NOT NULL
);

CREATE TABLE UserRoles (
    Id INT PRIMARY KEY IDENTITY(1,1),
    Username VARCHAR(100) FOREIGN KEY REFERENCES Users(Username),
    RoleId VARCHAR(50) FOREIGN KEY REFERENCES Roles(Id)
);

INSERT INTO Users (Username, Password, Enabled) VALUES
('user@gmail.com', '{noop}123', 1),
('admin@gmail.com', '{noop}123', 1),
('both@gmail.com', '{noop}123', 1);

INSERT INTO Roles (Id, Name) VALUES
('ROLE_USER', N'Nhân viên'),
('ROLE_ADMIN', N'Quản lý');

INSERT INTO UserRoles (Username, RoleId) VALUES
('user@gmail.com', 'ROLE_USER'),
('admin@gmail.com', 'ROLE_ADMIN'),
('both@gmail.com', 'ROLE_USER'),
('both@gmail.com', 'ROLE_ADMIN');
