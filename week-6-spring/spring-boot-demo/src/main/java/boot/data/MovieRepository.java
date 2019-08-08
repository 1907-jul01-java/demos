package boot.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * MovieRepository
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{
    Movie findByTitle(String title);
    Movie findByYear(Integer year);
    List<Movie> findByIdBetween(int min, int max);
    
}