package com.datasoft.pcs.Model.cchaportdb;

import io.swagger.models.auth.In;
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
@Table(name="igm_detail_notifytabs")
public class IgmDetailNotifyTabs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "igm_detail_id")
    private Integer igm_detail_id;

    @Column(name = "Notify_ID")
    private Integer Notify_ID;

    @Column(name = "ff_clearance")
    private Integer ff_clearance;




}
