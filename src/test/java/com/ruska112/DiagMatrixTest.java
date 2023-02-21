package com.ruska112;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiagMatrixTest {

    DiagMatrix dm1 = new DiagMatrix(2, 0, 0, 0, 3, 0, 0, 0, 5);

    @Test
    public void getIJTest0() {
        Assert.assertEquals(2, dm1.getIJ(0, 0), 0.001);
    }

    @Test
    public void getIJTest1() {
        Assert.assertEquals(0, dm1.getIJ(0, 1), 0.001);
    }

    @Test
    public void setIJ0() {
        dm1.setIJ(1, 1, 999);
        Assert.assertEquals(999, dm1.getIJ(1, 1), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setIJ1() {
        dm1.setIJ(0, 1, 999);
    }

    @Test
    public void getDeterminant() {
    }

    @Test
    public void getSize() {
        Assert.assertEquals(3, dm1.getSize(), 0.001);
    }
}