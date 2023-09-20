package com.datasoft.pcs.Model.cchaportdb;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_org_types")
public class OrganizationType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Organization type name is mandatory")
    @Column(name = "Org_Type")
    private String orgType;

    @Nullable
    @Column(name = "Type_description")
    private String typeDescription;

    @JsonIgnore
    @OneToMany(mappedBy = "organizationType",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrganizationProfile> organizationProfiles = new ArrayList<>();
}
