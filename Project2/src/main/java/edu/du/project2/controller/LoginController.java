package edu.du.project2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        RedirectAttributes redirectAttributes) {

        // 사용자 정보 검증 로직 (예시)
        boolean isValidUser = authenticate(username, password);

        if (isValidUser) {
            // 로그인 성공 시 main.html로 리다이렉트
            return "redirect:/main";
        } else {
            // 로그인 실패 시 에러 메시지를 전달하고 로그인 페이지로 돌아가기
            redirectAttributes.addFlashAttribute("error", "아이디 또는 비밀번호가 틀렸습니다.");
            return "redirect:/loginform";
        }
    }

    private boolean authenticate(String username, String password) {
        // 실제 인증 로직은 DB에서 아이디와 비밀번호를 비교하는 방식으로 구현됩니다.
        // 예시: DB에서 사용자 정보 조회 후 비밀번호 비교
        return "user123".equals(username) && "password123".equals(password);
    }
}
