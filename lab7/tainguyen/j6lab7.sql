CREATE DATABASE j6lab7
GO
USE j6lab7
GO

CREATE TABLE Categories (
    id INT PRIMARY KEY,
    name NVARCHAR(100) NOT NULL
)

CREATE TABLE Products (
    id INT PRIMARY KEY,
    name NVARCHAR(100) NOT NULL,
    price FLOAT NOT NULL,
    date DATE NOT NULL,
    categoryId INT FOREIGN KEY REFERENCES Categories(id)
)

CREATE TABLE Users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    fullname NVARCHAR(100),
    enabled BIT,
    role VARCHAR(20) CHECK (role IN ('USER', 'ADMIN'))
)

INSERT INTO Categories VALUES 
(1, N'Điện thoại'),
(2, N'Laptop'),
(3, N'Máy tính bảng'),
(4, N'Phụ kiện'),
(5, N'Đồng hồ')

INSERT INTO Products VALUES
(101, 'iPhone 15', 25000000, '2024-06-10', 1),
(102, 'Macbook Pro', 40000000, '2024-06-12', 2),
(103, 'iPad Air', 18000000, '2024-06-15', 3),
(104, 'AirPods Pro', 5500000, '2024-06-20', 4),
(105, 'Apple Watch', 10000000, '2024-06-22', 5)

INSERT INTO Users VALUES
('user1', '123', N'Nguyễn Văn A', 1, 'USER'),
('user2', '123', N'Trần Thị B', 1, 'USER'),
('admin', 'admin123', N'Quản Trị Viên', 1, 'ADMIN'),
('user3', 'abc', N'Lê Văn C', 0, 'USER'),
('user4', 'xyz', N'Phạm Thị D', 1, 'USER')
