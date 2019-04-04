package org.lalajiang.config.intercepors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    //这个方法是在访问接口之前执行的，我们只需要在这里写验证登陆状态的业务逻辑，就可以在用户调用指定接口之前验证登陆状态了
    //有Boolean类型的返回值，如果返回为False，则Handle本身及postHandle/afterCompletion以及后续的拦截器全部都不会再继续执行；为True则反之
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //每一个项目对于登陆的实现逻辑都有所区别，我这里使用最简单的session来验证登陆。
        HttpSession sessionName = request.getSession();
        String userName = String.valueOf(sessionName.getAttribute("userName"));
        if ("admin".equals(userName)) {
            response.sendRedirect("/user/show");
            return true;
        } else
            response.sendRedirect("/login");

        //根据cookie判断
        /*Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("llj_login") && cookie.getValue().equals("true")) {
                log.debug("自动登录程序");
                return false;
            }
        }*/
        return false;
    }

    //方法执行之后执行，页面视图加载之前
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    //所有加载之后
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
