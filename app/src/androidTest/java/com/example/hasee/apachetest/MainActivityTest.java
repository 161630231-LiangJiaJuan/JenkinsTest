package com.example.hasee.apachetest;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityUnitTestCase;
import android.test.AndroidTestCase;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;
/*
 *Created by haseeon 2018/10/22.
 */


public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mainActivity;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        mainActivity = getActivity();
    }

    public void testRepeatStr() {
        String string=mainActivity.repeatStr("love",5);
        Assert.assertEquals(string, "lovelovelovelovelove");
    }

    public void testReverseStr() {
        String string=mainActivity.reverseStr("i love ruan jian ce shi");
        assertEquals(string,"shi ce jian ruan love i");
        String string1=mainActivity.reverseStr("faker");
        assertEquals(string1,"rekaf");
    }

    public void testCreatNum() {
        int num0=mainActivity.creatNum("0x4687");
        assertEquals(num0,18055);
    }

    public void testCompareNum() {
        String result0=mainActivity.compareNum(0xffffffff,0x80000000);
        assertEquals(result0,"第一个数字大于第二个数字");
    }

    public void testStringUtils(){
        String s0= StringUtils.reverse("Uzi");
        assertEquals(s0,"izU");
        String s1=StringUtils.reverseDelimited("Clear Love",' ');
        assertEquals(s1,"Love Clear");
    }

    public void testDriver(){

    }
    @Test
    public void hideKeyBoard() {
    }
}