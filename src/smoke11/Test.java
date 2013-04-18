package smoke11;

public class Test
{
    static String[] text = new String[]{"Nasz pierwszy program jaki napiszemy w języku Java to standardowo „Hello World”. Powinniśmy w tym momencie omówić jak stworzyć odpowiedni plik. Otwórzmy notatnik i przepiszmy poniższy kod. Podkreślam słowo przepisz, ponieważ kopiując przykłady kompletnie niczego się nie nauczysz. Zastanawiałem się, czy nie wklejać tutaj obrazków z kodem, aby wam tego nie utrudnić i obronić przed lenistwem, ale jednak później kopiowanie będzie dozwolone.\n" +
            "\n" +
            "//Czytaj więcej na: http://javastart.pl/podstawy-jezyka/pierwszy-program/#ixzz2QqjzGQlt\n","Przepisz go do nowego pliku notatnika i zapisz w dowolnym miejscu z rozszerzeniem .java, zamiast .txt. Nazwa pliku musi być koniecznie taka sama jak nazwa klasy czyli Hello.java uwzględniając wielkość liter!\n" +
            "To właśnie takie rozszerzenie mają pliki z kodem, które następnie będą kompilowane.\n" +
            "\n" +
            "//Czytaj więcej na: http://javastart.pl/podstawy-jezyka/pierwszy-program/#ixzz2Qqk6rMzD\n","1. public class Hello – jest to nic innego jak publiczna klasa o nazwie Hello.\n" +
            "\n" +
            "Klasa to krótko mówiąc komórka informacji, zawiera ona różne dane – zmienne, metody(funkcje) a także inne obiekty. Jeśli na razie tego nie rozumiesz to się nie przejmuj.\n" +
            "\n" +
            "2. public static void main(String[] args) – jest to metoda main, to od niej rozpoczyna się działanie programu i w niej wywołujemy inne metody, lub tworzymy obiekty za to odpowiedzialne. W nawiasie podane są argumenty w postaci tablicy Stringów (nie to nie kobieca bielizna). Później przekonamy się jak można to wykorzystać.\n" +
            "\n" +
            "//Czytaj więcej na: http://javastart.pl/podstawy-jezyka/pierwszy-program/#ixzz2Qqk8dT00\n"};
    public static void main(String[] args){
        DebugView.createWindow(830, 0, 200, 400, DebugView.DEBUGLVL_MOREINFO);
        for (int i=0;i<13;i++)
            for (String t : text)
                DebugView.writeDebug(DebugView.DEBUGLVL_LESSINFO,t, "abcxv");
    }
}

//Czytaj więcej na: http://javastart.pl/podstawy-jezyka/pierwszy-program/#ixzz2QqjHy1FP
