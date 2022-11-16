package com.endless.study.repository;

import com.endless.study.entity.Target;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TargetRepository extends JpaRepository<Target, Long> {

    List<Target> findTargetByMemberMemberNo(Long memberNo);
}
