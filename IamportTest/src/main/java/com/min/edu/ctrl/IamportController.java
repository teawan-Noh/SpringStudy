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
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.AccessToken;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

@Controller
public class IamportController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private IamportClient client;
	
	public IamportController() {
		String test_api_key = "6833076151848562";
		String test_api_secret = "8cb171ad19502807f44c2224bb7043e04bbf3de216913e05207c936292513f0ad798b4707825784c";
		client = new IamportClient(test_api_key, test_api_secret);
	}
	
	@ResponseBody
	@RequestMapping(value="/verificationPayInfo.do", method = RequestMethod.POST)
	public IamportResponse<Payment> paymentByImpUid(Model model, HttpSession session, String imp_uid) throws IamportResponseException, IOException{	
			System.out.println("호출됨");
			System.out.println(imp_uid);
			System.out.println(client.paymentByImpUid(imp_uid).getResponse().getImpUid());
			return client.paymentByImpUid(imp_uid);
	}
	
	@ResponseBody
	@RequestMapping(value="/cancelPayInfo.do", method = RequestMethod.GET)
	public IamportResponse<Payment> cancelByMerchant_uid(Model model, HttpSession session, String imp_uid) throws IamportResponseException, IOException{	
		System.out.println("호출됨");
		System.out.println(imp_uid);
		System.out.println(client.paymentByImpUid(imp_uid).getResponse().getImpUid());
		CancelData cancel_data = new CancelData(imp_uid, true);
		cancel_data.setChecksum(BigDecimal.valueOf(10));
		return client.cancelPaymentByImpUid(cancel_data);
	}
}

