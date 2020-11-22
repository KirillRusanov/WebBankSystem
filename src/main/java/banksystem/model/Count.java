package banksystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "count")
@Data
public class Count {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "balance", nullable = false)
    private Integer balance;

    @Column(name = "currency", nullable = false)
    private String currency;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "client_id", nullable = false)
    private Client client_id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "count", cascade = CascadeType.ALL)
    private List<Card> cards;
}
