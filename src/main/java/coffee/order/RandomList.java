package coffee.order;


import java.util.ArrayList;
import java.util.List;

public class RandomList {
    public static final List<String> CLIENTS_LIST =
            List.of("Роман", "Сергій", "Олександр", "Віталій", "Андрій", "Кристина", "Анна", "Ольга", "Дмитро");

    public static List<String> getList(List<String> clients, int countClients) {
        ArrayList<String> arrayList = new ArrayList<>(countClients);
        for (int i = 0; i < countClients; i++) {
            arrayList.add(clients.get((int) (Math.random() * clients.size())));
        }
        return arrayList;
    }

    public static String client(List<String> clients) {
        return clients.get((int) (Math.random() * clients.size()));
    }
}
