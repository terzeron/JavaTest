package com.terzeron.java;

/**
 * Created by terzeron on 2015-01-22.
 */
public class SampleBean {

    public String name;
    public int age;
    public SampleBean innerBean;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SampleBean getInnerBean() {
        return innerBean;
    }

    public void setInnerBean(SampleBean innerBean) {
        this.innerBean = innerBean;
    }

    public String toString() {
        StringBuffer resultString = new StringBuffer();
        resultString.append(
                "Outter name : " + name + "\n"
                        + "Outter age  : " + age + "\n");
        if (innerBean != null) {
            resultString.append(
                    "inner name  : " + innerBean.getName() + "\n"
                    + "inner age   : " + innerBean.getAge() + "\n");
        }
        return resultString.toString();
    }
}