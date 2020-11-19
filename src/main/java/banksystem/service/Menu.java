package banksystem.service;

import banksystem.model.Card;
import banksystem.model.Client;
import banksystem.model.Count;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;
@Component
public class Menu {

    private Scanner scanner;
    private ClientService clientService;
    private CountService countService;
    private CardService cardService;

    @Autowired
    public Menu(CardService cardService, ClientService clientService, CountService countService) {
        this.cardService = cardService;
        this.clientService = clientService;
        this.countService = countService;
        this.scanner = new Scanner(System.in);
    }

    public void selectionMenu() {
        System.out.println("-----------\n" +
                "BankSystem\n" +
                "1 - Create\n" +
                "2 - Read\n" +
                "3 - Update\n" +
                "4 - Remove\n" +
                "5 - GetAll\n" +
                "-----------\n");
        switch (scanner.nextInt()) {
            case 1:
                createMenu();
                break;
            case 2:
                readMenu();
                break;
            case 3:
                updateMenu();
                break;
            case 4:
                removeMenu();
                break;
            case 5:
                getAll();
                break;
        }
    }

    public void createMenu() {
        System.out.println("What create: \n" +
                "1 - clients\n" +
                "2 - counts\n" +
                "3 - cards");
        switch (scanner.nextInt()) {
            case 1:
                clientService.create(createClient());
                selectionMenu();
                break;
            case 2:
                System.out.println("Input id client by which create: ");
                Client client = clientService.getById(scanner.nextLong());
                countService.create(createCount(client));
                selectionMenu();
                break;
            case 3:
                System.out.println("Input id count by which create: ");
                Count count = countService.getById(scanner.nextLong());
                cardService.create(createCard(count));
                selectionMenu();
                break;
        }
    }

    public void readMenu() {
        System.out.println("which load: \n" +
                "1 - clients\n" +
                "2 - counts\n" +
                "3 - cards");
        switch (scanner.nextInt()) {
            case 1:
                System.out.println("Input id:");
                Client client = clientService.getById(scanner.nextLong());
                System.out.print(client.getName() + " ");
                System.out.print(client.getSurname() + " ");
                System.out.print(client.getAddress() + " ");
                System.out.print(client.getPass_number() + " ");
                System.out.println(client.getPhone_number());
                selectionMenu();
                break;
            case 2:
                System.out.println("Input id:");
                Count count = countService.getById(scanner.nextLong());
                System.out.print(count.getBalance() + " ");
                System.out.print(count.getNumber() + " ");
                System.out.print(count.getCurrency() + " ");
                System.out.println(count.getClient_id());
                selectionMenu();
                break;
            case 3:
                System.out.println("Input id:");
                Card card = cardService.getById(scanner.nextLong());
                System.out.print(card.getNumber() + " ");
                System.out.println(card.getPin());
                selectionMenu();
                selectionMenu();
                break;
        }
    }

    public void updateMenu() {
        System.out.println("which update object: \n" +
                "1 - clients\n" +
                "2 - counts\n" +
                "3 - cards");
        switch (scanner.nextInt()) {
            case 1:
                System.out.println("Input id which want update");
                Client client = clientService.getById(scanner.nextLong());
                System.out.println("Input name");
                client.setName(scanner.next());
                System.out.println("Input surname");
                client.setSurname(scanner.next());
                System.out.println("Input patronymic");
                client.setPatronymic(scanner.next());
                System.out.println("Input address");
                client.setAddress(scanner.next());
                System.out.println("Input pass number");
                client.setPass_number(scanner.next());
                System.out.println("Input phone number");
                client.setPhone_number(scanner.next());
                client.setBirthday(new Date(1924L));
                clientService.update(client);
                break;
            case 2:
                Count count = new Count();
                System.out.println("Input number");
                count.setNumber(scanner.next());
                System.out.println("Input currency");
                count.setCurrency(scanner.next());
                System.out.println("Input start balance");
                count.setBalance(scanner.nextInt());
                countService.update(count);
                break;
            case 3:
                Card card = new Card();
                System.out.println("Input number card");
                card.setNumber(scanner.next());
                System.out.println("Input number pin");
                card.setPin(scanner.next());
                cardService.update(card);
                break;
        }
    }

    public void removeMenu() {
        System.out.println("which delete: \n" +
                "1 - clients\n" +
                "2 - counts\n" +
                "3 - cards");
        switch (scanner.nextInt()) {
            case 1:
                System.out.println("Which delete by ID");
                Client client = clientService.getById(scanner.nextLong());
                clientService.delete(client);
                selectionMenu();
                break;
            case 2:
                System.out.println("Which delete by ID");
                Count count = countService.getById(scanner.nextLong());
                countService.delete(count);
                selectionMenu();
                break;
            case 3:
                System.out.println("Which delete by ID");
                Card card = cardService.getById(scanner.nextLong());
                cardService.delete(card);
                selectionMenu();
                break;
        }


    }

    public void getAll() {

        System.out.println("Get All:\n" +
                "1 - clients\n" +
                "2 - counts\n" +
                "3 - cards");
        switch (scanner.nextInt()) {
            case 1:
                List<Client> clients = clientService.getAll();
                for (Client c : clients) {
                    System.out.print(c.getName());
                    System.out.println(" " + c.getSurname());
                }
                selectionMenu();
                break;
            case 2:
                List<Count> counts = countService.getAll();
                for (Count c : counts) {
                    System.out.print(c.getNumber());
                    System.out.println(" - Balance: " + c.getBalance());
                }
                selectionMenu();
                break;
            case 3:
                List<Card> cardList = cardService.getAll();
                for (Card c : cardList) {
                    System.out.println(c.getNumber());
                }
                selectionMenu();
                break;
        }
    }
    public Client createClient() {
        System.out.println("Create an client account...");
        Client client = new Client();
        System.out.println("Input name");
        client.setName(scanner.next());
        System.out.println("Input surname");
        client.setSurname(scanner.next());
        System.out.println("Input patronymic");
        client.setPatronymic(scanner.next());
        System.out.println("Input address");
        client.setAddress(scanner.next());
        System.out.println("Input pass number");
        client.setPass_number(scanner.next());
        System.out.println("Input phone number");
        client.setPhone_number(scanner.next());
        client.setBirthday(new Date(123123324L));
        return client;
    }
    public Count createCount(Client client) {
        System.out.println("Create an count...");
        Count count = new Count();
        System.out.println("Input number");
        count.setNumber(scanner.next());
        count.setClient_id(client);
        System.out.println("Input currency");
        count.setCurrency(scanner.next());
        System.out.println("Input start balance");
        count.setBalance(scanner.nextInt());
        return count;
    }
    public Card createCard(Count count) {
        System.out.println("Create an card...");
        Card card = new Card();
        System.out.println("Input number card");
        card.setNumber(scanner.next());
        System.out.println("Input number pin");
        card.setPin(scanner.next());
        card.setTerm(new Date(1924L));
        card.setCount(count);
        return card;
    }
}