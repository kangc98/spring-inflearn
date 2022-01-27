package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable // jpa 내장 타입
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    // 값을 변경할 수 없는 클래스를 만들자.
    protected Address() {

    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
