package com.datasoft.pcs.Service;
import com.datasoft.pcs.Model.DTO.*;
import com.datasoft.pcs.Model.cchaportdb.*;

import com.datasoft.pcs.Repository.cchaportdb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ViewIgmSubDetailService {
    @Autowired
    IgmMastersRepository igmMastersRepository;
    @Autowired
    OrganizationProfilesRepository organizationProfilesRepository;
    @Autowired
    IgmDetailsRepository igmDetailsRepository;
    @Autowired
    IgmDeliveryOrderRepository igmDeliveryOrderRepository;
    @Autowired
    OrganizationProfileRepository organizationProfileRepository;
    @Autowired
    IgmDetailContainerRepository igmDetailContainerRepository;



    @Autowired
    @Qualifier("cchaportdbEntityManagerFactory")
    EntityManagerFactory entityManagerFactory;

    public List getViewIgmSubDetalList(String type, Integer limit, Integer start, Integer status, Long code , Integer queryStatus ){
        List<ViewIgmSubDetailMainModel> mainResultList =new ArrayList<>();
        List<ViewIgmSubDetailModel> resultList =new ArrayList<>();
        ViewIgmSubDetailMainModel resultModel=new ViewIgmSubDetailMainModel();
        List<IgmDetails>list=new ArrayList<>();
        String mainQuery="";

        List<ViewIgmSubDetailModel> mainQueryList=new ArrayList<>();
        EntityManager entitymanager= entityManagerFactory.createEntityManager();
        if(queryStatus==0){



            mainQuery="Select new com.datasoft.pcs.Model.DTO.ViewIgmSubDetailModel( igms.id,igms.igmId,igms.Import_Rotation_No, \n" +
                    "igms.Line_No, igms.BL_No,igms.Pack_Number, \n" +
                    "igms.Pack_Description,igms.Pack_Marks_Number,\n" +
                    "igms.Description_of_Goods,igms.Date_of_Entry_of_Goods, \n" +
                    "igms.weight,igms.weight_unit,igms.net_weight,igms.final_submit_date,\n" +
                    "igms.net_weight_unit, igms.Bill_of_Entry_No,igms.Bill_of_Entry_Date,\n" +
                    "igms.office_code,igms.No_of_Pack_Delivered, igms.No_of_Pack_Discharged,\n" +
                    "igms.Remarks,igms.AFR,igms.int_block,igms.R_No,igms.R_Date,\n" +
                    "igms.delivery_block_stat,igms.ConsigneeDesc,\n" +
                    "igms.NotifyDesc,igms.navy_comments,igms.Submitee_Org_Id,igms.mlocode,igms.igmType,\n" +
                    "igms.imco,igms.un,igms.extra_remarks,Navyresponse.response_details1,Navyresponse.response_details3,Navyresponse.response_details2,\n" +
                    "Navyresponse.hold_application,Navyresponse.rejected_application,Navyresponse.auto_no,\n" +
                    "Navyresponse.final_amendment , Navyresponse.appsubmitdate ,Navyresponse.navy_response_to_port,Navyresponse.permission_no,igms.Submission_Date)\n" +
                    "FROM  IgmDetails igms \n" +
                    "LEFT OUTER JOIN IgmNavyResponse  Navyresponse \n" +
                    "ON Navyresponse.igm_details_id =igms.id WHERE igms.igmId='"+code+"' AND (igms.igmType='"+type+"') \n" +
                    "AND igms.finalSubmit=1";
            // list=igmDetailsRepository.findByIgmIdAndIgmTypeAndFinalSubmit(code,type,1);
        }
        else{
           // list =igmDetailsRepository.findByIgmIdAndIgmTypeOrIgmTypeAndFinalSubmit(code,type,"GM",1);
            mainQuery="Select new com.datasoft.pcs.Model.DTO.ViewIgmSubDetailModel( igms.id,igms.igmId,igms.Import_Rotation_No, \n" +
                    "igms.Line_No, igms.BL_No,igms.Pack_Number, \n" +
                    "igms.Pack_Description,igms.Pack_Marks_Number,\n" +
                    "igms.Description_of_Goods,igms.Date_of_Entry_of_Goods, \n" +
                    "igms.weight,igms.weight_unit,igms.net_weight,igms.final_submit_date,\n" +
                    "igms.net_weight_unit, igms.Bill_of_Entry_No,igms.Bill_of_Entry_Date,\n" +
                    "igms.office_code,igms.No_of_Pack_Delivered, igms.No_of_Pack_Discharged,\n" +
                    "igms.Remarks,igms.AFR,igms.int_block,igms.R_No,igms.R_Date,\n" +
                    "igms.delivery_block_stat,igms.ConsigneeDesc,\n" +
                    "igms.NotifyDesc,igms.navy_comments,igms.Submitee_Org_Id,igms.mlocode,igms.igmType,\n" +
                    "igms.imco,igms.un,igms.extra_remarks,Navyresponse.response_details1,Navyresponse.response_details3,Navyresponse.response_details2,\n" +
                    "Navyresponse.hold_application,Navyresponse.rejected_application,Navyresponse.auto_no,\n" +
                    "Navyresponse.final_amendment , Navyresponse.appsubmitdate ,Navyresponse.navy_response_to_port,Navyresponse.permission_no,igms.Submission_Date)\n" +
                    "FROM  IgmDetails igms \n" +
                    "LEFT OUTER JOIN IgmNavyResponse  Navyresponse \n" +
                    "ON Navyresponse.igm_details_id =igms.id WHERE igms.igmId='"+code+"' AND (igms.igmType='"+type+"') \n" +
                    "AND igms.finalSubmit=1 and (igms.PFstatus=1 or igms.PFstatus=10)";
        }
        mainQueryList =entitymanager.createQuery(mainQuery).getResultList();


        Integer resultSize=mainQueryList.size();
        List<ViewIgmSubDetailModel> mainQueryListLast=new ArrayList<>();

        for(int i=start;i<(start+limit) && (i<resultSize);i++){
            Long submitee_Org_Id=0L;
            String organizationName="";
            String ainNo="";
            List<OrganizationProfile> organizationNameList= new ArrayList<>();
            List<OrganizationProfile> organizationAinNoList= new ArrayList<>();

            String organizationNameQuery="";
            String organizationAinNoQuery="";
            ViewIgmSubDetailModel viewIgmSubDetailModel=mainQueryList.get(i);
            submitee_Org_Id=viewIgmSubDetailModel.getSubmitee_Org_Id();
            organizationNameQuery="select orgs from OrganizationProfile orgs where \n" +
                    "orgs.id="+submitee_Org_Id;

            organizationAinNoQuery="select orgs from OrganizationProfile orgs where \n" +
                    "orgs.id="+submitee_Org_Id;
            System.out.println(organizationAinNoQuery);
            organizationNameList= entitymanager.createQuery(organizationNameQuery).getResultList();
            organizationAinNoList= entitymanager.createQuery(organizationAinNoQuery).getResultList();
            System.out.println(organizationNameList.get(0).getOrganizationName());
            System.out.println(organizationNameList.get(0).getAinNo());
            if(organizationNameList.size()>0){
                organizationName=organizationNameList.get(0).getOrganizationName();
            }

            if(organizationAinNoList.size()>0){
                ainNo=organizationAinNoList.get(0).getAinNo();

            }

            viewIgmSubDetailModel.setOrganization_Name(organizationName);
            viewIgmSubDetailModel.setAIN_No(ainNo);




            mainQueryListLast.add(viewIgmSubDetailModel);
        }

        for(int i=0;i<mainQueryListLast.size();i++){
            Long id=0L;
            ViewIgmSubDetailModel queryResultMainModel=mainQueryListLast.get(i);
            id=queryResultMainModel.getId();
            String result1Query="";
            String result2Query="";
            String result3Query="";
            String result4Query="";
            List<ViewIGMSubDetailResultModel> resultList1=new ArrayList<>();
            List<ViewIGMSubDetailResultModel> resultList2=new ArrayList<>();
            List<ViewIGMSubDetailResultModel> resultList3=new ArrayList<>();
            List<ViewIGMSubDetailResultModel> resultList4=new ArrayList<>();
             result1Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(cnt.id,cnt.contNumber ,cnt.contSize ,cnt.contType ,\n" +
                    " cnt.cont_iso_type,cnt.contHeight,cnt.contStatus,\n" +
                    " cnt.contGrossWeight,cnt.contWeight,cnt.contSealNumber,\n" +
                    "cnt.contDescription,cnt.contImo,cnt.contUn,\n" +
                    "ogr.organizationName) from IgmDetailContainer cnt \n" +
                    "left join OrganizationProfile ogr on cnt.offDockId=ogr.id\n" +
                     "where cnt.igmDetailId='"+id+"'";
            resultList1=entitymanager.createQuery(result1Query).getResultList();
            if(resultList1.size()>0){
                queryResultMainModel.setResultListFirst(resultList1);
            }


            result2Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel( cons.id,cons.igm_detail_id,cons.Consignee_ID," +
                    "cons.ff_clearance,2) from  IgmDetailConsigneetabs cons where cons.igm_detail_id='"+id+"'";
            resultList2=entitymanager.createQuery(result2Query).getResultList();
            List<ViewIGMSubDetailResultModel> mainResultList2=new ArrayList<>();
            for(int j=0;j<resultList2.size();j++){
                Integer consigneeID=0;
                String orgName="";
                String address1="";
                ViewIGMSubDetailResultModel result2Model=resultList2.get(j);
                consigneeID= result2Model.getConsignee_ID();
                String result2Sub1Query="";
                String result2Sub2Query="";
                List<ViewIGMSubDetailResultModel> result2Sub1QueryList=new ArrayList<>();
                List<ViewIGMSubDetailResultModel> result2Sub2QueryList=new ArrayList<>();
                result2Sub1Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel( org.organizationName,'orgName') from OrganizationProfile org where org.id="+consigneeID;
                result2Sub2Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel( org1.addressOne,'address1') from OrganizationProfile org1 where org1.id="+consigneeID;
                result2Sub1QueryList=entitymanager.createQuery(result2Sub1Query).getResultList();
                result2Sub2QueryList=entitymanager.createQuery(result2Sub2Query).getResultList();
                if(result2Sub1QueryList.size()>0){
                    orgName=result2Sub1QueryList.get(0).getOrganization_Name();
                }
                if(result2Sub2QueryList.size()>0){
                    address1=result2Sub2QueryList.get(0).getAddress_1();
                }
                result2Model.setOrganization_Name(orgName);
                result2Model.setAddress_1(address1);
                mainResultList2.add(result2Model);

            }
            List<ViewIGMSubDetailResultModel> resultListMain2=new ArrayList<>();
            for(int s=0;s<mainResultList2.size();s++){
                ViewIGMSubDetailResultModel result2MainModel=resultList2.get(s);
                String pfsStatusQuery="";
                Integer psf=0;
                List<ViewIGMSubDetailResultModel> pfsStatusQueryList=new ArrayList<>();
                pfsStatusQuery="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel (igm.PFstatus) from IgmDetails igm where id='"+id+"'";
                pfsStatusQueryList=entitymanager.createQuery(pfsStatusQuery).getResultList();
                if(pfsStatusQueryList.size()>0){
                    psf=pfsStatusQueryList.get(0).getPFs();

                }
                result2MainModel.setPFs(psf);
                resultListMain2.add(result2MainModel);

            }
            queryResultMainModel.setResultListSecond(resultListMain2);

            result3Query="SELECT new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(notf.id,notf.igm_detail_id,notf.Notify_ID,\n" +
                    "notf.ff_clearance,3)FROM IgmDetailNotifyTabs notf WHERE notf.igm_detail_id='"+id+"'";
            resultList3=entitymanager.createQuery(result3Query).getResultList();

            List<ViewIGMSubDetailResultModel> mainResultList3=new ArrayList<>();
            for(int j=0;j<resultList3.size();j++){
                Integer Notify_ID=0;
                String result3OrgName="";
                String result3Address1="";
                ViewIGMSubDetailResultModel result3Model=resultList3.get(j);
                Notify_ID=result3Model.getNotify_ID();
                String result3Sub1Query="";
                String result3Sub2Query="";
                List<ViewIGMSubDetailResultModel> result3Sub1QueryList=new ArrayList<>();
                List<ViewIGMSubDetailResultModel> result3Sub2QueryList=new ArrayList<>();
                result3Sub1Query="SELECT  new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(org.organizationName,'orgName') FROM OrganizationProfile org WHERE org.id="+Notify_ID;
                result3Sub2Query="SELECT  new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel (org1.addressOne,'address1') FROM OrganizationProfile org1 WHERE org1.id="+Notify_ID;
                result3Sub1QueryList=entitymanager.createQuery(result3Sub1Query).getResultList();
                result3Sub2QueryList=entitymanager.createQuery(result3Sub2Query).getResultList();
                if(result3Sub1QueryList.size()>0){
                    result3OrgName=  result3Sub1QueryList.get(0).getOrganization_Name();
                }
                if(result3Sub2QueryList.size()>0){
                    result3Address1=result3Sub2QueryList.get(0).getAddress_1();
                }
                result3Model.setOrganization_Name(result3OrgName);
                result3Model.setAddress_1(result3Address1);
                mainResultList3.add(result3Model);
            }
            queryResultMainModel.setResultListThird(mainResultList3);
            result4Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel (cnf.id,cnf.igm_detail_id,cnf.CnF_ID_to_be_AccountedFor) \n" +
                    " from IgmDetailCnfTabs cnf \n" +
                    "where cnf.igm_detail_id='"+id+"'";
            resultList4=entitymanager.createQuery(result4Query).getResultList();
            List<ViewIGMSubDetailResultModel> mainResultList4=new ArrayList<>();
            for(int j=0;j<resultList4.size();j++){
                String cnf_name="";
                String orgName="";
                String Address_1="";
                String AIN_No="";
                Integer CnF_ID_to_be_AccountedFor=0;
                ViewIGMSubDetailResultModel result4Model=resultList4.get(j);
                CnF_ID_to_be_AccountedFor=result4Model.getCnF_ID_to_be_AccountedFor();
                String result4Sub1Query="";
                String result4Sub2Query="";
                String result4Sub3Query="";

                List<ViewIGMSubDetailResultModel> result4Sub1QueryList=new ArrayList<>();
                List<ViewIGMSubDetailResultModel> result4Sub2QueryList=new ArrayList<>();
                List<ViewIGMSubDetailResultModel> result4Sub3QueryList=new ArrayList<>();

                result4Sub1Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(org.organizationName,'orgName') from OrganizationProfile where org.id="+CnF_ID_to_be_AccountedFor;
                result4Sub2Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(org1.addressOne,'address1')  from OrganizationProfile org1 where org1.id="+CnF_ID_to_be_AccountedFor;
                result4Sub3Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(org.ainNo,'ain') from OrganizationProfile org where org.id="+CnF_ID_to_be_AccountedFor;
                result4Sub1QueryList=entitymanager.createQuery(result4Sub1Query).getResultList();
                result4Sub2QueryList=entitymanager.createQuery(result4Sub2Query).getResultList();
                result4Sub3QueryList=entitymanager.createQuery(result4Sub3Query).getResultList();
                if(result4Sub1QueryList.size()>0){
                   cnf_name= result4Sub1QueryList.get(0).getCnf_name();

                }
                if(result4Sub2QueryList.size()>0){
                    Address_1=result4Sub2QueryList.get(0).getAddress_1();

                }
                if(result4Sub3QueryList.size()>0){
                    AIN_No=result4Sub3QueryList.get(0).getAIN_No();
                }
                result4Model.setCnf_name(cnf_name);
                result4Model.setAddress_1(Address_1);
                result4Model.setAIN_No(AIN_No);
                mainResultList4.add(result4Model);

            }
            queryResultMainModel.setResultListFour(mainResultList4);



            resultList.add(queryResultMainModel);
        }

        Integer actualSize=0;
        if((resultSize%5)==0){
            actualSize=resultSize/5;
        }
        else {
            actualSize=(resultSize/5)+1;
        }
        Integer a=0;
        Integer b=5;
        Integer c=5;
        System.out.println("page "+actualSize);
        List<ViewIgmSubDetailMainModel> pageList=new ArrayList<>();
        for(int k=1; k<=actualSize; k++){
            ViewIgmSubDetailMainModel paginationModel=new ViewIgmSubDetailMainModel();
            paginationModel.setPageStratLimit(a);
            paginationModel.setPageEndLimit(c);
            paginationModel.setSl(k);
            if(b<=(start+15) && start<=resultSize){
                paginationModel.setState(1);
            }
            else{
                paginationModel.setState(0);
            }

            a=b;
            b=b+5;
            pageList.add(paginationModel);
        }

        resultModel.setResultList(resultList);
        resultModel.setPagination(pageList);
        mainResultList.add(resultModel);




        return mainResultList;
    }

    public List viewIgmDeatailSearch(Long code,Integer role,Integer orgTpeId, String type){
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        List<ViewIgmSubDetailSearchModel> resultList=new ArrayList<>();
        String rotation="";
        Optional<IgmMasters> igmMasters= igmMastersRepository.findDistinctById(code);
        rotation=igmMasters.get().getImportRotationNo();
        ViewIgmSubDetailSearchModel resultModel=new ViewIgmSubDetailSearchModel();
        resultModel.setImport_Rotation_No(rotation);
        if(role==21 || role==19 ||role==17){
            List<OrganizationProfile> organizationProfileList1=organizationProfilesRepository.findByOrganizationTypeIdOrderByOrganizationName(4L);
            resultModel.setResult1(organizationProfileList1);
       }
        if(role==15 || role==19 ||role==17){
            List<OrganizationProfile> organizationProfileList2=organizationProfilesRepository.findByOrganizationTypeIdOrderByOrganizationName(2L);
            resultModel.setResult2(organizationProfileList2);
        }
       if(role==23 || role==19 ||role==17){
            List<OrganizationProfile> organizationProfileList3=organizationProfilesRepository.findByIdOrOrganizationTypeIdOrderByOrganizationName(2591L,6L);
            resultModel.setResult3(organizationProfileList3);
        }

       if(role==25 || role==19 ||role==17){
            List<OrganizationProfile> organizationProfileList4=organizationProfilesRepository.findByOrganizationTypeIdOrderByOrganizationName(6L);
            resultModel.setResult4(organizationProfileList4);
        }
        if( role==19 ||role==17){
            List<OrganizationProfile> organizationProfileList5=organizationProfilesRepository.findByOrganizationTypeIdOrderByOrganizationName(11L);
            resultModel.setResult5(organizationProfileList5);
        }

        List<ViewIgmSubDetailSearchModel> resultList6=new ArrayList<>();
        String resultList6Query="SELECT DISTINCT new com.datasoft.pcs.Model.DTO.ViewIgmSubDetailSearchModel( igm.Submitee_Org_Id ) "+
                //"(SELECT Organization_Name FROM organization_profiles orgs WHERE orgs.id=igm_details.Submitee_Org_Id) AS Organization_Name \n" +
                "FROM  IgmDetails igm WHERE igm.igmId='"+code+"' AND SUBSTRING(igm.submitteId,-1)='F'  AND igm.igmType='"+type+"'";
        resultList6=entityManager.createQuery(resultList6Query).getResultList();

        List<ViewIgmSubDetailSearchModel> resultMainList6=new ArrayList<>();
        for(int i=0;i<resultList6.size();i++){
            List<ViewIgmSubDetailSearchModel> resultSubList6=new ArrayList<>();
            ViewIgmSubDetailSearchModel viewIgmSubDetailSearchModel=new ViewIgmSubDetailSearchModel();
            Long igmDetailId=0L;
            igmDetailId=resultList6.get(i).getId();

          String result6SubQuery="SELECT new com.datasoft.pcs.Model.DTO.ViewIgmSubDetailSearchModel(orgs.id,orgs.organizationName) FROM OrganizationProfile orgs WHERE orgs.id='"+igmDetailId+"' order by orgs.organizationName ";
            resultSubList6=entityManager.createQuery(result6SubQuery).getResultList();
            viewIgmSubDetailSearchModel=resultSubList6.get(i);
            resultMainList6.add(viewIgmSubDetailSearchModel);
        }

        resultModel.setResult6(resultMainList6);


        List<ViewIgmSubDetailSearchModel> resultList7=new ArrayList<>();
        String resultList7Query="SELECT DISTINCT new com.datasoft.pcs.Model.DTO.ViewIgmSubDetailSearchModel( igm.Submitee_Org_Id ) "+
                "FROM  IgmDetails igm WHERE igm.igmId='"+code+"' AND SUBSTRING(igm.submitteId,-1)='m'  AND igm.igmType='"+type+"'";
        resultList7=entityManager.createQuery(resultList7Query).getResultList();

        List<ViewIgmSubDetailSearchModel> resultMainList7=new ArrayList<>();
        for(int i=0;i<resultList7.size();i++){
            List<ViewIgmSubDetailSearchModel> resultSubList7=new ArrayList<>();
            ViewIgmSubDetailSearchModel viewIgmSubDetailSearchModel=new ViewIgmSubDetailSearchModel();
            Long igmDetailId=0L;
            igmDetailId=resultList7.get(i).getId();

            String result7SubQuery="SELECT new com.datasoft.pcs.Model.DTO.ViewIgmSubDetailSearchModel(orgs.id,orgs.organizationName) FROM OrganizationProfile orgs WHERE orgs.id='"+igmDetailId+"' order by orgs.organizationName ";
            resultSubList7=entityManager.createQuery(result7SubQuery).getResultList();
            viewIgmSubDetailSearchModel=resultSubList7.get(i);
            resultMainList7.add(viewIgmSubDetailSearchModel);
        }

        resultModel.setResult7(resultMainList7);

        List<IgmDetails> igmDetailsList8= igmDetailsRepository.findDistinctByIgmId(code);
       // List<IgmDetails> igmDetailsList8= igmDetailsRepository.findDistinctMlocodeByIgmId(code);
        resultModel.setResult8(igmDetailsList8);
        resultList.add(resultModel);
        return resultList;

    }


    public List searchIgmSubmittedBySAF(String type, Integer status, Long code,Integer queryStatus,Long orgTypeId ){
        List<ViewIgmSubDetailMainModel> mainResultList =new ArrayList<>();
        List<ViewIgmSubDetailModel> resultList =new ArrayList<>();
        ViewIgmSubDetailMainModel resultModel=new ViewIgmSubDetailMainModel();
        List<IgmDetails>list=new ArrayList<>();
        String mainQuery="";

        List<ViewIgmSubDetailModel> mainQueryList=new ArrayList<>();
        EntityManager entitymanager= entityManagerFactory.createEntityManager();
        if(queryStatus==0){


            mainQuery="Select new com.datasoft.pcs.Model.DTO.ViewIgmSubDetailModel( igms.id,igms.igmId,igms.Import_Rotation_No, \n" +
                    "igms.Line_No, igms.BL_No,igms.Pack_Number, \n" +
                    "igms.Pack_Description,igms.Pack_Marks_Number,\n" +
                    "igms.Description_of_Goods,igms.Date_of_Entry_of_Goods, \n" +
                    "igms.weight,igms.weight_unit,igms.net_weight,igms.final_submit_date,\n" +
                    "igms.net_weight_unit, igms.Bill_of_Entry_No,igms.Bill_of_Entry_Date,\n" +
                    "igms.office_code,igms.No_of_Pack_Delivered, igms.No_of_Pack_Discharged,\n" +
                    "igms.Remarks,igms.AFR,igms.int_block,igms.R_No,igms.R_Date,\n" +
                    "igms.delivery_block_stat,igms.ConsigneeDesc,\n" +
                    "igms.NotifyDesc,igms.navy_comments,igms.Submitee_Org_Id,igms.mlocode,igms.igmType,\n" +
                    "igms.imco,igms.un,igms.extra_remarks" +
                    " WHERE igms.igmId='"+code+"' AND (igms.igmType='"+type+"') \n" +
                    "AND igms.finalSubmit=1 AND igms.Submitee_Org_Id='"+orgTypeId+"'";

        }
        else{

            mainQuery="Select new com.datasoft.pcs.Model.DTO.ViewIgmSubDetailModel( igms.id,igms.igmId,igms.Import_Rotation_No, \n" +
                    "  igms.Line_No, igms.BL_No,igms.Pack_Number,\n" +
                    "  igms.Pack_Description,igms.Pack_Marks_Number,\n" +
                    "  igms.Description_of_Goods,igms.Date_of_Entry_of_Goods, \n" +
                    "  igms.weight,igms.weight_unit,igms.net_weight,igms.final_submit_date,\n" +
                    "  igms.net_weight_unit, igms.Bill_of_Entry_No,igms.Bill_of_Entry_Date,\n" +
                    "  igms.office_code,igms.No_of_Pack_Delivered, igms.No_of_Pack_Discharged,\n" +
                    "  igms.Remarks,igms.AFR,igms.int_block,igms.R_No,igms.R_Date\n" +
                    "  igms.delivery_block_stat,igms.ConsigneeDesc,\n" +
                    "  igms.NotifyDesc,igms.navy_comments,igms.Submitee_Org_Id,igms.mlocode,igms.igmType, +\n" +
                    "  igms.imco,igms.un,igms.extra_remarks\" +\n" +
                    "   WHERE igms.igmId='"+code+"' AND (igms.igmType='"+type+"') \n" +
                    "   AND igms.finalSubmit=1 AND (igms.PFstatus=1 or igms.PFstatus=10) AND igms.Submitee_Org_Id='"+orgTypeId+"'" ;
        }
        mainQueryList =entitymanager.createQuery(mainQuery).getResultList();


        Integer resultSize=mainQueryList.size();
        List<ViewIgmSubDetailModel> mainQueryListLast=new ArrayList<>();

        for(int i=0;i<mainQueryList.size();i++){
            Long submitee_Org_Id=0L;
            String organizationName="";
            String ainNo="";
            List<OrganizationProfile> organizationNameList= new ArrayList<>();
            List<OrganizationProfile> organizationAinNoList= new ArrayList<>();

            String organizationNameQuery="";
            String organizationAinNoQuery="";
            ViewIgmSubDetailModel viewIgmSubDetailModel=mainQueryList.get(i);
            submitee_Org_Id=viewIgmSubDetailModel.getSubmitee_Org_Id();
            organizationNameQuery="select orgs from OrganizationProfile orgs where \n" +
                    "orgs.id="+submitee_Org_Id;

            organizationAinNoQuery="select orgs from OrganizationProfile orgs where \n" +
                    "orgs.id="+submitee_Org_Id;

            organizationNameList= entitymanager.createQuery(organizationNameQuery).getResultList();
            organizationAinNoList= entitymanager.createQuery(organizationAinNoQuery).getResultList();
            if(organizationNameList.size()>0){
                organizationName=organizationNameList.get(0).getOrganizationName();
            }

            if(organizationAinNoList.size()>0){
                ainNo=organizationAinNoList.get(0).getAinNo();

            }

            viewIgmSubDetailModel.setOrganization_Name(organizationName);
            viewIgmSubDetailModel.setAIN_No(ainNo);




            mainQueryListLast.add(viewIgmSubDetailModel);
        }

        for(int i=0;i<mainQueryListLast.size();i++){
            Long id=0L;
            ViewIgmSubDetailModel queryResultMainModel=mainQueryListLast.get(i);
            id=queryResultMainModel.getId();
            String result1Query="";
            String result2Query="";
            String result3Query="";
            String result4Query="";
            List<ViewIGMSubDetailResultModel> resultList1=new ArrayList<>();
            List<ViewIGMSubDetailResultModel> resultList2=new ArrayList<>();
            List<ViewIGMSubDetailResultModel> resultList3=new ArrayList<>();
            List<ViewIGMSubDetailResultModel> resultList4=new ArrayList<>();

            result1Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(cnt.id,cnt.contNumber ,cnt.contSize ,cnt.contType ,\n" +
                    " cnt.cont_iso_type,cnt.contHeight,cnt.contStatus,\n" +
                    " cnt.contGrossWeight,cnt.contWeight,cnt.contSealNumber,\n" +
                    "cnt.contDescription,cnt.contImo,cnt.contUn,\n" +
                    "ogr.organizationName) from IgmDetailContainer cnt \n" +
                    "left join OrganizationProfile ogr on cnt.offDockId=ogr.id\n" +
                    "where cnt.igmDetailId='"+id+"'";
            resultList1=entitymanager.createQuery(result1Query).getResultList();
            if(resultList1.size()>0){
                queryResultMainModel.setResultListFirst(resultList1);
            }


            result2Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel( cons.id,cons.igm_detail_id,cons.Consignee_ID," +
                    "cons.ff_clearance,2) from  IgmDetailConsigneetabs cons where cons.igm_detail_id='"+id+"'";
            resultList2=entitymanager.createQuery(result2Query).getResultList();
            List<ViewIGMSubDetailResultModel> mainResultList2=new ArrayList<>();
            for(int j=0;j<resultList2.size();j++){
                Integer consigneeID=0;
                String orgName="";
                String address1="";
                ViewIGMSubDetailResultModel result2Model=resultList2.get(j);
                consigneeID= result2Model.getConsignee_ID();
                String result2Sub1Query="";
                String result2Sub2Query="";
                List<ViewIGMSubDetailResultModel> result2Sub1QueryList=new ArrayList<>();
                List<ViewIGMSubDetailResultModel> result2Sub2QueryList=new ArrayList<>();
                result2Sub1Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel( org.organizationName,'orgName') from OrganizationProfile org where org.id="+consigneeID;
                result2Sub2Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel( org1.addressOne,'address1') from OrganizationProfile org1 where org1.id="+consigneeID;
                result2Sub1QueryList=entitymanager.createQuery(result2Sub1Query).getResultList();
                result2Sub2QueryList=entitymanager.createQuery(result2Sub2Query).getResultList();
                if(result2Sub1QueryList.size()>0){
                    orgName=result2Sub1QueryList.get(0).getOrganization_Name();
                }
                if(result2Sub2QueryList.size()>0){
                    address1=result2Sub2QueryList.get(0).getAddress_1();
                }
                result2Model.setOrganization_Name(orgName);
                result2Model.setAddress_1(address1);
                mainResultList2.add(result2Model);

            }
            List<ViewIGMSubDetailResultModel> resultListMain2=new ArrayList<>();
            for(int s=0;s<mainResultList2.size();s++){
                ViewIGMSubDetailResultModel result2MainModel=resultList2.get(s);
                String pfsStatusQuery="";
                Integer psf=0;
                List<ViewIGMSubDetailResultModel> pfsStatusQueryList=new ArrayList<>();
                pfsStatusQuery="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel (igm.PFstatus) from IgmDetails igm where id='"+id+"'";
                pfsStatusQueryList=entitymanager.createQuery(pfsStatusQuery).getResultList();
                if(pfsStatusQueryList.size()>0){
                    psf=pfsStatusQueryList.get(0).getPFs();

                }
                result2MainModel.setPFs(psf);
                resultListMain2.add(result2MainModel);

            }
            queryResultMainModel.setResultListSecond(resultListMain2);

            result3Query="SELECT new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(notf.id,notf.igm_detail_id,notf.Notify_ID,\n" +
                    "notf.ff_clearance,3)FROM IgmDetailNotifyTabs notf WHERE notf.igm_detail_id='"+id+"'";
            resultList3=entitymanager.createQuery(result3Query).getResultList();

            List<ViewIGMSubDetailResultModel> mainResultList3=new ArrayList<>();
            for(int j=0;j<resultList3.size();j++){
                Integer Notify_ID=0;
                String result3OrgName="";
                String result3Address1="";
                ViewIGMSubDetailResultModel result3Model=resultList3.get(j);
                Notify_ID=result3Model.getNotify_ID();
                String result3Sub1Query="";
                String result3Sub2Query="";
                List<ViewIGMSubDetailResultModel> result3Sub1QueryList=new ArrayList<>();
                List<ViewIGMSubDetailResultModel> result3Sub2QueryList=new ArrayList<>();
                result3Sub1Query="SELECT  new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(org.organizationName,'orgName') FROM OrganizationProfile org WHERE org.id="+Notify_ID;
                result3Sub2Query="SELECT  new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel (org1.addressOne,'address1') FROM OrganizationProfile org1 WHERE org1.id="+Notify_ID;
                result3Sub1QueryList=entitymanager.createQuery(result3Sub1Query).getResultList();
                result3Sub2QueryList=entitymanager.createQuery(result3Sub2Query).getResultList();
                if(result3Sub1QueryList.size()>0){
                    result3OrgName=  result3Sub1QueryList.get(0).getOrganization_Name();
                }
                if(result3Sub2QueryList.size()>0){
                    result3Address1=result3Sub2QueryList.get(0).getAddress_1();
                }
                result3Model.setOrganization_Name(result3OrgName);
                result3Model.setAddress_1(result3Address1);
                mainResultList3.add(result3Model);
            }
            queryResultMainModel.setResultListThird(mainResultList3);
            result4Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel (cnf.id,cnf.igm_detail_id,cnf.CnF_ID_to_be_AccountedFor) \n" +
                    " from IgmDetailCnfTabs cnf \n" +
                    "where cnf.igm_detail_id='"+id+"'";
            resultList4=entitymanager.createQuery(result4Query).getResultList();
            List<ViewIGMSubDetailResultModel> mainResultList4=new ArrayList<>();
            for(int j=0;j<resultList4.size();j++){
                String cnf_name="";
                String orgName="";
                String Address_1="";
                String AIN_No="";
                Integer CnF_ID_to_be_AccountedFor=0;
                ViewIGMSubDetailResultModel result4Model=resultList4.get(j);
                CnF_ID_to_be_AccountedFor=result4Model.getCnF_ID_to_be_AccountedFor();
                String result4Sub1Query="";
                String result4Sub2Query="";
                String result4Sub3Query="";

                List<ViewIGMSubDetailResultModel> result4Sub1QueryList=new ArrayList<>();
                List<ViewIGMSubDetailResultModel> result4Sub2QueryList=new ArrayList<>();
                List<ViewIGMSubDetailResultModel> result4Sub3QueryList=new ArrayList<>();

                result4Sub1Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(org.organizationName,'orgName') from OrganizationProfile where org.id="+CnF_ID_to_be_AccountedFor;
                result4Sub2Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(org1.addressOne,'address1')  from OrganizationProfile org1 where org1.id="+CnF_ID_to_be_AccountedFor;
                result4Sub3Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(org.ainNo,'ain') from OrganizationProfile org where org.id="+CnF_ID_to_be_AccountedFor;
                result4Sub1QueryList=entitymanager.createQuery(result4Sub1Query).getResultList();
                result4Sub2QueryList=entitymanager.createQuery(result4Sub2Query).getResultList();
                result4Sub3QueryList=entitymanager.createQuery(result4Sub3Query).getResultList();
                if(result4Sub1QueryList.size()>0){
                    cnf_name= result4Sub1QueryList.get(0).getCnf_name();

                }
                if(result4Sub2QueryList.size()>0){
                    Address_1=result4Sub2QueryList.get(0).getAddress_1();

                }
                if(result4Sub3QueryList.size()>0){
                    AIN_No=result4Sub3QueryList.get(0).getAIN_No();
                }
                result4Model.setCnf_name(cnf_name);
                result4Model.setAddress_1(Address_1);
                result4Model.setAIN_No(AIN_No);
                mainResultList4.add(result4Model);

            }
            queryResultMainModel.setResultListFour(mainResultList4);



            resultList.add(queryResultMainModel);
        }



        resultModel.setResultList(resultList);
        // resultModel.setPagination(pageList);
        mainResultList.add(resultModel);




        return mainResultList;
    }


    public List searchIgmSubmittedByMlo(String type, Integer status, Long code , Integer queryStatus,Long orgTypeId ){
        List<ViewIgmSubDetailMainModel> mainResultList =new ArrayList<>();
        List<ViewIgmSubDetailModel> resultList =new ArrayList<>();
        ViewIgmSubDetailMainModel resultModel=new ViewIgmSubDetailMainModel();
        List<IgmDetails>list=new ArrayList<>();
        String mainQuery="";

        List<ViewIgmSubDetailModel> mainQueryList=new ArrayList<>();
        EntityManager entitymanager= entityManagerFactory.createEntityManager();
        if(queryStatus==0){

            mainQuery="Select new com.datasoft.pcs.Model.DTO.ViewIgmSubDetailModel( igms.id,igms.igmId,igms.Import_Rotation_No, \n" +
                    "igms.Line_No, igms.BL_No,igms.Pack_Number, \n" +
                    "igms.Pack_Description,igms.Pack_Marks_Number,\n" +
                    "igms.Description_of_Goods,igms.Date_of_Entry_of_Goods, \n" +
                    "igms.weight,igms.weight_unit,igms.net_weight,igms.final_submit_date,\n" +
                    "igms.net_weight_unit, igms.Bill_of_Entry_No,igms.Bill_of_Entry_Date,\n" +
                    "igms.office_code,igms.No_of_Pack_Delivered, igms.No_of_Pack_Discharged,\n" +
                    "igms.Remarks,igms.AFR,igms.int_block,igms.R_No,igms.R_Date,\n" +
                    "igms.delivery_block_stat,igms.ConsigneeDesc,\n" +
                    "igms.NotifyDesc,igms.navy_comments,igms.Submitee_Org_Id,igms.mlocode,igms.igmType,\n" +
                    "igms.imco,igms.un,igms.extra_remarks,Navyresponse.response_details1,Navyresponse.response_details3,Navyresponse.response_details2,\n" +
                    "Navyresponse.hold_application,Navyresponse.rejected_application,Navyresponse.auto_no,\n" +
                    "Navyresponse.final_amendment , Navyresponse.appsubmitdate ,Navyresponse.navy_response_to_port,Navyresponse.permission_no,igms.Submission_Date)\n" +
                    "FROM  IgmDetails igms \n" +
                    "LEFT OUTER JOIN IgmNavyResponse  Navyresponse \n" +
                    "ON Navyresponse.igm_details_id =igms.id WHERE igms.igmId='"+code+"' AND (igms.igmType='"+type+"') \n" +
                    "AND igms.finalSubmit=1 AND igms.Submitee_Org_Id='"+orgTypeId+"'";
            // list=igmDetailsRepository.findByIgmIdAndIgmTypeAndFinalSubmit(code,type,1);
        }
        else{
            // list =igmDetailsRepository.findByIgmIdAndIgmTypeOrIgmTypeAndFinalSubmit(code,type,"GM",1);
            mainQuery="Select new com.datasoft.pcs.Model.DTO.ViewIgmSubDetailModel( igms.id,igms.igmId,igms.Import_Rotation_No, \n" +
                    "igms.Line_No, igms.BL_No,igms.Pack_Number, \n" +
                    "igms.Pack_Description,igms.Pack_Marks_Number,\n" +
                    "igms.Description_of_Goods,igms.Date_of_Entry_of_Goods, \n" +
                    "igms.weight,igms.weight_unit,igms.net_weight,igms.final_submit_date,\n" +
                    "igms.net_weight_unit, igms.Bill_of_Entry_No,igms.Bill_of_Entry_Date,\n" +
                    "igms.office_code,igms.No_of_Pack_Delivered, igms.No_of_Pack_Discharged,\n" +
                    "igms.Remarks,igms.AFR,igms.int_block,igms.R_No,igms.R_Date,\n" +
                    "igms.delivery_block_stat,igms.ConsigneeDesc,\n" +
                    "igms.NotifyDesc,igms.navy_comments,igms.Submitee_Org_Id,igms.mlocode,igms.igmType,\n" +
                    "igms.imco,igms.un,igms.extra_remarks,Navyresponse.response_details1,Navyresponse.response_details3,Navyresponse.response_details2,\n" +
                    "Navyresponse.hold_application,Navyresponse.rejected_application,Navyresponse.auto_no,\n" +
                    "Navyresponse.final_amendment , Navyresponse.appsubmitdate ,Navyresponse.navy_response_to_port,Navyresponse.permission_no,igms.Submission_Date)\n" +
                    "FROM  IgmDetails igms \n" +
                    "LEFT OUTER JOIN IgmNavyResponse  Navyresponse \n" +
                    "ON Navyresponse.igm_details_id =igms.id WHERE igms.igmId='"+code+"' AND (igms.igmType='"+type+"' or igms.igmType='GM') \n" +
                    "AND igms.finalSubmit=1 and (igms.PFstatus=1 or igms.PFstatus=10) AND igms.Submitee_Org_Id='"+orgTypeId+"'" ;
        }
        mainQueryList =entitymanager.createQuery(mainQuery).getResultList();


        Integer resultSize=mainQueryList.size();
        List<ViewIgmSubDetailModel> mainQueryListLast=new ArrayList<>();

        for(int i=0;i<mainQueryList.size();i++){
            Long submitee_Org_Id=0L;
            String organizationName="";
            String ainNo="";
            List<OrganizationProfile> organizationNameList= new ArrayList<>();
            List<OrganizationProfile> organizationAinNoList= new ArrayList<>();

            String organizationNameQuery="";
            String organizationAinNoQuery="";
            ViewIgmSubDetailModel viewIgmSubDetailModel=mainQueryList.get(i);
            submitee_Org_Id=viewIgmSubDetailModel.getSubmitee_Org_Id();
            organizationNameQuery="select orgs from OrganizationProfile orgs where \n" +
                    "orgs.id="+submitee_Org_Id;

            organizationAinNoQuery="select orgs from OrganizationProfile orgs where \n" +
                    "orgs.id="+submitee_Org_Id;

            organizationNameList= entitymanager.createQuery(organizationNameQuery).getResultList();
            organizationAinNoList= entitymanager.createQuery(organizationAinNoQuery).getResultList();
            if(organizationNameList.size()>0){
                organizationName=organizationNameList.get(0).getOrganizationName();
            }

            if(organizationAinNoList.size()>0){
                ainNo=organizationAinNoList.get(0).getAinNo();

            }

            viewIgmSubDetailModel.setOrganization_Name(organizationName);
            viewIgmSubDetailModel.setAIN_No(ainNo);




            mainQueryListLast.add(viewIgmSubDetailModel);
        }

        for(int i=0;i<mainQueryListLast.size();i++){
            Long id=0L;
            ViewIgmSubDetailModel queryResultMainModel=mainQueryListLast.get(i);
            id=queryResultMainModel.getId();
            String result1Query="";
            String result2Query="";
            String result3Query="";
            String result4Query="";
            List<ViewIGMSubDetailResultModel> resultList1=new ArrayList<>();
            List<ViewIGMSubDetailResultModel> resultList2=new ArrayList<>();
            List<ViewIGMSubDetailResultModel> resultList3=new ArrayList<>();
            List<ViewIGMSubDetailResultModel> resultList4=new ArrayList<>();
            result1Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(cnt.id,cnt.contNumber ,cnt.contSize ,cnt.contType ,\n" +
                    " cnt.cont_iso_type,cnt.contHeight,cnt.contStatus,\n" +
                    " cnt.contGrossWeight,cnt.contWeight,cnt.contSealNumber,\n" +
                    "cnt.contDescription,cnt.contImo,cnt.contUn,\n" +
                    "ogr.organizationName) from IgmDetailContainer cnt \n" +
                    "left join OrganizationProfile ogr on cnt.offDockId=ogr.id\n" +
                    "where cnt.igmDetailId='"+id+"'";
            resultList1=entitymanager.createQuery(result1Query).getResultList();
            if(resultList1.size()>0){
                queryResultMainModel.setResultListFirst(resultList1);
            }


            result2Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel( cons.id,cons.igm_detail_id,cons.Consignee_ID," +
                    "cons.ff_clearance,2) from  IgmDetailConsigneetabs cons where cons.igm_detail_id='"+id+"'";
            resultList2=entitymanager.createQuery(result2Query).getResultList();
            List<ViewIGMSubDetailResultModel> mainResultList2=new ArrayList<>();
            for(int j=0;j<resultList2.size();j++){
                Integer consigneeID=0;
                String orgName="";
                String address1="";
                ViewIGMSubDetailResultModel result2Model=resultList2.get(j);
                consigneeID= result2Model.getConsignee_ID();
                String result2Sub1Query="";
                String result2Sub2Query="";
                List<ViewIGMSubDetailResultModel> result2Sub1QueryList=new ArrayList<>();
                List<ViewIGMSubDetailResultModel> result2Sub2QueryList=new ArrayList<>();
                result2Sub1Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel( org.organizationName,'orgName') from OrganizationProfile org where org.id="+consigneeID;
                result2Sub2Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel( org1.addressOne,'address1') from OrganizationProfile org1 where org1.id="+consigneeID;
                result2Sub1QueryList=entitymanager.createQuery(result2Sub1Query).getResultList();
                result2Sub2QueryList=entitymanager.createQuery(result2Sub2Query).getResultList();
                if(result2Sub1QueryList.size()>0){
                    orgName=result2Sub1QueryList.get(0).getOrganization_Name();
                }
                if(result2Sub2QueryList.size()>0){
                    address1=result2Sub2QueryList.get(0).getAddress_1();
                }
                result2Model.setOrganization_Name(orgName);
                result2Model.setAddress_1(address1);
                mainResultList2.add(result2Model);

            }
            List<ViewIGMSubDetailResultModel> resultListMain2=new ArrayList<>();
            for(int s=0;s<mainResultList2.size();s++){
                ViewIGMSubDetailResultModel result2MainModel=resultList2.get(s);
                String pfsStatusQuery="";
                Integer psf=0;
                List<ViewIGMSubDetailResultModel> pfsStatusQueryList=new ArrayList<>();
                pfsStatusQuery="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel (igm.PFstatus) from IgmDetails igm where id='"+id+"'";
                pfsStatusQueryList=entitymanager.createQuery(pfsStatusQuery).getResultList();
                if(pfsStatusQueryList.size()>0){
                    psf=pfsStatusQueryList.get(0).getPFs();

                }
                result2MainModel.setPFs(psf);
                resultListMain2.add(result2MainModel);

            }
            queryResultMainModel.setResultListSecond(resultListMain2);

            result3Query="SELECT new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(notf.id,notf.igm_detail_id,notf.Notify_ID,\n" +
                    "notf.ff_clearance,3)FROM IgmDetailNotifyTabs notf WHERE notf.igm_detail_id='"+id+"'";
            resultList3=entitymanager.createQuery(result3Query).getResultList();

            List<ViewIGMSubDetailResultModel> mainResultList3=new ArrayList<>();
            for(int j=0;j<resultList3.size();j++){
                Integer Notify_ID=0;
                String result3OrgName="";
                String result3Address1="";
                ViewIGMSubDetailResultModel result3Model=resultList3.get(j);
                Notify_ID=result3Model.getNotify_ID();
                String result3Sub1Query="";
                String result3Sub2Query="";
                List<ViewIGMSubDetailResultModel> result3Sub1QueryList=new ArrayList<>();
                List<ViewIGMSubDetailResultModel> result3Sub2QueryList=new ArrayList<>();
                result3Sub1Query="SELECT  new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(org.organizationName,'orgName') FROM OrganizationProfile org WHERE org.id="+Notify_ID;
                result3Sub2Query="SELECT  new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel (org1.addressOne,'address1') FROM OrganizationProfile org1 WHERE org1.id="+Notify_ID;
                result3Sub1QueryList=entitymanager.createQuery(result3Sub1Query).getResultList();
                result3Sub2QueryList=entitymanager.createQuery(result3Sub2Query).getResultList();
                if(result3Sub1QueryList.size()>0){
                    result3OrgName=  result3Sub1QueryList.get(0).getOrganization_Name();
                }
                if(result3Sub2QueryList.size()>0){
                    result3Address1=result3Sub2QueryList.get(0).getAddress_1();
                }
                result3Model.setOrganization_Name(result3OrgName);
                result3Model.setAddress_1(result3Address1);
                mainResultList3.add(result3Model);
            }
            queryResultMainModel.setResultListThird(mainResultList3);
            result4Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel (cnf.id,cnf.igm_detail_id,cnf.CnF_ID_to_be_AccountedFor) \n" +
                    " from IgmDetailCnfTabs cnf \n" +
                    "where cnf.igm_detail_id='"+id+"'";
            resultList4=entitymanager.createQuery(result4Query).getResultList();
            List<ViewIGMSubDetailResultModel> mainResultList4=new ArrayList<>();
            for(int j=0;j<resultList4.size();j++){
                String cnf_name="";
                String orgName="";
                String Address_1="";
                String AIN_No="";
                Integer CnF_ID_to_be_AccountedFor=0;
                ViewIGMSubDetailResultModel result4Model=resultList4.get(j);
                CnF_ID_to_be_AccountedFor=result4Model.getCnF_ID_to_be_AccountedFor();
                String result4Sub1Query="";
                String result4Sub2Query="";
                String result4Sub3Query="";

                List<ViewIGMSubDetailResultModel> result4Sub1QueryList=new ArrayList<>();
                List<ViewIGMSubDetailResultModel> result4Sub2QueryList=new ArrayList<>();
                List<ViewIGMSubDetailResultModel> result4Sub3QueryList=new ArrayList<>();

                result4Sub1Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(org.organizationName,'orgName') from OrganizationProfile where org.id="+CnF_ID_to_be_AccountedFor;
                result4Sub2Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(org1.addressOne,'address1')  from OrganizationProfile org1 where org1.id="+CnF_ID_to_be_AccountedFor;
                result4Sub3Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(org.ainNo,'ain') from OrganizationProfile org where org.id="+CnF_ID_to_be_AccountedFor;
                result4Sub1QueryList=entitymanager.createQuery(result4Sub1Query).getResultList();
                result4Sub2QueryList=entitymanager.createQuery(result4Sub2Query).getResultList();
                result4Sub3QueryList=entitymanager.createQuery(result4Sub3Query).getResultList();
                if(result4Sub1QueryList.size()>0){
                    cnf_name= result4Sub1QueryList.get(0).getCnf_name();

                }
                if(result4Sub2QueryList.size()>0){
                    Address_1=result4Sub2QueryList.get(0).getAddress_1();

                }
                if(result4Sub3QueryList.size()>0){
                    AIN_No=result4Sub3QueryList.get(0).getAIN_No();
                }
                result4Model.setCnf_name(cnf_name);
                result4Model.setAddress_1(Address_1);
                result4Model.setAIN_No(AIN_No);
                mainResultList4.add(result4Model);

            }
            queryResultMainModel.setResultListFour(mainResultList4);



            resultList.add(queryResultMainModel);
        }

      

        resultModel.setResultList(resultList);
       // resultModel.setPagination(pageList);
        mainResultList.add(resultModel);




        return mainResultList;
    }

    public List searchByMloCode(String type, Integer status, Long code,Integer queryStatus,String orgTypeId ){
        List<ViewIgmSubDetailMainModel> mainResultList =new ArrayList<>();
        List<ViewIgmSubDetailModel> resultList =new ArrayList<>();
        ViewIgmSubDetailMainModel resultModel=new ViewIgmSubDetailMainModel();
        List<IgmDetails>list=new ArrayList<>();
        String mainQuery="";

        List<ViewIgmSubDetailModel> mainQueryList=new ArrayList<>();
        EntityManager entitymanager= entityManagerFactory.createEntityManager();
        if(queryStatus==0){


            mainQuery="Select new com.datasoft.pcs.Model.DTO.ViewIgmSubDetailModel( igms.id,igms.igmId,igms.Import_Rotation_No, \n" +
                    "igms.Line_No, igms.BL_No,igms.Pack_Number, \n" +
                    "igms.Pack_Description,igms.Pack_Marks_Number,\n" +
                    "igms.Description_of_Goods,igms.Date_of_Entry_of_Goods, \n" +
                    "igms.weight,igms.weight_unit,igms.net_weight,igms.final_submit_date,\n" +
                    "igms.net_weight_unit, igms.Bill_of_Entry_No,igms.Bill_of_Entry_Date,\n" +
                    "igms.office_code,igms.No_of_Pack_Delivered, igms.No_of_Pack_Discharged,\n" +
                    "igms.Remarks,igms.AFR,igms.int_block,igms.R_No,igms.R_Date,\n" +
                    "igms.delivery_block_stat,igms.ConsigneeDesc,\n" +
                    "igms.NotifyDesc,igms.navy_comments,igms.Submitee_Org_Id,igms.mlocode,igms.igmType,\n" +
                    "igms.imco,igms.un,igms.extra_remarks)" +
                    "FROM  IgmDetails igms \n" +
                    " WHERE igms.igmId='"+code+"' AND (igms.igmType='"+type+"') \n" +
                    "AND igms.finalSubmit=1 AND igms.mlocode='"+orgTypeId+"'";

        }
        else{

            mainQuery="Select new com.datasoft.pcs.Model.DTO.ViewIgmSubDetailModel( igms.id,igms.igmId,igms.Import_Rotation_No, \n" +
                    "  igms.Line_No, igms.BL_No,igms.Pack_Number,\n" +
                    "  igms.Pack_Description,igms.Pack_Marks_Number,\n" +
                    "  igms.Description_of_Goods,igms.Date_of_Entry_of_Goods, \n" +
                    "  igms.weight,igms.weight_unit,igms.net_weight,igms.final_submit_date,\n" +
                    "  igms.net_weight_unit, igms.Bill_of_Entry_No,igms.Bill_of_Entry_Date,\n" +
                    "  igms.office_code,igms.No_of_Pack_Delivered, igms.No_of_Pack_Discharged,\n" +
                    "  igms.Remarks,igms.AFR,igms.int_block,igms.R_No,igms.R_Date,\n" +
                    "  igms.delivery_block_stat,igms.ConsigneeDesc,\n" +
                    "  igms.NotifyDesc,igms.navy_comments,igms.Submitee_Org_Id,igms.mlocode,igms.igmType, \n" +
                    "  igms.imco,igms.un,igms.extra_remarks) \n" +
                    "  FROM  IgmDetails igms \n" +
                    "   WHERE igms.igmId='"+code+"' AND (igms.igmType='"+type+"') \n" +
                    "   AND igms.finalSubmit=1 AND (igms.PFstatus=1 or igms.PFstatus=10) AND igms.mlocode='"+orgTypeId+"'" ;
        }
        mainQueryList =entitymanager.createQuery(mainQuery).getResultList();


        Integer resultSize=mainQueryList.size();
        List<ViewIgmSubDetailModel> mainQueryListLast=new ArrayList<>();

        for(int i=0;i<mainQueryList.size();i++){
            Long submitee_Org_Id=0L;
            String organizationName="";
            String ainNo="";
            List<OrganizationProfile> organizationNameList= new ArrayList<>();
            List<OrganizationProfile> organizationAinNoList= new ArrayList<>();

            String organizationNameQuery="";
            String organizationAinNoQuery="";
            ViewIgmSubDetailModel viewIgmSubDetailModel=mainQueryList.get(i);
            submitee_Org_Id=viewIgmSubDetailModel.getSubmitee_Org_Id();
            organizationNameQuery="select orgs from OrganizationProfile orgs where \n" +
                    "orgs.id="+submitee_Org_Id;

            organizationAinNoQuery="select orgs from OrganizationProfile orgs where \n" +
                    "orgs.id="+submitee_Org_Id;

            organizationNameList= entitymanager.createQuery(organizationNameQuery).getResultList();
            organizationAinNoList= entitymanager.createQuery(organizationAinNoQuery).getResultList();
            if(organizationNameList.size()>0){
                organizationName=organizationNameList.get(0).getOrganizationName();
            }

            if(organizationAinNoList.size()>0){
                ainNo=organizationAinNoList.get(0).getAinNo();

            }

            viewIgmSubDetailModel.setOrganization_Name(organizationName);
            viewIgmSubDetailModel.setAIN_No(ainNo);




            mainQueryListLast.add(viewIgmSubDetailModel);
        }

        for(int i=0;i<mainQueryListLast.size();i++){
            Long id=0L;
            ViewIgmSubDetailModel queryResultMainModel=mainQueryListLast.get(i);
            id=queryResultMainModel.getId();
            String result1Query="";
            String result2Query="";
            String result3Query="";
            String result4Query="";
            List<ViewIGMSubDetailResultModel> resultList1=new ArrayList<>();
            List<ViewIGMSubDetailResultModel> resultList2=new ArrayList<>();
            List<ViewIGMSubDetailResultModel> resultList3=new ArrayList<>();
            List<ViewIGMSubDetailResultModel> resultList4=new ArrayList<>();

            result1Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(cnt.id,cnt.contNumber ,cnt.contSize ,cnt.contType ,\n" +
                    " cnt.cont_iso_type,cnt.contHeight,cnt.contStatus,\n" +
                    " cnt.contGrossWeight,cnt.contWeight,cnt.contSealNumber,\n" +
                    "cnt.contDescription,cnt.contImo,cnt.contUn,\n" +
                    "ogr.organizationName) from IgmDetailContainer cnt \n" +
                    "left join OrganizationProfile ogr on cnt.offDockId=ogr.id\n" +
                    "where cnt.igmDetailId='"+id+"'";
            resultList1=entitymanager.createQuery(result1Query).getResultList();
            if(resultList1.size()>0){
                queryResultMainModel.setResultListFirst(resultList1);
            }


            result2Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel( cons.id,cons.igm_detail_id,cons.Consignee_ID," +
                    "cons.ff_clearance,2) from  IgmDetailConsigneetabs cons where cons.igm_detail_id='"+id+"'";
            resultList2=entitymanager.createQuery(result2Query).getResultList();
            List<ViewIGMSubDetailResultModel> mainResultList2=new ArrayList<>();
            for(int j=0;j<resultList2.size();j++){
                Integer consigneeID=0;
                String orgName="";
                String address1="";
                ViewIGMSubDetailResultModel result2Model=resultList2.get(j);
                consigneeID= result2Model.getConsignee_ID();
                String result2Sub1Query="";
                String result2Sub2Query="";
                List<ViewIGMSubDetailResultModel> result2Sub1QueryList=new ArrayList<>();
                List<ViewIGMSubDetailResultModel> result2Sub2QueryList=new ArrayList<>();
                result2Sub1Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel( org.organizationName,'orgName') from OrganizationProfile org where org.id="+consigneeID;
                result2Sub2Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel( org1.addressOne,'address1') from OrganizationProfile org1 where org1.id="+consigneeID;
                result2Sub1QueryList=entitymanager.createQuery(result2Sub1Query).getResultList();
                result2Sub2QueryList=entitymanager.createQuery(result2Sub2Query).getResultList();
                if(result2Sub1QueryList.size()>0){
                    orgName=result2Sub1QueryList.get(0).getOrganization_Name();
                }
                if(result2Sub2QueryList.size()>0){
                    address1=result2Sub2QueryList.get(0).getAddress_1();
                }
                result2Model.setOrganization_Name(orgName);
                result2Model.setAddress_1(address1);
                mainResultList2.add(result2Model);

            }
            List<ViewIGMSubDetailResultModel> resultListMain2=new ArrayList<>();
            for(int s=0;s<mainResultList2.size();s++){
                ViewIGMSubDetailResultModel result2MainModel=resultList2.get(s);
                String pfsStatusQuery="";
                Integer psf=0;
                List<ViewIGMSubDetailResultModel> pfsStatusQueryList=new ArrayList<>();
                pfsStatusQuery="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel (igm.PFstatus) from IgmDetails igm where id='"+id+"'";
                pfsStatusQueryList=entitymanager.createQuery(pfsStatusQuery).getResultList();
                if(pfsStatusQueryList.size()>0){
                    psf=pfsStatusQueryList.get(0).getPFs();

                }
                result2MainModel.setPFs(psf);
                resultListMain2.add(result2MainModel);

            }
            queryResultMainModel.setResultListSecond(resultListMain2);

            result3Query="SELECT new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(notf.id,notf.igm_detail_id,notf.Notify_ID,\n" +
                    "notf.ff_clearance,3)FROM IgmDetailNotifyTabs notf WHERE notf.igm_detail_id='"+id+"'";
            resultList3=entitymanager.createQuery(result3Query).getResultList();

            List<ViewIGMSubDetailResultModel> mainResultList3=new ArrayList<>();
            for(int j=0;j<resultList3.size();j++){
                Integer Notify_ID=0;
                String result3OrgName="";
                String result3Address1="";
                ViewIGMSubDetailResultModel result3Model=resultList3.get(j);
                Notify_ID=result3Model.getNotify_ID();
                String result3Sub1Query="";
                String result3Sub2Query="";
                List<ViewIGMSubDetailResultModel> result3Sub1QueryList=new ArrayList<>();
                List<ViewIGMSubDetailResultModel> result3Sub2QueryList=new ArrayList<>();
                result3Sub1Query="SELECT  new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(org.organizationName,'orgName') FROM OrganizationProfile org WHERE org.id="+Notify_ID;
                result3Sub2Query="SELECT  new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel (org1.addressOne,'address1') FROM OrganizationProfile org1 WHERE org1.id="+Notify_ID;
                result3Sub1QueryList=entitymanager.createQuery(result3Sub1Query).getResultList();
                result3Sub2QueryList=entitymanager.createQuery(result3Sub2Query).getResultList();
                if(result3Sub1QueryList.size()>0){
                    result3OrgName=  result3Sub1QueryList.get(0).getOrganization_Name();
                }
                if(result3Sub2QueryList.size()>0){
                    result3Address1=result3Sub2QueryList.get(0).getAddress_1();
                }
                result3Model.setOrganization_Name(result3OrgName);
                result3Model.setAddress_1(result3Address1);
                mainResultList3.add(result3Model);
            }
            queryResultMainModel.setResultListThird(mainResultList3);
            result4Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel (cnf.id,cnf.igm_detail_id,cnf.CnF_ID_to_be_AccountedFor) \n" +
                    " from IgmDetailCnfTabs cnf \n" +
                    "where cnf.igm_detail_id='"+id+"'";
            resultList4=entitymanager.createQuery(result4Query).getResultList();
            List<ViewIGMSubDetailResultModel> mainResultList4=new ArrayList<>();
            for(int j=0;j<resultList4.size();j++){
                String cnf_name="";
                String orgName="";
                String Address_1="";
                String AIN_No="";
                Integer CnF_ID_to_be_AccountedFor=0;
                ViewIGMSubDetailResultModel result4Model=resultList4.get(j);
                CnF_ID_to_be_AccountedFor=result4Model.getCnF_ID_to_be_AccountedFor();
                String result4Sub1Query="";
                String result4Sub2Query="";
                String result4Sub3Query="";

                List<ViewIGMSubDetailResultModel> result4Sub1QueryList=new ArrayList<>();
                List<ViewIGMSubDetailResultModel> result4Sub2QueryList=new ArrayList<>();
                List<ViewIGMSubDetailResultModel> result4Sub3QueryList=new ArrayList<>();

                result4Sub1Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(org.organizationName,'orgName') from OrganizationProfile where org.id="+CnF_ID_to_be_AccountedFor;
                result4Sub2Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(org1.addressOne,'address1')  from OrganizationProfile org1 where org1.id="+CnF_ID_to_be_AccountedFor;
                result4Sub3Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(org.ainNo,'ain') from OrganizationProfile org where org.id="+CnF_ID_to_be_AccountedFor;
                result4Sub1QueryList=entitymanager.createQuery(result4Sub1Query).getResultList();
                result4Sub2QueryList=entitymanager.createQuery(result4Sub2Query).getResultList();
                result4Sub3QueryList=entitymanager.createQuery(result4Sub3Query).getResultList();
                if(result4Sub1QueryList.size()>0){
                    cnf_name= result4Sub1QueryList.get(0).getCnf_name();

                }
                if(result4Sub2QueryList.size()>0){
                    Address_1=result4Sub2QueryList.get(0).getAddress_1();

                }
                if(result4Sub3QueryList.size()>0){
                    AIN_No=result4Sub3QueryList.get(0).getAIN_No();
                }
                result4Model.setCnf_name(cnf_name);
                result4Model.setAddress_1(Address_1);
                result4Model.setAIN_No(AIN_No);
                mainResultList4.add(result4Model);

            }
            queryResultMainModel.setResultListFour(mainResultList4);



            resultList.add(queryResultMainModel);
        }



        resultModel.setResultList(resultList);
        // resultModel.setPagination(pageList);
        mainResultList.add(resultModel);




        return mainResultList;
    }

    public List searchByBlNumberLineNumberContainerNumber(String type, Integer status, Long code,Integer queryStatus,
                                                          Integer role,Integer searchType,String searchValue){
        List<ViewIgmSubDetailMainModel> mainResultList =new ArrayList<>();
        List<ViewIgmSubDetailModel> resultList =new ArrayList<>();
        ViewIgmSubDetailMainModel resultModel=new ViewIgmSubDetailMainModel();
        List<IgmDetails>list=new ArrayList<>();
        String mainQuery="";

        List<ViewIgmSubDetailModel> mainQueryList=new ArrayList<>();
        EntityManager entitymanager= entityManagerFactory.createEntityManager();
        if(searchType==1){
            if(role==19 || role==23 || role==21){
                mainQuery="Select new com.datasoft.pcs.Model.DTO.ViewIgmSubDetailModel( igms.id,igms.igmId,igms.Import_Rotation_No, \n" +
                        "igms.Line_No, igms.BL_No,igms.Pack_Number, \n" +
                        "igms.Pack_Description,igms.Pack_Marks_Number,\n" +
                        "igms.Description_of_Goods,igms.Date_of_Entry_of_Goods, \n" +
                        "igms.weight,igms.weight_unit,igms.net_weight,igms.final_submit_date,\n" +
                        "igms.net_weight_unit, igms.Bill_of_Entry_No,igms.Bill_of_Entry_Date,\n" +
                        "igms.office_code,igms.No_of_Pack_Delivered, igms.No_of_Pack_Discharged,\n" +
                        "igms.Remarks,igms.AFR,igms.int_block,igms.R_No,igms.R_Date,\n" +
                        "igms.delivery_block_stat,igms.ConsigneeDesc,\n" +
                        "igms.NotifyDesc,igms.navy_comments,igms.Submitee_Org_Id,igms.mlocode,igms.igmType,\n" +
                        "igms.imco,igms.un,igms.extra_remarks,Navyresponse.response_details1,Navyresponse.response_details3,Navyresponse.response_details2,\n" +
                        "Navyresponse.hold_application,Navyresponse.rejected_application,Navyresponse.auto_no,\n" +
                        "Navyresponse.final_amendment , Navyresponse.appsubmitdate ,Navyresponse.navy_response_to_port,Navyresponse.permission_no,igms.Submission_Date)\n" +
                        "FROM  IgmDetails igms \n" +
                        "LEFT OUTER JOIN IgmNavyResponse  Navyresponse \n" +
                        "ON Navyresponse.igm_details_id =igms.id WHERE igms.igmId='"+code+"' AND (igms.igmType='"+type+"') \n" +
                        "AND igms.finalSubmit=1 AND igms.BL_No LIKE '%"+searchValue+"'";

            }
            else{
                mainQuery="Select new com.datasoft.pcs.Model.DTO.ViewIgmSubDetailModel( igms.id,igms.igmId,igms.Import_Rotation_No, \n" +
                        "igms.Line_No, igms.BL_No,igms.Pack_Number, \n" +
                        "igms.Pack_Description,igms.Pack_Marks_Number,\n" +
                        "igms.Description_of_Goods,igms.Date_of_Entry_of_Goods, \n" +
                        "igms.weight,igms.weight_unit,igms.net_weight,igms.final_submit_date,\n" +
                        "igms.net_weight_unit, igms.Bill_of_Entry_No,igms.Bill_of_Entry_Date,\n" +
                        "igms.office_code,igms.No_of_Pack_Delivered, igms.No_of_Pack_Discharged,\n" +
                        "igms.Remarks,igms.AFR,igms.int_block,igms.R_No,igms.R_Date,\n" +
                        "igms.delivery_block_stat,igms.ConsigneeDesc,\n" +
                        "igms.NotifyDesc,igms.navy_comments,igms.Submitee_Org_Id,igms.mlocode,igms.igmType,\n" +
                        "igms.imco,igms.un,igms.extra_remarks,Navyresponse.response_details1,Navyresponse.response_details3,Navyresponse.response_details2,\n" +
                        "Navyresponse.hold_application,Navyresponse.rejected_application,Navyresponse.auto_no,\n" +
                        "Navyresponse.final_amendment , Navyresponse.appsubmitdate ,Navyresponse.navy_response_to_port,Navyresponse.permission_no,igms.Submission_Date)\n" +
                        "FROM  IgmDetails igms \n" +
                        "LEFT OUTER JOIN IgmNavyResponse  Navyresponse \n" +
                        "ON Navyresponse.igm_details_id =igms.id WHERE igms.igmId='"+code+"' AND igms.igmType='"+type+"' \n" +
                        "AND igms.finalSubmit=1 and (igms.PFstatus=1 or igms.PFstatus=10) AND igms.BL_No LIKE '%"+searchValue+"'" ;


            }


        }
        else if(searchType==2){
            if(role==19 || role==23 || role==21){
                mainQuery="Select new com.datasoft.pcs.Model.DTO.ViewIgmSubDetailModel( igms.id,igms.igmId,igms.Import_Rotation_No, \n" +
                        "igms.Line_No, igms.BL_No,igms.Pack_Number, \n" +
                        "igms.Pack_Description,igms.Pack_Marks_Number,\n" +
                        "igms.Description_of_Goods,igms.Date_of_Entry_of_Goods, \n" +
                        "igms.weight,igms.weight_unit,igms.net_weight,igms.final_submit_date,\n" +
                        "igms.net_weight_unit, igms.Bill_of_Entry_No,igms.Bill_of_Entry_Date,\n" +
                        "igms.office_code,igms.No_of_Pack_Delivered, igms.No_of_Pack_Discharged,\n" +
                        "igms.Remarks,igms.AFR,igms.int_block,igms.R_No,igms.R_Date,\n" +
                        "igms.delivery_block_stat,igms.ConsigneeDesc,\n" +
                        "igms.NotifyDesc,igms.navy_comments,igms.Submitee_Org_Id,igms.mlocode,igms.igmType,\n" +
                        "igms.imco,igms.un,igms.extra_remarks,Navyresponse.response_details1,Navyresponse.response_details3,Navyresponse.response_details2,\n" +
                        "Navyresponse.hold_application,Navyresponse.rejected_application,Navyresponse.auto_no,\n" +
                        "Navyresponse.final_amendment , Navyresponse.appsubmitdate ,Navyresponse.navy_response_to_port,Navyresponse.permission_no,igms.Submission_Date)\n" +
                        "FROM  IgmDetails igms \n" +
                        "LEFT OUTER JOIN IgmNavyResponse  Navyresponse \n" +
                        "ON Navyresponse.igm_details_id =igms.id WHERE igms.igmId='"+code+"' AND (igms.igmType='"+type+"') \n" +
                        "AND igms.finalSubmit=1 AND igms.Line_No LIKE '%"+Integer.valueOf(searchValue)+"'";

            }
            else{
                mainQuery="Select new com.datasoft.pcs.Model.DTO.ViewIgmSubDetailModel( igms.id,igms.igmId,igms.Import_Rotation_No, \n" +
                        "igms.Line_No, igms.BL_No,igms.Pack_Number, \n" +
                        "igms.Pack_Description,igms.Pack_Marks_Number,\n" +
                        "igms.Description_of_Goods,igms.Date_of_Entry_of_Goods, \n" +
                        "igms.weight,igms.weight_unit,igms.net_weight,igms.final_submit_date,\n" +
                        "igms.net_weight_unit, igms.Bill_of_Entry_No,igms.Bill_of_Entry_Date,\n" +
                        "igms.office_code,igms.No_of_Pack_Delivered, igms.No_of_Pack_Discharged,\n" +
                        "igms.Remarks,igms.AFR,igms.int_block,igms.R_No,igms.R_Date,\n" +
                        "igms.delivery_block_stat,igms.ConsigneeDesc,\n" +
                        "igms.NotifyDesc,igms.navy_comments,igms.Submitee_Org_Id,igms.mlocode,igms.igmType,\n" +
                        "igms.imco,igms.un,igms.extra_remarks,Navyresponse.response_details1,Navyresponse.response_details3,Navyresponse.response_details2,\n" +
                        "Navyresponse.hold_application,Navyresponse.rejected_application,Navyresponse.auto_no,\n" +
                        "Navyresponse.final_amendment , Navyresponse.appsubmitdate ,Navyresponse.navy_response_to_port,Navyresponse.permission_no,igms.Submission_Date)\n" +
                        "FROM  IgmDetails igms \n" +
                        "LEFT OUTER JOIN IgmNavyResponse  Navyresponse \n" +
                        "ON Navyresponse.igm_details_id =igms.id WHERE igms.igmId='"+code+"' AND igms.igmType='"+type+"' \n" +
                        "AND igms.finalSubmit=1 and (igms.PFstatus=1 or igms.PFstatus=10) AND igms.Line_No LIKE '%"+Integer.valueOf(searchValue)+"'" ;

            }

        }
        else if(searchType==3){
            if(role==19 || role==23 || role==21){
                mainQuery="Select new com.datasoft.pcs.Model.DTO.ViewIgmSubDetailModel( igms.id,igms.igmId,igms.Import_Rotation_No, \n" +
                        "igms.Line_No, igms.BL_No,igms.Pack_Number, \n" +
                        "igms.Pack_Description,igms.Pack_Marks_Number,\n" +
                        "igms.Description_of_Goods,igms.Date_of_Entry_of_Goods, \n" +
                        "igms.weight,igms.weight_unit,igms.net_weight,igms.final_submit_date,\n" +
                        "igms.net_weight_unit, igms.Bill_of_Entry_No,igms.Bill_of_Entry_Date,\n" +
                        "igms.office_code,igms.No_of_Pack_Delivered, igms.No_of_Pack_Discharged,\n" +
                        "igms.Remarks,igms.AFR,igms.int_block,igms.R_No,igms.R_Date,\n" +
                        "igms.delivery_block_stat,igms.ConsigneeDesc,\n" +
                        "igms.NotifyDesc,igms.navy_comments,igms.Submitee_Org_Id,igms.mlocode,igms.igmType,\n" +
                        "igms.imco,igms.un,igms.extra_remarks)" +
                        "FROM  IgmDetails igms \n" +
                        "INNER JOIN IgmDetailContainer igmDetailCotainer on igms.id=igmDetailCotainer.igmDetailId \n"+
                        " WHERE igms.igmId='"+code+"' AND (igms.igmType='"+type+"') \n" +
                        "AND igms.finalSubmit=1 AND igmDetailCotainer.contNumber LIKE '%"+searchValue+"%'";

            }
            else{
                mainQuery="Select new com.datasoft.pcs.Model.DTO.ViewIgmSubDetailModel( igms.id,igms.igmId,igms.Import_Rotation_No, \n" +
                        "  igms.Line_No, igms.BL_No,igms.Pack_Number,\n" +
                        "  igms.Pack_Description,igms.Pack_Marks_Number,\n" +
                        "  igms.Description_of_Goods,igms.Date_of_Entry_of_Goods, \n" +
                        "  igms.weight,igms.weight_unit,igms.net_weight,igms.final_submit_date,\n" +
                        "  igms.net_weight_unit, igms.Bill_of_Entry_No,igms.Bill_of_Entry_Date,\n" +
                        "  igms.office_code,igms.No_of_Pack_Delivered, igms.No_of_Pack_Discharged,\n" +
                        "  igms.Remarks,igms.AFR,igms.int_block,igms.R_No,igms.R_Date,\n" +
                        "  igms.delivery_block_stat,igms.ConsigneeDesc,\n" +
                        "  igms.NotifyDesc,igms.navy_comments,igms.Submitee_Org_Id,igms.mlocode,igms.igmType, \n" +
                        "  igms.imco,igms.un,igms.extra_remarks) \n" +
                        "  FROM  IgmDetails igms \n" +
                        "INNER JOIN IgmDetailContainer igmDetailCotainer on igms.id=igmDetailCotainer.igmDetailId \n"+
                        "   WHERE igms.igmId='"+code+"' AND (igms.igmType='"+type+"') \n" +
                        "   AND igms.finalSubmit=1 AND (igms.PFstatus=1 or igms.PFstatus=10) AND igmDetailCotainer.contNumber LIKE '%"+searchValue+"%'" ;


            }

        }

        mainQueryList =entitymanager.createQuery(mainQuery).getResultList();


        Integer resultSize=mainQueryList.size();
        List<ViewIgmSubDetailModel> mainQueryListLast=new ArrayList<>();

        for(int i=0;i<mainQueryList.size();i++){
            Long submitee_Org_Id=0L;
            String organizationName="";
            String ainNo="";
            List<OrganizationProfile> organizationNameList= new ArrayList<>();
            List<OrganizationProfile> organizationAinNoList= new ArrayList<>();

            String organizationNameQuery="";
            String organizationAinNoQuery="";
            ViewIgmSubDetailModel viewIgmSubDetailModel=mainQueryList.get(i);
            submitee_Org_Id=viewIgmSubDetailModel.getSubmitee_Org_Id();
            organizationNameQuery="select orgs from OrganizationProfile orgs where \n" +
                    "orgs.id="+submitee_Org_Id;

            organizationAinNoQuery="select orgs from OrganizationProfile orgs where \n" +
                    "orgs.id="+submitee_Org_Id;

            organizationNameList= entitymanager.createQuery(organizationNameQuery).getResultList();
            organizationAinNoList= entitymanager.createQuery(organizationAinNoQuery).getResultList();
            if(organizationNameList.size()>0){
                organizationName=organizationNameList.get(0).getOrganizationName();
            }

            if(organizationAinNoList.size()>0){
                ainNo=organizationAinNoList.get(0).getAinNo();

            }

            viewIgmSubDetailModel.setOrganization_Name(organizationName);
            viewIgmSubDetailModel.setAIN_No(ainNo);




            mainQueryListLast.add(viewIgmSubDetailModel);
        }

        for(int i=0;i<mainQueryListLast.size();i++){
            Long id=0L;
            ViewIgmSubDetailModel queryResultMainModel=mainQueryListLast.get(i);
            id=queryResultMainModel.getId();
            String result1Query="";
            String result2Query="";
            String result3Query="";
            String result4Query="";
            List<ViewIGMSubDetailResultModel> resultList1=new ArrayList<>();
            List<ViewIGMSubDetailResultModel> resultList2=new ArrayList<>();
            List<ViewIGMSubDetailResultModel> resultList3=new ArrayList<>();
            List<ViewIGMSubDetailResultModel> resultList4=new ArrayList<>();
            result1Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(cnt.id,cnt.contNumber ,cnt.contSize ,cnt.contType ,\n" +
                    " cnt.cont_iso_type,cnt.contHeight,cnt.contStatus,\n" +
                    " cnt.contGrossWeight,cnt.contWeight,cnt.contSealNumber,\n" +
                    "cnt.contDescription,cnt.contImo,cnt.contUn,\n" +
                    "ogr.organizationName) from IgmDetailContainer cnt \n" +
                    "left join OrganizationProfile ogr on cnt.offDockId=ogr.id\n" +
                    "where cnt.igmDetailId='"+id+"'";
            resultList1=entitymanager.createQuery(result1Query).getResultList();
            if(resultList1.size()>0){
                queryResultMainModel.setResultListFirst(resultList1);
            }


            result2Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel( cons.id,cons.igm_detail_id,cons.Consignee_ID," +
                    "cons.ff_clearance,2) from  IgmDetailConsigneetabs cons where cons.igm_detail_id='"+id+"'";
            resultList2=entitymanager.createQuery(result2Query).getResultList();
            List<ViewIGMSubDetailResultModel> mainResultList2=new ArrayList<>();
            for(int j=0;j<resultList2.size();j++){
                Integer consigneeID=0;
                String orgName="";
                String address1="";
                ViewIGMSubDetailResultModel result2Model=resultList2.get(j);
                consigneeID= result2Model.getConsignee_ID();
                String result2Sub1Query="";
                String result2Sub2Query="";
                List<ViewIGMSubDetailResultModel> result2Sub1QueryList=new ArrayList<>();
                List<ViewIGMSubDetailResultModel> result2Sub2QueryList=new ArrayList<>();
                result2Sub1Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel( org.organizationName,'orgName') from OrganizationProfile org where org.id="+consigneeID;
                result2Sub2Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel( org1.addressOne,'address1') from OrganizationProfile org1 where org1.id="+consigneeID;
                result2Sub1QueryList=entitymanager.createQuery(result2Sub1Query).getResultList();
                result2Sub2QueryList=entitymanager.createQuery(result2Sub2Query).getResultList();
                if(result2Sub1QueryList.size()>0){
                    orgName=result2Sub1QueryList.get(0).getOrganization_Name();
                }
                if(result2Sub2QueryList.size()>0){
                    address1=result2Sub2QueryList.get(0).getAddress_1();
                }
                result2Model.setOrganization_Name(orgName);
                result2Model.setAddress_1(address1);
                mainResultList2.add(result2Model);

            }
            List<ViewIGMSubDetailResultModel> resultListMain2=new ArrayList<>();
            for(int s=0;s<mainResultList2.size();s++){
                ViewIGMSubDetailResultModel result2MainModel=resultList2.get(s);
                String pfsStatusQuery="";
                Integer psf=0;
                List<ViewIGMSubDetailResultModel> pfsStatusQueryList=new ArrayList<>();
                pfsStatusQuery="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel (igm.PFstatus) from IgmDetails igm where id='"+id+"'";
                pfsStatusQueryList=entitymanager.createQuery(pfsStatusQuery).getResultList();
                if(pfsStatusQueryList.size()>0){
                    psf=pfsStatusQueryList.get(0).getPFs();

                }
                result2MainModel.setPFs(psf);
                resultListMain2.add(result2MainModel);

            }
            queryResultMainModel.setResultListSecond(resultListMain2);

            result3Query="SELECT new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(notf.id,notf.igm_detail_id,notf.Notify_ID,\n" +
                    "notf.ff_clearance,3)FROM IgmDetailNotifyTabs notf WHERE notf.igm_detail_id='"+id+"'";
            resultList3=entitymanager.createQuery(result3Query).getResultList();

            List<ViewIGMSubDetailResultModel> mainResultList3=new ArrayList<>();
            for(int j=0;j<resultList3.size();j++){
                Integer Notify_ID=0;
                String result3OrgName="";
                String result3Address1="";
                ViewIGMSubDetailResultModel result3Model=resultList3.get(j);
                Notify_ID=result3Model.getNotify_ID();
                String result3Sub1Query="";
                String result3Sub2Query="";
                List<ViewIGMSubDetailResultModel> result3Sub1QueryList=new ArrayList<>();
                List<ViewIGMSubDetailResultModel> result3Sub2QueryList=new ArrayList<>();
                result3Sub1Query="SELECT  new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(org.organizationName,'orgName') FROM OrganizationProfile org WHERE org.id="+Notify_ID;
                result3Sub2Query="SELECT  new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel (org1.addressOne,'address1') FROM OrganizationProfile org1 WHERE org1.id="+Notify_ID;
                result3Sub1QueryList=entitymanager.createQuery(result3Sub1Query).getResultList();
                result3Sub2QueryList=entitymanager.createQuery(result3Sub2Query).getResultList();
                if(result3Sub1QueryList.size()>0){
                    result3OrgName=  result3Sub1QueryList.get(0).getOrganization_Name();
                }
                if(result3Sub2QueryList.size()>0){
                    result3Address1=result3Sub2QueryList.get(0).getAddress_1();
                }
                result3Model.setOrganization_Name(result3OrgName);
                result3Model.setAddress_1(result3Address1);
                mainResultList3.add(result3Model);
            }
            queryResultMainModel.setResultListThird(mainResultList3);
            result4Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel (cnf.id,cnf.igm_detail_id,cnf.CnF_ID_to_be_AccountedFor) \n" +
                    " from IgmDetailCnfTabs cnf \n" +
                    "where cnf.igm_detail_id='"+id+"'";
            resultList4=entitymanager.createQuery(result4Query).getResultList();
            List<ViewIGMSubDetailResultModel> mainResultList4=new ArrayList<>();
            for(int j=0;j<resultList4.size();j++){
                String cnf_name="";
                String orgName="";
                String Address_1="";
                String AIN_No="";
                Integer CnF_ID_to_be_AccountedFor=0;
                ViewIGMSubDetailResultModel result4Model=resultList4.get(j);
                CnF_ID_to_be_AccountedFor=result4Model.getCnF_ID_to_be_AccountedFor();
                String result4Sub1Query="";
                String result4Sub2Query="";
                String result4Sub3Query="";

                List<ViewIGMSubDetailResultModel> result4Sub1QueryList=new ArrayList<>();
                List<ViewIGMSubDetailResultModel> result4Sub2QueryList=new ArrayList<>();
                List<ViewIGMSubDetailResultModel> result4Sub3QueryList=new ArrayList<>();

                result4Sub1Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(org.organizationName,'orgName') from OrganizationProfile where org.id="+CnF_ID_to_be_AccountedFor;
                result4Sub2Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(org1.addressOne,'address1')  from OrganizationProfile org1 where org1.id="+CnF_ID_to_be_AccountedFor;
                result4Sub3Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(org.ainNo,'ain') from OrganizationProfile org where org.id="+CnF_ID_to_be_AccountedFor;
                result4Sub1QueryList=entitymanager.createQuery(result4Sub1Query).getResultList();
                result4Sub2QueryList=entitymanager.createQuery(result4Sub2Query).getResultList();
                result4Sub3QueryList=entitymanager.createQuery(result4Sub3Query).getResultList();
                if(result4Sub1QueryList.size()>0){
                    cnf_name= result4Sub1QueryList.get(0).getCnf_name();

                }
                if(result4Sub2QueryList.size()>0){
                    Address_1=result4Sub2QueryList.get(0).getAddress_1();

                }
                if(result4Sub3QueryList.size()>0){
                    AIN_No=result4Sub3QueryList.get(0).getAIN_No();
                }
                result4Model.setCnf_name(cnf_name);
                result4Model.setAddress_1(Address_1);
                result4Model.setAIN_No(AIN_No);
                mainResultList4.add(result4Model);

            }
            queryResultMainModel.setResultListFour(mainResultList4);



            resultList.add(queryResultMainModel);
        }



        resultModel.setResultList(resultList);
        // resultModel.setPagination(pageList);
        mainResultList.add(resultModel);




        return mainResultList;
    }

    public List searchByConsigneeNotifyDescription(String type, Integer status, Long code,Integer queryStatus,
                                                          Integer role,String searchType,String searchValue){
        List<ViewIgmSubDetailMainModel> mainResultList =new ArrayList<>();
        List<ViewIgmSubDetailModel> resultList =new ArrayList<>();
        ViewIgmSubDetailMainModel resultModel=new ViewIgmSubDetailMainModel();
        List<IgmDetails>list=new ArrayList<>();
        String mainQuery="";

        List<ViewIgmSubDetailModel> mainQueryList=new ArrayList<>();
        EntityManager entitymanager= entityManagerFactory.createEntityManager();
         if(role==19 || role==23 || role==21){
             mainQuery="Select new com.datasoft.pcs.Model.DTO.ViewIgmSubDetailModel( igms.id,igms.igmId,igms.Import_Rotation_No, \n" +
                     "igms.Line_No, igms.BL_No,igms.Pack_Number, \n" +
                     "igms.Pack_Description,igms.Pack_Marks_Number,\n" +
                     "igms.Description_of_Goods,igms.Date_of_Entry_of_Goods, \n" +
                     "igms.weight,igms.weight_unit,igms.net_weight,igms.final_submit_date,\n" +
                     "igms.net_weight_unit, igms.Bill_of_Entry_No,igms.Bill_of_Entry_Date,\n" +
                     "igms.office_code,igms.No_of_Pack_Delivered, igms.No_of_Pack_Discharged,\n" +
                     "igms.Remarks,igms.AFR,igms.int_block,igms.R_No,igms.R_Date,\n" +
                     "igms.delivery_block_stat,igms.ConsigneeDesc,\n" +
                     "igms.NotifyDesc,igms.navy_comments,igms.Submitee_Org_Id,igms.mlocode,igms.igmType,\n" +
                     "igms.imco,igms.un,igms.extra_remarks,Navyresponse.response_details1,Navyresponse.response_details3,Navyresponse.response_details2,\n" +
                     "Navyresponse.hold_application,Navyresponse.rejected_application,Navyresponse.auto_no,\n" +
                     "Navyresponse.final_amendment , Navyresponse.appsubmitdate ,Navyresponse.navy_response_to_port,Navyresponse.permission_no,igms.Submission_Date)\n" +
                     "FROM  IgmDetails igms \n" +
                     "LEFT OUTER JOIN IgmNavyResponse  Navyresponse \n" +
                     "ON Navyresponse.igm_details_id =igms.id WHERE igms.igmId='"+code+"' AND (igms.igmType='"+type+"') \n" +
                     "AND igms.finalSubmit=1 AND igms."+searchType+" LIKE '%"+searchValue+"%'";


        }
         else{
             mainQuery="Select new com.datasoft.pcs.Model.DTO.ViewIgmSubDetailModel( igms.id,igms.igmId,igms.Import_Rotation_No, \n" +
                     "igms.Line_No, igms.BL_No,igms.Pack_Number, \n" +
                     "igms.Pack_Description,igms.Pack_Marks_Number,\n" +
                     "igms.Description_of_Goods,igms.Date_of_Entry_of_Goods, \n" +
                     "igms.weight,igms.weight_unit,igms.net_weight,igms.final_submit_date,\n" +
                     "igms.net_weight_unit, igms.Bill_of_Entry_No,igms.Bill_of_Entry_Date,\n" +
                     "igms.office_code,igms.No_of_Pack_Delivered, igms.No_of_Pack_Discharged,\n" +
                     "igms.Remarks,igms.AFR,igms.int_block,igms.R_No,igms.R_Date,\n" +
                     "igms.delivery_block_stat,igms.ConsigneeDesc,\n" +
                     "igms.NotifyDesc,igms.navy_comments,igms.Submitee_Org_Id,igms.mlocode,igms.igmType,\n" +
                     "igms.imco,igms.un,igms.extra_remarks,Navyresponse.response_details1,Navyresponse.response_details3,Navyresponse.response_details2,\n" +
                     "Navyresponse.hold_application,Navyresponse.rejected_application,Navyresponse.auto_no,\n" +
                     "Navyresponse.final_amendment , Navyresponse.appsubmitdate ,Navyresponse.navy_response_to_port,Navyresponse.permission_no,igms.Submission_Date)\n" +
                     "FROM  IgmDetails igms \n" +
                     "LEFT OUTER JOIN IgmNavyResponse  Navyresponse \n" +
                     "ON Navyresponse.igm_details_id =igms.id WHERE igms.igmId='"+code+"' AND igms.igmType='"+type+"'  \n" +
                     "AND igms.finalSubmit=1 and (igms.PFstatus=1 or igms.PFstatus=10) AND igms."+searchType+" LIKE '%"+searchValue+"%'" ;

         }


        mainQueryList =entitymanager.createQuery(mainQuery).getResultList();


        Integer resultSize=mainQueryList.size();
        List<ViewIgmSubDetailModel> mainQueryListLast=new ArrayList<>();

        for(int i=0;i<mainQueryList.size();i++){
            Long submitee_Org_Id=0L;
            String organizationName="";
            String ainNo="";
            List<OrganizationProfile> organizationNameList= new ArrayList<>();
            List<OrganizationProfile> organizationAinNoList= new ArrayList<>();

            String organizationNameQuery="";
            String organizationAinNoQuery="";
            ViewIgmSubDetailModel viewIgmSubDetailModel=mainQueryList.get(i);
            submitee_Org_Id=viewIgmSubDetailModel.getSubmitee_Org_Id();
            organizationNameQuery="select orgs from OrganizationProfile orgs where \n" +
                    "orgs.id="+submitee_Org_Id;

            organizationAinNoQuery="select orgs from OrganizationProfile orgs where \n" +
                    "orgs.id="+submitee_Org_Id;

            organizationNameList= entitymanager.createQuery(organizationNameQuery).getResultList();
            organizationAinNoList= entitymanager.createQuery(organizationAinNoQuery).getResultList();
            if(organizationNameList.size()>0){
                organizationName=organizationNameList.get(0).getOrganizationName();
            }

            if(organizationAinNoList.size()>0){
                ainNo=organizationAinNoList.get(0).getAinNo();

            }

            viewIgmSubDetailModel.setOrganization_Name(organizationName);
            viewIgmSubDetailModel.setAIN_No(ainNo);




            mainQueryListLast.add(viewIgmSubDetailModel);
        }

        for(int i=0;i<mainQueryListLast.size();i++){
            Long id=0L;
            ViewIgmSubDetailModel queryResultMainModel=mainQueryListLast.get(i);
            id=queryResultMainModel.getId();
            String result1Query="";
            String result2Query="";
            String result3Query="";
            String result4Query="";
            List<ViewIGMSubDetailResultModel> resultList1=new ArrayList<>();
            List<ViewIGMSubDetailResultModel> resultList2=new ArrayList<>();
            List<ViewIGMSubDetailResultModel> resultList3=new ArrayList<>();
            List<ViewIGMSubDetailResultModel> resultList4=new ArrayList<>();
            result1Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(cnt.id,cnt.contNumber ,cnt.contSize ,cnt.contType ,\n" +
                    " cnt.cont_iso_type,cnt.contHeight,cnt.contStatus,\n" +
                    " cnt.contGrossWeight,cnt.contWeight,cnt.contSealNumber,\n" +
                    "cnt.contDescription,cnt.contImo,cnt.contUn,\n" +
                    "ogr.organizationName) from IgmDetailContainer cnt \n" +
                    "left join OrganizationProfile ogr on cnt.offDockId=ogr.id\n" +
                    "where cnt.igmDetailId='"+id+"'";
            resultList1=entitymanager.createQuery(result1Query).getResultList();
            if(resultList1.size()>0){
                queryResultMainModel.setResultListFirst(resultList1);
            }


            result2Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel( cons.id,cons.igm_detail_id,cons.Consignee_ID," +
                    "cons.ff_clearance,2) from  IgmDetailConsigneetabs cons where cons.igm_detail_id='"+id+"'";
            resultList2=entitymanager.createQuery(result2Query).getResultList();
            List<ViewIGMSubDetailResultModel> mainResultList2=new ArrayList<>();
            for(int j=0;j<resultList2.size();j++){
                Integer consigneeID=0;
                String orgName="";
                String address1="";
                ViewIGMSubDetailResultModel result2Model=resultList2.get(j);
                consigneeID= result2Model.getConsignee_ID();
                String result2Sub1Query="";
                String result2Sub2Query="";
                List<ViewIGMSubDetailResultModel> result2Sub1QueryList=new ArrayList<>();
                List<ViewIGMSubDetailResultModel> result2Sub2QueryList=new ArrayList<>();
                result2Sub1Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel( org.organizationName,'orgName') from OrganizationProfile org where org.id="+consigneeID;
                result2Sub2Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel( org1.addressOne,'address1') from OrganizationProfile org1 where org1.id="+consigneeID;
                result2Sub1QueryList=entitymanager.createQuery(result2Sub1Query).getResultList();
                result2Sub2QueryList=entitymanager.createQuery(result2Sub2Query).getResultList();
                if(result2Sub1QueryList.size()>0){
                    orgName=result2Sub1QueryList.get(0).getOrganization_Name();
                }
                if(result2Sub2QueryList.size()>0){
                    address1=result2Sub2QueryList.get(0).getAddress_1();
                }
                result2Model.setOrganization_Name(orgName);
                result2Model.setAddress_1(address1);
                mainResultList2.add(result2Model);

            }
            List<ViewIGMSubDetailResultModel> resultListMain2=new ArrayList<>();
            for(int s=0;s<mainResultList2.size();s++){
                ViewIGMSubDetailResultModel result2MainModel=resultList2.get(s);
                String pfsStatusQuery="";
                Integer psf=0;
                List<ViewIGMSubDetailResultModel> pfsStatusQueryList=new ArrayList<>();
                pfsStatusQuery="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel (igm.PFstatus) from IgmDetails igm where id='"+id+"'";
                pfsStatusQueryList=entitymanager.createQuery(pfsStatusQuery).getResultList();
                if(pfsStatusQueryList.size()>0){
                    psf=pfsStatusQueryList.get(0).getPFs();

                }
                result2MainModel.setPFs(psf);
                resultListMain2.add(result2MainModel);

            }
            queryResultMainModel.setResultListSecond(resultListMain2);

            result3Query="SELECT new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(notf.id,notf.igm_detail_id,notf.Notify_ID,\n" +
                    "notf.ff_clearance,3)FROM IgmDetailNotifyTabs notf WHERE notf.igm_detail_id='"+id+"'";
            resultList3=entitymanager.createQuery(result3Query).getResultList();

            List<ViewIGMSubDetailResultModel> mainResultList3=new ArrayList<>();
            for(int j=0;j<resultList3.size();j++){
                Integer Notify_ID=0;
                String result3OrgName="";
                String result3Address1="";
                ViewIGMSubDetailResultModel result3Model=resultList3.get(j);
                Notify_ID=result3Model.getNotify_ID();
                String result3Sub1Query="";
                String result3Sub2Query="";
                List<ViewIGMSubDetailResultModel> result3Sub1QueryList=new ArrayList<>();
                List<ViewIGMSubDetailResultModel> result3Sub2QueryList=new ArrayList<>();
                result3Sub1Query="SELECT  new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(org.organizationName,'orgName') FROM OrganizationProfile org WHERE org.id="+Notify_ID;
                result3Sub2Query="SELECT  new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel (org1.addressOne,'address1') FROM OrganizationProfile org1 WHERE org1.id="+Notify_ID;
                result3Sub1QueryList=entitymanager.createQuery(result3Sub1Query).getResultList();
                result3Sub2QueryList=entitymanager.createQuery(result3Sub2Query).getResultList();
                if(result3Sub1QueryList.size()>0){
                    result3OrgName=  result3Sub1QueryList.get(0).getOrganization_Name();
                }
                if(result3Sub2QueryList.size()>0){
                    result3Address1=result3Sub2QueryList.get(0).getAddress_1();
                }
                result3Model.setOrganization_Name(result3OrgName);
                result3Model.setAddress_1(result3Address1);
                mainResultList3.add(result3Model);
            }
            queryResultMainModel.setResultListThird(mainResultList3);
            result4Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel (cnf.id,cnf.igm_detail_id,cnf.CnF_ID_to_be_AccountedFor) \n" +
                    " from IgmDetailCnfTabs cnf \n" +
                    "where cnf.igm_detail_id='"+id+"'";
            resultList4=entitymanager.createQuery(result4Query).getResultList();
            List<ViewIGMSubDetailResultModel> mainResultList4=new ArrayList<>();
            for(int j=0;j<resultList4.size();j++){
                String cnf_name="";
                String orgName="";
                String Address_1="";
                String AIN_No="";
                Integer CnF_ID_to_be_AccountedFor=0;
                ViewIGMSubDetailResultModel result4Model=resultList4.get(j);
                CnF_ID_to_be_AccountedFor=result4Model.getCnF_ID_to_be_AccountedFor();
                String result4Sub1Query="";
                String result4Sub2Query="";
                String result4Sub3Query="";

                List<ViewIGMSubDetailResultModel> result4Sub1QueryList=new ArrayList<>();
                List<ViewIGMSubDetailResultModel> result4Sub2QueryList=new ArrayList<>();
                List<ViewIGMSubDetailResultModel> result4Sub3QueryList=new ArrayList<>();

                result4Sub1Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(org.organizationName,'orgName') from OrganizationProfile where org.id="+CnF_ID_to_be_AccountedFor;
                result4Sub2Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(org1.addressOne,'address1')  from OrganizationProfile org1 where org1.id="+CnF_ID_to_be_AccountedFor;
                result4Sub3Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(org.ainNo,'ain') from OrganizationProfile org where org.id="+CnF_ID_to_be_AccountedFor;
                result4Sub1QueryList=entitymanager.createQuery(result4Sub1Query).getResultList();
                result4Sub2QueryList=entitymanager.createQuery(result4Sub2Query).getResultList();
                result4Sub3QueryList=entitymanager.createQuery(result4Sub3Query).getResultList();
                if(result4Sub1QueryList.size()>0){
                    cnf_name= result4Sub1QueryList.get(0).getCnf_name();

                }
                if(result4Sub2QueryList.size()>0){
                    Address_1=result4Sub2QueryList.get(0).getAddress_1();

                }
                if(result4Sub3QueryList.size()>0){
                    AIN_No=result4Sub3QueryList.get(0).getAIN_No();
                }
                result4Model.setCnf_name(cnf_name);
                result4Model.setAddress_1(Address_1);
                result4Model.setAIN_No(AIN_No);
                mainResultList4.add(result4Model);

            }
            queryResultMainModel.setResultListFour(mainResultList4);



            resultList.add(queryResultMainModel);
        }



        resultModel.setResultList(resultList);
        // resultModel.setPagination(pageList);
        mainResultList.add(resultModel);




        return mainResultList;
    }
   public List viewReport(String rotation, String blNo){
        List<ViewIgmSubDetailReportModel> resultList =new ArrayList<>();
        List<IgmDeliveryOrder> deliveryOrderList=igmDeliveryOrderRepository.findByRotationAndBlNo(rotation,blNo);
        if(deliveryOrderList.size()>0){
            for(int i=0;i< deliveryOrderList.size();i++){
                ViewIgmSubDetailReportModel resultModel=new ViewIgmSubDetailReportModel();
                Long consigneeId=deliveryOrderList.get(i).getConsigneeId();
                String cconsigneeName=deliveryOrderList.get(0).getConsigneeName();
                resultModel.setId(deliveryOrderList.get(i).getId());
                resultModel.setRotation(deliveryOrderList.get(i).getRotation());
                resultModel.setLineNo(deliveryOrderList.get(i).getLineNo());
                resultModel.setBlNo(deliveryOrderList.get(i).getBlNo());
                resultModel.setBillOfEntryNo(deliveryOrderList.get(i).getBillOfEntryNo());
                resultModel.setBillOfEntryDate(deliveryOrderList.get(i).getBillOfEntryDate());
                resultModel.setGpNo(deliveryOrderList.get(i).getGpNo());
                resultModel.setGpDate(deliveryOrderList.get(i).getGpDate());
                resultModel.setPaidDate(deliveryOrderList.get(i).getPaidDate());
                resultModel.setVoyNo(deliveryOrderList.get(i).getVoyNo());
                resultModel.setVesselName(deliveryOrderList.get(i).getVesselName());
                resultModel.setDate(deliveryOrderList.get(i).getDate());
                resultModel.setPackMarksNumber(deliveryOrderList.get(i).getPackMarksNumber());
                resultModel.setDescription(deliveryOrderList.get(i).getDescription());
                resultModel.setConsigneeId(deliveryOrderList.get(i).getConsigneeId());
                resultModel.setConsigneeName(deliveryOrderList.get(i).getConsigneeName());
                resultModel.setCnfId(deliveryOrderList.get(i).getCnfId());
                resultModel.setAgent(deliveryOrderList.get(i).getAgent());
                resultModel.setReleased(deliveryOrderList.get(i).getReleased());
                resultModel.setPortComment(deliveryOrderList.get(i).getPortComment());
                String cnfName="";
                if(consigneeId>0){
                    cnfName=cconsigneeName;
                }
                Optional<OrganizationProfile> organizationProfile=organizationProfileRepository.findById(deliveryOrderList.get(i).getCnfId());

                if(organizationProfile.isPresent()){
                    cnfName= organizationProfile.get().getOrganizationName();
                }
                resultModel.setCnfName(cnfName);
                List<IgmDetailContainer> igmDetailContainers= igmDetailContainerRepository.findByIgmDetailId(deliveryOrderList.get(0).getIgmDetailId());
                resultModel.setIgmContainerList(igmDetailContainers);
                resultList.add(resultModel);

            }

        }

        return resultList;
   }

    public List viewDeliveryOrder(String rotation, String blNo,Integer igmDetailId,String portComment,String loginId){
        EntityManager entitymanager= entityManagerFactory.createEntityManager();
        List<ViewIgmSubDetailReportModel> resultList =new ArrayList<>();
        String queryString="UPDATE IgmDeliveryOrder igm \n" +
                "      SET igm.portComment=:portComment\n" +
                "      SET igm.commentBy=:commentBy\n" +
              //"      SET igm.commentTime=:commentTime\n" +
                "       WHERE igm.igmDetailId=:igmDetailId";
        entitymanager.getTransaction().begin();
        Query query = entitymanager.createQuery(queryString);
        query.setParameter("portComment",portComment );
        query.setParameter("commentBy",loginId );
       // query.setParameter("commentTime",portComment );
        query.setParameter("igmDetailId", igmDetailId);
        query.executeUpdate();
        entitymanager.getTransaction().commit();
        resultList=viewReport(rotation,blNo);
        return resultList;
    }

    public List releaseDeliveryOrder(String rotation, String blNo,Integer igmDetailId,String loginId){
        EntityManager entitymanager= entityManagerFactory.createEntityManager();
        List<ViewIgmSubDetailReportModel> resultList =new ArrayList<>();String queryString="UPDATE IgmDeliveryOrder igm \n" +
                "      SET igm.released=:released\n" +
                "      SET igm.releasedBy=:releasedBy\n" +
                //"      SET igm.releasedTime=:releasedTime\n" +
                "       WHERE igm.igmDetailId=:igmDetailId";
        entitymanager.getTransaction().begin();
        Query query = entitymanager.createQuery(queryString);
        query.setParameter("released",1 );
        query.setParameter("releasedBy",loginId );
        // query.setParameter("releasedTime",portComment );
        query.setParameter("igmDetailId", igmDetailId);
        query.executeUpdate();
        entitymanager.getTransaction().commit();
        resultList=viewReport(rotation,blNo);
        return resultList;
    }

    public List viewSupplementaryDetail(Long code, Long subCode, String type  ){
        List<ViewSupplementaryDetailModel> mainResultList=new ArrayList<>();
        List<ViewSupplementaryDetailModel> resultList=new ArrayList<>();
        EntityManager entitymanager= entityManagerFactory.createEntityManager();
        String sqlQuery="";
        sqlQuery="SELECT new com.datasoft.pcs.Model.DTO.ViewSupplementaryDetailModel("+
        "igms.id, igms.igmMasterId, igms.igmDetailId, igms.masterLineNo,\n" +
        "igms.masterBLNo, igms.importRotationNo, igms.lineNo,\n" +
        "igms.blNo, igms.packNumber, igms.afr, igms.packDescription,\n" +
        "igms.packMarksNumber, igms.descriptionOfGoods, igms.dateOfEntryOfGoods,\n" +
        "igms.weight, igms.billOfEntryNo, igms.billOfEntryDate, igms.officeCode,\n" +
        "igms.noOfPackDelivered, igms.noOfPackDischarged, igms.remarks, igms.consigneeDesc,\n" +
        "igms.notifyDesc, igms.igmSupDetailId, igms.weightUnit, igms.netWeight, igms.netWeightUnit,\n" +
        "igms.submissionDate, igms.typeOfIgm, igms.finalSubmit, igms.submiteeOrgId, navyresponse.navy_response_to_port,\n" +
        "navyresponse.response_details1, navyresponse.response_details2, navyresponse.response_details3,\n" +
        "navyresponse.secondApprovalTime, navyresponse.hold_application, navyresponse.holdDate, navyresponse.rejected_application,\n" +
        "navyresponse.rejected_date, navyresponse.final_amendment, org.organizationName, org.ainNo, org.ainNoNew) \n"+
        "from IgmSupplimentaryDetail igms inner join OrganizationProfile org on igms.submiteeOrgId=org.id \n"+
         "left join IgmNavyResponse navyresponse on navyresponse.egmDetailsId=igms.id \n"+
        "where igms.igmMasterId='"+code+"' and igms.igmDetailId='"+subCode+"' and igms.typeOfIgm='"+type+"' and igms.finalSubmit=1 and igms.igmSupDetailId=0";
        resultList=entitymanager.createQuery(sqlQuery).getResultList();
        for(int i=0;i<resultList.size();i++){
            ViewSupplementaryDetailModel mainModel =resultList.get(i);
           /* Long id=resultList.get(i).getId();
            String result1Query="";
            result1Query="SELECT new com.datasoft.pcs.Model.DTO.ViewSupplimentaryDetailResultModel(" +
                    "igm.id, igm.contNumber, igm.contSize, igm.contType, igm.contHeight, igm.contStatus, " +
                    "igm.contWeight, igm.contGrossWeight, igm.contSealNumber, igm.contDescription, " +
                    "igm.contImo, igm.contUn"+
                    ")"+"FROM IgmSupDetailContainer igm "+
                    "WHERE igm.igmSupDetailId="+id;
            List resultList1=entitymanager.createQuery(result1Query).getResultList();
            System.out.println("result 1 id and  size ");
            mainModel.setResultListFirst(resultList1);*/

          /*  String result2Query="";

            result2Query="SELECT new com.datasoft.pcs.Model.DTO.ViewSupplimentaryDetailResultModel(" +
                    "igm.id, igm.igmSupDetailId, igm.consigneeID"+
                    ")"+"FROM IgmSupDetailConsigneetabs igm "+
                    "WHERE igm.igmSupDetailId="+id;
            List<ViewSupplimentaryDetailResultModel> resultList2=entitymanager.createQuery(result2Query).getResultList();
            List<ViewSupplimentaryDetailResultModel>finalResultList2=new ArrayList<>();
           for(int j=0; j<resultList2.size();j++){
                ViewSupplimentaryDetailResultModel result2Model=resultList2.get(j);
                Long consigneeID=result2Model.getConsigneeID();
            String result2Sub1Query="";
            String result2Sub2Query="";
            String orgName="";
            String address1="";
            List<ViewSupplimentaryDetailResultModel> result2Sub1QueryList=new ArrayList<>();
            List<ViewSupplimentaryDetailResultModel> result2Sub2QueryList=new ArrayList<>();
            result2Sub1Query="select new com.datasoft.pcs.Model.DTO.ViewSupplimentaryDetailResultModel( org.organizationName,'orgName') from OrganizationProfile org where org.id="+consigneeID;
            result2Sub2Query="select new com.datasoft.pcs.Model.DTO.ViewSupplimentaryDetailResultModel( org1.addressOne,'address1') from OrganizationProfile org1 where org1.id="+consigneeID;
            result2Sub1QueryList=entitymanager.createQuery(result2Sub1Query).getResultList();
            result2Sub2QueryList=entitymanager.createQuery(result2Sub2Query).getResultList();
            if(result2Sub1QueryList.size()>0){
                orgName=result2Sub1QueryList.get(0).getOrganizationName();
            }
            if(result2Sub2QueryList.size()>0){
                address1=result2Sub2QueryList.get(0).getAddress1();
            }
            finalResultList2.add(result2Model);
            mainModel.setResultListSecond(finalResultList2);
            }*/
            resultList.add(mainModel);
        }


        return resultList;
    }







}
