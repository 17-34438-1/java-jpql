package com.datasoft.pcs.Model.cchaportdb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="igm_delivery_order")
public class IgmDeliveryOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="igm_detail_id")
    private Long igmDetailId;

    @Column(name="rotation")
    private String rotation;

    @Column(name="Line_No")
    private String lineNo;

    @Column(name="BL_No")
    private String blNo;

    @Column(name="bill_of_entry_no")
    private String billOfEntryNo;

    @Column(name="bill_of_entry_date")
    private String billOfEntryDate;

    @Column(name="gp_no")
    private String gpNo;

    @Column(name="gp_date")
    private String gpDate;

    @Column(name="paid_date")
    private String paidDate;

    @Column(name="voy_no")
    private String voyNo;

    @Column(name="vessel_name")
    private String vesselName;

    @Column(name="date")
    private String date;

    @Column(name="pack_marks_number")
    private String packMarksNumber;

    @Column(name="description")
    private String description;

    @Column(name="consignee_id")
    private Long consigneeId;

    @Column(name="consignee_name")
    private String consigneeName;

    @Column(name="cnf_id")
    private Long cnfId;

    @Column(name="agent")
    private String agent;

    @Column(name="released")
    private Integer released;

    @Column(name="released_by")
    private String releasedBy;

    @Column(name="released_time")
    private String releasedTime;

    @Column(name="port_comment")
    private String portComment;

    @Column(name="comment_by")
    private String commentBy;

    @Column(name="comment_time")
    private String commentTime;
}
