package com.hjp.spi;

/**
 * @auther huang jianping
 * @date 2019/5/22 08:49
 */
public class PlusOperationImpl implements IOperation {

    @Override
    public int operation(int numberA, int numberB) {
        return numberA + numberB;
    }
}