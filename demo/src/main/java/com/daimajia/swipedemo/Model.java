package com.daimajia.swipedemo;

/**
 * Created by controller on 9/28/15.
 */
public class Model {

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isSelection1() {
        return isSelection1;
    }

    public void setIsSelection1(boolean isSelection1) {
        this.isSelection1 = isSelection1;
    }

    public boolean isSelection2() {
        return isSelection2;
    }

    public void setIsSelection2(boolean isSelection2) {
        this.isSelection2 = isSelection2;
    }

    public boolean isSelection3() {
        return isSelection3;
    }

    public void setIsSelection3(boolean isSelection3) {
        this.isSelection3 = isSelection3;
    }

    String text;
    boolean isSelection1;
    boolean isSelection2;
    boolean isSelection3;
}
