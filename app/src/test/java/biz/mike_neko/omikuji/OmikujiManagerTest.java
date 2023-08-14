package biz.mike_neko.omikuji;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OmikujiManagerTest {

    private OmikujiManager om;

    @Before
    public void setUp() throws Exception {
        om = new OmikujiManager();
    }

    @Test
    public void おみくじの出現頻度をチェックする() {
        for(int i=0; i<100; i++){
            Omikuji omikuji = om.getOmikuji();
            if(omikuji == Omikuji.DAIKICHI){
                System.out.println("大吉");
            }else if(omikuji == Omikuji.CHUUKICHI) {
                System.out.println("中吉");
            }
        }
    }
}