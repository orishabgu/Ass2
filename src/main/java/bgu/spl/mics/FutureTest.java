package bgu.spl.mics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class FutureTest {
    Future<Integer> future;
    Future<Integer> brokenFuture;
    Integer one;
    @Before
    public void setUp() throws Exception {
       future = new Future<>();
       brokenFuture = new Future<>();
       one = new Integer(1);
    }

    @After
    public void tearDown() throws Exception {
        future=null;
    }

    @Test
    public void get() {
        future.resolve(one);
        assertEquals("you got the right one", future,one);
    }

    @Test
    public void resolve() {
        future.resolve(one);
        assertEquals("you got the right one", future,one);
    }

    @Test
    public void isDone() {
        future.resolve(one);
        boolean done = future.isDone();
        assertEquals("The object has been resolved", true,done);
        boolean unDone = brokenFuture.isDone();
        assertEquals("The object wasn't resolved", false,unDone);
    }

    @Test
    public void get1() {
        future.resolve(one);
        long now = System.currentTimeMillis();
        Integer bla = future.get(1000, TimeUnit.MILLISECONDS);
        long after = System.currentTimeMillis();
        long def = now - after;
        assert(1000<=def);
    }
}