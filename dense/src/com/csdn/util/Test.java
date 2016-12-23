package com.csdn.util;

import com.jsoniter.Any;
import com.jsoniter.JsonIterator;
import com.sun.org.glassfish.external.amx.AMX;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/23.
 */

public class Test {

    public static void main(String[] args) throws IOException {
        System.out.print("111111111111111111");
        new Test().test_iterator_api();


        JsonIterator iter = JsonIterator.parse("{ 'field1' : 'hello' , 'field2': 'world' }".replace('\'', '"'));

        Any testObj1 = iter.readAny();
        System.out.println("" + testObj1.get("field1"));

        //JsonIterator iter2 = JsonIterator.parse("[{'field1':'11','field2':'12'},{'field1':'21','field2':'22'}]".replace('\'', '"'));
        JsonIterator iter2 = JsonIterator.parse("[{'field1':'11','field2':'我们是中国人'},{'field1':'21','field2':'22'}]".replace('\'', '"'));
        Any val = iter2.readAny();


        for(int i=0;i<val.getList().size();i++){
            System.out.println(val.toString(i, "field1")); // 22
        }


    }


    public void test_any_api() throws IOException {
        JsonIterator iter = JsonIterator.parse("[0,1,2,9]");
        System.out.println(iter.readAny().toInt(3));
    }

    public void test_iterator_api() throws IOException {
        JsonIterator iter = JsonIterator.parse("[0,1,2,9]");
        int total = 0;
        while (iter.readArray()) {
            total += iter.readInt();
        }
        System.out.println(total);
    }


}
