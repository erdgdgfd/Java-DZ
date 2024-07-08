import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

class Laptop {
    String brand;
    int ram; // в ГБ
    int hdd; // в ГБ
    String os;
    String color;

    // Конструктор
    Laptop(String brand, int ram, int hdd, String os, String color) {
        this.brand = brand;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Ноутбук [бренд=" + brand + ", ОЗУ=" + ram + "ГБ, ЖД=" + hdd + "ГБ, ОС=" + os + ", цвет=" + color + "]";
    }
}

public class LaptopStore {
    public static void main(String[] args) {
        // Создаем множество ноутбуков
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Dell", 8, 512, "Windows", "Black"));
        laptops.add(new Laptop("HP", 16, 1024, "Windows", "Silver"));
        laptops.add(new Laptop("Apple", 8, 256, "macOS", "Gray"));
        laptops.add(new Laptop("Asus", 32, 1024, "Windows", "Blue"));
        laptops.add(new Laptop("Lenovo", 4, 128, "Linux", "Black"));

        // Запрашиваем у пользователя критерии фильтрации
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> filters = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        int criterion = scanner.nextInt();
        scanner.nextLine(); // Очистить буфер

        switch (criterion) {
            case 1:
                System.out.print("Введите минимальный объем ОЗУ (в ГБ): ");
                filters.put("ram", scanner.nextInt());
                break;
            case 2:
                System.out.print("Введите минимальный объем ЖД (в ГБ): ");
                filters.put("hdd", scanner.nextInt());
                break;
            case 3:
                System.out.print("Введите операционную систему: ");
                filters.put("os", scanner.nextLine());
                break;
            case 4:
                System.out.print("Введите цвет: ");
                filters.put("color", scanner.nextLine());
                break;
            default:
                System.out.println("Неправильный ввод.");
                return;
        }

        // Фильтруем и выводим ноутбуки
        System.out.println("Подходящие ноутбуки:");
        for (Laptop laptop : laptops) {
            boolean matches = true;
            if (filters.containsKey("ram") && laptop.ram < filters.get("ram")) {
                matches = false;
            }
            if (filters.containsKey("hdd") && laptop.hdd < filters.get("hdd")) {
                matches = false;
            }
            if (filters.containsKey("os") && !laptop.os.equalsIgnoreCase(filters.get("os").toString())) {
                matches = false;
            }
            if (filters.containsKey("color") && !laptop.color.equalsIgnoreCase(filters.get("color").toString())) {
                matches = false;
            }
            if (matches) {
                System.out.println(laptop);
            }
        }
    }
}