package com.siemion.mockito;

import com.siemion.mockito.pkg.Child;
import org.junit.Test;
import org.kohsuke.github.GHIssue;

import static org.mockito.Mockito.mock;

public class AppTest {
    @Test
    public void test() {
        mock(GHIssue.class);
    }
}
