package com.min.edu.ctrl;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.AuthData;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.AccessToken;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

import retrofit2.Call;
import retrofit2.HttpException;
import retrofit2.Response;

@Controller
public class IamportController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private IamportClient client;
	
	public IamportController() {
		String api_key = "6833076151848562";
		String api_secret = "8cb171ad19502807f44c2224bb7043e04bbf3de216913e05207c936292513f0ad798b4707825784c";
		client = new IamportClient(api_key, api_secret);
//			IamportResponse<AccessToken> access_token = client.getAuth();
//			System.out.println("access_token: " + access_token.getResponse().getToken());
	}
	
	/**
	 * 결제 요청은 클라이언트 상에서 이루어지기 때문에 클라이언트의 스크립트를 조작해 금액을 위변조하여 결제를 요청할 수 있습니다. 
	 * 따라서 결제 프로세스 완료 후 처음 요청했던 금액과 실제로 결제된 금액을 비교하여 일치하지 않을 경우 결제 취소시키는 로직을 구현
	 * @param imp_uid: client-side에서 넘겨받은 imp_uid
	 * @param paid_amount: client-side에서 넘겨받은 paid_amount
	 */
	@ResponseBody
	@RequestMapping(value="/verifyPayInfo.do", method = RequestMethod.POST)
	public IamportResponse<Payment> verifyPaymentByImpUid(Model model, HttpSession session, String imp_uid, String paid_amount) throws IamportResponseException, IOException{	
			logger.info("paymentByImpUid 실행");
			
//			String iamportServerAmount = client.paymentByImpUid("imp_155216410209").getResponse().getAmount().toString();
			String iamportServerAmount = client.paymentByImpUid(imp_uid).getResponse().getAmount().toString();
			System.out.println("iamportServerAmount: " + iamportServerAmount);
			//imp_uid로 아임포트 서버에서 조회하여 data를 반환시킴 // 결제금액이 일치하지 않을경우 결제 취소됨
			if(paid_amount.equals(iamportServerAmount)) {
				System.out.println("인증성공");
				//인증에 성공했으므로 데이터베이스에 저장하는 로직 추가해주면 된다.
				//검증을 더 빡세게 할 수있을까? 생각해보기
			}else {
				System.out.println("인증실패");
				CancelData cancel_data = new CancelData(imp_uid, true); //imp_uid를 통한 전액취소
				client.cancelPaymentByImpUid(cancel_data);
				//위변조 시도된 경우도 데이터베이스에 저장하는가?
			}
			return client.paymentByImpUid(imp_uid);
	}
	
	@ResponseBody
	@RequestMapping(value="/cancelPay.do", method = RequestMethod.GET)
	public IamportResponse<Payment> cancelByImpUid(Model model, HttpSession session, String imp_uid, String cancel_request_amount) throws IamportResponseException, IOException{	
		System.out.println("호출됨");
		System.out.println(imp_uid);
		System.out.println(client.paymentByImpUid(imp_uid).getResponse().getImpUid());
		
		int client_cancel_request_amount = Integer.parseInt(cancel_request_amount);
		CancelData cancel_data = new CancelData(imp_uid, true);
		//서버와 아임포트 서버간에 환불 가능 금액을 검증 (부분 취소할때 사용하면 좋을듯)
		cancel_data.setChecksum(BigDecimal.valueOf(client_cancel_request_amount));
		return client.cancelPaymentByImpUid(cancel_data);
	}
	
}

