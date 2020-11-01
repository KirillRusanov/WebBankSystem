package banksystem.service;

import banksystem.dao.DAO;
import banksystem.entity.Card;
import banksystem.entity.Client;
import banksystem.entity.Count;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static final DAO DAO = new DAO(HibernateUtil.getSessionFactory());

    public static final Scanner scanner = new Scanner(System.in);

    public static void selectionMenu() {
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

    public static void createMenu() {
        System.out.println("Creating the starter kit");
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
        DAO.create(client);
        System.out.println("Create an count...");
        Count count = new Count();
        System.out.println("Input number");
        count.setNumber(scanner.next());
        System.out.println("Input currency");
        count.setCurrency(scanner.next());
        System.out.println("Input start balance");
        count.setBalance(scanner.nextInt());
        count.setClient(client);
        DAO.create(count);
        System.out.println("Create an card...");
        Card card = new Card();
        System.out.println("Input number card");
        card.setNumber(scanner.next());
        System.out.println("Input number pin");
        card.setPin(scanner.next());
        card.setTerm(new Date(1924L));
        card.setCount(count);
        DAO.create(card);
        selectionMenu();
    }

    public static void readMenu() {
        System.out.println("which load: \n" +
                "1 - clients\n" +
                "2 - counts\n" +
                "3 - cards");
        switch (scanner.nextInt()) {
            case 1:
                System.out.println("Введите id:");
                Client client = DAO.read(Client.class, scanner.nextLong());
                System.out.print(client.getName() + " ");
                System.out.print(client.getSurname() + " ");
                System.out.print(client.getAddress() + " ");
                System.out.print(client.getPass_number() + " ");
                System.out.println(client.getPhone_number());
                selectionMenu();
                break;
            case 2:
                System.out.println("Введите id:");
                Count count = DAO.read(Count.class, scanner.nextLong());
                System.out.print(count.getBalance() + " ");
                System.out.print(count.getNumber() + " ");
                System.out.print(count.getCurrency() + " ");
                System.out.println(count.getClient());
                selectionMenu();
                break;
            case 3:
                System.out.println("Введите id:");
                Card card = DAO.read(Card.class, scanner.nextLong());
                System.out.print(card.getNumber() + " ");
                System.out.println(card.getPin());
                selectionMenu();
                selectionMenu();
                break;
        }
    }

    public static void updateMenu() {
        System.out.println("which update object: \n" +
                "1 - clients\n" +
                "2 - counts\n" +
                "3 - cards");
        switch (scanner.nextInt()) {
            case 1:
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
                client.setBirthday(new Date(1924L));
                DAO.update(client);
                break;
            case 2:
                Count count = new Count();
                System.out.println("Input number");
                count.setNumber(scanner.next());
                System.out.println("Input currency");
                count.setCurrency(scanner.next());
                System.out.println("Input start balance");
                count.setBalance(scanner.nextInt());
                DAO.update(count);
                break;
            case 3:
                Card card = new Card();
                System.out.println("Input number card");
                card.setNumber(scanner.next());
                System.out.println("Input number pin");
                card.setPin(scanner.next());
                DAO.update(card);
                break;
        }
    }

    public static void removeMenu() {
        System.out.println("which delete: \n" +
                "1 - clients\n" +
                "2 - counts\n" +
                "3 - cards");
        switch (scanner.nextInt()) {
            case 1:
                System.out.println("Which delete by ID");
                Client client = DAO.read(Client.class, scanner.nextLong());
                DAO.delete(client);
                selectionMenu();
                break;
            case 2:
                System.out.println("Which delete by ID");
                Count count = DAO.read(Count.class, scanner.nextLong());
                DAO.delete(count);
                selectionMenu();
                break;
            case 3:
                System.out.println("Which delete by ID");
                Card card = DAO.read(Card.class, scanner.nextLong());
                DAO.delete(card);
                selectionMenu();
                break;
        }


    }

    public static void getAll() {

        System.out.println("Get All:\n" +
                "1 - clients\n" +
                "2 - counts\n" +
                "3 - cards");
        switch (scanner.nextInt()) {
            case 1:
                List<Client> clients = DAO.getAll(Client.class);
                for (Client c : clients) {
                    System.out.print(c.getName());
                    System.out.println(" " + c.getSurname());
                }
                selectionMenu();
                break;
            case 2:
                List<Count> counts = DAO.getAll(Count.class);
                for (Count c : counts) {
                    System.out.print(c.getNumber());
                    System.out.println(" - Balance: " + c.getBalance());
                }
                selectionMenu();
                break;
            case 3:
                List<Card> cardList = DAO.getAll(Card.class);
                for (Card c : cardList) {
                    System.out.println(c.getNumber());
                }
                selectionMenu();
                break;
        }
    }
}