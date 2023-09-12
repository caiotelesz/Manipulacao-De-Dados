public class VetorObjeto {
    private Object[] elementos;
    private int tamanho;
    public VetorObjeto(int capacidade) {
        this.elementos = new Object[capacidade];
        this.tamanho = 0;
    }

//    Adicionar elementos
    public void adiciona(Object elemento) throws Exception {
        this.aumentaCapacidade();
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
        } else {
            throw new Exception("O vetor já está cheio");
        }
    }

//    Tamanho
    public int tamanho() {
        return this.tamanho;
    }

//   toString
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");

        for(int i = 0; i<this.tamanho-1; i++) {
            s.append(this.elementos[i]);
            s.append(", ");
        }

        if (this.tamanho > 0) {
            s.append(this.elementos[this.tamanho-1]);
        }

        s.append("]");

        return s.toString();
    }

//    Buscar pela posição e entregará o nome
    public Object busca (int posicao) throws Exception {
        if (posicao >= 0 && posicao < tamanho) {
            return elementos[posicao];
        } else {
            throw new Exception("Posição Inválida");
        }
    }

//   Buscar pelo nome e entregará a posição
    public int buscaPos(Object elemento) {
        for(int i = 0; i < tamanho; i++) {
            if (elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

//    Adicionar no inicio do vetor
    public boolean adicionarInicio(int posicao, Object elementos) throws Exception {
        this.aumentaCapacidade();
        if (posicao >= 0 && posicao < tamanho) {
            for (int i = this.tamanho-1; i>posicao; i--) {
                this.elementos[i+1] = this.elementos[i];
            }
            this.elementos[posicao] = elementos;
            this.tamanho++;
        }

        else {
            throw new Exception("Posição Inválida");
        }

        return true;
    }

//    Aumentar a capacidade do vetor, quando chegar na capacidade colocada, automaticamente se mutiplicará
    private void aumentaCapacidade() {
        if(this.tamanho == this.elementos.length) {
            Object[] elementosNovos = new Object[this.elementos.length * 2];
            for (int i = 0; i<this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }
    
//    Remover elementos
    public void remove(int posicao) throws Exception {
        if(posicao >= 0 && posicao < tamanho) {
            for (int i = posicao; i<this.tamanho-1; i++) {
                this.elementos[i] = this.elementos[i+1];
            }
            this.tamanho--;
        }
        else {
            throw new Exception("Posição Inválida");
        }
    }
}
