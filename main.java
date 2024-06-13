import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import java.util.Iterator;

interface Coffee {
    Coffee clone();

    String getName();

    void setName(String name);
}

class Strong implements Coffee {
    private String name;

    public Strong(String name) {
        this.name = name;
    }

    public Strong clone() {
        return new Strong(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Light implements Coffee {
    private String name;

    public Light(String name) {
        this.name = name;
    }

    public Light clone() {
        return new Light(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// D
interface Chocolate {
    public String getLabel();

    public double getPrice();
}

class Black implements Chocolate {
    private String label;
    private double price;

    public Black(String label, double price) {
        this.label = label;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public String getLabel() {
        return this.label;
    }
}

class Milk implements Chocolate {
    private String label;
    private double price;

    public Milk(String label, double price) {
        this.label = label;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public String getLabel() {
        return this.label;
    }
}

class White implements Chocolate {
    private String label;
    private double price;

    public White(String label, double price) {
        this.label = label;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public String getLabel() {
        return this.label;
    }
}

// I
interface Sugar {
    String getName();
}

class Brown implements Sugar {

    private String name;

    public Brown(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

class Caster implements Sugar {

    private String name;

    public Caster(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}

public class main {

    // Prototype
    static void one() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of coffee: ");
        int n = sc.nextInt();
        int n1;
        String name;
        Vector<Coffee> c = new Vector<Coffee>();

        for (int i = 0; i < n; i++) {
            System.out.println("Name: ");
            name = sc.next();

            System.out.println("Strong or Light coffee (0 or 1): ");
            n1 = sc.nextInt();

            if (n1 == 0) {
                c.add(new Strong(name));
            } else if (n1 == 1) {
                c.add(new Light(name));
            } else
                break;
        }

        /*
         * Coffee onec = new Strong("Black");
         * Coffee two = new Light("Latte");
         */

        System.out.println("Clone of: ");
        n1 = sc.nextInt();

        System.out.println("Cl: " + c.get(n1 - 1));
        c.add(c.get(n1 - 1).clone());
        System.out.println(n1 + " coffee: " + c.get(n - 1).getName());
        System.out.println(n1 + " coffee Clone: " + c.lastElement().getName());

        System.out.println("Change Clone name: ");
        name = sc.next();
        c.lastElement().setName(name);
        // clOne.setName("Ristretto");

        System.out.println("\nCoffee: ");
        for (Coffee i : c) {
            System.out.println(i.getName());
        }
        System.out.println("Coffee vec: " + c);
        sc.close();
    }

    // Decorator
    static void two() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of chocolate: ");
        int n = sc.nextInt();
        int n1;
        String label;
        int cost;
        Vector<Chocolate> c = new Vector<Chocolate>();

        for (int i = 0; i < n; i++) {
            System.out.println("\nLabel: ");
            label = sc.next();
            System.out.println("Cost: ");
            cost = sc.nextInt();

            System.out.println("Black or Milk or White (0/1/2): ");
            n1 = sc.nextInt();

            if (n1 == 0) {
                c.add(new Black(label, cost));
            } else if (n1 == 1) {
                c.add(new Milk(label, cost));
            } else if (n1 == 2) {
                c.add(new White(label, cost));
            } else
                break;
        }

        System.out.println("\nLabel of: ");
        n1 = sc.nextInt();

        System.out.println("Label: ");
        System.out.println(c.get(n1 - 1).getLabel());

        System.out.println("\nPrice of: ");
        n1 = sc.nextInt();

        System.out.println("Price: ");
        System.out.println(c.get(n1 - 1).getPrice());

        System.out.println("\nChocolate: ");
        for (Chocolate i : c) {
            System.out.println("    " + i.getLabel() + "  " + i.getPrice());
        }

        int sum = 0;
        for (Chocolate i : c) {
            sum += (int) (i.getPrice());
        }
        System.out.println("\nSum Price: " + sum);

        System.out.println("Chocolate vec: " + c);
        sc.close();
    }

    // Iterator
    static void three() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of sugar packages: ");
        int n = sc.nextInt();
        int n1;
        String name;
        ArrayList<Sugar> c = new ArrayList<Sugar>();

        for (int i = 0; i < n; i++) {
            System.out.println("\nName: ");
            name = sc.next();

            System.out.println("Brown or Caster (0/1): ");
            n1 = sc.nextInt();

            if (n1 == 0) {
                c.add(new Brown(name));
            } else if (n1 == 1) {
                c.add(new Caster(name));
            } else
                break;
        }

        Iterator<Sugar> it = c.iterator();
        System.out.println("\nFirst iteam: ");
        System.out.println(it.next().getName());

        System.out.println("\nOther iteam: ");
        while (it.hasNext()) {
            System.out.println(it.next().getName());
        }
        sc.close();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Task: ");

        int t = sc.nextInt();

        switch (t) {
            case 1: {
                one();
                break;
            }
            case 2: {
                two();
                break;
            }
            case 3: {
                three();
                break;
            }
            default:
                System.out.println("Error");
        }
        sc.close();
    }
}
