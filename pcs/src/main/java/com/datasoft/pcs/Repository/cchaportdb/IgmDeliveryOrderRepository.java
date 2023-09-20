package com.datasoft.pcs.Repository.cchaportdb;

import com.datasoft.pcs.Model.cchaportdb.IgmDeliveryOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IgmDeliveryOrderRepository extends JpaRepository<IgmDeliveryOrder,Long> {

    List<IgmDeliveryOrder> findByRotationAndBlNo(String rotation, String blNo);
}
