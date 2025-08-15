package com.jspiders.hibernate.entities;

import jakarta.persistence.*;

@Entity
@Table(name ="profile_pic")
public class ProfilePictureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ppid;
    private int size;
    private String path;
    private String format;

    public int getPpid() {
        return ppid;
    }

    public void setPpid(int ppid) {
        this.ppid = ppid;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "ProfilePictureEntity{" +
                "ppid=" + ppid +
                ", size=" + size +
                ", path='" + path + '\'' +
                ", format='" + format + '\'' +
                '}';
    }
}
