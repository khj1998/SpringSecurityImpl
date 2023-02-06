package springsecurity.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;

@Slf4j
public class MyAuthFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        if (exception instanceof BadCredentialsException) {
            log.info("비밀번호가 일치하지 않습니다");
        } else if (exception instanceof UsernameNotFoundException) {
            log.info("계정이 존재하지 않습니다");
        } else {
            log.info("알 수 없는 오류로 로그인에 실패하였습니다.");
        }
    }
}
