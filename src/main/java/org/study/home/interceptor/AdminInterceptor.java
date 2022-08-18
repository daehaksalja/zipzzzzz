package org.study.home.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.study.home.model.MemberDTO;

public class AdminInterceptor extends HandlerInterceptorAdapter {
   @Override
   public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {

      HttpSession session = req.getSession();
      MemberDTO member = (MemberDTO) session.getAttribute("member");

      System.out.println("dfdfsdfsdf" + member);
      if (member == null) {
    	  session.invalidate();
         res.sendRedirect("redirect:/");
         
         return false;
      }
      if (member.getAdminCk() != 1) {
    	  session.invalidate();
         res.sendRedirect("/");
        
         return false;
      }

      return true;
   }
}