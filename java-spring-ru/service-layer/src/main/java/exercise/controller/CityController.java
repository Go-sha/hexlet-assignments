package exercise.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import exercise.CityNotFoundException;
import exercise.model.City;
import exercise.repository.CityRepository;
import exercise.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private WeatherService weatherService;

    // BEGIN
    private ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/cities/{id}")
    public Map<String, String> getCityData(@PathVariable long id) {
        return weatherService.getWeather(cityRepository
                .findById(id)
                .orElseThrow(() -> new CityNotFoundException("City not found"))
                .getName());
    }

    @GetMapping("/search")
    public List<Map<String, String>> getCitiesData(@PathParam(value = "name") String name) {
        List<City> citiesList = new ArrayList<>();

        if (name != null) {
             citiesList = cityRepository
                    .findByNameContainingIgnoreCase(name)
                    .orElseThrow(() -> new CityNotFoundException("City not found"));
        } else {
            citiesList = cityRepository.
                    findAllByOrderByNameAsc()
                    .orElseThrow(() -> new CityNotFoundException("City not found"));
        }

        return citiesList.stream()
                .map(City::getName)
                .map(cityName -> weatherService.getWeather(cityName))
                .collect(Collectors.toList());
    }
    // END
}

