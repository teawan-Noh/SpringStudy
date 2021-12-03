<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>

<c:catch var="err">
<c:set var="weatherURL" value="http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=${code}" />
<c:import var="weather" url="${weatherURL}" />
<x:parse var="wrd" xml="${weather}" />
{"x":"<x:out select="$wrd/rss/channel/item/description/header/x"/>",
"y":"<x:out select="$wrd/rss/channel/item/description/header/y"/>",
"pubDate":"<x:out select="$wrd/rss/channel/pubDate"/>",
"wfKor":"<x:out select="$wrd/rss/channel/item/description/body/data/wfKor"/>",
"temp":"<x:out select="$wrd/rss/channel/item/description/body/data/temp"/>",
"pop":"<x:out select="$wrd/rss/channel/item/description/body/data/pop"/>",
"reh":"<x:out select="$wrd/rss/channel/item/description/body/data/reh"/>"}
</c:catch>
<c:if test="${err != null}">
${err}
</c:if>
