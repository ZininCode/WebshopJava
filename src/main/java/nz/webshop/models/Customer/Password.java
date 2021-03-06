package nz.webshop.models.Customer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import nz.webshop.models.Order.Order;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class Password {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "password")
    private String password;

    //@OneToOne (targetEntity = CustomerNoPassword.class)
    @OneToOne (targetEntity = CustomerNoPassword.class, cascade = CascadeType.ALL)
    //@PrimaryKeyJoinColumn
  //  @JsonBackReference  (value="customer-password")
    @JoinColumn(name = "customer", referencedColumnName = "customer_id")
    @MapsId
    private CustomerNoPassword customer;

    public CustomerNoPassword getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerNoPassword customer) {
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
