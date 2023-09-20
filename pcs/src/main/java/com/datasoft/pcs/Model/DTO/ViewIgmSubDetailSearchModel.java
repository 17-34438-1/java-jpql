package com.datasoft.pcs.Model.DTO;

import java.util.List;

public class ViewIgmSubDetailSearchModel {
    private Long id;
    private String organizationName;
    private String Import_Rotation_No;
    private List result1;
    private List result2;
    private List result3;
    private List result4;
    private List result5;
    private List result6;
    private List result7;
    private List result8;
    private List result9;
    private List result10;


   public ViewIgmSubDetailSearchModel(){

   }
   public ViewIgmSubDetailSearchModel(Long id){
       this.id=id;
   }
   public ViewIgmSubDetailSearchModel(String organizationName){
       this.organizationName=organizationName;

   }
   public ViewIgmSubDetailSearchModel(Long id,String organizationName){
       this.id=id;
       this.organizationName=organizationName;

   }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getImport_Rotation_No() {
        return Import_Rotation_No;
    }

    public void setImport_Rotation_No(String import_Rotation_No) {
        Import_Rotation_No = import_Rotation_No;
    }

    public List getResult1() {
        return result1;
    }

    public void setResult1(List result1) {
        this.result1 = result1;
    }

    public List getResult2() {
        return result2;
    }

    public void setResult2(List result2) {
        this.result2 = result2;
    }

    public List getResult3() {
        return result3;
    }

    public void setResult3(List result3) {
        this.result3 = result3;
    }

    public List getResult4() {
        return result4;
    }

    public void setResult4(List result4) {
        this.result4 = result4;
    }

    public List getResult5() {
        return result5;
    }

    public void setResult5(List result5) {
        this.result5 = result5;
    }

    public List getResult6() {
        return result6;
    }

    public void setResult6(List result6) {
        this.result6 = result6;
    }

    public List getResult7() {
        return result7;
    }

    public void setResult7(List result7) {
        this.result7 = result7;
    }

    public List getResult8() {
        return result8;
    }

    public void setResult8(List result8) {
        this.result8 = result8;
    }

    public List getResult9() {
        return result9;
    }

    public void setResult9(List result9) {
        this.result9 = result9;
    }

    public List getResult10() {
        return result10;
    }

    public void setResult10(List result10) {
        this.result10 = result10;
    }
}
