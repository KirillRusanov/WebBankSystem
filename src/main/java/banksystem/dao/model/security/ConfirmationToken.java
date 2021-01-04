package banksystem.dao.model.security;

import banksystem.dao.model.Client;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "confirmationToken")
public class ConfirmationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="token")
    private String token;

    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @OneToOne(targetEntity = Client.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "client_id")
    private Client client;

    public ConfirmationToken(Client client, String token, Date createdDate) {
        this.client = client;
        this.token = token;
        this.createdDate = createdDate;
    }
}