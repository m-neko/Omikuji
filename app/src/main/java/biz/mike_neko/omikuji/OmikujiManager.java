package biz.mike_neko.omikuji;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class OmikujiManager {

    private ArrayList<Omikuji> container;

    public OmikujiManager(){
        container = new ArrayList<Omikuji>();
        for(int i=0; i<5; i++) container.add(Omikuji.DAIKICHI);
        for(int i=0; i<10; i++) container.add(Omikuji.CHUUKICHI);
        for(int i=0; i<25; i++) container.add(Omikuji.SYOKICHI);
        for(int i=0; i<30; i++) container.add(Omikuji.KICHI);
        for(int i=0; i<15; i++) container.add(Omikuji.SUEKICHI);
        for(int i=0; i<10; i++) container.add(Omikuji.KYOU);
        for(int i=0; i<5; i++) container.add(Omikuji.DAIKYOU);
        Collections.shuffle(container);
    }

    public Omikuji getOmikuji(){
        Random rand = new Random();
        int num = rand.nextInt(container.size());
        return container.get(num);
    }
}
