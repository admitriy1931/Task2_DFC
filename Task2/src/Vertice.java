import java.util.Objects;

public class Vertice {
    public int numOfVertex;
    public  int number;
    public Vertice(int numOfVertex, int number){
        this.number = number;
        this.numOfVertex = numOfVertex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertice vertice = (Vertice) o;
        return numOfVertex == vertice.numOfVertex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numOfVertex, number);
    }

    @Override
    public String toString() {
        return "Vertice{" +
                "numOfVertex=" + numOfVertex +
                ", number=" + number +
                '}';
    }
}
