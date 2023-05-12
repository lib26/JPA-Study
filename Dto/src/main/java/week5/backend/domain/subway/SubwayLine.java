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

    private String lineNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lines")
    private List<SubwayStation> subwayStation;

}
