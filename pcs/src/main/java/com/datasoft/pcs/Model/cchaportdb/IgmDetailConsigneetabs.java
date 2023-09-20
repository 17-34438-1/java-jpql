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
@Table(name="igm_detail_consigneetabs")
public class IgmDetailConsigneetabs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="igm_detail_id")
    private Integer igm_detail_id;
    @Column(name="Consignee_ID")
    private Integer Consignee_ID;
    @Column(name="ff_clearance")
    private Integer ff_clearance;
}
