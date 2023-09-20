package com.datasoft.pcs.Model.cchaportdb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="igm_navy_response")
public class IgmNavyResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="auto_no")
    private Long auto_no ;
  // @ManyToOne
  //  @JoinColumn(name="igm_details_id")
   // IgmDetails igmDetails;
    @Column(name="igm_details_id")
   private Integer igm_details_id;

  @Column(name="egm_details_id")
  private Long egmDetailsId;

    @Column(name="response_details1")
    private String response_details1;

    @Column(name="response_details3")
    private String response_details3;

    @Column(name="response_details2")
    private String response_details2;

    @Column(name="hold_application")
    private String hold_application;

    @Column(name="rejected_application")
    private String rejected_application;

  @Column(name="rejected_date")
  private String rejected_date;

    @Column(name="final_amendment")
    private String final_amendment;

    @Column(name="appsubmitdate")
    private String appsubmitdate;

    @Column(name="navy_response_to_port")
    private String navy_response_to_port;

    @Column(name="to_custom")
    private String to_custom;

    @Column(name="permission_no")
    private String permission_no;

  @Column(name="secondapprovaltime")
  private String secondApprovalTime;
  @Column(name="hold_date")
  private String holdDate;






}
