import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(malesOnly(Person.persons()));
        names(Person.persons()).forEach(System.out::println);
        sortedByIncomeDes().forEach(System.out::println);
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

    static List<Person> sortedByIncomeDes(){
        List<Person> sortedList = Person.persons().stream()
                .sorted(Comparator.comparing(Person::getIncome).reversed())
                .toList();
        return sortedList;
    }
}
