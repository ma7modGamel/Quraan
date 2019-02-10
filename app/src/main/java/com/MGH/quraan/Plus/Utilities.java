package com.MGH.quraan.Plus;

public class Utilities {
    public int getProgressPercentage(long paramLong1, long paramLong2) {
        paramLong1 = (paramLong1 / 1000L);
        paramLong2 = (paramLong2 / 1000L);
        return Double.valueOf(paramLong1 / paramLong2 * 100.0D).intValue();
    }

    public String milliSecondsToTimer(long paramLong) {
        String str1 = "";
        int i = (int) (paramLong / 3600000L);
        int j = (int) (paramLong % 3600000L) / 60000;
        int k = (int) (paramLong % 3600000L % 60000L / 1000L);
        if (i > 0) {
            str1 = i + ":";
        }
        if (k < 10) {
        }
        for (String str2 = "0" + k; ; str2 = "" + k) {
            return str1 + j + ":" + str2;
        }
    }

    public int progressToTimer(int paramInt1, int paramInt2) {
        paramInt2 /= 1000;
        return (int) (paramInt1 / 100.0D * paramInt2) * 1000;
    }
}

