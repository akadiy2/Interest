package com.projects.kadiyala.Interest.model.service;

import com.projects.kadiyala.Interest.model.dao.entity.InterestEntity;
import com.projects.kadiyala.Interest.model.dao.repository.InterestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InterestsService {

    private InterestRepository interestRepository;


    @Autowired
    public InterestsService(InterestRepository interestRepository) {
        this.interestRepository = interestRepository;
    }

    /**
     * @param name       The name of the {@link InterestEntity}.
     * @param type        The age of the {@link InterestEntity}.
     * @return One {@link InterestEntity} with the specified name and type
     */
    public InterestEntity getInterestByNameAndType(String name, String type) {
        return interestRepository.findOneByNameAndType(name, type);
    }

    /**
     * Returns a list of all the interests in the data store.
     *
     * @return The List of all {@link InterestEntity}s
     */
    public List<InterestEntity> getAllInterests() {
        return interestRepository.findAll();
    }

    /**
     * Adds a {@link InterestEntity} into the datastore.
     *
     * @param interest - The interest to add.
     * @return The {@link InterestEntity} which was added.
     */
    public InterestEntity addInterest(InterestEntity interest) {
        InterestEntity interestEntity = null;

        try {
            interestEntity = interestRepository.save(interest);
            //log.info("Successfully persisted {} into DB", interestEntity);
        } catch (Exception e) {
            //log.error("There was an exception with the transaction trying to persist the object {}", interestEntity, e);
        }

        return interestEntity;
    }

}
