package com.ruska112;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {
    Matrix m1 = new Matrix(3);
    Matrix m2 = new Matrix(3);

    Matrix m3 = new Matrix(4);

    @Before
    public void setUp() throws Exception {
        m1.array = new double[]{2, 4, 6, 3, 3, 3, 4, 5, 9};
        m2.array = new double[]{-2, -4, -6, 3, 3, 3, 4, 5, 9};
    }

    @Test
    public void getIJTest0() {
        Assert.assertEquals(2, m1.getIJ(0, 0), 0.001);
    }

    @Test
    public void getIJTest1() {
        Assert.assertEquals(3, m1.getIJ(1, 1), 0.001);
    }

    @Test
    public void getIJTest2() {
        Assert.assertEquals(6, m1.getIJ(0, 2), 0.001);
    }

    @Test
    public void setIJTest0() {
        m1.setIJ(0, 2, 999);
        Assert.assertEquals(999, m1.getIJ(0, 2), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setIJTestException() {
        m1.setIJ(0, 4, 999);
        m1.getIJ(0, 2);
    }

    @Test
    public void getSizeTest() {
        Assert.assertEquals(3, m1.getSize());
    }

    @Test
    public void getDeterminantTest0() {
        Assert.assertEquals(-18, m1.getDeterminant(), 0.001);
    }

    @Test
    public void getDeterminantTest1() {
        Assert.assertEquals(18, m2.getDeterminant(), 0.001);
    }
}