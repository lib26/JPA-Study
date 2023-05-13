package week5.backend.domain.subway;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class SubwayUsage {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    SubwayStation subwayStation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private precipitation precipitation;

    private Integer onBoard;

    private Integer offBoard;



}
