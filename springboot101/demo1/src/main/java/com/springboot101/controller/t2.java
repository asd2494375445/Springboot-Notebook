package com.springboot101.controller;

import java.util.stream.Stream;

public class t2 {

    public void t2(){

        Stream.of("a b c d e".split(" ")).map(w -> w + " ").peek(System.out::print);
    }
    public static void main(String[] args) {
        t2 t2 = new t2();
        t2.t2();
    }
}
