package com.lambdaschool.zoos.services;


import com.lambdaschool.zoos.models.Telephones;
import com.lambdaschool.zoos.models.Zoos;
import com.lambdaschool.zoos.repository.TelephoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "telephoneService")
public class TelephoneServiceImpl implements TelephoneService {

    @Autowired
    private TelephoneRepository telephonerepos;

    @Autowired
    private ZooService zooService;

    @Transactional
    @Override
    public Telephones save(String phonenumber, String phonetype, long zooid) {
        Zoos currentZoo = zooService.findByZooId(zooid);
        Telephones newTelephone = new Telephones(phonenumber, phonetype, currentZoo);
        return telephonerepos.save(newTelephone);
    }
}
