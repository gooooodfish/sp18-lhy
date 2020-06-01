public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque chars = new ArrayDeque();
        for(int i = 0; i < word.length(); i++){
            Character a = word.charAt(i);
            chars.addLast(a);
        }
        return chars;
    }
}

