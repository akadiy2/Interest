package com.projects.kadiyala.Interest.model.dao.repository;

import com.projects.kadiyala.Interest.model.dao.entity.InterestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestRepository extends JpaRepository<InterestEntity, Long> {
    /**
     * Retrieves a {@link InterestEntity} that matches with the given criteria.
     *
     * @param name       - The name to look up by.
     * @param type        - The type to look up by.
     * @return InterestEntity that matches given criteria
     */
    InterestEntity findOneByNameAndType(String name, String type);
}
