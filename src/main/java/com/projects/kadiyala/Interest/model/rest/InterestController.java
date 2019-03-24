package com.projects.kadiyala.Interest.model.rest;

import com.projects.kadiyala.Interest.model.dao.entity.InterestEntity;
import com.projects.kadiyala.Interest.model.service.InterestsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * {@link RestController} for {@link InterestEntity}s.
 */
@RestController
@RequestMapping("/interests")
public class InterestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(InterestController.class);

    /**
     * The {@link InterestsService} to be used.
     */
    private InterestsService interestsService;

    @Autowired
    private InterestController(InterestsService interestsService) {
        this.interestsService = interestsService;
    }

    /**
     * Endpoint to fetch all Interests.
     *
     * @return List of all {@link InterestEntity}s.
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<InterestEntity>> getAllPersons() {
        ResponseEntity<List<InterestEntity>> responseEntity = null;

        try {
            responseEntity = ResponseEntity.ok(interestsService.getAllInterests());
        } catch (Exception e) {
            LOGGER.info("There is an error occurring with getting the response", e);
            System.out.println("There is an error occurring with getting the response: " + e.getMessage());
        }

        return responseEntity;
    }

    /**
     * Endpoint to fetch an interest by name and type
     *
     * @param name
     * @param type
     * @return a {@link InterestEntity} with the given name and type.
     */
    @RequestMapping(method = RequestMethod.GET, params = {"name", "type"})
    public ResponseEntity<InterestEntity> getInterestByNameAndType(@RequestParam("name") String name,
                                                @RequestParam("type") String type) {
        ResponseEntity<InterestEntity> responseEntity = null;

        try {
            responseEntity = ResponseEntity.ok(interestsService.getInterestByNameAndType(name, type));
        } catch (Exception e) {
            LOGGER.info("There is an error occurring with getting the response", e);
        }

        return responseEntity;
    }

    /**
     * Adds a {@link InterestEntity} to the database.
     *
     * @param interestEntity - The interest to add
     */
    @RequestMapping(method = RequestMethod.POST)
    public InterestEntity addInterest(@RequestBody InterestEntity interestEntity) {
        return interestsService.addInterest(interestEntity);
    }

}
