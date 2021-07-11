--찜목록
create table scrap
(
    scrap_seq       NUMBER         NOT NULL, --찜번호
    member_id       VARCHAR2(20)   NOT NULL, --회원아이디
    scrap_date      DATE           NOT NULL, --스크랩일자
    sale_seq        NUMBER         NOT NULL --원글)상품글번호
    
);

--시퀀스 객체
create sequence seq_scrap nocache nocycle;
