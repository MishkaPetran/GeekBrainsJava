public class HomeWork5_OOP {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new Employee(
                "Иванов Иван Иванович",
                "Директор",
                "ivanov_ii@mail.ru",
                "+7 (1234) 567-890",
                10000,
                55);

        employees[1] = new Employee(
                "Петров Петр Петрович",
                "Заместитель директора",
                "petrov_pp@mail.ru",
                "+7 (1234) 567-891",
                8000,
                50);

        employees[2] = new Employee(
                "Галкина Галина Геннадьевна",
                "Главный бухгалтер",
                "galkina_gg@mail.ru",
                "+7 (1234) 567-892",
                7000,
                45);

        employees[3] = new Employee(
                "Федорова Федосья Федоровна",
                "Ведущий инженер",
                "fedorova_ff@mail.ru",
                "+7 (1234) 567-893",
                6500,
                30);

        employees[4] = new Employee(
                "Путин Владимир Владимирович",
                "Уборщик",
                "no-email@mail.ru",
                "+7 (1234) 003-003",
                37.5,
                25);

        overForty(employees);

    }

    public static void overForty(Employee[] array){
        System.out.println("Работники старше 40 лет:");
        for (int i = 0; i < array.length; i++) {
            if (array[i].getAge() >= 40){
                System.out.println(array[i].toString());
            }
        }
    }
}
