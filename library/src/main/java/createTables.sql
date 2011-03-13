drop table if exists Department;

create table Department(
	deptId varchar(255) NOT NULL,
	depCode varchar(255),
	deptName varchar(255),
	deptShortName varchar(255),
	deptAlias varchar(255),
	deptDesc varchar(255),
	parentDeptId varchar(255),
	primary key (deptId)
);

drop table if exists User;

create table User(
	userId varchar(255) NOT NULL,
	userAccount varchar(255) NOT NULL,
	userName varchar(255),
	password varchar(255) NOT NULL,
	userActive boolean,
	createDate date,
	deptId varchar(255),
	primary key (userId),
	foreign key (deptId) references Department(deptId)
);

drop table if exists Role;

create table Role(
	roleId varchar(255) NOT NULL,
	roleName varchar(255) NOT NULL,
	roleDesc varchar(255),
	roleActive boolean,
	createDate date,
	primary key (roleId)
);

drop table if exists UserRole;

create table UserRole(
	userId varchar(255) NOT NULL,
	roleId varchar(255) NOT NULL,
	primary key (userId,roleId),
	foreign key (userId) references User(userId),
	foreign key (roleId) references Role(roleId)
);

drop table if exists Function;

create table Function(
	funcId varchar(255) NOT NULL,
	funcName varchar(255) NOT NULL,
	funcActive boolean,
	funcOrder int,
	funcLogUrl varchar(255),
	level int,
	leaf boolean,
	checked boolean,
	resCmpId varchar(255),
	resCmpText varchar(255),
	resCmpIconCls varchar(255),
	resCmpHandURL varchar(255),
	parentFuncId varchar(255),
	primary key(funcId)
);

drop table if exists RoleFunction;

create table RoleFunction(
	roleId varchar(255) NOT NULL,
	funcId varchar(255) NOT NULL,
	primary key (funcId,roleId),
	foreign key (funcId) references Function(funcId),
	foreign key (roleId) references Role(roleId)
);






