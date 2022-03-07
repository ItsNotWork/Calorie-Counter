package Util;

import InputData.RecordInputData;
import java.util.Collections;

public class OperationStatistic {
    private static int targetStep = 10000;

    @Override
    public String toString() {
        return "OperationStatistic{" +
                "targetStep=" + targetStep +
                '}';
    }

    public static void getPrintStatistics(int month) {  // Monthly statistics printing
        if (month < 0) {
            System.out.println("Введены не корректные данные");
            return;
        }
        System.out.printf("Общая статистика за %s\n", RecordInputData.getNameMount(month));
        int sumSteps = 0;
        int bestOne = 0;
        int bestSeria = 0;
        for (int i = 1; i <= 30; i++) {
            if (RecordInputData.dataInput.get(month).get(i) != 0) {
                System.out.printf("За %s день пройдено %s шага(ов)\n", (i),
                        RecordInputData.dataInput.get(month).get(i));
            }
        }
        for (Integer steps : RecordInputData.dataInput.get(month).values()) {
            sumSteps += steps;
            if (steps >= targetStep) {
                bestOne++;
            } else if (bestOne < bestSeria) {
                bestOne = 0;
            } else if (bestOne > bestSeria) {
                bestSeria = bestOne;
            }
        }
        System.out.printf("Всего за пройдено %d шагов\n", sumSteps);
        System.out.printf("Максимальное количество %s шагов \n",
                Collections.max(RecordInputData.dataInput.get(month).values()));
        System.out.printf("Среднее количество шагов %.2f\n",
                (sumSteps / (RecordInputData.dataInput.get(month).size() * 1.0)));
        System.out.printf("Пройденная дистанция составляет %s киллометров\n",
                Converter.getStepToKilometer(sumSteps));
        System.out.printf("Количество сожжённых килокалорий %s\n",
                Converter.getStepToKilocalories(sumSteps),
                RecordInputData.getNameMount(month));
        System.out.printf("Лучшая серия шагов %d\n", bestSeria);
    }

    public static void getNewTargetStep(int newTargetSteps) {  // New target step
        if (newTargetSteps < 0) {
            System.out.println("Введены не корректные данные");
        }
        targetStep = newTargetSteps;
        System.out.println("Вы изменили цель по шагам на " + newTargetSteps);
    }
}



