package com.dgyt.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class TestProxyA {

    @Test
    public void test() throws IOException {
        BufferedImage bi = ImageIO.read(Objects.requireNonNull(TestProxyA.class.getClassLoader().getResourceAsStream("images/e1.gif")));
        Assertions.assertNotNull(bi);
    }


}
