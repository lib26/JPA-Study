package week5.backend.domain.subway;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class TimeStamp {

    @Id
    @GeneratedValue
    private Long id;

    private String time_stamp;

    @OneToMany(mappedBy = "timeStamp", cascade = CascadeType.ALL)
    private List<precipitation> precipitation;

}
