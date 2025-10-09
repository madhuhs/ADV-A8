
SELECT * FROM hms.hotel_room_info;

insert into hms.hotel_room_info values(
1,2,'city1','c1','india',1,'hotel@gmail.com','fax1','909090901','8981','1',1
);

insert into hms.hotel_room_info values(
2,2,'city1','c1','india',1,'hotel@gmail.com','fax1','909090901','8981','1',1
                                      );

insert into hms.hotel_room_info values(
3,2,'city1','c1','india',1,'hotel@gmail.com','fax1','909090901','8981','1',1
                                      );

SELECT * FROM hms.hotel_room_info;

insert into hms.hotel_room_info values(1,4,4,2,5000,'Normal',1);
insert into hms.hotel_room_info values(2,4,4,2,5000,'Normal',1);

insert into hms.hotel_room_info values(3,4,4,2,5000,'Normal',2);
insert into hms.hotel_room_info values(4,4,4,2,5000,'Normal',2);

insert into hms.hotel_room_info values(5,4,4,2,5000,'Normal',3);
insert into hms.hotel_room_info values(6,4,4,2,5000,'Normal',3);


select * from hotel_info_hotel_room_info_entity_list;

insert into hotel_info_hotel_room_info_entity_list values(1,1);
insert into hotel_info_hotel_room_info_entity_list values(1,2);

insert into hotel_info_hotel_room_info_entity_list values(2,3);
insert into hotel_info_hotel_room_info_entity_list values(2,4);

insert into hotel_info_hotel_room_info_entity_list values(3,5);
insert into hotel_info_hotel_room_info_entity_list values(3,6);

