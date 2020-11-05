package banksystem.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "card", schema = "banksystem")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Basic
    @Column(name = "number", nullable = false)
    private String number;

    @Basic
    @Column(name = "pin", nullable = false)
    private String pin;

    @Basic
    @Column(name = "term", nullable = false)
    private Date term;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "count_id", nullable = false)
    private Count count;

}