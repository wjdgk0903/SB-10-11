package edu.du.project1.repository;

import edu.du.project1.entity.Member;

import java.util.List;

public interface LoginRepository {

    List<Member> findById(String id);

    List<Member> findBPwd(String pwd);

}
