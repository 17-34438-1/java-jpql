package com.datasoft.pcs.Model.cchaportdb;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "organization_profiles")
public class OrganizationProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Organization name is mandatory")
    @NotBlank(message = "Organization name is mandatory")
    @Column(name = "Organization_Name")
    private String organizationName;

    @NotNull(message = "AIN No is mandatory")
    @NotBlank(message = "AIN No is mandatory")
    @Column(name = "AIN_No")
    private String ainNo;

    @Column(name = "AIN_No_New")
    private String ainNoNew;

    @NotNull(message = "License No is mandatory")
    @NotBlank(message = "License No is mandatory")
    @Column(name = "License_No")
    private String licenseNo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone = "Asia/Dhaka")
    @Column(name = "License_issue_Date")
    private Date licenceIssueDate;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone = "Asia/Dhaka")
    @Column(name = "Licence_Validity_Date")
    private Date licenceValidityDate;

    @NotNull(message = "Address One is mandatory")
    @NotBlank(message = "Address One is mandatory")
    @Column(name = "Address_1")
    private String addressOne;

    @Column(name = "Address_2")
    private String addressTwo;

    @Column(name = "Address_3")
    private String addressThree;

    @Column(name = "Telephone_No_Land")
    private String telephoneNoLand;

    @NotNull(message = "Mobile No is mandatory")
    @NotBlank(message = "Mobile No is mandatory")
    @Column(name = "Cell_No_1")
    private String cellNoOne;

    @Column(name = "Cell_No_2")
    private String cellNoTwo;

    @Column(name = "Fax_No")
    private String faxNo;

    @Column(name = "email")
    private String email;

    @Column(name = "logo")
    private String logo;

    @Column(name = "signature")
    private String signature;

    @Column(name = "URL")
    private String url;

    @Column(name = "Last_Update_By_id")
    private String lastUpdateById;

    @Column(name = "user_action")
    private String userAction;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Dhaka")
    @Column(name = "last_update")
    private Date lastUpdate = new Date();

    @Column(name = "License_No_Dh")
    private String licenseNoDh;

    @Column(name = "dummy")
    private String dummy;

    @Column(name = "Agent_Code")
    private String agentCode;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Dhaka")
    @Column(name = "last_payment_date")
    private Date lastPaymentDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Dhaka")
    @Column(name = "last_working_dt")
    private Date lastWorkingDate = new Date();

    @Column(name = "last_workin_comment")
    private String lastWorkingComment;

    @Column(name = "block_open")
    private String blockOpen;

    @Column(name = "block_open_by")
    private String blockOpenBy;

    @Column(name = "block_open_comment")
    private String blockOpenComment;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Dhaka")
    @Column(name = "block_date")
    private Date blockDate = new Date();

    @Column(name = "bizu_gkey")
    private Long bizuGkey;

    @Column(name = "entered_by", updatable = false)
    private String enteredBy;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Dhaka")
    @Column(name = "entry_time", updatable = false)
    private Date entryTime = new Date();

    @ManyToOne
    @JoinColumn(name = "Org_Type_id") //setting the name of the joining column
    private OrganizationType organizationType;

    @JsonIgnore
    @OneToMany(mappedBy = "organizationProfile", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<UserInfo> userInfos = new ArrayList<>();
}
