package ca.nl.cna.java3.java3projectoutline.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends CrudRepository <Education, Integer> {

    /*
        If we need specialized queries beyond those included in CrudRepository we can engage here or in the Repository interface
        But we only need CRUD so don't populate this interface
    */
}
