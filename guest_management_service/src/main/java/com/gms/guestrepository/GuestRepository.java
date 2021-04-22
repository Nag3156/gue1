package com.gms.guestrepository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gms.model.Guest;

@Repository
public interface GuestRepository extends MongoRepository<Guest, String> {

}

