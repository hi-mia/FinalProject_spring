--회원가입
create table jajumember
(
    member_seq           NUMBER                                  NOT NULL, 
    member_id            VARCHAR2(20)                            NOT NULL, 
    member_pwd           VARCHAR2(30), 
    member_name          VARCHAR2(30)                            NOT NULL,  
    member_email         VARCHAR2(100)                           NOT NULL, 
    member_telephone     VARCHAR2(30), 
	  member_sido          VARCHAR2(50)                            NOT NULL, --시도
    member_sigungu       VARCHAR2(50)                            NOT NULL, --시군구
		member_address       VARCHAR2(100)                            NOT NULL,
    member_detailAddr    VARCHAR2(100)                           NOT NULL, --상세주소
    member_gender        VARCHAR2(20)    DEFAULT 'n'             NOT NULL,
	  member_manner        NUMBER          DEFAULT 36.5            NOT NULL, --리뷰평점
    member_warning       NUMBER          DEFAULT 0               NOT NULL, --경고누적횟수
    member_state         VARCHAR2(20)    DEFAULT 0               NOT NULL, --0: 일반회원  1:활동중지  2: 강제탈퇴 
    member_image         VARCHAR2(1000)  DEFAULT 'profile.jpg',            --이미지
    member_date          DATE            DEFAULT sysdate         NOT NULL
);

--시퀀스 객체
create sequence seq_jajumember nocache nocycle;