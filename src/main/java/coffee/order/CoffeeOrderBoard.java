package coffee.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;

public class CoffeeOrderBoard {
    private final LinkedList<Order> orders;
    private static final Logger logger = LoggerFactory.getLogger("logger");

    public CoffeeOrderBoard() {
        orders = new LinkedList<>();
    }

    //3. Реалізувати метод add у класі CoffeeOrderBoard. Даний метод додає нове замовлення
//та надає замовленню номер (натуральний порядок).
//Натуральний порядок (natural ordering) означає, що й у останнього замовлення номер 86,
//то наступний буде 87.
//Не може бути такої ситуації, що номер повторюється у межах одного об'єкта типу CoffeeOrderBoard.
    public boolean add(String name) {
        Order order = new Order(name);
        logger.info(name + " замовив.");
        return orders.add(order);
    }

    //4. Реалізувати метод deliver у класі CoffeeOrderBoard. Цей метод видає найближче у
//черзі замовлення. Видача супроводжується видаленням замовлення зі списку.
    public boolean deliver() {
        if (orders.isEmpty()) {
            System.out.println("\nСписок замовлень пустий, нікого обслуговувати.");
            logger.error("ERROR: Список замовлень пустий, нікого обслуговувати.---");
            return false;
        } else {
            System.out.println("\nОбслуговується перший в черзі, замовлення: " + "№ " +
                    orders.getFirst().getId() + " | " + orders.getFirst().getName() +
                    "\nЗамовлення виконано.");
            logger.info("Замовлення №" + orders.getFirst().getId() + ", " + orders.getFirst().getName() + " отримав");
            return orders.remove(orders.getFirst());
        }
    }

    //5. Реалізувати метод deliver у класі CoffeeOrderBoard. Даний метод видає замовлення
//з певним номером. Видача супроводжується видаленням замовлення зі списку.
//Даний метод обробляє ситуацію, коли замовлення, що надійшло пізніше, готове раніше.
    public boolean deliver(int idOrder) {
        for (Order ord : orders) {
            if (ord.getId() == idOrder) {
                System.out.println("\nОбслуговується замовлення: № " + ord.getId() + " на ім'я " +
                        ord.getName() + "\nЗамовлення виконано.");
                logger.info("Замовлення №" + ord.getId() + ", " + ord.getName() + " отримав");

                return orders.remove(ord);
            }
        }
        System.out.println("\nЗамовлення № " + idOrder + " не існує.\n");
        logger.error("ERROR: замовлення №" + idOrder + " не існує.---");
        return false;
    }

    //6. Реалізувати метод draw у класі CoffeeOrderBoard. Цей метод виводить у консоль інформацію
//про поточний стан черги у порядку найближчого до видачі замовлення.
    public void draw() {
        if (!orders.isEmpty()) {
            System.out.println("\nПорядок видачі замовлень");
            System.out.printf("%s", "_________________________\n");
            System.out.printf("%-12s %s %-5s", "№ замовлення", "|", "Ім'я");
            System.out.printf("\n%s", "_________________________\n");
            for (Order order : orders) {
                System.out.printf("%-12d %s %5s", order.getId(), "|", order.getName() + "\n");
            }
            System.out.printf("%s", "_________________________\n");
        }
    }

    public void closeCaffe() {
        if (!orders.isEmpty()) {
            logger.error("ERROR: Ще не всі клієнти обслужені, не можна закривати кафе.");
        } else logger.info("Кафе зачинено.");

    }

    @Override
    public String toString() {
        return "CoffeeOrderBoard{" +
                "orders=" + orders +
                '}';
    }
}
