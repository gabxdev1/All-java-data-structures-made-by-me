package br.com.gabxdev.datastructure;


import java.util.Arrays;
import java.util.Collections;

public class ListTest01 {
    public static void main(String[] args) {

        long inicio;
        long fim;


        ArrayList<String> arrayList = new ArrayList<>(1);
        arrayList.add("teste 1");
        arrayList.add("teste 2");
        arrayList.add("teste 3");
        arrayList.add("teste 4");
        arrayList.add("teste 5");
        arrayList.add(2, "test push");
        arrayList.remove(2);
        arrayList.remove("teste 4");
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.get("teste 3"));
        arrayList.set(3, "test");
        System.out.println(arrayList);



        java.util.ArrayList<String> list = new java.util.ArrayList<>(1);

       // list.remove(1);






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
