<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript">

/* var IMP = window.IMP; // 생략 가능
IMP.init("{가맹점 식별코드}"); // 예: imp00000000 */

	function request_pay(){
	//가맹점 식별코드
	IMP.init('imp51549826');
	IMP.request_pay({
	    pg : 'html5_inicis',
	    pay_method : 'card',
	    merchant_uid : 'merchant_' + new Date().getTime(),
	    name : '상품1' , //결제창에서 보여질 이름
	    amount : 10, //실제 결제되는 가격
	    buyer_email : 'iamport@siot.do',
	    buyer_name : '구매자이름',
	    buyer_tel : '010-1234-5678',
	    /* buyer_addr : '서울 강남구 도곡동',
	    buyer_postcode : '123-456' */
	}, function(rsp) {
		console.log(rsp);
	    if ( rsp.success ) {
	    	var msg = '결제가 완료되었습니다.';
	        msg += '고유ID : ' + rsp.imp_uid;
	        msg += '상점 거래ID : ' + rsp.merchant_uid;
	        msg += '결제 금액 : ' + rsp.paid_amount;
	        msg += '카드 승인번호 : ' + rsp.apply_num;
	    } else {
	    	 var msg = '결제에 실패하였습니다.';
	         msg += '에러내용 : ' + rsp.error_msg;
	    }
	    alert(msg);
	});
}
</script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
</script>
<script type="text/javascript">
  function cancelPay() {
    jQuery.ajax({
      "url": "{http://localhost:8095/edu/}", // 예: http://www.myservice.com/payments/cancel
      "type": "POST",
      "contentType": "application/json",
      "data": JSON.stringify({
        "merchant_uid": "{merchant_1637606460507}", // 예: ORD20180131-0000011
        "cancel_request_amount": 10, // 환불금액
        "reason": "테스트 결제 환불" // 환불사유
        /* "refund_holder": "홍길동", // [가상계좌 환불시 필수입력] 환불 수령계좌 예금주
        "refund_bank": "88" // [가상계좌 환불시 필수입력] 환불 수령계좌 은행코드(예: KG이니시스의 경우 신한은행은 88번)
        "refund_account": "56211105948400" // [가상계좌 환불시 필수입력] 환불 수령계좌 번호 */
      }),
      "dataType": "json"
    });
  }
</script>
</head>
<body>
	<h2>첫화면인데</h2>
	<button onclick="request_pay()">결제</button>
	<button onclick="cancelPay()">환불하기</button>
</body>


</html>