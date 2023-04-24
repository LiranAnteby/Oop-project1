import java.util.*;

public class Polynomial {

    private TreeMap<Integer, Monomial> monomials;

    public Polynomial(LinkedList<Monomial> list) {
        monomials = new TreeMap<>();
        for(Monomial m : list){
            if (monomials.containsKey(m.getExponent())){
                monomials.put(m.getExponent(), m.add(monomials.get(m.getExponent())));
            }
            else{
                monomials.put(m.getExponent(), m);
            }
        }
    }
    static Polynomial build(String input) {
        LinkedList<Monomial> list = new LinkedList<>();
        int exponent = 0;
        for (String word : input.split(" ")) {
            if (word.indexOf("/") == -1) {//if the number is not a fraction:
                Scalar coefficient = new IntegerScalar(Integer.parseInt(word));
                list.add(new Monomial(exponent, coefficient));
            } else {
                String[] fraction = word.split("/");
                String strNumerator = fraction[0];
                String strDenominator = fraction[1];
                Scalar coefficient = new RationalScalar(Integer.parseInt(strNumerator), Integer.parseInt(strDenominator));
                list.add(new Monomial(exponent, coefficient));
            }
            exponent++;
        }
        return new Polynomial(list);
    }
/*
    public Polynomial add(Polynomial p) {
        LinkedList<Monomial> list = new LinkedList<>() ;
        list.addAll(this.monomials.values());
        list.addAll(p.monomials.values());
        return new Polynomial(list);

    public Polynomial add(Polynomial p) {
        LinkedList<Monomial> list = new LinkedList<>() ;
        int lastCurrent = monomials.lastKey();
        int lastOther = p.monomials.lastKey();
        if (lastCurrent>=lastOther){int last = lastOther;}
        else{int last = lastCurrent;}
        for(int i = 0 ; i<=last ; i++) {
            Monomial tempP = new Monomial(i, p.monomials.get(i).getCoefficient());
            list.add(this.monomials.get(i).add(tempP));
        }
        return new Polynomial(list);
    }



 */

    public Polynomial add(Polynomial p) {
        LinkedList<Monomial> list = new LinkedList<>() ;
        for ( Integer key : p.monomials.keySet()){
            if (this.monomials.keySet() != )

        }
    }
    public Polynomial mul(Polynomial p){
        LinkedList<Monomial> list = new LinkedList<>() ;

    }

    public Scalar evaluate(Scalar s){
        Scalar scalar = new RationalScalar(0,1) ;
        for (Map.Entry<Integer, Monomial> entry : this.monomials.entrySet()) {
            Monomial mono = entry.getValue();
            Scalar temp = scalar.add(mono.evaluate(s));
            scalar = temp;
        }
        return scalar;
    }

    public Polynomial derivative(){
        LinkedList<Monomial> list = new LinkedList<>() ;
        for (Map.Entry<Integer, Monomial> entry : this.monomials.entrySet()) {
            Monomial mono = entry.getValue();
            list.add(mono.derivative());
        }
        return new Polynomial(list);
    }

    public boolean equals(Object o){
        if (! (o instanceof Polynomial)) return false;
        int lastCurrent = monomials.lastKey();
        int lastOther = ((Polynomial) o).monomials.lastKey();
        if (lastCurrent != lastOther) return false;
        for(int i = 0 ; i<=lastCurrent ; i++) {
            Monomial value = ((Polynomial) o).monomials.get(i);
            if (this.monomials.get(i) != ((Polynomial) o).monomials.get(i)){
                return false;
            }
        }
        return true;
    }

    public String toString(){
        String string = "";
        int last = monomials.lastKey();
        for(int i = 0 ; i<=last ; i++){
            Monomial value = monomials.get(i);
            string = string + value.toString();
        }
        return string;
    }

}

