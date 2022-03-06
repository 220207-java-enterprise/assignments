package com.revature.recurringWordII;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class SolutionTest extends TestCase {
    Solution sut = new Solution();

    @Test
    public void testRecurringWordII1() {
        String str = "We tell people sometimes: we're like drug dealers, come into town and get everybody absolutely addicted to painting. It doesn't take much to get you addicted. If we're gonna walk though the woods, we need a little path. We artists are a different breed of people. We're a happy bunch. All you have to learn here is how to have fun. It's a very cold picture, I may have to go get my coat. It’s about to freeze me to death.";

        Assert.assertEquals("to", sut.recurringWordII(str));
    }

    @Test
    public void testRecurringWordII2() {
        String str = "Isn't it fantastic that you can change your mind and create all these happy things? Everyone is going to see things differently - and that's the way it should be. I will take some magic white, and a little bit of Vandyke brown and a little touch of yellow.";

        Assert.assertEquals("and", sut.recurringWordII(str));
    }

    @Test
    public void testRecurringWordII3() {
        String str = "Isn't that fantastic that you can create an almighty tree that fast? Let's have a nice tree right here. Work on one thing at a time. Don't get carried away - we have plenty of time.";

        Assert.assertEquals("that", sut.recurringWordII(str));
    }

    @Test
    public void testRecurringWordII4() {
        String str = "Put your feelings into it, your heart, it's your world. It is a lot of fun. The more we do this - the more it will do good things to our heart. Nice little clouds playing around in the sky. At home you have unlimited time. Anything you want to do you can do here.";

        Assert.assertEquals("do", sut.recurringWordII(str));
    }

    @Test
    public void testRecurringWordII5() {
        String str = "Steve wants reflections, so let's give him reflections. We need a shadow side and a highlight side. Imagination is the key to painting. Use what you see, don't plan it. What the devil. So often we avoid running water, and running water is a lot of fun.";

        Assert.assertEquals("a", sut.recurringWordII(str));
    }
}