package banksystem.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "client", schema = "banksystem")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @Basic
    @Column(name = "surname", nullable = false)
    private String surname;

    @Basic
    @Column(name = "patronymic", nullable = false)
    private String patronymic;

    @Basic
    @Column(name = "address", nullable = false)
    private String address;

    @Basic
    @Column(name = "pass_number", nullable = false)
    private String pass_number;

    @Basic
    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @Basic
    @Column(name = "phone_number", nullable = false)
    private String phone_number;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client", cascade = CascadeType.ALL)
    private List<Count> counts;
}
