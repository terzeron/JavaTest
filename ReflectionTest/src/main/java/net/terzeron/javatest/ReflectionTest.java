package net.terzeron.javatest;

import java.lang.reflect.*;

/**
 * Created by terzeron on 2015-01-22.
 */
public class ReflectionTest {
    public ReflectionTest() {
    }

    private void printClassInformation(Object object) {
        // 클래스 기본 정보 확인
        System.out.println("** Class information **");
        System.out.println("=======================");
        System.out.println(object.getClass().getPackage());
        System.out.println("Class Name : " + object.getClass().getName());
        System.out.println("Super Class: " + object.getClass().getSuperclass().getName());
        System.out.println("");
        // 접근자 확인
        System.out.println("** Class Modifier information **");
        System.out.println("================================");
        System.out.println("Modifier : " + Modifier.toString(object.getClass().getModifiers()));
        System.out.println("");
        // 메소드 확인
        System.out.println("** Method information **");
        System.out.println("========================");
        System.out.println(" << all method >> ");
        System.out.println(getMethodInfo(object.getClass().getDeclaredMethods()));
        System.out.println("");
        System.out.println(" << access possible method >> ");
        System.out.println(getMethodInfo(object.getClass().getMethods()));
        System.out.println("");
        // 필드 확인
        System.out.println("** Field information **");
        System.out.println("=======================");
        System.out.println(" << all field >> ");
        System.out.println(getFieldInfo(object.getClass().getDeclaredFields()));
        System.out.println(" << access possible field >> ");
        System.out.println(getFieldInfo(object.getClass().getFields()));
        System.out.println("");
    }

    private String getFieldInfo(Field[] fields) {
        StringBuffer fieldInfo = new StringBuffer();
        for (int i = 0; i < fields.length; i++) {
            StringBuffer info = new StringBuffer();
            info.append(Modifier.toString(fields[i].getModifiers()) + " ");
            info.append(fields[i].getType().getName() + " ");
            info.append(fields[i].getName() + " \n");
            fieldInfo.append(info.toString());
        }
        return fieldInfo.toString();
    }

    private String getMethodInfo(Method[] methods) {
        StringBuffer methodInfo = new StringBuffer();
        for (int i = 0; i < methods.length; i++) {
            StringBuffer info = new StringBuffer();
            String methodName = methods[i].getName();
            int methodModifier = methods[i].getModifiers();
            Class methodReturnType = methods[i].getReturnType();
            Class[] methodParamType = methods[i].getParameterTypes();
            info.append(Modifier.toString(methodModifier) + " ");
            info.append(methodReturnType.getName() + " ");
            info.append(methodName + "(");

            for (int j = 0; j < methodParamType.length; j++) {
                if (j != 0) info.append(", ");
                info.append(methodParamType[j].getName());
            }
            info.append(")\n");
            methodInfo.append(info.toString());
        }
        return methodInfo.toString();
    }

    private String getModifierInfo(Object object) {
        StringBuffer modifier = new StringBuffer("Modifier: ");
        int modifierType = object.getClass().getModifiers();
        if (Modifier.isAbstract(modifierType)) modifier.append("ABSTRACT");
        if (Modifier.isFinal(modifierType)) modifier.append("FINAL");
        if (Modifier.isInterface(modifierType)) modifier.append("INTERFACE");
        if (Modifier.isNative(modifierType)) modifier.append("NATIVE");
        if (Modifier.isPrivate(modifierType)) modifier.append("PRIVATE");
        if (Modifier.isProtected(modifierType)) modifier.append("PROTECTED");
        if (Modifier.isPublic(modifierType)) modifier.append("PUBLIC");
        if (Modifier.isStatic(modifierType)) modifier.append("STATIC");
        if (Modifier.isSynchronized(modifierType)) modifier.append("SYNCHRONIZED");
        if (Modifier.isStrict(modifierType)) modifier.append("STRICT");
        if (Modifier.isVolatile(modifierType)) modifier.append("VOLATILE");
        return modifier.toString();
    }

    private void invokeMethodTest(Object object) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class cls = object.getClass();
        System.out.println("before invoke .. StringBuffer value ");
        System.out.println(" >> " + object.toString());

        Method invokeMethod = cls.getMethod("append", new String().getClass());
        invokeMethod.invoke(object, "Yahoo");

        System.out.println("after invoke .. StringBuffer value");
        System.out.println(" >> " + object.toString());

        invokeMethod = cls.getMethod("toString", null);

        System.out.println("StringBuffer value .. call toString()");
        System.out.println(invokeMethod.invoke(object, null));
    }

    private void updateFieldValueTest(Object object) throws NoSuchFieldException, IllegalAccessException {
        System.out.println(object.toString());

        Class cls = object.getClass();
        cls.getField("name").set(object, "outer");
        cls.getField("age").setInt(object, 27);

        SampleBean innerBean = new SampleBean();
        innerBean.setName("inner");
        innerBean.setAge(17);
        cls.getField("innerBean").set(object, innerBean);

        System.out.println(object.toString());

        System.out.println("== get Field value !! ==");
        // 필드값 가져오기. get은 Object이므로 String로 형변환 함
        String name = (String) cls.getField("name").get(object);
        // int필드이므로 그냥 getInt를 이용함
        int age = cls.getField("age").getInt(object);
        System.out.println("name [" + name + "] age [" + age + "]");
    }

    public static void main(String[] arg) {
        ReflectionTest rt = new ReflectionTest();
        rt.printClassInformation(rt);
        rt.printClassInformation(new String());
        try {
            rt.invokeMethodTest(new StringBuffer());

            SampleBean bean = new SampleBean();
            rt.updateFieldValueTest(bean);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
