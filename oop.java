import java.util.LinkedList;
import java.util.Queue;

public class Market implements QueueBehaviour, MarketBehaviour {
    private Queue<Human> queue; // Очередь людей
    private Queue<Order> orders; // Очередь заказов

    public Market() {
        queue = new LinkedList<>();
        orders = new LinkedList<>();
    }

    @Override
    public void addToQueue(Human human) {
        queue.add(human);
        System.out.println(human.getName() + " добавлен в очередь.");
    }

    @Override
    public void removeFromQueue(Human human) {
        if (queue.contains(human)) {
            queue.remove(human);
            System.out.println(human.getName() + " удален из очереди.");
        } else {
            System.out.println(human.getName() + " не найден в очереди.");
        }
    }

    @Override
    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println("Заказ " + order.getId() + " принят.");
    }

    @Override
    public Order getNextOrder() {
        return orders.poll();
    }

    @Override
    public void update() {
        // Логика обновления состояния магазина
        System.out.println("Состояние магазина обновлено.");
    }
}
