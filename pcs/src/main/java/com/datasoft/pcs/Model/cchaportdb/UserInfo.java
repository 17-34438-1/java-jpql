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
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Name is mandatory")
    @NotBlank(message = "Name is mandatory")
    @Column(name = "u_name")
    private String userName;

    @NotNull(message = "Login ID is mandatory")
    @NotBlank(message = "Login ID is mandatory")
    @Column(name = "login_id")
    private String loginId;

    @NotNull(message = "Password is mandatory")
    @NotBlank(message = "Password is mandatory")
    @Column(name = "login_password")
    private String loginPassword;

    @NotNull(message = "Address is mandatory")
    @NotBlank(message = "Address is mandatory")
    @Column(name = "address")
    private String address;

    @NotNull(message = "Telephone is mandatory")
    @NotBlank(message = "Telephone is mandatory")
    @Column(name = "telephone_no")
    private String telephoneNo;

    @NotNull(message = "Mobile No is mandatory")
    @NotBlank(message = "Mobile No is mandatory")
    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "email")
    private String email;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "ptext")
    private String ptext;

    @Column(name = "section")
    private Integer section;

    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Dhaka")
    @Column(name = "expire_date", updatable = false)
    private Date expireDate = new Date();

    @Column(name = "first_login_track")
    private Integer firstLoginTrack;

    @Column(name = "two_stp_st")
    private Integer twoStpSt;

    @Column(name = "otp_code")
    private String otpCode;

    @Column(name = "two_stp_verify_st")
    private Integer twoStpVerifySt;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Dhaka")
    @Column(name = "entry_at", updatable = false)
    private Date entryAt = new Date();

    @Column(name = "entry_by")
    private String entryBy;

    @Column(name = "entry_ip")
    private String entryIp;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Dhaka")
    @Column(name = "update_at")
    private Date updateAt = new Date();

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "update_ip")
    private String updateIp;

  /*  @ManyToOne
    @JoinColumn(name = "role_id") //setting the name of the joining column
    private Role userRole;*/


    @ManyToOne
    @JoinColumn(name = "org_id")
    private OrganizationProfile organizationProfile;
}
