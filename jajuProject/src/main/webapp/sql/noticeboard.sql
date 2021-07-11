--공지게시판
create table noticeboard
(
		notice_seq       NUMBER           primary key,
		notice_subject   VARCHAR2(255)    NOT NULL,
		notice_content   VARCHAR2(4000)   NOT NULL,
		image0           VARCHAR2(200),
		image1           VARCHAR2(200),
		image2           VARCHAR2(200),
		image3           VARCHAR2(200),
		image4           VARCHAR2(200),
		image5           VARCHAR2(200),
		image6           VARCHAR2(200),
		image7           VARCHAR2(200),
		image8           VARCHAR2(200),
		image9           VARCHAR2(200),
		logtime          DATE
);

--시퀀스 객체
create sequence seq_noticeboard nocache nocycle;