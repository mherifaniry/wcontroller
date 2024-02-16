package com.mherifaniry.wcontroller;

import mherifaniry.entity.Transactions;
import mherifaniry.service.TransactionsService;

import java.util.List;
import java.util.Scanner;

public class TransactionsController {

    TransactionsService transactionsService = null;
    public TransactionsController()
    {
        transactionsService = new TransactionsService();
    }

    public void create()
    {
        System.out.print("Cégorie: ");
        Scanner sc2 =  new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        short id_categorie = sc.nextShort();

        System.out.print("Montant de la transaction : ");
        double montant = sc.nextDouble();
        System.out.print("Décrire cette transaction: ");
        String description = sc2.nextLine();
        int id_personne = 2;


        transactionsService.create(id_categorie, id_personne, description, montant);
    }

    public void  getById()
    {
        System.out.print("L'identité de la transaction :");
        Scanner sc = new Scanner(System.in);
        long id = sc.nextLong();
        Transactions transactions = transactionsService.getById(id);
        if(transactions != null)
        {
            System.out.print(transactions.getId()+' '+transactions.getCategorie().getLibelle()+' '+transactions.getMontant()+' '+transactions.getPersonne().getName());
        }
        else {
            System.out.println("Pas de résultat, merci d'essayer d'autre id ");
        }

    }

    public List<Transactions> list()
    {
        return transactionsService.list();
    }
}
