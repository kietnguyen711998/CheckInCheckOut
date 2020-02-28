
package com.example.checkincheckout.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CheckOut {

    @Expose
    private Object comment;
    @Expose
    private String date;
    @Expose
    private String employee;
    @Expose
    private Long id;
    @Expose
    private String idno;
    @Expose
    private String ipin;
    @Expose
    private String ipout;
    @Expose
    private String reason;
    @Expose
    private Long reference;
    @SerializedName("status_timein")
    private String statusTimein;
    @SerializedName("status_timeout")
    private String statusTimeout;
    @Expose
    private String timein;
    @Expose
    private Object timeout;
    @Expose
    private String totalhours;

    public Object getComment() {
        return comment;
    }

    public void setComment(Object comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getIpin() {
        return ipin;
    }

    public void setIpin(String ipin) {
        this.ipin = ipin;
    }

    public String getIpout() {
        return ipout;
    }

    public void setIpout(String ipout) {
        this.ipout = ipout;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getReference() {
        return reference;
    }

    public void setReference(Long reference) {
        this.reference = reference;
    }

    public String getStatusTimein() {
        return statusTimein;
    }

    public void setStatusTimein(String statusTimein) {
        this.statusTimein = statusTimein;
    }

    public String getStatusTimeout() {
        return statusTimeout;
    }

    public void setStatusTimeout(String statusTimeout) {
        this.statusTimeout = statusTimeout;
    }

    public String getTimein() {
        return timein;
    }

    public void setTimein(String timein) {
        this.timein = timein;
    }

    public Object getTimeout() {
        return timeout;
    }

    public void setTimeout(Object timeout) {
        this.timeout = timeout;
    }

    public String getTotalhours() {
        return totalhours;
    }

    public void setTotalhours(String totalhours) {
        this.totalhours = totalhours;
    }

    @NonNull
    @Override
    public String toString() {
        return getId() + "" + getTimein() + "" + getTotalhours();
    }
}
