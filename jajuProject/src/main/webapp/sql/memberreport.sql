--사용자 신고
create table memberreport
(
		sale_seq          NUMBER                              NOT NULL, --신고 글번호
		sale_id           VARCHAR2(20)                        NOT NULL, --신고 아이디
		report_seq        NUMBER                              NOT NULL, --글번호
		report_id         VARCHAR2(20)                        NOT NULL, --아이디
		report_name       VARCHAR2(50)                        NOT NULL, --이름
		reportType        VARCHAR2(50)                        NOT NULL, --신고 유형
		report_tal        VARCHAR2(40)                        NOT NULL, --전화번호
		report_subject    VARCHAR2(255)                       NOT NULL, --신고 제목
		report_content    VARCHAR2(4000)                      NOT NULL, --신고 내용
		report_image1     VARCHAR2(200),                                --이미지
		report_image2     VARCHAR2(200),
		report_image3     VARCHAR2(200),
		report_state      VARCHAR2(20)     DEFAULT '처리중'   NOT NULL, --처리 상태
		logtime           DATE                                         --시간
);

--시퀀스 객체
create sequence seq_memberReport nocache nocycle;