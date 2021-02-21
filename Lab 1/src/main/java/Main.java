public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        String[] languages=new String[]{"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n=(int)(Math.random()*1000000);
        n=n*3;
        n=n+Integer.parseInt("10101");
        n=n+Integer.parseInt("FF",16);
        n=n*6;
        System.out.println(n);

        while(n>9) {
            n=n/10+n%10;
        }
        System.out.println(n);
        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);
    }
}
