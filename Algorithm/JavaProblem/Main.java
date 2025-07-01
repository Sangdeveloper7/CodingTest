package JavaProblem;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        C11();
    }

    static void A01() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a birth year > ");
        int birth_year = Integer.parseInt(br.readLine());
        int age = 2024 - birth_year + 1;
        System.out.println("You are " + age + " year's old.");
    }

    static void A02() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Celsius temperature > ");
        double c_degree = Double.parseDouble(br.readLine());
        double f_degree = c_degree * 1.8 + 32;
        System.out.println("Fahrenheit temperature is " + f_degree + ".");
    }

    static void A03() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter width of Rectangle > ");
        int width = Integer.parseInt(br.readLine());

        System.out.print("Enter height of Rectangle > ");
        int height = Integer.parseInt(br.readLine());

        int area = width * height;
        System.out.println("Area of Rectangle is " + area);
    }

    static void A04() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter area of Apartment(m^2) > ");
        double m2_area = Double.parseDouble(br.readLine());
        double pyung_area = m2_area / 3.305;

        System.out.println("Area of Apartment(평수) " + pyung_area);
    }

    static void A05() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of days > ");
        int days = Integer.parseInt(br.readLine());
        int seconds = days * 24 * 60 * 60;

        System.out.println("Total seconds is " + seconds);
    }

    static void A06() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter points of Korean > ");
        int kor = Integer.parseInt(br.readLine());
        System.out.print("Enter points of English > ");
        int eng = Integer.parseInt(br.readLine());
        System.out.print("Enter points of Math > ");
        int math = Integer.parseInt(br.readLine());

        int total = kor + eng + math;
        double average = (double) total / 3;

        System.out.println("Total point is " + total);
        System.out.println("The average is " + average);
    }

    static void A07() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter file size as gigabytes > ");

        int gigabytes = Integer.parseInt(br.readLine());
        int megabytes = gigabytes * 1024;
        int kilobytes = megabytes * 1024;
        long bytes = (long) kilobytes * 1024;

        System.out.println("Your file size is");
        System.out.println(megabytes + " MB");
        System.out.println(kilobytes + " KB");
        System.out.println(bytes + " B");
    }

    static void B01() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a birth year > ");
        int birth_year = Integer.parseInt(br.readLine());
        int age = 2024 - birth_year + 1;
        System.out.println(age >= 20 ? "You are adult" : "You are not adult");
    }

    static void B02() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter temperature > ");
        double input_degree = Double.parseDouble(br.readLine());
        System.out.print("Enter type of temperature('C' for Celsius, 'F' for Fahrenheit) ");
        String kind = br.readLine();
        System.out.println("Fahrenheit temperature is " + (kind.equals('C') ? (input_degree - 32) * 1.8 : input_degree * 1.8 + 32));
    }

    static void B03() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter width of Rectangle > ");
        int width = Integer.parseInt(br.readLine());

        System.out.print("Enter height of Rectangle > ");
        int height = Integer.parseInt(br.readLine());

        int area = width * height;
        System.out.print("Area of Rectangle is " + area);
        System.out.println(" and \n" + (width == height ? "it is square " : "it is not square"));
    }

    static void B04() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter area of Apartment(m^2) > ");
        double m2_area = Double.parseDouble(br.readLine());
        double pyung_area = m2_area / 3.305;

        System.out.println("Area of Apartment(평수) " + pyung_area);
        System.out.println(pyung_area < 30 ? "It is small apartment " : "It is big apartment ");
    }

    static void B05() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of days > ");
        int days = Integer.parseInt(br.readLine());
        int seconds = days * 24 * 60 * 60;

        System.out.println("Total seconds is " + seconds);
        System.out.println(seconds > 1_000_000 ? "It includes million seconds " + seconds / 1_000_000 + " times" : "");
    }

    static void B06() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter points of Korean > ");
        int kor = Integer.parseInt(br.readLine());
        System.out.print("Enter points of English > ");
        int eng = Integer.parseInt(br.readLine());
        System.out.print("Enter points of Math > ");
        int math = Integer.parseInt(br.readLine());

        int total = kor + eng + math;
        double average = (double) total / 3;

        System.out.println("Total point is " + total);
        System.out.println("The average is " + average);
        System.out.println(kor > 90 ? "Korean grade is outstanding!" : "");
        System.out.println(eng > 90 ? "English grade is outstanding!" : "");
        System.out.println(math > 90 ? "Math grade is outstanding!" : "");
    }

    static void B07() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter file size as megabytes > ");

        int megabytes = Integer.parseInt(br.readLine());
        int kilobytes = megabytes * 1024;
        long bytes = (long) kilobytes * 1024;

        System.out.print("Enter 'Y' if USB type is 2.0 or 'N' > ");
        String usb2 = br.readLine();

        System.out.print("File transfer time is ");
        System.out.println(usb2.equals("Y") ? bytes / 60_000_000 : bytes / 1_500_000);
    }

    static void B08() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> hset = new HashSet<>();

        System.out.print("Enter first number ");
        int num1 = Integer.parseInt(br.readLine());
        System.out.print("Enter second number ");
        int num2 = Integer.parseInt(br.readLine());
        System.out.print("Enter third number ");
        int num3 = Integer.parseInt(br.readLine());

        hset.add(num1);
        hset.add(num2);
        hset.add(num3);
        if (hset.size() < 3) {
            System.out.println("Satisfies the first condition");
        }

        int countOver50 = 0;
        if (num1 > 50) countOver50++;
        if (num2 > 50) countOver50++;
        if (num3 > 50) countOver50++;
        if (countOver50 >= 2) {
            System.out.println("Satisfies the second condition");
        }

        if (num1 + num2 == num3 || num1 + num3 == num2 || num2 + num3 == num1) {
            System.out.println("Satisfies the third condition");
        }

        if ((num1 != 0 && num2 % num1 == 0 && num3 % num1 == 0) ||
                (num2 != 0 && num1 % num2 == 0 && num3 % num2 == 0) ||
                (num3 != 0 && num1 % num3 == 0 && num2 % num3 == 0)) {
            System.out.println("Satisfies the fourth condition");
        }
    }

    static void B09() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter height(cm) ");
        int height = Integer.parseInt(br.readLine());
        System.out.print("Enter weight(cm) ");
        int weight = Integer.parseInt(br.readLine());

        System.out.println(height / (weight * weight) >= 25 ? "You are obesity " : "You are not obesity\n");
    }

    static void C01() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a birth year > ");
        int birth_year = Integer.parseInt(br.readLine());
        int age = 2024 - birth_year + 1;

        String category = age >= 0 && age < 7 ? "You are baby" : age < 13 ? "You are child" : age < 20 ? "You are teenage" : age < 30 ? "You are youth" : age < 60 ? "You are middle-age" : "You are elderly";
        System.out.println(category + "\n");
    }

    static void C02() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter water temperature > ");
        double input_degree = Double.parseDouble(br.readLine());

        String state = input_degree < 0 ? "Invalid input!" : input_degree < 25 ? "It's cold water" : input_degree < 40 ? "It's warm water" : input_degree < 80 ? "It's hot water" : "It's boiling water";
        System.out.println(state + "\n");
    }

    static void C03() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter width of Rectangle > ");
        int width = Integer.parseInt(br.readLine());

        System.out.print("Enter height of Rectangle > ");
        int height = Integer.parseInt(br.readLine());

        if (width == height) {
            System.out.println("It is square");
        } else if (width >= 2 * height) {
            System.out.println("It is an oblong rectangle from side to side.");
        } else if (height >= 2 * width) {
            System.out.println("It is an oblong rectangle from top to bottom.");
        } else if (width > height) {
            System.out.println("It is a horizontal rectangle.");
        } else {
            System.out.println("It is a vertical rectangle.");
        }
    }

    static void C04() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter area of Apartment(m^2) > ");
        double m2_area = Double.parseDouble(br.readLine());
        double pyung_area = m2_area / 3.305;

        System.out.printf("Area of Apartment(pyung) %.1f\n", pyung_area);

        String size = pyung_area < 15 ? "small-size" : pyung_area < 30 ? "small and medium-sized" : pyung_area < 50 ? "medium-sized" : "big-sized";
        System.out.println("It is " + size + " apartment");
    }

    static void C05() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter a month > ");
        int month = Integer.parseInt(br.readLine());
        System.out.print("Enter a day > ");
        int day = Integer.parseInt(br.readLine());

        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (month < 1 || month > 12 || day < 1 || day > monthDays[month - 1]) {
            System.out.println("This date is not valid.");
            return;
        }
        int day_count = 0;
        for (int i = 0; i < month - 1; i++) {
            day_count += monthDays[i];
        }
        day_count += day;

        System.out.println("This date is " + day_count + "th of the year");
    }

    static void C06() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter points of Korean > ");
        int kor = Integer.parseInt(br.readLine());
        System.out.print("Enter points of English > ");
        int eng = Integer.parseInt(br.readLine());
        System.out.print("Enter points of Math > ");
        int math = Integer.parseInt(br.readLine());

        int total = kor + eng + math;
        double average = (double) total / 3;

        System.out.println("Total point is " + total);
        System.out.printf("The average is %.1f\n", average);

        String grade = average >= 90 ? "A" : average >= 80 ? "B" : average >= 70 ? "C" : average >= 60 ? "D" : "F";
        System.out.println("Your grade is " + grade);
    }

    static void C07() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter file size as megabytes > ");
        int megabytes = Integer.parseInt(br.readLine());

        long bytes = (long) megabytes * 1024 * 1024;

        System.out.print("Enter transfer method (1. WiFi, 2. Bluetooth, 3. LTE, 4. USB) > ");
        byte kind = Byte.parseByte(br.readLine());

        double speed = 0;
        if (kind == 1) speed = 1_500_000;
        else if (kind == 2) speed = 300_000;
        else if (kind == 3) speed = 1_000_000;
        else if (kind == 4) speed = 60_000_000;

        double time = bytes / speed;
        System.out.printf("File transfer time is %.1f\n", time);
    }

    static void C08() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter first number > ");
        int num1 = Integer.parseInt(br.readLine());
        System.out.print("Enter second number > ");
        int num2 = Integer.parseInt(br.readLine());
        System.out.print("Enter third number > ");
        int num3 = Integer.parseInt(br.readLine());

        int max_num = Math.max(num1, Math.max(num2, num3));
        int min_num = Math.min(num1, Math.min(num2, num3));

        System.out.println("Max number is " + max_num + ", Min number is " + min_num);
    }

    static void C09() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter income > ");
        int income = Integer.parseInt(br.readLine());

        double taxRate = income < 10_000_000 ? 0.095 :
                income < 40_000_000 ? 0.19 :
                        income < 80_000_000 ? 0.28 : 0.37;

        int tax = (int) (income * taxRate);
        System.out.println("Income tax is " + tax);
    }

    static void C10() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number1 > ");
        int num1 = Integer.parseInt(br.readLine());
        System.out.print("Enter number2 > ");
        int num2 = Integer.parseInt(br.readLine());
        System.out.print("Enter a math symbol('+', '-', '*', '/') ");
        String operator = br.readLine();

        System.out.println("Result is " + (operator.equals("+") ? num1 + num2 : operator.equals("-") ? num1 - num2 : operator.equals("*") ? num1 * num2 :  num1 / num2));
    }

    static void C11() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a year >  ");
        int year = Integer.parseInt(br.readLine());

        if(year % 4 == 0){
            if(year % 400 == 0){
                System.out.println("This year is leap year\n");
            }else if(year % 100 == 0){
                System.out.println("This year is not leap year\n");
            }else{
                System.out.println("This year is leap year\n");
            }
        }else{
            System.out.println("This year is not leap year\n");
        }
    }
}
