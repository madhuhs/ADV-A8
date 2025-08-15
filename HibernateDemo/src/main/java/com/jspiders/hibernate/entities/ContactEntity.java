package com.jspiders.hibernate.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "contact")
public class ContactEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phone;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profilePicture",referencedColumnName = "ppid")
    private ProfilePictureEntity profilePicture;


    @OneToMany(
            mappedBy = "contactEntity",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )

    private List<CallLogsEntity> callLogs;

    public ContactEntity(int id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    public ContactEntity(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ProfilePictureEntity getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(ProfilePictureEntity profilePicture) {
        this.profilePicture = profilePicture;
    }


    public List<CallLogsEntity> getCallLogs() {
        return callLogs;
    }

    public void setCallLogs(List<CallLogsEntity> callLogs) {
        this.callLogs = callLogs;
    }

    @Override
    public String toString() {
        return "ContactEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", profilePicture=" + profilePicture +
                '}';
    }
}
