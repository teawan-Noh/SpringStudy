package com.min.edu.validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.min.edu.dtos.UploadFile;

@Service
public class FileValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		UploadFile file = (UploadFile)target;
		System.out.println("파일사이즈 :" + file.getFile().getSize());
		if(file.getFile().getSize() == 0) {
			errors.rejectValue("file", "errorCode", "파일을 선택해 주세요");
		}
	}

}
