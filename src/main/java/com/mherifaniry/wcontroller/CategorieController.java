package com.mherifaniry.wcontroller;

import mherifaniry.entity.Categorie;
import mherifaniry.service.CategorieService;

import java.util.List;
import java.util.Scanner;

public class CategorieController {
    private CategorieService categorieService;
    public CategorieController()
    {
        this.categorieService = new CategorieService();
    }

    public void creerCategorie()
    {
        Boolean b = true;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Le titre : ");
            String libelle = sc.nextLine();
            System.out.print("Le type: ");
            char type = sc.next().charAt(0);
            Categorie categorie = new Categorie();
            categorie.setLibelle(libelle);
            categorie.setType(type);
            categorieService.create(categorie);
            System.out.println(categorie.getId());

            System.out.print("Voulez vous continuez : ");
            Scanner scs = new Scanner(System.in);
            char yes = scs.next().charAt(0);
            if(yes == 'n'){
                b = false;
            }
        }while(b);
    }

    public void listCategorie()
    {
        System.out.println("voici la liste des categorie ");
        List<Categorie> categorieList =  this.categorieService.list();
        for(Categorie categorie : categorieList)
        {
            System.out.println("id: "+categorie.getId()+" Libelle: "+categorie.getLibelle()+" Type:"+categorie.getType());
        }
    }
    public String afficherCategorie(short id)
    {
        String final_value = "vide";
        Categorie categorie = categorieService.getById(id);
        if(categorie != null)
        {
            final_value =  "La catégorie n°"+categorie.getId()+": "+categorie.getLibelle()+ " de type "+categorie.getType();
        }

        return final_value;

    }

    public void updateCategorie()
    {
        System.out.print("Quelle catégorie ? (id) : ");
        Scanner sc = new Scanner(System.in);
        short id = sc.nextShort();
        Categorie categorie = categorieService.getById(id);
        System.out.println("La catégorie n°"+categorie.getId()+": "+categorie.getLibelle()+ " de type "+categorie.getType());
        System.out.println("Nouvelle libellée: ");
        Scanner scs = new Scanner(System.in);
        String libelle = scs.nextLine();
        System.out.print("Nouvelle Type: ");
        char type = sc.next().charAt(0);
        categorie = categorieService.update(categorie.getId(), libelle, type);
        System.out.println("La catégorie n°"+categorie.getId()+": "+categorie.getLibelle()+ " de type "+categorie.getType());

    }

    public void deleteCategorie()
    {
        System.out.print("Quelle catégorie ? (id) : ");
        Scanner sc = new Scanner(System.in);
        short id = sc.nextShort();
        categorieService.delete(id);
    }

}
