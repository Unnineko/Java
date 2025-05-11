package com.company;

import java.util.Scanner;

public class RaceTrack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalSegments = scanner.nextInt(); //общее число участков
        int transferTime = scanner.nextInt();  //время переезда между дорогами

        long timeOnA = 0;           //время достижения начальной точки A
        long timeOnB = transferTime; //время достижения начальной точки B после переезда

        for (int i = 0; i < totalSegments; i++) {
            int segmentA = scanner.nextInt();
            int segmentB = scanner.nextInt();

            long updatedTimeA = timeOnA + segmentA; //продолжить по дороге A
            long updatedTimeB = Math.min(
                    timeOnB + segmentB,                 //продолжить по дороге B
                    timeOnA + transferTime + segmentB //переход с A на B
            );

            timeOnA = updatedTimeA;
            timeOnB = updatedTimeB;
        }

        System.out.println(Math.min(timeOnA, timeOnB));
        scanner.close();
    }
}