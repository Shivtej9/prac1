import java.io.*;

class Prac {
    public static void main(String args[]) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //? Requires when we read external file
        int i;
        String a[][] = { { "", "START", "101", "" },
                { "", "MOVER", "BREG", "ONE" },
                { "AGAIN", "MULT", "BREG", "TERM" },
                { "", "MOVER", "CREG", "TERM" },
                { "", "ADD", "CREG", "N" },
                { "", "MOVEM", "CREG", "TERM" },
                { "N", "DS", "2", "" },
                { "RESULT", "DS", "2", "" },
                { "ONE", "DC", "1", "" },
                { "TERM", "DS", "1", "" },
                { "", "END", "", "" } };//? Created a input sample
        int lc = Integer.parseInt(a[0][2]); //? lc-location counter || Fetching Location counter Here || Parse int converts string into integer value
        String st[][] = new String[5][2];   //? st- Symbol Table
        int cnt = 0,l;//? Two variables are defined here

        for (i = 1; i < 11; i++) {
            if (a[i][0] != "") {
                st[cnt][0] = a[i][0];
                st[cnt][1] = Integer.toString(lc);
                cnt++;
                if (a[i][1] == "DS") {
                    int d = Integer.parseInt(a[i][2]);
                    lc = lc + d;
                } else {
                    lc++;
                }
            } else {
                lc++;
            }
        }
        System.out.print("***SYMBOL TABLE****\n");
        System.out.println("_____________________");
        for (i = 0; i < 5; i++) {
            for (cnt = 0; cnt < 2; cnt++) {
                System.out.print(st[i][cnt] + "\t");
            }
            System.out.println();

        }
        String inst[] = { "STOP", "ADD", "SUB", "MULT", "MOVER", "MOVEM", "COMP", "BC", "DIV", "READ", "PRINT" };
        String reg[] = { "NULL", "AREG", "BREG", "CREG", "DREG" };
        int op[][] = new int[12][3];
        int j, k, p = 1, cnt1 = 0;
        for (i = 1; i < 11; i++) {
            for (j = 0; j < 11; j++) {
                if (a[i][1].equalsIgnoreCase(inst[j])) {
                    op[cnt1][0] = j;
                } else if (a[i][1].equalsIgnoreCase("DS")) {
                    p = Integer.parseInt(a[i][2]);
                } else if (a[i][1].equalsIgnoreCase("DC")) {
                    op[cnt1][2] = Integer.parseInt(a[i][2]);
                }
            }
            for (k = 0; k < 5; k++) {
                if (a[i][2].equalsIgnoreCase(reg[k])) {
                    op[cnt1][1] = k;
                }
            }
            for (l = 0; l < 5; l++) {
                if (a[i][3].equalsIgnoreCase(st[l][0])) {
                    int mn = Integer.parseInt(st[l][1]);
                    op[cnt1][2] = mn;
                    // System.out.println(st[l][0]);
                }
            }
            cnt1 = cnt1 + p;
        }
        System.out.println("\n *****OUTPUT*****\n");
        System.out.println("**********MOT TABLE**********");
        int dlc = Integer.parseInt(a[0][2]);
        for (i = 0; i < 12; i++) {
            System.out.print(dlc++ + "\t");
            for (j = 0; j < 3; j++) {
                System.out.print(" " + op[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("");

    }
} 