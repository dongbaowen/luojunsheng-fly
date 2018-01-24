package com.junshengluo.service.impl;

import com.junshengluo.domain.Person;
import com.junshengluo.service.PersonService;
import org.springframework.stereotype.Service;

/**
 * @author DongBaoWen
 * @create 2018-01-24 23:39
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {

    public int addPerson(Person person) {
        System.out.println("添加成功!");
        System.out.println(person);
        return 1;
    }
}
