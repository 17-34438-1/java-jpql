package com.datasoft.pcs.Model.DTO;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

public class ViewSupplimentaryDetailResultModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String contNumber;
    private Integer contSize;
    private String contType;
    private Float contHeight;
    private String contStatus;
    private Integer contWeight;
    private Double contGrossWeight;
    private String contSealNumber;
    private String contDescription;
    private String contImo;
    private String contUn;

    private Long igmSupDetailConsigneetabsId;
    private Long igmSupDetailId;
    private Long consigneeID;
    private String organizationName;
    private String address1;



    public ViewSupplimentaryDetailResultModel(){

    }

    public ViewSupplimentaryDetailResultModel(Long id, String contNumber, Integer contSize, String contType, Float contHeight, String contStatus, Integer contWeight, Double contGrossWeight, String contSealNumber, String contDescription, String contImo, String contUn) {
        this.id = id;
        this.contNumber = contNumber;
        this.contSize = contSize;
        this.contType = contType;
        this.contHeight = contHeight;
        this.contStatus = contStatus;
        this.contWeight = contWeight;
        this.contGrossWeight = contGrossWeight;
        this.contSealNumber = contSealNumber;
        this.contDescription = contDescription;
        this.contImo = contImo;
        this.contUn = contUn;
    }

    public ViewSupplimentaryDetailResultModel(Long igmSupDetailConsigneetabsId, Long igmSupDetailId, Long consigneeID){
        this.igmSupDetailConsigneetabsId=igmSupDetailConsigneetabsId;
        this.igmSupDetailId=igmSupDetailId;
        this.consigneeID=consigneeID;

    }

    public ViewSupplimentaryDetailResultModel(String organizationName,String status) {
        if(status.equals("orgName")){
            this.organizationName = organizationName;
        }
        else if(status.equals("address1")){
            this.address1 = organizationName;
        }
        else if(status.equals("ain")){
            this.address1=organizationName;

        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContNumber() {
        return contNumber;
    }

    public void setContNumber(String contNumber) {
        this.contNumber = contNumber;
    }

    public Integer getContSize() {
        return contSize;
    }

    public void setContSize(Integer contSize) {
        this.contSize = contSize;
    }

    public String getContType() {
        return contType;
    }

    public void setContType(String contType) {
        this.contType = contType;
    }

    public Float getContHeight() {
        return contHeight;
    }

    public void setContHeight(Float contHeight) {
        this.contHeight = contHeight;
    }

    public String getContStatus() {
        return contStatus;
    }

    public void setContStatus(String contStatus) {
        this.contStatus = contStatus;
    }

    public Integer getContWeight() {
        return contWeight;
    }

    public void setContWeight(Integer contWeight) {
        this.contWeight = contWeight;
    }

    public Double getContGrossWeight() {
        return contGrossWeight;
    }

    public void setContGrossWeight(Double contGrossWeight) {
        this.contGrossWeight = contGrossWeight;
    }

    public String getContSealNumber() {
        return contSealNumber;
    }

    public void setContSealNumber(String contSealNumber) {
        this.contSealNumber = contSealNumber;
    }

    public String getContDescription() {
        return contDescription;
    }

    public void setContDescription(String contDescription) {
        this.contDescription = contDescription;
    }

    public String getContImo() {
        return contImo;
    }

    public void setContImo(String contImo) {
        this.contImo = contImo;
    }

    public String getContUn() {
        return contUn;
    }

    public void setContUn(String contUn) {
        this.contUn = contUn;
    }

    public Long getIgmSupDetailConsigneetabsId() {
        return igmSupDetailConsigneetabsId;
    }

    public void setIgmSupDetailConsigneetabsId(Long igmSupDetailConsigneetabsId) {
        this.igmSupDetailConsigneetabsId = igmSupDetailConsigneetabsId;
    }

    public Long getIgmSupDetailId() {
        return igmSupDetailId;
    }

    public void setIgmSupDetailId(Long igmSupDetailId) {
        this.igmSupDetailId = igmSupDetailId;
    }

    public Long getConsigneeID() {
        return consigneeID;
    }

    public void setConsigneeID(Long consigneeID) {
        this.consigneeID = consigneeID;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }
}
