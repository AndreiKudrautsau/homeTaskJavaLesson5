import java.util.*;

public class PhoneBook {
    public static void main (String[] args) {
        HashMap<String, ArrayList<String>> contacts = new HashMap<>();
        addContacts(contacts,"Ivanov", "5555");
        addContacts(contacts,"Avalon", "7777");
        addContacts(contacts,"Avalon", "8855");
        addContacts(contacts,"Ivanov", "5555");
        addContacts(contacts,"Petrov", "5555");
        addContacts(contacts,"Petrov", "8888");
        addContacts(contacts,"Sidorov", "9999");
        addContacts(contacts,"Ivanov", "5577");
        addContacts(contacts,"Ivanov", "5667");
        addContacts(contacts,"Avalon", "7997");
        System.out.println(contacts);

        ArrayList<String> lst =new ArrayList<>();
        for (String s : contacts.keySet()) {
            lst.add(s);
        }

        Collections.sort(lst, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return contacts.get(o2).size() - contacts.get(o1).size();
            }
        });

        System.out.println("Отсортированный по количеству номеров у абонента (по убыванию) телефонный справочник: ");
        lst.forEach(n -> System.out.println(n + " : " + contacts.get(n).size() + " - " + contacts.get(n)));
    }
    private static void addContacts(HashMap<String, ArrayList<String>> contacts, String name, String phoneNumber){
        contacts.putIfAbsent(name, new ArrayList<>());
        contacts.get(name).add(phoneNumber);
    }
}
