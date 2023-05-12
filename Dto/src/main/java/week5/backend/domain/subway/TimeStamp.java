package week5.backend.domain.subway;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class TimeStamp {

    @Id
    @GeneratedValue
    private Long id;

    private String time_stamp;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "timeStamp")
    private List<Perceptation> perceptation;

}
