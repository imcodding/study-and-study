package com.endless.study.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberNo;

    private String memberId;
    private String name;
    private String dept;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Target> targetList = new ArrayList<>();

    public void addTarget(Target target) {
        this.targetList.add(target);
    }
}
