CREATE TABLE SEOULBIKE(
NEW_ADDR VARCHAR2(100),
CONTENT_ID NUMBER,
ADDR_GU VARCHAR2(100),
LONGITUDE NUMBER,
CRADLE_COUNT NUMBER,
LATITUDE NUMBER,
CONTENT_NM VARCHAR2(100)
);


INSERT INTO SEOULBIKE
	(NEW_ADDR, CONTENT_ID, ADDR_GU, LONGITUDE, CRADLE_COUNT, LATITUDE, CONTENT_NM)
	VALUES(new_addr, content_id, addr_gu, longitude, cradle_count, latitude, content_nm);