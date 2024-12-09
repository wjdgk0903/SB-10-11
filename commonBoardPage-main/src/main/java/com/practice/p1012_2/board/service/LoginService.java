package edu.du.project1.service;

import edu.du.project1.entity.Member;
import edu.du.project1.repository.LoginRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepositoryImpl loginRepository;

    public Member login(Member member) {
        List<Member> loginId = loginRepository.findById(member.getLoginId());
        List<Member> password = loginRepository.findBPwd(member.getPassword1());

        if(loginId.isEmpty() || password.isEmpty() || !member.getPassword1().equals(password.get(0).getPassword1())) {
            return null;
        }
        return loginId.get(0);
    }
}
