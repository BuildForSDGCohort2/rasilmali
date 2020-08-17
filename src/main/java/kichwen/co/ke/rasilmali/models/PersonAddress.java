package kichwen.co.ke.rasilmali.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person_address")
public class PersonAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_address_id")
    private int id;

    @Column(name = "person_id")
    private String personid;

    @Column(name = "address_type")
    private String addresstype;

    @Column(name = "county")
    private String county;

    @Column(name = "subcounty")
    private String subcounty;

    @Column(name = "address")
    private String address;

    @Column(name = "postal_code")
    private String postalcode;

    @Transient
    private UUID uuid = UUID.randomUUID();

    @ManyToOne()
    @JoinColumn(name="person_id",referencedColumnName = "person_id", nullable=false,insertable = false, updatable =false)
    @JsonIgnoreProperties("person_address")
    private Person  personAddresses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    public String getAddresstype() {
        return addresstype;
    }

    public void setAddresstype(String addresstype) {
        this.addresstype = addresstype;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getSubcounty() {
        return subcounty;
    }

    public void setSubcounty(String subcounty) {
        this.subcounty = subcounty;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Person getPersonAddresses() {
        return personAddresses;
    }

    public void setPersonAddresses(Person personAddresses) {
        this.personAddresses = personAddresses;
    }
}
