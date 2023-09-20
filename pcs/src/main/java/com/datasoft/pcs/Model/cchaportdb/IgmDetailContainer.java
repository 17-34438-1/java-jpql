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
@Table(name="igm_detail_container")
public class IgmDetailContainer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="igm_detail_id")
    private Integer igmDetailId;

    @Column(name="cont_number")
    private String contNumber;

    @Column(name="cont_size")
    private Integer contSize;

    @Column(name="cont_type")
    private String contType;

    @Column(name="cont_iso_type")
    private String cont_iso_type;

    @Column(name="cont_height")
    private Double contHeight;

    @Column(name="cont_status")
    private String contStatus;

    @Column(name="cont_gross_weight")
    private Double contGrossWeight;

    @Column(name="cont_weight")
    private Integer contWeight;

    @Column(name="cont_seal_number")
    private String contSealNumber;

    @Column(name="cont_description")
    private String contDescription;

    @Column(name="cont_imo")
    private String contImo;

    @Column(name="cont_un")
    private String contUn;
  //  @ManyToOne
   // @JoinColumn(name="off_dock_id")
 //   private OrganizationProfiles organizationProfiles;
    @Column(name="off_dock_id")
    private Integer offDockId;




}
