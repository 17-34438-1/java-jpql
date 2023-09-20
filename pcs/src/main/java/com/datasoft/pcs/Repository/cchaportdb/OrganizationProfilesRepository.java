package com.datasoft.pcs.Repository.cchaportdb;

import com.datasoft.pcs.Model.cchaportdb.IgmDetailContainer;
import com.datasoft.pcs.Model.cchaportdb.OrganizationProfile;
import com.datasoft.pcs.Model.cchaportdb.OrganizationProfiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrganizationProfilesRepository extends JpaRepository<OrganizationProfile,Integer> {

    List<OrganizationProfile> findByOrganizationTypeIdOrderByOrganizationName(Long i);

    List<OrganizationProfile> findByIdOrOrganizationTypeIdOrderByOrganizationName(long l, long l1);

    // List<OrganizationProfiles> findByIgmDetailContainersIgmDetailId(Integer id);


}
