package ui;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ConjuntoImpl<T> implements Conjunto<T>, Cloneable {

  private Set<T> elementos;

  public ConjuntoImpl() {
    elementos = new HashSet<>();
  }

  public ConjuntoImpl(Collection<T> elementos) {
    if (elementos == null) {
      throw new NullPointerException("La colección no debe ser nula");
    }

    this.elementos = new HashSet<>();
    for (T item : elementos) {
      this.elementos.add(item);
    }
  }

  public ConjuntoImpl(T... elementos) {
    if (elementos == null) {
      throw new NullPointerException("La colección no debe ser nula");
    }

    this.elementos = new HashSet<>();
    for (T item : elementos) {
      this.elementos.add(item);
    }
  }

  @Override
  public boolean contains(T elemento) {
    return this.elementos.contains(elemento);
  }

  @Override
  public int size() {
    return this.elementos.size();
  }

  @Override
  public boolean isEmpty() {
    return this.elementos.isEmpty();
  }

  @Override
  public boolean equals(Object obj) {
    boolean equals = false;

    if (obj == this) {
      equals = true;
    } else if (obj instanceof Conjunto) {
      Conjunto<?> e = (Conjunto<?>) obj;
      if (e.size() == this.size()) {
        for (Object item : this.getElementos()) {
          equals = false;
          for (Object item2 : e.getElementos()) {
            if (item.equals(item2)) {
              equals = true;
            }
          }
          if (!equals) {
            break;
          }
        }
      }
    }
    return equals;
  }

  @Override
  public String toString() {
    String elementos = this.elementos.toString().replaceAll("\\[", "{");
    elementos = elementos.replaceAll("]", "}");
    return elementos;
  }

  @Override
  public ConjuntoImpl<T> union(Conjunto<T> conjunto) {
    Set<T> unionConjuntos = new HashSet<>();
    if (conjunto != null) {
      unionConjuntos.addAll(conjunto.getElementos());
    }
    unionConjuntos.addAll(this.elementos);

    return new ConjuntoImpl<>(unionConjuntos);
  }

  @Override
  public ConjuntoImpl<T> interseccion(Conjunto<T> conjunto) {
    Set<T> interseccionConjuntos = new HashSet<>();

    for (T item : conjunto.getElementos()) {
      if (this.elementos.contains(item)) {
        interseccionConjuntos.add(item);
      }
    }

    return new ConjuntoImpl<>(interseccionConjuntos);
  }

  @Override
  public ConjuntoImpl<T> diferencia(Conjunto<T> conjunto) {
    Set<T> diferenciaConjuntos = new HashSet<>(this.elementos);

    diferenciaConjuntos.removeAll(conjunto.getElementos());

    return new ConjuntoImpl<>(diferenciaConjuntos);
  }

  @Override
  public boolean subConjunto(Conjunto<T> conjunto) {
    return conjunto.getElementos().containsAll(this.elementos);
  }

  @Override
  public boolean subConjuntoPropio(Conjunto<T> conjunto) {
    return (conjunto.size() < this.size() && subConjunto(conjunto));
  }

  @Override
  public ConjuntoImpl<T> complemento(Conjunto<T> conjunto) {
    return (ConjuntoImpl<T>) conjunto.diferencia(this);
  }

  public ConjuntoImpl<T> deepClone() {
    Cloner cloner = new Cloner();
    return cloner.deepClone(this);
  }

  @Override
  public Object clone() {
    ConjuntoImpl<T> conjunto;
    try {
      conjunto = (ConjuntoImpl<T>) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException("Clone not supported");
    }
    return conjunto;
  }

  public Set<T> getElementos() {
    return elementos;
  }

  public void setElementos(Set<T> elementos) {
    this.elementos = elementos;
  }
  
}