/*
 Navicat Premium Data Transfer

 Source Server         : sql server
 Source Server Type    : SQL Server
 Source Server Version : 13001601
 Source Host           : LAPTOP-AH3OU4CL:1433
 Source Catalog        : test
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 13001601
 File Encoding         : 65001

 Date: 14/08/2020 00:36:16
*/


-- ----------------------------
-- Table structure for iuser
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[iuser]') AND type IN ('U'))
	DROP TABLE [dbo].[iuser]
GO

CREATE TABLE [dbo].[iuser] (
  [id] int  IDENTITY(1,1) NOT NULL,
  [name] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [password] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [email] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [perms] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[iuser] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of iuser
-- ----------------------------
SET IDENTITY_INSERT [dbo].[iuser] ON
GO

INSERT INTO [dbo].[iuser] ([id], [name], [password], [email], [perms]) VALUES (N'1', N'啊啊1', N'12344', N'248972@qq.com', N'user:admin')
GO

INSERT INTO [dbo].[iuser] ([id], [name], [password], [email], [perms]) VALUES (N'2', N'zhijie', N'12345', N'24897@qq.com', N'user:add')
GO

INSERT INTO [dbo].[iuser] ([id], [name], [password], [email], [perms]) VALUES (N'3', N'wulitu', N'123456', N'24897@qq.com', N'user:add')
GO

INSERT INTO [dbo].[iuser] ([id], [name], [password], [email], [perms]) VALUES (N'13', N'baba', N'123', N'247315@qq.com', N'user:update')
GO

INSERT INTO [dbo].[iuser] ([id], [name], [password], [email], [perms]) VALUES (N'15', N'qazz', N'123', N'252@qq.com', N'user:update')
GO

INSERT INTO [dbo].[iuser] ([id], [name], [password], [email], [perms]) VALUES (N'17', N'qa', N'qazwsx', N'22@qq.com', NULL)
GO

SET IDENTITY_INSERT [dbo].[iuser] OFF
GO


-- ----------------------------
-- Auto increment value for iuser
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[iuser]', RESEED, 17)
GO


-- ----------------------------
-- Primary Key structure for table iuser
-- ----------------------------
ALTER TABLE [dbo].[iuser] ADD CONSTRAINT [PK_user] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO

