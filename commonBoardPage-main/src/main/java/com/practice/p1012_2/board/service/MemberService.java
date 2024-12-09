package edu.du.project1.service;

import edu.du.project1.entity.Member;
import edu.du.project1.repository.MemberRepository;
import edu.du.project1.spring.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void registerMember(MemberDto dto){
        Member entity = dto.toEntity(dto);
        memberRepository.save(entity);
    }

    public int validateMemberId(String id) {
        List<Member> findId = memberRepository.findById(id);

        if(findId !=null && !findId.isEmpty()){
            return 1;  //아이디 중복시 1;
        }
        return 0;      //아이디 중복x 0;

    }

    public int passwordMatch(String password1, String password2) {
        if(password1.equals(password2)){
            return 0; // 비밀번호가 같다면 0
        }
        return 1;     // 일치하지 않으면 1
    }

    // 로그인 처리 (단순 예시로 로그인 정보 확인 로직 추가)
    public Member login(MemberDto dto) {
        // 여기서는 예시로 로그인 처리를 할 수 있습니다.
        // 실제로는 ID와 비밀번호를 확인하고, 회원을 반환하거나 예외를 처리하는 방식으로 구현할 수 있습니다.
        List<Member> members = memberRepository.findById(dto.getLoginId());
        if (members.isEmpty()) {
            throw new RuntimeException("아이디 또는 비밀번호가 일치하지 않습니다.");
        }
        Member member = members.get(0);
        if (!member.getPassword1().equals(dto.getPassword1())) {
            throw new RuntimeException("아이디 또는 비밀번호가 일치하지 않습니다.");
        }
        return member;  // 로그인 성공한 회원 반환
    }
}
