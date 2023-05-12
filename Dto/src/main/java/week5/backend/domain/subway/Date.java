package week5.backend.domain.subway;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Date {

    @Id
    @GeneratedValue
    private Long id;

    private java.util.Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private SubwayDay week_day;

    @OneToMany(mappedBy = "date", cascade = CascadeType.ALL)
    private List<Perceptation> perceptation;

}
