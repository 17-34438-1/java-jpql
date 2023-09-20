package com.datasoft.pcs.Model.cchaportdb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="igm_supplimentary_detail")
public class IgmSupplimentaryDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="igm_master_id")
    private Long igmMasterId;

    @Column(name="igm_detail_id")
    private Long igmDetailId;

    @Column(name="master_Line_No")
    private Long masterLineNo;

    @Column(name="master_BL_No")
    private String masterBLNo;

    @Column(name="Import_Rotation_No")
    private String importRotationNo;

    @Column(name="Line_No")
    private Long lineNo;

    @Column(name="BL_No")
    private String blNo;

    @Column(name="Pack_Number")
    private Float packNumber;

    @Column(name="AFR")
    private String afr;

    @Column(name="Pack_Description")
    private String packDescription;

    @Column(name="Pack_Marks_Number")
    private String packMarksNumber;

    @Column(name="Description_of_Goods")
    private String descriptionOfGoods;

    @Column(name="Date_of_Entry_of_Goods")
    private String dateOfEntryOfGoods;

    @Column(name="weight")
    private Double weight;

    @Column(name="Bill_of_Entry_No")
    private String billOfEntryNo;

    @Column(name="Bill_of_Entry_Date")
    private String billOfEntryDate;

    @Column(name="office_code")
    private String officeCode;

    @Column(name="No_of_Pack_Delivered")
    private Long noOfPackDelivered;

    @Column(name="No_of_Pack_Discharged")
    private String noOfPackDischarged;

    @Column(name="Remarks")
    private String remarks;

    @Column(name="ConsigneeDesc")
    private String consigneeDesc;

    @Column(name="NotifyDesc")
    private String notifyDesc;

    @Column(name="igm_sup_detail_id")
    private Long igmSupDetailId;

    @Column(name="weight_unit")
    private String weightUnit;

    @Column(name="net_weight")
    private String netWeight;

    @Column(name="net_weight_unit")
    private String netWeightUnit;

    @Column(name="Submission_Date")
    private String submissionDate;

    @Column(name="type_of_igm")
    private String typeOfIgm;

    @Column(name="final_submit")
    private Integer finalSubmit;

    @Column(name="Submitee_Org_Id")
    private Long submiteeOrgId;





}
