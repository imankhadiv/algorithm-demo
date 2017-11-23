package com.elrast;

import com.elrast.CircleMaker;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CircleMakerTest {


    CircleMaker circleMaker;
    @Before
    public void setUp() throws Exception {
        circleMaker = new CircleMaker();
    }

    @Test
    public void testJudgeCircle() throws Exception {

        assertFalse(circleMaker.judgeCircle("LL"));
    }
    @Test
    public void shouldReturnFalseWhenInputLengthIsNotEven() {

        assertFalse(circleMaker.judgeCircle("LRLUD"));
    }
    @Test
    public void shouldJudge() throws Exception {

        assertFalse(circleMaker.judgeCircle2("LL"));
    }
    @Test
    public void shouldReturnFalseForNotEvenMoves() {

        assertFalse(circleMaker.judgeCircle2("LRLUD"));
    }
}