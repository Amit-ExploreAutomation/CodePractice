package com.exploreAutomation;

class C{
  public int x = 1;
  public C(int i){
    x=x+1;
  }
}

class D extends C{
  public D(int i){
    super(i);
    x=x+1;
  }
}

public class TestFour {
  public static void main(String[] args){
    C ar[] = new C[2];
    ar[0] = new C(1);
    ar[1] = new D(2);

    System.out.println(ar[0].x + ar[1].x);
  }

}
