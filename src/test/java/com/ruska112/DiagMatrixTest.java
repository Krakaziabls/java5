package com.ruska112;

import org.junit.Test;

import static org.junit.Assert.*;

public class DiagMatrixTest {

    DiagMatrix dm1 = new DiagMatrix(2, 3, 5);

    @Test
    public void getIJTest0() {
        assertEquals(3, dm1.getIJ(1, 1), 0.001);
    }

    @Test
    public void getIJTest1() {
        assertEquals(0, dm1.getIJ(0, 1), 0.001);
    }

    @Test
    public void setIJTest0() {
        dm1.setIJ(1, 1, 999);
        assertEquals(999, dm1.getIJ(1, 1), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setIJTest1() {
        dm1.setIJ(0, 1, 999);
    }

    @Test
    public void getDeterminantTest() {
        assertEquals(30, dm1.getDeterminant(), 0.001);
    }

    @Test
    public void getSizeTest() {
        assertEquals(3, dm1.getSize(), 0.001);
    }

    @Test
    public void equalsTest1() {
        DiagMatrix dm4 = new DiagMatrix(dm1.getSize());
        for (int i = 0; i < dm1.getSize(); i++) {
            dm4.setIJ(i, i, dm1.getIJ(i, i));
        }
        assertTrue(dm1.equals(dm4));
    }
}