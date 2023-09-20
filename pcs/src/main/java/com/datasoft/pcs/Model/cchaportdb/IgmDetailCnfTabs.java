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
@Table(name="igm_detail_cnftabs")
public class IgmDetailCnfTabs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="igm_detail_id")
    private Integer igm_detail_id;
    @Column(name="CnF_ID_to_be_AccountedFor")
    private Integer CnF_ID_to_be_AccountedFor;
}
