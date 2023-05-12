/*
Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
 */


package seminar5;

public class task1 {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Василий", "123456789");
        phoneBook.add("Василий", "2145");
        phoneBook.add("Игорь", "1234567890");
        phoneBook.add("Игорь", "123456789");
        phoneBook.add("Алексей", "56688");
        phoneBook.add("Дмитрий", "5484");
        System.out.println(phoneBook);
//        System.out.println(phoneBook.searchName("Василий"));
//        System.out.println(phoneBook.searchName("Васили1й"));
//        System.out.println(phoneBook.searchPhone("123456789"));
//        System.out.println(phoneBook.searchPhone("21450"));
//        System.out.println(phoneBook.deleteName("Дмитрий"));
//        System.out.println(phoneBook);
//        System.out.println(phoneBook.deletePhone("123456789"));
//        System.out.println(phoneBook);

    }
}
