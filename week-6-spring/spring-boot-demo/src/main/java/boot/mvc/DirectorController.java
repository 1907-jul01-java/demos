package boot.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import boot.data.Director;
import boot.data.DirectorRepository;

/**
 * DirectorController
 */
@RestController
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
    public List<Director> getAllDirectors() {
        return getDirectorRepository().getAllDirectors();
    }

    @PostMapping("/")
    public Director postDirector(@RequestBody Director director) {
        return getDirectorRepository().postDirector(director);
    }
}