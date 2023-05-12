package week5.backend.domain.subway;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class SubwayDay {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private Week week_day;

    @OneToMany(mappedBy = "week_day", cascade = CascadeType.ALL)
    private List<Date> subwayDate;



}
