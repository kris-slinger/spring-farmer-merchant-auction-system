package com.slinger.farmerMerchantAuctionSystem.CustomUser;


import javax.persistence.*;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name="custom_user_email_Unique",columnNames = "customUserEmail")
})
public class CustomUser {
    @Id
    @SequenceGenerator(
            name="user_sequence",
            sequenceName="user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Integer customUserId;
    private String customUserName;
    private Integer customUserNationalId;
    private String customUserEmail;
    private String customUserPassword;
    private String customUserRole;

    public CustomUser() {
    }

    public CustomUser(String customUserName, Integer customUserNationalId, String customUserEmail, String customUserPassword, String customUserRole) {
        this.customUserName = customUserName;
        this.customUserNationalId = customUserNationalId;
        this.customUserEmail = customUserEmail;
        this.customUserPassword = customUserPassword;
        this.customUserRole = customUserRole;
    }

    public Integer getCustomUserId() {
        return customUserId;
    }

    public void setCustomUserId(Integer customUserId) {
        this.customUserId = customUserId;
    }

    public String getCustomUserName() {
        return customUserName;
    }

    public void setCustomUserName(String customUserName) {
        this.customUserName = customUserName;
    }

    public Integer getCustomUserNationalId() {
        return customUserNationalId;
    }

    public void setCustomUserNationalId(Integer customUserNationalId) {
        this.customUserNationalId = customUserNationalId;
    }

    public String getCustomUserEmail() {
        return customUserEmail;
    }

    public void setCustomUserEmail(String customUserEmail) {
        this.customUserEmail = customUserEmail;
    }

    public String getCustomUserPassword() {
        return customUserPassword;
    }

    public void setCustomUserPassword(String customUserPassword) {
        this.customUserPassword = customUserPassword;
    }

    public String getCustomUserRole() {
        return customUserRole;
    }

    public void setCustomUserRole(String customUserRole) {
        this.customUserRole = customUserRole;
    }

    @Override
    public String toString() {
        return "CustomUser{" +
                "customUserId=" + customUserId +
                ", customUserName='" + customUserName + '\'' +
                ", customUserNationalId=" + customUserNationalId +
                ", customUserEmail='" + customUserEmail + '\'' +
                ", customUserPassword='" + customUserPassword + '\'' +
                ", customUserRole='" + customUserRole + '\'' +
                '}';
    }
}
