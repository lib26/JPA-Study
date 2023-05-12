package week5.backend.domain.subway;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Perceptation {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private TimeStamp timeStamp;

    private float perceptation;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perceptations")
    private List<SubwayUsage> subwayUsage;


}
