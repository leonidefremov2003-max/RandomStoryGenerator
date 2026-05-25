package org.example;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    static ArrayList<String> characters = new ArrayList<>();     // Создаём коллекцию для имён (порядок не важен, значения уникальны)
    static ArrayList<String> actions = new ArrayList<>();        // Создаём коллекцию для действий (порядок не важен, значения уникальны)
    static ArrayList<String> places = new ArrayList<>();        // Создаём коллекцию для мест (порядок не важен, значения уникальны)

    static ArrayList<String> storiesList = new ArrayList<>(); // Создаём коллекцию List для сохранения историй (порядок важен, значения не уникальны)



    public static void main(String[] args) {



        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));

        Scanner scanner = new Scanner(System.in);


        characters.add("Принцесса");             // Создаём 3 элемента (имя)
        characters.add("Гном");
        characters.add("Робот");

        actions.add("танцует");                 // Создаём 3 элемента (действие)
        actions.add("дерётся");
        actions.add("готовит");

        places.add("в лесу");                   // Создаём 3 элемента (место)
        places.add("в космосе");
        places.add("в яме");


        System.out.println("Добро пожаловать в генератор случайных историй!");
        while (true) {

            System.out.println("У нас есть персонажи (" + characters.size() + " шт.), " + "действия (" + actions.size() + " шт.), " + "места (" + places.size() + " шт.).");
            System.out.println("Выберите пункт:");
            System.out.print("1 - Добавить персонажа" + "\n" + "2 - Добавить действие" + "\n" + "3 - Добавить место" + "\n" + "4 - Сгенерировать историю" + "\n" + "5 - Посмотреть все истории" + "\n" + "6 - Выход" + "\n" + "Ваш выбор:");

            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка! Введите число");
                scanner.next();
                continue;
            }

            int inputInt = scanner.nextInt();
            scanner.nextLine();

            if (inputInt == 1) {
                System.out.println("Введите имя нового персонажа:");
                String newCharacters = scanner.nextLine();
                characters.add(newCharacters);
                System.out.println("Добавлен новый персонаж :" + newCharacters);

            } else if (inputInt == 2) {
                System.out.println("Введите новое действие:");
                String newActions = scanner.nextLine();
                actions.add(newActions);
                System.out.println("Добавлено новое действие :" + newActions);
            } else if (inputInt == 3) {
                System.out.println("Введите новое место:");
                String newPlaces = scanner.nextLine();
                places.add(newPlaces);
                System.out.println("Добавлено новое место :" + newPlaces);
            } else if (inputInt == 4) {
                String story = generateStory();
                storiesList.add(story);
            } else if (inputInt == 5) {
                if (storiesList.isEmpty()) {
                    System.out.println("Историй пока нет! Сгенерируйте хотя бы одну историю");
                } else {
                    for (String s : storiesList) {
                        System.out.println(s);
                    }
                }
            } else if (inputInt == 6) {
                System.out.println("До свидания");
                break;
            }

        }
        scanner.close();








        }

    static String generateStory() {

        String randomCharacters = characters.get(ThreadLocalRandom.current().nextInt(characters.size()));
        String randomActions = actions.get(ThreadLocalRandom.current().nextInt(actions.size()));
        String randomPlaces = places.get(ThreadLocalRandom.current().nextInt(places.size()));

        System.out.println("Сгенерированная история: " + randomCharacters + " " + randomActions + " " + randomPlaces);




        return randomCharacters + " " + randomActions + " " + randomPlaces;
    }

}
