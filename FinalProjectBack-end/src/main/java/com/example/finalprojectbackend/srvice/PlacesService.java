package com.example.finalprojectbackend.srvice;

import com.example.finalprojectbackend.Repositry.PlaceRepositry;
import com.example.finalprojectbackend.model.Places;
import com.example.finalprojectbackend.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PlacesService {

    public final PlaceRepositry placeRepositry;

    public void Addplace(Places placess, Users user){
        //check if he is admin first
        placess.setAdminId(user.getId());
        placeRepositry.save(placess);

    }

    public void updateplace(Places places,Users users,Integer id){
        //check if he is admin
//        if (places.getAdminId().equals(users.getId())) {
            Places newplace=placeRepositry.findPlacesById(id);
            newplace.setDuration(places.getDuration());
            newplace.setLocation(places.getLocation());
            newplace.setPrice(places.getPrice());
            newplace.setKindOfStorage(places.getKindOfStorage());
            placeRepositry.save(newplace);
        }
        //places.setAdminId(users.getId());




    public void deleteplace(Users users,Integer id) {
        //chechk if he is admin
        Places thewantedplace = placeRepositry.findPlacesById(id);
        if (users.getId().equals(thewantedplace.getAdminId()))
            placeRepositry.delete(thewantedplace);
//        else
//            throw exception
    }

        public List<Places> SearchbyLocation(String location){

        return placeRepositry.findAllByLocation(location);
    }
public List<Places> SearchbyLocationAndType(String location,String type){
//
  return placeRepositry.findAllByLocationAndKindOfStorage(location,type);
  }
//
//    public List<Places> findAllByAdminId(Users users){
//
//        return placeRepositry.findAllByAdminId(users.getId());
//
//        }



    }




