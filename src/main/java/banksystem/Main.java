package banksystem;

import banksystem.repository.ClientRepository;
import banksystem.service.CardService;
import banksystem.service.ClientService;
import banksystem.service.CountService;
import banksystem.service.Menu;


public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu(new CardService(),new ClientService(new ClientRepository()), new CountService());
        menu.selectionMenu();
    }
}