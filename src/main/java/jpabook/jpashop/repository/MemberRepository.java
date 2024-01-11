package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //컴포넌 스캔에 의해 자동으로 스프링 빈으로 관리가 됌.
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    //persist하면 영속성컨텍스트에 member객체를 넣고, 트랜잭션이 커밋되는 시저에 디비에 반영(디비에 인서트 쿼리가 날라가는거다.)
    public void save(Member member) {
        em.persist(member);
    }

    //단건 조회
    public Member fineOne(Long id) {
        return em.find(Member.class, id); //엔티티매니저의 find메서드 (타입, pk)
    }

    //jpql을 사용 sql과 문법 거의 유사 from의 대상이 테이블이 아닌 엔티티임
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
