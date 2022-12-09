package exercise;

import lombok.*;

// BEGIN
@Data
@AllArgsConstructor
// END
class User {
    int id;
    String firstName;
    String lastName;
    int age;
}
