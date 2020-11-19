package banksystem.model;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client_id", cascade = CascadeType.ALL)
    private List<Count> counts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPass_number() {
        return pass_number;
    }

    public void setPass_number(String pass_number) {
        this.pass_number = pass_number;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public List<Count> getCounts() {
        return counts;
    }

    public void setCounts(List<Count> counts) {
        this.counts = counts;
    }
}
