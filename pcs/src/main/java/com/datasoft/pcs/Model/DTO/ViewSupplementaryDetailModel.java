package com.datasoft.pcs.Model.DTO;


import javax.persistence.Column;
import java.util.List;

public class ViewSupplementaryDetailModel {

    private Long id;
    private Long igmMasterId;
    private Long igmDetailId;
    private Long masterLineNo;
    private String masterBLNo;
    private String importRotationNo;
    private Long lineNo;
    private String blNo;
    private Float packNumber;
    private String afr;
    private String packDescription;
    private String packMarksNumber;
    private String DescriptionOfGoods;
    private String dateOfEntryOfGoods;
    private Double weight;
    private String billOfEntryNo;
    private String billOfEntryDate;
    private String officeCode;
    private Long noOfPackDelivered;
    private String noOfPackDischarged;
    private String remarks;
    private String consigneeDesc;
    private String notifyDesc;
    private Long igmSupDetailId;
    private String weightUnit;
    private String netWeight;
    private String netWeightUnit;
    private String submissionDate;
    private String typeOfIgm;
    private Integer finalSubmit;
    private Long submiteeOrgId;
    private String navy_response_to_port;
    private String response_details1;
    private String response_details2;
    private String response_details3;
    private String secondApprovalTime;
    private String hold_application;
    private String holdDate;
    private String rejected_application;
    private String rejected_date;
    private String final_amendment;
    private String organizationName;
    private String ainNo;
    private String ainNoNew;


    private List resultListFirst;
    private List resultListSecond;
    private List resultListThird;
    private List resultListFour;


    public  ViewSupplementaryDetailModel(){

    }

    public ViewSupplementaryDetailModel(Long id, Long igmMasterId, Long igmDetailId, Long masterLineNo,
                                        String masterBLNo, String importRotationNo, Long lineNo,
                                        String blNo, Float packNumber, String afr, String packDescription,
                                        String packMarksNumber, String descriptionOfGoods, String dateOfEntryOfGoods,
                                        Double weight, String billOfEntryNo, String billOfEntryDate, String officeCode,
                                        Long noOfPackDelivered, String noOfPackDischarged, String remarks, String consigneeDesc,
                                        String notifyDesc, Long igmSupDetailId, String weightUnit, String netWeight, String netWeightUnit,
                                        String submissionDate, String typeOfIgm, Integer finalSubmit, Long submiteeOrgId, String navy_response_to_port,
                                        String response_details1, String response_details2, String response_details3,
                                        String secondApprovalTime, String hold_application, String holdDate, String rejected_application,
                                        String rejected_date, String final_amendment, String organizationName, String ainNo, String ainNoNew) {
        this.id = id;
        this.igmMasterId = igmMasterId;
        this.igmDetailId = igmDetailId;
        this.masterLineNo = masterLineNo;
        this.masterBLNo = masterBLNo;
        this.importRotationNo = importRotationNo;
        this.lineNo = lineNo;
        this.blNo = blNo;
        this.packNumber = packNumber;
        this.afr = afr;
        this.packDescription = packDescription;
        this.packMarksNumber = packMarksNumber;
        DescriptionOfGoods = descriptionOfGoods;
        this.dateOfEntryOfGoods = dateOfEntryOfGoods;
        this.weight = weight;
        this.billOfEntryNo = billOfEntryNo;
        this.billOfEntryDate = billOfEntryDate;
        this.officeCode = officeCode;
        this.noOfPackDelivered = noOfPackDelivered;
        this.noOfPackDischarged = noOfPackDischarged;
        this.remarks = remarks;
        this.consigneeDesc = consigneeDesc;
        this.notifyDesc = notifyDesc;
        this.igmSupDetailId = igmSupDetailId;
        this.weightUnit = weightUnit;
        this.netWeight = netWeight;
        this.netWeightUnit = netWeightUnit;
        this.submissionDate = submissionDate;
        this.typeOfIgm = typeOfIgm;
        this.finalSubmit = finalSubmit;
        this.submiteeOrgId = submiteeOrgId;
        this.navy_response_to_port = navy_response_to_port;
        this.response_details1 = response_details1;
        this.response_details2 = response_details2;
        this.response_details3 = response_details3;
        this.secondApprovalTime = secondApprovalTime;
        this.hold_application = hold_application;
        this.holdDate = holdDate;
        this.rejected_application = rejected_application;
        this.rejected_date = rejected_date;
        this.final_amendment = final_amendment;
        this.organizationName = organizationName;
        this.ainNo = ainNo;
        this.ainNoNew = ainNoNew;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIgmMasterId() {
        return igmMasterId;
    }

    public void setIgmMasterId(Long igmMasterId) {
        this.igmMasterId = igmMasterId;
    }

    public Long getIgmDetailId() {
        return igmDetailId;
    }

    public void setIgmDetailId(Long igmDetailId) {
        this.igmDetailId = igmDetailId;
    }

    public Long getMasterLineNo() {
        return masterLineNo;
    }

    public void setMasterLineNo(Long masterLineNo) {
        this.masterLineNo = masterLineNo;
    }

    public String getMasterBLNo() {
        return masterBLNo;
    }

    public void setMasterBLNo(String masterBLNo) {
        this.masterBLNo = masterBLNo;
    }

    public String getImportRotationNo() {
        return importRotationNo;
    }

    public void setImportRotationNo(String importRotationNo) {
        this.importRotationNo = importRotationNo;
    }

    public Long getLineNo() {
        return lineNo;
    }

    public void setLineNo(Long lineNo) {
        this.lineNo = lineNo;
    }

    public String getBlNo() {
        return blNo;
    }

    public void setBlNo(String blNo) {
        this.blNo = blNo;
    }

    public Float getPackNumber() {
        return packNumber;
    }

    public void setPackNumber(Float packNumber) {
        this.packNumber = packNumber;
    }

    public String getAfr() {
        return afr;
    }

    public void setAfr(String afr) {
        this.afr = afr;
    }

    public String getPackDescription() {
        return packDescription;
    }

    public void setPackDescription(String packDescription) {
        this.packDescription = packDescription;
    }

    public String getPackMarksNumber() {
        return packMarksNumber;
    }

    public void setPackMarksNumber(String packMarksNumber) {
        this.packMarksNumber = packMarksNumber;
    }

    public String getDescriptionOfGoods() {
        return DescriptionOfGoods;
    }

    public void setDescriptionOfGoods(String descriptionOfGoods) {
        DescriptionOfGoods = descriptionOfGoods;
    }

    public String getDateOfEntryOfGoods() {
        return dateOfEntryOfGoods;
    }

    public void setDateOfEntryOfGoods(String dateOfEntryOfGoods) {
        this.dateOfEntryOfGoods = dateOfEntryOfGoods;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getBillOfEntryNo() {
        return billOfEntryNo;
    }

    public void setBillOfEntryNo(String billOfEntryNo) {
        this.billOfEntryNo = billOfEntryNo;
    }

    public String getBillOfEntryDate() {
        return billOfEntryDate;
    }

    public void setBillOfEntryDate(String billOfEntryDate) {
        this.billOfEntryDate = billOfEntryDate;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public Long getNoOfPackDelivered() {
        return noOfPackDelivered;
    }

    public void setNoOfPackDelivered(Long noOfPackDelivered) {
        this.noOfPackDelivered = noOfPackDelivered;
    }

    public String getNoOfPackDischarged() {
        return noOfPackDischarged;
    }

    public void setNoOfPackDischarged(String noOfPackDischarged) {
        this.noOfPackDischarged = noOfPackDischarged;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getConsigneeDesc() {
        return consigneeDesc;
    }

    public void setConsigneeDesc(String consigneeDesc) {
        this.consigneeDesc = consigneeDesc;
    }

    public String getNotifyDesc() {
        return notifyDesc;
    }

    public void setNotifyDesc(String notifyDesc) {
        this.notifyDesc = notifyDesc;
    }

    public Long getIgmSupDetailId() {
        return igmSupDetailId;
    }

    public void setIgmSupDetailId(Long igmSupDetailId) {
        this.igmSupDetailId = igmSupDetailId;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    public String getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(String netWeight) {
        this.netWeight = netWeight;
    }

    public String getNetWeightUnit() {
        return netWeightUnit;
    }

    public void setNetWeightUnit(String netWeightUnit) {
        this.netWeightUnit = netWeightUnit;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getTypeOfIgm() {
        return typeOfIgm;
    }

    public void setTypeOfIgm(String typeOfIgm) {
        this.typeOfIgm = typeOfIgm;
    }

    public Integer getFinalSubmit() {
        return finalSubmit;
    }

    public void setFinalSubmit(Integer finalSubmit) {
        this.finalSubmit = finalSubmit;
    }

    public Long getSubmiteeOrgId() {
        return submiteeOrgId;
    }

    public void setSubmiteeOrgId(Long submiteeOrgId) {
        this.submiteeOrgId = submiteeOrgId;
    }

    public String getNavy_response_to_port() {
        return navy_response_to_port;
    }

    public void setNavy_response_to_port(String navy_response_to_port) {
        this.navy_response_to_port = navy_response_to_port;
    }

    public String getResponse_details1() {
        return response_details1;
    }

    public void setResponse_details1(String response_details1) {
        this.response_details1 = response_details1;
    }

    public String getResponse_details2() {
        return response_details2;
    }

    public void setResponse_details2(String response_details2) {
        this.response_details2 = response_details2;
    }

    public String getResponse_details3() {
        return response_details3;
    }

    public void setResponse_details3(String response_details3) {
        this.response_details3 = response_details3;
    }

    public String getSecondApprovalTime() {
        return secondApprovalTime;
    }

    public void setSecondApprovalTime(String secondApprovalTime) {
        this.secondApprovalTime = secondApprovalTime;
    }

    public String getHold_application() {
        return hold_application;
    }

    public void setHold_application(String hold_application) {
        this.hold_application = hold_application;
    }

    public String getHoldDate() {
        return holdDate;
    }

    public void setHoldDate(String holdDate) {
        this.holdDate = holdDate;
    }

    public String getRejected_application() {
        return rejected_application;
    }

    public void setRejected_application(String rejected_application) {
        this.rejected_application = rejected_application;
    }

    public String getRejected_date() {
        return rejected_date;
    }

    public void setRejected_date(String rejected_date) {
        this.rejected_date = rejected_date;
    }

    public String getFinal_amendment() {
        return final_amendment;
    }

    public void setFinal_amendment(String final_amendment) {
        this.final_amendment = final_amendment;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getAinNo() {
        return ainNo;
    }

    public void setAinNo(String ainNo) {
        this.ainNo = ainNo;
    }

    public String getAinNoNew() {
        return ainNoNew;
    }

    public void setAinNoNew(String ainNoNew) {
        this.ainNoNew = ainNoNew;
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
}
