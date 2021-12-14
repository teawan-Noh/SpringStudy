package com.min.edu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.constant.CardConstant;
import com.siot.IamportRestClient.request.*;
import com.siot.IamportRestClient.request.naver.*;
import com.siot.IamportRestClient.response.*;
import org.junit.Before;
import org.junit.Test;

import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.escrow.EscrowLogisData;
import com.siot.IamportRestClient.request.escrow.EscrowLogisInvoiceData;
import com.siot.IamportRestClient.request.escrow.EscrowLogisPersonData;
import com.siot.IamportRestClient.response.escrow.EscrowLogisInvoice;
import com.siot.IamportRestClient.response.naver.NaverProductOrder;

/**
 * Unit test for simple App.
 */
public class IamportRestTest {
	
	IamportClient client;
	
//	private IamportClient getNaverTestClient() {
//		String test_api_key = "6833076151848562";
//		String test_api_secret = "8cb171ad19502807f44c2224bb7043e04bbf3de216913e05207c936292513f0ad798b4707825784c";
//		
//		return new IamportClient(test_api_key, test_api_secret);
//	}
//
//	private IamportClient getBillingTestClient() {
//		String test_api_key = "6833076151848562";
//		String test_api_secret = "8cb171ad19502807f44c2224bb7043e04bbf3de216913e05207c936292513f0ad798b4707825784c";
//
//		return new IamportClient(test_api_key, test_api_secret);
//	}
	
	@Before
	public void setup() {
		String test_api_key = "6833076151848562";
		String test_api_secret = "8cb171ad19502807f44c2224bb7043e04bbf3de216913e05207c936292513f0ad798b4707825784c";
		client = new IamportClient(test_api_key, test_api_secret);
	}
	
	@Test
	public void testGetToken() {
		try {
			IamportResponse<AccessToken> auth_response = client.getAuth();
			
			assertNotNull(auth_response.getResponse());
			assertNotNull(auth_response.getResponse().getToken());
		} catch (IamportResponseException e) {
			System.out.println(e.getMessage());
			
			switch(e.getHttpStatusCode()) {
			case 401 :
				//TODO
				break;
			case 500 :
				//TODO
				break;
			}
		} catch (IOException e) {
			//서버 연결 실패
			e.printStackTrace();
		}
	}
//	//현재는 PAYCO, KCP만 지원됩니다
//	@Test
//	public void testPaymentBalanceByImpUid() {
//		String test_imp_uid = "imp_581562621950";
//		try {
//			IamportResponse<PaymentBalance> payment_response = client.paymentBalanceByImpUid(test_imp_uid);
//			
//			assertNotNull(payment_response.getResponse());
//		} catch (IamportResponseException e) {
//			System.out.println(e.getMessage());
//			
//			switch(e.getHttpStatusCode()) {
//			case 401 :
//				//TODO
//				break;
//			case 500 :
//				//TODO
//				break;
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
//	//요청 uid와 iamport에 등록된 uid가 같은지 확인
//	@Test
//	public void testPaymentByImpUid() {
//		String test_imp_uid = "imp_006461532804";
//		try {
//			IamportResponse<Payment> payment_response = client.paymentByImpUid(test_imp_uid);
//			System.out.println(payment_response.getResponse().getImpUid());
//			assertNotNull(payment_response.getResponse());
//			assertEquals(test_imp_uid, payment_response.getResponse().getImpUid());
//		} catch (IamportResponseException e) {
//			System.out.println(e.getMessage());
//			
//			switch(e.getHttpStatusCode()) {
//			case 401 :
//				//TODO
//				break;
//			case 500 :
//				//TODO
//				break;
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		String test_imp_uid_cancelled = "imp_006461532804";
//		try {
//			IamportResponse<Payment> cancelled_response = client.paymentByImpUid(test_imp_uid_cancelled);
//			
//			Payment cancelled = cancelled_response.getResponse();
//			PaymentCancelDetail[] cancelDetail = cancelled.getCancelHistory();
//			System.out.println(cancelDetail[0].getReason());
//			System.out.println(cancelDetail[0].getAmount());
//			System.out.println(cancelDetail[0].getCancelledAt()); // 1637658558 ??? 취소날짜 나오는거 아닌가???
//			System.out.println(cancelDetail[0].getReceiptUrl());
//			assertEquals(cancelDetail.length, 1);
//			assertNotNull(cancelDetail[0].getPgTid());
//		} catch (IamportResponseException e) {
//			System.out.println(e.getMessage());
//			
//			switch(e.getHttpStatusCode()) {
//			case 401 :
//				//TODO
//				break;
//			case 500 :
//				//TODO
//				break;
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
//	//결제상태에 따른 호출
//	@Test
//	public void testPaymentsByStatusAll() {
//		try {
//			IamportResponse<PagedDataList<Payment>> r_response = client.paymentsByStatus("ready");
//			IamportResponse<PagedDataList<Payment>> p_response = client.paymentsByStatus("paid");
//			IamportResponse<PagedDataList<Payment>> f_response = client.paymentsByStatus("failed");
//			IamportResponse<PagedDataList<Payment>> c_response = client.paymentsByStatus("cancelled");
//			IamportResponse<PagedDataList<Payment>> all_response = client.paymentsByStatus("all");
//			
//			assertNotNull(all_response.getResponse());
//			assertNotNull(r_response.getResponse());
//			assertNotNull(p_response.getResponse());
//			assertNotNull(f_response.getResponse());
//			assertNotNull(c_response.getResponse());
//			
//			assertTrue(all_response.getResponse().getTotal() == 
//					r_response.getResponse().getTotal() + p_response.getResponse().getTotal() + f_response.getResponse().getTotal() + c_response.getResponse().getTotal());
//		} catch (IamportResponseException e) {
//			System.out.println(e.getMessage());
//			
//			switch(e.getHttpStatusCode()) {
//			case 401 :
//				//TODO
//				break;
//			case 500 :
//				//TODO
//				break;
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
//  checksum 검증 추가 버전 ImpUid를 통한 결제 취소 : valueOf(금액) 금액이 iamport서버와 다를경우 결제 취소 요청이 실패됨
	@Test
	public void testCancelPaymentChecksumByImpUid() {
		String test_already_cancelled_imp_uid = "imp_004190650691";
		CancelData cancel_data = new CancelData(test_already_cancelled_imp_uid, true); //imp_uid를 통한 전액취소
		cancel_data.setChecksum(BigDecimal.valueOf(10)); // checksum 으로 검증 추가

		try {
			//결제취소 요청
			IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);
			System.out.println(payment_response.getResponse());
			assertNull(payment_response.getResponse());
		} catch (IamportResponseException e) {
			System.out.println(e.getMessage());
			
			switch(e.getHttpStatusCode()) {
				case 401 :
					//TODO
					break;
				case 500 :
					//TODO
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	merchant_uid 통한 전액취소
//	@Test
//	public void testCancelPaymentAlreadyCancelledMerchantUid() {
//		String test_already_cancelled_merchant_uid = "merchant_1638439838683";
//		CancelData cancel_data = new CancelData(test_already_cancelled_merchant_uid, false); //merchant_uid를 통한 전액취소
//		
//		try {
//			IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);
//			System.out.println(payment_response.getResponse());
//			assertNull(payment_response.getResponse()); // 이미 취소된 거래는 response가 null이다
//			System.out.println(payment_response.getMessage());
//		} catch (IamportResponseException e) {
//			System.out.println(e.getMessage());
//			
//			switch(e.getHttpStatusCode()) {
//			case 401 :
//				//TODO
//				break;
//			case 500 :
//				//TODO
//				break;
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//	}
	
	//부분취소 안쓸꺼같은데
//	@Test
//	public void testPartialCancelPaymentAlreadyCancelledImpUid() {
//		String test_already_cancelled_imp_uid = "imp_448280090638";
//		CancelData cancel_data = new CancelData(test_already_cancelled_imp_uid, true, BigDecimal.valueOf(500)); //imp_uid를 통한 500원 부분취소
//
//		try {
//			IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);
//			
//			assertNull(payment_response.getResponse()); // 이미 취소된 거래는 response가 null이다
//			System.out.println(payment_response.getMessage());
//		} catch (IamportResponseException e) {
//			System.out.println(e.getMessage());
//			
//			switch(e.getHttpStatusCode()) {
//			case 401 :
//				//TODO
//				break;
//			case 500 :
//				//TODO
//				break;
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
//partial 안씀
//	@Test
//	public void testPartialCancelPaymentAlreadyCancelledMerchantUid() {
//		String test_already_cancelled_merchant_uid = "merchant_1448280088556";
//		CancelData cancel_data = new CancelData(test_already_cancelled_merchant_uid, false, BigDecimal.valueOf(500)); //merchant_uid를 통한 500원 부분취소
//		
//		try {
//			IamportResponse<Payment> payment_response = client.cancelPaymentByImpUid(cancel_data);
//			
//			assertNull(payment_response.getResponse()); // 이미 취소된 거래는 response가 null이다
//			System.out.println(payment_response.getMessage());
//		} catch (IamportResponseException e) {
//			System.out.println(e.getMessage());
//			
//			switch(e.getHttpStatusCode()) {
//			case 401 :
//				//TODO
//				break;
//			case 500 :
//				//TODO
//				break;
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	//인증테스트? 어디에 쓰는건지 확인 필요
//	@Test
//	public void testCertificationByImpUid() {
////		String test_imp_uid = "imp_339323965143";
//		// origin 검증을 위해 is not null인 imp_uid로 변경
//		String test_imp_uid = "imp_132904804683";
//		
//		try {
//			IamportResponse<Certification> certification_response = client.certificationByImpUid(test_imp_uid);
//			
//			assertNotNull(certification_response.getResponse());
//			assertEquals(test_imp_uid, certification_response.getResponse().getImpUid());
//			assertEquals("http://kicc.iamport.kr/pages/certi", certification_response.getResponse().getOrigin());
//		} catch (IamportResponseException e) {
//			System.out.println(e.getMessage());
//			
//			switch(e.getHttpStatusCode()) {
//			case 401 :
//				//TODO
//				break;
//			case 500 :
//				//TODO
//				break;
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	
//	@Test
//	public void testOnetimePayment() {
//		CardInfo card = new CardInfo("1234123412341234", "201901", "801231", "00");
//		OnetimePaymentData onetime_data = new OnetimePaymentData(getRandomMerchantUid(), BigDecimal.valueOf(1004), card);
//		onetime_data.setName("ActiveX없는결제테스트");
//		onetime_data.setBuyerName("구매자");
//		onetime_data.setBuyerEmail("iamport@siot.do");
//		onetime_data.setBuyerTel("16705176");
//		
//		IamportResponse<Payment> payment_response = client.onetimePayment(onetime_data);
//		assertEquals(payment_response.getResponse().getStatus(), "paid");
//	}
	
}
