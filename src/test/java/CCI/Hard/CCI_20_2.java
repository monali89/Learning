package Hard;

public class CCI_20_2 {

    public static void main(String[] args) {

        int[] deck = new int[52];
        shuffleArray_ml(deck);
        System.out.println("Temp " + (long)Math.random()*100);

    }

    public static void shuffleArray_ml(int[] deck) {

        boolean[] selected = new boolean[52];

        for(int i=0; i<deck.length; i++) deck[i] = i+1;
        for(int i=0; i<selected.length; i++) selected[i] = false;

        for(int i=0; i<deck.length; i++){
            double ran = Math.random();
            int index = ((int) ran * 51);
            System.out.print(ran*51 + " " + index + " ");
            if(selected[index] == false){
                System.out.print(deck[index] + " ");
                selected[index] = true;
            }
            System.out.println();
        }
    }

    public static void shuffleArray(int[] cards) {
        int temp, index;
        for (int i = 0; i < cards.length; i++){
            index = (int) (Math.random() * (cards.length - i)) + i;
            temp = cards[i];
            cards[i] = cards[index];
            cards[index] = temp;
            }
        for (int i = 0; i < cards.length; i++){
            System.out.println(cards[i]);
        }
    }

}


/*
* Write a method to shuffle a deck of cards. It must be a perfect shuffle -
* in other words, each 52! permutations of the deck has to be equally likely.
* Assume that you are given a random number generator which is perfect.
* */