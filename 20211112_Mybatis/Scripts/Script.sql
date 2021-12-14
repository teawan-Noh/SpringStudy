--MyBatis 연습을 위한 쿼리

--CTAS (Create Table As Select) : 기존에 있는 테이블 스키마(컬럼, 타입, 값)를 복제함 Not null 제외 제약조건 다 삭제해줌 테스트용으로 쓰임
CREATE TABLE JOBS_TEMP AS (SELECT * FROM JOBS J);

-- 전체조회
SELECT JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY 
	FROM JOBS_TEMP jt;
	
-- 단일조회
SELECT JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY 
	FROM JOBS_TEMP jt 
	WHERE JOB_ID = 'IT_PROG';

	
-- Select01 테스트
SELECT COUNT(*) 
	FROM JOBS_TEMP jt 
	WHERE JOB_ID = 'IT_PROG';
	
-- Select02 테스트

SELECT JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY 
	FROM JOBS_TEMP jt 
	WHERE JOB_ID = 'IT_PROG';
	
-- Select 03 테스트
-- 맵핑되는 VO의 Setter의 명으로 Alias를 맞춰준다.
SELECT EMPLOYEE_ID JOB_ID, FIRST_NAME || LAST_NAME JOB_TITLE,
		MANAGER_ID MIN_SALARY, DEPARTMENT_ID MAX_SALARY
	FROM EMPLOYEES e ;

-- Select 03_1 테스트
-- 맵핑이 되는 VO와 결과 Column을 sql문에서 처리하지 않고 mybatis의 resultMap 기능을 통해 정의
-- 컬럼은 무조건 대문자
-- sql문에서 ""을 사용하는 경우 : 1. 예약어로 되어 있는 경우 , 2. alias를 선언할 때 공백을 포함하는 경우
-- create 문을 생성할때 "school" ""로 묶으면 from 부를때 ""빼면 안불러짐 
	SELECT EMPLOYEE_ID, FIRST_NAME || LAST_NAME NAME,
		MANAGER_ID, DEPARTMENT_ID
	FROM EMPLOYEES e ;

-- ETC
SELECT *
	FROM DUAL; --값이 있는 걸까? 없는걸까? : dual 값이 X가 나온다
	
SELECT *
	FROM EMPLOYEES e 
	WHERE EMPLOYEE_ID = '3333';

SELECT *
	FROM JOBS_TEMP jt 
	WHERE JOB_ID = 'IT_PROG' AND JOB_TITLE = 'Programmer';

--용어 : 공집합 , null
--공집합은 결과가 없는 상태
--null은 null값이 들어가 있는 형태
SELECT COMMISSION_PCT 
	FROM EMPLOYEES e 
	WHERE COMMISSION_PCT IS NULL ;
	

--211116
ALTER TABLE JOBS_TEMP ADD(SEQ NUMBER); 

ALTER TABLE JOBS_TEMP DROP COLUMN SQE;

CREATE SEQUENCE JOBS_TEMP_SEQ START WITH 1 INCREMENT BY 1;

SELECT JOBS_TEMP_SEQ.NEXTVAL
	FROM DUAL;

SELECT JOBS_TEMP_SEQ.CURRVAL
	FROM DUAL;
	
INSERT INTO JOBS_TEMP
(JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY, SEQ)
VALUES('Goodee', 'Academy', 1000, 3000, JOBS_TEMP_SEQ.NEXTVAL);

SELECT JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY, SEQ
FROM JOBS_TEMP
WHERE SEQ = (SELECT MAX(NVL(SEQ,0))
	FROM JOBS_TEMP jt);

SELECT MAX(NVL(SEQ,0))
	FROM JOBS_TEMP jt ;

SELECT * FROM JOBS_TEMP jt ;

--update01
UPDATE JOBS_TEMP
	SET JOB_ID='구디', JOB_TITLE='학원'
	WHERE LOWER(JOB_ID) = 'goodee' AND SEQ = '24';

SELECT *
	FROM JOBS_TEMP jt 
	WHERE LOWER(JOB_ID) = LOWER('Goodee') ;

--delete01
DELETE FROM JOBS_TEMP jt
	WHERE SEQ = '23';


-- 실습 --------------
CREATE TABLE BOARD(
	SEQ NUMBER,
	TITLE VARCHAR2(50),
	CONTENT VARCHAR2(2000),
	REGDATE DATE
);

ALTER TABLE BOARD ADD CONSTRAINT BOARD_PK PRIMARY KEY(SEQ);

CREATE SEQUENCE BOARD_SEQ START WITH 1 INCREMENT BY 1;

-- 입력
INSERT INTO BOARD VALUES (BOARD_SEQ.NEXTVAL, '게시판', '내용입니다', '2021-11-16');
INSERT INTO BOARD VALUES (BOARD_SEQ.NEXTVAL, '게시판2', '이거', '2021-11-16');
INSERT INTO BOARD VALUES (BOARD_SEQ.NEXTVAL, '게시판3', '컨텐츠', '2021-11-16');

-- 전체조회
SELECT * 
	FROM BOARD b ;
-- 상세조회 (단일조회)
SELECT SEQ, TITLE, CONTENT, REGDATE
	FROM BOARD b 
	WHERE SEQ = '1';
-- 수정
UPDATE BOARD SET CONTENT = '수정내용'
	WHERE SEQ = '1';
-- 삭제
DELETE 
	FROM BOARD b 
	WHERE SEQ = '1';

--------------------------------------------------------
--2021-11-17
--binding01
SELECT JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY 
	FROM JOBS j 
	WHERE JOB_ID  = 'IT_PROG';

SELECT JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY 
	FROM JOBS j 
	WHERE JOB_TITLE  = 'Programmer';

--binding02
--like
SELECT JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY 
			FROM JOBS j 
			WHERE JOB_ID LIKE 'IT'||'%';
