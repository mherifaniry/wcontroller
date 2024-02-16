package com.mherifaniry.wcontroller;


import mherifaniry.entity.Personne;
import mherifaniry.service.PersonneService;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class PersonneController {
    PersonneService personneService = null;

    public PersonneController()
    {
        personneService = new PersonneService();
    }

    public void create()
    {
        Personne personne = new Personne();
        Scanner sc = new Scanner(System.in);
        System.out.print("votre nom: ");
        String nom = sc.nextLine();
        short jour, mois;

        do {
            System.out.print("Jour de naissance: ");
            jour = sc.nextShort();
        }while(jour <= 0 || jour > 31);

         do {
            System.out.print("Mois de naissance: ");
            mois = sc.nextShort();
        }while (mois <= 0 || mois > 12 );

        System.out.print("Année de naissance: ");
        int year = sc.nextInt();
        System.out.print("Votre sex (H/F): ");
        char sex = sc.next().charAt(0);

        Calendar calendar = new GregorianCalendar(year, mois-1, jour);
        personne.setName(nom);
        personne.setDateOfBirth(new Timestamp(calendar.getTimeInMillis()));
        personne.setSex(sex);
        personneService.create(personne);
        System.out.print("Done..");

    }
    public void read()
    {
        List<Personne> personneList =  personneService.list();
        for(Personne personne: personneList){
            System.out.println("Nom: "+personne.getName()+" id: "+ personne.getId());
        }

    }
    public void update()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("votre nom: ");
        String nom = sc.nextLine();
        short jour, mois;

        do {
            System.out.print("Jour de naissance: ");
            jour = sc.nextShort();
        }while(jour <= 0 || jour > 31);

        do {
            System.out.print("Mois de naissance: ");
            mois = sc.nextShort();
        }while (mois <= 0 || mois > 12 );

        System.out.print("Année de naissance: ");
        int year = sc.nextInt();
        System.out.print("Votre sex (H/F): ");
        char sex = sc.next().charAt(0);

        Calendar calendar = new GregorianCalendar(year, mois, jour);

        System.out.print("Id: ");
        int id = sc.nextInt();
        personneService.update(id, nom, new Timestamp(calendar.getTimeInMillis()), sex);
        System.out.print("Done..");
    }

    public void delete()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Id de la personne: ");
        short id = sc.nextShort();
        personneService.delete(id);
        System.out.print("Done...");
    }
}
