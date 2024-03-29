CREATE DATABASE CarX
GO

create table Account (accountId numeric(19,0) identity not null, createDate datetime not null, note varchar(255), password varchar(255) not null, status INT DEFAULT 0 not null, username varchar(255) not null, roleId int not null, primary key (accountId));
create table Assistant (assistantId int identity not null, DOB datetime not null, email varchar(255) not null, gender bit not null, name NVARCHAR(300) not null, note NVARCHAR(300), phone varchar(255) not null, status INT DEFAULT 0 not null, schoolId int not null, primary key (assistantId));
create table Car (carId numeric(19,0) identity not null, carName NVARCHAR(300) not null, createDate datetime not null, description NVARCHAR(3000), status INT DEFAULT 0 not null, carTypeId int not null, teamId numeric(19,0) not null, primary key (carId));
create table CarInRace (carRaceId numeric(19,0) identity not null, bonus INT DEFAULT 0, endTime datetime, penalty INT DEFAULT 0, racePosition int, score int, startTime datetime, status INT DEFAULT 0 not null, raceId numeric(19,0) not null, teamId numeric(19,0) not null, primary key (carRaceId));
create table CarType (carTypeId int identity not null, avatar NVARCHAR(300) DEFAULT 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fcar%20models%2Fdefault%20car%20type%20avatar.jpg?alt=media&token=9718a570-999f-4290-9a9c-7289c2f3707e' not null, description NVARCHAR(3000), name NVARCHAR(300) not null, note NVARCHAR(300), status INT DEFAULT 0 not null, primary key (carTypeId));
create table Location (locationId int identity not null, description NVARCHAR(3000), locationName NVARCHAR(1000) DEFAULT 'FPT University Library' not null, status INT DEFAULT 0 not null, primary key (locationId));
create table Map (mapId int identity not null, description NVARCHAR(3000), mapName NVARCHAR(300) not null, status INT DEFAULT 0 not null, mapTypeId int not null, primary key (mapId));
create table MapImage (mapImageId numeric(19,0) identity not null, link VARCHAR(3000) not null, note NVARCHAR(300), mapId int not null, primary key (mapImageId));
create table MapType (mapTypeId int identity not null, description NVARCHAR(3000), status INT DEFAULT 0 not null, typeName NVARCHAR(300) not null, tournamentId numeric(19,0) not null, primary key (mapTypeId));
create table Member (memberId numeric(19,0) identity not null, note NVARCHAR(300), status INT DEFAULT 0 not null, studentId numeric(19,0) not null, teamId numeric(19,0) not null, tournamentId numeric(19,0) not null, primary key (memberId));
create table Race (raceId numeric(19,0) identity not null, endTime datetime, note NVARCHAR(300), startTime datetime, status INT DEFAULT 0 not null, mapId int not null, roundId numeric(19,0) not null, umpireId int not null, primary key (raceId));
create table Role (roleId int identity not null, description NVARCHAR(3000), name NVARCHAR(300) not null, status INT DEFAULT 0 not null, primary key (roleId));
create table Round (roundId numeric(19,0) identity not null, endTime datetime, note NVARCHAR(300), startTime datetime, status INT DEFAULT 0 not null, tournamentId numeric(19,0) not null, primary key (roundId));
create table School (schoolId int identity not null, address NVARCHAR(300) not null, createDate datetime not null, mail varchar(255) not null, note NVARCHAR(300), phone varchar(255) not null, schoolName NVARCHAR(300) not null, status INT DEFAULT 0 not null, primary key (schoolId));
create table SchoolTour (schoolTourId numeric(19,0) identity not null, note NVARCHAR(300), status INT DEFAULT 0 not null, schoolId int not null, tournamentId numeric(19,0) not null, primary key (schoolTourId));
create table SchoolYear (yearId int identity not null, description NVARCHAR(3000), status INT DEFAULT 0 not null, yearNo INT DEFAULT 2024 not null, primary key (yearId));
create table Student (studentId numeric(19,0) identity not null, DOB datetime not null, email varchar(255) not null, gender bit not null, name NVARCHAR(300) not null, note NVARCHAR(300), phone varchar(255) not null, status INT DEFAULT 0 not null, schoolId int not null, primary key (studentId));
create table Team (teamId numeric(19,0) identity not null, avatar NVARCHAR(300) DEFAULT 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fcar%20models%2Fdefault%20car%20type%20avatar.jpg?alt=media&token=9718a570-999f-4290-9a9c-7289c2f3707e' not null, description NVARCHAR(3000), status INT DEFAULT 0 not null, teamName NVARCHAR(300) not null, schoolTourId numeric(19,0) not null, primary key (teamId));
create table Tournament (tournamentId numeric(19,0) identity not null, date datetime not null, status INT DEFAULT 0 not null, tournamentName NVARCHAR(300) not null, locationId int not null, yearId int not null, primary key (tournamentId));
create table Umpire (umpireId int identity not null, DOB datetime not null, email varchar(255) not null, gender bit not null, name NVARCHAR(300) not null, note NVARCHAR(300), phone varchar(255) not null, status INT DEFAULT 0 not null, primary key (umpireId));
alter table Account add constraint UK_de34gsw4qt8auhffbna969ahp unique (username);
alter table Account add constraint FKn410hnfqcgp1xqbc6e9v4lper foreign key (roleId) references Role;
alter table Assistant add constraint FKaajrtwcap7b0ge8ktigjq2g1i foreign key (schoolId) references School;
alter table Car add constraint FK50wgij30w6h7aodbbhsafcg8h foreign key (carTypeId) references CarType;
alter table Car add constraint FKrvk1a9xobx2dqytgtp6n23a4c foreign key (teamId) references Team;
alter table CarInRace add constraint FK1rjjoljk3vbnpnqoxk9w2hd43 foreign key (raceId) references Race;
alter table CarInRace add constraint FK7kf8y4inb59bwxg7vuuqy7276 foreign key (teamId) references Team;
alter table Map add constraint FKr1wpulwiagtoreoh64ai5jcal foreign key (mapTypeId) references MapType;
alter table MapImage add constraint FKoy6hafs79u80sgt2dqmha34op foreign key (mapId) references Map;
alter table MapType add constraint FK6drh88ei0pwenaqmgbs98dngo foreign key (tournamentId) references Tournament;
alter table Member add constraint FK39jr3cpe22j6gr8ck2irqle47 foreign key (studentId) references Student;
alter table Member add constraint FKnd42gy6hy2mg90pccmmdbus3p foreign key (teamId) references Team;
alter table Member add constraint FK49he0yraj4bw8kempnkd3ql0 foreign key (tournamentId) references Tournament;
alter table Race add constraint FKhuejy75sl6mcga2qunq53qaot foreign key (mapId) references Map;
alter table Race add constraint FKtr04uf9vt5pmi6xnj362amdfv foreign key (roundId) references Round;
alter table Race add constraint FKfg6a82f3pxf8yp3nldx0w9jd4 foreign key (umpireId) references Umpire;
alter table Round add constraint FKs8ldy7inm06n9g1opw3vmitbi foreign key (tournamentId) references Tournament;
alter table SchoolTour add constraint FK7qcad93a3p57nvxvsnlcs9xtj foreign key (schoolId) references School;
alter table SchoolTour add constraint FKs1trdv9ldm931fedh8g6cea1p foreign key (tournamentId) references Tournament;
alter table Student add constraint FKef1nxhxm77yoflgh1955it31v foreign key (schoolId) references School;
alter table Team add constraint FKsk5kr55fld85r7t834orv9ldi foreign key (schoolTourId) references SchoolTour;
alter table Tournament add constraint FKkklmef8orx4y8na5em3mp0tyr foreign key (locationId) references Location;
alter table Tournament add constraint FK9chbn3g3fl7f5su02bjx4fge foreign key (yearId) references SchoolYear;
