package com.supernova.com.crystalball;

import java.util.Random;

/**
 * Created by Usuário1 on 19/08/2014.
 */
public class CrystalBall {
    public String[] manswers = {
            "I feel some good vibes" ,
            "I DO NOT recommend this path",
            "It depends",
            "You need to trust YOURSELF",
            "Sometimes,you need give some time",
            "Be patient, breath, think again..."

    };
    //Um objeto tem duas características :
    //propriedades do objeto,que sao as member variables,que comecam com m,tipo mCrystallBall,sao as caracteristicas do objt.
    //metodos que ele faz
    //o nosso pega a resposta apenas
    public String getAnswer(){
        
        String answer = "";
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(manswers.length);
        answer = Integer.toString(randomNumber);
        answer = manswers[randomNumber];
        return answer;

    }


}
