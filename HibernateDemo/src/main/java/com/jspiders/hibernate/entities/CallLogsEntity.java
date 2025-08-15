package com.jspiders.hibernate.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "call_logs")
public class CallLogsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int callLogId;
    private String callType;
    private String dateAndTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "contact_id", nullable = false)
    private ContactEntity contactEntity;

    public int getCallLogId() {
        return callLogId;
    }

    public void setCallLogId(int logId) {
        this.callLogId = logId;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public ContactEntity getContactEntity() {
        return contactEntity;
    }

    public void setContactEntity(ContactEntity contactEntity) {
        this.contactEntity = contactEntity;
    }

    @Override
    public String toString() {
        return "CallLogsEntity{" +
                "callLogId=" + callLogId +
                ", callType='" + callType + '\'' +
                ", dateAndTime='" + dateAndTime + '\'' +
                '}';
    }
}
