package ca.nl.cna.java3.java3projectoutline.dao;

import ca.nl.cna.java3.java3projectoutline.dao.Education;
import ca.nl.cna.java3.java3projectoutline.dao.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;


/**
 * The main controller for the course project
 *
 * This will handle requests for Education now.
 *
 * //TODO Consider using 3 different controllers
 *
 */
@RestController
@RequestMapping(path = "/api")
public class MainController {

    //Constants used in REST API definition
    public static final String VERSION_1 = "/v1";
    public static final String EDUCATION = "/educations";

    @Autowired  //This links this to the database
    private EducationRepository educationRepository;

    @GetMapping(path=VERSION_1 + EDUCATION)
    public @ResponseBody
    Iterable<Education> getAllEducations(){
        String name = "Test";
        return educationRepository.findAll();
    }

    @GetMapping(path = VERSION_1 + EDUCATION + "/{id}")
    public @ResponseBody
    Optional<Education> getEducationWithId(@PathVariable Integer id){
        String name = "Test";
        return educationRepository.findById(id);
    }

    /**
     * Add a new education to the resume
     * @param id
     * @param title
     * @param institutionName
     * @param gradYear
     * @param startDate
     * @param endDate
     * @param abbreviation
     * @return
     */
    @PostMapping(path=VERSION_1 + EDUCATION)
    public @ResponseBody
    String addNewEducation(@RequestParam Integer id, @RequestParam String title,
            @RequestParam String institutionName, @RequestParam Integer gradYear,
            @RequestParam LocalDate startDate, @RequestParam LocalDate endDate,
            @RequestParam String abbreviation){

        Education education = new Education();
        education.setId(id);
        education.setTitle(title);
        education.setInstitutionName(institutionName);
        education.setGradYear(gradYear);
        education.setStartDate(startDate);
        education.setEndDate(endDate);
        education.setAbbreviation(abbreviation);
        educationRepository.save(education);
        return "Saved";
    }

    @DeleteMapping(path = VERSION_1 + EDUCATION)
    public @ResponseBody
    String deleteEducation(@RequestParam Integer id){
        educationRepository.deleteById(id);
        return "deleted";
    }

}