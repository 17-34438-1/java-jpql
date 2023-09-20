package com.datasoft.pcs.Model.DTO;

import javax.persistence.Column;
import java.util.List;

public class ViewIgmSubDetailReportModel {
    private Long id;
    private Long igmDetailId;
    private String rotation;
    private String lineNo;
    private String blNo;
    private String billOfEntryNo;
    private String billOfEntryDate;
    private String gpNo;
    private String gpDate;
    private String paidDate;
    private String voyNo;
    private String vesselName;
    private String date;
    private String packMarksNumber;
    private String description;
    private Long consigneeId;
    private String consigneeName;
    private Long cnfId;
    private String cnfName;
    private String agent;
    private Integer released;
    private String portComment;
    private List igmContainerList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIgmDetailId() {
        return igmDetailId;
    }

    public void setIgmDetailId(Long igmDetailId) {
        this.igmDetailId = igmDetailId;
    }

    public String getRotation() {
        return rotation;
    }

    public void setRotation(String rotation) {
        this.rotation = rotation;
    }

    public String getLineNo() {
        return lineNo;
    }

    public void setLineNo(String lineNo) {
        this.lineNo = lineNo;
    }

    public String getBlNo() {
        return blNo;
    }

    public void setBlNo(String blNo) {
        this.blNo = blNo;
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

    public String getGpNo() {
        return gpNo;
    }

    public void setGpNo(String gpNo) {
        this.gpNo = gpNo;
    }

    public String getGpDate() {
        return gpDate;
    }

    public void setGpDate(String gpDate) {
        this.gpDate = gpDate;
    }

    public String getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(String paidDate) {
        this.paidDate = paidDate;
    }

    public String getVoyNo() {
        return voyNo;
    }

    public void setVoyNo(String voyNo) {
        this.voyNo = voyNo;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPackMarksNumber() {
        return packMarksNumber;
    }

    public void setPackMarksNumber(String packMarksNumber) {
        this.packMarksNumber = packMarksNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getConsigneeId() {
        return consigneeId;
    }

    public void setConsigneeId(Long consigneeId) {
        this.consigneeId = consigneeId;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public Long getCnfId() {
        return cnfId;
    }

    public void setCnfId(Long cnfId) {
        this.cnfId = cnfId;
    }

    public String getCnfName() {
        return cnfName;
    }

    public void setCnfName(String cnfName) {
        this.cnfName = cnfName;
    }

    public String getAgent() {
        return agent;
    }
    public void setAgent(String agent) {
        this.agent = agent;
    }

    public Integer getReleased() {
        return released;
    }

    public void setReleased(Integer released) {
        this.released = released;
    }

    public String getPortComment() {
        return portComment;
    }

    public void setPortComment(String portComment) {
        this.portComment = portComment;
    }

    public List getIgmContainerList() {
        return igmContainerList;
    }

    public void setIgmContainerList(List igmContainerList) {
        this.igmContainerList = igmContainerList;
    }
}
