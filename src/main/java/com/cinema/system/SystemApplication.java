package com.cinema.system;

import com.cinema.system.domain.entities.Movie;
import com.cinema.system.dto.RegistrationDTO;
import com.cinema.system.services.MovieService;
import com.cinema.system.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootApplication
public class SystemApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SystemApplication.class, args);

        MovieService movieService = applicationContext.getBean(MovieService.class);
        UserService userService = applicationContext.getBean(UserService.class);

        Movie movie1 = movieService.createMovie("Click", "Adam Sandler", 107);
        Movie movie2 = movieService.createMovie("Click", "Adam Sandler", 107);

        List<Movie> movies = movieService.findAllMovies();

        System.out.println("Receiving all movies");
        for (Movie movie : movies) {
            System.out.println(movie.getId() + " " + movie.getName() + " " + movie.getProducer() + " " + movie.getDuration());
        }

        RegistrationDTO adminDTO = new RegistrationDTO("admin", "12345678");
        String adminPassword = adminDTO.getPassword();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(adminPassword);
        adminDTO.setPassword(encodedPassword);
        userService.registerAsAdmin(adminDTO);

        RegistrationDTO userDTO = new RegistrationDTO("mazvira", "12345678");
        String userPassword = adminDTO.getPassword();
        BCryptPasswordEncoder encoder2 = new BCryptPasswordEncoder();
        String encodedPassword2 = encoder2.encode(userPassword);
        userDTO.setPassword(encodedPassword2);
        userService.registerAsUser(userDTO);

    }
}
