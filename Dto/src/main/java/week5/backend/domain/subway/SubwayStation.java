package week5.backend.domain.subway;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class SubwayStation {

    @Id
    @GeneratedValue
    private Long id;

    private String stationName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private SubwayLine subwayLine;

    @OneToMany(mappedBy = "subwayStation", cascade = CascadeType.ALL)
    private List<SubwayUsage> subwayUsage;


}
