--자유게시판 댓글
create table freeboard_comment
(
    comment_seq        NUMBER           NOT NULL, 
    board_seq          NUMBER           NOT NULL, 
    board_id           VARCHAR2(20)     NOT NULL, 
    comment_content    VARCHAR2(100)    NOT NULL, 
    comment_ref        NUMBER           NOT NULL, 
    comment_lev        NUMBER           NOT NULL, 
    comment_step       NUMBER           NOT NULL, 
    comment_pseq       NUMBER           NOT NULL, 
    logtime            DATE             NOT NULL
);

--시퀀스 객체
create sequence freeboard_comment_seq nocache nocycle;