package com.example.webservicehw;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Organizations {

    public static Map<Long, Organization> orgs = new HashMap<>();

    static {
        orgs.put(1L, new Organization(1L,"HalykBank","Astana", LocalDate.now()));
        orgs.put(2L, new Organization(2L,"ForteBank","Almaty", LocalDate.now()));
    }
}
