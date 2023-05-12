package week5.backend.domain.subway;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.logging.Level;

@Entity
@Getter
public class SubwayUsage {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    SubwayStation stations;

    private Integer onBoard;

    private Integer offBoard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Perceptation perceptations;


}
