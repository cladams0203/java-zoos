package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Telephones;

public interface TelephoneService {

    Telephones save(String phonenumber, String phonetype, long zooid);


}
