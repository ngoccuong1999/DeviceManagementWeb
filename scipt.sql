USE [DeviceManagement]
GO
/****** Object:  Table [dbo].[annoucement]    Script Date: 4/7/2020 12:44:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[annoucement](
	[id] [int] NOT NULL,
	[annoucement_content] [nvarchar](100) NOT NULL,
	[time] [datetime] NULL,
	[user_id_request] [nvarchar](50) NOT NULL,
	[device_id_request] [int] NOT NULL,
	[status] [int] NOT NULL,
 CONSTRAINT [PK_annoucement] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[device]    Script Date: 4/7/2020 12:44:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[device](
	[id] [int] NOT NULL,
	[device_name] [nvarchar](50) NOT NULL,
	[device_description] [nvarchar](50) NULL,
	[device_type] [nvarchar](50) NULL,
	[device_room_id] [int] NOT NULL,
	[time_buy] [datetime] NOT NULL,
	[warranty_period] [datetime] NOT NULL,
	[status] [int] NOT NULL,
 CONSTRAINT [PK_device] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[device_fix]    Script Date: 4/7/2020 12:44:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[device_fix](
	[id] [int] NOT NULL,
	[device_id] [int] NOT NULL,
	[user_id] [nvarchar](50) NOT NULL,
	[request_time] [datetime] NOT NULL,
	[request_content] [nvarchar](200) NOT NULL,
	[time_fix_begin] [datetime] NULL,
	[time_fix_finish] [datetime] NULL,
	[result] [bit] NOT NULL,
	[user_id_fix] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_device_fix] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[device_image]    Script Date: 4/7/2020 12:44:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[device_image](
	[id] [int] NOT NULL,
	[link_image] [nvarchar](50) NOT NULL,
	[device_id] [int] NOT NULL,
 CONSTRAINT [PK_device_image] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[device_position]    Script Date: 4/7/2020 12:44:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[device_position](
	[id] [int] NOT NULL,
	[device_id] [int] NOT NULL,
	[no] [int] NULL,
	[user_id] [nvarchar](50) NULL,
	[change_time] [datetime] NULL,
	[change_reason] [nvarchar](50) NULL,
	[device_room_id] [int] NOT NULL,
 CONSTRAINT [PK_device_position] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[device_room]    Script Date: 4/7/2020 12:44:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[device_room](
	[id] [int] NOT NULL,
	[name] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_device_room] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[user_has_annoucement]    Script Date: 4/7/2020 12:44:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user_has_annoucement](
	[annoucement_id] [int] NOT NULL,
	[user_id] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_user_has_annoucement] PRIMARY KEY CLUSTERED 
(
	[annoucement_id] ASC,
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[user_info]    Script Date: 4/7/2020 12:44:26 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user_info](
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[full_name] [nvarchar](50) NULL,
	[phone_number] [varchar](50) NOT NULL,
	[online] [bit] NOT NULL,
	[device_room_id] [int] NULL,
	[role] [int] NOT NULL,
 CONSTRAINT [PK_user] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[annoucement] ([id], [annoucement_content], [time], [user_id_request], [device_id_request], [status]) VALUES (1, N'User: 1 yêu cầu sửa  thiết bị có id: 6 Bàn phím Bị hư', CAST(N'2020-03-24T00:00:00.000' AS DateTime), N'1', 6, 2)
INSERT [dbo].[annoucement] ([id], [annoucement_content], [time], [user_id_request], [device_id_request], [status]) VALUES (2, N'User: 1 yêu cầu sửa  thiết bị có id: 2 Cpu  cũ', CAST(N'2020-03-24T00:00:00.000' AS DateTime), N'1', 2, 2)
INSERT [dbo].[annoucement] ([id], [annoucement_content], [time], [user_id_request], [device_id_request], [status]) VALUES (3, N'User: 1 yêu cầu sửa  thiết bị có id: 6 Bàn phím hư', CAST(N'2020-03-24T00:00:00.000' AS DateTime), N'1', 6, 1)
INSERT [dbo].[annoucement] ([id], [annoucement_content], [time], [user_id_request], [device_id_request], [status]) VALUES (4, N'User: cross123 yêu cầu sửa  thiết bị có id: 3 Micro hu', CAST(N'2020-03-24T23:33:55.550' AS DateTime), N'cross123', 3, 0)
INSERT [dbo].[annoucement] ([id], [annoucement_content], [time], [user_id_request], [device_id_request], [status]) VALUES (5, N'User: testuser yêu cầu sửa  thiết bị có id: 10 test device Bị hư', CAST(N'2020-03-30T09:22:06.660' AS DateTime), N'testuser', 10, 1)
INSERT [dbo].[annoucement] ([id], [annoucement_content], [time], [user_id_request], [device_id_request], [status]) VALUES (6, N'User: testuser yêu cầu sửa  thiết bị có id: 15 may tinh bị hư ', CAST(N'2020-03-30T09:26:05.563' AS DateTime), N'testuser', 15, 0)
INSERT [dbo].[annoucement] ([id], [annoucement_content], [time], [user_id_request], [device_id_request], [status]) VALUES (7, N'User: testuser yêu cầu sửa  thiết bị có id: 15 may tinh bị hư', CAST(N'2020-03-30T09:28:02.677' AS DateTime), N'testuser', 15, 0)
INSERT [dbo].[device] ([id], [device_name], [device_description], [device_type], [device_room_id], [time_buy], [warranty_period], [status]) VALUES (1, N'Màn hình ', N'màn hình 4k', N'stream', 2, CAST(N'2012-10-12T00:00:00.000' AS DateTime), CAST(N'2018-10-12T00:00:00.000' AS DateTime), 0)
INSERT [dbo].[device] ([id], [device_name], [device_description], [device_type], [device_room_id], [time_buy], [warranty_period], [status]) VALUES (2, N'Cpu ', N'Intel Core i9-9990k, RTX 2080', N'stream', 1, CAST(N'2015-10-12T00:00:00.000' AS DateTime), CAST(N'2018-10-12T00:00:00.000' AS DateTime), 1)
INSERT [dbo].[device] ([id], [device_name], [device_description], [device_type], [device_room_id], [time_buy], [warranty_period], [status]) VALUES (3, N'Micro', N'Micro đời mới xịn nhất', N'stream', 1, CAST(N'2015-10-12T00:00:00.000' AS DateTime), CAST(N'2018-10-12T00:00:00.000' AS DateTime), 0)
INSERT [dbo].[device] ([id], [device_name], [device_description], [device_type], [device_room_id], [time_buy], [warranty_period], [status]) VALUES (4, N'Máy playstation', N'máy playstation đời mới nhât năm 2020', N'playstation xịn', 3, CAST(N'2015-10-12T00:00:00.000' AS DateTime), CAST(N'2018-10-12T00:00:00.000' AS DateTime), 0)
INSERT [dbo].[device] ([id], [device_name], [device_description], [device_type], [device_room_id], [time_buy], [warranty_period], [status]) VALUES (5, N'Tay cầm', N'xịn xò', N'playstation', 2, CAST(N'2015-10-12T00:00:00.000' AS DateTime), CAST(N'2018-10-12T00:00:00.000' AS DateTime), 0)
INSERT [dbo].[device] ([id], [device_name], [device_description], [device_type], [device_room_id], [time_buy], [warranty_period], [status]) VALUES (6, N'Bàn phím', N'Blue cạch cạch cạch', N'stream', 1, CAST(N'2019-10-12T00:00:00.000' AS DateTime), CAST(N'2022-10-12T00:00:00.000' AS DateTime), 1)
INSERT [dbo].[device] ([id], [device_name], [device_description], [device_type], [device_room_id], [time_buy], [warranty_period], [status]) VALUES (10, N'test device', N'cuong', N'stream', 20, CAST(N'2018-12-05T00:00:00.000' AS DateTime), CAST(N'2021-12-05T00:00:00.000' AS DateTime), 1)
INSERT [dbo].[device] ([id], [device_name], [device_description], [device_type], [device_room_id], [time_buy], [warranty_period], [status]) VALUES (12, N'cuong', N'dafs', N'asdf', 4, CAST(N'2021-03-04T00:00:00.000' AS DateTime), CAST(N'2021-03-05T00:00:00.000' AS DateTime), 0)
INSERT [dbo].[device] ([id], [device_name], [device_description], [device_type], [device_room_id], [time_buy], [warranty_period], [status]) VALUES (15, N'may tinh', N'sadfs', N'sdfsdf', 20, CAST(N'2020-12-05T00:00:00.000' AS DateTime), CAST(N'2022-12-05T00:00:00.000' AS DateTime), 0)
INSERT [dbo].[device_fix] ([id], [device_id], [user_id], [request_time], [request_content], [time_fix_begin], [time_fix_finish], [result], [user_id_fix]) VALUES (1, 3, N'cross123', CAST(N'2020-03-24T00:00:00.000' AS DateTime), N'User: cross123 yêu cầu sửa  thiết bị có id: 3 Micro hu', CAST(N'2020-03-24T23:35:20.593' AS DateTime), CAST(N'2020-03-24T23:35:26.017' AS DateTime), 1, N'cross')
INSERT [dbo].[device_fix] ([id], [device_id], [user_id], [request_time], [request_content], [time_fix_begin], [time_fix_finish], [result], [user_id_fix]) VALUES (2, 15, N'TestUser', CAST(N'2020-03-30T00:00:00.000' AS DateTime), N'User: testuser yêu cầu sửa  thiết bị có id: 15 may tinh bị hư ', NULL, CAST(N'2020-03-30T09:26:16.453' AS DateTime), 1, N'testfixer')
INSERT [dbo].[device_fix] ([id], [device_id], [user_id], [request_time], [request_content], [time_fix_begin], [time_fix_finish], [result], [user_id_fix]) VALUES (3, 15, N'TestUser', CAST(N'2020-03-30T00:00:00.000' AS DateTime), N'User: testuser yêu cầu sửa  thiết bị có id: 15 may tinh bị hư', NULL, CAST(N'2020-03-30T09:28:14.200' AS DateTime), 1, N'testfixer')
INSERT [dbo].[device_image] ([id], [link_image], [device_id]) VALUES (1, N'images/1.jpg', 1)
INSERT [dbo].[device_image] ([id], [link_image], [device_id]) VALUES (2, N'images/1.1.jfif', 1)
INSERT [dbo].[device_image] ([id], [link_image], [device_id]) VALUES (3, N'images/1.3.jpg', 1)
INSERT [dbo].[device_position] ([id], [device_id], [no], [user_id], [change_time], [change_reason], [device_room_id]) VALUES (1, 1, 1, N'crossline', CAST(N'2015-10-12T00:00:00.000' AS DateTime), N'Thích', 1)
INSERT [dbo].[device_position] ([id], [device_id], [no], [user_id], [change_time], [change_reason], [device_room_id]) VALUES (2, 1, 2, N'crossline', CAST(N'2016-10-12T00:00:00.000' AS DateTime), N'Cũng thích nốt', 2)
INSERT [dbo].[device_position] ([id], [device_id], [no], [user_id], [change_time], [change_reason], [device_room_id]) VALUES (3, 1, 3, N'crossline', CAST(N'2018-10-12T00:00:00.000' AS DateTime), N'like', 4)
INSERT [dbo].[device_position] ([id], [device_id], [no], [user_id], [change_time], [change_reason], [device_room_id]) VALUES (4, 2, 1, N'crossline', CAST(N'2015-10-12T00:00:00.000' AS DateTime), N'like it', 2)
INSERT [dbo].[device_position] ([id], [device_id], [no], [user_id], [change_time], [change_reason], [device_room_id]) VALUES (5, 1, 4, N'crossline', CAST(N'2015-10-12T00:00:00.000' AS DateTime), N'like ', 1)
INSERT [dbo].[device_position] ([id], [device_id], [no], [user_id], [change_time], [change_reason], [device_room_id]) VALUES (6, 2, 2, N'1', CAST(N'2020-03-03T00:00:00.000' AS DateTime), N'Mượn chơi', 1)
INSERT [dbo].[device_position] ([id], [device_id], [no], [user_id], [change_time], [change_reason], [device_room_id]) VALUES (7, 1, 5, N'crossline', CAST(N'2020-03-24T09:29:41.250' AS DateTime), N'thích thì đổi thôi', 5)
INSERT [dbo].[device_position] ([id], [device_id], [no], [user_id], [change_time], [change_reason], [device_room_id]) VALUES (8, 1, 6, N'crossline', CAST(N'2020-03-24T09:36:43.803' AS DateTime), N'phòng cũ dơ ', 2)
INSERT [dbo].[device_position] ([id], [device_id], [no], [user_id], [change_time], [change_reason], [device_room_id]) VALUES (9, 10, 1, N'crossline', CAST(N'2020-03-30T09:00:11.047' AS DateTime), N'', 20)
INSERT [dbo].[device_position] ([id], [device_id], [no], [user_id], [change_time], [change_reason], [device_room_id]) VALUES (10, 15, 1, N'crossline', CAST(N'2020-03-30T09:25:39.977' AS DateTime), N'', 20)
INSERT [dbo].[device_position] ([id], [device_id], [no], [user_id], [change_time], [change_reason], [device_room_id]) VALUES (11, 6, 1, N'crossline', CAST(N'2020-03-30T09:31:20.037' AS DateTime), N'thích', 5)
INSERT [dbo].[device_position] ([id], [device_id], [no], [user_id], [change_time], [change_reason], [device_room_id]) VALUES (12, 6, 2, N'crossline', CAST(N'2020-03-30T09:31:28.470' AS DateTime), N'thích', 1)
INSERT [dbo].[device_room] ([id], [name]) VALUES (1, N'Streaming')
INSERT [dbo].[device_room] ([id], [name]) VALUES (2, N'PlayStation')
INSERT [dbo].[device_room] ([id], [name]) VALUES (3, N'LienMinhHuyenThoai')
INSERT [dbo].[device_room] ([id], [name]) VALUES (4, N'Phòng cho user mới')
INSERT [dbo].[device_room] ([id], [name]) VALUES (5, N'Phòng cho user cũ')
INSERT [dbo].[device_room] ([id], [name]) VALUES (6, N'Phòng cho user mới')
INSERT [dbo].[device_room] ([id], [name]) VALUES (7, N'Phòng cho user mới')
INSERT [dbo].[device_room] ([id], [name]) VALUES (8, N'Phòng cho user cũ')
INSERT [dbo].[device_room] ([id], [name]) VALUES (9, N'Phòng cho user mới')
INSERT [dbo].[device_room] ([id], [name]) VALUES (10, N'Phòng cho user mới')
INSERT [dbo].[device_room] ([id], [name]) VALUES (11, N'Phòng cho user mới')
INSERT [dbo].[device_room] ([id], [name]) VALUES (12, N'Phòng cho user mới')
INSERT [dbo].[device_room] ([id], [name]) VALUES (13, N'Phòng cho user mới')
INSERT [dbo].[device_room] ([id], [name]) VALUES (14, N'Phòng cho user mới')
INSERT [dbo].[device_room] ([id], [name]) VALUES (15, N'Phòng cho user mới')
INSERT [dbo].[device_room] ([id], [name]) VALUES (20, N'TestRoom')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (1, N'cross')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (1, N'crossline')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (1, N'crossline123')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (1, N'ngoccuong1999')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (2, N'cross')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (2, N'crossline')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (2, N'crossline123')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (2, N'ngoccuong1999')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (3, N'cross')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (3, N'crossline')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (3, N'crossline123')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (3, N'ngoccuong1999')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (4, N'1')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (4, N'cross')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (4, N'crossline')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (4, N'crossline123')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (4, N'crossline9x')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (4, N'ngoccuong1999')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (5, N'1')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (5, N'cross')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (5, N'crossline')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (5, N'crossline123')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (5, N'crossline9x')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (5, N'ngoccuong1999')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (5, N'test fixer')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (5, N'testfixer')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (6, N'1')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (6, N'cross')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (6, N'crossline')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (6, N'crossline123')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (6, N'crossline9x')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (6, N'ngoccuong1999')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (6, N'test fixer')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (6, N'testfixer')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (7, N'1')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (7, N'cross')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (7, N'crossline')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (7, N'crossline123')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (7, N'crossline9x')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (7, N'ngoccuong1999')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (7, N'test fixer')
INSERT [dbo].[user_has_annoucement] ([annoucement_id], [user_id]) VALUES (7, N'testfixer')
INSERT [dbo].[user_info] ([username], [password], [full_name], [phone_number], [online], [device_room_id], [role]) VALUES (N'1', N'Khongbiet123', N'Đặng Ngọc Cường', N'03467666', 0, 1, 2)
INSERT [dbo].[user_info] ([username], [password], [full_name], [phone_number], [online], [device_room_id], [role]) VALUES (N'123456', N'Khongbiet123', N'Ngọc Cường', N'1234567', 0, 5, 1)
INSERT [dbo].[user_info] ([username], [password], [full_name], [phone_number], [online], [device_room_id], [role]) VALUES (N'1234567', N'Khongbiet123', N'Huy con lợn', N'12345678', 0, 3, 1)
INSERT [dbo].[user_info] ([username], [password], [full_name], [phone_number], [online], [device_room_id], [role]) VALUES (N'abcde', N'Khongbiet123', N'123123', N'123123', 0, 20, 1)
INSERT [dbo].[user_info] ([username], [password], [full_name], [phone_number], [online], [device_room_id], [role]) VALUES (N'cross', N'Khongbiet1', N'Cường', N'0346766634', 0, 4, 2)
INSERT [dbo].[user_info] ([username], [password], [full_name], [phone_number], [online], [device_room_id], [role]) VALUES (N'cross123', N'Khongbiet123', N'Cuong', N'034676634', 0, 1, 1)
INSERT [dbo].[user_info] ([username], [password], [full_name], [phone_number], [online], [device_room_id], [role]) VALUES (N'crossline', N'khongbiet1', N'Đặng', N'0346766634', 0, 1, 3)
INSERT [dbo].[user_info] ([username], [password], [full_name], [phone_number], [online], [device_room_id], [role]) VALUES (N'crossline123', N'Khongbiet123', N'Cuong', N'1234567', 0, 8, 3)
INSERT [dbo].[user_info] ([username], [password], [full_name], [phone_number], [online], [device_room_id], [role]) VALUES (N'crossline9x', N'Khongbiet123', N'cuong', N'03476213', 0, 7, 3)
INSERT [dbo].[user_info] ([username], [password], [full_name], [phone_number], [online], [device_room_id], [role]) VALUES (N'ngoccuong1999', N'Vipprono1', N'312', N'123324', 0, 9, 3)
INSERT [dbo].[user_info] ([username], [password], [full_name], [phone_number], [online], [device_room_id], [role]) VALUES (N'test fixer', N'Khongbiet123', N'123123', N'123123', 0, 11, 2)
INSERT [dbo].[user_info] ([username], [password], [full_name], [phone_number], [online], [device_room_id], [role]) VALUES (N'testfixer', N'Khongbiet123', N'cuong', N'1231321', 0, 12, 2)
INSERT [dbo].[user_info] ([username], [password], [full_name], [phone_number], [online], [device_room_id], [role]) VALUES (N'TestUser', N'Khongbiet123', N'Cường', N'12343241', 0, 5, 1)
ALTER TABLE [dbo].[device]  WITH CHECK ADD  CONSTRAINT [FK_device_device_room] FOREIGN KEY([device_room_id])
REFERENCES [dbo].[device_room] ([id])
GO
ALTER TABLE [dbo].[device] CHECK CONSTRAINT [FK_device_device_room]
GO
ALTER TABLE [dbo].[device_fix]  WITH CHECK ADD  CONSTRAINT [FK_device_fix_device] FOREIGN KEY([device_id])
REFERENCES [dbo].[device] ([id])
GO
ALTER TABLE [dbo].[device_fix] CHECK CONSTRAINT [FK_device_fix_device]
GO
ALTER TABLE [dbo].[device_fix]  WITH CHECK ADD  CONSTRAINT [FK_device_fix_user2] FOREIGN KEY([user_id])
REFERENCES [dbo].[user_info] ([username])
GO
ALTER TABLE [dbo].[device_fix] CHECK CONSTRAINT [FK_device_fix_user2]
GO
ALTER TABLE [dbo].[device_fix]  WITH CHECK ADD  CONSTRAINT [FK_device_fix_user3] FOREIGN KEY([user_id_fix])
REFERENCES [dbo].[user_info] ([username])
GO
ALTER TABLE [dbo].[device_fix] CHECK CONSTRAINT [FK_device_fix_user3]
GO
ALTER TABLE [dbo].[device_image]  WITH CHECK ADD  CONSTRAINT [FK_device_image_device] FOREIGN KEY([device_id])
REFERENCES [dbo].[device] ([id])
GO
ALTER TABLE [dbo].[device_image] CHECK CONSTRAINT [FK_device_image_device]
GO
ALTER TABLE [dbo].[device_position]  WITH CHECK ADD  CONSTRAINT [FK_device_position_device] FOREIGN KEY([device_id])
REFERENCES [dbo].[device] ([id])
GO
ALTER TABLE [dbo].[device_position] CHECK CONSTRAINT [FK_device_position_device]
GO
ALTER TABLE [dbo].[device_position]  WITH CHECK ADD  CONSTRAINT [FK_device_position_device_room] FOREIGN KEY([device_room_id])
REFERENCES [dbo].[device_room] ([id])
GO
ALTER TABLE [dbo].[device_position] CHECK CONSTRAINT [FK_device_position_device_room]
GO
ALTER TABLE [dbo].[device_position]  WITH CHECK ADD  CONSTRAINT [FK_device_position_user] FOREIGN KEY([user_id])
REFERENCES [dbo].[user_info] ([username])
GO
ALTER TABLE [dbo].[device_position] CHECK CONSTRAINT [FK_device_position_user]
GO
ALTER TABLE [dbo].[user_has_annoucement]  WITH CHECK ADD  CONSTRAINT [FK_user_has_annoucement_annoucement] FOREIGN KEY([annoucement_id])
REFERENCES [dbo].[annoucement] ([id])
GO
ALTER TABLE [dbo].[user_has_annoucement] CHECK CONSTRAINT [FK_user_has_annoucement_annoucement]
GO
ALTER TABLE [dbo].[user_has_annoucement]  WITH CHECK ADD  CONSTRAINT [FK_user_has_annoucement_user] FOREIGN KEY([user_id])
REFERENCES [dbo].[user_info] ([username])
GO
ALTER TABLE [dbo].[user_has_annoucement] CHECK CONSTRAINT [FK_user_has_annoucement_user]
GO
ALTER TABLE [dbo].[user_info]  WITH CHECK ADD  CONSTRAINT [FK_user_device_room] FOREIGN KEY([device_room_id])
REFERENCES [dbo].[device_room] ([id])
GO
ALTER TABLE [dbo].[user_info] CHECK CONSTRAINT [FK_user_device_room]
GO
