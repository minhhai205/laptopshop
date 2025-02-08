package vn.minhhai.laptopshop.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.minhhai.laptopshop.domain.User;
import vn.minhhai.laptopshop.service.UserService;

public class CustomSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private UserService userService;

    protected void setSessionAttribute(HttpServletRequest request, Authentication authentication) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        // get email from Authentication Object in Spring Context
        String email = authentication.getName();
        // find user by found email
        User user = this.userService.getUserByEmail(email);
        // set attribute session for using in view page
        if (user != null) {
            session.setAttribute("name", user.getFullName());
            session.setAttribute("image", user.getAvatar());
            session.setAttribute("email", user.getEmail());

        }
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        if (response.isCommitted()) {
            return;
        }

        setSessionAttribute(request, authentication);
    }

}
