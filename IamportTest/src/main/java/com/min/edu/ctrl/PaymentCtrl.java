package com.min.edu.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.edu.model.service.IPaymentsService;
import com.min.edu.vo.PaymentsVo;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

@Controller
public class PaymentCtrl {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private final String apiKey = "6833076151848562";
	private final String apisecret = "8cb171ad19502807f44c2224bb7043e04bbf3de216913e05207c936292513f0ad798b4707825784c";
	
	@Autowired
	private IPaymentsService service;
	
	private IamportClient client;
	public PaymentCtrl() {
		client = new IamportClient(apiKey, apisecret);
	}
	
	@GetMapping(value = "/paymentList.do")
	public String PaymentList(Model model) {
		logger.info("PaymentCtrl 결제전체조회 호출");
		List<PaymentsVo> paymentList = service.paymentSelectAll();
		model.addAttribute("paymentList", paymentList);
		
		return "paymentList";
	}
	
	/**
	 * 결제 요청은 클라이언트 상에서 이루어지기 때문에 클라이언트의 스크립트를 조작해 금액을 위변조하여 결제를 요청할 수 있습니다. 
	 * 따라서 결제 프로세스 완료 후 처음 요청했던 금액과 실제로 결제된 금액을 비교하여 일치하지 않을 경우 결제 취소시키는 로직을 구현
	 * @param imp_uid: client-side에서 넘겨받은 imp_uid
	 * @param paid_amount: client-side에서 넘겨받은 paid_amount
	 */
	
	@ResponseBody
	@RequestMapping(value="/paymentInsert.do", method = RequestMethod.POST)
	public IamportResponse<Payment> paymentInsert(Model model, HttpSession session, @RequestBody Map<String,String> map, HttpServletResponse resp) throws IamportResponseException, IOException{	
			logger.info("paymentByImpUid 실행");
//			System.out.println(map);
			String imp_uid = map.get("imp_uid");
//			System.out.println("imp_uid 확인 :" + imp_uid);
			String iamportServerAmount = client.paymentByImpUid(imp_uid).getResponse().getAmount().toString();
//			System.out.println("iamportServerAmount: " + iamportServerAmount);
			//imp_uid로 아임포트 서버에서 조회하여 data를 반환시킴 // 결제금액이 일치하지 않을경우 결제 취소됨
			String paidAmount = map.get("price");
//			String paidAmount = "300"; //testcode
//			System.out.println("paidAmount : " + paidAmount);
			if(paidAmount.equals(iamportServerAmount)) {
				System.out.println("인증성공");
				String product_code = Integer.toString(1);
				map.put("product_code", product_code);
				map.put("userid", "아이디1");
				service.paymentInsert(map);
				//검증 추가할 방법 생각해보기
			}else {
				System.out.println("인증실패");
				CancelData cancel_data = new CancelData(imp_uid, true); //imp_uid를 통한 전액취소
				client.cancelPaymentByImpUid(cancel_data);
				//위변조 시도된 경우 세션 삭제 추가
//				session.removeAttribute("userid");
			}
			return client.paymentByImpUid(imp_uid);
	}
}
