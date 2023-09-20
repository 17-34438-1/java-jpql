package com.datasoft.pcs.Controller;

import com.datasoft.pcs.Service.ViewIgmSubDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/IgmOperation")
public class IgmController {
    @Autowired
    ViewIgmSubDetailService viewIgmSubDetailService;

    @RequestMapping(value = "/ViewIgmSubDetailList/{type}/{limit}/{start}/{status}/{code}/{queryStatus}", method= RequestMethod.GET)
    @ResponseBody
    public List getViewIgmSubDetailList(@PathVariable String type, @PathVariable Integer limit, @PathVariable Integer start,
                                        @PathVariable Integer status, @PathVariable Long code, @PathVariable Integer queryStatus)  {
        List list =new ArrayList<>();

        list=viewIgmSubDetailService.getViewIgmSubDetalList(type,limit,start,status,code,queryStatus);


        return list;
    }

    @RequestMapping(value = "/ViewIgmSubDetailSearch/{code}/{role}/{orgTpeId}/{type}", method= RequestMethod.GET)
    @ResponseBody
    public List viewIgmSubDetailSearch(@PathVariable Long code, @PathVariable Integer role,  @PathVariable Integer orgTpeId,@PathVariable String type)  {
        List list =new ArrayList<>();

        list=viewIgmSubDetailService.viewIgmDeatailSearch(code,role,orgTpeId,type);


        return list;
    }

    @RequestMapping(value = "/SearchIgmSubmittedByMlo/{type}/{status}/{code}/{queryStatus}/{orgTypeId}", method= RequestMethod.GET)
    @ResponseBody
    public List searchIgmSubmittedByMlo(@PathVariable String type,@PathVariable Integer status, @PathVariable Long code,
                                        @PathVariable Integer queryStatus,@PathVariable Long orgTypeId)  {
        List list =new ArrayList<>();

        list=viewIgmSubDetailService.searchIgmSubmittedByMlo(type,status,code,queryStatus,orgTypeId);


        return list;
    }

    @RequestMapping(value = "/SearchIgmSubmittedBySAF/{type}/{status}/{code}/{queryStatus}/{orgTypeId}", method= RequestMethod.GET)
    @ResponseBody
    public List searchIgmSubmittedBySAF(@PathVariable String type,@PathVariable Integer status, @PathVariable Long code,
                                        @PathVariable Integer queryStatus,@PathVariable Long orgTypeId)  {
        List list =new ArrayList<>();


        list=viewIgmSubDetailService.searchIgmSubmittedBySAF(type,status,code,queryStatus,orgTypeId);


        return list;
    }


    @RequestMapping(value = "/SearchByMloCode/{type}/{status}/{code}/{queryStatus}/{orgTypeId}", method= RequestMethod.GET)
    @ResponseBody
    public List searchByMloCode(@PathVariable String type,@PathVariable Integer status, @PathVariable Long code,
                                @PathVariable Integer queryStatus,@PathVariable String orgTypeId)  {
        List list =new ArrayList<>();

        list=viewIgmSubDetailService.searchByMloCode(type,status,code,queryStatus,orgTypeId);


        return list;
    }

    @RequestMapping(value = "/SearchByBlNumberLineNumberContainerNumber/{type}/{status}/{code}/{queryStatus}/{role}/{searchType}/{searchValue}", method= RequestMethod.GET)
    @ResponseBody
    public List searchByBlNumberLineNumberContainerNumber(@PathVariable String type,@PathVariable Integer status, @PathVariable Long code,
                                @PathVariable Integer queryStatus, @PathVariable Integer role,@PathVariable Integer searchType,
                                                          @PathVariable String searchValue)  {
        System.out.println("hello ");
        List list =new ArrayList<>();

        list=viewIgmSubDetailService.searchByBlNumberLineNumberContainerNumber(type,status,code,queryStatus,role,searchType,searchValue);


        return list;
    }

    @RequestMapping(value = "/SearchByConsigneeNotifyDescription/{type}/{status}/{code}/{queryStatus}/{role}/{searchType}/{searchValue}", method= RequestMethod.GET)
    @ResponseBody
    public List searchByConsigneeNotifyDescription(@PathVariable String type,@PathVariable Integer status, @PathVariable Long code,
                                                          @PathVariable Integer queryStatus, @PathVariable Integer role,@PathVariable String searchType,
                                                          @PathVariable String searchValue)  {
        List list =new ArrayList<>();
        searchValue=searchValue.replace("-","/");

        list=viewIgmSubDetailService.searchByConsigneeNotifyDescription(type,status,code,queryStatus,role,searchType,searchValue);


        return list;
    }

    @RequestMapping(value = "/ViewIgmSubDetailReport/{rotation}/{blNo}", method= RequestMethod.GET)
    @ResponseBody
    public List viewIgmSubDetailReport(@PathVariable String rotation,@PathVariable String blNo )  {
        List list =new ArrayList<>();
        rotation=rotation.replace("-","/");
        list=viewIgmSubDetailService.viewReport(rotation,blNo);
        return list;
    }

    @RequestMapping(value = "/ViewDeliveryOrder", method= RequestMethod.POST)
    @ResponseBody
    public List viewDeliveryOrder(@RequestParam("loginId") String loginId ,@RequestParam("rotation") String rotation ,
                                  @RequestParam("blNo") String blNo, @RequestParam("igmDetailId") Integer igmDetailId,
                                  @RequestParam("portComment") String portComment)  {
        List list =new ArrayList<>();
        rotation=rotation.replace("-","/");
        list=viewIgmSubDetailService.viewDeliveryOrder(rotation,blNo,igmDetailId,portComment,loginId);
        return list;
    }

    @RequestMapping(value = "/ReleasedDeliveryOrder", method= RequestMethod.POST)
    @ResponseBody
    public List releasedDeliveryOrder(@RequestParam("loginId") String loginId ,@RequestParam("rotation") String rotation ,
                                  @RequestParam("blNo") String blNo, @RequestParam("igmDetailId") Integer igmDetailId)  {
        List list =new ArrayList<>();
        rotation=rotation.replace("-","/");
        list=viewIgmSubDetailService.releaseDeliveryOrder(rotation,blNo,igmDetailId,loginId);
        return list;
    }

    @RequestMapping(value = "/ViewSupplementaryDetail/{code}/{subCode}/{type}", method= RequestMethod.GET)
    @ResponseBody
    public List viewSupplementaryDetail(@PathVariable Long code,@PathVariable Long subCode,@PathVariable String  type )  {
        List list =new ArrayList<>();
        list=viewIgmSubDetailService.viewSupplementaryDetail(code,subCode,type);
        return list;
    }
}
