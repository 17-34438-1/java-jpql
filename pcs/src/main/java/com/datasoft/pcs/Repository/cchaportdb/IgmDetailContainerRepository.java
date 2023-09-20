package com.datasoft.pcs.Repository.cchaportdb;

import com.datasoft.pcs.Model.cchaportdb.IgmDetailContainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IgmDetailContainerRepository extends JpaRepository<IgmDetailContainer,Integer> {
    List<IgmDetailContainer> findByIgmDetailId(Long igmDetailId);


    // List<IgmDetailContainer> findByIgmDetailId(Integer id);

  //  @Query("Select e.id from IgmDetailContainer  ")
   // public List<IgmDetailContainer> all();
}
