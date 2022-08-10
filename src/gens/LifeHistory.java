package gens;

import auxi.*;

public class LifeHistory implements ILifeHistory {

    private Node<Gen> history;

    public LifeHistory(IGen gen) {
        history = new Node<Gen>((Gen)gen, null);
    }

    public void evolve() {
        history = new Node<Gen>(history.element.next(), history);
    }

    public void undo() {
        history = history.next;
    }

    public Gen current() {
        return history.element;
    }

    public Gen former() {
        return history.next.element;
        
    }

    public int generations() {
        int counter = 0;
        Node<Gen> aux = history;
        while (aux != null) {
            counter++;
            aux = aux.next;
        }
        return counter;
    }

    public boolean endOfGame() {
        if(generations() > 2){
            return (current().equals(former()) || current().equals(history.next.next.element));
        }
        else return false;
    }
}
