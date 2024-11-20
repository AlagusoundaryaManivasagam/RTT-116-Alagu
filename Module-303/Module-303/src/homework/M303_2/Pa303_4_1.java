package homework.M303_2;

import java.util.Scanner;

public class Pa303_4_1 {
    public static void main(String[] args) {
        int x = 7;
        if (x < 10) {
            System.out.println("Less than 10");
        }
        int x1 = 15;
        if (x1 < 10) {
            System.out.println("Less than 10");
        }
        System.out.println("==============================================================");
        int x2 = 7;
        if (x2 < 10) {
            System.out.println("Less than 10");
        } else if (x2 > 10) {
            System.out.println("Greater than 10");
        }
        int x3 = 15;
        if (x3 < 10) {
            System.out.println("Less than 10");
        } else if (x3 > 10) {
            System.out.println("Greater than 10");
        }
        System.out.println("==============================================================");
        int x4 = 15;
        if (x4 < 10) {
            System.out.println("Less than 10");
        } else if (x4 < 20 && x4 > 10) {
            System.out.println("Between 10 and 20");
        } else if (x4 > 20) {
            System.out.println("Greater than 20");
        }
        int x5 = 50;
        if (x5 < 10) {
            System.out.println("Less than 10");
        } else if (x5 < 20 && x5 > 10) {
            System.out.println("Between 20 and 10");
        } else if (x5 > 20) {
            System.out.println("Greater than 20");
        }
        System.out.println("==============================================================");
        int x6 = 15;
        if (x6 < 10 || x6 > 20) {
            System.out.println("Out of range");
        } else if (x6 > 10 && x6 < 20) {
            System.out.println("In range");
        }
        int x7 = 5;
        if (x7 < 10 || x7 > 20) {
            System.out.println("Out of range");
        } else if (x7 > 10 && x7 < 20) {
            System.out.println("In range");
        }
        System.out.println("==============================================================");
        int marks;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter marks");
        marks = scan.nextInt();
        if (marks < 0 || marks > 100) {
            System.out.println("Marks out of range");
        } else if (marks < 100 && marks >= 90) {
            System.out.println("Grade A");
        } else if (marks >= 80) {
            System.out.println("Grade B");
        } else if (marks >= 70) {
            System.out.println("Grade C");
        } else if (marks >= 60) {
            System.out.println("Grade D");
        } else {
            System.out.println("Grade F");
        }
        System.out.println("==============================================================");
        int weekday;
        System.out.println("Enter a number between 1 and 7");
        weekday = scan.nextInt();
        switch (weekday) {
            case 1:
                System.out.println("SUNDAY");
                break;
            case 2:
                System.out.println("MONDAY");
                break;
            case 3:
                System.out.println("TUESDAY");
                break;
            case 4:
                System.out.println("WEDNESDAY");
                break;
            case 5:
                System.out.println("THURSDAY");
                break;
            case 6:
                System.out.println("FRIDAY");
                break;
            case 7:
                System.out.println("SATURDAY");
                break;
            default:
                System.out.println("Out of range");
        }
        System.out.println("=============================================================");
        int taxRate= 0;
        String maritalStatus;
        Double tax;
        System.out.println("Enter marital status(Single," +
                "Married filing jointly/Qualified Widower,Married filing separately,Head of household ");
        maritalStatus = scan.next();
        System.out.println("Enter income");
        int income = scan.nextInt();
        if (maritalStatus.equalsIgnoreCase("Single")) {
            if (income >= 0 && income <= 8350) {
                taxRate = 10;
            } else if (income <= 33950) {
                taxRate = 15;
            } else if (income <= 82250) {
                taxRate = 25;
            } else if (income <= 171550) {
                taxRate = 28;
            } else if (income <= 372950) {
                taxRate = 33;
            } else if (income >= 372951) {
                taxRate = 35;
            }
        }
        if (maritalStatus.equalsIgnoreCase("Married filing jointly") ||
                maritalStatus.equalsIgnoreCase("Qualified Widower")) {
            if (income >= 0 && income <= 16700) {
                taxRate = 10;
            } else if (income <= 67900) {
                taxRate = 15;
            } else if (income <= 137050) {
                taxRate = 25;
            } else if (income <= 208850) {
                taxRate = 28;
            } else if (income <= 372950) {
                taxRate = 33;
            } else if (income >= 372951) {
                taxRate = 35;
            }

        }
        if (maritalStatus.equalsIgnoreCase("Married filing separately")) {
            if (income >= 0 && income <= 8350) {
                taxRate = 10;
            } else if (income <= 33950) {
                taxRate = 15;
            } else if (income <= 68525) {
                taxRate = 25;
            } else if (income <= 104425) {
                taxRate = 28;
            } else if (income <= 186475) {
                taxRate = 33;
            } else if (income >= 186476) {
                taxRate = 35;
            }
        }
        if (maritalStatus.equalsIgnoreCase("Head of household")) {
            if (income >= 0 && income <= 11950) {
                taxRate = 10;
            } else if (income <= 45500) {
                taxRate = 15;
            } else if (income <= 117450) {
                taxRate = 25;
            } else if (income <= 190200) {
                taxRate = 28;
            } else if (income <= 372950) {
                taxRate = 33;
            } else if (income >= 372951) {
                taxRate = 35;
            }
        }
        System.out.println("TaxRate is : "+ taxRate+"%");
        tax= ((double)taxRate/100)*income;
        System.out.println("The tax amount to be paid is : "+tax );


    }
}
