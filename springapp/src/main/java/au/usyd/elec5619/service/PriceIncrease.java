package au.usyd.elec5619.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PriceIncrease {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    private int percentagechentest;

    public void setPercentagechentest(int i) {
    	percentagechentest = i;
        logger.info("Percentage set to " + i);
    }

    public int getPercentagechentest() {
        return percentagechentest;
    }

}