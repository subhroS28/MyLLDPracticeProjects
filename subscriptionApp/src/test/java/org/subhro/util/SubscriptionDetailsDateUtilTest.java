package org.subhro.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SubscriptionDetailsDateUtilTest {

    @InjectMocks
    private SubscriptionDetailsDateUtil subscriptionDetailsDateUtil;

    @Test
    public void getSimpleDateFormatWithIncorrectDate(){
        Date simpleDateFormat = subscriptionDetailsDateUtil.getSimpleDateFormat("07-19-2022");

        assertNull(simpleDateFormat);
    }

    @Test
    public void getSimpleDateFormatWithCorrectDate(){
        Date simpleDateFormat = subscriptionDetailsDateUtil.getSimpleDateFormat("20-02-2022");

        assertNotNull(simpleDateFormat);
    }

    @Test
    public void getRenewalDate1Test(){
        Date simpleDateFormat = subscriptionDetailsDateUtil.getSimpleDateFormat("20-02-2022");
        String renewalDate = subscriptionDetailsDateUtil.getRenewalDate(simpleDateFormat, 3);

        assertNotNull(renewalDate);
        assertEquals(renewalDate, "10-05-2022");
    }

    @Test
    public void getRenewalDate2Test(){
        Date simpleDateFormat = subscriptionDetailsDateUtil.getSimpleDateFormat("10-02-2022");
        String renewalDate = subscriptionDetailsDateUtil.getRenewalDate(simpleDateFormat, 5);

        assertNotNull(renewalDate);
        assertEquals(renewalDate, "30-06-2022");
    }
}
