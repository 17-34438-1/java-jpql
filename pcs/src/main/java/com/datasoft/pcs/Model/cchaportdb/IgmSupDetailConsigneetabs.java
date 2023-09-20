package com.datasoft.pcs.Model.cchaportdb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "igm_sup_detail_consigneetabs")
public class IgmSupDetailConsigneetabs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @Column(name="igm_sup_detail_id")
    private Long igmSupDetailId;

    @Column(name="Consignee_ID")
    private Long consigneeID;
}
