package org.algebra;

public class FiniteFieldElement {
    private final int p;
    private final int a, b; // element represented as a + bx
    private final int alpha;

    public FiniteFieldElement(int p, int a, int b, int alpha) {
        this.p = p;
        this.a = (a % p + p) % p;
        this.b = (b % p + p) % p;
        this.alpha = alpha;
    }

    public FiniteFieldElement add(FiniteFieldElement el) {
        return new FiniteFieldElement(p, (this.a + el.a) % p, (this.b + el.b) % p, alpha);
    }

    public FiniteFieldElement multiply(FiniteFieldElement el) {
        int newA = (this.a * el.a + this.b * el.b * alpha) % p;
        int newB = (this.a * el.b + this.b * el.a) % p;
        return new FiniteFieldElement(p, newA, newB, alpha);
    }

    public int getAlpha() {
        return this.alpha;
    }

    @Override
    public String toString() {
        return a + " + " + b + "x";
    }
}
