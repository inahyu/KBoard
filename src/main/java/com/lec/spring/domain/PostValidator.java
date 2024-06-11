package com.lec.spring.domain;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PostValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        boolean result = Post.class.isAssignableFrom(clazz);

        return result;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Post post = (Post) target;
        System.out.println("validate() 호출 : " + post);

//        String user = post.getUser();
//        if(user == null || user.trim().isEmpty()){
//            errors.rejectValue("user", "작성자는 필수입니다.");
//        }



        //        String subject = post.getSubject();
        //        if(subject == null || subject.trim().isEmpty()){
        //            errors.rejectValue("subject", "글 제목은 필수입니다.");
        //        }

                // 주어진 객체(target)에 유효성검사를 하고
        // 유효성검사에 오류가 있는 경우 주어진 객체에 이 오류들을 errors 에 등록 한다.
        // 아래 validate() 는 Spring 이 기본적인 binding이 수행한 이후에 호출된다.
        // 따라서, errors 에는 Spring이 수행한 기본적인 binding 에러 들이 이미 담겨 있고
        // target 에는 binding 이 완료한 커맨드 객체가 전달된다.


        // 컨트롤러 핸들러 매개변수에 @Valid 가 붙어 있어야 validate() 가 동작한다
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject", "글 제목은 필수입니다");

    }
}
