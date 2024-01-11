package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable //JPA의 내장타입
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address() { // jpa기본 스펙이 리플렉션, 프록시 기술 사용시 기본 생성자가 있어야함. 그래서 기본 생성자 만들어둠.
    }                     // public으로 하면 사람들이 많이 호출할 수 있기 때문에 jpa 스펙에서는 protected까지 허용해줌.

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
