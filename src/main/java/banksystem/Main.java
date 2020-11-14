package banksystem;

import banksystem.service.Menu;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        Menu menu = context.getBean("menuBean", Menu.class);
        menu.selectionMenu();


    }
}