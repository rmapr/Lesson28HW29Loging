package coffee.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.List;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger("logger");

    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        int clients = 15;
        logger.info("-----------------------Новий день--------------------------");
        logger.info("Відкриття кафе."+ new Timestamp(System.currentTimeMillis()));
        List<String> listName = RandomList.getList(RandomList.CLIENTS_LIST, clients);
        logger.info("Список замовленнь:");
        for (int i = 0; i < clients; i++){
            coffeeOrderBoard.add(RandomList.client(listName));
        }
        coffeeOrderBoard.draw();
        System.out.println("Обслуговуються всі непарні");
        logger.info("----------------Видача замовленнь----------------");
        for (int i = 1; i <= clients; i++){
            if (i % 2 != 0) {
                coffeeOrderBoard.deliver(i);
            }
        }
        logger.info("-------------------------------------------------");
        int numOrder = 5;
        coffeeOrderBoard.deliver(numOrder);
        coffeeOrderBoard.draw();
        coffeeOrderBoard.deliver();
        coffeeOrderBoard.draw();

        logger.info("Закриття кафе." + new Timestamp(System.currentTimeMillis()));
//        Просто інформативне повідомлення у випадку якщо ще є кого обслуговувати,
//        можно закоментувати рядки: 26, 28 трохи інші результати виконання
        coffeeOrderBoard.closeCaffe();
    }
}
