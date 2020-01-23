package com.example.bottomnavigation;

import java.text.DecimalFormat;

public class covertformula {


    public  static double celsius2farenheit(double c){
        return  Double.parseDouble(currency1.format(32+c*9/5));
    }
    public static double farenheit2celsius(double f){
        return  Double.parseDouble(currency1.format((f-32)*5/9));
    }
    public static double currency(double cu){
        return  Double.parseDouble(currency1.format(cu*85));
    }
    public static double ccurrency(double ccu){
        return  Double.parseDouble(currency1.format( ccu/85));
    }
   public static DecimalFormat currency1 = new DecimalFormat("###########,#############.#####");



    public static double times(double t)
    {
        return Double.parseDouble(currency1.format(t*60));
    }
    public static double timem(double j)
    {
        return Double.parseDouble(currency1.format(j*60));
    }
    public static double timeh(double i)
    {
        return Double.parseDouble(currency1.format(i*24));
    }


    public static double times1(double t)
    {
        return Double.parseDouble(currency1.format(t/60));
    }
    public static double timem1(double t)
    {
        return Double.parseDouble(currency1.format(t/60));
    }
    public static double timeh1(double t)
    {
        return Double.parseDouble(currency1.format(t/24));
    }
    public static double tims(double t)
    {
        return Double.parseDouble(currency1.format(t*86400));
    }
    public static double tims1(double t)
    {
        return Double.parseDouble(currency1.format(t/86400));
    }
    public static double timm(double t)
    {
        return Double.parseDouble(currency1.format(t*1440));
    }
    public static double timm1(double t)
    {
        return Double.parseDouble(currency1.format(t/1440));
    }
    public static double timh(double t)
    {
        return Double.parseDouble(currency1.format(t*3600));
    }
    public static double timh1(double t)
    {
        return Double.parseDouble(currency1.format(t/3600));
    }
    public static double lengthc(double a)
    {
        return Double.parseDouble(currency1.format(a*100));
    }
    public static double lengthc1(double a)
    {
        return Double.parseDouble(currency1.format(a/100));
    }
    public static double lengthm(double a)
    {
        return Double.parseDouble(currency1.format(a*1000));
    }
    public static double lengthm1(double a)
    {
        return Double.parseDouble(currency1.format(a/1000));
    }
    public static double lengthk(double a)
    {
        return Double.parseDouble(currency1.format(a*1.60934));
    }
    public static double lengthk1(double a)
    {
        return Double.parseDouble(currency1.format(a/1.60934));
    }
    public static double lengthC(double a)
    {
        return Double.parseDouble(currency1.format(a*160934));
    }
    public static double lengthC1(double a)
    {
        return Double.parseDouble(currency1.format(a/160934));
    }
    public static double lengthM(double a)
    {
        return Double.parseDouble(currency1.format(a*1609.34));
    }
    public static double lengthM1(double a)
    {
        return Double.parseDouble(currency1.format(a/1609.34));
    }
    public static double lengthK(double a)
    {
        return Double.parseDouble(currency1.format(a*100000));
    }
    public static double lengthK1(double a)
    {
        return Double.parseDouble(currency1.format(a/100000));
    }


    public static double aream(double a)
    {
        return Double.parseDouble(currency1.format(a*1000000));
    }
    public static double aream1(double a)
    {
        return Double.parseDouble(currency1.format(a/1000000));
    }
    public static double areak(double a)
    {
        return Double.parseDouble(currency1.format(a*2.58999));
    }
    public static double areak1(double a)
    {
        return Double.parseDouble(currency1.format(a/2.58999));
    }
    public static double areaM(double a)
    {
        return Double.parseDouble(currency1.format(a*2590000));
    }
    public static double areaM1(double a)
    {
        return Double.parseDouble(currency1.format(a/2590000));
    }
    public static double weightg(double a)
    {
        return Double.parseDouble(currency1.format(a*1000));
    }
    public static double weightg1(double a)
    {
        return Double.parseDouble(currency1.format(a/1000));
    }
    public static double weightkg(double a)
    {
        return Double.parseDouble(currency1.format(a*2.20462));
    }
    public static double weightkg1(double a)
    {
        return Double.parseDouble(currency1.format(a/2.20462));
    }
    public static double weightp(double a)
    {
        return Double.parseDouble(currency1.format(a*453.592));
    }
    public static double weightp1(double a)
    {
        return Double.parseDouble(currency1.format(a/453.592));
    }




}
