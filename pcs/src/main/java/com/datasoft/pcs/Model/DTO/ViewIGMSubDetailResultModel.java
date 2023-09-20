package com.datasoft.pcs.Model.DTO;

public class ViewIGMSubDetailResultModel {
  private Long id;
  private String cont_number;
  private Integer cont_size;
  private String cont_type;
  private String cont_iso_type;
  private Double cont_height;
  private String cont_status;
  private Double cont_gross_weight;
  private Integer cont_weight;
  private String cont_seal_number;
  private String cont_description;
  private String cont_imo;
  private String cont_un;
  private String Organization_Name;

    private Integer PFs;

  private Integer igm_detail_id;
  private Integer Consignee_ID;
  private String consignee_name;
  private  String Address_1;
  private Integer ff_clearance;

  private Integer Notify_ID;
  private String notify_name;

  private Integer CnF_ID_to_be_AccountedFor;
  private String cnf_name;
  private String AIN_No;

  public ViewIGMSubDetailResultModel(){

    }

    public ViewIGMSubDetailResultModel(Long id, String cont_number, Integer cont_size, String cont_type, String cont_iso_type, Double cont_height, String cont_status, Double cont_gross_weight, Integer cont_weight, String cont_seal_number, String cont_description, String cont_imo, String cont_un, String organization_Name) {
        this.id = id;
        this.cont_number = cont_number;
        this.cont_size = cont_size;
        this.cont_type = cont_type;
        this.cont_iso_type = cont_iso_type;
        this.cont_height = cont_height;
        this.cont_status = cont_status;
        this.cont_gross_weight = cont_gross_weight;
        this.cont_weight = cont_weight;
        this.cont_seal_number = cont_seal_number;
        this.cont_description = cont_description;
        this.cont_imo = cont_imo;
        this.cont_un = cont_un;
        Organization_Name = organization_Name;
    }

    public ViewIGMSubDetailResultModel(Long id, Integer igm_detail_id, Integer consignee_ID, Integer ff_clearance, Integer status) {
        this.id = id;
        this.igm_detail_id = igm_detail_id;
        if(status==2){
            this.Consignee_ID = consignee_ID;
        }
        else if(status==3){
            this.Notify_ID=consignee_ID;
        }
        this.ff_clearance = ff_clearance;
    }

    public ViewIGMSubDetailResultModel(String organization_Name,String status) {
    if(status.equals("orgName")){
       this.Organization_Name = organization_Name;
        }
    else if(status.equals("address1")){
        this.Address_1 = organization_Name;
    }
    else if(status.equals("ain")){
        this.AIN_No=organization_Name;

    }

    }


    public ViewIGMSubDetailResultModel(Integer PFs) {
        this.PFs = PFs;
    }
    public ViewIGMSubDetailResultModel(Long id,Integer igm_detail_id, Integer CnF_ID_to_be_AccountedFor) {
    this.id=id;
    this.igm_detail_id=igm_detail_id;
    this.CnF_ID_to_be_AccountedFor=CnF_ID_to_be_AccountedFor;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCont_number() {
        return cont_number;
    }

    public void setCont_number(String cont_number) {
        this.cont_number = cont_number;
    }

    public Integer getCont_size() {
        return cont_size;
    }

    public void setCont_size(Integer cont_size) {
        this.cont_size = cont_size;
    }

    public String getCont_type() {
        return cont_type;
    }

    public void setCont_type(String cont_type) {
        this.cont_type = cont_type;
    }

    public String getCont_iso_type() {
        return cont_iso_type;
    }

    public void setCont_iso_type(String cont_iso_type) {
        this.cont_iso_type = cont_iso_type;
    }

    public Double getCont_height() {
        return cont_height;
    }

    public void setCont_height(Double cont_height) {
        this.cont_height = cont_height;
    }

    public String getCont_status() {
        return cont_status;
    }

    public void setCont_status(String cont_status) {
        this.cont_status = cont_status;
    }

    public Double getCont_gross_weight() {
        return cont_gross_weight;
    }

    public void setCont_gross_weight(Double cont_gross_weight) {
        this.cont_gross_weight = cont_gross_weight;
    }

    public Integer getCont_weight() {
        return cont_weight;
    }

    public void setCont_weight(Integer cont_weight) {
        this.cont_weight = cont_weight;
    }

    public String getCont_seal_number() {
        return cont_seal_number;
    }

    public void setCont_seal_number(String cont_seal_number) {
        this.cont_seal_number = cont_seal_number;
    }

    public String getCont_description() {
        return cont_description;
    }

    public void setCont_description(String cont_description) {
        this.cont_description = cont_description;
    }

    public String getCont_imo() {
        return cont_imo;
    }

    public void setCont_imo(String cont_imo) {
        this.cont_imo = cont_imo;
    }

    public String getCont_un() {
        return cont_un;
    }

    public void setCont_un(String cont_un) {
        this.cont_un = cont_un;
    }

    public String getOrganization_Name() {
        return Organization_Name;
    }

    public void setOrganization_Name(String organization_Name) {
        Organization_Name = organization_Name;
    }

    public Integer getIgm_detail_id() {
        return igm_detail_id;
    }

    public void setIgm_detail_id(Integer igm_detail_id) {
        this.igm_detail_id = igm_detail_id;
    }

    public Integer getConsignee_ID() {
        return Consignee_ID;
    }

    public void setConsignee_ID(Integer consignee_ID) {
        Consignee_ID = consignee_ID;
    }

    public String getConsignee_name() {
        return consignee_name;
    }

    public void setConsignee_name(String consignee_name) {
        this.consignee_name = consignee_name;
    }

    public String getAddress_1() {
        return Address_1;
    }

    public void setAddress_1(String address_1) {
        Address_1 = address_1;
    }

    public Integer getFf_clearance() {
        return ff_clearance;
    }

    public void setFf_clearance(Integer ff_clearance) {
        this.ff_clearance = ff_clearance;
    }

    public Integer getPFs() {
        return PFs;
    }

    public void setPFs(Integer PFs) {
        this.PFs = PFs;
    }

    public Integer getNotify_ID() {
        return Notify_ID;
    }

    public void setNotify_ID(Integer notify_ID) {
        Notify_ID = notify_ID;
    }

    public String getNotify_name() {
        return notify_name;
    }

    public void setNotify_name(String notify_name) {
        this.notify_name = notify_name;
    }

    public Integer getCnF_ID_to_be_AccountedFor() {
        return CnF_ID_to_be_AccountedFor;
    }

    public void setCnF_ID_to_be_AccountedFor(Integer cnF_ID_to_be_AccountedFor) {
        CnF_ID_to_be_AccountedFor = cnF_ID_to_be_AccountedFor;
    }

    public String getCnf_name() {
        return cnf_name;
    }

    public void setCnf_name(String cnf_name) {
        this.cnf_name = cnf_name;
    }

    public String getAIN_No() {
        return AIN_No;
    }

    public void setAIN_No(String AIN_No) {
        this.AIN_No = AIN_No;
    }
}
