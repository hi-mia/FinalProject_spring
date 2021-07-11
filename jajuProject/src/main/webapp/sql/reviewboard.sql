--후기 게시판
create table reviewboard
(
    review_seq 	      NUMBER                      NOT NULL, --리뷰번호
    sale_seq          NUMBER                      NOT NULL, --상품글 번호
    sale_image1       VARCHAR2(20)                NOT NULL, --판매글 첫번째 이미지
    member_id         VARCHAR2(20)                NOT NULL, --리뷰대상 아이디
    review_id         VARCHAR2(20)                NOT NULL, --리뷰하는 아이디(구매자)
    sale_subject      VARCHAR2(1000)              NOT NULL, --판매글 제목
    review_subject    VARCHAR2(1000)              NOT NULL, --리뷰글 제목
    review_content    VARCHAR2(4000)              NOT NULL, --글내용
    review_image1     VARCHAR2(1000),                       --리뷰글 이미지1
    review_image2     VARCHAR2(1000),
    review_image3     VARCHAR2(1000),
    review_manner     VARCHAR2(20)                NOT NULL, --리뷰평점
    review_date       DATE                        NOT NULL, --날짜
    review_hit        NUMBER          DEFAULT 0   NOT NULL  --리뷰 글 조회수
);

--시퀀스 객체
create sequence review_seq nocache nocycle;