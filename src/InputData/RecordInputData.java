package InputData;

import java.util.ArrayList;
import java.util.HashMap;

public class RecordInputData {

    private final int numberMount;
    private final int day;
    private final int step;
    public static ArrayList<HashMap<Integer, Integer>> dataInput = new ArrayList<>();

    static {
        for (int i = 0; i < 12; i++) {
            HashMap<Integer, Integer> tempMap = new HashMap<>();
            for (int j = 1; j <= 30; j++) {
                tempMap.put(j, 0);
            }
            dataInput.add(tempMap);
        }
    }

    public RecordInputData(int numberMount, int day, int step) {
        dataInput.get(numberMount).put(day, step);
        this.numberMount = numberMount;
        this.day = day;
        this.step = step;
    }

    @Override
    public String toString() {
        return "RecordInputData{" +
                "month=" + numberMount +
                ", day=" + day +
                ", step=" + step +
                '}';
    }
    public static String getNameMount(int month) {
        return switch (month) {
            case 1 -> "Январь";
            case 2 -> "Февраль";
            case 3 -> "Март";
            case 4 -> "Апрель";
            case 5 -> "Май";
            case 6 -> "Июнь";
            case 7 -> "Июль";
            case 8 -> "Август";
            case 9 -> "Сентябрь";
            case 10 -> "Октябрь";
            case 11 -> "Ноябрь";
            case 12 -> "Декабрь";
            default -> "";
        };
    }

    public static void getInputData(int month, int day, int step) {  // incoming data from the scanner
        if ( month > 13 || month < 0| day > 31 || day < 0 || step < 0){
            System.out.println("Введены не корректные данные");
            return;
        }
        dataInput.get(month).put(day, dataInput.get(month).get(day) + step);
        System.out.println("Информация сохранена");
    }
}