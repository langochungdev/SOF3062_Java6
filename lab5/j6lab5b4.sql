create database j6lab5b4
go
use j6lab5b4
go

CREATE TABLE Students( 
Id VARCHAR(50) NOT NULL PRIMARY KEY, 
Name NVARCHAR(50) NOT NULL, 
Mark FLOAT NOT NULL, 
Gender BIT NOT NULL 
) 
INSERT INTO Students (Id, Name, Mark, Gender)
VALUES 
('SV001', N'Lý Thái tổ', 9.5, 1),
('SV002', N'Lê Trọng Tấn', 4.5, 1),
('SV003', N'Nguyễn Thị Minh Khai', 9.5, 0),
('SV004', N'Đoàn Trung Trực', 6.0, 1);
