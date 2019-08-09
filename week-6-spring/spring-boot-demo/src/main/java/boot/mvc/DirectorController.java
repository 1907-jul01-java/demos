package boot.mvc;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    RestTemplate restTemplate;

    @GetMapping
    public List<Director> getAllDirectors() {
        return this.directorRepository.getAllDirectors();
    }

    @PostMapping
    public Director postDirector(@RequestBody @Valid Director director, Error error) {
        if (error != null) return null;
        return this.directorRepository.postDirector(director);
    }

    @GetMapping("oops")
    public void oops() throws IOException {
        throw new IOException();
    }

    @ExceptionHandler(IOException.class)
    @ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT)
    public String ioProblem() {
        return "oops!";
    }

    @GetMapping("restCall")
    public ResponseEntity<String> callOtherService() {
        return restTemplate.getForEntity("http://localhost:8080/directors/", String.class);
    }
}