ALTER TABLE ANSWERBOARD DROP CONSTRAINT SYS_C007005;

ALTER TABLE ANSWERBOARD MODIFY CONTENT DEFAULT '작성된 글이 없음..';

--익명적 방법
--모든 컬럼의 순서를 DB에 입력되어있는 순서대로 입력한다.
--입력되는 VALUES의 모든 항목을 입력해야한다.
--DEFAULT 제약조건이 작동되지 않는다.
INSERT INTO ANSWERBOARD
--(SEQ, ID, TITLE, CONTENT, REFER, STEP, "DEPTH", DELFLAG, REGDATE)
VALUES(ANSWERBOARD_SEQ.NEXTVAL, 'USER0A', '안녕', '',(SELECT NVL(MAX(REFER),0)FROM ANSWERBOARD a)+1, 0, 0, 'N', SYSDATE);

INSERT INTO ANSWERBOARD
--(SEQ, ID, TITLE, CONTENT, REFER, STEP, "DEPTH", DELFLAG, REGDATE)
VALUES(ANSWERBOARD_SEQ.NEXTVAL, 'USER0A', '안녕', NULL,(SELECT NVL(MAX(REFER),0)FROM ANSWERBOARD a)+1, 0, 0, 'N', SYSDATE);

SELECT *
	FROM ANSWERBOARD a
	ORDER BY REGDATE DESC;
	

--명시적 방법을 통한 입력
--컬럼을 모두 작성해줘야 한다.
--순서에 상관없이 컬럼의 선언된 순서에 맞춰서 VALUES를 작성하면 된다.
--사용하지 않는 값에 대해서 만약에 COLUMN이 DEFAULT 처리되어 있다면 DEFAULT값이 입력된다. 
INSERT INTO ANSWERBOARD
(SEQ, ID, TITLE, REFER, STEP, "DEPTH", DELFLAG, REGDATE)
VALUES(ANSWERBOARD_SEQ.NEXTVAL, 'USER0A', '안녕1', (SELECT NVL(MAX(REFER),0)FROM ANSWERBOARD a)+1, 0, 0, 'N', SYSDATE);