package com.ruska112;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UpTriangleMatrixTest {
    UpTriangleMatrix utm1 = new UpTriangleMatrix(3);

    @Before
    public void setup() {
        utm1.array = new double[]{1, 2, 3, 0, 3, 3, 0, 0, 9};
    }

    @Test
    public void setIJTest0() {
        utm1.setIJ(1, 2, 4);
        assertEquals(4, utm1.getIJ(1, 2), 0.001);
    }

    @Test
    public void setIJTest1() {
        utm1.setIJ(1, 1, 4);
        assertEquals(4, utm1.getIJ(1, 1), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setIJTestBad() {
        utm1.setIJ(2, 0, 4);
    }

    @Test
    public void getDeterminantTest0() {
        assertEquals(27, utm1.getDeterminant(), 0.001);
    }

    @Test
    public void getSizeTest() {
        assertEquals(3, utm1.getSize());
    }

    @Test
    public void equalsTest() {
        UpTriangleMatrix utm2 = new UpTriangleMatrix(utm1.getSize());
        for (int i = 0; i < utm1.getSize(); i++) {
            for (int j = 0; j < utm1.getSize(); j++) {
                if (j >= i) {
                    utm2.setIJ(i, j, utm1.getIJ(i, j));
                }
            }
        }
        assertTrue(utm1.equals(utm2));
    }
}