
select	* from LIST_SEATED_USER_TODAY_VW
WHERE	OFFICE_SEQ = 4;

drop table user_att_tb;
drop table user_device_tb;
drop table user_seat_tb;
drop table user_tb;
drop table att_policy_tb;
drop table beacon_tb;
drop table seat_tb;
drop table dept_tb;
drop table office_tb;


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
	OFFICE_SEQ		NUMBER 	NOT NULL,
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
    SEAT_REAL_LOCATION    VARCHAR2(100),
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


INSERT  INTO    OFFICE_TB   VALUES(1, 9, 'CENTRAL');
INSERT  INTO    OFFICE_TB   VALUES(2, 10, 'CENTRAL');
INSERT  INTO    OFFICE_TB   VALUES(3, 13, 'CENTRAL');
INSERT  INTO    OFFICE_TB   VALUES(4, 14, 'CENTRAL');


insert into dept_tb values ('HR', '인사팀', null, '명동');
insert into dept_tb values ('DEPARTMENT', '백화점팀', null, '명동');
insert into dept_tb values ('STARBUCKS', '스타벅스팀', null, '시청');
insert into dept_tb values ('EMART', '이마트팀', null, '성수');
insert into dept_tb values ('POS', 'POS팀', null, '명동');


select * from USER_SEAT_TB;
-------------------------------------------------------------------------------------------------------------
-- 김기찬 
INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)

VALUES(2,'10','A','Y','10F-A-10');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)

VALUES(2,'12','A','Y','10F-A-12');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)

VALUES(4,'60','B','Y','14F-B-60');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)

VALUES(4,'61','B','Y','14F-B-61');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)

VALUES(4,'1','A','Y','14F-A-1');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)

VALUES(4,'2','A','Y','14F-A-2');

-----------------------------------------------------------
INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(1,'1','A','N','9F-A-1');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(1,'2','A','N','9F-A-2');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(1,'3','A','N','9F-A-3');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(1,'4','A','N','9F-A-4');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(1,'5','A','N','9F-A-5');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(1,'6','A','N','9F-A-6');

-------------------------------------------------------------------------------------------------------------


INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(2,'51','A','N','10F-A-51');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(2,'52','A','N','10F-A-52');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(2,'53','A','N','10F-A-53');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(2,'54','A','N','10F-A-54');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(2,'55','A','N','10F-A-55');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(2,'56','A','N','10F-A-56');


-------------------------------------------------------------------------------------------------------------


INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(3,'1','A','N','13F-A-1');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(3,'2','A','N','13F-A-2');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(3,'3','A','N','13F-A-3');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(3,'4','A','N','13F-A-4');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(3,'5','A','N','13F-A-5');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(3,'6','A','N','13F-A-6');


-------------------------------------------------------------------------------------------------------------

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(4,'51','A','N','14F-A-51');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(4,'52','A','N','14F-A-52');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(4,'53','A','N','14F-A-53');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(4,'54','A','N','14F-A-54');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(4,'55','A','N','14F-A-55');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(4,'56','A','N','14F-A-56');

-------------------------------------------------------------------------------------------------------------

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(4,'41','B','N','14F-B-41');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(4,'42','B','N','14F-B-42');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(4,'43','B','N','14F-B-43');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(4,'44','B','N','14F-B-44');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(4,'45','B','N','14F-B-45');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(4,'46','B','N','14F-B-46');


-------------------------------------------------------------------------------------------------------------

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(1,'31','B','N','9F-B-31');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(1,'32','B','N','9F-B-32');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(1,'33','B','N','9F-B-33');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(1,'34','B','N','9F-B-34');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(1,'35','B','N','9F-B-35');

INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(1,'36','B','N','9F-B-36');

-------------------------------------------------------------------------------------------------------------
INSERT  INTO    SEAT_TB (OFFICE_SEQ, SEAT_ID, SEAT_REAL_LOCATION, SEAT_USEABLE_STATE, SEAT_NFC_TAG_ID)
VALUES(4,'1','A','N','14F-A-1');


INSERT  INTO    BEACON_TB VALUES('B1', 3, '78:A5:04:4F:53:61', 'TEST', 'TEST');
INSERT  INTO    BEACON_TB VALUES('MiniBeacon-12882', 2, 'C1:00:47:00:32:52', '10F-A', '10F-A');
INSERT  INTO    BEACON_TB VALUES('MiniBeacon-12891', 2, 'C1:00:47:00:32:5B', '10F-B', '10F-B');
INSERT  INTO    BEACON_TB VALUES('MiniBeacon-12894', 4, 'C1:00:47:00:32:5E', '14F-A', '14F-A');
INSERT  INTO    BEACON_TB VALUES('MiniBeacon-12897', 4, 'C1:00:47:00:32:61', '14F-B', '14F-B');


insert into att_policy_tb values ('HR', 'POLICY1', 'N', 7);
insert into att_policy_tb values ('HR', 'POLICY2', 'Y', 6);
insert into att_policy_tb values ('DEPARTMENT', 'POLICY2', 'Y', 6);
insert into att_policy_tb values ('STARBUCKS', 'POLICY3', 'Y', 7);
insert into att_policy_tb values ('EMART', 'POLICY4', 'N', 8);
insert into att_policy_tb values ('POS', 'POLICY5', 'N', 7);



insert into user_tb values ('p908v1', 'rlarlcks', '김기찬', 'Y', '010-1234-1234', 'EMART', 'CEO', SYSDATE, default);
insert into user_tb values ('p908v2', 'rlatmdgml', '김승희', 'Y', '010-1234-1234', 'HR', '인턴', SYSDATE-2, default);
insert into user_tb values ('p908v3', 'dlrbtkd', '이규상', 'N', '010-1234-1234', 'DEPARTMENT', '인턴', SYSDATE-3, default);
insert into user_tb values ('p908vd', 'whguswo', '조현재', 'Y', '010-1234-1234', 'STARBUCKS', '인턴', SYSDATE-1, default);
insert into user_tb values ('p908v4', 'ghdrlfehd', '홍길동', 'N', '010-1234-1234', 'POS', '인턴', SYSDATE, default);
insert into user_tb values ('p908v5', 'rlacjftn', '김철수', 'N', '010-1234-1234', 'HR', '인턴', SYSDATE, default);






INSERT  INTO    USER_SEAT_TB    VALUES ('p908v1', '1',4, SYSDATE, 'N');

INSERT  INTO    USER_SEAT_TB    VALUES ('p908v2', '2',4, SYSDATE, 'N');

INSERT  INTO    USER_SEAT_TB    VALUES ('p908v1', '1',4, SYSDATE-1, 'N');

INSERT  INTO    USER_SEAT_TB    VALUES ('p908v2', '2',4, SYSDATE-2, 'N');




INSERT  INTO    USER_SEAT_TB    VALUES ('p908v1', '1',1, SYSDATE, 'N');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908v1', '2',1, SYSDATE, 'Y');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908v1', '3',1, SYSDATE-1, 'N');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908v1', '4',1, SYSDATE-1, 'Y');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908v1', '5',1, SYSDATE-2, 'N');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908v1', '6',1, SYSDATE-2, 'Y');

INSERT  INTO    USER_SEAT_TB    VALUES ('p908v2', '51',2, SYSDATE, 'N');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908v2', '52',2, SYSDATE, 'Y');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908v2', '53',2, SYSDATE-1, 'N');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908v2', '54',2, SYSDATE-1, 'Y');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908v2', '55',2, SYSDATE-2, 'N');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908v2', '56',2, SYSDATE-2, 'Y');

INSERT  INTO    USER_SEAT_TB    VALUES ('p908v3', '1',3, SYSDATE, 'N');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908v3', '2',3, SYSDATE, 'Y');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908v3', '3',3, SYSDATE-1, 'N');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908v3', '4',3, SYSDATE-1, 'N');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908v3', '5',3, SYSDATE-2, 'Y');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908v3', '6',3, SYSDATE-2, 'N');

INSERT  INTO    USER_SEAT_TB    VALUES ('p908vd', '51',4, SYSDATE, 'Y');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908vd', '52',4, SYSDATE, 'N');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908vd', '53',4, SYSDATE-1, 'N');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908vd', '54',4, SYSDATE-1, 'N');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908vd', '55',4, SYSDATE-2, 'Y');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908vd', '56',4, SYSDATE-2, 'N');

INSERT  INTO    USER_SEAT_TB    VALUES ('p908v4', '41',4, SYSDATE, 'Y');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908v4', '42',4, SYSDATE, 'Y');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908v4', '43',4, SYSDATE-1, 'Y');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908v4', '44',4, SYSDATE-1, 'Y');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908v4', '45',4, SYSDATE-2, 'Y');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908v4', '46',4, SYSDATE-2, 'Y');

INSERT  INTO    USER_SEAT_TB    VALUES ('p908v5', '31',1, SYSDATE, 'Y');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908v5', '32',1, SYSDATE, 'Y');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908v5', '33',1, SYSDATE-1, 'Y');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908v5', '34',1, SYSDATE-1, 'Y');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908v5', '35',1, SYSDATE-2, 'Y');
INSERT  INTO    USER_SEAT_TB    VALUES ('p908v5', '36',1, SYSDATE-2, 'Y');

DROP VIEW BEACON_OFFICE_VW;

CREATE VIEW BEACON_OFFICE_VW
AS
(
    SELECT  BEACON_ID, 
    		BEACON_ADDR, 
    		BEACON_POSITION, 
    		BEACON_ALIAS, 
    		FLOOR_NUM,
    		BUILDING_NAME
    FROM    BEACON_TB
    JOIN    OFFICE_TB   USING(OFFICE_SEQ)
);

DROP VIEW LIST_SEATED_USER_VW;

CREATE VIEW LIST_SEATED_USER_VW
AS
(   SELECT  S.OFFICE_SEQ, 
			S.SEAT_ID, 
			S.SEAT_REAL_LOCATION, 
			S.SEAT_USEABLE_STATE, 
			S.SEAT_NFC_TAG_ID, 
			SU.USER_ID, 
			SU.SEATED_DATE, 
			SU.USER_LEAVE_YN
    FROM    SEAT_TB   S
    LEFT    JOIN   USER_SEAT_TB  SU  ON(S.SEAT_ID = SU.SEAT_ID)
)
ORDER   BY  S.OFFICE_SEQ, S.SEAT_REAL_LOCATION, S.SEAT_ID;

DROP VIEW     LIST_SEATED_USER_TODAY_VW;

CREATE  VIEW    LIST_SEATED_USER_TODAY_VW
AS
(
    SELECT  S.OFFICE_SEQ, 
    		S.SEAT_ID, 
    		S.SEAT_REAL_LOCATION, 
    		S.SEAT_USEABLE_STATE, 
    		S.SEAT_NFC_TAG_ID, 
    		SU.USER_ID, SU.SEATED_DATE, SU.USER_LEAVE_YN
    FROM    SEAT_TB 	S
    LEFT    JOIN    
    (
    SELECT 	USER_ID, 
        	SEAT_ID, 
        	OFFICE_SEQ, 
        	DECODE(MAX(TO_DATE(SEATED_DATE, 'YYYY-MM-DD')),TO_DATE(CURRENT_DATE,'YYYY-MM-DD'),TO_DATE(CURRENT_DATE,'YYYY-MM-DD'), NULL) AS SEATED_DATE, USER_LEAVE_YN 
    FROM USER_SEAT_TB
    GROUP BY USER_ID, SEAT_ID, OFFICE_SEQ, USER_LEAVE_YN
    ) SU  ON(S.SEAT_ID = SU.SEAT_ID)
    WHERE   SEATED_DATE IS NULL
    OR      SEATED_DATE = TO_DATE(CURRENT_DATE, 'YYYY-MM-DD')
)
ORDER   BY  S.OFFICE_SEQ, S.SEAT_REAL_LOCATION, S.SEAT_ID;





