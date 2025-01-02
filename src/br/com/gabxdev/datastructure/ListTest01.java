package br.com.gabxdev.datastructure;


public class ListTest01 {
    public static void main(String[] args) {

        long inicio;
        long fim;


        ArrayList vetor = new ArrayList(2);
        vetor.add("A");
        vetor.add("B");
        System.out.println(vetor.remove("A"));
        System.out.println(vetor);


        java.util.ArrayList<String> list = new java.util.ArrayList<>(1);
        list.add("A");
        list.remove(new String("asd"));
        //System.out.println(list.remove(0));






//        for (int i = 0; i < 300_000_000; i++) {
//            list.add("teste");
//        }
//
//        inicio = System.currentTimeMillis();
//        list.add(50_000_000, "fodase");
//        fim = System.currentTimeMillis();
//        System.out.println("vetor do java: " + (fim-inicio));
//        System.out.println(list.size());



//        for (int i = 0; i < 300_000_000; i++) {
//            vetor.add("teste");
//        }
//
//        inicio = System.currentTimeMillis();
//        vetor.add(50_000_000, "fodase");
//        fim = System.currentTimeMillis();
        //496

    }
}
