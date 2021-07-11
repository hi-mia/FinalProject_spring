--내 동네 설정
create table location
(
		location_id       VARCHAR2(20)   NOT NULL, --아이디
		location1_addr1   VARCHAR2(50)   NOT NULL, --지역1 (시,도)
		location1_addr2   VARCHAR2(50)   NOT NULL, --지역1 (시,군,구)
		location2_addr1   VARCHAR2(50),            --지역2 (시,도)
		location2_addr2   VARCHAR2(50),            --지역2 (시,군,구)
		location3_addr1   VARCHAR2(50),            --지역3 (시,도)
		location3_addr2   VARCHAR2(50)             --지역3 (시,군,구)
); 
