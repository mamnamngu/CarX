﻿
--SCHOOL INSERTION
INSERT INTO School (schoolName, address, phone, mail, createDate, note, status) VALUES (N'THPT Chuyên Trần Đại Nghĩa', N'20 Lý Tự Trọng, Bến Nghé, Quận 1, Thành phố Hồ Chí Minh, Vietnam', '0186393264', 'thptchuyentrandainghia@gmail.edu.vn', '01/05/2023', '', '0');
INSERT INTO School (schoolName, address, phone, mail, createDate, note, status) VALUES (N'THPT Nguyễn Thượng Hiền', N'649 Đ. Hoàng Văn Thụ, Phường 4, Tân Bình, Thành phố Hồ Chí Minh, Vietnam', '0173948965', 'thptnguyenthuonghien@gmail.edu.vn', '02/05/2023', '', '0');
INSERT INTO School (schoolName, address, phone, mail, createDate, note, status) VALUES (N'THPT Bùi Thị Xuân', N'73 Đ. Bùi Thị Xuân, Phường Phạm Ngũ Lão, Quận 1, Thành phố Hồ Chí Minh, Vietnam', '0926782193', 'thptbuithixuan@gmail.edu.vn', '02/05/2023', '', '0');

--ASSISTANT INSERTION
INSERT INTO Assistant (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('1', N'Trần Nguyễn Thiên Ân', '04/18/1992', '1', '01893664649', 'antnt@gmail.com', 'primary', '0');
INSERT INTO Assistant (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('1', N'Trần Tiến Dũng', '05/22/1990', '1', '02866487476', 'dungtt@gmail.com', 'collateral', '0');
INSERT INTO Assistant (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('2', N'Nguyễn Quốc Chánh', '10/20/1989', '1', '08338799837', 'chanhnq@gmail.com', 'primary', '0');
INSERT INTO Assistant (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('2', N'Hoàng Thành Long', '06/07/1994', '1', '09378963929', 'longht@gmail.com', 'collateral', '0');
INSERT INTO Assistant (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('3', N'Lương Vĩnh Thiệu', '09/18/1993', '1', '09782979943', 'thieulv@gmail.com', 'primary', '0');
INSERT INTO Assistant (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('3', N'Nguyễn Nhật Huy', '10/11/1990', '1', '01378936498', 'huynn@gmail.com', 'collateral', '0');

--SCHOOL YEAR INSERTION
INSERT INTO SchoolYear (yearNo, description, status) VALUES ('2023', '2023 is the establishment year of CarX.', '3');
INSERT INTO SchoolYear (yearNo, description, status) VALUES ('2024', '2024 marks miraculous growth of CarX on the track of introducing IOT and Programminig concepts to students of all ages.', '0');

--LOCATION INSERTION
INSERT INTO [Location] (locationName, description, status) VALUES ('FPT University HCMC Campus Library', 'Transforming a library into the venue for a remote control car race competition adds an intriguing twist to traditional racing events, blending the quiet, studious atmosphere of the library with the thrilling, competitive spirit of racing. Imagine the library aisles and reading areas cleverly converted into challenging race tracks, where the silent concentration is replaced with the buzzing of tiny engines and the focused attention of participants and spectators alike.', '0');
INSERT INTO [Location] (locationName, description, status) VALUES ('FPT University HCMC Campus Rooftop', 'A rooftop sets the stage for an exhilarating and visually stunning remote control car race competition, offering a unique blend of open-air excitement and panoramic views of the surrounding cityscape. This elevated platform transforms into a race track like no other, where the sky is the limit for creativity in course design. The rooftop boundaries and features, such as air conditioning units, raised garden beds, and seating areas, become natural obstacles and turns, challenging racers to navigate their vehicles with precision and skill.', '0');
INSERT INTO [Location] (locationName, description, status) VALUES ('FPT University HCMC Campus Entrance Hall', 'The entrance hall, with its expansive space and grandeur, serves as a magnificent setting for a remote control car race competition. This central area, typically the first point of contact for visitors, transforms into a dynamic racecourse, where the elegance of architecture meets the adrenaline of high-speed competition. The wide, open layout provides ample room for intricate tracks to be set up, featuring tight corners, long straightaways, and challenging obstacles that test the skills of racers.', '0');
INSERT INTO [Location] (locationName, description, status) VALUES ('FPT University HCMC Campus Lotus Lake', 'Lotus Lake, with its serene beauty and natural landscape, offers a picturesque and challenging setting for a remote control car race competition. This tranquil location is transformed into a dynamic and captivating racecourse, where the natural elements of water, land, and flora play integral roles in the design of the track. The competition leverages the lake winding shores, lush surroundings, and the iconic lotus pads floating on the water surface to create a unique and immersive racing experience.', '0');
INSERT INTO [Location] (locationName, description, status) VALUES ('FPT University HCMC Campus Hall B', 'An hall B offers a controlled and versatile environment for hosting a remote control car race competition, providing racers and spectators with an experience that is both intense and intimate. This setting allows for the creation of a meticulously designed racecourse, featuring a variety of challenges such as tight turns, intricate obstacle courses, and varied terrain simulated with ramps, tunnels, and jumps, all within the confines of a spacious yet sheltered area.', '0');

--CAR TYPE INSERTION
INSERT INTO CarType (name, description, avatar, note, status) VALUES ('Buggy', 'These are versatile, lightweight RC cars suitable for a wide range of terrains, including dirt, grass, and tracks. They typically have a good balance of speed and handling.', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fcar%20models%2Fbuggy.jpg?alt=media&token=9a60c6f7-2021-4733-a027-1e300197ffde', 'Demo Model', '0');
INSERT INTO CarType (name, description, avatar, note, status) VALUES ('Truggy', 'A hybrid between a buggy and a monster truck, truggies offer the speed and agility of a buggy with the stability and durability of a monster truck. They are excellent for rough terrains.', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fcar%20models%2Ftruggy.jpg?alt=media&token=a8f036ad-f282-4968-a0e3-ee1bc7c0d4f5', 'Demo Model', '0');
INSERT INTO CarType (name, description, avatar, note, status) VALUES ('Monster Truck', 'These RC cars are known for their large size, high ground clearance, and big tires, making them ideal for off-road conditions, particularly over obstacles.', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fcar%20models%2Fmonster%20truck.jpg?alt=media&token=de189ba5-9213-4eec-ae4c-13395480f1c7', 'Demo Model', '0');
INSERT INTO CarType (name, description, avatar, note, status) VALUES ('Short Course Truck', 'Inspired by full-size short course race trucks, these RC cars have a realistic look and are designed for racing on dirt tracks. They are durable and handle well on a variety of surfaces.', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fcar%20models%2Fshort%20course%20truck.jpg?alt=media&token=8757565e-5938-44c5-8ae2-2142f11cf61b', 'Demo Model', '0');
INSERT INTO CarType (name, description, avatar, note, status) VALUES ('Drift Car', 'Specialized for drifting, these cars are designed to slide around turns in a controlled manner. They typically have slick tires and are used on smooth, flat surfaces.', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fcar%20models%2Fdrift%20car.jpg?alt=media&token=0017b963-8ef0-4112-a582-76a09ec928c7', 'Demo Model', '0');
INSERT INTO CarType (name, description, avatar, note, status) VALUES ('Rock Crawler', 'Specifically designed for climbing rocks and rough terrain, rock crawlers have high torque and are geared for powerful climbing with a focus on maneuverability and stability.', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fcar%20models%2Frock%20crawler.jpg?alt=media&token=cc358653-7304-47e1-97bc-2ce2598fd2a9', 'Demo Model', '0');
INSERT INTO CarType (name, description, avatar, note, status) VALUES ('On-Road Car', 'These are designed for speed and performance on paved surfaces. They are lower to the ground with a focus on aerodynamics and handling at high speeds.', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fcar%20models%2Fon-road%20car.jpg?alt=media&token=b43b73dd-5e7e-4a07-becc-ab3644ed5052', 'Demo Model', '0');
INSERT INTO CarType (name, description, avatar, note, status) VALUES ('Stadium Truck', 'A mix between a buggy and a short course truck, stadium trucks have a more open-wheel design. They are well-suited for off-road conditions, especially on dirt tracks.', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fcar%20models%2Fstadium%20truck.jpg?alt=media&token=25851e1f-b81c-4a3c-9e15-d4db43abbf05', 'Demo Model', '0');
INSERT INTO CarType (name, description, avatar, note, status) VALUES ('Rally Car', 'Designed for mixed surface racing (both on-road and off-road), rally cars have a robust build and can handle a variety of terrains, from asphalt to gravel and dirt.', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fcar%20models%2Frally%20car.jpg?alt=media&token=2d4a0905-dccd-47a3-b620-90ca026bc104', 'Demo Model', '0');

--ROLE INSERTION
INSERT INTO [Role] (name, description, status) VALUES ('umpire', 'As the guardians of fairness and integrity on the racetrack, umpires mission is to ensure that every race is conducted under the highest standards of sportsmanship and regulatory compliance.', '0');
INSERT INTO [Role] (name, description, status) VALUES ('school assistant', 'School assistants are here to facilitate and streamline the process of managing student entries, ensuring that their young racers are registered and ready to hit the track.', '0');
INSERT INTO [Role] (name, description, status) VALUES ('system admin', 'As the System Administrator, they are dedicated to ensuring that their digital infrastructure operates flawlessly, supporting every aspect of the competition from registration to real-time race updates.', '0');

--UMPIRE INSERTION
INSERT INTO Umpire (name, DOB, gender, phone, email, note, status) VALUES (N'Nguyễn Hoàng Nam', '01/18/2001', '1', '08278916231', 'asouth93new@gmail.com', 'new apprentice', '0');
INSERT INTO Umpire (name, DOB, gender, phone, email, note, status) VALUES (N'Lâm Hữu Khánh Phương', '05/12/1980', '1', '01827535625', 'sample@gmail.com', 'instructor', '0');
INSERT INTO Umpire (name, DOB, gender, phone, email, note, status) VALUES (N'Trần Chiêu An', '04/22/1990', '0', '08273562839', 'antc@gmail.com', 'instructor', '0');
INSERT INTO Umpire (name, DOB, gender, phone, email, note, status) VALUES (N'Nguyễn Thế Hoàng', '06/25/1980', '1', '09278195782', 'hoangnt@gmail.com', 'instructor', '0');
INSERT INTO Umpire (name, DOB, gender, phone, email, note, status) VALUES (N'Huỳnh Thanh Trúc', '03/07/1992', '0', '01672678536', 'trucht@gmail.com', 'instructor', '0');

--STUDENT INSERTION
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('1', N'Thi Nhật Nam', '06/20/2003', '1', '0192784924', 'namtnSE150922@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('1', N'Nguyễn Hoàng Huy', '11/5/2003', '1', '0392478913', 'huynhSE160012@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('1', N'Lâm Gia Hưng', '03/07/2003', '1', '0189464024', 'hunglgSE160025@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('1', N'Hoàng Trọng Tiến', '03/13/2003', '1', '0827389462', 'tienhtSE160049@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('1', N'Đặng Nguyễn Vũ Hoàng', '09/24/2002', '1', '0628397134', 'hoangdnvSE160061@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('1', N'Hoàng Xuân Học', '06/03/2002', '1', '0928387491', 'hochxSE160220@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('1', N'Châu Ngọc Hiền', '05/05/2002', '1', '0928496456', 'hiencnSE160244@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('1', N'Nguyễn Gia Đạt', '03/20/2002', '1', '0827389445', 'datngSE160265@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('1', N'Lê Long Nhật', '08/19/2002', '1', '0237891864', 'nhatllSE160267@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('1', N'Cao Kiến Quốc', '11/13/2002', '1', '0128749864', 'quocckSE160271@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('1', N'Nguyễn Hồng Ngọc', '10/03/2002', '0', '0826892014', 'ngocnhSE160303@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('1', N'Dương Thị Hiền', '05/28/2002', '0', '0123178456', 'hiendtSE160317@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('1', N'Thiều Phan Văn Minh', '12/08/2002', '1', '0192845780', 'minhtpvSE160611@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('1', N'Nguyễn Tuấn Khải', '01/26/2002', '1', '0927837485', 'khaintSE161879@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('1', N'Nguyễn Đức Quang', '03/22/2002', '1', '0673891345', 'quangndSE161882@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('1', N'Nguyễn Huy Phúc', '11/04/2002', '1', '0938804750', 'phucnhSE161932@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('2', N'Huỳnh Ngọc Thành Long', '02/04/2002', '1', '0178362545', 'longhntSE161971@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('2', N'Lê Hoàng Giang', '12/02/2002', '1', '0920918397', 'gianglhSE161972@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('2', N'Trần Tấn Đạt', '03/12/2002', '1', '0147802740', 'datttSE162069@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('2', N'Đỗ Minh Hiếu', '03/15/2003', '1', '0928947506', 'hieudmSE162117@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('2', N'Phạm Trần Sơn Nguyên', '01/22/2003', '1', '0920842571', 'nguyenptsSE170048@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('2', N'Trần Quang Vinh', '03/22/2003', '1', '0839576305', 'vinhtqSE170399@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('2', N'Lê Thúc Thanh Tú', '06/19/2003', '1', '0829642071', 'tulttSE171116@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('2', N'Dương Tiến Phát', '07/04/2003', '1', '0193795686', 'phatdtSE171188@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('2', N'Hồ Nguyên Gíap', '05/08/2003', '1', '0278935677', 'giaphnSE171532@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('2', N'Nguyễn Hoàng Đại Việt', '09/02/2003', '1', '0928389947', 'vietnhdSE171666@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('2', N'Trương Chí Cường', '10/03/2003', '1', '0562907429', 'cuongtcSE171693@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('2', N'Lê Anh Tuấn', '10/04/2003', '1', '0273896450', 'tuanlaSE171726@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('2', N'Bùi Nguyễn Gia Huy', '09/04/2003', '1', '0928909285', 'huybngSE172270@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('2', N'Trần Minh Nhựt', '04/04/2003', '1', '0821212094', 'nhuttmSE172609@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('2', N'Lý Khải Nghiệp', '08/23/2003', '1', '0129802458', 'nghieplkSE172770@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('3', N'Đặng Võ Anh Minh', '04/05/2003', '1', '0929808809', 'minhdvaSE172977@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('3', N'Lê Nguyễn Tiến Nhật', '12/26/2003', '1', '0809990245', 'nhatlntSE173012@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('3', N'Lê Trung Đức', '05/04/2003', '1', '0368958909', 'ducltSE173043@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('3', N'Nguyễn Hoàng Nam', '10/11/2003', '1', '0357129749', 'namhSE173230@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('3', N'Trần Minh Đạt', '08/10/2003', '1', '0912637548', 'dattmSE173260@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('3', N'Nguyễn Đức Bảo', '06/19/2003', '1', '0271379645', 'baondSE173024@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('3', N'Nguyễn Phi', '11/06/2003', '1', '0132789463', 'phinSE173264@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('3', N'Lê Trọng Đạo', '05/09/2003', '1', '0379026984', 'daoltSE1731641@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('3', N'Đặng Đức Nghĩa', '03/27/2003', '1', '0238964929', 'nghiandSE173252@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('3', N'Đỗ Nguyễn Bảo Tâm', '09/06/2003', '1', '0973872583', 'tamdnbSE173314@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('3', N'Nguyễn Huỳnh Minh Khôi', '06/12/2003', '1', '0827827916', 'khoinhmSE173272@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('3', N'Nguyễn Đình Trung Kiên', '10/23/2003', '1', '0878916893', 'kienndtSE173261@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('3', N'Nguyễn Huy Long', '08/06/2003', '1', '0278396896', 'longnhSE173280@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('3', N'Lâm Hoài Thương', '09/02/2003', '0', '0137872969', 'thuonglhSS170315@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('3', N'Hồ Trần Bảo Hân', '02/24/2003', '0', '0290378937', 'hanhtbSS170004@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('3', N'Nguyễn Lan Hương', '07/17/2002', '0', '0927894692', 'huongnlSE161291@fpt.edu.vn', 'sample data', '0');
INSERT INTO Student (schoolId, name, DOB, gender, phone, email, note, status) VALUES ('3', N'Nguyễn Hưng Hải', '08/17/2003', '1', '0829889369', 'hainhSE173100@fpt.edu.vn', 'sample data', '0');

--TOURNAMENT INSERTION
INSERT INTO Tournament (tournamentName, yearId, locationId, date, status) VALUES ('Spring Slides', '1', '1', '02/01/2023', '3');
INSERT INTO Tournament (tournamentName, yearId, locationId, date, status) VALUES ('Summer Break', '1', '2', '04/15/2023', '3');
INSERT INTO Tournament (tournamentName, yearId, locationId, date, status) VALUES ('Fall Journey', '1', '3', '07/20/2023', '3');
INSERT INTO Tournament (tournamentName, yearId, locationId, date, status) VALUES ('Christmas Sleighs', '1', '4', '11/25/2023', '3');
INSERT INTO Tournament (tournamentName, yearId, locationId, date, status) VALUES ('Tet Trips', '2', '4', '01/08/2024', '3');
INSERT INTO Tournament (tournamentName, yearId, locationId, date, status) VALUES ('Spring Race', '2', '3', '03/05/2024', '0');

--SCHOOL TOUR INSERTION
INSERT INTO SchoolTour (tournamentId, schoolId, note, status) VALUES ('6', '1', 'First Visit', '0');
INSERT INTO SchoolTour (tournamentId, schoolId, note, status) VALUES ('6', '2', 'First Visit', '0');
INSERT INTO SchoolTour (tournamentId, schoolId, note, status) VALUES ('6', '3', 'First Visit', '0');

--MAP TYPE INSERTION
INSERT INTO MapType (tournamentId, typeName, description, status) VALUES ('6', 'On-Road Tracks', 'These are smooth, paved tracks, often resembling actual roadways. They are designed for high-speed racing and require precise handling. These tracks may include tight turns, chicanes, and long straights for speed.', '0');
INSERT INTO MapType (tournamentId, typeName, description, status) VALUES ('6', 'Carpet Tracks', 'These indoor tracks are covered with carpet or similar materials, providing a unique surface that offers high traction. They are commonly used for competitive racing, especially during colder months or in regions with frequent rain.', '0');
INSERT INTO MapType (tournamentId, typeName, description, status) VALUES ('6', 'Rally Tracks', 'Combining elements of both on-road and off-road tracks, rally tracks often feature mixed surfaces like dirt, gravel, and asphalt. These tracks test the versatility and handling of rally-type RC cars.', '0');
INSERT INTO MapType (tournamentId, typeName, description, status) VALUES ('6', 'Rock Crawling Courses', 'These courses are made with rocks, boulders, and various obstacles that mimic mountainous and rough terrains. The goal is to navigate these challenging landscapes without getting stuck or overturning the RC car.', '0');
INSERT INTO MapType (tournamentId, typeName, description, status) VALUES ('6', 'Drift Tracks', 'Specifically designed for RC drift cars, these tracks often have a smooth, slippery surface to facilitate drifting. They include a series of turns and corners where drivers can showcase their drifting skills.', '0');

--MAP INSERTION
INSERT INTO Map (mapTypeId, mapName, description, status) VALUES ('1', 'Long Straights', 'These sections allow for high-speed racing and are a test of a car top speed and acceleration.', '0');
INSERT INTO Map (mapTypeId, mapName, description, status) VALUES ('1', 'Hairpin Turns', 'Tight, U-shaped turns challenge drivers to brake accurately and navigate the turn without losing too much speed or control.', '0');
INSERT INTO Map (mapTypeId, mapName, description, status) VALUES ('1', 'S-Bends', 'These are a series of curves that snake back and forth, requiring rhythmic steering adjustments and good throttle control.', '0');
INSERT INTO Map (mapTypeId, mapName, description, status) VALUES ('2', 'Tight Corners', 'Due to the high traction, carpet tracks often feature tight corners that test the driver steering precision and car handling.', '0');
INSERT INTO Map (mapTypeId, mapName, description, status) VALUES ('2', 'Slalom Sections', 'Areas where drivers have to weave in and out of a series of obstacles, testing their steering accuracy and control.', '0');
INSERT INTO Map (mapTypeId, mapName, description, status) VALUES ('2', 'Sweeping Curves', 'These are longer, more gradual turns that test the driver ability to maintain a fast, consistent racing line.', '0');
INSERT INTO Map (mapTypeId, mapName, description, status) VALUES ('3', 'Dirt and Gravel Sections', 'A classic feature in rally tracks, these sections simulate the loose and unpredictable nature of real rally stages. The dirt and gravel surfaces challenge the driver ability to maintain control and speed.', '0');
INSERT INTO Map (mapTypeId, mapName, description, status) VALUES ('3', 'Asphalt Sections', 'Smooth, paved sections that require precise handling and braking. These contrast with the looser surfaces and test the car on-road capabilities.', '0');
INSERT INTO Map (mapTypeId, mapName, description, status) VALUES ('3', 'Water Crossings', 'Shallow water sections can be included to add an extra level of difficulty, affecting traction and car handling.', '0');
INSERT INTO Map (mapTypeId, mapName, description, status) VALUES ('4', 'Rock Gardens', 'These are areas filled with various sizes of rocks and boulders, creating a rugged and uneven terrain that tests the crawler ability to traverse obstacles.', '0');
INSERT INTO Map (mapTypeId, mapName, description, status) VALUES ('4', 'Steep Inclines and Declines', 'Steep uphill and downhill sections challenge the vehicle power, traction, and the driver throttle control.', '0');
INSERT INTO Map (mapTypeId, mapName, description, status) VALUES ('4', 'Rock Steps', 'A series of rocks or ledges set up like steps, requiring precise control to climb up or down without tipping over.', '0');
INSERT INTO Map (mapTypeId, mapName, description, status) VALUES ('5', 'Figure-Eights', 'A track layout that involves driving in a pattern resembling the number 8, which is excellent for practicing transitions between drifts.', '0');
INSERT INTO Map (mapTypeId, mapName, description, status) VALUES ('5', 'Obstacle Avoidance', 'Sometimes, obstacles are placed near the track edge, challenging drivers to drift close to them without making contact.', '0');
INSERT INTO Map (mapTypeId, mapName, description, status) VALUES ('5', 'Chicanes', 'A series of tight, quick turns, challenging drivers to switch the direction of their drift rapidly while maintaining control.', '0');

--MAP IMAGE INSERTION
INSERT INTO MapImage (mapId, link, note) VALUES ('1', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FLong%20Straights%201.jpg?alt=media&token=a32ff669-c82f-40fc-bb0f-0bc323b8cdf9', 'Profile Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('1', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FLong%20Straights%202.jpg?alt=media&token=715697be-d266-4216-bc8e-20134a823d74', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('1', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FLong%20Straights%203.jpg?alt=media&token=669547ce-5884-4299-bedb-6a4c91a4431b', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('2', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FHairpin%20Turns%201.jpg?alt=media&token=3b177e42-7a32-4d34-94e8-5a1a33ab487c', 'Profile Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('2', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FHairpin%20Turns%202.jpg?alt=media&token=6e95a604-0943-4c52-b82b-0d79ee5da31a', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('2', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FHairpin%20Turns%203.jpg?alt=media&token=844c657c-ce8a-4950-b5b5-97c71385b3b7', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('2', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FHairpin%20Turns%204.jpg?alt=media&token=af79bb40-55bc-44ab-95c4-6882a93dc714', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('3', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FS-Bends%201.jpg?alt=media&token=a5c56e23-aa44-4ad9-99fe-a649e6c98b48', 'Profile Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('3', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FS-Bends%202.jpg?alt=media&token=706bd84a-6b90-4c85-9c9d-ee0bf7f73158', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('3', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FS-Bends%203.jpg?alt=media&token=6ea087a1-4e62-4e9f-b292-d63c1b4a30b6', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('3', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FS-Bends%204.jpg?alt=media&token=82953682-d589-4492-b3fd-32977d4dd4c6', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('4', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FTight%20Corners%201.jpg?alt=media&token=6eafa4ba-9908-4a4a-915b-86518539f3cb', 'Profile Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('4', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FTight%20Corners%202.jpg?alt=media&token=53ff1d58-3db4-40c4-b598-a4bd4d45cda4', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('5', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FSlalom%20Sections%201.jpg?alt=media&token=f7351ac8-4f92-4324-94a6-5f4bcfc35c65', 'Profile Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('5', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FSlalom%20Sections%202.jpg?alt=media&token=6e8f9d48-9907-41b9-9f6b-001e80537c82', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('5', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FSlalom%20Sections%203.jpg?alt=media&token=2d017a17-519a-46ca-ab81-c2d4affb9391', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('5', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FSlalom%20Sections%204.jpg?alt=media&token=2e4d8973-2309-49cd-8b23-149afa25f392', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('6', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FSweeping%20Curves%201.jpg?alt=media&token=913c2c6c-ca28-472d-81e2-a5460435ff97', 'Profile Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('6', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FSweeping%20Curves%202.jpg?alt=media&token=62d6692d-ba70-42d0-b611-92628f065df5', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('7', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FDirt%20and%20Gravel%20Sections%201.jpg?alt=media&token=87a82ee0-81e7-49e2-803f-a4e879fdd520', 'Profile Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('7', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FDirt%20and%20Gravel%20Sections%202.jpg?alt=media&token=b0952ae3-1788-49d0-9366-d13a7ef5d39b', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('7', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FDirt%20and%20Gravel%20Sections%203.jpg?alt=media&token=62a50db9-f6cc-4c91-904a-77e5d26a95f6', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('7', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FDirt%20and%20Gravel%20Sections%204.jpg?alt=media&token=936e04fd-1f84-4572-abcb-78ec752655fc', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('8', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FAsphalt%20Sections%201.jpg?alt=media&token=deb6e877-e53f-41c5-ad78-3a3284d384f0', 'Profile Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('8', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FAsphalt%20Sections%202.jpg?alt=media&token=495be9d1-09aa-43d5-8c87-54755aca5124', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('8', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FAsphalt%20Sections%203.jpg?alt=media&token=9dc8b755-dd9a-4bec-a88b-c77baf890d26', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('8', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FAsphalt%20Sections%204.jpg?alt=media&token=a01717d4-52ec-4041-960d-4d97e21b0491', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('9', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FWater%20Crossings%201.jpg?alt=media&token=09c64dd6-3423-433e-a1ba-2e0000c8b473', 'Profile Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('9', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FWater%20Crossings%202.jpg?alt=media&token=b4ea7298-4530-4d21-9d27-813259a00d7c', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('9', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FWater%20Crossings%203.jpg?alt=media&token=b7c8c96e-2787-4154-9632-a3671c069bd6', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('10', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FRock%20Gardens%201.jpg?alt=media&token=65f52ade-7ed1-4593-85c7-5d77d52c1c5e', 'Profile Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('10', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FRock%20Gardens%202.jpg?alt=media&token=1f3e2e47-42fd-4371-9a78-e725ca74d49a', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('10', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FRock%20Gardens%203.jpg?alt=media&token=0db6fccc-bcf4-411f-a9c0-84d8e811cfde', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('10', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FRock%20Gardens%204.jpg?alt=media&token=4cde1b3e-4cf4-4108-a6af-ae1dd1ea94fe', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('11', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FSteep%20Inclines%20and%20Declines%201.jpg?alt=media&token=837fa744-552d-486a-a7cc-e4867f6d873c', 'Profile Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('11', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FSteep%20Inclines%20and%20Declines%202.jpg?alt=media&token=c2c2f05e-df0a-4274-9cbf-0e81ddacc6c1', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('11', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FSteep%20Inclines%20and%20Declines%203.jpg?alt=media&token=ddb179d1-0e05-4484-a644-cf9a41fff449', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('11', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FSteep%20Inclines%20and%20Declines%204.jpg?alt=media&token=7174cb6d-c732-4b8f-a820-c1341106f1e2', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('12', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FRock%20Steps%201.jpg?alt=media&token=4c5adb37-f12d-4a40-8473-a4c668552e5c', 'Profile Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('12', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FRock%20Steps%202.jpg?alt=media&token=39d5f541-a5a8-4fa1-b3e3-3c4470aedf86', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('12', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FRock%20Steps%203.jpg?alt=media&token=2aeaf948-4863-4755-81ac-8eb51c771794', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('13', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FFigure-Eights%201.jpg?alt=media&token=d5b07668-de9c-4375-a4c8-895b4b5985d4', 'Profile Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('13', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FFigure-Eights%202.jpg?alt=media&token=969f5673-656f-4059-aaee-4b6b4558a8a2', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('13', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FFigure-Eights%203.jpg?alt=media&token=a5b5157e-41e0-4700-951c-88d68b244d98', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('14', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FObstacle%20Avoidance%201.jpg?alt=media&token=c6cb45ae-0f98-414c-86c5-2df0457a9781', 'Profile Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('14', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FObstacle%20Avoidance%202.jpg?alt=media&token=59dabd87-4089-415b-8e01-176ea2b3770f', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('14', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FObstacle%20Avoidance%203.jpg?alt=media&token=67c1dd5b-c78f-4d87-8e71-950b15f1f980', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('15', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FChicanes%201.jpg?alt=media&token=afb24939-f021-48d7-bc02-8e1ac647818b', 'Profile Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('15', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FChicanes%202.jpg?alt=media&token=e577e425-3faf-4c17-be5a-9cf3291d0144', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('15', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FChicanes%203.jpg?alt=media&token=8abe39b2-95ce-48be-b9ee-54f6e596189f', 'Rolling Image');
INSERT INTO MapImage (mapId, link, note) VALUES ('15', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fmaps%2FChicanes%204.jpg?alt=media&token=3cd4c729-fb9d-425c-aaca-f20250f604dc', 'Rolling Image');

--ROUND INSERTION
INSERT INTO [Round] (tournamentId, startTime, endTime, note, status) VALUES ('6', '', '', 'Kick-Start', '4');
INSERT INTO [Round] (tournamentId, startTime, endTime, note, status) VALUES ('6', '', '', 'Accelarate', '4');
INSERT INTO [Round] (tournamentId, startTime, endTime, note, status) VALUES ('6', '', '', 'Finish', '4');

--RACE INSERTION
INSERT INTO Race (roundId, umpireId, mapId, startTime, endTime, note, status) VALUES ('1', '1', '3', '', '', 'Race 1.1', '4');
INSERT INTO Race (roundId, umpireId, mapId, startTime, endTime, note, status) VALUES ('1', '1', '3', '', '', 'Race 1.2', '4');
INSERT INTO Race (roundId, umpireId, mapId, startTime, endTime, note, status) VALUES ('1', '1', '3', '', '', 'Race 1.3', '4');
INSERT INTO Race (roundId, umpireId, mapId, startTime, endTime, note, status) VALUES ('1', '1', '3', '', '', 'Race 1.4', '4');
INSERT INTO Race (roundId, umpireId, mapId, startTime, endTime, note, status) VALUES ('2', '2', '8', '', '', 'Race 2.1', '4');
INSERT INTO Race (roundId, umpireId, mapId, startTime, endTime, note, status) VALUES ('2', '2', '8', '', '', 'Race 2.2', '4');
INSERT INTO Race (roundId, umpireId, mapId, startTime, endTime, note, status) VALUES ('2', '2', '8', '', '', 'Race 2.3', '4');
INSERT INTO Race (roundId, umpireId, mapId, startTime, endTime, note, status) VALUES ('2', '3', '8', '', '', 'Race 2.4', '4');
INSERT INTO Race (roundId, umpireId, mapId, startTime, endTime, note, status) VALUES ('2', '3', '8', '', '', 'Race 2.5', '4');
INSERT INTO Race (roundId, umpireId, mapId, startTime, endTime, note, status) VALUES ('2', '3', '8', '', '', 'Race 2.6', '4');
INSERT INTO Race (roundId, umpireId, mapId, startTime, endTime, note, status) VALUES ('3', '4', '14', '', '', 'Race 3.1', '4');
INSERT INTO Race (roundId, umpireId, mapId, startTime, endTime, note, status) VALUES ('3', '4', '14', '', '', 'Race 3.2', '4');
INSERT INTO Race (roundId, umpireId, mapId, startTime, endTime, note, status) VALUES ('3', '4', '14', '', '', 'Race 3.3', '4');

--TEAM INSERTION
INSERT INTO Team (schoolTourId, teamName, avatar, description, status) VALUES ('1', 'Speed Demons', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fteams%2FSpeed%20Demon.png?alt=media&token=c10ce563-1366-492c-bc7e-fc2fe5584780', 'Speed Demon Racing Team is a formidable contender in the world of car racing competitions, known for their cutting-edge technology, strategic prowess, and unyielding determination. Comprising a diverse group of individuals, including seasoned drivers with a knack for high speeds, Speed Demon has carved out a reputation for excellence on the track.', '0');
INSERT INTO Team (schoolTourId, teamName, avatar, description, status) VALUES ('1', 'Nitro Knight', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fteams%2FNitro%20Knight.png?alt=media&token=f5205715-9691-439f-b115-a00b09b41402', 'Nitro Knight is a dynamic and formidable team in the world of remote control car competitions, known for their precision, speed, and innovative strategies. Comprising a group of passionate RC car enthusiasts, Nitro Knight has quickly risen through the ranks to become a crowd favorite. The team drivers possess exceptional skills, maneuvering their high-speed vehicles through complex tracks with agility and finesse.', '0');
INSERT INTO Team (schoolTourId, teamName, avatar, description, status) VALUES ('1', 'Track Titan', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fteams%2FTrack%20Titan.png?alt=media&token=6f9a57b4-4495-4598-84ed-7c6f871e076c', 'Track Titan emerges as a powerhouse in the realm of remote control car racing, commanding attention with their blend of technical prowess and strategic brilliance. This team, composed of skilled racers and ingenious engineers, has earned a reputation for transforming every race into a showcase of innovation and determination.', '0');
INSERT INTO Team (schoolTourId, teamName, avatar, description, status) VALUES ('1', 'Marvels', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fteams%2FMarvels.png?alt=media&token=3d0d63ef-7293-446a-b36e-ba259231da2d', 'Marvels Racing Team is a vibrant and emerging force in the remote control car competition scene, quickly becoming known for their creativity, enthusiasm, and spirited approach to the sport. This team, consisting of avid RC enthusiasts and talented hobbyists, brings a fresh and innovative perspective to each race, combining a deep love for RC cars with a flair for dramatic and strategic racing.', '0');
INSERT INTO Team (schoolTourId, teamName, avatar, description, status) VALUES ('2', 'Thunder Track', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fteams%2FThunder%20Track.png?alt=media&token=044f37d5-49f9-4297-a14f-65798a972a53', 'Thunder Track is an electrifying presence in the remote control car racing circuit, known for their explosive speed and thunderous performance on the track. This team combines seasoned racers with adept engineers, creating a formidable alliance that strikes awe and admiration in the hearts of competitors and spectators alike.', '0');
INSERT INTO Team (schoolTourId, teamName, avatar, description, status) VALUES ('2', 'Apex', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fteams%2FApex.png?alt=media&token=464eec29-61de-4a1f-a06a-aff1157ab05f', 'Apex Racing is a distinguished name in car racing competitions, embodying excellence, resilience, and strategic mastery. This team is composed of elite drivers who possess an innate ability to navigate the complexities of the racetrack, showcasing exceptional talent in maneuvering and speed control.', '0');
INSERT INTO Team (schoolTourId, teamName, avatar, description, status) VALUES ('2', 'Asphalt Aces', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fteams%2FAsphalt%20Aces.png?alt=media&token=0e0020e1-74cd-4165-80c5-7f0b9467b300', 'Asphalt Aces is a distinguished team in the remote control car racing world, revered for their masterful command of speed and precision on the track. This team, comprised of elite drivers and visionary engineers, has carved out a reputation for excellence in the competitive RC racing scene.', '0');
INSERT INTO Team (schoolTourId, teamName, avatar, description, status) VALUES ('2', 'Dashers', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fteams%2FDashers.png?alt=media&token=bc2b8075-737a-4163-b06a-f23e64518cf8', 'Dashers RC Racing Team is a dynamic and spirited group that has quickly become a standout contender in the remote control car competition circuit. Known for their swift maneuvers and lightning-fast reflexes, the Dashers bring a level of excitement and energy to every race they participate in.', '0');
INSERT INTO Team (schoolTourId, teamName, avatar, description, status) VALUES ('3', 'Gladiators', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fteams%2FGladiators.png?alt=media&token=36f5ece4-c839-4ea1-a003-0c871741a4e2', 'The Gladiators RC Racing Team stands as a formidable force in the world of remote control car competitions, embodying strength, resilience, and strategic mastery on the racetrack. Composed of seasoned racers and skilled engineers, the Gladiators are celebrated for their tactical approach to racing, leveraging not just raw speed but also precision and adaptability to outmaneuver their opponents and dominate the competition.', '0');
INSERT INTO Team (schoolTourId, teamName, avatar, description, status) VALUES ('3', 'Drift Dynamos', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fteams%2FDrift%20Dynamos.png?alt=media&token=27039b29-1623-472a-9576-0411b6920f5d', 'Drift Dynamos is a thrilling force to be reckoned with in the remote control car competition circuit, particularly celebrated for their exceptional skill in the art of RC drifting. This team, composed of highly skilled drivers and innovative technicians, specializes in mastering the precision and control required to execute flawless drifts around the most demanding of corners.', '0');
INSERT INTO Team (schoolTourId, teamName, avatar, description, status) VALUES ('3', 'Throttle Thrashers', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fteams%2FThrottle%20Thrashers.png?alt=media&token=3b6b8524-70a5-47b3-9b54-d4d8cc917bcd', 'Throttle Thrashers is an adrenaline-fueled powerhouse in the remote control car racing scene, known for their high-octane performances and relentless pursuit of speed. This team, comprising some of the most daring and skilled drivers, alongside a crew of innovative engineers, has quickly risen to prominence for their fearless racing style and technical prowess.', '0');
INSERT INTO Team (schoolTourId, teamName, avatar, description, status) VALUES ('3', 'AceX', 'https://firebasestorage.googleapis.com/v0/b/carx-swd392.appspot.com/o/images%2Fteams%2FAceX.png?alt=media&token=836449e1-7ecc-41a2-940c-32dfe6c1cd74', 'AceX Racing Team is a standout competitor in the arena of car race competitions, renowned for their exceptional skill, precision, and innovation. This team brings together a highly skilled ensemble of professional drivers known for their sharp reflexes and strategic racing techniques, alongside a crew of brilliant engineers who push the boundaries of automotive technology.', '0');

--MEMBER INSERTION
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('1', '1', '6', 'Leader', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('2', '1', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('3', '1', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('4', '1', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('5', '2', '6', 'Leader', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('6', '2', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('7', '2', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('8', '2', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('9', '3', '6', 'Leader', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('10', '3', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('11', '3', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('12', '3', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('13', '4', '6', 'Leader', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('14', '4', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('15', '4', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('16', '4', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('17', '5', '6', 'Leader', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('18', '5', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('19', '5', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('20', '5', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('21', '6', '6', 'Leader', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('22', '6', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('23', '6', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('24', '6', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('25', '7', '6', 'Leader', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('26', '7', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('27', '7', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('28', '7', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('29', '8', '6', 'Leader', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('30', '8', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('31', '8', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('32', '8', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('33', '9', '6', 'Leader', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('34', '9', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('35', '9', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('36', '9', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('37', '10', '6', 'Leader', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('38', '10', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('39', '10', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('40', '10', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('41', '11', '6', 'Leader', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('42', '11', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('43', '11', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('44', '11', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('45', '12', '6', 'Leader', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('46', '12', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('47', '12', '6', '', '0');
INSERT INTO Member (studentId, teamId, tournamentId, note, status) VALUES ('48', '12', '6', '', '0');

--CAR INSERTION
INSERT INTO Car (teamId, carTypeId, carName, description, createDate, status) VALUES ('1', '5', 'Solaris', 'The Solaris Sprint embodies the fusion of innovation and agility. Designed for those who seek the thrill of speed with the sustainability of solar energy, this car is a beacon of futuristic travel. Its sleek design and advanced solar panels ensure an eco-friendly journey without compromising on performance.', '02/25/2024', '0');
INSERT INTO Car (teamId, carTypeId, carName, description, createDate, status) VALUES ('2', '6', 'Vortex', 'With a name that conjures images of power and speed, the Thunderbolt Vortex is engineered for the adrenaline junkie. Its turbocharged engine delivers unmatched acceleration, making every drive an electrifying experience. This car doesnt just travel; it dominates the road with a roar that echoes its name.', '02/25/2024', '0');
INSERT INTO Car (teamId, carTypeId, carName, description, createDate, status) VALUES ('3', '2', 'Nebula', 'The Nebula Navigator is your companion for exploration, designed for the adventurous spirit. With its all-terrain capabilities and advanced navigation systems, it promises to take you where no car has gone before. The Navigator is not just a car; its a promise of uncharted adventures.', '02/25/2024', '0');
INSERT INTO Car (teamId, carTypeId, carName, description, createDate, status) VALUES ('4', '4', 'Quantum', 'The Quantum Quest represents the pinnacle of automotive technology. Its cutting-edge design and quantum computing capabilities offer a driving experience thats not just about getting from A to B, but doing so with unparalleled efficiency and intelligence. The Quest is for those who look to the future.', '02/25/2024', '0');
INSERT INTO Car (teamId, carTypeId, carName, description, createDate, status) VALUES ('5', '9', 'Eclipse', 'Elegant and mysterious, the Eclipse Endeavor captures the essence of the celestial event its named after. Its design is a harmonious blend of beauty and mystery, offering a driving experience that feels like gliding through the night sky. The Endeavor is for those who appreciate the finer things in life.', '02/25/2024', '0');
INSERT INTO Car (teamId, carTypeId, carName, description, createDate, status) VALUES ('6', '3', 'Halo', 'Bright, bold, and beautiful, the Horizon Halo is inspired by the first light of dawn. Its designed for optimists who see every day as a new opportunity. With its eco-friendly engine and radiant design, the Halo is a symbol of hope and renewal on the road.', '02/25/2024', '0');
INSERT INTO Car (teamId, carTypeId, carName, description, createDate, status) VALUES ('7', '1', 'Celestial', 'Fast, fiery, and fleeting, the Celestial Comet is designed for those who live in the moment. Its powerful engine and aerodynamic shape make it a marvel of speed, leaving a trail of awe in its wake. The Comet is for the daring, those who chase the extraordinary.', '02/25/2024', '0');
INSERT INTO Car (teamId, carTypeId, carName, description, createDate, status) VALUES ('8', '1', 'Phantom', 'Mysterious and majestic, the Phantom Pinnacle represents the zenith of luxury. With its whisper-quiet engine and sumptuous interiors, driving the Pinnacle is like moving in a dream. Its the car for those who command elegance and sophistication.', '02/25/2024', '0');
INSERT INTO Car (teamId, carTypeId, carName, description, createDate, status) VALUES ('9', '6', 'Maverick', 'The Mirage Maverick is for the unconventional, the rebels who chart their own path. With its unique design and innovative features, it challenges the status quo and turns heads wherever it goes. The Maverick isnt just a car; its a statement.', '02/25/2024', '0');
INSERT INTO Car (teamId, carTypeId, carName, description, createDate, status) VALUES ('10', '7', 'Aero', 'Sleek, swift, and sophisticated, the Aero Apex cuts through the air with grace and precision. Its aerodynamic design and powerful engine are a testament to the beauty of speed. The Apex is for those who seek performance in its most elegant form.', '02/25/2024', '0');
INSERT INTO Car (teamId, carTypeId, carName, description, createDate, status) VALUES ('11', '8', 'Trek', 'Robust and reliable, the Titan Trek is built for the long haul. Its sturdy build and advanced safety features provide peace of mind on every journey. The Trek is a fortress on wheels, for those who value strength and durability.', '02/25/2024', '0');
INSERT INTO Car (teamId, carTypeId, carName, description, createDate, status) VALUES ('12', '9', 'Galactic', 'The Galactic Glide is inspired by the vastness of space, designed for those who dream big. Its smooth ride and spacious interior make every journey feel like a voyage among the stars. The Glide is for dreamers, explorers, and anyone who believes in the infinite possibilities of the road ahead.', '02/25/2024', '0');

--CAR IN RACE INSERTION
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('1', '1', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('2', '1', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('3', '1', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('4', '2', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('5', '2', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('6', '2', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('7', '3', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('8', '3', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('9', '3', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('10', '4', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('11', '4', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('12', '4', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('1', '5', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('2', '5', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('3', '6', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('4', '6', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('5', '7', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('6', '7', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('7', '8', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('8', '8', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('9', '9', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('10', '9', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('11', '10', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('12', '10', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('1', '11', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('2', '11', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('3', '11', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('4', '11', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('5', '12', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('6', '12', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('7', '12', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('8', '12', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('9', '13', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('10', '13', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('11', '13', '', '', '', '', '', '', '4');
INSERT INTO CarInRace (teamId, raceId, startTime, endTime, bonus, penalty, score, racePosition, status) VALUES ('12', '13', '', '', '', '', '', '', '4');

--ACCOUNT INSERT
INSERT INTO Account (username, password, roleId, createDate, note, status) VALUES ('admin123', 'admin123', '3', '02/27/2024', 'test', '0');
INSERT INTO Account (username, password, roleId, createDate, note, status) VALUES ('schoolassistant', 'schoolassistant', '2', '02/27/2024', 'test', '0');
INSERT INTO Account (username, password, roleId, createDate, note, status) VALUES ('umpire123', 'umpire123', '1', '02/27/2024', 'test', '0');
