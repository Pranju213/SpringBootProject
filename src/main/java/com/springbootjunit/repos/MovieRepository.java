package com.springbootjunit.repos;

// CRUD
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.springbootjunit.entity.Movie;
public interface MovieRepository extends JpaRepository<Movie, Long>
{
	//Custom method
	List<Movie> findByGenera(String genera);
}


