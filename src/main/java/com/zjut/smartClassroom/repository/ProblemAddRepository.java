package com.zjut.smartClassroom.repository;

import com.zjut.smartClassroom.dataObject.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemAddRepository extends JpaRepository<Problem, Problem> {

    Problem save(Problem problem);

}
