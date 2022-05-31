package com.example.codeCamp.service;

import com.example.codeCamp.dao.PersonDao;
import com.example.codeCamp.model.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;

    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        UUID id = UUID.randomUUID();
        return personDao.insertPerson(id, person);
    }

    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }
}
