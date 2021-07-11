--판매게시판
create table sale_board
(
    sale_seq           NUMBER 	                     NOT NULL, 
    sale_state         VARCHAR2(20)	                 NOT NULL, 
    sale_subject       VARCHAR2(1000)           	   NOT NULL,
    sale_price         NUMBER 	                     NOT NULL, 
    sale_nego          VARCHAR2(5), 
    sale_category      VARCHAR2(20) 		             NOT NULL, 
    sale_condition     VARCHAR2(20) 		             NOT NULL,
    sale_direct        VARCHAR2(5), 
    sale_delivery      VARCHAR2(5), 
    sale_onlineTran    VARCHAR2(5), 
    sale_content       VARCHAR2(4000) 	             NOT NULL,
    member_id          VARCHAR2(20) 		             NOT NULL,
    sale_hit           NUMBER           DEFAULT 0 	 NOT NULL, 
    sale_date          DATE 		                     NOT NULL, 
    sale_hide          VARCHAR2(5), 
    sale_buyer         VARCHAR2(20),
    sale_image1        VARCHAR2(1000) 		           NOT NULL, 
    sale_image2        VARCHAR2(1000) 		           NOT NULL, 
		sale_image3        VARCHAR2(1000), 
    sale_image4        VARCHAR2(1000), 
		sale_image5        VARCHAR2(1000), 
    sale_image6        VARCHAR2(1000), 
		sale_image7        VARCHAR2(1000), 
    sale_image8        VARCHAR2(1000),
		sale_image9        VARCHAR2(1000), 
    sale_image10       VARCHAR2(1000) 		
);

--시퀀스 객체
create sequence sale_seq_sale_board  nocache nocycle;