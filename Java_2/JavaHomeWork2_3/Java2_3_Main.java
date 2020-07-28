import java.util.*;

public class Java2_3_Main {
    /*
        1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
        Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        Посчитать сколько раз встречается каждое слово.
     */
    public static void main(String[] args) {
        ArrayList<String> wordsArray = new ArrayList<>();
        wordsArray.add("Apple");
        wordsArray.add("Avocado");
        wordsArray.add("Apricot");
        wordsArray.add("Banana");
        wordsArray.add("Date");
        wordsArray.add("Fig");
        wordsArray.add("Grapefruit");
        wordsArray.add("Grapes");
        wordsArray.add("Kiwi");
        wordsArray.add("Lime");
        wordsArray.add("Apple");
        wordsArray.add("Lemon");
        wordsArray.add("Apricot");
        wordsArray.add("Mango");
        wordsArray.add("Date");
        wordsArray.add("Melon");
        wordsArray.add("Grapefruit");
        wordsArray.add("Nectarine");
        wordsArray.add("Kiwi");
        wordsArray.add("Orange");
        wordsArray.add("Orange");
        wordsArray.add("Orange");
        wordsArray.add("Orange");
        wordsArray.add("Orange");
        wordsArray.add("Orange");

        System.out.println("Изначальный список");
        System.out.println(wordsArray);
        System.out.println();

        System.out.println("Список без дубликатов, с указанием количества элементов");
        System.out.println(findDuplicate(wordsArray));
    }

    public static ArrayList findDuplicate(ArrayList arrayList){
        for (int i = 0; i < arrayList.size(); i++) {
            int itemCount = 1;
            while (Collections.frequency(arrayList, arrayList.get(i)) > 1) {
                arrayList.remove(arrayList.lastIndexOf(arrayList.get(i)));
                itemCount += 1;
            }
            arrayList.set(i, arrayList.get(i) + " - " + itemCount);
        }
        return arrayList;
    }
}
