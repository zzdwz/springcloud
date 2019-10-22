package com.example.ribbonconsumer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RibbonConsumerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void bubbleSortTest(){
        int array[] = {2, 5, 1, 6, -9, 7, 8, 9, 4, -2};

        for(int i = 1; i < array.length; i++){
            for(int j = 0; j < array.length - i; j++){
                if (array[j] > array[j + 1]){
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }

        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }



}
