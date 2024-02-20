package ru.Sberbank;

import ru.Sberbank.LessonCollection.Person;
import ru.Sberbank.LogHandler.LogWriter;
import ru.Sberbank.LogHandler.TargetFiles;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class App {


    static String file = "D:\\JLearn\\Terehov\\src\\test\\java\\ru\\Sberbank\\LogHandler\\Logs.json";
    static TargetFiles tf = new TargetFiles();
    static LogWriter lw = new LogWriter();

    public static void main(String[] args) {

//        Person vasya = new Person(1, "Vasya", "Pupkin", 10);
//        Person petya = new Person(2, "Petya", "Sidorov", 20);
//        Person sidor = new Person(3, "Sidor", "Petrov", 30);
//
//        HashSet<Person> hashPersons = new HashSet<>();
//        hashPersons.add(vasya);
//        hashPersons.add(new Person(3, "Kolya", "Ivanov", 40));
//
//        HashMap<Integer, Person> mapPersons = new HashMap<>();
//        mapPersons.put(3, new Person(3, "Kolya", "Ivanov", 40));
//        mapPersons.put(vasya.getId(), vasya);
//        mapPersons.put(petya.getId(), petya);
//        mapPersons.put(sidor.getId(), sidor);
//
//        writeObject(petya, "D:\\JLearn\\Terehov\\person.dat");
//        Person readed = readObject("D:\\JLearn\\Terehov\\person.dat");
//        System.out.println(readed.getFirstName());
//        writeObjectAsJson(vasya, "D:\\JLearn\\Terehov\\person.txt");
//        Person personFromJsonFile = readJson("D:\\JLearn\\Terehov\\person.json");
//        System.out.println(personFromJsonFile.toString());


        List<TargetFiles> listOfLogs = tf.logList(file);
        lw.writeLog(listOfLogs);

    }


//    public static Person readJson(String fileName) {
//        try {
//            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//            return mapper.readValue(new File(fileName), Person.class);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return new Person(0, "", "", 0);
//        }
//    }
//
//    public static void writeObjectAsJson(Object obj, String fileName) {
//        try {
//            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//            mapper.writeValue(new File(fileName), obj);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }

    public static void writeObject(Person p, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(p);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Person readObject(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Person) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return new Person(0, "", "", 0);
        }
    }

    public static void writeFile() {
        File hello = new File("D:\\JLearn\\Terehov\\hello.txt");
        try {
            String text = "Привет";
            long lastModified = hello.lastModified();
            try (FileOutputStream inFile = new FileOutputStream(hello)) {
                byte[] buffer = text.getBytes(StandardCharsets.UTF_8);
                inFile.write(buffer);
            }
            System.out.println(new Date(lastModified));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile() {
        ArrayList<Byte> b = new ArrayList<>();
        ArrayList<Character> text = new ArrayList<>();
        HashMap<Byte, Character> table = new HashMap<>();
        String str = "";
        try {
            try (FileInputStream fileForRead = new FileInputStream("D:\\JLearn\\Terehov\\hello.txt")) {
                System.out.println("Размер файла: " + fileForRead.available());
                int i;

                while ((i = fileForRead.read()) != -1) {
                    b.add((byte) i);
                    text.add((char) i);
                    table.put((byte) i, (char) i);
                    str += (char) i;
                }
            }
        } catch (IOException ex) {
        }
        System.out.print(b + "\n");
        System.out.print(text + "\n");
        System.out.println(table);
        System.out.println(str);
    }

    public static void readFile2() {
        try {
            try (FileInputStream filereader = new FileInputStream("D:\\JLearn\\Terehov\\hello.txt")) {
                byte[] text = new byte[filereader.available()];
                filereader.read(text);
                System.out.println(new String(text, StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
        }
    }

    public static void writeTextFile() {
        try {
            try (FileWriter fw = new FileWriter("D:\\JLearn\\Terehov\\hello.txt")) {
                String text = "hello, Vasya\nhello, Petya";
                fw.write(text);
                fw.flush();
            }
        } catch (IOException e) {
        }
    }

    public static void readTextFile() {
        try {
            try (FileReader fr = new FileReader("D:\\JLearn\\Terehov\\hello.txt")) {
                BufferedReader reader = new BufferedReader(fr);
                String line;
                StringBuilder sb = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                System.out.println(sb);
            }
        } catch (IOException e) {
        }
    }

    public static void simpleReadFile() {
        try {
            List<String> allLines = Files.readAllLines(Paths.get("D:\\JLearn\\Terehov\\hello.txt"));
            allLines.forEach(line -> {
                System.out.println(line);
            });
        } catch (IOException e) {
        }
    }

    public static void anotherOneRead() {
        try {
            String file = "D:\\JLearn\\Terehov\\hello.txt";
            String content = Files.lines(Paths.get(file)).reduce("", String::concat);
            System.out.println(content);
        } catch (IOException e) {
        }
    }
}