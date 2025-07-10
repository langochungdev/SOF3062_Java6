create database j6lab2
go
use j6lab2
go 

CREATE TABLE Users (
    Username VARCHAR(50) NOT NULL,
    Password VARCHAR(500) NOT NULL,
    Enabled BIT NOT NULL,
    PRIMARY KEY (Username)
);

CREATE TABLE Authorities (
    Id BIGINT NOT NULL IDENTITY(1,1),
    Username VARCHAR(50) NOT NULL,
    Authority VARCHAR(50) NOT NULL,
    PRIMARY KEY (Id),
    UNIQUE (Username, Authority),
    FOREIGN KEY (Username) REFERENCES Users(Username)
        ON DELETE CASCADE ON UPDATE CASCADE
);

-- Dữ liệu mẫu
INSERT INTO Users (Username, Password, Enabled) VALUES 
('user@gmail.com', '{noop}123', 1),
('admin@gmail.com', '{noop}123', 1),
('both@gmail.com', '{noop}123', 1);

INSERT INTO Authorities (Username, Authority) VALUES
('user@gmail.com', 'ROLE_USER'),
('admin@gmail.com', 'ROLE_ADMIN'),
('both@gmail.com', 'ROLE_USER'),
('both@gmail.com', 'ROLE_ADMIN');
