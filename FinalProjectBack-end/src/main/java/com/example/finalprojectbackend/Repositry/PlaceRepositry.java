package com.example.finalprojectbackend.Repositry;

import com.example.finalprojectbackend.model.Places;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepositry extends JpaRepository<Places, Integer> {
    List<Places> findAllByLocation(String location);
    List<Places> findAllByLocationAndKindOfStorage(String location,String kindOfStorage);
//    List<Places> findAllByAdminId(String adminid);

    Places findPlacesById(Integer id);
 //   List<Places> findAllByAdminId(Integer id);
//    Places findById(Integer id);

}
