
--자주묻는 질문
create table question
(
		question_seq        NUMBER,
		question_subject    VARCHAR2(255)    NOT NULL,
		question_content    VARCHAR2(4000)   NOT NULL,
		questionType        VARCHAR2(50)     NOT NULL, --카테고리
		question_image1     VARCHAR2(200),
		question_image2     VARCHAR2(200),
		question_image3     VARCHAR2(200),
		logtime             DATE
);

--시퀀스 객체
create sequence seq_question nocache nocycle;