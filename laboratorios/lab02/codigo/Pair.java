
import java.util.Objects;

/**
 * Contenedor para dos objetos de cualquier tipo. Basada en la implementacion de
 * Android.
 *
 * @author Mateo Agudelo
 */
public class Pair<F, S> {
    public final F key;
    public final S value;

    /**
     * Constructor de pares.
     *
     * @param key
     *            primer objeto del par.
     * @param value
     *            segundo objeto del par.
     */
    public Pair(F key, S value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Verifica si dos pares son equivalentes. Se comparan los objetos
     * correspondientes uno a uno: key con key, value con value.
     *
     * @param o
     *            el par con el cual este par (this) sera verificado
     * @return true (verdadero) si los objetos en cada 'componente' son
     *         equivalentes entre si.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair<?, ?> p = (Pair<?, ?>) o;
        return Objects.equals(p.key, key) && Objects.equals(p.value, value);
    }

    /**
     * Computa el hash del objeto en base al hash de cada objeto que contiene.
     *
     * @return hash del par.
     */
    @Override
    public int hashCode() {
        int hashFirst = (key == null) ? 0 : key.hashCode();
        int hashSecond = (value == null) ? 0 : value.hashCode();
        return hashFirst ^ hashSecond;
    }

    @Override
    public String toString() {
        return "Pair{" + String.valueOf(key) + " " + String.valueOf(value) + "}";
    }

    /**
     * Metodo utilitario para crear un par debidamente tipado. Se recomienda
     * usar este en vez del constructor.
     *
     * @param a primer objeto del par.
     * @param b segundo objeto del par.
     * @return un par que contiene a 'a' y a 'b', y fue debidamente creado en
     *         base al tipo de objeto que estos son.
     */
    public static <A, B> Pair <A, B> makePair(A a, B b) {
        return new Pair<A, B>(a, b);
    }






}