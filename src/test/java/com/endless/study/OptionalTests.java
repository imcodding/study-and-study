package com.endless.study;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionalTests {

    /*======================================*
        객체 감싸기
        of                  null 허용 X
        ofNullable          null 허용
    *======================================*/
    @Test
    public void of_notNull() {
        String name = "bob";
        Optional<String> opt = Optional.of(name);
        assertEquals("Optional[bob]", opt.toString());
    }

    @Test
    public void of_null() {
        String name = null;
        Optional<String> opt = Optional.of(name); // NPE
    }

    @Test
    public void ofNullable_notNull() {
        String name = "bob";
        Optional<String> opt = Optional.ofNullable(name);
        assertEquals("Optional[bob]", opt.toString());
    }

    @Test
    public void ofNullable_null() {
        String name = null;
        Optional<String> opt = Optional.ofNullable(name);
        assertEquals("Optional.empty", opt.toString());
    }

    @Test
    public void if_instead_of_optional() {
        String name = null;
        if(name != null) {
            System.out.println(name);
        }
    }

    @Test
    public void optional_instead_of_if() {
        String name = "bob";
        Optional<String> opt = Optional.ofNullable(name);
        opt.ifPresent(n -> System.out.println(n));
    }

    /*==Optional 객체 값 가져오기===================================================*
        isPresent       값 존재 여부 판단
        ifPresent       람다식을 인자로 받아, 값이 존재할 때 그 값에 람다식 적용
        get             Optional 객체가 가진 value 값 가져옴. 값 없으면 예외발생
        orElse          중간처리 메소드를 거치거나 Optional 빈 객체면 orElse 지정 값 반환
        orElseGet       중간처리 메소드를 거치거나 Optional 빈 객체면 orElseGet 함수 객체 반환
        orElseThrow
    *============================================================================*/
    @Test
    public void isPresent() {
        Optional.of("TEST").isPresent(); // true
        Optional.of("TEST")
                .filter(v -> "TEST2".equals(v))
                .isPresent(); // false
    }

    @Test
    public void ifPresent() {
        Optional.of("TEST").ifPresent(System.out::println); //TEST
        Optional.ofNullable(null).ifPresent(System.out::println); //출력X
    }

    @Test
    public void get() {
        Optional.of("TEST").get(); //TEST
        Optional.ofNullable(null).get(); //NoSuchElementException
    }

    @Test
    public void orElse() {
        //ABC
        Optional.of("ABC")
                .filter(v -> v.startsWith("AB"))
                .orElse("XYZ"); // 항상 실행
        //XYZ
        Optional.ofNullable(null).orElse("XYZ");
    }

    @Test
    public void orElseGet() {
        Optional.of("XYZ")
                .filter(c -> c.startsWith("AB"))
                .orElseGet(() -> "Not AB"); //Optional 이 빈 객체일 경우만 실행
    }

    @Test
    public void orElseThrow() {
        Optional.ofNullable(null).orElseThrow(IllegalArgumentException::new);
        Optional.of("ABC").filter(v -> v.startsWith("AB")).orElseThrow(NoSuchElementException::new);
    }

    /*==중간처리 메소드=============================================================*
        filter      인자로 받은 람다식이 참 => Optional 객체 통과
                                     거짓이면 => Optional.Empty() 반환
        map         Optional 객체의 값을 다른 값으로 변경
    *============================================================================*/

    @Test
    public void filter() {
        //ABCD
        Optional.of("ABCD").filter(v -> v.startsWith("AB")).orElse("Not AB");
        //Not AB
        Optional.of("XYZ").filter(v -> v.startsWith("AB")).orElse("Not AB");
    }

    @Test
    public void map() {
        Optional.of("XYZ").map(String::toLowerCase).orElse("Not AB");
    }
}
