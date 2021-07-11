
--사용자 신고 댓글
create table reportcomment
(
		report_seq        NUMBER, 
		comment_seq       NUMBER,
		comment_content   VARCHAR2(3000),
		logtime           DATE
);

--시퀀스 객체
create sequence seq_reportcomment nocache nocycle;