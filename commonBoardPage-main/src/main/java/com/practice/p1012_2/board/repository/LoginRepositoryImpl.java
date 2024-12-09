package edu.du.project1.repository;

import edu.du.project1.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class LoginRepositoryImpl implements LoginRepository {

    private final EntityManager em;


    @Override
    public List<Member> findById(String id) {
        String jpql = "SELECT m FROM Member m WHERE m.loginId = :loginId";
        List<Member> loginId = em.createQuery(jpql, Member.class).setParameter("loginId", id).getResultList();
        return loginId;
    }

    @Override
    public List<Member> findBPwd(String pwd) {
        String jpql = "SELECT m FROM Member m WHERE m.password1 = :password";
        List<Member> password = em.createQuery(jpql, Member.class).setParameter("password", pwd).getResultList();
        return password;
    }

}
