package com.endless.study;

import com.endless.study.entity.Board;
import org.junit.jupiter.api.Test;

public class BuilderTests {

    /*==================================================
        Builder 사용
        1. 필요한 데이터만 설정 가능
        2. 유연성 확보 가능
        3. 가독성 높임
        4. 불변성 확보
        - Setter 를 열어두지 않고, 객체를 생성할 경우.
        - 각 변수는 final 붙여서 선언.
    ====================================================*/

    @Test
    void test1() {
        //매개변수에 따른 각각의 생성자를 만들 필요 없다.
        Board board =  Board.builder()
                .title("제목")
                .content("내용입니다")
                .build();
    }

    @Test
    void test2() {
        //새로운 변수가 추가될 경우, 생성자나 Setter 추가할 필요 없음.
        //조회수가 추가되었다고 가정
        Board board = Board.builder()
                .title("제목")
                .content("내용입니다")
                .views(10)
                .build();
    }

}
