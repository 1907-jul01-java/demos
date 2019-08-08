package boot.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import boot.data.Movie;
import boot.data.MovieRepository;


/**
 * MovieController
 */
@RestController
@RequestMapping(path = "movies")
public class MovieController {
    @Autowired
    MovieRepository movieRepository;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    
    @GetMapping(params = {"min", "max"})
    public List<Movie> getByYear(@RequestParam(name="min") int min, @RequestParam(name = "max") int max) {
        return movieRepository.findByYearBetween(min, max);
    }

    @GetMapping(params = "title")
    public List<Movie> getByTitle(@RequestParam(name = "title") String title) {
        return movieRepository.findByTitle(title);
    }
    
    @PostMapping
    public Movie newMovie(Movie movie) {
        return movie;
    }
}