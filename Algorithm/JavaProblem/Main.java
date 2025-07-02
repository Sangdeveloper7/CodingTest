package JavaProblem;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        B09();
    }

    static void A01() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a birth year > ");
        int birth_year = Integer.parseInt(br.readLine());
        int age = 2025 - birth_year;
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
        int age = 2025 - birth_year;
        System.out.println(age >= 20 ? "You are adult" : "You are not adult");
    }

    static void B02() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter temperature > ");
        double input_degree = Double.parseDouble(br.readLine());
        System.out.print("Enter type of temperature('C' for Celsius, 'F' for Fahrenheit) ");
        String kind = br.readLine();
        System.out.println(kind.equals("C") ? "Fahrenheit temperature is " + (input_degree * 1.8 + 32) : "Celsius temperature is " + ((input_degree - 32) / 1.8));
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
        System.out.print("Enter weight(kg) ");
        int weight = Integer.parseInt(br.readLine());
        double heightMeter = height / 100.0;
        double bmi = weight / (heightMeter * heightMeter);

        System.out.println(bmi >= 25 ? "You are obesity" : "You are not obesity");
    }

    static void C01() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a birth year > ");
        int birth_year = Integer.parseInt(br.readLine());
        int age = 2025 - birth_year;

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

    static void D01() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a number > ");
        int number = Integer.parseInt(br.readLine());
        if(number <= 1)
            System.out.println("Invalid input");
        else{
            int totalsum = number * (number+1) / 2;
            System.out.println("The sum of all integer from 1 to the number entered is " + totalsum);
        }
    }

    static void D02() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>();
        while(true){
            System.out.print("Enter a number > ");
            int number = Integer.parseInt(br.readLine());
            if(number < 0 || number > 100)
                break;
            else
                arr.add(number);
        }
        Collections.sort(arr);
        int max_num = arr.get(arr.size()-1);
        int min_num = arr.get(0);
        System.out.println("Max number is " + max_num + " , Min number is " + min_num);
    }

    static void D03() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total_sum = 0;
        int count = 0;
        while(true){
            System.out.print("Enter a number > ");
            int number = Integer.parseInt(br.readLine());
            if(number < 0 || number > 100)
                break;
            total_sum += number;
            count++;
        }
        System.out.println("The sum of " + count + " numbers is " + total_sum + " , average is " + (float) total_sum / count);
    }

    static void D04() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of family members > ");
        int count_all = Integer.parseInt(br.readLine());
        int count_young = 0;

        for(int i = 0; i < count_all; i++){
            int birth_year = Integer.parseInt(br.readLine());
            int age = 2021 - birth_year + 1;
            if(age < 20) count_young++;
        }

        System.out.println("There are " + count_young + " youngs in the family. ");
    }

    static void D05() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int width, height;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;

        while (true) {
            System.out.print("Enter width, height of Rectangle > ");
            String[] input = br.readLine().split(" ");
            width = Integer.parseInt(input[0]);
            height = Integer.parseInt(input[1]);

            if (width <= 0 || height <= 0) break;
            if (width == height) {
                count1++;
            } else if (width >= height * 2) {
                count2++;
            } else if (height >= width * 2) {
                count3++;
            } else if (width > height) {
                count4++;
            } else {
                count5++;
            }
        }

        System.out.println("Count of square is " + count1);
        System.out.println("Count of an oblong rectangle from side to side is " + count2);
        System.out.println("Count of an oblong rectangle from top to bottom is " + count3);
        System.out.println("Count of a horizontal rectangle is " + count4);
        System.out.println("Count of a vertical rectangle is " + count5);
    }

    static void D06() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double m2_area;
        double pyung_area;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter area of Apartment(m^2) > ");
            m2_area = Double.parseDouble(br.readLine());
            pyung_area = m2_area / 3.305;
            if (pyung_area < 15)
                count1++;
            else if (pyung_area < 30)
                count2++;
            else if (pyung_area < 50)
                count3++;
            else
                count4++;
        }

        System.out.println("Count of small-sized apartment is " + count1);
        System.out.println("Count of small and medium-sized apartment is " + count2);
        System.out.println("Count of medium-sized apartment is " + count3);
        System.out.println("Count of big-sized apartment is " + count4);
    }

    static void D07() throws IOException{
        System.out.print("Enter the coefficients a and b of linear function(y=ax+b) > ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.print("Enter the start and end values of x coordinates > ");

        st = new StringTokenizer(br.readLine());
        int x_begin = Integer.parseInt(st.nextToken());
        int x_end = Integer.parseInt(st.nextToken());

        for(int i = x_begin; i < x_end; i++){
            int y = a * i + b;
            int x = i;
            System.out.println("coordinates (" + x + " ," + y +")");
        }
    }

    static void D08()  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the coefficients a and b of quadratic function(y=ax^2+bx+c) > ");
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.print("Enter the start and end values of x coordinates > ");
        st = new StringTokenizer(br.readLine());

        int x_begin = Integer.parseInt(st.nextToken());
        int x_end = Integer.parseInt(st.nextToken());

        for (int x = x_begin; x <= x_end; x++) {
            int y = a * x * x + b * x + c;
            System.out.println("coordinates (" + x + ", " + y + ")");
        }
    }

    static void D09()  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int dan;

        while (true) {
            System.out.print("Enter number of gugudan(2~9) > ");
            dan = Integer.parseInt(br.readLine());
            if (dan >= 2 && dan <= 9) {
                break;
            } else {
                System.out.println("Invalid input");
            }
        }
        for (int i = 1; i <= 9; i++) {
            System.out.println(dan + " X " + i + " = " + (dan * i));
        }
    }

    static void D10()  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter two numbers > ");
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= 100; i++){
            if(i % num1 == 0 || i % num2 == 0){
                if(i % num1 == 0 && i % num2 == 0)
                    continue;
                else
                    System.out.print(i + " ");
            }
        }
    }


}
