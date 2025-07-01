package JavaProblem;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        B09();
    }

    static void A01() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a birth year > ");
        int birth_year = Integer.parseInt(br.readLine());
        int age = 2024 - birth_year + 1;
        System.out.println("You are "+ age + " year's old.");
    }

    static void A02() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Celsius temperature > ");
        double c_degree = Double.parseDouble(br.readLine());
        double f_degree = c_degree*1.8 + 32;
        System.out.println("Fahrenheit temperature is "+ f_degree + ".");
    }

    static void A03() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter width of Rectangle > ");
        int width =Integer.parseInt(br.readLine());

        System.out.print("Enter height of Rectangle > ");
        int height =Integer.parseInt(br.readLine());

        int area = width * height;
        System.out.println("Area of Rectangle is "+ area);
    }

    static void A04() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter area of Apartment(m^2) > ");
        double m2_area = Double.parseDouble(br.readLine());
        double pyung_area = m2_area / 3.305;

        System.out.println("Area of Apartment(평수) "+ pyung_area);
    }

    static void A05() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of days > ");
        int days =Integer.parseInt(br.readLine());
        int seconds = days * 24 * 60 * 60;

        System.out.println("Total seconds is "+ seconds);
    }

    static void A06() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter points of Korean > ");
        int kor =Integer.parseInt(br.readLine());
        System.out.print("Enter points of English > ");
        int eng =Integer.parseInt(br.readLine());
        System.out.print("Enter points of Math > ");
        int math =Integer.parseInt(br.readLine());

        int total = kor + eng + math;
        double average = (double) total / 3;

        System.out.println("Total point is "+ total);
        System.out.println("The average is "+ average);
    }

    static void A07() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter file size as gigabytes > ");

        int gigabytes =Integer.parseInt(br.readLine());
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
        System.out.println("Fahrenheit temperature is " + (kind.equals('C') ? (input_degree-32)*1.8 : input_degree*1.8 + 32));
    }

    static void B03() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter width of Rectangle > ");
        int width =Integer.parseInt(br.readLine());

        System.out.print("Enter height of Rectangle > ");
        int height =Integer.parseInt(br.readLine());

        int area = width * height;
        System.out.print("Area of Rectangle is "+ area);
        System.out.println(" and \n" +  (width == height ? "it is square " : "it is not square"));
    }

    static void B04() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter area of Apartment(m^2) > ");
        double m2_area = Double.parseDouble(br.readLine());
        double pyung_area = m2_area / 3.305;

        System.out.println("Area of Apartment(평수) "+ pyung_area);
        System.out.println(pyung_area < 30 ? "It is small apartment " : "It is big apartment ");
    }

    static void B05() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of days > ");
        int days =Integer.parseInt(br.readLine());
        int seconds = days * 24 * 60 * 60;

        System.out.println("Total seconds is "+ seconds);
        System.out.println(seconds > 1_000_000 ? "It includes million seconds " + seconds / 1_000_000 + " times" : "");
    }

    static void B06() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter points of Korean > ");
        int kor =Integer.parseInt(br.readLine());
        System.out.print("Enter points of English > ");
        int eng =Integer.parseInt(br.readLine());
        System.out.print("Enter points of Math > ");
        int math =Integer.parseInt(br.readLine());

        int total = kor + eng + math;
        double average = (double) total / 3;

        System.out.println("Total point is "+ total);
        System.out.println("The average is "+ average);
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
        System.out.println(usb2.equals("Y") ? bytes/ 60_000_000 : bytes / 1_500_000);
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
        if(hset.size() < 3){
            System.out.println("Satisfies the first condition");
        }

        int countOver50 = 0;
        if(num1 > 50) countOver50++;
        if(num2 > 50) countOver50++;
        if(num3 > 50) countOver50++;
        if(countOver50 >= 2){
            System.out.println("Satisfies the second condition");
        }

        if(num1 + num2 == num3 || num1 + num3 == num2 || num2 + num3 == num1){
            System.out.println("Satisfies the third condition");
        }

        if((num1 != 0 && num2 % num1 == 0 && num3 % num1 == 0) ||
                (num2 != 0 && num1 % num2 == 0 && num3 % num2 == 0) ||
                (num3 != 0 && num1 % num3 == 0 && num2 % num3 == 0)){
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
}
