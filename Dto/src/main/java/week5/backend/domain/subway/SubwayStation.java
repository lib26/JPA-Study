package week5.backend.domain.subway;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private SubwayLine lines;

    @OneToMany(mappedBy = "stations", cascade = CascadeType.ALL)
    private List<SubwayUsage> subwayUsage;


}
