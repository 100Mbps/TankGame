package com.dgyt.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class TestA {

    @Test
    public void test() throws IOException {
        BufferedImage bi = ImageIO.read(Objects.requireNonNull(TestA.class.getClassLoader().getResourceAsStream("images/e1.gif")));
        Assertions.assertNotNull(bi);
    }

    /**
     * 测试继承,属性值
     */
    @Test
    public void testExtends() {
        A a = new B();
        a.a = 10;
        B b = (B) a;
        Assertions.assertEquals(b.a, 0);
        Assertions.assertEquals(a.a, 10);
    }


}
