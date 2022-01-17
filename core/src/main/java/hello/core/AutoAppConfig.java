package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( // 테스트용 - AppConfig.class 등록 제외하기 위함
//        basePackages = "hello.core", // 탐색 위치 지정
//        지정하지 않으면 설정 정보 클래스(AutoAppConfig.class)의 패키지 hello.core가 default
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}