--자유게시판
create table freeboard
(
		board_seq       NUMBER,
		board_id        VARCHAR2(20)                  NOT NULL,
		board_subject   VARCHAR2(1000)                NOT NULL,
		board_content   VARCHAR2(4000)                NOT NULL,
		image1          VARCHAR2(1000),
		image2          VARCHAR2(1000),
		image3          VARCHAR2(1000),
		board_hit       NUMBER            DEFAULT 0   NOT NULL,
		logtime         DATE                          NOT NULL
);

--시퀀스 객체
create sequence seq_freeboard nocache nocycle;