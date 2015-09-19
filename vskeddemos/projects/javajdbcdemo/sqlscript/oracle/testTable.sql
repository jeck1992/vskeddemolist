

create table testTableInfo(
testIds number(5) primary key,
testNumberA number(7,2),
testVarchar varchar(50),
testVarchar2 varchar2(50),
testNVarchar2 nvarchar2(50),
testDate date default (sysdate),
testTimeStamp timestamp default (sysdate),
testChar char(50),
testNChar nchar(50)
);

insert into testTableInfo(testIds,testNumberA,testVarchar,testVarchar2,testNVarchar2,testChar,testNChar) 
values (1, 98.12, 'abcdefg中文在这儿', 'hijklmn三师兄不是来打酱油的吃货', 'opqrstuvw师傅说不会数据库不让吃','aabbccdd传说不在这儿', 'eeffhhii没人听说过这个么' );

select * from testTableInfo;

--drop table testTableInfo;