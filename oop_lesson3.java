import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class УчебнаяГруппа {
    // Поля и методы для учебной группы
}

class Поток implements Iterable<УчебнаяГруппа> {
    private List<УчебнаяГруппа> группы;

    public Поток() {
        группы = new ArrayList<>();
    }

    // Добавление группы в поток
    public void добавитьГруппу(УчебнаяГруппа группа) {
        группы.add(группа);
    }

    // Реализация метода Iterable
    @Override
    public java.util.Iterator<УчебнаяГруппа> iterator() {
        return группы.iterator();
    }
}

class StreamComparator implements Comparator<Поток> {
    @Override
    public int compare(Поток поток1, Поток поток2) {
        // Сравнение по количеству групп в потоке
        return Integer.compare(поток1.группы.size(), поток2.группы.size());
    }
}

class ПотокСервис {
    // Метод для сортировки списка потоков
    public void сортироватьПотоки(List<Поток> потоки) {
        потоки.sort(new StreamComparator());
    }
}

class Контроллер {
    private ПотокСервис потокСервис;

    public Контроллер() {
        потокСервис = new ПотокСервис();
    }

    // Метод для сортировки списка потоков
    public void сортироватьПотоки(List<Поток> потоки) {
        потокСервис.сортироватьПотоки(потоки);
    }
}

public class Main {
    public static void main(String[] args) {
        // Пример использования
        Поток поток1 = new Поток();
        // Добавление групп в поток1

        Поток поток2 = new Поток();
        // Добавление групп в поток2

        List<Поток> потоки = new ArrayList<>();
        потоки.add(поток1);
        потоки.add(поток2);

        Контроллер контроллер = new Контроллер();
        контроллер.сортироватьПотоки(потоки);

        // Теперь потоки отсортированы по количеству групп
    }
}
