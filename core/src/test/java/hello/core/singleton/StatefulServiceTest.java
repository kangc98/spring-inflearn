package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;

class StatefulServiceTest {

    @Test
    @DisplayName("싱글톤 방식의 주의점")
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

//        // ThreadA: 사용자 A 10000원 주문
//        statefulService1.order("userA", 10000);
//        // ThreadB: 사용자 B 20000원 주문
//        statefulService2.order("userB", 20000);
//
//        // ThreadA: 사용자 A 주문 금액 조회
//        int price = statefulService1.getPrice();
//        System.out.println("price = " + price);
//        price = 20000, statefulService1과 2가 같은 객체이므로 price는 공유 필드임.
//
//        assertThat(statefulService1.getPrice()).isEqualTo(20000);



        // ThreadA: 사용자 A 10000원 주문
        int userAPrice = statefulService1.order2("userA", 10000);
        // ThreadB: 사용자 B 20000원 주문
        int userBPrice = statefulService2.order2("userB", 20000);

        // ThreadA: 사용자 A 주문 금액 조회
        System.out.println("price = " + userAPrice); // userAPrice = 10000

    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}