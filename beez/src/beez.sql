drop table user_att_tb;
drop table beacon_tb;
drop table user_device_tb;
drop table user_seat_tb;
drop table seat_tb;
drop table office_tb;
drop table att_policy_tb;
drop table user_tb;
drop table dept_tb;

CREATE TABLE USER_TB 
(
    USER_ID     VARCHAR2(40)    PRIMARY KEY NOT NULL,
    USER_PWD    VARCHAR2(200)   NOT NULL,
    USER_NAME   VARCHAR2(50)    NOT NULL,
    SKEY_USE_YN VARCHAR2(4)     NOT NULL,
    PHONE_NUM   VARCHAR2(20),
    DEPT_ID     VARCHAR2(20)    NOT NULL,
    DUTY_NAME   VARCHAR2(10)    NOT NULL,
    LAST_ACCESS TIMESTAMP,
    FAIL_CNT    NUMBER          DEFAULT 0
);


CREATE TABLE DEPT_TB
(
    DEPT_ID     VARCHAR2(40) PRIMARY KEY NOT NULL,
    DEPT_NAME   VARCHAR2(50) NOT NULL,
    HIGHER_DEPT VARCHAR2(10),
    OFFICE_ADDR VARCHAR2(100)
);

CREATE TABLE BEACON_TB
(
    BEACON_ID       VARCHAR2(40) NOT NULL,
	OFFICE_SEQ		NUMBER NOT NULL,
    BEACON_ADDR     VARCHAR2(40) NOT NULL,
    BEACON_POSITION VARCHAR2(200),
    BEACON_ALIAS    VARCHAR2(50),
    PRIMARY KEY (BEACON_ID)
);

CREATE TABLE USER_ATT_TB
(
    USER_ID             VARCHAR2(40)    NOT NULL,
    ATT_DATE            DATE            NOT NULL,
    ATT_IDX             NUMBER          NOT NULL,
    BEACON_ID           VARCHAR2(40),
    ATT_ARRIVE_TIME     TIMESTAMP,
    ATT_LEAVE_TIME      TIMESTAMP,
    ATT_NEWEST_CHK_TIME TIMESTAMP,
    PRIMARY KEY (USER_ID, ATT_DATE, ATT_IDX)
);

CREATE TABLE USER_DEVICE_TB
(
    USER_ID             VARCHAR2(20)    NOT NULL,
    DEVICE_SEQ          NUMBER NOT NULL,
    DEVICE_TYPE         VARCHAR2(50),
    DEVICE_MAC_ADDR     VARCHAR2(40)    NOT NULL,
    DEVICE_ALIAS        VARCHAR2(100),
    DEVICE_UNIQUE_ID    VARCHAR2(200)   NOT NULL,
    DEVICE_FCM_TOKEN    VARCHAR2(100)   NOT NULL,
    DEVICE_ENABLE_YN    VARCHAR2(4),
    PRIMARY KEY (USER_ID, DEVICE_SEQ)
);

CREATE TABLE ATT_POLICY_TB
(
    DEPT_ID                 VARCHAR2(40) NOT NULL,
    POLICY_ID               VARCHAR2(40) NOT NULL,
    POLICY_USE_YN           VARCHAR2(4),
    POLICY_LEAVE_TIME_TEAM  NUMBER,
    PRIMARY KEY (DEPT_ID, POLICY_ID)
);

CREATE TABLE OFFICE_TB
(
    OFFICE_SEQ      NUMBER     PRIMARY KEY  NOT NULL,
    FLOOR_NUM       NUMBER,
    BUILDING_NAME   VARCHAR2(50)
);

CREATE TABLE SEAT_TB
(
    OFFICE_SEQ              NUMBER          NOT NULL,
    SEAT_ID                 VARCHAR2(40)    NOT NULL,
    SEAT_REAL_LOCATION      VARCHAR2(100),
    SEAT_USEABLE_STATE      VARCHAR2(20),
    SEAT_NFC_TAG_ID         VARCHAR2(40),
    PRIMARY KEY (OFFICE_SEQ, SEAT_ID)
);

CREATE TABLE USER_SEAT_TB
(
    USER_ID         VARCHAR2(40)    NOT NULL,
    SEAT_ID         VARCHAR2(40)    NOT NULL,
    OFFICE_SEQ      NUMBER          NOT NULL,
    SEATED_DATE     DATE            NOT NULL,
    USER_LEAVE_YN   VARCHAR2(4),
    PRIMARY KEY (USER_ID, SEAT_ID, OFFICE_SEQ, SEATED_DATE)
);



ALTER TABLE USER_TB
ADD FOREIGN KEY (DEPT_ID) REFERENCES DEPT_TB(DEPT_ID);

ALTER TABLE DEPT_TB
ADD FOREIGN KEY (HIGHER_DEPT) REFERENCES DEPT_TB(DEPT_ID);

ALTER TABLE USER_ATT_TB
ADD FOREIGN KEY (USER_ID) REFERENCES USER_TB(USER_ID);

ALTER TABLE USER_ATT_TB
ADD FOREIGN KEY (BEACON_ID) REFERENCES BEACON_TB(BEACON_ID);
 
ALTER TABLE USER_DEVICE_TB
ADD FOREIGN KEY (USER_ID) REFERENCES USER_TB(USER_ID);

ALTER TABLE ATT_POLICY_TB
ADD FOREIGN KEY (DEPT_ID) REFERENCES DEPT_TB(DEPT_ID);

ALTER TABLE BEACON_TB
ADD FOREIGN KEY (OFFICE_SEQ) REFERENCES OFFICE_TB(OFFICE_SEQ);

ALTER TABLE SEAT_TB
ADD FOREIGN KEY (OFFICE_SEQ) REFERENCES OFFICE_TB(OFFICE_SEQ);

ALTER TABLE USER_SEAT_TB
ADD FOREIGN KEY (USER_ID) REFERENCES USER_TB(USER_ID);

ALTER TABLE USER_SEAT_TB
ADD FOREIGN KEY (SEAT_ID, OFFICE_SEQ) REFERENCES SEAT_TB(SEAT_ID, OFFICE_SEQ);



DROP VIEW BEACON_OFFICE_VW;
  
CREATE  VIEW    BEACON_OFFICE_VW
AS(
    SELECT  BEACON_ID, BEACON_ADDR, BEACON_POSITION, BEACON_ALIAS, FLOOR_NUM, BUILDING_NAME
    FROM    BEACON_TB
    JOIN    OFFICE_TB   USING(OFFICE_SEQ)
);


DROP VIEW LIST_SEATED_USER_VW;

CREATE VIEW LIST_SEATED_USER_VW
AS
(    
	SELECT  S.OFFICE_SEQ, 
			S.SEAT_ID, 
			S.SEAT_REAL_LOCATION, 
			S.SEAT_USEABLE_STATE,
			S.SEAT_NFC_TAG_ID, 
			SU.USER_ID, 
			SU.SEATED_DATE, 
			SU.USER_LEAVE_YN
	FROM    SEAT_TB S
	LEFT    JOIN   USER_SEAT_TB   SU  ON(S.SEAT_ID = SU.SEAT_ID)
)
ORDER   BY  S.OFFICE_SEQ, S.SEAT_REAL_LOCATION, S.SEAT_ID;


-- 뷰 사용 예제 첨부

SELECT  *  
FROM 	LIST_SEATED_USER_VW 
WHERE   OFFICE_SEQ = 4 
AND 	SEAT_REAL_LOCATION = 'A'
AND     (SEATED_DATE = CURRENT_DATE OR SEATED_DATE IS NULL);

--위 쿼리 실행 시 OFFICE_SEQ = 4 (14F) 의 A 구역의 오늘 좌석 정보가 나타남 
--만약 OR SEATED_DATE IS NULL 이 없다면, LEFT JOIN을 하는것이 의미가 없어져서 괄호를 통해 OR연산을 우선적으로 수행함

INSERT  INTO    OFFICE_TB   VALUES(1, 9, 'CENTRAL');
INSERT  INTO    OFFICE_TB   VALUES(2, 10, 'CENTRAL');
INSERT  INTO    OFFICE_TB   VALUES(3, 13, 'CENTRAL');
INSERT  INTO    OFFICE_TB   VALUES(4, 14, 'CENTRAL');


insert into dept_tb values ('HR', '인사팀', null, '명동');
insert into dept_tb values ('DEPARTMENT', '백화점팀', null, '명동');
insert into dept_tb values ('STARBUCKS', '스타벅스팀', null, '시청');
insert into dept_tb values ('EMART', '이마트팀', null, '성수');


INSERT INTO SEAT_TB VALUES(2,'10','A','Y','10F-A-10');
INSERT INTO SEAT_TB VALUES(2,'12','A','Y','10F-A-12');
INSERT INTO SEAT_TB VALUES(4,'60','B','Y','14F-B-60');
INSERT INTO SEAT_TB VALUES(4,'61','B','Y','14F-B-61');
INSERT INTO SEAT_TB VALUES(4,'1','A','Y','14F-A-1');
INSERT INTO SEAT_TB VALUES(4,'2','A','Y','14F-A-2');


INSERT INTO BEACON_TB VALUES('B1', 3, '78:A5:04:4F:53:61', 'TEST', 'TEST');
INSERT INTO BEACON_TB VALUES('MiniBeacon-12882', 2, 'C1:00:47:00:32:52', '10F-A', '10F-A');
INSERT INTO BEACON_TB VALUES('MiniBeacon-12891', 2, 'C1:00:47:00:32:5B', '10F-B', '10F-B');
INSERT INTO BEACON_TB VALUES('MiniBeacon-12894', 4, 'C1:00:47:00:32:5E', '14F-A', '14F-A');
INSERT INTO BEACON_TB VALUES('MiniBeacon-12897', 4, 'C1:00:47:00:32:61', '14F-B', '14F-B');

insert into att_policy_tb values ('HR', 'POLICY1', 'N', 7);
insert into att_policy_tb values ('HR', 'POLICY2', 'Y', 6);
insert into att_policy_tb values ('DEPARTMENT', 'POLICY2', 'Y', 6);
insert into att_policy_tb values ('STARBUCKS', 'POLICY3', 'Y', 7);
insert into att_policy_tb values ('EMART', 'POLICY4', 'N', 8);


insert into user_tb values ('p908vd', 'whguswo', '조현재', 'Y', '010-1234-1234', 'STARBUCKS', '인턴', SYSDATE-1, default);
insert into user_tb values ('p908v1', 'rlarlcks', '김기찬', 'Y', '010-1234-1234', 'EMART', 'CEO', SYSDATE, default);
insert into user_tb values ('p908v2', 'rlatmdgml', '김승희', 'Y', '010-1234-1234', 'HR', '인턴', SYSDATE-2, default);
insert into user_tb values ('p908v3', 'dlrbtkd', '이규상', 'N', '010-1234-1234', 'DEPARTMENT', '인턴', SYSDATE-3, default);

 
insert into user_seat_tb values ('p908vd', '60', 4, SYSDATE-8, 'Y');
insert into user_seat_tb values ('p908vd', '61', 4, SYSDATE-7, 'Y');
insert into user_seat_tb values ('p908vd', '1', 4, SYSDATE-6, 'Y');
insert into user_seat_tb values ('p908vd', '2', 4, SYSDATE-5, 'Y'); 
insert into user_seat_tb values ('p908vd', '60', 4, SYSDATE-2, 'Y');
insert into user_seat_tb values ('p908vd', '61', 4, SYSDATE-1, 'Y');
 
insert into user_seat_tb values ('p908v1', '60', 4, SYSDATE-8, 'Y');
insert into user_seat_tb values ('p908v1', '61', 4, SYSDATE-7, 'Y');
insert into user_seat_tb values ('p908v1', '1', 4, SYSDATE-6, 'Y');
insert into user_seat_tb values ('p908v1', '2', 4, SYSDATE-5, 'Y'); 
insert into user_seat_tb values ('p908v1', '60', 4, SYSDATE-2, 'Y');
insert into user_seat_tb values ('p908v1', '61', 4, SYSDATE-1, 'Y');


insert into user_seat_tb values ('p908v2', '10', 2, SYSDATE, 'N');
insert into user_seat_tb values ('p908v2', '12', 2, SYSDATE-9, 'Y'); 
insert into user_seat_tb values ('p908v2', '10', 2, SYSDATE-4, 'Y');
insert into user_seat_tb values ('p908v2', '12', 2, SYSDATE-3, 'Y'); 

insert into user_seat_tb values ('p908v3', '10', 2, SYSDATE, 'N');
insert into user_seat_tb values ('p908v3', '12', 2, SYSDATE-9, 'Y'); 
insert into user_seat_tb values ('p908v3', '10', 2, SYSDATE-4, 'Y');
insert into user_seat_tb values ('p908v3', '12', 2, SYSDATE-3, 'Y'); 


INSERT INTO USER_DEVICE_TB VALUES(	'p908vd',	1,	'TYPE1',	'0A1B9C8D',	 '단말기 별칭1',	'UNIQUE1',	'TOKEN1',	'Y'	);
INSERT INTO USER_DEVICE_TB VALUES(	'p908v1',	2,	'TYPE2',	'0A1B9C9D',	 '단말기 별칭2',	'UNIQUE2',	'TOKEN2',	'Y'	);
INSERT INTO USER_DEVICE_TB VALUES(	'p908v2',	3,	'TYPE3',	'0A1B9C10D', '단말기 별칭3',	'UNIQUE3',	'TOKEN3',	'Y'	);
INSERT INTO USER_DEVICE_TB VALUES(	'p908v3',	4,	'TYPE4',	'0A1B9C11D', '단말기 별칭4',	'UNIQUE4',	'TOKEN4',	'Y'	);


insert into user_att_tb values ('p908vd', SYSDATE-9, 1, 'MiniBeacon-12894', SYSTIMESTAMP-9, SYSTIMESTAMP-9, SYSTIMESTAMP-9);
insert into user_att_tb values ('p908vd', SYSDATE-8, 2, 'MiniBeacon-12894', SYSTIMESTAMP-8, SYSTIMESTAMP-8, SYSTIMESTAMP-8);
insert into user_att_tb values ('p908vd', SYSDATE-7, 3, 'MiniBeacon-12894', SYSTIMESTAMP-7, SYSTIMESTAMP-7, SYSTIMESTAMP-7);
insert into user_att_tb values ('p908vd', SYSDATE-6, 4, 'MiniBeacon-12894', SYSTIMESTAMP-6, SYSTIMESTAMP-6, SYSTIMESTAMP-6);
insert into user_att_tb values ('p908vd', SYSDATE-5, 5, 'MiniBeacon-12894', SYSTIMESTAMP-5, SYSTIMESTAMP-5, SYSTIMESTAMP-5);
insert into user_att_tb values ('p908vd', SYSDATE-4, 6, 'MiniBeacon-12894', SYSTIMESTAMP-4, SYSTIMESTAMP-4, SYSTIMESTAMP-4);
insert into user_att_tb values ('p908vd', SYSDATE-3, 7, 'MiniBeacon-12894', SYSTIMESTAMP-3, SYSTIMESTAMP-3, SYSTIMESTAMP-3);
insert into user_att_tb values ('p908vd', SYSDATE-2, 8, 'MiniBeacon-12894', SYSTIMESTAMP-2, SYSTIMESTAMP-2, SYSTIMESTAMP-2);
insert into user_att_tb values ('p908vd', SYSDATE-1, 9, 'MiniBeacon-12894', SYSTIMESTAMP-1, SYSTIMESTAMP-1, SYSTIMESTAMP-1);
insert into user_att_tb values ('p908vd', SYSDATE, 10, 'MiniBeacon-12894', SYSTIMESTAMP-0, SYSTIMESTAMP, SYSTIMESTAMP);

insert into user_att_tb values ('p908v1', SYSDATE-9, 11, 'MiniBeacon-12897', SYSTIMESTAMP-9, SYSTIMESTAMP-9, SYSTIMESTAMP-9);
insert into user_att_tb values ('p908v1', SYSDATE-8, 12, 'MiniBeacon-12897', SYSTIMESTAMP-8, SYSTIMESTAMP-8, SYSTIMESTAMP-8);
insert into user_att_tb values ('p908v1', SYSDATE-7, 13, 'MiniBeacon-12897', SYSTIMESTAMP-7, SYSTIMESTAMP-7, SYSTIMESTAMP-7);
insert into user_att_tb values ('p908v1', SYSDATE-6, 14, 'MiniBeacon-12897', SYSTIMESTAMP-6, SYSTIMESTAMP-6, SYSTIMESTAMP-6);
insert into user_att_tb values ('p908v1', SYSDATE-5, 15, 'MiniBeacon-12897', SYSTIMESTAMP-5, SYSTIMESTAMP-5, SYSTIMESTAMP-5);
insert into user_att_tb values ('p908v1', SYSDATE-4, 16, 'MiniBeacon-12897', SYSTIMESTAMP-4, SYSTIMESTAMP-4, SYSTIMESTAMP-4);
insert into user_att_tb values ('p908v1', SYSDATE-3, 17, 'MiniBeacon-12897', SYSTIMESTAMP-3, SYSTIMESTAMP-3, SYSTIMESTAMP-3);
insert into user_att_tb values ('p908v1', SYSDATE-2, 18, 'MiniBeacon-12897', SYSTIMESTAMP-2, SYSTIMESTAMP-2, SYSTIMESTAMP-2);
insert into user_att_tb values ('p908v1', SYSDATE-1, 19, 'MiniBeacon-12897', SYSTIMESTAMP-1, SYSTIMESTAMP-1, SYSTIMESTAMP-1);
insert into user_att_tb values ('p908v1', SYSDATE, 20, 'MiniBeacon-12897', SYSTIMESTAMP-0, SYSTIMESTAMP, SYSTIMESTAMP);


insert into user_att_tb values ('p908v2', SYSDATE-9, 21, 'MiniBeacon-12882', SYSTIMESTAMP-9, SYSTIMESTAMP-9, SYSTIMESTAMP-9);
insert into user_att_tb values ('p908v2', SYSDATE-8, 22, 'MiniBeacon-12882', SYSTIMESTAMP-8, SYSTIMESTAMP-8, SYSTIMESTAMP-8);
insert into user_att_tb values ('p908v2', SYSDATE-7, 23, 'MiniBeacon-12882', SYSTIMESTAMP-7, SYSTIMESTAMP-7, SYSTIMESTAMP-7);
insert into user_att_tb values ('p908v2', SYSDATE-6, 24, 'MiniBeacon-12882', SYSTIMESTAMP-6, SYSTIMESTAMP-6, SYSTIMESTAMP-6);
insert into user_att_tb values ('p908v2', SYSDATE-5, 25, 'MiniBeacon-12882', SYSTIMESTAMP-5, SYSTIMESTAMP-5, SYSTIMESTAMP-5);
insert into user_att_tb values ('p908v2', SYSDATE-4, 26, 'MiniBeacon-12882', SYSTIMESTAMP-4, SYSTIMESTAMP-4, SYSTIMESTAMP-4);
insert into user_att_tb values ('p908v2', SYSDATE-3, 27, 'MiniBeacon-12882', SYSTIMESTAMP-3, SYSTIMESTAMP-3, SYSTIMESTAMP-3);
insert into user_att_tb values ('p908v2', SYSDATE-2, 28, 'MiniBeacon-12882', SYSTIMESTAMP-2, SYSTIMESTAMP-2, SYSTIMESTAMP-2);
insert into user_att_tb values ('p908v2', SYSDATE-1, 29, 'MiniBeacon-12882', SYSTIMESTAMP-1, SYSTIMESTAMP-1, SYSTIMESTAMP-1);
insert into user_att_tb values ('p908v2', SYSDATE, 30, 'MiniBeacon-12882', SYSTIMESTAMP-0, SYSTIMESTAMP, SYSTIMESTAMP);

insert into user_att_tb values ('p908v3', SYSDATE-9, 31, 'MiniBeacon-12891', SYSTIMESTAMP-9, SYSTIMESTAMP-9, SYSTIMESTAMP-9);
insert into user_att_tb values ('p908v3', SYSDATE-8, 32, 'MiniBeacon-12891', SYSTIMESTAMP-8, SYSTIMESTAMP-8, SYSTIMESTAMP-8);
insert into user_att_tb values ('p908v3', SYSDATE-7, 33, 'MiniBeacon-12891', SYSTIMESTAMP-7, SYSTIMESTAMP-7, SYSTIMESTAMP-7);
insert into user_att_tb values ('p908v3', SYSDATE-6, 34, 'MiniBeacon-12891', SYSTIMESTAMP-6, SYSTIMESTAMP-6, SYSTIMESTAMP-6);
insert into user_att_tb values ('p908v3', SYSDATE-5, 35, 'MiniBeacon-12891', SYSTIMESTAMP-5, SYSTIMESTAMP-5, SYSTIMESTAMP-5);
insert into user_att_tb values ('p908v3', SYSDATE-4, 36, 'MiniBeacon-12891', SYSTIMESTAMP-4, SYSTIMESTAMP-4, SYSTIMESTAMP-4);
insert into user_att_tb values ('p908v3', SYSDATE-3, 37, 'MiniBeacon-12891', SYSTIMESTAMP-3, SYSTIMESTAMP-3, SYSTIMESTAMP-3);
insert into user_att_tb values ('p908v3', SYSDATE-2, 38, 'MiniBeacon-12891', SYSTIMESTAMP-2, SYSTIMESTAMP-2, SYSTIMESTAMP-2);
insert into user_att_tb values ('p908v3', SYSDATE-1, 39, 'MiniBeacon-12891', SYSTIMESTAMP-1, SYSTIMESTAMP-1, SYSTIMESTAMP-1);
insert into user_att_tb values ('p908v3', SYSDATE, 40, 'MiniBeacon-12891', SYSTIMESTAMP-0, SYSTIMESTAMP, SYSTIMESTAMP);
