import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Solution {
    public static void main(String[] args) {
        System.out.println(malesOnly(Person.persons()));
        names(Person.persons()).forEach(System.out::println);
        sortedByIncomeDes().forEach(System.out::println);
        distinctGenders().forEach(System.out::println);
        System.out.println("first three peoples");
        firstThreePeople().forEach(System.out::println);
        System.out.println("list with the first two skipped");
        skippedPeople().forEach(System.out::println);
        System.out.println(isHighIncome());
        System.out.println(isNoZeroIncome());
        System.out.println(countPerson());
        if(personWithHighestIncome().isPresent()){
            Person p = personWithHighestIncome().get();
            System.out.println("Person with high income is --- " + p);
        }


    }

    //challenge 1
    static List<String> malesOnly(List<Person> people){
        people = Person.persons();
        List<String> males = people.stream()
                .filter(Person::isMale)
                .map(Person::getName)
                .toList();
        return males;
    }

    //challenge 2
    static List<String> names(List<Person> people){
        List<String> names = people.stream()
                .map(Person::getName)
                .toList();
        return names;
    }

    //challenge 3
    static List<Person> sortedByIncomeDes(){
        List<Person> sortedList = Person.persons().stream()
                .sorted(Comparator.comparing(Person::getIncome).reversed())
                .toList();
        return sortedList;
    }

    //challenge 4
    static List<Person.Gender> distinctGenders(){
        List<Person.Gender> genders = Person.persons()
                .stream()
                .map(Person::getGender)
                .distinct()
                .toList();
        return genders;
    }
    //challenge 5
    static List<Person> firstThreePeople(){
        List<Person> top3 = Person.persons()
                .stream()
                .limit(3)
                .toList();
        return top3;
    }

    static List<Person> skippedPeople(){
        List<Person> skipped = Person.persons()
                .stream()
                .skip(2)
                .toList();
        return skipped;
    }

    static void displayNames(){
        Person.persons()
                .stream()
                .peek(person -> System.out.println("Person name" + person.getName()))
                .forEach(System.out::println);
    }

    //to check if any person's income is greater than 8000

    static boolean isHighIncome(){
      return  Person.persons()
                .stream()
                .anyMatch(p->p.getIncome() >8000);

    }

    static boolean isAllPeopleAreMale(){
        return Person.persons()
                .stream()
                .allMatch(Person::isMale);
    }

    static boolean isNoZeroIncome(){
        return Person.persons()
                .stream()
                .noneMatch(p->p.getIncome()==0);
    }

    //to count the number of persons
    static long countPerson(){
       return Person.persons()
                .stream()
                .filter(Person::isFemale)
                .count();
    }
    //to find the person with the highest income
    static Optional<Person> personWithHighestIncome(){
        return Person.persons()
                .stream()
                .max(Comparator.comparingDouble(Person::getIncome));
    }

}
