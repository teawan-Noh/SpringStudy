--회원가입시 비밀번호 암호화 가입 및 로그인
-- OWASP : https://blog.alyac.co.kr/4135 참고

CREATE TABLE USERSECURITY(
	NAME VARCHAR2(30),
	PASSWORD VARCHAR2(2000)
);

SELECT * FROM USERSECURITY u ;