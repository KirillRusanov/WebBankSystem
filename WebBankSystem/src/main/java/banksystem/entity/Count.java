package banksystem.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "count", schema = "banksystem")
public class Count {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Basic
    @Column(name = "number", nullable = false)
    private String number;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "client", nullable = false)
    private Client client;

    @Basic
    @Column(name = "balance", nullable = false)
    private Integer balance;

    @Basic
    @Column(name = "currency", nullable = false)
    private String currency;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "count", cascade = CascadeType.ALL)
    private List<Card> cards;
}
