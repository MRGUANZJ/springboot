package com.zhijie.confing;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: zhijie
 * @Date: 2020/06/14/23:22
 * @Description:
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String language = httpServletRequest.getParameter("l");

        Locale locale=Locale.getDefault();//如果没有就使用默认的

        //携带了国际化的参数  zh_CN 国家，地区
        if (!StringUtils.isEmpty(language)){
            String[] split = language.split("_");
           locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
