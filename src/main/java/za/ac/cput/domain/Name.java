package za.ac.cput.domain;
// Mlungisi L. Mbuyazi
// 221164014
// https://github.com/Skiet88/comic__city_project


import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Name {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String middleName;
    private String lastName;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Author author;

    protected Name() {
    }
    public Name(NameBuilder n) {
        this.firstName = n.firstName;
        this.middleName = n.middleName;
        this.lastName = n.lastName;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return id == name.id && Objects.equals(firstName, name.firstName) && Objects.equals(middleName, name.middleName) && Objects.equals(lastName, name.lastName) && Objects.equals(author, name.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, middleName, lastName, author);
    }

    @Override
    public String toString() {
        return "Name{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +

                '}';
    }

    public static class NameBuilder{
        private String firstName;
        private String middleName;
        private String lastName;

        public NameBuilder(){


        }

        public NameBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public NameBuilder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public NameBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public NameBuilder copy(Name n) {
            this.firstName = n.firstName;
            this.middleName = n.middleName;
            this.lastName = n.lastName;

            return this;
        }

        public Name build(){

            return new Name(this);
        }
    }
}
