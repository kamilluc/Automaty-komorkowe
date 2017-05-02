package com.company;

public class Main {

    public static void main(String[] args) {
	    CA1D ex1=new CA1D(15,31);
	    //default rule 30
	    ex1.compute();

        boolean[] r60={false,false,true,true,true,true,false,false};
	    ex1.setRule(r60);
	    ex1.compute();


        boolean[] r90={false,true,false,true,true,false,true,false};
        ex1.setRule(r90);
        ex1.compute();

        boolean[] r120={false,true,true,true,true,false,false,false};
        ex1.setRule(r120);
        ex1.compute();
    }
}
