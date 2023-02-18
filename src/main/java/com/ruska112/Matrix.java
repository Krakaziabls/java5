package com.ruska112;

import java.util.Arrays;
import java.util.Objects;

public class Matrix implements IMatrix {
    private int size;
    private double[] array;

    public double getIJ(int i, int j) {
        if (i >= 0 && i < size && j >= 0 && j < size) {
            return array[i * size + j];
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setIJ(int i, int j, double element) {
        if (i >= 0 && i < size && j >= 0 && j < size) {
            array[i * size + j] = element;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public double getDeterminant() {
        double[] tmpArray = Arrays.copyOf(array, size * size);
        double result = 1;
        double tmp = 0;
        double coefficient = 0;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j <= size - 1; j++) {
                tmp = tmpArray[j * size + i];
                coefficient = tmpArray[j * size + i] / tmpArray[i * size + i];
                for (int k = 0; k < size; k++) {
                    if (coefficient > 0) {
                        tmpArray[j * size + k] -= tmpArray[i * size + k] * coefficient;
                    } else if (coefficient < 0) {
                        tmpArray[j * size + k] += tmpArray[i * size + k] * coefficient;
                    }
                }
            }
        }
        for (int i = 0; i < size; i++) {
            result *= tmpArray[i * size + i];
        }
        return result;
    }

    public Matrix(int size) {
        if (size > 0) {
            this.size = size;
            this.array = new double[size * size];
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    public boolean equals(Matrix obj) {
        return this.hashCode() == obj.hashCode();
    }
}
