--쪽지
create table message
(
    message_seq        NUMBER            NOT NULL, --쪽지번호
    message_reader     VARCHAR2(20)      NOT NULL, --받는사람 아이디
    message_writer     VARCHAR2(20)      NOT NULL, --보내는사람 아이디
    message_subject    VARCHAR2(100)     NOT NULL, --제목
    message_content    VARCHAR2(1000)    NOT NULL, --내용
    message_date       DATE              NOT NULL, --날짜
    sale_seq           NUMBER            NOT NULL, --판매글 번호
    message_change     VARCHAR2(5)       NOT NULL  --상태표시변수
);

--시퀀스 객체
create sequence seq_message nocache nocycle;