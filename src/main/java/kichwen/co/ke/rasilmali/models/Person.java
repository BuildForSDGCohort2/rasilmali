package kichwen.co.ke.rasilmali.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int id;

    @Column(name = "prefix")
    private String prefix;

    @Column(name = "given_name")
    private String givenname;

    @Column(name = "middle_name")
    private String middlename;

    @Column(name = "family_name")
    private String familyname;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "birthdate_estimated")
    private int birthdate_estimated;

    @Transient
    private UUID corrId = UUID.randomUUID();

    @OneToMany(mappedBy="personAddresses", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("person")
    private Set<PersonAddress> person ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getGivenname() {
        return givenname;
    }

    public void setGivenname(String givenname) {
        this.givenname = givenname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getBirthdate_estimated() {
        return birthdate_estimated;
    }

    public void setBirthdate_estimated(int birthdate_estimated) {
        this.birthdate_estimated = birthdate_estimated;
    }

    public UUID getCorrId() {
        return corrId;
    }

    public void setCorrId(UUID corrId) {
        this.corrId = corrId;
    }

    public Set<PersonAddress> getPerson() {
        return person;
    }

    public void setPerson(Set<PersonAddress> person) {
        this.person = person;
    }
}
