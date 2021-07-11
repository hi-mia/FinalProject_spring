--팔로우
create table follow
(
    follow_seq      NUMBER          NOT NULL, --팔로우번호
    member_id       VARCHAR2(20)    NOT NULL, --회원아이디(팔로우받는쪽)
		member_manner   NUMBER          NOT NULL, --회원매너등급
    follow_id       VARCHAR2(20)    NOT NULL  --팔로우 등록한 아이디
);

--시퀀스 객체
create sequence seq_follow nocache nocycle;