package com.endless.study;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTests {

    /*================================================================
        Stream
        컬렉션, 배열에 저장되어 있는 요소들을 하나씩 참조하며 반복적인 처리 가능
        람다식을 이용하면 for 문과 if 문을 사용하지 않고 깔끔한 코드 짤 수 있음
    =================================================================*/
    List<Person> people = new ArrayList<>();

    public StreamTests() {
        init();
    }

    @Test
    void streamMap() {
        List<String> peopleNames = people.stream()
                                         .map(Person::getName)
                                         .collect(Collectors.toList());

        for(String name : peopleNames) {
            System.out.println(name);
        }
    }

    @Test
    void streamMap2() {
        List<String> license = people.stream()
                                     .map(Person::getLicense)
                                     .flatMap(Collection::stream)
                                     .distinct() // 중복제거
                                     .collect(Collectors.toList());

        for(String lc : license) {
            System.out.println(lc);
        }
    }

    @Test
    void streamFilter() {
        List<Person> filterPeople = people.stream()
                                          .filter(p -> p.getLicense().contains("SQLD"))
                                          .collect(Collectors.toList());
        for(Person person : filterPeople) {
            System.out.println(person.getName());
        }
    }

    @Test
    void init() {
        List<String> list = new ArrayList<>();
        list.add("리눅스마스터2급");
        list.add("정보처리기사");

        people.add(new Person("bob", list));

        list = new ArrayList<>();
        list.add("정보처리기사");
        list.add("SQLD");
        list.add("CCNA");

        people.add(new Person("tomas", list));

    }

}

class Person {
    private String name;
    private List<String> license;

    public Person(String name, List<String> license) {
        this.name = name;
        this.license = license;
    }

    public String getName() {
        return name;
    }

    public List<String> getLicense() {
        return license;
    }
}