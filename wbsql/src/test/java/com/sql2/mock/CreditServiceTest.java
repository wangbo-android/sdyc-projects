package com.sql2.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CreditServiceTest {

    @Test
    public void getUserCredit() throws Exception {

        int userId = 10;
        CreditService creditService = mock(CreditService.class);
        when(creditService.getUserCredit(eq(userId))).thenReturn(1000);
        when(creditService.addCredit(eq(userId),anyInt())).thenReturn(true);

        int ret = creditService.getUserCredit(10);

        creditService.addCredit(userId,ret + 10);

        assertEquals(1000,ret);

        verify(creditService,times(1)).
                getUserCredit(eq(userId));

        InOrder inOrder = inOrder(creditService);
        inOrder.verify(creditService).getUserCredit(userId);
        inOrder.verify(creditService).addCredit(userId,ret + 10);
    }
}