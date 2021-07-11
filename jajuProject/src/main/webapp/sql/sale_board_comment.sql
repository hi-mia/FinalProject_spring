--판매게시판 댓글
create table sale_board_comment
(
    comment_seq        NUMBER           NOT NULL, 
    sale_seq           NUMBER           NOT NULL, 
    member_id          VARCHAR2(20)     NOT NULL, 
    comment_content    VARCHAR2(1000)    NOT NULL, 
    comment_ref        NUMBER           NOT NULL, 
    comment_lev        NUMBER           NOT NULL, 
    comment_step       NUMBER           NOT NULL, 
    comment_pseq       NUMBER           NOT NULL, 
    logtime            DATE             NOT NULL
);





--시퀀스 객체
create sequence sale_board_comment_seq nocache nocycle;