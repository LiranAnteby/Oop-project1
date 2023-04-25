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
        Polynomial poly = this;
        Set<Integer> pSet = p.monomials.keySet();
        for ( Integer key : pSet){
            poly.monomials.put(key,poly.monomials.get(key).add(p.monomials.get(key)));
        }
        return poly;
    }
    public Polynomial mul(Polynomial p){
        Polynomial poly = this;
        Set<Integer> pSet = p.monomials.keySet();
        for ( Integer key : pSet){
            poly.monomials.put(key,poly.monomials.get(key).mul(p.monomials.get(key)));
        }
        return poly;
    }

    public Scalar evaluate(Scalar s){
        Scalar scalar = new RationalScalar(0,1) ;
        Set<Integer> KeySet = this.monomials.keySet();
        for ( Integer key : KeySet){
            Scalar temp = this.monomials.get(key).evaluate(s);
            scalar = temp;
        }
        return scalar;
    }

    public Polynomial derivative(){
         Polynomial poly = this;
         Set<Integer> pSet = this.monomials.keySet();
         for ( Integer key : pSet){
             poly.monomials.put(key,poly.monomials.get(key).derivative());
         }
        return poly;
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
    Set<Integer> keySet = this.monomials.keySet();
    for ( Integer key : keySet){;
        Monomial value = monomials.get(key);
        //System.out.println(value.toString());
        if (value.toString() != ""){
            if(value.toString().charAt(0) == '-'){
                string = string + value.toString();
            }
            else{
                if (string != ""){
                    string =    string + "+"+value.toString() ;

                }
                else{
                    string = string + value.toString();
                }
            }
        }
    }
    return string;
}


}

