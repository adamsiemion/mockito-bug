package com.siemion.mockito;

import com.siemion.mockito.pkg.Child;
import org.junit.Test;
import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHRepository;

import static org.mockito.Mockito.mock;

public class AppTest {
    @Test
    public void test_GHIssue() {
        mock(GHIssue.class);
    }

    @Test
    public void test_GHRepository() {
        mock(GHRepository.class);
    }
}
