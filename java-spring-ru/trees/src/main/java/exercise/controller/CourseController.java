package exercise.controller;

import exercise.model.Course;
import exercise.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping(path = "")
    public Iterable<Course> getCorses() {
        return courseRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Course getCourse(@PathVariable long id) {
        return courseRepository.findById(id);
    }

    // BEGIN
    @GetMapping("/{id}/previous")
    public List<Optional<Course>> getPrevCourses(@PathVariable long id) {
        String path = courseRepository.findById(id).getPath();

        if (path != null) {
            return Arrays.stream(path.split("\\."))
                    .map(Long::parseLong)
                    .map(course_id -> courseRepository.findById(course_id))
                    .collect(Collectors.toList());
        }

        return new ArrayList<>();
    }
    // END

}
