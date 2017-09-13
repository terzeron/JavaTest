package net.terzeron.quiz;

/**
 * Created by terzeron on 2016. 11. 9..
 */

/*
    아래의 boolean 식 F를 가능한 간단한 형태로 고쳐라. 아래의 식에서 '~'은 NOT, '·'는 AND, '+'는 OR를 의미한다.
      F = (~A)·(~B)·(~C) + (~A)·(~B)·C + (~A)·B·C + A·(~B)·C + A·B·C
 */

public class Logic {
    boolean f(boolean a, boolean b, boolean c) {
        if (!a && !b && !c) {
            return true;
        } else if (!a && !b && c) {
            return true;
        } else if (!a && b && c) {
            return true;

        } else if (a && !b && c) {
            return true;
        } else if (a && b && c) {
            return true;
        }
        return false;
    }

    boolean f2(boolean a, boolean b, boolean c) {
        if (!a && !b) {
            return true;
        } else if (!a && b && c) {
            return true;
        } else if (a && c) {
            return true;
        }
        return false;
    }

    boolean f3(boolean a, boolean b, boolean c) {
        if (!a && (!b || b && c)) {
            return true;
        } else if (a && c) {
            return true;
        }
        return false;
    }

    boolean f4(boolean a, boolean b, boolean c) {
        if (!a && (!b || c)) {
            return true;
        } else if (a && c) {
            return true;
        }
        return false;
    }

    boolean f5(boolean a, boolean b, boolean c) {
        if (!a && !b || !a && c || a && c) {
            return true;
        }
        return false;
    }

    boolean f6(boolean a, boolean b, boolean c) {
        if (!a && !b || c) {
            return true;
        }
        return false;
    }
}
