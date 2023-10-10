import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(malesOnly(Person.persons()));
        names(Person.persons()).forEach(System.out::println);
        sortedByIncomeDes().forEach(System.out::println);
        distinctGenders().forEach(System.out::println);
        firstThreePeople().forEach(System.out::println);
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

}
