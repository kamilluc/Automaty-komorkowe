package com.company;

public class CA1D {
    private int height,width;
    private boolean[] line1, line2;
    private boolean[] rule={false,false,false,true,true,true,true,false};

    public CA1D(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public void setRule(boolean[] yourRule){
        for (int i=0;i<8;i++)
            rule[i]=yourRule[i];
        System.out.println();
        System.out.println();
    }

    private void showLine(boolean[] line){
        System.out.println();
        for(int i=0;i<width;i++) {
            if (line[i])
                System.out.print("#");
            else
                System.out.print(" ");
        }
    }

    private void fillFirtsLine(){
        line1=new boolean[width];
        line2=new boolean[width];
        for(int i=0;i<width;i++){
            if(i==width/2-1)
                line1[i]=true;
            else
                line1[i]=false;
        }
    }

    private void swapLines(){
        for(int i=0;i<width;i++) {
            line1[i] = line2[i];
            line2[i] = false;
        }
    }

    public void compute(){
        fillFirtsLine();
        showLine(line1);

        for(int j=0;j<height;j++){
            for(int i=0;i<width;i++){
                if(i==0){
                    if (line1[i] && line1[i + 1]) line2[i] = true;
                    if (line1[i] && !line1[i + 1]) line2[i] = false;
                    if (!line1[i] && line1[i + 1]) line2[i] = true;
                    if (!line1[i] && !line1[i + 1]) line2[i] = false;
                }
                else if(i==width-1){
                    if (line1[i - 1] && line1[i]) line2[i] = true;
                    if (line1[i - 1] && !line1[i]) line2[i] = true;
                    if (!line1[i - 1] && line1[i]) line2[i] = false;
                    if (!line1[i - 1] && !line1[i]) line2[i] = false;
                }
                else {
                    if (line1[i - 1] && line1[i] && line1[i + 1]) line2[i] = rule[0];
                    if (line1[i - 1] && line1[i] && !line1[i + 1]) line2[i] = rule[1];
                    if (line1[i - 1] && !line1[i] && line1[i + 1]) line2[i] = rule[2];
                    if (line1[i - 1] && !line1[i] && !line1[i + 1]) line2[i] = rule[3];
                    if (!line1[i - 1] && line1[i] && line1[i + 1]) line2[i] = rule[4];
                    if (!line1[i - 1] && line1[i] && !line1[i + 1]) line2[i] = rule[5];
                    if (!line1[i - 1] && !line1[i] && line1[i + 1]) line2[i] = rule[6];
                    if (!line1[i - 1] && !line1[i] && !line1[i + 1]) line2[i] = rule[7];
                }
            }
            swapLines();
            showLine(line1);
        }
    }
}