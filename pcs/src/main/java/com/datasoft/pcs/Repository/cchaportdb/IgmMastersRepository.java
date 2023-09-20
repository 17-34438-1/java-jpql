package com.datasoft.pcs.Repository.cchaportdb;

import com.datasoft.pcs.Model.cchaportdb.IgmMasters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IgmMastersRepository extends JpaRepository<IgmMasters,Long> {


    Optional<IgmMasters> findDistinctById(Long code);
}
