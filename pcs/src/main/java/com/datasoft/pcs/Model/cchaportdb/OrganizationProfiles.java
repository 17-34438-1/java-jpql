package com.datasoft.pcs.Model.cchaportdb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="organization_profiles")
public class OrganizationProfiles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Organization_Name")
    private String organizationName;
    @Column(name = "AIN_No")
    private String AIN_No;
    @Column(name = "Address_1")
    private String Address_1;
  //  @OneToMany(mappedBy = "organizationProfiles",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   // List<IgmDetailContainer> igmDetailContainers=new ArrayList<>();

}
