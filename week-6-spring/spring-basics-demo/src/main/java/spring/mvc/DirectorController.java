package spring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.data.DirectorRepository;

/**
 * DirectorController
 */
@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping(path = "directors")
public class DirectorController {

    @Autowired
    DirectorRepository directorRepository;

    public DirectorRepository getDirectorRepository() {
        return directorRepository;
    }

    public void setDirectorRepository(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @GetMapping("/")
    public String getAllDirectors() {
        return getDirectorRepository().getAllDirectors().toString();
    }
}