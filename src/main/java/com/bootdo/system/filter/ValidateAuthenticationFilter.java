package com.bootdo.system.filter;

import com.bootdo.common.config.Constant;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class ValidateAuthenticationFilter extends FormAuthenticationFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        Session session = SecurityUtils.getSubject().getSession();
        String validateCode = (String)session.getAttribute("validateCode");
        String pageValidateCode = httpServletRequest.getParameter("validateCode");
        if(pageValidateCode == null){
            httpServletRequest.setAttribute(Constant.SHIRO_LOG_IN_FAILURE,Constant.KAPTCHA_VALIDATE_FAILED);
            return true;
        }else if(pageValidateCode != null && validateCode != null && !pageValidateCode.equals(validateCode)){
            httpServletRequest.setAttribute(Constant.SHIRO_LOG_IN_FAILURE,Constant.KAPTCHA_VALIDATE_FAILED);
            return true;
        }
        return super.onAccessDenied(request, response);
    }

//    @Bean
//    public FilterRegistrationBean registration(ValidateAuthenticationFilter filter) {
//        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
//        registration.setEnabled(false);
//        return registration;
//    }
}
