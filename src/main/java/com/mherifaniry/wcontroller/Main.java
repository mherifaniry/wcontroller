package com.mherifaniry.wcontroller;

import mherifaniry.entity.Categorie;
import mherifaniry.entity.Personne;
import mherifaniry.entity.Transactions;

import java.sql.Timestamp;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Categorie categorie = new Categorie();
        System.out.println(categorie.getId());
        /*TransactionsController transactionsController = new TransactionsController();
        List<Transactions> transactionsList = transactionsController.list();
        for(Transactions transactions: transactionsList)
        {
            System.out.println(transactions.getCategorie().getId()+" "+transactions.getPersonne().getName());
        }*/


        //transactionsController.create();

    }
}
