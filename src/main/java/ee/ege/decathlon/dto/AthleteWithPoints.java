package ee.ege.decathlon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AthleteWithPoints {
    private Long id;
    private String firstName;
    private String lastName;
    private String country;
    private int points;
}
