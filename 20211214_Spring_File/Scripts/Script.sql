--Paging 연습을 위한 테이블
CREATE TABLE PAGING(
	TITLE VARCHAR2(1000),
	REGDATE DATE
);
SELECT * FROM PAGING p ;
--글입력
INSERT INTO PAGING (TITLE, REGDATE)
	VALUES('글',SYSDATE);

--글삭제
DELETE FROM PAGING;

--전체 글의 개수
SELECT NVL(COUNT(*),0) FROM PAGING;

--ROWNUM QUERY 범위를 가진 Paging
--1) 입력되어 있는 데이터를 요구조건의 정렬에 따라서 정제 => INLINE VIEW
--2) 1)정제된 데이터에서 순서를 정하는 ROWNUM을 실행하고
--3) 2)페이징 처리(BETWEEN AND)

SELECT *
	FROM(
		SELECT ROWNUM RNUM, p.*
			FROM(
				SELECT *
					FROM PAGING p
					ORDER BY REGDATE DESC			
				)p
	)
	WHERE RNUM BETWEEN 4 AND 6;

--WINDOW FN을 통한 ROWNUM 처리
--WINDOWING 절 : WINDOW FUNCTION에 OREDER BY의 처리 방식 default(ROWS BETWEEN UNBOUNCED PRECIDING AND FOLLOWING)
SELECT *
	FROM (
		SELECT p.*, ROW_NUMBER () OVER(ORDER BY REGDATE DESC) RNUM
			FROM PAGING p
	)
	WHERE RNUM BETWEEN 0 AND 3;
















