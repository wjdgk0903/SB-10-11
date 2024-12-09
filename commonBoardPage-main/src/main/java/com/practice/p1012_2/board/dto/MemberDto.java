package edu.du.project1.spring;

import edu.du.project1.entity.Address;
import edu.du.project1.entity.Member;
import edu.du.project1.entity.Role;
import lombok.*;
import javax.validation.constraints.NotBlank;

@Data
@Getter
@Setter
@NoArgsConstructor
public class MemberDto {

    private Long id;
    @NotBlank(message = "아이디를 입력하세요")
    private String loginId;

    @NotBlank(message = "이름을 입력하세요")
    private String username;

    @NotBlank(message = "비밀번호를 입력하세요")
    private String password1;

    @NotBlank(message ="비밀번호를 다시한번 입력해주세요" )
    private String password2;

    @NotBlank(message = "이메일을 입력해주세요")
    private String email;

    @NotBlank(message = "인증번호를 입력해주세요")
    private String emailConfirm;

    @NotBlank(message = "생년월일 8자리를 입력해주세요")
    private String brithDay;

    private Role role;

    private Address address;



    @Builder
    public MemberDto( String loginId, String username, String password1, String password2, String email, String brithDay, Role role, Address address) {
        this.loginId = loginId;
        this.username = username;
        this.password1 = password1;
        this.password2 = password2;
        this.email = email;
        this.emailConfirm = email;
        this.brithDay = brithDay;
        this.role = role;
        this.address = address;
    }

    public Member toEntity(MemberDto memberDto) {
        Member entity = Member.builder()
                .loginId(memberDto.getLoginId())
                .username(memberDto.getUsername())
                .password1(memberDto.getPassword1())
                .password2(memberDto.getPassword2())
                .email(memberDto.getEmail())
                .brithDay(memberDto.getBrithDay())
                .role(memberDto.getRole())
                .address(memberDto.getAddress())
                .build();

        return entity;
    }

    public MemberDto of(Member member) {
        MemberDto dto = MemberDto.builder()
                .loginId(member.getLoginId())
                .username(member.getUsername())
                .password1(member.getPassword1())
                .password2(member.getPassword2())
                .email(member.getEmail())
                .brithDay(member.getBrithDay())
                .role(member.getRole())
                .address(member.getAddress())
                .build();

        return dto;
    }


}
