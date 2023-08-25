public class Vetor {
    private String[] elementos;
    private int tamanho;

//    Metodo de Adicionar a capacidade de elementos
    public Vetor(int capacidade) { // Parametro que indica o tam do vetor
        this.elementos = new String[capacidade];
        this.tamanho = 0;
    }

//    Metodo de Adicionar Novos Elementos
    public void adicionar(String elemento) throws Exception{
        this.aumentaCapacidade();
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
        } else {
            throw new Exception("O vetor já está cheio, " + "não é possivel adicionar novos elementos");
        }
    }
    public int tamanho() {
        return this.tamanho;
    }

//    Metodo para mostrar ao usuário
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");

        for(int i = 0; i<this.tamanho-1; i++) {
            s.append(this.elementos[i]);
            s.append(", ");
        }

        if(this.tamanho > 0) {
            s.append(this.elementos[this.tamanho-1]);
        }

        s.append("]");

        return s.toString();
    }

//    Metodo de buscar
    public String buscar(int posicao) throws Exception {
        if (posicao >= 0 && posicao < tamanho) {
            return elementos[posicao];
        } else {
            throw new Exception("Posição Inválida");
        }
    }

//    metodo de buscar a posição
    public int busca1(String elemento) {
        for(int i = 0; i < tamanho; i++) {
            if(elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

//    Adicionar no inicio
    public boolean adicionarInicio(int posicao, String elemento) throws Exception {
        this.aumentaCapacidade();
        if (posicao >= 0 && posicao < tamanho) {
            for(int i = this.tamanho-1; i>posicao; i--) {
                this.elementos[i+1] = this.elementos[i];
            }
            this.elementos[posicao] = elemento;
            this.tamanho++;
        } else {
            throw new Exception("Posição Inválida");
        }
        return true;
    }

//    Método para aumentar a capacidade do vetor
    public void aumentaCapacidade() {
        if (this.tamanho == this.elementos.length) {
            String[] elementosNovos = new String[this.elementos.length * 2];
            for(int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }

//    Método Remover elementos
    public void remove(int posicao) throws Exception {
        if(posicao >= 0 && posicao < tamanho) {
            for(int i = posicao; i < this.tamanho; i--) {
                this.elementos[i] = this.elementos[i+1];
            }
            this.tamanho--;
        } else {
            throw new Exception("Posição Inválida");
        }
    }
 }
