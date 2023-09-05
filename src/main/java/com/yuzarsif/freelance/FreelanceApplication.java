package com.yuzarsif.freelance;

import com.yuzarsif.freelance.dto.LocationDto;
import com.yuzarsif.freelance.dto.TagDto;
import com.yuzarsif.freelance.model.Location;
import com.yuzarsif.freelance.repository.LocationRepository;
import com.yuzarsif.freelance.service.LocationService;
import com.yuzarsif.freelance.service.TagService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class FreelanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreelanceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(LocationService locationService,
                                               TagService tagService) {
        return args -> {
            List<LocationDto> location = locationService.findLocationByCountryOrCity("Turkey");
            System.out.println(location);

            List<TagDto> tags = tagService.findTagsByLabelName("Spring");
            System.out.println(tags);
        };
    }

}
