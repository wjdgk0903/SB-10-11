package edu.du.project1.repository;

import edu.du.project1.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
        em.flush();
    }

    public List<Member> findById(String loginId){
        String jpql = "select m from Member m where m.loginId=:loginId";
        List<Member> findId = em.createQuery(jpql, Member.class).setParameter("loginId", loginId).getResultList();
        return findId;
    }
}
