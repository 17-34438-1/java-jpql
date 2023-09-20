package com.datasoft.pcs.Model.DTO;

import java.util.List;

public class ViewIgmSubDetailModel {
    private Long id;
    private Long IGM_id;
    private String Import_Rotation_No;
    private Integer Line_No;
    private String BL_No;
    private Double Pack_Number;
    private String Pack_Description;
    private String Pack_Marks_Number;
    private String Description_of_Goods;
    private String Date_of_Entry_of_Goods;
    private Double weight;
    private String weight_unit;
    private String net_weight;
    private String final_submit_date;
    private String net_weight_unit;
    private String Bill_of_Entry_No;
    private String Bill_of_Entry_Date;
    private String office_code;
    private Double No_of_Pack_Delivered;
    private String No_of_Pack_Discharged;
    private String Remarks;
    private String AFR;
    private String int_block;
    private String R_No;
    private String R_Date;
    private String delivery_block_stat;
    private String ConsigneeDesc;
    private String NotifyDesc;
    private String navy_comments;
    private Long Submitee_Org_Id;
    private String mlocode;
    private String type_of_igm;
    private String imco;
    private String un;
    private String extra_remarks;
    private String response_details1;
    private String response_details3;
    private String response_details2;
    private String hold_application;
    private String rejected_application;
    private String submitId;
    private Long auto_no;
    private String final_amendment;
    private String appsubmitdate;
    private String navy_response_to_port;
    private String to_custom;
    private String permission_no;
    private String Submission_Date;

    private String Organization_Name;
    private String AIN_No;


    private List resultListFirst;
    private List resultListSecond;
    private List resultListThird;
    private List resultListFour;


    public ViewIgmSubDetailModel(){

    }


    public ViewIgmSubDetailModel(Long id, Long IGM_id, String import_Rotation_No, Integer line_No,
                                 String BL_No, Double pack_Number, String pack_Description, String pack_Marks_Number,
                                 String Description_of_Goods, String Date_of_Entry_of_Goods,Double weight,
                                 String weight_unit,String net_weight,String final_submit_date ,String net_weight_unit,
                                 String Bill_of_Entry_No,String Bill_of_Entry_Date, String office_code,Double No_of_Pack_Delivered,
                                 String No_of_Pack_Discharged,String Remarks,String AFR,String int_block,String R_No, String R_Date,
                                 String delivery_block_stat, String ConsigneeDesc,String NotifyDesc,String navy_comments,Long Submitee_Org_Id,
                                 String mlocode,String type_of_igm,String imco,String un, String extra_remarks, String response_details1,
                                 String response_details3,String response_details2,String hold_application,String rejected_application,
                                 Long auto_no,String final_amendment,String appsubmitdate,String navy_response_to_port,String permission_no,String Submission_Date) {




        this.id = id;
        this.IGM_id = IGM_id;
        this.Import_Rotation_No = import_Rotation_No;
        this.Line_No = line_No;
        this.BL_No = BL_No;
        this.Pack_Number = pack_Number;
        this.Pack_Description = pack_Description;
        this.Pack_Marks_Number = pack_Marks_Number;
        this.Description_of_Goods=Description_of_Goods;
        this.Date_of_Entry_of_Goods=Date_of_Entry_of_Goods;
        this.weight=weight;
        this.weight_unit=weight_unit;
        this.net_weight=net_weight;
        this.final_submit_date=final_submit_date;
        this.Bill_of_Entry_No=Bill_of_Entry_No;
        this.Bill_of_Entry_Date=Bill_of_Entry_Date;
        this.office_code=office_code;
        this.No_of_Pack_Delivered=No_of_Pack_Delivered;
        this.No_of_Pack_Discharged=No_of_Pack_Discharged;
        this.Remarks=Remarks;
        this.AFR=AFR;
        this.int_block=int_block;
        this.R_No=R_No;
        this.R_Date=R_Date;
        this.delivery_block_stat=delivery_block_stat;
        this.ConsigneeDesc=ConsigneeDesc;
        this.NotifyDesc=NotifyDesc;
        this.navy_comments=navy_comments;
        this.Submitee_Org_Id=Submitee_Org_Id;
        this.mlocode=mlocode;
        this.type_of_igm=type_of_igm;
        this.imco=imco;
        this.un=un;
        this.extra_remarks=extra_remarks;
        this.response_details1=response_details1;
        this.response_details3=response_details3;
        this.response_details2=response_details2;
        this.hold_application=hold_application;
        this.rejected_application=rejected_application;
        this.auto_no=auto_no;
        this.final_amendment=final_amendment;
        this.appsubmitdate=appsubmitdate;
        this.navy_response_to_port=navy_response_to_port;
        this.permission_no=permission_no;
        this.Submission_Date=Submission_Date;




    }

    public ViewIgmSubDetailModel(Long id, Long IGM_id, String import_Rotation_No, Integer line_No,
                                 String BL_No, Double pack_Number, String pack_Description, String pack_Marks_Number,
                                 String Description_of_Goods, String Date_of_Entry_of_Goods,Double weight,
                                 String weight_unit,String net_weight,String final_submit_date ,String net_weight_unit,
                                 String Bill_of_Entry_No,String Bill_of_Entry_Date, String office_code,Double No_of_Pack_Delivered,
                                 String No_of_Pack_Discharged,String Remarks,String AFR,String int_block,String R_No, String R_Date,
                                 String delivery_block_stat, String ConsigneeDesc,String NotifyDesc,String navy_comments,Long Submitee_Org_Id,
                                 String mlocode,String type_of_igm,String imco,String un, String extra_remarks) {




        this.id = id;
        this.IGM_id = IGM_id;
        this.Import_Rotation_No = import_Rotation_No;
        this.Line_No = line_No;
        this.BL_No = BL_No;
        this.Pack_Number = pack_Number;
        this.Pack_Description = pack_Description;
        this.Pack_Marks_Number = pack_Marks_Number;
        this.Description_of_Goods=Description_of_Goods;
        this.Date_of_Entry_of_Goods=Date_of_Entry_of_Goods;
        this.weight=weight;
        this.weight_unit=weight_unit;
        this.net_weight=net_weight;
        this.final_submit_date=final_submit_date;
        this.Bill_of_Entry_No=Bill_of_Entry_No;
        this.Bill_of_Entry_Date=Bill_of_Entry_Date;
        this.office_code=office_code;
        this.No_of_Pack_Delivered=No_of_Pack_Delivered;
        this.No_of_Pack_Discharged=No_of_Pack_Discharged;
        this.Remarks=Remarks;
        this.AFR=AFR;
        this.int_block=int_block;
        this.R_No=R_No;
        this.R_Date=R_Date;
        this.delivery_block_stat=delivery_block_stat;
        this.ConsigneeDesc=ConsigneeDesc;
        this.NotifyDesc=NotifyDesc;
        this.navy_comments=navy_comments;
        this.Submitee_Org_Id=Submitee_Org_Id;
        this.mlocode=mlocode;
        this.type_of_igm=type_of_igm;
        this.imco=imco;
        this.un=un;
        this.extra_remarks=extra_remarks;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIGM_id() {
        return IGM_id;
    }

    public void setIGM_id(Long IGM_id) {
        this.IGM_id = IGM_id;
    }

    public String getImport_Rotation_No() {
        return Import_Rotation_No;
    }

    public void setImport_Rotation_No(String import_Rotation_No) {
        Import_Rotation_No = import_Rotation_No;
    }

    public Integer getLine_No() {
        return Line_No;
    }

    public void setLine_No(Integer line_No) {
        Line_No = line_No;
    }

    public String getBL_No() {
        return BL_No;
    }

    public void setBL_No(String BL_No) {
        this.BL_No = BL_No;
    }

    public Double getPack_Number() {
        return Pack_Number;
    }

    public void setPack_Number(Double pack_Number) {
        Pack_Number = pack_Number;
    }

    public String getPack_Description() {
        return Pack_Description;
    }

    public void setPack_Description(String pack_Description) {
        Pack_Description = pack_Description;
    }

    public String getPack_Marks_Number() {
        return Pack_Marks_Number;
    }

    public void setPack_Marks_Number(String pack_Marks_Number) {
        Pack_Marks_Number = pack_Marks_Number;
    }

    public String getDescription_of_Goods() {
        return Description_of_Goods;
    }

    public void setDescription_of_Goods(String description_of_Goods) {
        Description_of_Goods = description_of_Goods;
    }

    public String getDate_of_Entry_of_Goods() {
        return Date_of_Entry_of_Goods;
    }

    public void setDate_of_Entry_of_Goods(String date_of_Entry_of_Goods) {
        Date_of_Entry_of_Goods = date_of_Entry_of_Goods;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getWeight_unit() {
        return weight_unit;
    }

    public void setWeight_unit(String weight_unit) {
        this.weight_unit = weight_unit;
    }

    public String getNet_weight() {
        return net_weight;
    }

    public void setNet_weight(String net_weight) {
        this.net_weight = net_weight;
    }


    public String getNet_weight_unit() {
        return net_weight_unit;
    }

    public void setNet_weight_unit(String net_weight_unit) {
        this.net_weight_unit = net_weight_unit;
    }

    public String getBill_of_Entry_No() {
        return Bill_of_Entry_No;
    }

    public void setBill_of_Entry_No(String bill_of_Entry_No) {
        Bill_of_Entry_No = bill_of_Entry_No;
    }

    public String getBill_of_Entry_Date() {
        return Bill_of_Entry_Date;
    }

    public void setBill_of_Entry_Date(String bill_of_Entry_Date) {
        Bill_of_Entry_Date = bill_of_Entry_Date;
    }

    public String getOffice_code() {
        return office_code;
    }

    public void setOffice_code(String office_code) {
        this.office_code = office_code;
    }

    public Double getNo_of_Pack_Delivered() {
        return No_of_Pack_Delivered;
    }

    public void setNo_of_Pack_Delivered(Double no_of_Pack_Delivered) {
        No_of_Pack_Delivered = no_of_Pack_Delivered;
    }

    public String getNo_of_Pack_Discharged() {
        return No_of_Pack_Discharged;
    }

    public void setNo_of_Pack_Discharged(String no_of_Pack_Discharged) {
        No_of_Pack_Discharged = no_of_Pack_Discharged;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    public String getAFR() {
        return AFR;
    }

    public void setAFR(String AFR) {
        this.AFR = AFR;
    }

    public String getInt_block() {
        return int_block;
    }

    public void setInt_block(String int_block) {
        this.int_block = int_block;
    }

    public String getR_No() {
        return R_No;
    }

    public void setR_No(String r_No) {
        R_No = r_No;
    }

    public String getR_Date() {
        return R_Date;
    }

    public void setR_Date(String r_Date) {
        R_Date = r_Date;
    }

    public String getDelivery_block_stat() {
        return delivery_block_stat;
    }

    public void setDelivery_block_stat(String delivery_block_stat) {
        this.delivery_block_stat = delivery_block_stat;
    }

    public String getConsigneeDesc() {
        return ConsigneeDesc;
    }

    public void setConsigneeDesc(String consigneeDesc) {
        ConsigneeDesc = consigneeDesc;
    }

    public String getFinal_submit_date() {
        return final_submit_date;
    }

    public void setFinal_submit_date(String final_submit_date) {
        this.final_submit_date = final_submit_date;
    }

    public String getNotifyDesc() {
        return NotifyDesc;
    }

    public void setNotifyDesc(String notifyDesc) {
        NotifyDesc = notifyDesc;
    }

    public String getNavy_comments() {
        return navy_comments;
    }

    public void setNavy_comments(String navy_comments) {
        this.navy_comments = navy_comments;
    }

    public Long getSubmitee_Org_Id() {
        return Submitee_Org_Id;
    }

    public void setSubmitee_Org_Id(Long submitee_Org_Id) {
        Submitee_Org_Id = submitee_Org_Id;
    }

    public String getMlocode() {
        return mlocode;
    }

    public void setMlocode(String mlocode) {
        this.mlocode = mlocode;
    }

    public String getType_of_igm() {
        return type_of_igm;
    }

    public void setType_of_igm(String type_of_igm) {
        this.type_of_igm = type_of_igm;
    }

    public String getOrganization_Name() {
        return Organization_Name;
    }

    public void setOrganization_Name(String organization_Name) {
        Organization_Name = organization_Name;
    }

    public String getAIN_No() {
        return AIN_No;
    }

    public void setAIN_No(String AIN_No) {
        this.AIN_No = AIN_No;
    }

    public String getImco() {
        return imco;
    }

    public void setImco(String imco) {
        this.imco = imco;
    }

    public String getUn() {
        return un;
    }

    public void setUn(String un) {
        this.un = un;
    }

    public String getExtra_remarks() {
        return extra_remarks;
    }

    public void setExtra_remarks(String extra_remarks) {
        this.extra_remarks = extra_remarks;
    }

    public String getResponse_details1() {
        return response_details1;
    }

    public void setResponse_details1(String response_details1) {
        this.response_details1 = response_details1;
    }

    public String getResponse_details3() {
        return response_details3;
    }

    public void setResponse_details3(String response_details3) {
        this.response_details3 = response_details3;
    }

    public String getResponse_details2() {
        return response_details2;
    }

    public void setResponse_details2(String response_details2) {
        this.response_details2 = response_details2;
    }

    public String getHold_application() {
        return hold_application;
    }

    public void setHold_application(String hold_application) {
        this.hold_application = hold_application;
    }

    public String getRejected_application() {
        return rejected_application;
    }

    public void setRejected_application(String rejected_application) {
        this.rejected_application = rejected_application;
    }

    public String getSubmitId() {
        return submitId;
    }

    public void setSubmitId(String submitId) {
        this.submitId = submitId;
    }

    public String getFinal_amendment() {
        return final_amendment;
    }

    public void setFinal_amendment(String final_amendment) {
        this.final_amendment = final_amendment;
    }

    public String getAppsubmitdate() {
        return appsubmitdate;
    }

    public void setAppsubmitdate(String appsubmitdate) {
        this.appsubmitdate = appsubmitdate;
    }

    public String getNavy_response_to_port() {
        return navy_response_to_port;
    }

    public void setNavy_response_to_port(String navy_response_to_port) {
        this.navy_response_to_port = navy_response_to_port;
    }

    public String getTo_custom() {
        return to_custom;
    }

    public void setTo_custom(String to_custom) {
        this.to_custom = to_custom;
    }

    public String getPermission_no() {
        return permission_no;
    }

    public void setPermission_no(String permission_no) {
        this.permission_no = permission_no;
    }

    public String getSubmission_Date() {
        return Submission_Date;
    }

    public void setSubmission_Date(String submission_Date) {
        Submission_Date = submission_Date;
    }

    public List getResultListFirst() {
        return resultListFirst;
    }

    public void setResultListFirst(List resultListFirst) {
        this.resultListFirst = resultListFirst;
    }

    public List getResultListSecond() {
        return resultListSecond;
    }

    public void setResultListSecond(List resultListSecond) {
        this.resultListSecond = resultListSecond;
    }

    public List getResultListThird() {
        return resultListThird;
    }

    public void setResultListThird(List resultListThird) {
        this.resultListThird = resultListThird;
    }

    public List getResultListFour() {
        return resultListFour;
    }

    public void setResultListFour(List resultListFour) {
        this.resultListFour = resultListFour;
    }

    public Long getAuto_no() {
        return auto_no;
    }

    public void setAuto_no(Long auto_no) {
        this.auto_no = auto_no;
    }
}
