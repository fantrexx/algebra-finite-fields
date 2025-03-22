package org.algebra;

import java.util.ArrayList;
import java.util.List;

public class GFp2Tables {
    private final int p;
    private final List<FiniteFieldElement> elements;
    private final int alpha;

    public GFp2Tables(int p) {
        this.p = p;
        this.alpha = findNonSquare(p);
        this.elements = generateElements();
    }

    /**
     *  Generates all (a,b) pairs, where a,b belongs to {0, 1, ..., p-1}
     * @return list of p^2 elements
     */
    private List<FiniteFieldElement> generateElements() {
        List<FiniteFieldElement> elems = new ArrayList<>();

        for (int a = 0; a < p; a++) {
            for (int b = 0; b < p; b++) {
                elems.add(new FiniteFieldElement(p, a, b, alpha));
            }
        }
        return elems;
    }

    public void printAdditionTable() {
        System.out.println("\nAddition Table GF(" + p + "^2):");
        for (FiniteFieldElement e1 : elements) {
            for (FiniteFieldElement e2 : elements) {
                System.out.print(e1.add(e2) + "\t");
            }
            System.out.println();
        }
    }

    public void printMultiplicationTable() {
        System.out.println("\nMultiplication Table GF(" + p + "^2):");
        for (FiniteFieldElement e1 : elements) {
            for (FiniteFieldElement e2: elements) {
                System.out.print(e1.multiply(e2) + "\t");
            }
            System.out.println();
        }
    }

    private int findNonSquare(int p) {
        for (int i = 2; i < p; i++) {
            boolean isSquare = false;
            for (int x = 0; x < p; x++) {
                if ((x * x) % p == i) {
                    isSquare = true;
                    break;
                }
            }
            if (!isSquare) {
                return i;
            }
        }
        return -1;
    }
}
