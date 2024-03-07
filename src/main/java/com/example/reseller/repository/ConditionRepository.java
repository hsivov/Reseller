package com.example.reseller.repository;

import com.example.reseller.model.entity.Condition;
import com.example.reseller.model.entity.ConditionName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionRepository extends JpaRepository<Condition, Long> {
    Condition findByConditionName(ConditionName conditionName);
}
