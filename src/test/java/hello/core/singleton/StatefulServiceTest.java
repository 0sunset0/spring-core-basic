package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(StatefulService.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        //TreadA : A 사용자 10000주 문
        int userAPrice = statefulService1.order("userA", 10000);
        //TreadB : B 사용자 20000주 문
        int userBPrice = statefulService2.order("userB", 20000);

        //TreadA : 사용자 A가 주문금액 조회

        Assertions.assertThat(userAPrice).isEqualTo(10000);
    }

    static  class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}