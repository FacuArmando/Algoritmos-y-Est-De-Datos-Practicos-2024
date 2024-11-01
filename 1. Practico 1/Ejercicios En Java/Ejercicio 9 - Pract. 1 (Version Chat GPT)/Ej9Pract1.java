// Clase base para todas las fórmulas lógicas
abstract class Formula {
    // Método abstracto para evaluar la fórmula (dependiendo de su implementación específica)
    public abstract boolean evaluate();

    // Método para obtener una representación en cadena de la fórmula
    @Override
    public abstract String toString();
}

// Clase que representa una variable proposicional (como 'p', 'q', etc.)
class Variable extends Formula {
    private String name;
    private boolean value; // Valor de la variable

    public Variable(String name, boolean value) {
        this.name = name;
        this.value = value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public boolean evaluate() {
        return value;
    }

    @Override
    public String toString() {
        return name;
    }
}

// Clase abstracta para fórmulas con un solo operando (unarios)
abstract class UnaryFormula extends Formula {
    protected Formula operand;

    public UnaryFormula(Formula operand) {
        this.operand = operand;
    }
}

// Clase para la negación (¬)
class Negation extends UnaryFormula {
    public Negation(Formula operand) {
        super(operand);
    }

    @Override
    public boolean evaluate() {
        return !operand.evaluate();
    }

    @Override
    public String toString() {
        return "¬(" + operand.toString() + ")";
    }
}

// Clase abstracta para fórmulas con dos operandos (binarios)
abstract class BinaryFormula extends Formula {
    protected Formula left;
    protected Formula right;

    public BinaryFormula(Formula left, Formula right) {
        this.left = left;
        this.right = right;
    }
}

// Clase para la conjunción (∧)
class Conjunction extends BinaryFormula {
    public Conjunction(Formula left, Formula right) {
        super(left, right);
    }

    @Override
    public boolean evaluate() {
        return left.evaluate() && right.evaluate();
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " ∧ " + right.toString() + ")";
    }
}

// Clase para la disyunción (∨)
class Disjunction extends BinaryFormula {
    public Disjunction(Formula left, Formula right) {
        super(left, right);
    }

    @Override
    public boolean evaluate() {
        return left.evaluate() || right.evaluate();
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " ∨ " + right.toString() + ")";
    }
}

// Clase para la implicación (→)
class Implication extends BinaryFormula {
    public Implication(Formula left, Formula right) {
        super(left, right);
    }

    @Override
    public boolean evaluate() {
        return !left.evaluate() || right.evaluate();
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " → " + right.toString() + ")";
    }
}

// Clase para la equivalencia (↔)
class Equivalence extends BinaryFormula {
    public Equivalence(Formula left, Formula right) {
        super(left, right);
    }

    @Override
    public boolean evaluate() {
        return left.evaluate() == right.evaluate();
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " ↔ " + right.toString() + ")";
    }
}