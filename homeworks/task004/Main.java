import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        long counter = persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.printf("Кол-во несовершеннолетних - %d", counter);

        List<String> armyList = persons.stream()
                .filter(person -> person.getSex().equals(Sex.MAN))
                .filter(person -> person.getAge() >= 19)
                .filter(person -> person.getAge() <= 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println("Список призывников: " + "\n" + armyList);

        List<Person> workers= persons.stream()
                .filter(person -> person.getEducation().equals(Education.HIGHER))
                .filter(person -> person.getAge() >= 18)
                .filter(person -> (person.getSex().equals(Sex.MAN) && person.getAge() < 65)
                        || (person.getSex().equals(Sex.WOMAN) && person.getAge() < 60))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());

        System.out.println("\nСписок потенциально работоспособных людей с высшим образованием:" + workers);

    }

}