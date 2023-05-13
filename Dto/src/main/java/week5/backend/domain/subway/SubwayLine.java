package week5.backend.domain.subway;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class SubwayLine {

    @Id
    @GeneratedValue
    private Long id;

    private String lineName;

    @OneToMany(mappedBy = "subwayLine", cascade = CascadeType.ALL)
    private List<SubwayStation> subwayStation;

}
