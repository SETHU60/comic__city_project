package za.ac.cput.domain;
// Mlungisi L. Mbuyazi
// 221164014
// https://github.com/Skiet88/comic__city_project
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

public class Contact {

    private  String email;
    private  String mobile;
    private String workTelephone;

    protected Contact() {

    }

    private Contact(ContactBuilder contactBuilder) {
        this.email = contactBuilder.email;
        this.mobile = contactBuilder.mobile;
        this.workTelephone = contactBuilder.workTelephone;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWorkTelephone() {
        return workTelephone;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(email, contact.email) && Objects.equals(mobile, contact.mobile) && Objects.equals(workTelephone, contact.workTelephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, mobile, workTelephone);
    }

    @Override
    public String toString() {
        return "Domain.Contact{" +
                "email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", workTelephone='" + workTelephone + '\'' +
                '}';
    }
    public static class ContactBuilder{
        private  String email;
        private  String mobile;
        private String workTelephone;

        public ContactBuilder() {
        }


        public ContactBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public ContactBuilder setMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public ContactBuilder setWorkTelephone(String workTelephone) {
            this.workTelephone = workTelephone;
            return this;
        }
        public ContactBuilder copy(Contact contact) {
            this.email = contact.email;
            this.mobile = contact.mobile;
            this.workTelephone = contact.workTelephone;
            return this;
        }

        public Contact build(){
            return new Contact(this);

        }
    }
}
