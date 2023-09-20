package com.datasoft.pcs.Repository.cchaportdb;

import com.datasoft.pcs.Model.cchaportdb.IgmDeliveryOrder;
import com.datasoft.pcs.Model.cchaportdb.IgmDetails;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface IgmDetailsRepository extends JpaRepository<IgmDetails,Integer> {
    List<IgmDetails> findDistinctByIgmId(Long code);

    List<IgmDetails> findDistinctMlocodeByIgmId(Long code);

    List<IgmDetails> findDistinctIgmTypeByIgmId(Long code);



    //  List<IgmDetails> findByIgmId(Integer code);
   // List<IgmDetails> findByIgmIdAndIgmTypeAndFinalSubmit(Integer code, String type,Integer i);
   // List<IgmDetails> findByIgmIdAndIgmTypeOrIgmTypeAndFinalSubmitAndIdBetween(Integer code, String type, String gm, int i, Integer start, Integer limit);


  //  List<IgmDetails> findByIgmIdAndIgmTypeOrIgmTypeAndFinalSubmit(Integer code, String type, String gm, int i);
}
