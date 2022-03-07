package Menu;

import InputData.RecordInputData;
import Util.OperationStatistic;

import java.util.Scanner;
public class Menu {
    public static void getMenus() {
        while (true) {
            getPrintMenu();
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    System.out.println("Введите месяц");
                    int month = scanner.nextInt();
                    System.out.println("Введите день");
                    int day = scanner.nextInt();
                    System.out.println("Введите количество пройденных шагов");
                    int step = scanner.nextInt();
                    RecordInputData.getInputData(month, day, step);
                    break;
                case "2":
                    System.out.println("Введите месяц");
                    int mounth = scanner.nextInt();
                    OperationStatistic.getPrintStatistics(mounth);
                    break;
                case "3":
                    System.out.println("Введите новое значения цели по шагам");
                    int newTargetStep = scanner.nextInt();
                    OperationStatistic.getNewTargetStep(newTargetStep);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Такой команды не существует, повторите свой выбор");
                    break;
            }
        }
    }

    public static void getPrintMenu() {
        System.out.println("1 - Количество количество шагов за определённый день;");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");
        System.out.print("Выберите комманду  ");
    }
}