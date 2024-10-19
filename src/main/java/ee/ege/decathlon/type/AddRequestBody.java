package ee.ege.decathlon.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddRequestBody {
    private int points;
    private String event;
    private Long athleteId;
}
