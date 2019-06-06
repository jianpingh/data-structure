package com.hjp.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @auther huang jianping
 * @date 2019/5/22 08:57
 */
public class main {

    public static void main(String[] args) {
        IOperation plus = new PlusOperationImpl();

        IOperation division = new DivisionOperationImpl();
        /*System.out.println(plus.operation(5, 3));

        System.out.println(division.operation(9, 3));*/

        ServiceLoader<IOperation> operations = ServiceLoader.load(IOperation.class);
        Iterator<IOperation> operationIterator = operations.iterator();
        //System.out.println("classPath:"+System.getProperty("java.class.path"));
        while (operationIterator.hasNext()) {
            IOperation operation = operationIterator.next();
            System.out.println(operation.operation(6, 3));
        }
    }
}
