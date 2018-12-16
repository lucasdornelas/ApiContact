package com.agenciacontato.apicontact.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Contact {

    private String name;
    private String nickName;

    private String telephoneNumber;
    private String cellNumber;

    private String companyName;

    private String webSite;

    private String email;
}
