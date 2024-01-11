package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") // Order테이블에 있는 member필드에 의해서 맵핑된거란 뜻. (맵핑된 거울인 뿐인 것.) (읽기 전용)
    private List<Order> orders = new ArrayList<>();
}
