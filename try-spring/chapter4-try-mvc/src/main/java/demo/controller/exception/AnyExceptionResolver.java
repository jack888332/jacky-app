package demo.controller.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
与Spring整合的方法：目标类实现Spring的相关接口，在放到Spring IOC，受控于Spring运作机制
 */
@Component
public class AnyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 获取异常对象
        AnyException anyException = null;
        if (ex instanceof AnyException) {
            anyException = (AnyException) ex;
        } else {
            anyException = new AnyException("系统故障了");
        }
        ModelAndView mv = new ModelAndView("common/error");
        mv.addObject("errorMsg", anyException.getMessage());
        return mv;
    }
}
