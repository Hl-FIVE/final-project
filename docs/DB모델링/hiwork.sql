
-- 게시글 정보
DROP TABLE IF EXISTS cms_bList RESTRICT;

-- 회사정보
DROP TABLE IF EXISTS cms_cInfo RESTRICT;

-- 팀 목록
DROP TABLE IF EXISTS cms_tList RESTRICT;

-- 사원
DROP TABLE IF EXISTS cms_worker RESTRICT;

-- 권한
DROP TABLE IF EXISTS cms_auth RESTRICT;

-- 휴가 신청
DROP TABLE IF EXISTS cms_vApp RESTRICT;

-- 휴가 종류 
DROP TABLE IF EXISTS cms_vKind RESTRICT;

-- 댓글 정보
DROP TABLE IF EXISTS cms_cmtInfo RESTRICT;

-- 대화방
DROP TABLE IF EXISTS cms_cRoom RESTRICT;

-- 일정
DROP TABLE IF EXISTS cms_calender RESTRICT;

-- 게시판
DROP TABLE IF EXISTS cms_board RESTRICT;

-- 대화
DROP TABLE IF EXISTS cms_chat RESTRICT;

-- 대화방참여자
DROP TABLE IF EXISTS cms_cGroup RESTRICT;

-- 아마존 인코딩
alter table cms_auth convert to character set utf8;
alter table cms_bList convert to character set utf8;
alter table cms_board convert to character set utf8;
alter table cms_cGroup convert to character set utf8;
alter table cms_cInfo convert to character set utf8;
alter table cms_cRoom convert to character set utf8;
alter table cms_calender convert to character set utf8;
alter table cms_chat convert to character set utf8;
alter table cms_cmtInfo convert to character set utf8;
alter table cms_tList convert to character set utf8;
alter table cms_vApp convert to character set utf8;
alter table cms_vKind convert to character set utf8;
alter table cms_worker convert to character set utf8;


-- 게시글 정보
CREATE TABLE cms_bList (
  bNo      INTEGER     NOT NULL COMMENT '게시글번호', -- 게시글번호
  bNo2     INTEGER     NOT NULL COMMENT '게시판번호', -- 게시판번호
  wNo      INTEGER     NOT NULL COMMENT '사원 번호', -- 사원 번호
  title    VARCHAR(50) NOT NULL COMMENT '제목', -- 제목
  regiDate DATE        NOT NULL COMMENT '등록일', -- 등록일
  vCount   INTEGER     NOT NULL COMMENT '조회수', -- 조회수
  aFile    VARCHAR(50) NULL     COMMENT '첨부파일명', -- 첨부파일명
  fSize    INTEGER     NULL     COMMENT '첨부파일 용량', -- 첨부파일 용량
  content  MEDIUMTEXT  NULL     COMMENT '글내용' -- 글내용
)
COMMENT '게시글 정보';

-- 게시글 정보
ALTER TABLE cms_bList
  ADD CONSTRAINT PK_cms_bList -- 게시글 정보 기본키
    PRIMARY KEY (
      bNo -- 게시글번호
    );

ALTER TABLE cms_bList
  MODIFY COLUMN bNo INTEGER NOT NULL AUTO_INCREMENT COMMENT '게시글번호';

-- 회사정보
CREATE TABLE cms_cInfo (
  crNo   INTEGER      NOT NULL COMMENT '법인등록번호', -- 법인등록번호
  cName  VARCHAR(50)  NOT NULL COMMENT '회사명', -- 회사명
  map    MEDIUMTEXT   NOT NULL COMMENT '지도', -- 지도
  postNo INTEGER      NOT NULL COMMENT '우편번호', -- 우편번호
  addr   VARCHAR(255) NOT NULL COMMENT '주소', -- 주소
  tel    VARCHAR(30)  NOT NULL COMMENT '전화번호', -- 전화번호
  fax    VARCHAR(30)  NOT NULL COMMENT '팩스번호' -- 팩스번호
)
COMMENT '회사정보';

-- 회사정보
ALTER TABLE cms_cInfo
  ADD CONSTRAINT PK_cms_cInfo -- 회사정보 기본키
    PRIMARY KEY (
      crNo -- 법인등록번호
    );

-- 팀 목록
CREATE TABLE cms_tList (
  tCode VARCHAR(20) NOT NULL COMMENT '팀 코드', -- 팀 코드
  crNo  INTEGER     NOT NULL COMMENT '법인등록번호', -- 법인등록번호
  tName VARCHAR(50) NOT NULL COMMENT '팀 부서' -- 팀 부서
)
COMMENT '팀 목록';

-- 팀 목록
ALTER TABLE cms_tList
  ADD CONSTRAINT PK_cms_tList -- 팀 목록 기본키
    PRIMARY KEY (
      tCode -- 팀 코드
    );

-- 사원
CREATE TABLE cms_worker (
  wNo      INTEGER      NOT NULL COMMENT '사원 번호', -- 사원 번호
  aCode    INTEGER      NOT NULL COMMENT '권한 코드', -- 권한 코드
  tCode    VARCHAR(20)  NULL     COMMENT '팀 코드', -- 팀 코드
  wName    VARCHAR(50)  NOT NULL COMMENT '사원이름', -- 사원이름
  email    VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
  wPhoto   VARCHAR(255) NOT NULL COMMENT '사원사진', -- 사원사진
  rank     MEDIUMTEXT   NOT NULL COMMENT '직급', -- 직급
  eType    MEDIUMTEXT   NOT NULL COMMENT '고용형태', -- 고용형태
  regiDate DATE         NOT NULL COMMENT '입사일', -- 입사일
  tel      INTEGER      NOT NULL COMMENT '휴대폰번호', -- 휴대폰번호
  gender   INTEGER      NOT NULL COMMENT '성별', -- 성별
  tAnnu    INTEGER      NOT NULL COMMENT '총 연차', -- 총 연차
  pwd      INTEGER      NOT NULL COMMENT '비밀번호', -- 비밀번호
  eSt      INTEGER      NOT NULL COMMENT '재직 상태' -- 재직 상태
)
COMMENT '사원';

-- 사원
ALTER TABLE cms_worker
  ADD CONSTRAINT PK_cms_worker -- 사원 기본키
    PRIMARY KEY (
      wNo -- 사원 번호
    );

-- 이메일
CREATE UNIQUE INDEX UIX_cms_worker
  ON cms_worker ( -- 사원
    email ASC -- 이메일
  );

-- 휴대폰번호
CREATE UNIQUE INDEX UIX_cms_worker2
  ON cms_worker ( -- 사원
    tel ASC -- 휴대폰번호
  );

ALTER TABLE cms_worker
  MODIFY COLUMN wNo INTEGER NOT NULL AUTO_INCREMENT COMMENT '사원 번호';

-- 권한
CREATE TABLE cms_auth (
  aCode INTEGER     NOT NULL COMMENT '권한 코드', -- 권한 코드
  name  VARCHAR(50) NOT NULL COMMENT '권한명' -- 권한명
)
COMMENT '권한';

-- 권한
ALTER TABLE cms_auth
  ADD CONSTRAINT PK_cms_auth -- 권한 기본키
    PRIMARY KEY (
      aCode -- 권한 코드
    );

-- 권한 유니크 인덱스
CREATE UNIQUE INDEX UIX_cms_auth
  ON cms_auth ( -- 권한
    name ASC -- 권한명
  );

-- 휴가 종류 
CREATE TABLE cms_vKind (
  vCode VARCHAR(20) NOT NULL COMMENT '휴가 코드', -- 휴가 코드
  name  VARCHAR(50) NOT NULL COMMENT '휴가명' -- 휴가명
)
COMMENT '휴가 종류 ';

-- 휴가 종류 
ALTER TABLE cms_vKind
  ADD CONSTRAINT PK_cms_vKind -- 휴가 종류  기본키
    PRIMARY KEY (
      vCode -- 휴가 코드
    );
    
-- 휴가 신청
ALTER TABLE cms_vApp
  ADD CONSTRAINT PK_cms_vApp -- 휴가 신청 기본키
    PRIMARY KEY (
      vNo -- 휴가신청번호
    );
    
-- 휴가 신청
CREATE TABLE cms_vApp (
  vNo   INTEGER     NOT NULL COMMENT '휴가신청번호', -- 휴가신청번호
  vCode VARCHAR(20) NOT NULL COMMENT '휴가 코드', -- 휴가 코드
  wNo   INTEGER     NOT NULL COMMENT '사원 번호', -- 사원 번호
  adt   DATE        NOT NULL COMMENT '신청일', -- 신청일
  sdt   DATE        NOT NULL COMMENT '시작일', -- 시작일
  edt   DATE        NOT NULL COMMENT '종료일', -- 종료일
  used  INTEGER     NOT NULL COMMENT '사용연차일수', -- 사용연차일수
  rs    MEDIUMTEXT  NOT NULL COMMENT '신청사유', -- 신청사유
  appr  MEDIUMTEXT  NOT NULL COMMENT '승인여부' -- 승인여부
)
COMMENT '휴가 신청';



-- 댓글 정보
CREATE TABLE cms_cmtInfo (
  cCode   VARCHAR(20) NOT NULL COMMENT '댓글 코드', -- 댓글 코드
  bNo     INTEGER     NOT NULL COMMENT '게시글번호', -- 게시글번호
  list    INTEGER     NOT NULL COMMENT '순서', -- 순서
  stage   INTEGER     NOT NULL COMMENT '단계', -- 단계
  content MEDIUMTEXT  NOT NULL COMMENT '내용', -- 내용
  rdt     DATE        NOT NULL COMMENT '등록일', -- 등록일
  wNo     INTEGER     NOT NULL COMMENT '사원 번호' -- 사원 번호
)
COMMENT '댓글 정보';

-- 댓글 정보
ALTER TABLE cms_cmtInfo
  ADD CONSTRAINT PK_cms_cmtInfo -- 댓글 정보 기본키
    PRIMARY KEY (
      cCode -- 댓글 코드
    );

-- 대화방
CREATE TABLE cms_cRoom (
  gChatCode INTEGER     NOT NULL COMMENT '대화방번호', -- 대화방번호
  cName     VARCHAR(50) NOT NULL COMMENT '채팅방명', -- 채팅방명
  cExpl     MEDIUMTEXT  NULL     COMMENT '채팅방설명' -- 채팅방설명
)
COMMENT '대화방';

-- 대화방
ALTER TABLE cms_cRoom
  ADD CONSTRAINT PK_cms_cRoom -- 대화방 기본키
    PRIMARY KEY (
      gChatCode -- 대화방번호
    );

-- 일정
CREATE TABLE cms_calender (
  calCode VARCHAR(20)  NOT NULL COMMENT '일정코드', -- 일정코드
  wNo     INTEGER      NOT NULL COMMENT '사원 번호', -- 사원 번호
  title   VARCHAR(50)  NOT NULL COMMENT '제목', -- 제목
  sdt     DATE         NOT NULL COMMENT '시작일', -- 시작일
  edt     DATE         NOT NULL COMMENT '종료일', -- 종료일
  content MEDIUMTEXT   NOT NULL COMMENT '내용', -- 내용
  place   VARCHAR(255) NULL     COMMENT '장소' -- 장소
)
COMMENT '일정';

-- 일정
ALTER TABLE cms_calender
  ADD CONSTRAINT PK_cms_calender -- 일정 기본키
    PRIMARY KEY (
      calCode -- 일정코드
    );

-- 게시판
CREATE TABLE cms_board (
  bNo   INTEGER     NOT NULL COMMENT '게시판번호', -- 게시판번호
  bName VARCHAR(50) NOT NULL COMMENT '게시판명' -- 게시판명
)
COMMENT '게시판';

-- 게시판
ALTER TABLE cms_board
  ADD CONSTRAINT PK_cms_board -- 게시판 기본키
    PRIMARY KEY (
      bNo -- 게시판번호
    );

-- 대화
CREATE TABLE cms_chat (
  cNo       INTEGER     NOT NULL COMMENT '대화번호', -- 대화번호
  wNo       INTEGER     NOT NULL COMMENT '사원 번호', -- 사원 번호
  gChatCode INTEGER     NOT NULL COMMENT '대화방번호', -- 대화방번호
  cContent  MEDIUMTEXT  NOT NULL COMMENT '메시지', -- 메시지
  cName     VARCHAR(50) NOT NULL COMMENT '메시지유형', -- 메시지유형
  cDate     DATE        NOT NULL COMMENT '생성일' -- 생성일
)
COMMENT '대화';

-- 대화
ALTER TABLE cms_chat
  ADD CONSTRAINT PK_cms_chat -- 대화 기본키
    PRIMARY KEY (
      cNo -- 대화번호
    );

-- 대화방참여자
CREATE TABLE cms_cGroup (
  wNo       INTEGER NOT NULL COMMENT '사원 번호', -- 사원 번호
  gChatCode INTEGER NOT NULL COMMENT '대화방번호' -- 대화방번호
)
COMMENT '대화방참여자';

-- 대화방참여자
ALTER TABLE cms_cGroup
  ADD CONSTRAINT PK_cms_cGroup -- 대화방참여자 기본키
    PRIMARY KEY (
      wNo,       -- 사원 번호
      gChatCode  -- 대화방번호
    );

-- 게시글 정보
ALTER TABLE cms_bList
  ADD CONSTRAINT FK_cms_board_TO_cms_bList -- 게시판 -> 게시글 정보
    FOREIGN KEY (
      bNo2 -- 게시판번호
    )
    REFERENCES cms_board ( -- 게시판
      bNo -- 게시판번호
    );

-- 게시글 정보
ALTER TABLE cms_bList
  ADD CONSTRAINT FK_cms_worker_TO_cms_bList -- 사원 -> 게시글 정보
    FOREIGN KEY (
      wNo -- 사원 번호
    )
    REFERENCES cms_worker ( -- 사원
      wNo -- 사원 번호
    );

-- 팀 목록
ALTER TABLE cms_tList
  ADD CONSTRAINT FK_cms_cInfo_TO_cms_tList -- 회사정보 -> 팀 목록
    FOREIGN KEY (
      crNo -- 법인등록번호
    )
    REFERENCES cms_cInfo ( -- 회사정보
      crNo -- 법인등록번호
    );

-- 사원
ALTER TABLE cms_worker
  ADD CONSTRAINT FK_cms_auth_TO_cms_worker -- 권한 -> 사원
    FOREIGN KEY (
      aCode -- 권한 코드
    )
    REFERENCES cms_auth ( -- 권한
      aCode -- 권한 코드
    );

-- 사원
ALTER TABLE cms_worker
  ADD CONSTRAINT FK_cms_tList_TO_cms_worker -- 팀 목록 -> 사원
    FOREIGN KEY (
      tCode -- 팀 코드
    )
    REFERENCES cms_tList ( -- 팀 목록
      tCode -- 팀 코드
    );

-- 휴가 신청
ALTER TABLE cms_vApp
  ADD CONSTRAINT FK_cms_vKind_TO_cms_vApp -- 휴가 종류  -> 휴가 신청
    FOREIGN KEY (
      vCode -- 휴가 코드
    )
    REFERENCES cms_vKind ( -- 휴가 종류 
      vCode -- 휴가 코드
    );

-- 휴가 신청
ALTER TABLE cms_vApp
  ADD CONSTRAINT FK_cms_worker_TO_cms_vApp -- 사원 -> 휴가 신청
    FOREIGN KEY (
      wNo -- 사원 번호
    )
    REFERENCES cms_worker ( -- 사원
      wNo -- 사원 번호
    );

-- 댓글 정보
ALTER TABLE cms_cmtInfo
  ADD CONSTRAINT FK_cms_bList_TO_cms_cmtInfo -- 게시글 정보 -> 댓글 정보
    FOREIGN KEY (
      bNo -- 게시글번호
    )
    REFERENCES cms_bList ( -- 게시글 정보
      bNo -- 게시글번호
    );

-- 댓글 정보
ALTER TABLE cms_cmtInfo
  ADD CONSTRAINT FK_cms_worker_TO_cms_cmtInfo -- 사원 -> 댓글 정보
    FOREIGN KEY (
      wNo -- 사원 번호
    )
    REFERENCES cms_worker ( -- 사원
      wNo -- 사원 번호
    );

-- 일정
ALTER TABLE cms_calender
  ADD CONSTRAINT FK_cms_worker_TO_cms_calender -- 사원 -> 일정
    FOREIGN KEY (
      wNo -- 사원 번호
    )
    REFERENCES cms_worker ( -- 사원
      wNo -- 사원 번호
    );

-- 대화
ALTER TABLE cms_chat
  ADD CONSTRAINT FK_cms_cGroup_TO_cms_chat -- 대화방참여자 -> 대화
    FOREIGN KEY (
      wNo,       -- 사원 번호
      gChatCode  -- 대화방번호
    )
    REFERENCES cms_cGroup ( -- 대화방참여자
      wNo,       -- 사원 번호
      gChatCode  -- 대화방번호
    );

-- 대화방참여자
ALTER TABLE cms_cGroup
  ADD CONSTRAINT FK_cms_worker_TO_cms_cGroup -- 사원 -> 대화방참여자
    FOREIGN KEY (
      wNo -- 사원 번호
    )
    REFERENCES cms_worker ( -- 사원
      wNo -- 사원 번호
    );

-- 대화방참여자
ALTER TABLE cms_cGroup
  ADD CONSTRAINT FK_cms_cRoom_TO_cms_cGroup -- 대화방 -> 대화방참여자
    FOREIGN KEY (
      gChatCode -- 대화방번호
    )
    REFERENCES cms_cRoom ( -- 대화방
      gChatCode -- 대화방번호
    );
    
-- 권한 예제데이터
insert into cms_auth(aCode, name)
values(0, '사원');

insert into cms_auth(aCode, name)
values(1, '인사');

insert into cms_auth(aCode, name)
values(9, '관리자');

-- 회사정보 예제데이터
insert into cms_cInfo(crNo, cName, map, postNo, addr, tel, fax)
values(1248100998, '하이워크', '1', '1234', '서울특별시 서초구 신논현', '02-1111-1111', '02-3333-3333');

-- 팀목록 예제데이터
insert into cms_tList(tCode, crNo, tName)
values('1', '1248100998', '개발팀');
insert into cms_tList(tCode, crNo, tName)
values('2', '1248100998', '인사팀');
insert into cms_tList(tCode, crNo, tName)
values('3', '1248100998', '영양팀');
insert into cms_tList(tCode, crNo, tName)
values('9', '1248100998', '관리팀');


-- 사원 예제데이터
insert into cms_worker(wNo, aCode, tCode, wName, email, wPhoto, rank, eType,
regiDate, tel, gender, tAnnu, pwd, eSt)
values(1, 0, '1', '김태희', 'aaa@test.com', '태희.jpg', '사장', '계약직',
'2020-07-13', '01092628654', '2', '12', '1111', 0);

insert into cms_worker(wNo, aCode, tCode, wName, email, wPhoto, rank, eType,
regiDate, tel, gender, tAnnu, pwd, eSt)
values(2, 1, '2', '홍길동', 'bbb@test.com', '길동.jpg', '사원', '계약직',
'2020-07-13', '01011111111', '1', '13', '1111', 0);

insert into cms_worker(wNo, aCode, tCode, wName, email, wPhoto, rank, eType,
regiDate, tel, gender, tAnnu, pwd, eSt)
values(3, 9, '9', '임꺽정', 'ccc@test.com', '꺽정.jpg', '대리', '정규직',
'2020-07-13', '01022222222', '1', '12', '1111', 0);

insert into cms_worker(wNo, aCode, tCode, wName, email, wPhoto, rank, eType,
regiDate, tel, gender, tAnnu, pwd, eSt)
values(4, 9, '9', '나퇴근', 'ddd@test.com', '퇴근.jpg', '대리', '정규직',
'2020-07-13', '01033333333', '1', '12', '1111', 1);

insert into cms_worker(wNo, aCode, tCode, wName, email, wPhoto, rank, eType,
regiDate, tel, gender, tAnnu, pwd, eSt)
values(5, 0, '3', '박영양', 'eee@test.com', '영양.jpg', '주임', '정규직',
'2020-07-13', '01044444444', '1', '12', '1111', 0);


-- 일정 예제데이터
insert into cms_calender(calCode, wNo, title, sdt, edt, content, place)
values('1', 1, '회의', '2020-07-13', '2020-12-31', '회의하는날', '회사');

insert into cms_calender(calCode, wNo, title, sdt, edt, content, place)
values('2', 2, '회의2', '2020-07-13', '2020-12-31', '회의하는날2', '회사');

insert into cms_calender(calCode, wNo, title, sdt, edt, content, place)
values('3', 2, '발표', '2020-11-17', '2020-11-18', '발표하는날', '회사');


-- 휴가 종류 예제데이터
insert into cms_vKind(vCode, name)
values('1', '병가');

insert into cms_vKind(vCode, name)
values('2', '연차');

insert into cms_vKind(vCode, name)
values('3', '반차');


-- 휴가 신청 예제데이터
insert into cms_vApp(vNo, vCode, wNo, adt, sdt, edt, used, rs, appr)
values(1, '1', 1, '2020-11-15', '2020-11-18', '2020-11-19', 1, '병가', '승인대기중');

insert into cms_vApp(vNo, vCode, wNo, adt, sdt, edt, used, rs, appr)
values(2, '2', 2, '2020-11-15', '2020-11-18', '2020-11-22', 4, '연차', '승인대기중');

insert into cms_vApp(vNo, vCode, wNo, adt, sdt, edt, used, rs, appr)
values(3, '3', 3, '2020-11-15', '2020-11-18', '2020-11-18', 0, '반차', '승인대기중');

-- 대화방 예제 데이터
insert into cms_cRoom(gChatCode, cName, cExpl)
values(1, '우리팀채팅방', '우리팀 회의방');

-- 대화방 참여자 예제 데이터
insert into cms_cGroup(wNo, gChatCode)
values(1, 1);

-- 대화 예제 데이터
insert into cms_chat(cNo, wNo, gChatCode, cContent, cName, cDate)
values(1, 1, 1, '안녕하세요', '텍스트', '2020-11-18');



-- 게시판 예제 데이터
insert into cms_board(bNo, bName)
values(1, "공지사항");

insert into cms_board(bNo, bName)
values(2, "사내소식");

insert into cms_board(bNo, bName)
values(3, "자유게시판");

insert into cms_board(bNo, bName)
values(4, "구내식단");



-- 게시글 정보 예제 데이터
insert into cms_bList(bNo, bNo2, wNo, title, regiDate, vCount, aFile, fSize, content)
values(1, 1, 1, '게시글 제목 테스트1', '2020-11-18', 0, '첨부파일명1', 1.5, '글 내용 테스트1');

insert into cms_bList(bNo, bNo2, wNo, title, regiDate, vCount, aFile, fSize, content)
values(2, 2, 2, '게시글 제목 테스트2', '2020-11-18', 0, '첨부파일명2', 1.7, '글 내용 테스트2');

insert into cms_bList(bNo, bNo2, wNo, title, regiDate, vCount, aFile, fSize, content)
values(3, 3, 3, '게시글 제목 테스트3', '2020-11-18', 0, '첨부파일명3', 2.3, '글 내용 테스트3');

insert into cms_bList(bNo, bNo2, wNo, title, regiDate, vCount, aFile, fSize, content)
values(4, 4, 5, '게시글 제목 테스트4', '2020-11-18', 0, '첨부파일명4', 1.5, '글 내용 테스트4');



-- 댓글 정보 예제 데이터
insert into cms_cmtInfo(cCode, bNo, list, stage, content, rdt, wNo)
values('a', 1, 1, 1, "댓글 내용1", '2020-11-18', 1);

insert into cms_cmtInfo(cCode, bNo, list, stage, content, rdt, wNo)
values('b', 2, 1, 1, "댓글 내용2", '2020-11-18', 2);

insert into cms_cmtInfo(cCode, bNo, list, stage, content, rdt, wNo)
values('c', 3, 1, 1, "댓글 내용3", '2020-11-19', 3);

insert into cms_cmtInfo(cCode, bNo, list, stage, content, rdt, wNo)
values('d', 4, 1, 1, "댓글 내용4", '2020-11-20', 4);

insert into cms_cmtInfo(cCode, bNo, list, stage, content, rdt, wNo)
values('e', 4, 1, 2, "댓글 내용5", '2020-11-20', 5);


-- 게시글 정보
DROP TABLE IF EXISTS cms_bList RESTRICT;

-- 회사정보
DROP TABLE IF EXISTS cms_cInfo RESTRICT;

-- 팀 목록
DROP TABLE IF EXISTS cms_tList RESTRICT;

-- 사원
DROP TABLE IF EXISTS cms_worker RESTRICT;

-- 권한
DROP TABLE IF EXISTS cms_auth RESTRICT;

-- 휴가 신청
DROP TABLE IF EXISTS cms_vApp RESTRICT;

-- 휴가 종류 
DROP TABLE IF EXISTS cms_vKind RESTRICT;

-- 댓글 정보
DROP TABLE IF EXISTS cms_cmtInfo RESTRICT;

-- 대화방
DROP TABLE IF EXISTS cms_cRoom RESTRICT;

-- 일정
DROP TABLE IF EXISTS cms_calender RESTRICT;

-- 게시판
DROP TABLE IF EXISTS cms_board RESTRICT;

-- 대화
DROP TABLE IF EXISTS cms_chat RESTRICT;

-- 대화방참여자
DROP TABLE IF EXISTS cms_cGroup RESTRICT;

-- 게시글 정보
CREATE TABLE cms_bList (
  bNo      INTEGER     NOT NULL COMMENT '게시글번호', -- 게시글번호
  bNo2     INTEGER     NOT NULL COMMENT '게시판번호', -- 게시판번호
  wNo      INTEGER     NOT NULL COMMENT '사원 번호', -- 사원 번호
  title    VARCHAR(50) NOT NULL COMMENT '제목', -- 제목
  regiDate DATE        NOT NULL COMMENT '등록일', -- 등록일
  vCount   INTEGER     NOT NULL COMMENT '조회수', -- 조회수
  aFile    VARCHAR(50) NULL     COMMENT '첨부파일명', -- 첨부파일명
  fSize    INTEGER     NULL     COMMENT '첨부파일 용량', -- 첨부파일 용량
  content  MEDIUMTEXT  NULL     COMMENT '글내용' -- 글내용
)
COMMENT '게시글 정보';

-- 게시글 정보
ALTER TABLE cms_bList
  ADD CONSTRAINT PK_cms_bList -- 게시글 정보 기본키
    PRIMARY KEY (
      bNo -- 게시글번호
    );

ALTER TABLE cms_bList
  MODIFY COLUMN bNo INTEGER NOT NULL AUTO_INCREMENT COMMENT '게시글번호';

-- 회사정보
CREATE TABLE cms_cInfo (
  crNo   INTEGER      NOT NULL COMMENT '법인등록번호', -- 법인등록번호
  cName  VARCHAR(50)  NOT NULL COMMENT '회사명', -- 회사명
  map    MEDIUMTEXT   NOT NULL COMMENT '지도', -- 지도
  postNo INTEGER      NOT NULL COMMENT '우편번호', -- 우편번호
  addr   VARCHAR(255) NOT NULL COMMENT '주소', -- 주소
  tel    VARCHAR(30)  NOT NULL COMMENT '전화번호', -- 전화번호
  fax    VARCHAR(30)  NOT NULL COMMENT '팩스번호' -- 팩스번호
)
COMMENT '회사정보';

-- 회사정보
ALTER TABLE cms_cInfo
  ADD CONSTRAINT PK_cms_cInfo -- 회사정보 기본키
    PRIMARY KEY (
      crNo -- 법인등록번호
    );

-- 팀 목록
CREATE TABLE cms_tList (
  tCode VARCHAR(20) NOT NULL COMMENT '팀 코드', -- 팀 코드
  crNo  INTEGER     NOT NULL COMMENT '법인등록번호', -- 법인등록번호
  tName VARCHAR(50) NOT NULL COMMENT '팀 부서' -- 팀 부서
)
COMMENT '팀 목록';

-- 팀 목록
ALTER TABLE cms_tList
  ADD CONSTRAINT PK_cms_tList -- 팀 목록 기본키
    PRIMARY KEY (
      tCode -- 팀 코드
    );

-- 사원
CREATE TABLE cms_worker (
  wNo      INTEGER      NOT NULL COMMENT '사원 번호', -- 사원 번호
  aCode    INTEGER      NOT NULL COMMENT '권한 코드', -- 권한 코드
  tCode    VARCHAR(20)  NULL     COMMENT '팀 코드', -- 팀 코드
  wName    VARCHAR(50)  NOT NULL COMMENT '사원이름', -- 사원이름
  email    VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
  wPhoto   VARCHAR(255) NOT NULL COMMENT '사원사진', -- 사원사진
  rank     MEDIUMTEXT   NOT NULL COMMENT '직급', -- 직급
  eType    MEDIUMTEXT   NOT NULL COMMENT '고용형태', -- 고용형태
  regiDate DATE         NOT NULL COMMENT '입사일', -- 입사일
  tel      INTEGER      NOT NULL COMMENT '휴대폰번호', -- 휴대폰번호
  gender   INTEGER      NOT NULL COMMENT '성별', -- 성별
  tAnnu    INTEGER      NOT NULL COMMENT '총 연차', -- 총 연차
  pwd      INTEGER      NOT NULL COMMENT '비밀번호', -- 비밀번호
  eSt      INTEGER      NOT NULL COMMENT '재직 상태' -- 재직 상태
)
COMMENT '사원';

-- 사원
ALTER TABLE cms_worker
  ADD CONSTRAINT PK_cms_worker -- 사원 기본키
    PRIMARY KEY (
      wNo -- 사원 번호
    );

-- 이메일
CREATE UNIQUE INDEX UIX_cms_worker
  ON cms_worker ( -- 사원
    email ASC -- 이메일
  );

-- 휴대폰번호
CREATE UNIQUE INDEX UIX_cms_worker2
  ON cms_worker ( -- 사원
    tel ASC -- 휴대폰번호
  );

ALTER TABLE cms_worker
  MODIFY COLUMN wNo INTEGER NOT NULL AUTO_INCREMENT COMMENT '사원 번호';

-- 권한
CREATE TABLE cms_auth (
  aCode INTEGER     NOT NULL COMMENT '권한 코드', -- 권한 코드
  name  VARCHAR(50) NOT NULL COMMENT '권한명' -- 권한명
)
COMMENT '권한';

-- 권한
ALTER TABLE cms_auth
  ADD CONSTRAINT PK_cms_auth -- 권한 기본키
    PRIMARY KEY (
      aCode -- 권한 코드
    );

-- 권한 유니크 인덱스
CREATE UNIQUE INDEX UIX_cms_auth
  ON cms_auth ( -- 권한
    name ASC -- 권한명
  );

-- 휴가 종류 
CREATE TABLE cms_vKind (
  vCode VARCHAR(20) NOT NULL COMMENT '휴가 코드', -- 휴가 코드
  name  VARCHAR(50) NOT NULL COMMENT '휴가명' -- 휴가명
)
COMMENT '휴가 종류 ';

-- 휴가 종류 
ALTER TABLE cms_vKind
  ADD CONSTRAINT PK_cms_vKind -- 휴가 종류  기본키
    PRIMARY KEY (
      vCode -- 휴가 코드
    );
    
-- 휴가 신청
ALTER TABLE cms_vApp
  ADD CONSTRAINT PK_cms_vApp -- 휴가 신청 기본키
    PRIMARY KEY (
      vNo -- 휴가신청번호
    );
    
-- 휴가 신청
CREATE TABLE cms_vApp (
  vNo   INTEGER     NOT NULL COMMENT '휴가신청번호', -- 휴가신청번호
  vCode VARCHAR(20) NOT NULL COMMENT '휴가 코드', -- 휴가 코드
  wNo   INTEGER     NOT NULL COMMENT '사원 번호', -- 사원 번호
  adt   DATE        NOT NULL COMMENT '신청일', -- 신청일
  sdt   DATE        NOT NULL COMMENT '시작일', -- 시작일
  edt   DATE        NOT NULL COMMENT '종료일', -- 종료일
  used  INTEGER     NOT NULL COMMENT '사용연차일수', -- 사용연차일수
  rs    MEDIUMTEXT  NOT NULL COMMENT '신청사유', -- 신청사유
  appr  MEDIUMTEXT  NOT NULL COMMENT '승인여부' -- 승인여부
)
COMMENT '휴가 신청';



-- 댓글 정보
CREATE TABLE cms_cmtInfo (
  cCode   VARCHAR(20) NOT NULL COMMENT '댓글 코드', -- 댓글 코드
  bNo     INTEGER     NOT NULL COMMENT '게시글번호', -- 게시글번호
  list    INTEGER     NOT NULL COMMENT '순서', -- 순서
  stage   INTEGER     NOT NULL COMMENT '단계', -- 단계
  content MEDIUMTEXT  NOT NULL COMMENT '내용', -- 내용
  rdt     DATE        NOT NULL COMMENT '등록일', -- 등록일
  wNo     INTEGER     NOT NULL COMMENT '사원 번호' -- 사원 번호
)
COMMENT '댓글 정보';

-- 댓글 정보
ALTER TABLE cms_cmtInfo
  ADD CONSTRAINT PK_cms_cmtInfo -- 댓글 정보 기본키
    PRIMARY KEY (
      cCode -- 댓글 코드
    );

-- 대화방
CREATE TABLE cms_cRoom (
  gChatCode INTEGER     NOT NULL COMMENT '대화방번호', -- 대화방번호
  cName     VARCHAR(50) NOT NULL COMMENT '채팅방명', -- 채팅방명
  cExpl     MEDIUMTEXT  NULL     COMMENT '채팅방설명' -- 채팅방설명
)
COMMENT '대화방';

-- 대화방
ALTER TABLE cms_cRoom
  ADD CONSTRAINT PK_cms_cRoom -- 대화방 기본키
    PRIMARY KEY (
      gChatCode -- 대화방번호
    );

-- 일정
CREATE TABLE cms_calender (
  calCode VARCHAR(20)  NOT NULL COMMENT '일정코드', -- 일정코드
  wNo     INTEGER      NOT NULL COMMENT '사원 번호', -- 사원 번호
  title   VARCHAR(50)  NOT NULL COMMENT '제목', -- 제목
  sdt     DATE         NOT NULL COMMENT '시작일', -- 시작일
  edt     DATE         NOT NULL COMMENT '종료일', -- 종료일
  content MEDIUMTEXT   NOT NULL COMMENT '내용', -- 내용
  place   VARCHAR(255) NULL     COMMENT '장소' -- 장소
)
COMMENT '일정';

-- 일정
ALTER TABLE cms_calender
  ADD CONSTRAINT PK_cms_calender -- 일정 기본키
    PRIMARY KEY (
      calCode -- 일정코드
    );

-- 게시판
CREATE TABLE cms_board (
  bNo   INTEGER     NOT NULL COMMENT '게시판번호', -- 게시판번호
  bName VARCHAR(50) NOT NULL COMMENT '게시판명' -- 게시판명
)
COMMENT '게시판';

-- 게시판
ALTER TABLE cms_board
  ADD CONSTRAINT PK_cms_board -- 게시판 기본키
    PRIMARY KEY (
      bNo -- 게시판번호
    );

-- 대화
CREATE TABLE cms_chat (
  cNo       INTEGER     NOT NULL COMMENT '대화번호', -- 대화번호
  wNo       INTEGER     NOT NULL COMMENT '사원 번호', -- 사원 번호
  gChatCode INTEGER     NOT NULL COMMENT '대화방번호', -- 대화방번호
  cContent  MEDIUMTEXT  NOT NULL COMMENT '메시지', -- 메시지
  cName     VARCHAR(50) NOT NULL COMMENT '메시지유형', -- 메시지유형
  cDate     DATE        NOT NULL COMMENT '생성일' -- 생성일
)
COMMENT '대화';

-- 대화
ALTER TABLE cms_chat
  ADD CONSTRAINT PK_cms_chat -- 대화 기본키
    PRIMARY KEY (
      cNo -- 대화번호
    );

-- 대화방참여자
CREATE TABLE cms_cGroup (
  wNo       INTEGER NOT NULL COMMENT '사원 번호', -- 사원 번호
  gChatCode INTEGER NOT NULL COMMENT '대화방번호' -- 대화방번호
)
COMMENT '대화방참여자';

-- 대화방참여자
ALTER TABLE cms_cGroup
  ADD CONSTRAINT PK_cms_cGroup -- 대화방참여자 기본키
    PRIMARY KEY (
      wNo,       -- 사원 번호
      gChatCode  -- 대화방번호
    );

-- 게시글 정보
ALTER TABLE cms_bList
  ADD CONSTRAINT FK_cms_board_TO_cms_bList -- 게시판 -> 게시글 정보
    FOREIGN KEY (
      bNo2 -- 게시판번호
    )
    REFERENCES cms_board ( -- 게시판
      bNo -- 게시판번호
    );

-- 게시글 정보
ALTER TABLE cms_bList
  ADD CONSTRAINT FK_cms_worker_TO_cms_bList -- 사원 -> 게시글 정보
    FOREIGN KEY (
      wNo -- 사원 번호
    )
    REFERENCES cms_worker ( -- 사원
      wNo -- 사원 번호
    );

-- 팀 목록
ALTER TABLE cms_tList
  ADD CONSTRAINT FK_cms_cInfo_TO_cms_tList -- 회사정보 -> 팀 목록
    FOREIGN KEY (
      crNo -- 법인등록번호
    )
    REFERENCES cms_cInfo ( -- 회사정보
      crNo -- 법인등록번호
    );

-- 사원
ALTER TABLE cms_worker
  ADD CONSTRAINT FK_cms_auth_TO_cms_worker -- 권한 -> 사원
    FOREIGN KEY (
      aCode -- 권한 코드
    )
    REFERENCES cms_auth ( -- 권한
      aCode -- 권한 코드
    );

-- 사원
ALTER TABLE cms_worker
  ADD CONSTRAINT FK_cms_tList_TO_cms_worker -- 팀 목록 -> 사원
    FOREIGN KEY (
      tCode -- 팀 코드
    )
    REFERENCES cms_tList ( -- 팀 목록
      tCode -- 팀 코드
    );

-- 휴가 신청
ALTER TABLE cms_vApp
  ADD CONSTRAINT FK_cms_vKind_TO_cms_vApp -- 휴가 종류  -> 휴가 신청
    FOREIGN KEY (
      vCode -- 휴가 코드
    )
    REFERENCES cms_vKind ( -- 휴가 종류 
      vCode -- 휴가 코드
    );

-- 휴가 신청
ALTER TABLE cms_vApp
  ADD CONSTRAINT FK_cms_worker_TO_cms_vApp -- 사원 -> 휴가 신청
    FOREIGN KEY (
      wNo -- 사원 번호
    )
    REFERENCES cms_worker ( -- 사원
      wNo -- 사원 번호
    );

-- 댓글 정보
ALTER TABLE cms_cmtInfo
  ADD CONSTRAINT FK_cms_bList_TO_cms_cmtInfo -- 게시글 정보 -> 댓글 정보
    FOREIGN KEY (
      bNo -- 게시글번호
    )
    REFERENCES cms_bList ( -- 게시글 정보
      bNo -- 게시글번호
    );

-- 댓글 정보
ALTER TABLE cms_cmtInfo
  ADD CONSTRAINT FK_cms_worker_TO_cms_cmtInfo -- 사원 -> 댓글 정보
    FOREIGN KEY (
      wNo -- 사원 번호
    )
    REFERENCES cms_worker ( -- 사원
      wNo -- 사원 번호
    );

-- 일정
ALTER TABLE cms_calender
  ADD CONSTRAINT FK_cms_worker_TO_cms_calender -- 사원 -> 일정
    FOREIGN KEY (
      wNo -- 사원 번호
    )
    REFERENCES cms_worker ( -- 사원
      wNo -- 사원 번호
    );

-- 대화
ALTER TABLE cms_chat
  ADD CONSTRAINT FK_cms_cGroup_TO_cms_chat -- 대화방참여자 -> 대화
    FOREIGN KEY (
      wNo,       -- 사원 번호
      gChatCode  -- 대화방번호
    )
    REFERENCES cms_cGroup ( -- 대화방참여자
      wNo,       -- 사원 번호
      gChatCode  -- 대화방번호
    );

-- 대화방참여자
ALTER TABLE cms_cGroup
  ADD CONSTRAINT FK_cms_worker_TO_cms_cGroup -- 사원 -> 대화방참여자
    FOREIGN KEY (
      wNo -- 사원 번호
    )
    REFERENCES cms_worker ( -- 사원
      wNo -- 사원 번호
    );

-- 대화방참여자
ALTER TABLE cms_cGroup
  ADD CONSTRAINT FK_cms_cRoom_TO_cms_cGroup -- 대화방 -> 대화방참여자
    FOREIGN KEY (
      gChatCode -- 대화방번호
    )
    REFERENCES cms_cRoom ( -- 대화방
      gChatCode -- 대화방번호
    );
    
-- 권한 예제데이터
insert into cms_auth(aCode, name)
values(0, '사원');

insert into cms_auth(aCode, name)
values(1, '인사');

insert into cms_auth(aCode, name)
values(9, '관리자');

-- 회사정보 예제데이터
insert into cms_cInfo(crNo, cName, map, postNo, addr, tel, fax)
values(1248100998, '하이워크', '1', '1234', '서울특별시 서초구 신논현', '02-1111-1111', '02-3333-3333');

-- 팀목록 예제데이터
insert into cms_tList(tCode, crNo, tName)
values('1', '1248100998', '개발팀');
insert into cms_tList(tCode, crNo, tName)
values('2', '1248100998', '인사팀');
insert into cms_tList(tCode, crNo, tName)
values('3', '1248100998', '영양팀');
insert into cms_tList(tCode, crNo, tName)
values('9', '1248100998', '관리팀');


-- 사원 예제데이터
insert into cms_worker(wNo, aCode, tCode, wName, email, wPhoto, rank, eType,
regiDate, tel, gender, tAnnu, pwd, eSt)
values(1, 0, '1', '김태희', 'aaa@test.com', '태희.jpg', '사장', '계약직',
'2020-07-13', '01092628654', '2', '12', '1111', 0);

insert into cms_worker(wNo, aCode, tCode, wName, email, wPhoto, rank, eType,
regiDate, tel, gender, tAnnu, pwd, eSt)
values(2, 1, '2', '홍길동', 'bbb@test.com', '길동.jpg', '사원', '계약직',
'2020-07-13', '01011111111', '1', '13', '1111', 0);

insert into cms_worker(wNo, aCode, tCode, wName, email, wPhoto, rank, eType,
regiDate, tel, gender, tAnnu, pwd, eSt)
values(3, 9, '9', '임꺽정', 'ccc@test.com', '꺽정.jpg', '대리', '정규직',
'2020-07-13', '01022222222', '1', '12', '1111', 0);

insert into cms_worker(wNo, aCode, tCode, wName, email, wPhoto, rank, eType,
regiDate, tel, gender, tAnnu, pwd, eSt)
values(4, 9, '9', '나퇴근', 'ddd@test.com', '퇴근.jpg', '대리', '정규직',
'2020-07-13', '01033333333', '1', '12', '1111', 1);

insert into cms_worker(wNo, aCode, tCode, wName, email, wPhoto, rank, eType,
regiDate, tel, gender, tAnnu, pwd, eSt)
values(5, 0, '3', '박영양', 'eee@test.com', '영양.jpg', '주임', '정규직',
'2020-07-13', '01044444444', '1', '12', '1111', 0);


-- 일정 예제데이터
insert into cms_calender(calCode, wNo, title, sdt, edt, content, place)
values('1', 1, '회의', '2020-07-13', '2020-12-31', '회의하는날', '회사');

insert into cms_calender(calCode, wNo, title, sdt, edt, content, place)
values('2', 2, '회의2', '2020-07-13', '2020-12-31', '회의하는날2', '회사');

insert into cms_calender(calCode, wNo, title, sdt, edt, content, place)
values('3', 2, '발표', '2020-11-17', '2020-11-18', '발표하는날', '회사');


-- 휴가 종류 예제데이터
insert into cms_vKind(vCode, name)
values('1', '병가');

insert into cms_vKind(vCode, name)
values('2', '연차');

insert into cms_vKind(vCode, name)
values('3', '반차');


-- 휴가 신청 예제데이터
insert into cms_vApp(vNo, vCode, wNo, adt, sdt, edt, used, rs, appr)
values(1, '1', 1, '2020-11-15', '2020-11-18', '2020-11-19', 1, '병가', '승인대기중');

insert into cms_vApp(vNo, vCode, wNo, adt, sdt, edt, used, rs, appr)
values(2, '2', 2, '2020-11-15', '2020-11-18', '2020-11-22', 4, '연차', '승인대기중');

insert into cms_vApp(vNo, vCode, wNo, adt, sdt, edt, used, rs, appr)
values(3, '3', 3, '2020-11-15', '2020-11-18', '2020-11-18', 0, '반차', '승인대기중');

-- 대화방 예제 데이터
insert into cms_cRoom(gChatCode, cName, cExpl)
values(1, '우리팀채팅방', '우리팀 회의방');

-- 대화방 참여자 예제 데이터
insert into cms_cGroup(wNo, gChatCode)
values(1, 1);

-- 대화 예제 데이터
insert into cms_chat(cNo, wNo, gChatCode, cContent, cName, cDate)
values(1, 1, 1, '안녕하세요', '텍스트', '2020-11-18');



-- 게시판 예제 데이터
insert into cms_board(bNo, bName)
values(1, "공지사항");

insert into cms_board(bNo, bName)
values(2, "사내소식");

insert into cms_board(bNo, bName)
values(3, "자유게시판");

insert into cms_board(bNo, bName)
values(4, "구내식단");



-- 게시글 정보 예제 데이터
insert into cms_bList(bNo, bNo2, wNo, title, regiDate, vCount, aFile, fSize, content)
values(1, 1, 1, '게시글 제목 테스트1', '2020-11-18', 0, '첨부파일명1', 1.5, '글 내용 테스트1');

insert into cms_bList(bNo, bNo2, wNo, title, regiDate, vCount, aFile, fSize, content)
values(2, 2, 2, '게시글 제목 테스트2', '2020-11-18', 0, '첨부파일명2', 1.7, '글 내용 테스트2');

insert into cms_bList(bNo, bNo2, wNo, title, regiDate, vCount, aFile, fSize, content)
values(3, 3, 3, '게시글 제목 테스트3', '2020-11-18', 0, '첨부파일명3', 2.3, '글 내용 테스트3');

insert into cms_bList(bNo, bNo2, wNo, title, regiDate, vCount, aFile, fSize, content)
values(4, 4, 5, '게시글 제목 테스트4', '2020-11-18', 0, '첨부파일명4', 1.5, '글 내용 테스트4');



-- 댓글 정보 예제 데이터
insert into cms_cmtInfo(cCode, bNo, list, stage, content, rdt, wNo)
values('a', 1, 1, 1, "댓글 내용1", '2020-11-18', 1);

insert into cms_cmtInfo(cCode, bNo, list, stage, content, rdt, wNo)
values('b', 2, 1, 1, "댓글 내용2", '2020-11-18', 2);

insert into cms_cmtInfo(cCode, bNo, list, stage, content, rdt, wNo)
values('c', 3, 1, 1, "댓글 내용3", '2020-11-19', 3);

insert into cms_cmtInfo(cCode, bNo, list, stage, content, rdt, wNo)
values('d', 4, 1, 1, "댓글 내용4", '2020-11-20', 4);

insert into cms_cmtInfo(cCode, bNo, list, stage, content, rdt, wNo)
values('e', 4, 1, 2, "댓글 내용5", '2020-11-20', 5);


