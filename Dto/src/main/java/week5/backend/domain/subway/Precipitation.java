package week5.backend.domain.subway;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Precipitation {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private TimeStamp timeStamp;

    private float precipitation;

    @OneToMany(mappedBy = "precipitation", cascade = CascadeType.ALL)
    private List<SubwayUsage> subwayUsage;


}
